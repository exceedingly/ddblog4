package com.example.markdown.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelBlogAndPageDTO {
    Integer total;
    List<MarkDown> markDowns;
}
