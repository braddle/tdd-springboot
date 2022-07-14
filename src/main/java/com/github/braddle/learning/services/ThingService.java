package com.github.braddle.learning.services;

import com.github.braddle.learning.entites.Thing;
import com.github.braddle.learning.repositories.ThingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThingService {

    private ThingRepository thingRepository;

    @Autowired
    public ThingService(ThingRepository thingRepository) {
        this.thingRepository = thingRepository;
    }

    public Thing save(Thing resource) {
        return thingRepository.save(resource);
    }

    public Thing getByID(Long id) throws NoThingException {
        return thingRepository.findById(id).orElseThrow(() -> new NoThingException());
    }
}
