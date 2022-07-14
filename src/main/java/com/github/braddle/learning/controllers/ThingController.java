package com.github.braddle.learning.controllers;

import com.github.braddle.learning.entites.Thing;
import com.github.braddle.learning.repositories.ThingRepository;
import com.github.braddle.learning.services.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/thing")
public class ThingController {


    private ThingRepository thingService;

    @Autowired
    public ThingController(ThingRepository thingService) {
        this.thingService = thingService;
    }

    @PostMapping
    public Thing create(@RequestBody Thing resource) {
        return thingService.save(resource);
    }

   @GetMapping("/{id}")
    public Thing getOne(@PathVariable("id") Long id) {
        return thingService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Thing Id:" + id));
   }
}
