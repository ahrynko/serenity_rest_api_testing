package com.github.db.dto;

import com.github.db.ColumnName;
import lombok.Data;

@Data
public class Student {

    @ColumnName(name = "PersonID") // имя колонки в БД
    private String personId;   // поле объекта (положить value with Map в поле)

    @ColumnName(name = "FirstName")
    private String firstName;

    @ColumnName(name = "LastName")
    private String lastName;

    @ColumnName(name = "Age")
    private String age;

    @ColumnName(name = "City")
    private String city;

    @ColumnName(name = "Address")
    private String address;
}
