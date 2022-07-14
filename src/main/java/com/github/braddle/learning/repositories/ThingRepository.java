package com.github.braddle.learning.repositories;

import com.github.braddle.learning.entites.Thing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThingRepository extends CrudRepository<Thing, Long> {}
