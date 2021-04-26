package com.example.markdown.dao;

import com.example.markdown.bean.MarkDown;
import com.example.markdown.bean.TagPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InsDao {
    @Insert("insert into dd_bbs_tag (name,gmt_create,gmt_modified) value(#{name},#{gmt_create},#{gmt_modified})")
    int insTag(TagPO tagPO);

}
