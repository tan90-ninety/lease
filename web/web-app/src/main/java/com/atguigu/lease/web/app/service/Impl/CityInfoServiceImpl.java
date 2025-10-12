package com.atguigu.lease.web.app.service.Impl;

import com.atguigu.lease.model.entity.CityInfo;
import com.atguigu.lease.web.app.mapper.CityInfoMapper;
import com.atguigu.lease.web.app.service.CityInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CityInfoServiceImpl extends ServiceImpl<CityInfoMapper, CityInfo> implements CityInfoService {
}
