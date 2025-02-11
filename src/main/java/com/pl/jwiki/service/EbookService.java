package com.pl.jwiki.service;

import com.pl.jwiki.domain.Ebook;
import com.pl.jwiki.domain.EbookExample;
import com.pl.jwiki.mapper.EbookMapper;
import com.pl.jwiki.req.EbookReq;
import com.pl.jwiki.resp.EbookResp;
import com.pl.jwiki.util.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {
    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req) {
        EbookExample ebookExample = new EbookExample();
        //相当于where的模糊查询
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%" + req.getName() + "%");
        List<Ebook> ebooks = ebookMapper.selectByExample(ebookExample);

        List<EbookResp> respList = new ArrayList<>();
        //快捷键iter
        for (Ebook ebook : ebooks) {
           // EbookResp ebookResp = new EbookResp();
           // BeanUtils.copyProperties(ebook, ebookResp);
           // 单体对象复制     使用自定义工具类CopyUtil
            EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);
            respList.add(ebookResp);
        }

        //列表复制
        List<EbookResp> list = CopyUtil.copyList(ebooks, EbookResp.class);
        return list;
    }
}
