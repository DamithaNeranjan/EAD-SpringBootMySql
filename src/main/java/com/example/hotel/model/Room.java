package com.example.hotel.model;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    private String roomNumber;
    private String roomType;
    private String roomColor;

    @ManyToOne()
    @JoinColumn(
            name = "hotelId",
            referencedColumnName = "hotelId"
    )
    private Hotel hotel;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomColor() {
        return roomColor;
    }

    public void setRoomColor(String roomColor) {
        this.roomColor = roomColor;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                ", roomColor='" + roomColor + '\'' +
                '}';
    }
}
