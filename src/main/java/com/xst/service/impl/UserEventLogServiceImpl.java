package com.xst.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xst.domain.UserEventLog;
import com.xst.domain.other.KeyValue;
import com.xst.repository.UserEventLogMapper;
import com.xst.service.UserEventLogService;
import com.xst.utility.DateTimeUtil;
import com.xst.viewmodel.admin.user.UserEventPageRequestVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author GUO
 * @Classname UserEventLogServiceImpl
 * @Description TODO
 * @Date 2020/11/16 21:49
 */
@Service
public class UserEventLogServiceImpl extends BaseServiceImpl<UserEventLog> implements UserEventLogService {

    private final UserEventLogMapper userEventLogMapper;

    @Autowired
    public UserEventLogServiceImpl(UserEventLogMapper userEventLogMapper) {
        super(userEventLogMapper);
        this.userEventLogMapper = userEventLogMapper;
    }

    @Override
    public List<UserEventLog> getUserEventLogByUserId(Integer id) {
        return userEventLogMapper.getUserEventLogByUserId(id);
    }

    @Override
    public PageInfo<UserEventLog> page(UserEventPageRequestVM requestVM) {
        return PageHelper.startPage(requestVM.getPageIndex(), requestVM.getPageSize(), "id desc").doSelectPageInfo(() ->
                userEventLogMapper.page(requestVM)
        );
    }


    @Override
    public List<Integer> selectMothCount() {
        Date startTime = DateTimeUtil.getMonthStartDay();
        Date endTime = DateTimeUtil.getMonthEndDay();
        List<KeyValue> mouthCount = userEventLogMapper.selectCountByDate(startTime, endTime);
        List<String> mothStartToNowFormat = DateTimeUtil.MothStartToNowFormat();
        return mothStartToNowFormat.stream().map(md -> {
            KeyValue keyValue = mouthCount.stream().filter(kv -> kv.getName().equals(md)).findAny().orElse(null);
            return null == keyValue ? 0 : keyValue.getValue();
        }).collect(Collectors.toList());
    }

}
