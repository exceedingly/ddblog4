package com.example.markdown.dao;

import com.example.markdown.bean.MarkDown;
import com.example.markdown.bean.MarkDownInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MarkdownDao {

    @Insert("insert into dd_markdown (user_id,gmt_create,gmt_modified,type,is_top,content,name,markcode,markhtml) values(#{user_id},#{gmt_create},#{gmt_modified},#{type},#{is_top},#{content},#{name},#{markCode},#{markHtml})")
    int insMarkdown(MarkDown markDown);


}
