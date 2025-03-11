package com.example.demo;

import com.example.demo.items.Item;
import com.example.demo.items.ItemService;
import com.example.demo.locations.Location;
import com.example.demo.locations.LocationService;
import com.example.demo.claims.Claim;
import com.example.demo.claims.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private ClaimService claimService;

    @GetMapping("/")
    public Map<String, List<?>> home() {
        Map<String, List<?>> response = new HashMap<>();
        response.put("items", itemService.getAllItems());
        response.put("locations", locationService.getAllLocations());
        response.put("claims", claimService.getAllClaims());
        return response;
    }
}