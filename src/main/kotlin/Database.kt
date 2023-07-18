class Database {

    private val users: MutableList<MutableMap<String, String>> = mutableListOf(
        mutableMapOf(
            "userId" to "1",
            "email" to "alice@loglass.co.jp",
            "userType" to "EMPLOYEE",
            "isEmailConfirmed" to "true",
        ),
        mutableMapOf(
            "userId" to "2",
            "email" to "bob@loglass.co.jp",
            "userType" to "EMPLOYEE",
            "isEmailConfirmed" to "false",
        ),
        mutableMapOf(
            "userId" to "3",
            "email" to "michael@example.com",
            "userType" to "CUSTOMER",
            "isEmailConfirmed" to "true",
        ),
    )

    private var company: MutableMap<String, String> = mutableMapOf(
        "numberOfEmployees" to "2",
        "companyDomainName" to "loglass.co.jp",
    )

    fun getUserById(userId: String): MutableMap<String, String>? = users.find { it["userId"] == userId }

    fun saveUser(newUser: MutableMap<String, String>) {
        val index = users.indexOfFirst { it["userId"] == newUser["userId"] }
        users[index] = newUser
    }

    fun getCompany(): MutableMap<String, String> = company

    fun saveCompany(newCompany: MutableMap<String, String>) {
        this.company = newCompany
    }
}
