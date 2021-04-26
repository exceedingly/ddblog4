package com.example.markdown.service.impl;

import com.example.markdown.bean.MarkDown;
import com.example.markdown.bean.TagPO;
import com.example.markdown.dao.InsDao;
import com.example.markdown.dao.UpdateDao;
import com.example.markdown.service.InsService;
import com.example.markdown.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UpdServiceImpl implements UpdateService {

    @Autowired
    UpdateDao updateDao;


    @Override
    public int UpdMarkdown(MarkDown markDown) {
        return updateDao.updMarkdown(markDown);
    }
}
