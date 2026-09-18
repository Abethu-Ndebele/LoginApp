/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login_app;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Login_app {
    String userName;
    String password;
    String CellPhoneNumber;
    boolean validUserName;
    boolean validPassword;
    boolean validCellPhoneNumber;
    private String registeredUserName;
    private String registeredPassword;
    private String registeredFirstName;
    private String registeredLastName;
    // Constructor
    public Login_app(String userName, String password, String cellPhoneNumber) {
        this.userName = userName;
        this.password = password;
        this.CellPhoneNumber = cellPhoneNumber;
    }
    // =========================
    // USERNAME
    // =========================
    public boolean checkUserName() {
        validUserName = userName != null
                && userName.length() <= 5
                && userName.contains("_");
        return validUserName;
    }
    // Used by the main program
    public String getUserNameMessage(boolean valid) {
        return valid
                ? "Username successfully captured."
                : "Username is not correctly formatted; "
                + "please ensure it contains an underscore and is no more than 5 characters.";
    }
    // Used by the JUnit tests
    public String getUserNameMessage() {
        return validUserName
                ? "Username successfully captured."
                : "Username is not correctly formatted; "
                + "please ensure that your username contains an underscore and is no more "
                + "than five characters in length.";
    }
   
    public String getUserNameFeedback() {
        if (userName == null || userName.isEmpty()) {
            validUserName = false;
            return "Username cannot be empty.";
        }
        if (userName.length() > 5) {
            validUserName = false;
            return " Too long: max 5 characters. Shorten your username.";
        }
        if (!userName.contains("_")) {
            validUserName = false;
            return "Missing '_': add an underscore in your username.";
        }
        validUserName = true;
        return " Username successfully captured.";
    }
    // =========================
    // PASSWORD
    // =========================
    public boolean checkPasswordComplexity() {
        validPassword = password != null
                && password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[0-9].*")
                && password.matches(".*[^a-zA-Z0-9].*");
        return validPassword;
    }
    // Used by the main program
    public String getPasswordMessage(boolean valid) {
        return valid
                ? "Password successfully captured."
                : "Password is not correctly formatted; "
                + "please ensure it has at least 8 characters, "
                + "an uppercase letter, a number, and a special character.";
    }
    // Used by the JUnit tests
    public String getPasswordMessage() {
        return validPassword
                ? "Password successfully captured."
                : "Password is not correctly formatted; "
                + "please ensure that the password contains at least eight characters, "
                + "a capital letter, a number, and a special character.";
    }
   
    public String getPasswordFeedback() {
        if (password == null || password.isEmpty()) {
            validPassword = false;
            return "❌ Password cannot be empty.";
        }
        StringBuilder msg = new StringBuilder();
        boolean ok = true;
        if (password.length() < 8) {
            msg.append(" Need at least 8 characters. ");
            ok = false;
        }
        if (!password.matches(".*[A-Z].*")) {
            msg.append("Need 1 uppercase letter (A-Z). ");
            ok = false;
        }
        if (!password.matches(".*[0-9].*")) {
            msg.append(" Need 1 number (0-9). ");
            ok = false;
        }
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            msg.append(" Need 1 special character (!@#$ etc). ");
            ok = false;
        }
        validPassword = ok;
        return ok ? "Password successfully captured." : msg.toString().trim();
    }
    // =========================
    // CELL PHONE
    // =========================
    public boolean checkCellPhoneNumber() {
        validCellPhoneNumber = CellPhoneNumber != null
                && CellPhoneNumber.matches("^\\+27[0-9]{9}$");
        return validCellPhoneNumber;
    }
    // Used by the main program
    public String getCellMessage(boolean valid) {
        return valid
                ? "Cell phone number successfully captured."
                : "Cell phone number is not correctly formatted; "
                + "please include a country code, for example +27838968976.";
    }
    // Used by the JUnit tests
    public String getCellMessage() {
        return validCellPhoneNumber
                ? "Cell phone number successfully added."
                : "Cell phone number incorrectly formatted or does not contain international code.";
    }
 
    public String getCellFeedback() {
        if (CellPhoneNumber == null || CellPhoneNumber.isEmpty()) {
            validCellPhoneNumber = false;
            return " Cell number cannot be empty.";
        }
        if (!CellPhoneNumber.startsWith("+")) {
            validCellPhoneNumber = false;
            return "Start with + e.g. +27...";
        }
        if (!CellPhoneNumber.substring(1).matches("27\\d{9}")) {
            validCellPhoneNumber = false;
            return " Use 9 digits after +27, no spaces.";
        }
        validCellPhoneNumber = true;
        return "Cell phone number successfully captured.";
    }
    // =========================
    // REGISTER USER
    // =========================
    public String registerUser(String username, String password,
                               String cellPhone, String firstName,
                               String lastName) {
        registeredUserName = username;
        registeredPassword = password;
        registeredFirstName = firstName;
        registeredLastName = lastName;
        return "Registration successful for "
                + registeredFirstName + " "
                + registeredLastName + ".";
    }
    // =========================
    // LOGIN USER
    // =========================
    public boolean loginUser(String username, String password) {
        return username != null
                && password != null
                && username.equals(registeredUserName)
                && password.equals(registeredPassword);
    }
    // =========================
    // LOGIN STATUS
    // =========================
    public String returnLoginStatus(boolean success) {
        return success
                ? "Welcome " + registeredFirstName + " "
                + registeredLastName
                + " , it is great to see you again."
                : "Username or password incorrect, please try again.";
    }
    // =========================
    // MAIN METHOD
    // =========================
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Login_app auth = new Login_app("", "", "");
            String username;
            String password;
            String cellPhone;
            String firstName;
            String lastName;
            System.out.println("======================================");
            System.out.println("  RegistrationAndLoginFeature ");
            System.out.println("======================================\n");
            // =========================
            // USERNAME
            // =========================
            do {
                System.out.println("Enter username: ");
                username = input.nextLine().trim();
                auth.userName = username;
                System.out.println(auth.getUserNameFeedback());
            } while (!auth.validUserName);
            System.out.println();
            // =========================
            // PASSWORD
            // =========================
            do {
                System.out.println("Enter password: ");
                password = input.nextLine().trim();
                auth.password = password;
                System.out.println(auth.getPasswordFeedback());
            } while (!auth.validPassword);
            System.out.println();
            // =========================
            // CELL PHONE
            // =========================
            do {
                System.out.println("Enter cell phone: ");
                cellPhone = input.nextLine().trim();
                auth.CellPhoneNumber = cellPhone;
                System.out.println(auth.getCellFeedback());
            } while (!auth.validCellPhoneNumber);
            System.out.println();
            // =========================
            // NAMES
            // =========================
            System.out.println("Enter first name: ");
            firstName = input.nextLine().trim();
            System.out.println("Enter last name: ");
            lastName = input.nextLine().trim();
            // =========================
            // REGISTER
            // =========================
            String result = auth.registerUser(
                    username,
                    password,
                    cellPhone,
                    firstName,
                    lastName
            );
            System.out.println("\n" + result + "\n");
            // =========================
            // LOGIN
            // =========================
            System.out.println("--- LOGIN ---");
            System.out.println("Enter username to login: ");
            String loginUser = input.nextLine().trim();
            System.out.println("Enter password to login: ");
            String loginPass = input.nextLine().trim();
            boolean success = auth.loginUser(
                    loginUser,
                    loginPass
            );
            System.out.println("\n" + auth.returnLoginStatus(success));
        }
    }
}

