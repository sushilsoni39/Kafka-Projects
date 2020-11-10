package com.example.KafkaDemo.model;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", insertable=true, updatable=true, unique=true, nullable=false)

    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "number")
    private long number;
    @Column(name = "email")
    private String email;

    public Employee() {
    }

    public Employee(Integer id, String name, long number, String email) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.email = email;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", email='" + email + '\'' +
                '}';
    }
}