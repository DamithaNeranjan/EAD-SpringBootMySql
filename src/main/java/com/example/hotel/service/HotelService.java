package com.example.hotel.service;

import com.example.hotel.model.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();

    void saveHotel (Hotel hotel);

    Hotel getHotelById(int id);

    void deleteHotelById(int id);
}
