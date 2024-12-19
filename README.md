# 日本語はREADME.ja.mdをご覧ください

# Problem

- Implement and refactor the test code for the process of changing the user's email address while satisfying the specifications described below.
- Some parts of the specifications described below are not fully implemented. Please read the source code and implement it according to the specifications.
- As a guideline for refactoring, consider appropriately extracting the data processed within the system into models, and separating the business logic and the processes that interact with external systems (such as databases or email services). This system is expected to undergo continuous development, so please refactor with that in mind.
- When adding new classes or methods during refactoring, briefly document in the code comments what you added and why.
- Ensure that all newly added test cases pass.
- There is no need to implement beyond the specifications described below. While it's true that, strictly speaking, email addresses should not allow empty strings or should follow a certain format, there's no need to implement such validations this time. Similarly, you do not need to implement any other specifications that would be considered common sense.
- Versions in both Kotlin and Java are provided. Please choose one of the languages and implement the task in that language.

# Specifications

- If the user's email address contains the company's domain name, the user's type (`userType`) should be registered as an employee (`EMPLOYEE`). If not, the user should be registered as a customer (`CUSTOMER`).
- The system should manage the number of employees (`numberOfEmployees`) among the registered users. If the user's type changes from employee to customer, the employee count should decrease. Conversely, if the user's type changes from customer to employee, the employee count should increase.
- Once the email address is successfully changed, the system should send a message to the mail service (`Mailer`) to notify external systems that the email address has been updated.
- Only the current email address that is confirmed (`isEmailConfirmed`) can be changed.
- The updated email address should be saved as unconfirmed.

# Constraints

- Treat `Database.kt` as an equivalent to an RDBMS (e.g., MySQL).
- Do not modify the implementation of `Database.kt`, but moving the file is allowed.
- Treat `Mailer.kt` as a service that sends messages through an external mail service (e.g., SendGrid). When called, it will actually invoke the external mail service and send a message.
- Do not modify the implementation of `Mailer.kt`, but moving the file is allowed.
- You are free to define packages, layers, etc. You may also freely add classes and methods.
- You can import and use any necessary libraries, including testing libraries. Test cases can be written in either Japanese or English.


# Environment Setup

```
// Download OpenJDK 11 (for Mac)
brew install --cask temurin@11

// Run Main.kt (Note: Main.kt is not part of the evaluation)
./gradlew run

// Run the tests
./gradlew test
```

# Evaluation Criteria
The following criteria will be evaluated in order of priority:

- **Code Reading**
  - Can you understand the existing code and implement the missing specifications?
- **Test Code**
  - Can you extract test cases from the specifications and create an appropriate amount of test code in the right places while considering the pros and cons of testing at different layers? Can you explain your decision-making process?
  - Can you define how to handle external systems like `Database.kt` or `Mailer.kt` in the test code, while considering the maintainability and execution speed of the test code? Can you explain your decision-making process?
  - Can the test cases clearly convey the specifications of the target code just by reading them?
- **Modeling and Refactoring**
  - Can you define important logic from the specifications and organize them into appropriate models?
  - Can you explain why you assigned certain responsibilities to specific classes?

# Submission Instructions

- Zip the entire project, upload it to Google Drive, and send the shared link via email.
  - There is no need to submit files under directories like `.gradle`, `.idea`, `build`, `.git`, etc.
- It is prohibited to share the problem details externally. Do not push the project to a public GitHub repository or share it publicly in any other way.
- You can submit up to two times. To prevent spending too much time, you are allowed to submit once the project has reached a certain stage. If you submit twice, the first submission will not be included in the evaluation.

