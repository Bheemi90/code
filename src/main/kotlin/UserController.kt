class UserController(
    private val database: Database,
    private val mailer: Mailer,
) {

    fun changeEmail(userId: String, newEmail: String) {
        val user = database.getUserById(userId)!!

        val email = user["email"]!!
        val userType = user["userType"]!!

        if (email == newEmail) {
            return
        }

        val company = database.getCompany()
        val companyDomainName = company["companyDomainName"]!!
        val numberOfEmployees = company["numberOfEmployees"]!!.toInt()

        val emailDomain = newEmail.split("@")[1]

        val newType = if (emailDomain == companyDomainName) "EMPLOYEE" else "CUSTOMER"

        if (userType != newType) {
            val delta = if (newType == "EMPLOYEE") 1 else -1
            val newNumber = numberOfEmployees + delta
            company["numberOfEmployees"] = newNumber.toString()
            company["companyDomainName"] = emailDomain
            database.saveCompany(company)
        }

        user["email"] = newEmail
        user["userType"] = newType

        database.saveUser(user)
        mailer.sendEmailChangedMessage(userId, newEmail)
    }
}
