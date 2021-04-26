package com.example.markdown.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagPO {
    private int id;
    private String name;
    private Date gmt_create;
    private Date gmt_modified;

}
