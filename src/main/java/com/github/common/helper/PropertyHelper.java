package com.github.common.helper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

    // class вычитывает  property (key - value)
    public class PropertyHelper {
        // поле класса со ссылкой на наш property file
        private static final String PROPERTY_FILE_PATH = "./src/main/resources/properties/prod.properties"; //qa
        private Properties properties;                        //объект который умеет читать property

        public PropertyHelper(){
            properties = new Properties();  //инициализация объекта в конструкторе
            try {
                File propertiesFile = new File(PROPERTY_FILE_PATH);  //создан File + указан путь к файлу
                FileReader fileReader = new FileReader(propertiesFile);  //FileReader - умеет читать данные из файла
                properties.load(fileReader);                 //properties.load(new FileReader(new File(PROPERTY_FILE_PATH)));
            } catch (IOException e) {
                throw new IllegalStateException("Unable to read properties file",e);
            }
        }
        public String readProperty(String key ) {   //возврат значения из property file
            return properties.getProperty(key);

        }

    }
