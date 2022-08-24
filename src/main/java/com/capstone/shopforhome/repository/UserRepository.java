package com.capstone.shopforhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.shopforhome.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{

}
