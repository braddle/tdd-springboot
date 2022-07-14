package com.github.braddle.learning.services;

import com.github.braddle.learning.entites.Thing;
import com.github.braddle.learning.repositories.ThingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ThingService {

    private ThingRepository thingRepository;

    public ThingService(ThingRepository thingRepository) {
        this.thingRepository = thingRepository;
    }

    public Thing save(Thing resource) {
        return thingRepository.save(resource);
    }
}
