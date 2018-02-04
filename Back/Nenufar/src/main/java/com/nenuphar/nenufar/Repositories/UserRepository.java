package com.nenuphar.nenufar.Repositories;

import com.nenuphar.nenufar.Models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(@Param("login") String login);

    @Query(value="SELECT * FROM user WHERE uuid = ?1", nativeQuery = true)
    User getByUuid(@Param("uuid") String uuid);

    @Query(value="SELECT * FROM User WHERE name = ?1 AND last_name=?2", nativeQuery = true)
    User getFromCompleteName(@Param("name") String name, @Param("last_name") String last_name);

    @Query(value="SELECT * FROM User WHERE id = (SELECT user_id from Team_user Where team_id = (SELECT Team_id FROM Team_user WHERE user_id = (SELECT user_id from User WHERE uuid = ?1)))", nativeQuery = true)
    List<User> getTeamMatesFromUUID(@Param("uuid") String uuid);

    @Query(value="SELECT * FROM User WHERE id = (SELECT user_id from workgroup_user Where workgroup_id= (SELECT workgroup_id FROM workgroup_user WHERE user_id = (SELECT user_id from User WHERE uuid = ?1)))", nativeQuery = true)
    List<User> getWorkgroupMembersFromUUID(@Param("uuid") String uuid);

}
