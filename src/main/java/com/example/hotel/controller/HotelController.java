package com.example.hotel.controller;

import com.example.hotel.model.Hotel;
import com.example.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/")
    public String viewHotelPage(Model model){
        model.addAttribute("listHotels", hotelService.getAllHotels());
        return "index";
    }

    @GetMapping("/showNewHotelForm")
    public String showNewHotelForm(Model model) {
        Hotel hotel = new Hotel();
        model.addAttribute("hotel", hotel);
        return "new_hotel";
    }

    @PostMapping("/saveHotel")
    public String saveHotel(@ModelAttribute("hotel") Hotel hotel) {
        hotelService.saveHotel(hotel);
        return "redirect:/";
    }

    @GetMapping("/showUpdateHotelForm/{id}")
    public String showUpdateHotelForm(@PathVariable(value = "id") int id, Model model) {

        Hotel hotel = hotelService.getHotelById(id);

        model.addAttribute("hotel", hotel);
        return "update_hotel";
    }

    @GetMapping("/deleteHotel/{id}")
    public String deleteHotel(@PathVariable (value = "id") int id) {

        this.hotelService.deleteHotelById(id);
        return "redirect:/";
    }
}
