package com.myCode.restaurantlisting.service;

import com.myCode.restaurantlisting.dto.RestaurantDTO;
import com.myCode.restaurantlisting.mapper.RestaurantMapper;
import com.myCode.restaurantlisting.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.myCode.restaurantlisting.entity.Restaurant;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

//    public List<RestaurantDTO> findAllRestaurant() {
//        List<Restaurant> restaurants = restaurantRepo.findAll();
//
//        List<RestaurantDTO> restaurantDTOList = restaurants.stream()
//                .map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant))
//                .collect(Collectors.toList());
//
//        return restaurantDTOList;
//
//    }

//    public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO) {
//
//        Restaurant savedRestaurant = restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
//
//        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(savedRestaurant);
//    }

    public Restaurant addRestaurantInDB(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    public List<Restaurant> findAllRestaurant() {
        return restaurantRepo.findAll();
    }

    public ResponseEntity<Restaurant> fetchRestaurantById(Integer id) {
        Optional<Restaurant> restaurant= restaurantRepo.findById(id);

        if (restaurant.isPresent()){
            return new ResponseEntity<>(restaurant.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

}
