package com.example.markdown.controller;

import com.example.annotation.PassToken;
import com.example.annotation.UserLoginToken;
import com.example.markdown.bean.MarkDown;
import com.example.markdown.bean.MarkDownInfo;
import com.example.markdown.bean.SelBlogAndPageDTO;
import com.example.markdown.bean.TagPO;
import com.example.markdown.service.impl.SelServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.List;

@Api(value = "markdownc查询类接口")

@Controller
@RequestMapping("/markdown")
public class selectController {
    @Autowired
    SelServiceImpl selService;

    /* 方法注解 */
    @ApiOperation(value = "查询博客", notes = "查询博客十条 按照页数查询")
    @RequestMapping(value = "/selBlogByPage",method = RequestMethod.GET)
    @PassToken
    @ResponseBody
    public SelBlogAndPageDTO selBlogByPage(Integer PageNum){
        return new SelBlogAndPageDTO(selService.selBlogTotal(),selService.selBlogByPage(PageNum));
    }
    @ApiOperation(value = "查询所有文章类型")
    @PassToken
    @RequestMapping(value = "/selBlogType",method = RequestMethod.GET)
    @ResponseBody
    public List<TagPO> selBlogTag(){
        return selService.selTagPO();
    }
    @ApiOperation(value = "查询单篇文章")
    @RequestMapping(value = "/selBlogById",method = RequestMethod.GET)
    @PassToken
    @ResponseBody
    public MarkDown selBlogById(Integer id){
        return selService.selBlogById(id);
    }
    @ApiOperation(value = "查询单篇文章 html")
    @RequestMapping(value = "/selBlogByMid",method = RequestMethod.GET)
    @ResponseBody
    public MarkDownInfo selBlogByMid(Integer mid){
        return selService.selBlogInfoByMid(mid);
    }

}
