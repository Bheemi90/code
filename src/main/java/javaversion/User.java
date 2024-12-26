package javaversion;

public class User {
    private String email;
    private boolean isEmailConfirmed;
    private String userType;

    public User(String email, boolean isEmailConfirmed) {
        this.email = email;
        this.isEmailConfirmed = isEmailConfirmed;
        this.userType = "CUSTOMER"; // Default user type is "CUSTOMER"
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailConfirmed() {
        return isEmailConfirmed;
    }

    public void setEmailConfirmed(boolean emailConfirmed) {
        isEmailConfirmed = emailConfirmed;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
