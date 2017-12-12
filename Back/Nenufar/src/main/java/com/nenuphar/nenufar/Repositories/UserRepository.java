package com.nenuphar.nenufar.Repositories;

import com.nenuphar.nenufar.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
