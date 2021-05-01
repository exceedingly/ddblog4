package com.example.markdown.service;

import com.example.markdown.bean.MarkDown;
import com.example.markdown.bean.MarkDownInfo;
import com.example.markdown.bean.TagPO;


import java.util.List;

public interface SelService {
    List<MarkDown> selBlogByPage(Integer PageNumber);
    List<TagPO> selTagPO();
    MarkDown selBlogById(Integer id);
    MarkDownInfo selBlogInfoByMid(Integer mid);
    Integer selBlogTotal();
}
