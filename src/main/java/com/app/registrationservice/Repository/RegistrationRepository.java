package com.app.registrationservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.registrationservice.Model.Registration;



@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
	
	boolean existsByEmail(String email);
	boolean existsByPhoneNumber(String phoneNumber);

}
