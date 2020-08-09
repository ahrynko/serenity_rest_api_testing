package com.github.serenity.steps.db;

import com.github.db.DataBaseUtils;
import com.github.db.dto.Student;
import com.github.db.dto.User;
import org.junit.Test;

import java.util.List;

public class SqlServerSteps {

    @Test
    public void verifySqlQueryExecution() {
      /*  final String query = "insert into [dbo].[hillel_students]" +
                "([LastName], [FirstName], [Age], [Address], [City]) " +
                "values ('Shcherbina', 'Denys', '22', 'Bankova str, 45', 'Kyiv')"; */

        final String selectStudentsQuery = "select * from hillel_students";
        final String selectUsersQuery = "select * from [hillel-database].dbo.[User]";
      /*  DataBaseUtils.executeQuery(query); */
      /*  final List<Map<String, String>> results = DataBaseUtils.executeRetrieve(selectQuery); */
        final List<Student> students = DataBaseUtils.executeRetrieveAsListObjects(selectStudentsQuery, Student.class);
        final List<User> users = DataBaseUtils.executeRetrieveAsListObjects(selectUsersQuery, User.class);
    }
}
