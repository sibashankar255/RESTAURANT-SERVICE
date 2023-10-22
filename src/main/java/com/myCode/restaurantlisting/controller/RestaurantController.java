package com.myCode.restaurantlisting.controller;


import com.myCode.restaurantlisting.dto.RestaurantDTO;
import com.myCode.restaurantlisting.entity.Restaurant;
import com.myCode.restaurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

//    @GetMapping("/fetchAllRestaurants")
//    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants(){
//
//        List<RestaurantDTO> allRestaurant = restaurantService.findAllRestaurant();
//
//        return new ResponseEntity<>(allRestaurant, HttpStatus.OK);
//    }


//    @PostMapping("/addRestaurant")
//    public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO){
//        RestaurantDTO restaurantAdded = restaurantService.addRestaurantInDB(restaurantDTO);
//
//        return new ResponseEntity<>(restaurantAdded,HttpStatus.CREATED);
//    }

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<Restaurant>> fetchAllRestaurants(){

        List<Restaurant> allRestaurant = restaurantService.findAllRestaurant();

        return new ResponseEntity<>(allRestaurant, HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant){
        Restaurant restaurantAdded = restaurantService.addRestaurantInDB(restaurant);
        return new ResponseEntity<>(restaurantAdded,HttpStatus.CREATED);
    }

    @GetMapping("fetchById/{id}")
    public ResponseEntity<Restaurant> fetchRestaurantById(@PathVariable Integer id){

        return restaurantService.fetchRestaurantById(id);
    }



}
