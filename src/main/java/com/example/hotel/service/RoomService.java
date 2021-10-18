package com.example.hotel.service;

import com.example.hotel.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAllRoomsByHotelId(int id);

    void addRoom (Room room);

    Room getRoomById(int id);

    void deleteRoomById(int id);
}
