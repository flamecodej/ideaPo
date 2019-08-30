package com.oracle.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class News implements Serializable {

    private Integer id;
    private String title;
    private String Content;
    private Date editDate;
}
