package com.wx.platform.api.response;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.wx.platform.api.entity.CustomAccount;

/**
 * @author peiyu
 */
public class GetCustomAccountsResponse extends BaseResponse {

    @JSONField(name = "kf_list")
    private List<CustomAccount> customAccountList;

    public List<CustomAccount> getCustomAccountList() {
        return customAccountList;
    }

    public void setCustomAccountList(List<CustomAccount> customAccountList) {
        this.customAccountList = customAccountList;
    }
}
