package com.pl.jwiki.controller;


import com.pl.jwiki.req.EbookReq;
import com.pl.jwiki.resp.CommonResp;
import com.pl.jwiki.resp.EbookResp;
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
   //为了不让请求参数越写越多，把多个参数封装成一个对象EbookReq req
    public CommonResp list(EbookReq req) {
        CommonResp<List<EbookResp>> resp = new CommonResp<>();
        List<EbookResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }

}
