## Overview
**Personal Budget Manager** is an application that helps people to control their personal budget in an easy way.

## Features
> At this moment we don't have all these features implemented, but it is for provide a guide for release 1.0.

- Incomes and Outcomes registration
- Budget administration
  - Create, edit and delete budgets
  - Compare two or more budgets
- Account administration

## Motivation
This project is intended for learning purposes and also to implement an open source alternative to the personal budget administration.

We strive for quality and implement best practices.

## Tech Stack
This is a list of the most relevant technologies used in this project:

- Spring 4 (MVC, Security and Test)
- Hibernate 5
- JTwig
- AngularJS 1.x
- Bootstrap 3
- DBUnit
- HtmlUnit

## Project Structure
It is a multi-module Maven project. Next is a brief description of each one:

- **core**: contains the Domain Objects and Services.
- **web**: contains the web application files.
- **common-test-resources**: provides a common API for test resources like in-memory database connections, used for automatized tests.

## Questions and issues
If you have any question related with this project, please create a new issue on GitHub and use a **question** label.

For any feature, bug or enhancement you see please also create an issue and use the corresponding label.

## Contributing
All contributions are welcome. To contribute, please fork the project and send me a Pull Request.

Here are some basic rules for accept your contribution:

- Provide Unit tests if apply
> Project uses JUnit as core framework for this, but for readability reason tests have "Should" suffix instead of "Test"
- Follow standard Java Code Conventions
- **Do not break the build!**
- Clean code as possible:
  - Remove unused imports
  - Remove warnings
  - Do not leave two or more consecutive blank lines
  - Provide meaningful names for variables, methods and classes
  - Refactor as possible

## Licence
To be defined