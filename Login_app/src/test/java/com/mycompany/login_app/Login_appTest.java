/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login_app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Student
 */
public class Login_appTest {

    public Login_appTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Login_app.main(args);
    }

   

    @Test
    public void testUserNameMessageCorrect() {
        Login_app login = new Login_app(
                "S_phe",
                "Sphelele@07",
                "+27836935189"
        );

        login.checkUserName();

        assertEquals(
                "Username successfully captured.",
                login.getUserNameMessage()
        );
    }
    
    public void testUserNameMessageInCorrect(){
        Login_app user = new Login_app("S_pheee","Sphelele_09", "+27836935189");
        assertEquals("""
                     "Username is not correctly formated,"
                                     + "please ensure that your username "
                                     + "contains an underscore and is not"
                                     + "more than five characters in length""",user.getUserNameMessage());  
}
//    @Test
//    public void testUserNameMessageInCorrect() {
//        Login_app login = new Login_app(
//                "Sphe",
//                "Sphelele@07",
//                "+27836935189"
//        );
//
//        login.checkUserName();
//
//        String expected =
//                "Username is not correctly formatted; "
//                + "please ensure that your username contains an underscore and is not more "
//                + "than five characters in length.";
//
//        assertEquals(expected, login.getUserNameMessage());
//    }

    @Test
    public void testUserNameReturnTrue() {
        Login_app login = new Login_app(
                "S_phe",
                "Sphelele@07",
                "+27836935189"
        );

        assertTrue(login.checkUserName());
    }

    @Test
    public void testUserNameReturnFalse() {
        Login_app login = new Login_app(
                "Sphe",
                "Sphelele@07",
                "0836935189"
        );

        assertFalse(login.checkUserName());
    }

   

    @Test
    public void testPasswordMessageCorrect() {
        Login_app login = new Login_app(
                "S_phe",
                "Sphelele@07",
                "+27836935189"
        );

        login.checkPasswordComplexity();

        assertEquals(
                "Password successfully captured.",
                login.getPasswordMessage()
        );
    }

    @Test
    public void testPasswordInCorrectMessage() {
        Login_app login = new Login_app(
                "S_phe",
                "Sphelele",
                "+27836935189"
        );

        login.checkPasswordComplexity();

        String expected =
                "Password is not correctly formatted; "
                + "please ensure that the password contains at least eight characters, "
                + "a capital letter, a number, and a special character.";

        assertEquals(expected, login.getPasswordMessage());
    }

    @Test
    public void testPasswordReturnTrue() {
        Login_app login = new Login_app(
                "S_phe",
                "Sphelele@07",
                "+27836935189"
        );

        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testPasswordReturnFalse() {
        Login_app login = new Login_app(
                "S_phe",
                "Sphelele",
                "+27836935189"
        );

        assertFalse(login.checkPasswordComplexity());
    }

   

    @Test
    public void testCellPhoneNumberCorrect() {
        Login_app login = new Login_app(
                "S_phe",
                "Sphelele@07",
                "+27836935189"
        );

        login.checkCellPhoneNumber();

        assertEquals(
                "Cell phone number successfully added.",
                login.getCellMessage()
        );
    }

    @Test
    public void testCellPhoneNumberInCorrect() {
        Login_app login = new Login_app(
                "S_phe",
                "Sphelele@07",
                "0836935189"
        );

        login.checkCellPhoneNumber();

        String expected =
                "Cell phone number incorrectly formatted or does not contain international code.";

        assertEquals(expected, login.getCellMessage());
    }

    @Test
    public void testCellPhoneReturnTrue() {
        Login_app login = new Login_app(
                "S_phe",
                "Sphelele@07",
                "+27836935189"
        );

        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneReturnFalse() {
        Login_app login = new Login_app(
                "S_phe",
                "Sphelele@07",
                "0836935189"
        );

        assertFalse(login.checkCellPhoneNumber());
    }
}

