package com.example.markdown.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarkDownDTO {
    private Integer id;
    private String name;
    private String markHtml;
    private String markCode;
    private String type;
    private String content;
}
