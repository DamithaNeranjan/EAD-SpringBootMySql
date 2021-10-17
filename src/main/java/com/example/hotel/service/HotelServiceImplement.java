package com.example.hotel.service;

import com.example.hotel.model.Hotel;
import com.example.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImplement implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public void saveHotel(Hotel hotel) {
        this.hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(int id) {
        Optional< Hotel > optional = hotelRepository.findById(id);
        Hotel hotel = null;
        if (optional.isPresent()) {
            hotel = optional.get();
        } else {
            throw new RuntimeException(" Hotel not found for id :: " + id);
        }
        return hotel;
    }

    @Override
    public void deleteHotelById(int id) {
        this.hotelRepository.deleteById(id);
    }
}
