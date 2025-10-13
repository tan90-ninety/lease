package com.atguigu.lease.web.app.mapper;

import com.atguigu.lease.model.entity.AttrValue;
import com.atguigu.lease.web.app.vo.attr.AttrValueVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface AttrValueMapper extends BaseMapper<AttrValue> {
    List<AttrValueVo> selectListByRoomId(Long id);
}
