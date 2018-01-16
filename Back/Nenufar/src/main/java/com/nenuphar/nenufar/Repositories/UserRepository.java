package com.nenuphar.nenufar.Repositories;

import com.nenuphar.nenufar.Models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(@Param("login") String login);

    User findByUuid(@Param("uuid") String uuid);

    @Query(value="SELECT * FROM User WHERE id = (SELECT user_id from Team_user Where team_id = (SELECT Team_id FROM Team_user WHERE user_id = (SELECT user_id from User WHERE uuid = ?1)))", nativeQuery = true)
    List<User> getTeamMatesFromUUID(@Param("uuid") String uuid);

    @Query(value="SELECT * FROM User WHERE id = (SELECT user_id from Workgroup_user Where workgroup_id= (SELECT Wokrgroup_id FROM Workgroup_user WHERE user_id = (SELECT user_id from User WHERE uuid = ?1)))", nativeQuery = true)
    List<User> getWorkgroupMembersFromUUID(@Param("uuid") String uuid);


}
