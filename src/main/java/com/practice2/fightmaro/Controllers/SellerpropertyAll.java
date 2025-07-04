package com.practice2.fightmaro.Controllers;

import com.practice2.fightmaro.Entities.Property;
import com.practice2.fightmaro.Repositories.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping
public class SellerpropertyAll {
    @Autowired
    private PropertyRepo propertyRepo;
    @GetMapping("/all-by-sellers")
    public ResponseEntity<List<Property>> getAllSellerProperties() {
        List<Property> sellerProps = propertyRepo.findAllPropertiesBySellers(); // or filter manually
        return ResponseEntity.ok(sellerProps);
    }

}
