package com.github.db;

import com.github.common.data.PropertiesReader;
import com.github.logging.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;

public class DataBaseUtils {

    private static Connection connection; // объект Connection

    private DataBaseUtils() {  //что-бы не создавать объект статического класса
    }

    private static void initConnection() {

        final PropertiesReader propertiesReader = new PropertiesReader();

        final String userName = propertiesReader.getProperty("sql.server.username");
        final String password = propertiesReader.getProperty("sql.server.password");
        final String connectionUrl = String.format(propertiesReader.getProperty("sql.server.connection.string"),
                userName, password);

        try {
            Logger.out.debug("Trying init connection to the SQL Server");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // зарегали jdbc-driver|динамическая загрузка (переносимость)
            connection = DriverManager.getConnection(connectionUrl);
            Logger.out.debug("Connection has successfully established!");
        } catch (final SQLException | ClassNotFoundException e) {
            throw new IllegalStateException("Unable to connect to the sever!", e);
        }
    }

    public static void executeQuery(final String query) {  // выполнить запрос
        try {
            final Statement statement = tryToConnect();
//            final Statement statement = connection.createStatement();  //объект Statement (позволяет выполнить запрос к БД)
            Logger.out.debug(String.format("Connection is established. Executing following query [%s]!", query));
            statement.executeUpdate(query);  // возврат true or false
//            final ResultSet resultSet = statement.executeQuery(query); //объект ResultSet (данные которые пришли с таблицы) -получить
            Logger.out.debug(String.format("Following query [%s] is successfully executed!", query));
        } catch (final SQLException e) {
            throw new IllegalStateException("Unable to execute query!", e);
        }
    }

//    public static <T> List<T> executeRetrieveAsListObjects(final String query, final Class<T> returnType) { // Class<T> returnType -любой тип данных который object
//        final List<Map<String, String>> results = executeRetrieve(query); //Вычитали все данные из таблицы           Лист -->и  распарсить в список моих объектов
//        for (final Map<String, String> columnData : results) {  // columnData -key(name DB)
//            final List<Field> fields = retrieveAllFields(returnType); // получил список полей
//            for (final Field field : fields) {
//                final String columnName = field.getAnnotation(ColumnName.class).name();
//                columnData.forEach((key, value) -> {
//                    if (StringUtils.equals(key, columnName)) {
//                        field.setAccessible(true);  // разрешить запись в приватное поле (Students)
//                        try {
//                            field.set(returnType, value);
//                        } catch (final IllegalAccessException e) {
//                            throw new IllegalStateException("Unable to set value into the field!", e);
//                        }
//                    }
//                });
//            }
//        }
//    }

    public static <T> List<T> executeRetrieveAsListObjects(final String query, final Class<T> returnType) {//

        final List<Map<String, String>> results = executeRetrieve(query); //Вычитали все данные из таблицы

        final List<T> records = new ArrayList<>(); //Создали коллекцию которая будет хранить считаные данные из базы данных в виде листа обджектов

        try {
            for (final Map<String, String> row : results) { //Идем в цикле по строкам, считаным из базы данных

                final T instance = returnType.getDeclaredConstructor().newInstance(); //Для каждой строки из базы нам надо создать новый обджект.
                //getDeclaredConstructor() - получаем дефолтный конструктор из обджекта
                //newInstance() - создаем новый обджект. Равносильно A a = new A(); ,
                // где new A(); - это newInstance() только через рефлексию

                final List<Field> fields = Arrays.asList(instance.getClass().getDeclaredFields()); //Получаем список полей нашего обджекта,
                // для того чтоб сравнить каждое из них и записать туда значение
                fields.forEach(field -> { //Итерируемся по списку полей
                    final String objectFieldName = field.getAnnotation(ColumnName.class).name(); //Если в текущей строке, которую мы вычитали из базы данных
                    // и положили в коллецию *results* есть поле
                    // (ключ) с именем нашего поля (полученого с аннотации  ColumnName.class.name())
                    if (row.containsKey(objectFieldName)) {

                        field.setAccessible(true); // Тогда разрешаем запись в это поле для нашего обджектаб путем установки флага в режим тру

                        try {

                            final String dbColumnValue = row.get(objectFieldName); // Получаем знаение из колонки

                            field.set(instance, dbColumnValue); // Пишем это значение в поле нашего обджекта

                        } catch (final IllegalAccessException e) {

                            throw new IllegalStateException("An Exception occurred!", e); //Если что-то пойдет не так, то выбросим ексепшин
                        }
                    }
                }); //И так для каждой записи в базе данных

                records.add(instance); //Добавляем каждый заполненый данными из баз обджект в коллекцию
            }
        } catch (final InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new IllegalStateException("An Exception occurred!", e);
        }
        return records;
    }


    private static <T> List<Field> retrieveAllFields(final Class<T> returnType) {  // получить все поля из моего объекта (Students)
        return Arrays.asList(returnType.getDeclaredFields());  // масив полей моего объекта
    }

    public static List<Map<String, String>> executeRetrieve(final String query) { //вычитать данные
        final List<Map<String, String>> rowsData = new ArrayList<>(); // Лист моих данных(список)

        try {

            final Statement statement = tryToConnect();
            final ResultSet resultSet = statement.executeQuery(query); //Данные о таблице (в том числе и служебная информация: ко-во колонок, строк. и тд)
            final ResultSetMetaData resultSetMetaData = resultSet.getMetaData();  //Служебные данные о таблице в которой мы получили из ResultSet
            final Integer columnCount = resultSetMetaData.getColumnCount(); //Получили количество колонок в таблице (распарсили)

            while (resultSet.next()) {  // пока есть строки(true) - вычитываем

                final Map<String, String> columnData = new HashMap<>();  // для каждой строчки создаем мапу

                for (Integer columnIndex = 1; columnIndex < columnCount; columnIndex++) { //Цикл по колонкам
                    final String columnName = resultSetMetaData.getColumnName(columnIndex);  //Имя колонки
                    final String columnValue = resultSet.getString(columnIndex);  // Значение колонки
                    columnData.put(columnName, columnValue); //положить в мапу
                }

                rowsData.add(columnData);  //добавить данные в лист(список)
            }

        } catch (final SQLException e) {
            throw new IllegalStateException("Unable to execute query!", e);
        }

        return rowsData;
    }

    private static Statement tryToConnect() throws SQLException {
        if (Objects.isNull(connection) || connection.isClosed()) {
            Logger.out.debug("Connection is closed. Perform reconnecting!");
            initConnection();
        }
        return connection.createStatement();
    }

}

