package com.example.markdown.service.impl;

import com.example.markdown.bean.TagPO;
import com.example.markdown.dao.InsDao;
import com.example.markdown.service.InsService;
import org.springframework.beans.factory.annotation.Autowired;

public class InsServiceImpl implements InsService {

    @Autowired
    InsDao insDao;

    @Override
    public int insTag(TagPO tagPO) {
        return insDao.insTag(tagPO);
    }
}
