// src/main/java/com/example/propertymgmt/repository/PropertyRepository.java
package com.proj.proj.Repository;

import com.proj.proj.Model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
