# G3B7_SpringMVC_GradedCodingAssignment-3

Summary of what we accomplished for the Ticket Tracker application:

1. **Project Setup**:
   - Initialized a Maven project for a Spring Boot web application.
   - Configured dependencies including Spring Boot Starter, Spring Data JPA, Thymeleaf, MySQL Connector, and Lombok.

2. **Data Model**:
   - Created a `Ticket` entity class with attributes like `id`, `title`, `description`, `content`, `createdDate`.
   - Utilized Lombok annotations for cleaner code, reducing boilerplate.

3. **Database Integration**:
   - Configured MySQL database connection in `application.properties`.
   - Implemented Spring Data JPA repository to perform CRUD operations on the `Ticket` entity.

4. **Controller Layer**:
   - Created a `TicketController` class with methods for handling various HTTP requests:
     - `GET /tickets`: List all tickets.
     - `GET /tickets/{id}`: View details of a specific ticket.
     - `GET /tickets/new`: Display a form to create a new ticket.
     - `POST /tickets`: Handle form submission for creating a new ticket.
     - `GET /tickets/edit/{id}`: Display a form to edit an existing ticket.
     - `POST /tickets/edit/{id}`: Handle form submission for updating an existing ticket.
     - `GET /tickets/delete/{id}`: Display confirmation to delete a ticket.
     - `POST /tickets/delete/{id}`: Handle ticket deletion.

5. **Thymeleaf Templates**:
   - Created Thymeleaf templates for listing tickets, viewing ticket details, creating a new ticket, and editing existing tickets.
   - Utilized Thymeleaf expressions to dynamically display ticket data in HTML forms and tables.

6. **Service Layer**:
   - Implemented a `TicketService` class to handle business logic, including interactions with the repository.
   - Encapsulated CRUD operations within the service layer for separation of concerns.

7. **User Interface**:
   - Designed a user interface with Bootstrap for a clean and responsive layout.
   - Implemented form validation and error handling for user inputs.

8. **Error Handling**:
   - Implemented error handling for scenarios such as invalid form submissions and incorrect routes.
   
9. **Testing and Debugging**:
    - Addressed issues related to Thymeleaf template parsing, ensuring correct usage of Thymeleaf expressions.
    - Debugged and fixed errors related to form submissions and database interactions.

These steps resulted in a functional Ticket Tracker application where users can create, view, edit, and delete tickets through a user-friendly web interface. The application is built using Spring Boot, Thymeleaf, and MySQL, providing a seamless user experience for managing tickets.
