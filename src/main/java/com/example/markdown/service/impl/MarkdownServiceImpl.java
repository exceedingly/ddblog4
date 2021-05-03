package com.example.markdown.service.impl;

import com.example.markdown.bean.MarkDown;
import com.example.markdown.bean.MarkDownDTO;
import com.example.markdown.bean.MarkDownInfo;
import com.example.markdown.dao.MarkdownDao;
import com.example.markdown.dao.SelDao;
import com.example.markdown.dao.UpdateDao;
import com.example.markdown.service.MarkdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MarkdownServiceImpl implements MarkdownService {


    @Autowired
    MarkdownDao markdownDao;

    @Autowired
    UpdateDao updateDao;

    @Autowired
    SelDao selDao;

    public int insMarkdown(MarkDownDTO markDownDTO) {


        MarkDown markDown=new MarkDown();
        markDown.setUser_id(12);
        markDown.setGmt_modified(new Date());
        markDown.setType(markDownDTO.getType());
        markDown.set_top(true);
        markDown.setContent(markDownDTO.getContent());
        markDown.setName(markDownDTO.getName());
        markDown.setMarkCode(markDownDTO.getMarkCode());
        markDown.setMarkHtml(markDownDTO.getMarkHtml());
        markDown.setType(markDownDTO.getType());
        System.out.println(markDownDTO.getId()==null);
        if(markDownDTO.getId()==null){
            // 添加
            markDown.setGmt_create(new Date());
            System.out.println("添加操作");
            System.out.println(markDown);
            return  insMarkdown(markDown);
        }else{
            // 更新
            markDown.setId(markDownDTO.getId());
            System.out.println(markDown);
            int i = updateDao.updMarkdown(markDown);
            System.out.println("更新操作");
            return i;
        }



    }



    @Override
    public int insMarkdown(MarkDown markDown) {
        return markdownDao.insMarkdown(markDown);
    }

    public String selImagePath(){return selDao.selImagesPath();}

}
