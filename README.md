This repository contains the test tasks for the Quality Assurance position at Insider. 

---
### 1. Pencil testing 
 Describe the steps for comprehensively testing of a pencil with an eraser on one end.
   Cases for all types of testing (such as functional, usability, performance, load, stress,
   security, etc.) are expected here.

[Solution](documentation/pencilTesting.md)

---
### 2. hepsiburada.com analysis
On the Main page of https://www.hepsiburada.com/ you can see the different
   Recommendations section with different products. These sections are also shown
   on Product Detail and Cart pages. What are these product suggestions, what is the
   rule for listing these products and showing them to the user?
   Full analysis is expected here.

[Solution](documentation/hepsiburadaAnalysis.md)

---
### 3. Automate the scenario below:
1. Visit https://useinsider.com/ and check Insider home page is opened or not
2. Select “Company” menu in navigation bar, select “Careers” and check Career
   page, its Locations, Teams and Life at Insider blocks are opened or not
3. Go to https://useinsider.com/careers/quality-assurance/, click “See all QA
   jobs”, filter jobs by Location - Istanbul, Turkey and department - Quality
   Assurance, check presence of jobs list
4. Check that all jobs’ Position contains “Quality Assurance”, Department
   contains “Quality Assurance”, Location contains “Istanbul, Turkey”
5. Click “View Role” button and check that this action redirects us to Lever
   Application form page

- Test case should be written using any programming language and framework
  (Python or Java + Selenium would be preferable)
- No BDD(Cucumber, Quantum, Codeception, etc.) frameworks are allowed
- Test case should fully meet POM requirements
- Buttons, dropdowns and other elements should have optimized Xpath and
  CSS selectors
- Assertions should be used in test case
- Code should be clean and readable

[Solution](src/test/java/com/useinsider/UseInsiderTest.java) is implemented as code in the following repository using JAVA/Selenium with Maven.
To run the test locally, use `mvn clean test`
