package com.example.markdown.service;

import com.example.markdown.bean.MarkDown;
import org.springframework.stereotype.Service;

@Service
public interface MarkdownService  {
    int insMarkdown(MarkDown markDown);

}
