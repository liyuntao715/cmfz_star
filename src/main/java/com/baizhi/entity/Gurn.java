package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gurn {
    @Id
    private String id;
    private String name;
    private String photo;
    private String status;
    private String sex;
}
