package com.wx.platform.message;
/**
 * 提交至微信的图文消息素材
 */
public class MpNewsMsg extends BaseMsg {

    private String mediaId;

    public MpNewsMsg() {
    }

    public MpNewsMsg(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
