package com.practice2.fightmaro.Service;

import com.practice2.fightmaro.Payloads.PropertyDto;
import com.practice2.fightmaro.Payloads.UserDto;

import java.util.List;

public interface PropertyService {
    //create property
    PropertyDto createProperty(PropertyDto propertyDto,Integer userId);
    //update property
    PropertyDto updateProperty(PropertyDto propertyDto, Integer userId);
    //delete property
    void deleteProperty(Integer id);
    //get all property of a user
    List<PropertyDto> getAllProperty(Integer userId);
 //get all property
    List<PropertyDto> getAllProperties();
    //get a single property
    PropertyDto getPropertyById(Integer id);
}
