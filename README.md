# SDET Assignment

## Overview
This project contains automated tests to verify that all users from the city 'FanCode' have completed more than 50% of their todos tasks.

## Tools and Libraries Used
- Java
- RestAssured
- testng
- Maven

## Setup and Running the Tests

1. **Clone the repository:**
    ```sh
    git clone <repository-url>
    ```

2. **Navigate to the project directory:**
    ```sh
    cd sdet-assignment
    ```

3. **Run the tests using Maven:**
    ```sh
    mvn test
    ```

## Project Structure
- `src/test/java/Fancode/toDocheckerTest.java`: Contains the test cases.
- `pom.xml`: Maven configuration file with dependencies.
- `README.md`: This file.

## Test Scenario
1. Fetch all users.
2. Identify users belonging to the city 'FanCode' based on latitude and longitude.
3. Verify that these users have completed more than 50% of their todos tasks.
