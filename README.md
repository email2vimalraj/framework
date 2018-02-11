# Test Automation Framework
A simple test automation framework which provides the following features:

- TestNG based framework
- Use `@NeedBrowser` annotation on Test method for automatic driver management
- Or, use `browserName` parameter in the TestNG suite xml to manage browser driver initiations
- Out of the box parallel execution ready framework
- Using [SimpleSe](https://github.com/RationaleEmotions/SimpleSe) to auto manage the page objects from the simple json files
- Integrated with [TestNG Extent Reporter](https://github.com/email2vimalraj/TestNGExtentsReport) 

## Pre-requisites

- JDK 8+
- Maven 3.x+
- Any IDE for development

## Setup

- Clone this repo
- Run `mvn clean install` from the cloned directory
- Run `mvn clean test` to run the sample test
