package com.nenuphar.nenufar.Repositories;

import com.nenuphar.nenufar.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByName(@Param("login") String login);
}
