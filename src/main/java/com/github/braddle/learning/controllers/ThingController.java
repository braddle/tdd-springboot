package com.github.braddle.learning.controllers;

import com.github.braddle.learning.entites.Thing;
import com.github.braddle.learning.services.NoThingException;
import com.github.braddle.learning.services.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/thing")
public class ThingController {


    private ThingService thingService;

    @Autowired
    public ThingController(ThingService thingService) {
        this.thingService = thingService;
    }

    @PostMapping
    public Thing create(@RequestBody Thing resource) {
        return thingService.save(resource);
    }

   @GetMapping("/{id}")
    public Thing getOne(@PathVariable("id") Long id) {
        try {
            return thingService.getByID(id);
        } catch (NoThingException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Thing Id:" + id);
        }
   }
}
