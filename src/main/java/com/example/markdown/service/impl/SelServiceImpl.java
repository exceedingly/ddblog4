package com.example.markdown.service.impl;


import com.example.markdown.bean.MarkDown;
import com.example.markdown.bean.MarkDownInfo;
import com.example.markdown.bean.TagPO;
import com.example.markdown.dao.SelDao;
import com.example.markdown.service.SelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SelServiceImpl implements SelService {
    @Autowired
    SelDao selDao;


    @Override
    public List<MarkDown> selBlogByPage(Integer pageNumber) {
        return selDao.selBlogByPage((pageNumber-1)*10);
    }

    @Override
    public List<TagPO> selTagPO() {
        return selDao.selAllTag();
    }
    @Override
    public MarkDown selBlogById(Integer id) {
        return selDao.selBlogById(id);
    }

    @Override
    public MarkDownInfo selBlogInfoByMid(Integer mid) {
        return selDao.selBlogInfoByMid(mid);
    }

    @Override
    public Integer selBlogTotal() {
        return selDao.selBlogTotal();
    }
}
