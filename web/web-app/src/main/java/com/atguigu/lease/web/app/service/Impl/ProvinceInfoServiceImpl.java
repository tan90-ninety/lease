package com.atguigu.lease.web.app.service.Impl;


import com.atguigu.lease.model.entity.ProvinceInfo;
import com.atguigu.lease.web.app.mapper.ProvinceInfoMapper;
import com.atguigu.lease.web.app.service.ProvinceInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProvinceInfoServiceImpl extends ServiceImpl<ProvinceInfoMapper, ProvinceInfo> implements ProvinceInfoService {
}
