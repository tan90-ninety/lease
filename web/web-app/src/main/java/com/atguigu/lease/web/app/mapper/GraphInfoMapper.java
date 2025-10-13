package com.atguigu.lease.web.app.mapper;

import com.atguigu.lease.model.entity.GraphInfo;
import com.atguigu.lease.model.enums.ItemType;
import com.atguigu.lease.web.app.vo.graph.GraphVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface GraphInfoMapper extends BaseMapper<GraphInfo> {
    List<GraphVo> selectListByItemTypeAndId(ItemType itemType, Long id);
}
