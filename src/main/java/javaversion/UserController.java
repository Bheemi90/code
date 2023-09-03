package javaversion;

import java.util.*;

public class UserController {
    private final Database database;
    private final Mailer mailer;

    public UserController(Database database, Mailer mailer) {
        this.database = Objects.requireNonNull(database);
        this.mailer = Objects.requireNonNull(mailer);
    }

    public void changeEmail(String userId, String newEmail) {
        var user = database.getUserById(userId)
            .orElseThrow(() -> new RuntimeException("ユーザーが見つかりませんでした。ユーザーID: " + userId));

        var email = user.get("email");

        if (email.equals(newEmail)) {
            return;
        }

        var company = database.getCompany();
        var companyDomainName = company.get("companyDomainName");
        var numberOfEmployees = Integer.parseInt(company.get("numberOfEmployees"));

        var emailDomain = newEmail.split("@")[1];
        var newType = emailDomain.equals(companyDomainName) ? "EMPLOYEE" : "CUSTOMER";

        var delta = newType.equals("EMPLOYEE") ? 1 : -1;
        var newNumber = numberOfEmployees + delta;

        var newCompany = new HashMap<>(company);
        newCompany.put("numberOfEmployees", String.valueOf(newNumber));
        newCompany.put("companyDomainName", emailDomain);
        database.saveCompany(newCompany);

        var newUser = new HashMap<>(user);
        newUser.put("email", newEmail);
        newUser.put("userType", newType);

        database.saveUser(newUser);
        mailer.sendEmailChangedMessage(userId, newEmail);
    }
}
