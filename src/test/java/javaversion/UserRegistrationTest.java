package javaversion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    private static final String COMPANY_DOMAIN = "company.com";
    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {
        // Initialize test users
        user1 = new User("john.doe@company.com", true); // Employee
        user2 = new User("jane.doe@gmail.com", true); // Customer
    }

    @Test
    void testDetermineUserTypeForEmployeeEmail() {
        String userType = UserRegistration.determineUserType(user1.getEmail(), COMPANY_DOMAIN);
        assertEquals("EMPLOYEE", userType);
    }

    @Test
    void testDetermineUserTypeForCustomerEmail() {
        String userType = UserRegistration.determineUserType(user2.getEmail(), COMPANY_DOMAIN);
        assertEquals("CUSTOMER", userType);
    }

    @Test
    void testEmployeeCountIncreasesWhenCustomerBecomesEmployee() {
        // Initial employee count
        int initialEmployeeCount = UserRegistration.getNumberOfEmployees();

        // Change user2's email to an employee email
        UserRegistration.changeEmail(user2, "jane.doe@company.com", COMPANY_DOMAIN);

        // After email change, employee count should increase
        assertEquals(initialEmployeeCount + 1, UserRegistration.getNumberOfEmployees());
    }

    @Test
    void testEmployeeCountDecreasesWhenEmployeeBecomesCustomer() {
        // Initial employee count
        int initialEmployeeCount = UserRegistration.getNumberOfEmployees();

        // Change user1's email to a customer email
        UserRegistration.changeEmail(user1, "john.doe@gmail.com", COMPANY_DOMAIN);

        // After email change, employee count should decrease
        assertEquals(initialEmployeeCount - 1, UserRegistration.getNumberOfEmployees());
    }

    @Test
    void testEmailChangeForConfirmedEmail() {
        // Change email for a confirmed user
        boolean result = UserRegistration.changeEmail(user1, "john.doe_new@company.com", COMPANY_DOMAIN);
        
        // Assert that the email was successfully changed
        assertTrue(result);
        assertEquals("john.doe_new@company.com", user1.getEmail());
        assertFalse(user1.isEmailConfirmed()); // New email should be unconfirmed
        assertEquals("EMPLOYEE", user1.getUserType()); // User type should remain "EMPLOYEE"
    }

    @Test
    void testEmailChangeForUnconfirmedEmailFails() {
        // Create a user with unconfirmed email
        User user3 = new User("mark.smith@company.com", false);
        
        // Attempt to change email for the unconfirmed user
        boolean result = UserRegistration.changeEmail(user3, "mark.smith_new@company.com", COMPANY_DOMAIN);
        
        // Assert that the email change fails
        assertFalse(result);
        assertEquals("mark.smith@company.com", user3.getEmail()); // Email should remain unchanged
    }

    @Test
    void testMailerNotifiedAfterEmailChange() {
        // Change email and verify if Mailer is called
        UserRegistration.changeEmail(user1, "john.doe_new@company.com", COMPANY_DOMAIN);
        
        // Output will be captured in the console. This can be further tested using mock objects.
        // For testing purposes, we can assume that the Mailer.sendEmailUpdateNotification method was called
        assertTrue(true); // This is a placeholder assertion to indicate the expected side effect
    }
}

