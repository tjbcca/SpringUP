package com.example.demo;

import com.example.demo.items.Item;
import com.example.demo.items.ItemRepository;
import com.example.demo.locations.Location;
import com.example.demo.locations.LocationRepository;
import com.example.demo.claims.Claim;
import com.example.demo.claims.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TheInit implements CommandLineRunner {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public void run(String... args) throws Exception {
        // Clear existing data
        claimRepository.deleteAll();
        itemRepository.deleteAll();
        locationRepository.deleteAll();

        // Create locations
        Location location1 = new Location();
        location1.setName("Central Library");
        location1.setAddress("123 Main St, Water Valley, MS");
        locationRepository.save(location1);

        Location location2 = new Location();
        location2.setName("Community Center");
        location2.setAddress("456 Elm St, Water Valley, MS");
        locationRepository.save(location2);

        Location location3 = new Location();
        location3.setName("City Park");
        location3.setAddress("789 Oak St, Water Valley, MS");
        locationRepository.save(location3);

        // Create items
        Item item1 = new Item();
        item1.setName("Wallet");
        item1.setDescription("Black leather wallet");
        item1.setClaimed(false);
        item1.setLocation(location1);
        itemRepository.save(item1);

        Item item2 = new Item();
        item2.setName("Umbrella");
        item2.setDescription("Blue umbrella with white stripes");
        item2.setClaimed(false);
        item2.setLocation(location2);
        itemRepository.save(item2);

        Item item3 = new Item();
        item3.setName("Backpack");
        item3.setDescription("Red backpack with school supplies");
        item3.setClaimed(false);
        item3.setLocation(location3);
        itemRepository.save(item3);

        Item item4 = new Item();
        item4.setName("Phone");
        item4.setDescription("Silver smartphone");
        item4.setClaimed(true);
        item4.setLocation(location1);
        itemRepository.save(item4);

        Item item5 = new Item();
        item5.setName("Keys");
        item5.setDescription("Set of car keys with a keychain");
        item5.setClaimed(true);
        item5.setLocation(location2);
        itemRepository.save(item5);

        // Create claims
        Claim claim1 = new Claim();
        claim1.setItemId(item4.getId());
        claim1.setClaimantName("John Doe");
        claim1.setClaimantContact("john.doe@example.com");
        claimRepository.save(claim1);

        Claim claim2 = new Claim();
        claim2.setItemId(item5.getId());
        claim2.setClaimantName("Jane Smith");
        claim2.setClaimantContact("jane.smith@example.com");
        claimRepository.save(claim2);
    }
}