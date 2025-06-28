package com.practice2.fightmaro.Service.serviceImpl;

import com.practice2.fightmaro.Entities.Property;
import com.practice2.fightmaro.Entities.User;
import com.practice2.fightmaro.Payloads.PropertyDto;
import com.practice2.fightmaro.Payloads.UserDto;
import com.practice2.fightmaro.Repositories.PropertyRepo;
import com.practice2.fightmaro.Repositories.UserRepo;
import com.practice2.fightmaro.Service.PropertyService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserRepo  userRepo;
    @Autowired
   private PropertyRepo  propertyRepo;

    public PropertyDto createProperty(PropertyDto propertyDto, Integer userid) {
       Property prop=this.modelMapper.map(propertyDto, Property.class);
       User user=this.userRepo.findById(userid).orElseThrow(()->new RuntimeException("User not found"));
       prop.setOwner(user);
        Property prop1=this.propertyRepo.save(prop);
        return this.modelMapper.map(prop1,PropertyDto.class);
    }
    public PropertyDto updateProperty(PropertyDto propertyDto, Integer id) {
        Property property=propertyRepo.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        property.setAddress(propertyDto.getAddress());
        property.setArea(propertyDto.getArea());
        property.setType(propertyDto.getType());
        property.setBedrooms(propertyDto.getBedrooms());
        property.setPrice(propertyDto.getPrice());
        property.setBathrooms(propertyDto.getBathrooms());
        Property updatedProp=this.propertyRepo.save(property);
        return this.modelMapper.map(updatedProp,PropertyDto.class);
    }
    public void deleteProperty(Integer id)
    {
        Property property=this.propertyRepo.findById(id).orElseThrow(()->new RuntimeException("Property not found"));
        this.propertyRepo.delete(property);
    }
    public List<PropertyDto> getAllProperty(Integer userId)
    {
        User user=this.userRepo.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
       List<Property> propertyall= this.propertyRepo.findByOwner(user);
        List<PropertyDto> propertyDtos=propertyall.stream().map(p->this.modelMapper.map(p,PropertyDto.class)).collect(Collectors.toList());
        return propertyDtos;
    }
 public List<PropertyDto> getAllProperties()
 {
     List<Property> property=this.propertyRepo.findAll();
    List<PropertyDto> propertyDtos= property.stream().map((prop)->this.modelMapper.map(prop,PropertyDto.class)).collect(Collectors.toList());
  return propertyDtos;
 }
public PropertyDto getPropertyById(Integer id)
{
    Property property=propertyRepo.findById(id).orElseThrow(()->new RuntimeException("Property not found"));
    return this.modelMapper.map(property,PropertyDto.class);
}
}
