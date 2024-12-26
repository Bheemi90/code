package javaversion;

public class UserRegistration {
    private static int numberOfEmployees = 0;

    public static String determineUserType(String email, String companyDomain) {
        return email.contains(companyDomain) ? "EMPLOYEE" : "CUSTOMER";
    }

    public static boolean changeEmail(User user, String newEmail, String companyDomain) {
        if (user.isEmailConfirmed()) {
            String oldEmail = user.getEmail();
            user.setEmail(newEmail);
            user.setEmailConfirmed(false); // Mark the new email as unconfirmed

            // Check and update user type based on the new email
            String newUserType = determineUserType(newEmail, companyDomain);
            if (!newUserType.equals(user.getUserType())) {
                // Update the number of employees based on type change
                if (user.getUserType().equals("EMPLOYEE")) {
                    numberOfEmployees--; // If an employee is changing to customer, decrease count
                } else {
                    numberOfEmployees++; // If a customer is changing to employee, increase count
                }
                user.setUserType(newUserType);
            }

            // Notify the mail service that the email was changed
            Mailer.sendEmailUpdateNotification(user.getEmail());
            return true;
        }
        return false;
    }

    public static int getNumberOfEmployees() {
        return numberOfEmployees;
    }
}
