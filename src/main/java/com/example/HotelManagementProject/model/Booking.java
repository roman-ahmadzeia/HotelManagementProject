package com.example.HotelManagementProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "Bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long customerid;
    private long roomid;
    private LocalDate startDate;
    private LocalDate endDate;

    public Booking() {
    }

    public Booking(long id, long customerid, long roomid, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.customerid = customerid;
        this.roomid = roomid;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Booking(long customerid, long roomid, LocalDate startDate, LocalDate endDate) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
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
