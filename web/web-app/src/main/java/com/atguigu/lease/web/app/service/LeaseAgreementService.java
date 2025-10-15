package com.atguigu.lease.web.app.service;

import com.atguigu.lease.model.entity.LeaseAgreement;
import com.atguigu.lease.web.app.vo.agreement.AgreementDetailVo;
import com.atguigu.lease.web.app.vo.agreement.AgreementItemVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface LeaseAgreementService extends IService<LeaseAgreement> {
    List<AgreementItemVo> listItem();

    AgreementDetailVo getDetailById(Long id);
}
