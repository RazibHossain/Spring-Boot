package com.razib.sample.Beggining.App.repository;

import com.razib.sample.Beggining.App.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {

}
