package com.haris.MechanicApp.Repository;

import com.haris.MechanicApp.Model.Location.Location;
import com.haris.MechanicApp.Model.Verification.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrentLocationRepository extends JpaRepository<Location , Long> {

    Optional<Location> findByUser(User user);
}
