package com.atguigu.lease.web.app.mapper;

import com.atguigu.lease.model.entity.BrowsingHistory;
import com.atguigu.lease.web.app.vo.history.HistoryItemVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface BrowsingHistoryMapper extends BaseMapper<BrowsingHistory> {
    IPage<HistoryItemVo> pageItem(Page<HistoryItemVo> page, Long userId);
}
