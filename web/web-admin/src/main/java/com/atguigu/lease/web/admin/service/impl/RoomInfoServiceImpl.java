package com.atguigu.lease.web.admin.service.impl;

import com.atguigu.lease.model.entity.*;
import com.atguigu.lease.model.enums.ItemType;
import com.atguigu.lease.web.admin.mapper.*;
import com.atguigu.lease.web.admin.service.*;
import com.atguigu.lease.web.admin.vo.attr.AttrValueVo;
import com.atguigu.lease.web.admin.vo.graph.GraphVo;
import com.atguigu.lease.web.admin.vo.room.RoomDetailVo;
import com.atguigu.lease.web.admin.vo.room.RoomItemVo;
import com.atguigu.lease.web.admin.vo.room.RoomQueryVo;
import com.atguigu.lease.web.admin.vo.room.RoomSubmitVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liubo
 * @description 针对表【room_info(房间信息表)】的数据库操作Service实现
 * @createDate 2023-07-24 15:48:00
 */
@Service
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo>
        implements RoomInfoService {

    @Autowired
    private GraphInfoService graphInfoService;

    @Autowired
    private RoomAttrValueService roomAttrKeyService;

    @Autowired
    private RoomFacilityService roomFacilityService;

    @Autowired
    private RoomLabelService roomLabelService;

    @Autowired
    private RoomPaymentTypeService roomPaymentTypeService;

    @Autowired
    private RoomLeaseTermService roomLeaseTermService;

    @Autowired
    private RoomInfoMapper roomInfoMapper;

    @Autowired
    private ApartmentInfoMapper apartmentInfoMapper;

    @Autowired
    private GraphInfoMapper graphInfoMapper;

    @Autowired
    private AttrValueMapper attrValueMapper;

    @Autowired
    private FacilityInfoMapper facilityInfoMapper;

    @Autowired
    private LabelInfoMapper labelInfoMapper;

    @Autowired
    private PaymentTypeMapper paymentTypeMapper;

    @Autowired
    private LeaseTermMapper leaseTermMapper;

    @Override
    public void saveOrUpdateRoom(RoomSubmitVo roomSubmitVo) {
        boolean isUpdate = roomSubmitVo.getId() != null;
        super.saveOrUpdate(roomSubmitVo);

        if (isUpdate) {
            LambdaQueryWrapper<GraphInfo> graphInfoWrapper = new LambdaQueryWrapper<>();
            graphInfoWrapper.eq(GraphInfo::getItemId, roomSubmitVo.getId());
            graphInfoWrapper.eq(GraphInfo::getItemType, ItemType.ROOM);
            graphInfoService.remove(graphInfoWrapper);

            LambdaQueryWrapper<RoomAttrValue> roomAttrValueWrapper = new LambdaQueryWrapper<>();
            roomAttrValueWrapper.eq(RoomAttrValue::getRoomId, roomSubmitVo.getId());
            roomAttrKeyService.remove(roomAttrValueWrapper);

            LambdaQueryWrapper<RoomFacility> roomFacilityWrapper = new LambdaQueryWrapper<>();
            roomFacilityWrapper.eq(RoomFacility::getRoomId, roomSubmitVo.getId());
            roomFacilityService.remove(roomFacilityWrapper);

            LambdaQueryWrapper<RoomLabel> roomLabelWrapper = new LambdaQueryWrapper<>();
            roomLabelWrapper.eq(RoomLabel::getRoomId, roomSubmitVo.getId());
            roomLabelService.remove(roomLabelWrapper);

            LambdaQueryWrapper<RoomPaymentType> roomPaymentTypeWrapper = new LambdaQueryWrapper<>();
            roomPaymentTypeWrapper.eq(RoomPaymentType::getRoomId, roomSubmitVo.getId());
            roomPaymentTypeService.remove(roomPaymentTypeWrapper);

            LambdaQueryWrapper<RoomLeaseTerm> roomLeaseTermWrapper = new LambdaQueryWrapper<>();
            roomLeaseTermWrapper.eq(RoomLeaseTerm::getRoomId, roomSubmitVo.getId());
            roomLeaseTermService.remove(roomLeaseTermWrapper);
        }

        List<GraphVo> graphVoList = roomSubmitVo.getGraphVoList();
        if (graphVoList != null && !graphVoList.isEmpty()) {
            List<GraphInfo> graphInfoList = graphVoList.stream().map(graphVo -> {
                GraphInfo graphInfo = new GraphInfo();
                graphInfo.setItemId(roomSubmitVo.getId());
                graphInfo.setItemType(ItemType.ROOM);
                graphInfo.setName(graphVo.getName());
                graphInfo.setUrl(graphVo.getUrl());
                return graphInfo;
            }).collect(Collectors.toList());
            graphInfoService.saveBatch(graphInfoList);
        }

        List<Long> attrValueIds = roomSubmitVo.getAttrValueIds();
        if (attrValueIds != null && !attrValueIds.isEmpty()) {
            List<RoomAttrValue> roomAttrValueList = attrValueIds.stream().map(id ->
                    RoomAttrValue
                            .builder()
                            .roomId(roomSubmitVo.getId())
                            .attrValueId(id)
                            .build()
            ).collect(Collectors.toList());
            roomAttrKeyService.saveBatch(roomAttrValueList);
        }

        List<Long> facilityInfoIds = roomSubmitVo.getFacilityInfoIds();
        if (facilityInfoIds != null && !facilityInfoIds.isEmpty()) {
            List<RoomFacility> roomFacilityList = facilityInfoIds.stream().map(id ->
                    RoomFacility
                            .builder()
                            .roomId(roomSubmitVo.getId())
                            .facilityId(id)
                            .build()
            ).collect(Collectors.toList());
            roomFacilityService.saveBatch(roomFacilityList);
        }

        List<Long> labelInfoIds = roomSubmitVo.getLabelInfoIds();
        if (labelInfoIds != null && !labelInfoIds.isEmpty()) {
            List<RoomLabel> roomLabelList = labelInfoIds.stream().map(id ->
                    RoomLabel
                            .builder()
                            .roomId(roomSubmitVo.getId())
                            .labelId(id)
                            .build()
            ).collect(Collectors.toList());
            roomLabelService.saveBatch(roomLabelList);
        }

        List<Long> paymentTypeIds = roomSubmitVo.getPaymentTypeIds();
        if (paymentTypeIds != null && !paymentTypeIds.isEmpty()) {
            List<RoomPaymentType> roomPaymentTypeList = paymentTypeIds.stream().map(id ->
                    RoomPaymentType
                            .builder()
                            .roomId(roomSubmitVo.getId())
                            .paymentTypeId(id)
                            .build()
            ).collect(Collectors.toList());
            roomPaymentTypeService.saveBatch(roomPaymentTypeList);
        }

        List<Long> leaseTermIds = roomSubmitVo.getLeaseTermIds();
        if (leaseTermIds != null && !leaseTermIds.isEmpty()) {
            List<RoomLeaseTerm> roomLeaseTermList = leaseTermIds.stream().map(id ->
                    RoomLeaseTerm.
                            builder()
                            .roomId(roomSubmitVo.getId())
                            .leaseTermId(id)
                            .build()
            ).collect(Collectors.toList());
            roomLeaseTermService.saveBatch(roomLeaseTermList);
        }

    }

    @Override
    public IPage<RoomItemVo> pageItem(Page<RoomItemVo> roomItemVoPage, RoomQueryVo queryVo) {
        IPage<RoomItemVo> roomItemVoIPage = roomInfoMapper.pageItem(roomItemVoPage, queryVo);
        return roomItemVoIPage;
    }

    @Override
    public RoomDetailVo getDetailById(Long id) {
        RoomDetailVo roomDetailVo = new RoomDetailVo();

        RoomInfo roomInfo = roomInfoMapper.selectById(id);
        BeanUtils.copyProperties(roomInfo, roomDetailVo);

        ApartmentInfo apartmentInfo = apartmentInfoMapper.selectById(roomInfo.getApartmentId());
        roomDetailVo.setApartmentInfo(apartmentInfo);

        List<GraphVo> graphVoList = graphInfoMapper.selectListByTypeAndId(ItemType.ROOM, id);
        roomDetailVo.setGraphVoList(graphVoList);

        List<AttrValueVo> attrValueVoList = attrValueMapper.selectAttrValueVoById(id);
        roomDetailVo.setAttrValueVoList(attrValueVoList);

        List<FacilityInfo> facilityInfoList = facilityInfoMapper.selectListByRoomId(id);
        roomDetailVo.setFacilityInfoList(facilityInfoList);

        List<LabelInfo> labelInfoList = labelInfoMapper.selectListByRoomId(id);
        roomDetailVo.setLabelInfoList(labelInfoList);

        List<PaymentType> paymentTypeList = paymentTypeMapper.selectListByRoomId(id);
        roomDetailVo.setPaymentTypeList(paymentTypeList);

        List<LeaseTerm> leaseTermList = leaseTermMapper.selectListByRoomId(id);
        roomDetailVo.setLeaseTermList(leaseTermList);

        return roomDetailVo;
    }

    @Override
    public void removeRoomById(Long id) {

        super.removeById(id);

        LambdaQueryWrapper<RoomAttrValue> roomAttrValueQueryWrapper = new LambdaQueryWrapper<>();
        roomAttrValueQueryWrapper.eq(RoomAttrValue::getRoomId, id);
        roomAttrKeyService.remove(roomAttrValueQueryWrapper);

        LambdaQueryWrapper<RoomFacility> roomFacilityQueryWrapper = new LambdaQueryWrapper<>();
        roomFacilityQueryWrapper.eq(RoomFacility::getRoomId, id);
        roomFacilityService.remove(roomFacilityQueryWrapper);

        LambdaQueryWrapper<RoomLabel> roomLabelQueryWrapper = new LambdaQueryWrapper<>();
        roomLabelQueryWrapper.eq(RoomLabel::getRoomId, id);
        roomLabelService.remove(roomLabelQueryWrapper);

        LambdaQueryWrapper<RoomPaymentType> roomPaymentTypeQueryWrapper = new LambdaQueryWrapper<>();
        roomPaymentTypeQueryWrapper.eq(RoomPaymentType::getRoomId, id);
        roomPaymentTypeService.remove(roomPaymentTypeQueryWrapper);

        LambdaQueryWrapper<RoomLeaseTerm> roomLeaseTermQueryWrapper = new LambdaQueryWrapper<>();
        roomLeaseTermQueryWrapper.eq(RoomLeaseTerm::getRoomId, id);
        roomLeaseTermService.remove(roomLeaseTermQueryWrapper);
    }
}




