package com.demo.CRUD.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.CRUD.model.Shoes;

@Repository
public interface ShoesRepository extends CrudRepository<Shoes, Integer>{

}
