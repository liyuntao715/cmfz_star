package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Counter {
    @Id
    private String id;
    private String userId;
    private String courseId;
    private String title;
    private String count;
    private Date createDate;
}
