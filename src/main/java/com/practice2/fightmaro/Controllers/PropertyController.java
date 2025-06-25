package com.practice2.fightmaro.Controllers;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.practice2.fightmaro.Payloads.PropertyDto;
import com.practice2.fightmaro.Payloads.UserDto;
import com.practice2.fightmaro.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @PostMapping("/user/{userId}/Property")
    public ResponseEntity<PropertyDto> createProperty(@RequestBody PropertyDto propertyDto, @PathVariable Integer userId)
    {
        PropertyDto propertyDto1=propertyService.createProperty(propertyDto, userId);
        return new ResponseEntity<>(propertyDto1, HttpStatus.CREATED);
    }
    //GET PROPERTY BY USER
    @GetMapping("/user/{userId}/Property")
    public ResponseEntity<List<PropertyDto>> getAllProperties(@PathVariable Integer userId)
    {
        List<PropertyDto> propertyDtos=this.propertyService.getAllProperty(userId);
        return new ResponseEntity<>(propertyDtos, HttpStatus.OK);
    }
    //GET ALL PROPERTY
    @GetMapping("/Property")
    public ResponseEntity<List<PropertyDto>> getAllProperties()
    {
        List<PropertyDto> propertyDtos=this.propertyService.getAllProperties();
        return new ResponseEntity<>(propertyDtos, HttpStatus.OK);
    }
    //GET PROPERTY BY ID
    @GetMapping("/Property/{id}")
    public ResponseEntity<PropertyDto> getPropertyById(@PathVariable Integer id)
    {
        PropertyDto propertyDto=this.propertyService.getPropertyById(id);
        return  new ResponseEntity<>(propertyDto, HttpStatus.OK);
    }
    //Delete property
    @DeleteMapping("/Property/{id}")
    public ResponseEntity<HttpStatus> deletePropertyById(@PathVariable Integer id){
        propertyService.deleteProperty(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //update property
    @PutMapping("/Property/{id}")
    public ResponseEntity<PropertyDto> updateProperty(@RequestBody PropertyDto propertyDto,@PathVariable Integer id){
        PropertyDto propertyDto1=this.propertyService.updateProperty(propertyDto,id);
        return new ResponseEntity<>(propertyDto1, HttpStatus.OK);
    }

}
