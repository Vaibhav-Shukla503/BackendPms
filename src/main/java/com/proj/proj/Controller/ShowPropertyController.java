package com.proj.proj.Controller;

import com.proj.proj.Model.Property;
import com.proj.proj.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/AvailableProperty")
public class ShowPropertyController {
    @Autowired
    private PropertyRepository propertyRepository;
    @GetMapping("/getProperty")
    public List<Property> getAvailableProperty() {
        return propertyRepository.findAll();

    }

        @PutMapping("/{id}")
        public ResponseEntity<String> updateProperty(
                @PathVariable Long id,
                @RequestBody Property updatedProperty) {

            Optional<Property> optionalProperty = propertyRepository.findById(id);
            if (optionalProperty.isPresent()) {
                Property property = optionalProperty.get();
                property.setName(updatedProperty.getName());
                property.setLocation(updatedProperty.getLocation());
                propertyRepository.save(property);
                return ResponseEntity.ok("Property updated successfully.");
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteProperty(@PathVariable Long id) {
            if (propertyRepository.existsById(id)) {
                propertyRepository.deleteById(id);
                return ResponseEntity.ok("Property deleted successfully.");
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }




