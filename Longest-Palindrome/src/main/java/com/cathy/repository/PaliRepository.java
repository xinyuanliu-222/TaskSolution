package com.cathy.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cathy.entity.Pali;

@Repository
public interface PaliRepository extends CrudRepository<Pali, Integer> {

	public Optional<Pali> findByName(String name);
}
