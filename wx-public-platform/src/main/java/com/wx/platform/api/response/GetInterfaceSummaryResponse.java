package com.wx.platform.api.response;

import java.util.List;

import com.wx.platform.api.entity.InterfaceSummary;

/**
 * @author peiyu
 */
public class GetInterfaceSummaryResponse extends BaseResponse {

    private List<InterfaceSummary> list;

    public List<InterfaceSummary> getList() {
        return list;
    }

    public void setList(List<InterfaceSummary> list) {
        this.list = list;
    }
}
