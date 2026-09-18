/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login_app;

/**
 *
 * @author Student
 */

 import java.util.regex.Pattern;

public class UserRegistrationAndLoginFeature  {

    private String registeredUsername;
    private String registeredPassword;
    private String firstName;
    private String lastName;
    private final String cellPhoneNumber;

   
    private static final String CELL_PHONE_PATTERN = "^\\+27[0-9]{9}$";

   
        public UserRegistrationAndLoginFeature(String userName, String password,
         String cellPhoneNumber) {

        this.registeredUsername = userName;
        this.registeredPassword = password;
        this.cellPhoneNumber = cellPhoneNumber.replaceAll("tel:|\\s+", "").trim();
    }

   
    public boolean checkUserName() {
        if (registeredUsername == null) return false;
        return registeredUsername.contains("_") && registeredUsername.length() <= 5;
    }

   
    public boolean checkPasswordComplexity() {
        if (registeredPassword == null || registeredPassword.length() < 8) {
            return false;
        }
        boolean hasCapital = false, hasNumber = false, hasSpecial = false;
        for (int i = 0; i < registeredPassword.length(); i++) {
            char c = registeredPassword.charAt(i);
            if (Character.isUpperCase(c)) hasCapital = true;
            else if (Character.isDigit(c)) hasNumber = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        return hasCapital && hasNumber && hasSpecial;
    }

   
    public boolean checkCellPhoneNumber() {
        if (cellPhoneNumber == null) return false;
        return Pattern.matches(CELL_PHONE_PATTERN, cellPhoneNumber);
    }
}


