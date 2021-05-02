package com.example.markdown.dao;

import com.example.markdown.bean.MarkDown;
import com.example.markdown.bean.MarkDownInfo;
import com.example.markdown.bean.TagPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SelDao {
       @Select("select * from dd_markdown where status = 1 limit #{PageNumber},10")
       List<MarkDown> selBlogByPage(Integer PageNumber);

       @Select("select * from dd_bbs_tag ")
       List<TagPO> selAllTag();

       @Select("select * from dd_markdown where id=#{id} ")
       MarkDown selBlogById(Integer id);

       @Select("select * from dd_markdown_info where mid=#{mid} ")
       MarkDownInfo selBlogInfoByMid(Integer mid);
       @Select("select count(*) from dd_markdown  ")
       Integer selBlogTotal();


}
