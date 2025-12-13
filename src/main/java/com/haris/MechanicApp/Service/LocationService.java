package com.haris.MechanicApp.Service;


import com.haris.MechanicApp.Model.Location.Location;
import com.haris.MechanicApp.Model.Verification.User;
import com.haris.MechanicApp.Repository.CurrentLocationRepository;
import com.haris.MechanicApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    CurrentLocationRepository currentlocation;

    // ye logined user ki location laikerdatabase may save kraiga
    public ResponseEntity<?> userCurrentLocation(Location location, String email) {
        User getUser = userRepo.findByEmail(email).get();
        Optional<Location> userLocation = currentlocation.findByUser(getUser);

        if (userLocation.isPresent()) {
            Location loc = userLocation.get();
            loc.setLongitude(location.getLongitude());
            loc.setLatitude(location.getLatitude());
        }
        Location newlocation = new Location();
        newlocation.setLatitude(location.getLatitude());
        newlocation.setLongitude(location.getLongitude());
        newlocation.setUser(getUser);
        return ResponseEntity.ok("Enjoy The Onfix Service");
    }
}