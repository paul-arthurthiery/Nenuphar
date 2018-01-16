package com.nenuphar.nenufar.Repositories;

import com.nenuphar.nenufar.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(@Param("login") String login);

    User findByUuid(@Param("uuid") String uuid);

    /*List<User> getTeamMembersFromUUID(String uuid);

    List<User> getWorkgroupMembersFromUUID(String uuid);*/


}
