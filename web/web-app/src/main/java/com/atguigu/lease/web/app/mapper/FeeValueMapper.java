package com.atguigu.lease.web.app.mapper;

import com.atguigu.lease.model.entity.FeeValue;
import com.atguigu.lease.web.app.vo.fee.FeeValueVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface FeeValueMapper extends BaseMapper<FeeValue> {
    List<FeeValueVo> selectListByApartmentId(Long apartmentId);
}
