package com.codingdojo.mvc.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Ninja;


@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long> {

}