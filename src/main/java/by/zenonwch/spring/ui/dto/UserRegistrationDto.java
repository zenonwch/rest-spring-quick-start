package by.zenonwch.spring.ui.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegistrationDto extends UserUpdateDto {
    @NotNull(message = "Email cannot be null")
    @Email
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 16, message = "Password must contain 8..16 characters")
    private String password;

    @NotNull(message = "Password confirmation cannot be null")
    private String confirmPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(final String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
