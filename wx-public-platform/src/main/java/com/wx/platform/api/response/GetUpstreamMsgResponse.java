package com.wx.platform.api.response;

import java.util.List;

import com.wx.platform.api.entity.UpstreamMsg;

/**
 * @author peiyu
 */
public class GetUpstreamMsgResponse extends BaseResponse {

    private List<UpstreamMsg> list;

    public List<UpstreamMsg> getList() {
        return list;
    }

    public void setList(List<UpstreamMsg> list) {
        this.list = list;
    }
}
