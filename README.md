# UI Test Automation – Java (Take-Home Assignment)

## Overview
Overview

This repository contains a UI Test Automation framework developed as part of an interview take-home assignment.
The goal of this project is to demonstrate:
- Clean test automation design
- Readable and maintainable test code
- Sensible framework structure
- Practical use of Java-based UI automation tools

- The framework is intentionally kept simple, clear, and extensible, focusing on correctness and best practices rather than over-engineering.

## Tech Stack
- Java (17+)
- Maven – build and dependency management
- Selenium WebDriver – browser automation
- TestNG – test execution and assertions
- Page Object Model (POM) – UI abstraction

## Design Approach
### Page Object Model (POM)
- Each page is represented by a dedicated class
- UI locators and actions are encapsulated
- Tests focus on behavior, not implementation details

### Separation of Concerns
- Tests describe scenarios
- Pages handle UI interactions
- Base / Utils manage setup, configuration, and helpers

### Readability First
- Minimal magic
- Explicit waits instead of hard sleeps
- Clear method names aligned with user actions

## Running the Tests
```
mvn test
```

## Reporting
Test results are available via TestNG default reports. Output is generated under:
`target/surefire-reports`