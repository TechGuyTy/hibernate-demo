## Lab 1: Hibernate Basics
- Add an entity to list working spaces. (Use XML config.) It includes
  - An auto-generated ID
  - Name of space
  - Number of seats in space
- Create a DAO and use it to...
  1. Write a test to add a new working space to the database
  2. Write a test to change the name of a space
  3. Write a test to delete a space
  4. Write a test to print out a list of all the spaces
  5. Write a test to print out a list of all the spaces that have at least 6 seats. Order the spaces alphabetically by name.
- For each of the above tests, write out (on paper or a text file) the SQL query or queries that Hibernate is using. Try without using the show_sql option; show_sql results are probably more complicated than you really need.

*NOTE:* You may want to clean out your database between exercises. You can DROP your tables or DELETE all the rows.

## Lab 2: More Complex Hibernate Usage
- Add fields to the working spaces
  - ID of nearest coffee maker
  - ID of one student claiming the space for their team
- Write a test to add a seat to the community table
- Write DAO methods to
  - claim a space for a student
    - throw an exception if the space is already claimed
  - un-claim a space
  - Write tests to test these DAO methods

## Lab 3: Aggregating Data
- Write a command line program
  - User enters the name of a working space
  - Print out
    1. the name of the space
    2. the number of seats
    3. the name of the student who has claimed the space
      - (if none, print "Unclaimed.")
    4. whether the nearest coffee maker requires manual fill
- Be sure to make use of the DAO pattern. All Hibernate session usage should be within a DAO class.

## Lab 4: Annotation Config
- Add an entity represent student lab scores. (Use Java Annotation config.) It includes
  - An auto-generated ID
  - ID of student
  - Number of Lab (ex: 1, 2, 28, etc...)
  - Name of Lab
  - Student's score on lab (a number from 1 to 10)
- Write a test to create one student lab score in the database and read it back by ID. Assert that all the fields have the expected values and that the ID is not null.

## Lab 5: Constraints and Transactions
Do not use the DAO pattern for this lab. Use the Hibernate session directly in your tests.
- Add a constraint to the working space table that nearest coffee pot cannot be null
- Write a test for each of the following...
  1. add a new student then create a new working space all in the same transaction. Commit the transaction. Then read back the student from the DB and print it.
  2. add a new student then create a new working space, but leave the coffee pot null. Surround the code with a try/catch that rolls back the transaction if there is an exception. Then read back the student from the DB and print it.
- Add a constraint to the working space table that the name must be unique (you can't have to spaces in the database with the same name).
- Write a test that attempts to add the two spaces with the same name. What happens?
