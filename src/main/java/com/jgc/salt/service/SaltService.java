package com.jgc.salt.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SaltService {

    @Resource
    private IdService idService;

    /**
     * 获取短链接
     *
     * @return
     */
    public String nextUrl() {
        return SaltUtil.next(idService.nextId());
    }


}
