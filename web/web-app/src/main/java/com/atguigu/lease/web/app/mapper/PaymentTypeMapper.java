package com.atguigu.lease.web.app.mapper;

import com.atguigu.lease.model.entity.PaymentType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface PaymentTypeMapper extends BaseMapper<PaymentType> {
    List<PaymentType> selectListByRoomId(Long id);
}
