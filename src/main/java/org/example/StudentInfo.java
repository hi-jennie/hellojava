package org.example;

/**
 * @author rd_qinglin_mu
 * @description student info
 * @单据标识
 * @date 2024/5/14 11:37
 **/
public class StudentInfo {
    private int id;
    private String name;
    private int age;

    public StudentInfo(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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


}
