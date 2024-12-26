package javaversion;

public class Mailer {
    public static void sendEmailChangedMessage(String userId, String email) {
        System.out.printf("Sending email changed message to %s at %s%n", userId, email);
    }
    
    public static void sendEmailUpdateNotification(String newEmail) {
        System.out.println("Email update notification sent for: " + newEmail);
    }
}
