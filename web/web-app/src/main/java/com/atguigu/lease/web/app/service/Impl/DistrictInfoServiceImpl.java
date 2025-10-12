package com.atguigu.lease.web.app.service.Impl;

import com.atguigu.lease.model.entity.DistrictInfo;
import com.atguigu.lease.web.app.mapper.DistrictInfoMapper;
import com.atguigu.lease.web.app.service.DistrictInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DistrictInfoServiceImpl extends ServiceImpl<DistrictInfoMapper, DistrictInfo> implements DistrictInfoService {
}
