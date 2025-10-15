package com.atguigu.lease.web.app.mapper;

import com.atguigu.lease.model.entity.LeaseAgreement;
import com.atguigu.lease.web.app.vo.agreement.AgreementItemVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {
    List<AgreementItemVo> listItem(String phone);
}
