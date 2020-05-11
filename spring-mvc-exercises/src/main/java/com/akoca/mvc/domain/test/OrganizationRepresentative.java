package com.akoca.mvc.domain.test;

import com.akoca.annotation.AgeConstraint;
import com.akoca.annotation.EmailVerification;
import com.akoca.annotation.FieldsVerification;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@FieldsVerification.List({

    @FieldsVerification(field = "email" ,
                        fieldMatch = "verifyEmail" ,
                        message = "Email do not match" ) ,

    @FieldsVerification(field = "password" ,
                        fieldMatch = "verifyPassword" ,
                        message = "Pass do not match")
})
public class OrganizationRepresentative {

    @NotBlank(message = "First name can not be blank")
    private String firstName;

    @NotEmpty(message = "Last name can not be empty")
    @Size(min = 4 , max = 12 , message = "min 4 , max 12")
    private String lastName;

    @AgeConstraint(lower = 20 , upper = 80 , message = "20 <   < 80 please")
    private Integer age;

    @NotBlank(message = "Not blank")
    @Pattern(regexp = "^[a-zA-Z0-9]{6}" , message = "6 longed , char and digit only")
    private String zipCode;

    @EmailVerification(message = "Email is not valid")
    @NotBlank(message = "email can not be blank")
    private String email;

    @NotBlank(message = "email can not be blank")
    private String verifyEmail;

    @NotBlank(message = "Pass can not be blank")
    private String password;

    @NotBlank(message = "Pass can not be blank")
    private String verifyPassword;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerifyEmail() {
        return verifyEmail;
    }

    public void setVerifyEmail(String verifyEmail) {
        this.verifyEmail = verifyEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}