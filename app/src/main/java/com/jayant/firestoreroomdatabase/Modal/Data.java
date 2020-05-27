package com.jayant.firestoreroomdatabase.Modal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Data", indices = @Index(value = {"id"} ,unique = true))
public class Data {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "age")
    private int age;

    @ColumnInfo(name = "experience")
    private int exprience;

    public Data(int id, String name, int age, int exprience) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.exprience = exprience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExprience() {
        return exprience;
    }

    public void setExprience(int exprience) {
        this.exprience = exprience;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", exprience=" + exprience +
                '}';
    }
}
