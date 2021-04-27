package com.homework.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "class")
public class Class {
    @Id
    private Integer id;

    private String name;
}