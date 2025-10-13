package com.atguigu.lease.web.app.service;

import com.atguigu.lease.model.entity.RoomInfo;
import com.atguigu.lease.web.app.vo.room.RoomDetailVo;
import com.atguigu.lease.web.app.vo.room.RoomItemVo;
import com.atguigu.lease.web.app.vo.room.RoomQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface RoomInfoService extends IService<RoomInfo> {
    IPage<RoomItemVo> pageItem(Page<RoomInfo> page, RoomQueryVo queryVo);

    RoomDetailVo getDetailById(Long id);

    IPage<RoomItemVo> pageItemByApartmentId(IPage<RoomItemVo> page, Long id);
}
