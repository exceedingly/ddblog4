package com.example.markdown.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarkDownInfo {
    private int id;
    private String markHtml;
    private String markCode;
    private Date gmt_create;
    private Date gmt_modified;
    private int mid;
}
