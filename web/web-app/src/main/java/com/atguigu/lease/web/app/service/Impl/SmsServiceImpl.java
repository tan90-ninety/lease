package com.atguigu.lease.web.app.service.Impl;

import com.atguigu.lease.web.app.service.SmsService;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {

    @Override
    public void sendCode(String phone, String code) {
        // 发送短信
        System.out.println(phone + ": " + code);
    }
}
