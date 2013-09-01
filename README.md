selenium-yatspec-petclinic
==========================

A Demonstration of using Selenium-Java and Yatspec for BDD style Selenium tests. Uses the Spring Pet Clinic application as a target.

Make sure you are using Maven 3 and JDK7 and have a recent Firefox installed.

You need to download and run the Spring PetClinic application separately:

> git clone https://github.com/SpringSource/spring-petclinic.git

> mvn tomcat7:run


Then download this project and run the tests from maven:

> git clone https://github.com/chrishumphreys/selenium-yatspec-petclinic.git

> cd selenium-yatspec-petclinic

> mvn clean install

Then open the Yatspec output in your browser. The location of the Yatspec output is written to the console
when running Maven:

e.g. 

> Yatspec output:

> /tmp/com/habitualcoder/springpetclinic/selenium/tests/OwnersTest.html

See Examples directory for pre-generated example output.

You can also run the tests from your IDE:

Open com/habitualcoder/springpetclinic/selenium/tests/OwnersTest.java

For reference there is also a pure JUnit example of the same tests:

Open com/habitualcoder/springpetclinic/selenium/tests/OwnersJUnitTest.java

