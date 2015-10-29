package com.wx.platform.api.response;

import java.util.List;

import com.wx.platform.api.entity.UserCumulate;

/**
 * @author peiyu
 */
public class GetUserCumulateResponse extends BaseResponse {

    private List<UserCumulate> list;

    public List<UserCumulate> getList() {
        return list;
    }

    public void setList(List<UserCumulate> list) {
        this.list = list;
    }
}
