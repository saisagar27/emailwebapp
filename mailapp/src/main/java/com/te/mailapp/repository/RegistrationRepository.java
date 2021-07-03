package com.te.mailapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.mailapp.beans.User;

public interface RegistrationRepository extends JpaRepository<User, Integer>{

}
