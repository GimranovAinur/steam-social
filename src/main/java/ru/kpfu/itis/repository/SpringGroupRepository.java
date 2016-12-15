package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.model.entity.Group;
import ru.kpfu.itis.model.entity.User;

import java.util.Set;

/**
 * Created by root on 08.12.16.
 */
public interface SpringGroupRepository extends JpaRepository<Group, Long>{

    @Query(value = "select u from User u " +
            "inner join u.groupsList g " +
            "where g.id = :groupid")
    Set<User> findGroupParticipants(@Param("groupid") Long groupid);

    @Query(value = "select g from Group g " +
            "inner join g.participantList u " +
            "where u.id = :userid")
    Set<Group> findUsersGroups(@Param("userid") Long id);
}