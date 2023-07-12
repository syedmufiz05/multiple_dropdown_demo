package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> getUserByEmailId(String emailId);

    void deleteUserByEmailId(String emailId);

    @Query(value = "select u from User u order by created desc")
    List<User> findAllUsers();
}
