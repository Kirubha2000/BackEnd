package com.app.registrationservice.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.registrationservice.DTO.RegistrationRequest;
import com.app.registrationservice.DTO.RegistrationResponse;
import com.app.registrationservice.Model.Registration;
import com.app.registrationservice.Repository.RegistrationRepository;
import com.app.registrationservice.exception.EmailAlreadyExistException;
import com.app.registrationservice.exception.PasswordMismatchException;
import com.app.registrationservice.exception.PhoneNumberAlreadyExistsException;

//import com.app.registrationservice.userValidation.UserValidation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class RegistrationService {

	private final RegistrationRepository registrationRepository;

	private final PasswordEncoder passwordEncoder;

	// private final UserValidation userValidation;

	public RegistrationResponse registration(RegistrationRequest registrationRequest) throws Exception {

		boolean ifEmailexist = registrationRepository.existsByEmail(registrationRequest.getEmail());
		boolean ifNumberExist = registrationRepository.existsByPhoneNumber(registrationRequest.getPhoneNumber());
		if (ifEmailexist) {
			throw new EmailAlreadyExistException("Email ALready Exist");
		} else if (ifNumberExist) {
			throw new PhoneNumberAlreadyExistsException("Phone Number already exist");
		} else if (!registrationRequest.getPassword().equals(registrationRequest.getConfirmPassword())) {
			throw new PasswordMismatchException("Password Mismatch");
		} else {

			String encodedPassword = passwordEncoder.encode(registrationRequest.getPassword());

			Registration registration = Registration.builder().firstName(registrationRequest.getFirstName())
					.lastName(registrationRequest.getLastName()).email(registrationRequest.getEmail())
					.phoneNumber(registrationRequest.getPhoneNumber()).dateOfBirth(registrationRequest.getDateOfBirth())
					.password(encodedPassword).build();
			registrationRepository.save(registration);
			RegistrationResponse registrationResponse = RegistrationResponse.builder()
					.firstName(registrationRequest.getFirstName())
					.lastName(registrationRequest.getLastName())
					.build();
			return registrationResponse;
			
		}

	}
}
