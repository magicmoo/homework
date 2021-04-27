package com.homework.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "student")
public class Student {
    @Id
    private Integer id;
    private String name;
    @Column(name = "sNumber")
    private String sNumber;
}
