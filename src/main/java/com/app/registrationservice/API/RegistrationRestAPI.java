package com.app.registrationservice.API;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.registrationservice.DTO.RegistrationRequest;
import com.app.registrationservice.DTO.RegistrationResponse;
import com.app.registrationservice.Service.RegistrationService;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registration")
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationRestAPI {

	private final RegistrationService registrationService;

	@PostMapping("/userRegister")
	public ResponseEntity<RegistrationResponse> registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) throws Exception  {
		RegistrationResponse registrationResponse = registrationService.registration(registrationRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);

	}
}
