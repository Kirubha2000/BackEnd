package com.app.registrationservice.DTO;



import java.sql.Date;




import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
	
	@NotNull(message = "Please Enter your First Name")
	@NotBlank(message = "First name must not be blank")
	private String firstName;
	@NotNull(message = "Please Enter your Last Name")
	@NotBlank(message = "Last name must not be blank")
	private String lastName;
	@Email(message = "Please enter the email in correct format")
	
	private String email;
	private Date dateOfBirth;
	@NotNull(message = "Please Enter your Phone Number")
	@Pattern(regexp = "^\\d{10}$",message = "Invalid mobile number entered")
	
	private String phoneNumber;
	@NotBlank(message = "Password must not be blank")
	@NotEmpty(message = "Password must not be empty")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "Password does not met the criteria")
	private String password;
	@NotBlank(message = "Your confirm password is blank")
	@NotEmpty(message = "Your confirm password is empty")
	private String confirmPassword;

}
