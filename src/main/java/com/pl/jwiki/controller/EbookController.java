package com.pl.jwiki.controller;


import com.pl.jwiki.domain.Ebook;
import com.pl.jwiki.resp.CommonResp;
import com.pl.jwiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController  //RestController返回字符串和json  Controller返回的是jsp,html页面  RestController=Controller+ResponseBody
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp<List<Ebook>> list() {
        CommonResp<List<Ebook>> resp = new CommonResp<>();
        List<Ebook> list = ebookService.list();
        resp.setContent(list);
        return resp;
    }

}
