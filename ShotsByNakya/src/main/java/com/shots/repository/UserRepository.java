package com.shots.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.shots.entity.User;


@Repository
public interface UserRepository extends JpaRepository <User, String> {
	@Query("SELECT U FROM User U WHERE U.email = ?1 AND U.password = ?2")
	User findUserByEmailAndPassword(String email, String password);
	
	
}
