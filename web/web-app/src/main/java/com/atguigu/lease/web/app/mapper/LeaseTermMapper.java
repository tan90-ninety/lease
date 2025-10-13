package com.atguigu.lease.web.app.mapper;

import com.atguigu.lease.model.entity.LeaseTerm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface LeaseTermMapper extends BaseMapper<LeaseTerm> {
    List<LeaseTerm> selectListByRoomId(Long id);
}
