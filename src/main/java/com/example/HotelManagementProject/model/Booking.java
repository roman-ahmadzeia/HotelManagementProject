package com.example.HotelManagementProject.model;

public class Booking {
    private long id;
    private long customerid;
    private long roomid;
    private String startDate;
    private String endDate;

    public Booking() {
    }

    public Booking(long id, long customerid, long roomid, String startDate, String endDate) {
        this.id = id;
        this.customerid = customerid;
        this.roomid = roomid;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Booking(long customerid, long roomid, String startDate, String endDate) {
        this.customerid = customerid;
        this.roomid = roomid;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    public long getRoomid() {
        return roomid;
    }

    public void setRoomid(long roomid) {
        this.roomid = roomid;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", customerid=" + customerid +
                ", roomid=" + roomid +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
