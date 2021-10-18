package com.example.hotel.service;

import com.example.hotel.model.Hotel;
import com.example.hotel.model.Room;
import com.example.hotel.repository.HotelRepository;
import com.example.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImplement implements RoomService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public List<Room> getAllRoomsByHotelId(int id) {
        List<Room> roomList = null;
        Optional<Hotel> optional = hotelRepository.findById(id);
        Hotel hotel = null;
        if (optional.isPresent()) {
            hotel = optional.get();
            roomList = hotel.getRooms();
        } else {
            throw new RuntimeException(" Rooms not found for Hotel id :: " + id);
        }
//        System.out.println(employeeList);
        return roomList;
    }

    @Override
    public void addRoom(Room room) {
        this.roomRepository.save(room);
    }

    @Override
    public Room getRoomById(int id) {
        Optional< Room > optional = roomRepository.findById(id);
        Room room = null;
        if (optional.isPresent()) {
            room = optional.get();
        } else {
            throw new RuntimeException(" Room not found for id :: " + id);
        }
        return room;
    }

    @Override
    public void deleteRoomById(int id) {
        this.roomRepository.deleteById(id);
    }
}
