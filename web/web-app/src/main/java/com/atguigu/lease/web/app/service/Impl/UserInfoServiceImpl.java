package com.atguigu.lease.web.app.service.Impl;

import com.atguigu.lease.model.entity.UserInfo;
import com.atguigu.lease.web.app.mapper.UserInfoMapper;
import com.atguigu.lease.web.app.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
}
