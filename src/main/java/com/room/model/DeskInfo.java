package com.room.model;

public class DeskInfo {
    private Integer id; //ID
    private String deskNo; //桌号
    private Integer deskStatus; //当前状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeskNo() {
        return deskNo;
    }

    public void setDeskNo(String deskNo) {
        this.deskNo = (deskNo == null) ? null : deskNo.trim();
    }

    public Integer getDeskStatus() {
        return deskStatus;
    }

    public void setDeskStatus(Integer deskStatus) {
        this.deskStatus = deskStatus;
    }
}

