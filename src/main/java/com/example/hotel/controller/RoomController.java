package com.example.hotel.controller;

import com.example.hotel.model.Room;
import com.example.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/showRoomsOfHotel/{id}")
    public String showRoomsOfHotel(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("listRoomsOfHotels", roomService.getAllRoomsByHotelId(id));
        model.addAttribute("hotelID", id);
        return "view_rooms";
    }

    @GetMapping("/showNewRoomForm/{id}")
    public String showNewRoomForm(@PathVariable(value = "id") int id, Model model) {
        Room room = new Room();
        model.addAttribute("room", room);
        model.addAttribute("hotelId", id);
        return "new_room";
    }

    @PostMapping("/saveRoom")
    public String saveRoom(@ModelAttribute("room") Room room) {
//        System.out.println(room);
        roomService.addRoom(room);
        return "redirect:/";
    }

    @GetMapping("/showUpdateRoomForm/{id}")
    public String showUpdateRoomForm(@PathVariable(value = "id") int id, Model model) {
        Room room = roomService.getRoomById(id);
//        System.out.println(room);
//        System.out.println("showUpdateRoomForm");
        model.addAttribute("room", room);
        return "update_room";
    }

    @GetMapping("/deleteRoom/{id}")
    public String deleteRoom(@PathVariable (value = "id") int id) {
        this.roomService.deleteRoomById(id);
        return "redirect:/";
    }

}
