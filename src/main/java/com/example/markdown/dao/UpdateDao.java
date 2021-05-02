package com.example.markdown.dao;

import com.example.markdown.bean.MarkDown;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UpdateDao {
    @Update("update dd_markdown set gmt_modified = #{gmt_modified},type = #{type},content = #{content},name = #{name},markHtml = #{markHtml},markCode = #{markCode} where id = #{id}")
    int updMarkdown(MarkDown markDown);
    @Update("update dd_markdown set show = '0' where id = #{id}")
    int updMarkdownById(Integer id);
}
