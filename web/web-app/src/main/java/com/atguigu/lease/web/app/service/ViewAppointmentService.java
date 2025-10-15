package com.atguigu.lease.web.app.service;

import com.atguigu.lease.model.entity.ViewAppointment;
import com.atguigu.lease.web.app.vo.appointment.AppointmentDetailVo;
import com.atguigu.lease.web.app.vo.appointment.AppointmentItemVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ViewAppointmentService extends IService<ViewAppointment> {
    List<AppointmentItemVo> listItem();

    AppointmentDetailVo getDetailById(Long id);
}
