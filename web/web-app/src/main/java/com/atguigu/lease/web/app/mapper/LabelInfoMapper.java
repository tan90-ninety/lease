package com.atguigu.lease.web.app.mapper;

import com.atguigu.lease.model.entity.LabelInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface LabelInfoMapper extends BaseMapper<LabelInfo> {
    List<LabelInfo> selectListByRoomId(Long id);

    List<LabelInfo> selectListByApartmentId(Long id);
}
