package com.wx.platform.api.response;

import java.util.List;

import com.wx.platform.api.entity.UserShare;

/**
 * @author peiyu
 */
public class GetUserShareResponse extends BaseResponse {

    private List<UserShare> list;

    public List<UserShare> getList() {
        return list;
    }

    public void setList(List<UserShare> list) {
        this.list = list;
    }
}
