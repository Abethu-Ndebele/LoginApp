# LoginApp
PROG5121 PoE Part 1 — Registration and Login Feature. Java application that validates username, password complexity and cellphone number format using regex. Includes console UI, JUnit tests and full validation flow.
## 📌 Student Information

| Detail | Information |
| :--- | :--- |
| **Student Name** | Abethu Sphelele Ndebele |
| **Student NO** | *[ST10533948]* |
| **Module** | Software Development / Programming (Java) |
| **Institution** | Rosebank College |
| **IDE Used** | Apache NetBeans |

---

## ✨ Key Features

> [!NOTE]
> All user inputs are validated in real-time using interactive console feedback before saving records to memory.

* ** Username Validation**
  * Maximum length of **5 characters**.
  * Must contain at least one **underscore (`_`)**.
* ** Password Complexity**
  * Minimum length of **8 characters**.
  * Requires at least **1 uppercase letter (`A-Z`)**.
  * Requires at least **1 numeric digit (`0-9`)**.
  * Requires at least **1 special character** (`!@#$%^&*` etc.).
* ** Cell Phone Number Formatting**
  * Validates South African international format via Regular Expressions (`^\+27[0-9]{9}$`).
  * Enforces the `+27` country code followed by **9 digits**.
* ** Automated Unit Testing**
  * Full unit test suite using **JUnit** to verify positive, negative, and string-matching conditions.

---

## 📂 Project Architecture

```text
📁 src/
 ├── 📄 Login_app.java # Main CLI engine, validation & loops
 ├── 📄 UserRegistrationAndLoginFeature.java # Helper class for string sanitization
 └── 📄 Login_appTest.java # Automated JUnit test suite

## Application Features

1. **Username Validation:**
   * Ensures the username is no longer than 5 characters in length.
   * Mandates the inclusion of an underscore (`_`).

2. **Password Complexity Check:**
   * Enforces a minimum length of 8 characters.
   * Requires at least one uppercase letter (`A-Z`).
   * Requires at least one numerical digit (`0-9`).
   * Requires at least one special character (e.g., `!@#$%^&*`).
.
3. **Cell Phone Number Format Check:**
   * Validates international formatting using Regular Expressions (`^\+27[0-9]{9}$`).
   * Requires South Africa's country code (`+27`) followed by exactly 9 numerical digits.

4. **User Registration & Interactive Login Loop:**
   * Solicits validated credentials from the user via an interactive console interface (`Scanner`).
   * Evaluates input using `do-while` control loops to continuously prompt until valid credentials are provided.
   * Validates login attempts against registered account records in memory.

5. **Automated Unit Testing:**
   * Integrated JUnit test suite verifying both boundary conditions (positive/negative test paths) and exact system message outputs​

​📚 References
Bloch, J., 2018. Effective Java. 3rd ed. Boston: Addison-Wesley Professional.
​Deitel, P.J. and Deitel, H.M., 2017. Java How to Program: Early Objects. 11th ed. Upper Saddle River, NJ: Pearson Education.
​JUnit Team, 2024. JUnit 5 User Guide. [online] JUnit.org. Available at: https://junit.org/junit5/docs/current/user-guide/ [Accessed 18 September 2026].
​Oracle, 2024. Java Platform, Standard Edition Documentation - Class Pattern (java.util.regex). [online] Oracle Documentation. Available at: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/regex/Pattern.html [Accessed 18 September 2026].
