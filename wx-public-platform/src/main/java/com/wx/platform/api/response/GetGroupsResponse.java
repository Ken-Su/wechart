package com.wx.platform.api.response;

import java.util.List;

import com.wx.platform.api.entity.Group;

/**
 * 新建实体类Group，将id，name，count属性移动到Group实体中。本实体采用List封装Groups信息
 *
 * @author peiyu, Nottyjay
 *
 */
public class GetGroupsResponse extends BaseResponse {

//    private Integer id;
//    private String  name;
//    private Integer count;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getCount() {
//        return count;
//    }
//
//    public void setCount(Integer count) {
//        this.count = count;
//    }

    private List<Group> groups;

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
