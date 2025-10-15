package com.atguigu.lease.web.app.mapper;

import com.atguigu.lease.model.entity.ViewAppointment;
import com.atguigu.lease.web.app.vo.appointment.AppointmentItemVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface ViewAppointmentMapper extends BaseMapper<ViewAppointment> {
    List<AppointmentItemVo> listItem(Long userId);
}
