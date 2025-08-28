Book Manager API
Hey there! 👋 This guide will walk you through how to get the Book Manager API up and running, and how to use its various endpoints step-by-step.

1. Getting Started: Setup and Run the Application
This section covers everything you need to do before you can start interacting with the API.

Step 1: Prerequisites

Before you begin, make sure you have these installed on your system:

Java Development Kit (JDK) 21 or higher.

Apache Maven (which is already bundled if you cloned the project, but good to have if you're building from scratch).

Step 2: Clone the Repository

First, you'll need to get the project files onto your local machine.

Open your terminal or command prompt.

Run the following command:

git clone https://github.com/your-username/your-repo-name.git

(Remember to replace your-username and your-repo-name with your actual GitHub username and repository name.)

Navigate into the cloned directory:

cd your-repo-name

Step 3: Run the Spring Boot Application

Now that you have the code, let's start the API server.

Option A: Using an IDE (Recommended for Development)

Open your favorite Java IDE (like IntelliJ IDEA, Eclipse, or VS Code with Java extensions).

Import the project as a Maven project.

Locate the Manager.java file (it's usually in src/main/java/.../Manager.java).

Right-click on the main method within Manager.java and select "Run 'Manager.main()'".

Option B: Using the Terminal

Make sure you are in the root directory of your project (where the pom.xml file is located).

Execute the following command to start the application:

./mvnw spring-boot:run

You'll see logs in your terminal, and once it's ready, you'll typically see a message indicating that the application has started on port 8080. For example: Started Manager in X.XXX seconds (process running for X.XXX)

The API will now be accessible at http://localhost:8080.

2. API Usage Basics
Once the application is running, you can start making requests to its endpoints.

Tools for Interaction

You can use various tools to send HTTP requests to the API:

Postman: A popular desktop application for API testing.

Insomnia: Another great desktop API client.

curl: A command-line tool, perfect for quick testing. All examples below use curl.

Web Browser: For simple GET requests, you can paste the URL directly into your browser.

Base URL

All the API endpoints listed below start with this base URL: http://localhost:8080/Books

3. Detailed API Endpoints: Step-by-Step Guide
Let's go through each API endpoint with instructions and curl examples.

3.1. Add a New Book (POST /Books) ➕

This is how you add a new book record to the system.

What it does: Creates a new book entry.

Method: POST

Endpoint: /Books

Content-Type: application/json (You must specify this in the header).

Request Body: You need to send a JSON object containing the book's id, title, author, and price.

{
    "id": 1,
    "title": "The Lord of the Rings",
    "author": "J.R.R. Tolkien",
    "price": 25.50
}

curl Example:

curl -X POST -H "Content-Type: application/json" -d '{"id": 1, "title": "The Lord of the Rings", "author": "J.R.R. Tolkien", "price": 25.50}' http://localhost:8080/Books

Tip: After running this, the API will respond with the newly added book object.

3.2. Get All Books (GET /Books) 📚

Want to see all the books currently in the collection?

What it does: Retrieves a list of all books stored in the system.

Method: GET

Endpoint: /Books

curl Example:

curl http://localhost:8080/Books

Tip: You can also paste http://localhost:8080/Books directly into your web browser.

3.3. Get Book by ID (GET /Books/{id}) 🔍

Find a specific book using its unique identifier.

What it does: Fetches a single book record by its ID.

Method: GET

Endpoint: /Books/{id} (Replace {id} with the actual ID, e.g., /Books/1)

curl Example (for book with ID 1):

curl http://localhost:8080/Books/1

Tip: Similar to getting all books, you can use your browser for this: http://localhost:8080/Books/1.

3.4. Update Book (PUT /Books/{id}) ✍️

Modify the details of an existing book.

What it does: Updates the details (title, author, price) of a book identified by its ID.

Method: PUT

Endpoint: /Books/{id} (Replace {id} with the book's ID, e.g., /Books/1)

Content-Type: application/json

Request Body: Provide the complete updated book object. The id in the body should match the id in the URL.

{
    "id": 1,
    "title": "The Hobbit",
    "author": "J.R.R. Tolkien",
    "price": 18.75
}

curl Example (to update book with ID 1):

curl -X PUT -H "Content-Type: application/json" -d '{"id": 1, "title": "The Hobbit", "author": "J.R.R. Tolkien", "price": 18.75}' http://localhost:8080/Books/1

Tip: The API will respond with a success message if updated, or "Book not found." otherwise.

3.5. Delete Book (DELETE /Books/{id}) 🗑️

Remove a book from the collection.

What it does: Deletes a book record based on its ID.

Method: DELETE

Endpoint: /Books/{id} (Replace {id} with the book's ID, e.g., /Books/1)

curl Example (to delete book with ID 1):

curl -X DELETE http://localhost:8080/Books/1

Tip: The API will respond with a success message if deleted, or "Book not found." otherwise.

3.6. Get Books by Author (GET /Books/Search?author={author_name}) 🧑‍💻

Find all books written by a particular author.

What it does: Retrieves a list of books where the author matches the provided name (case-insensitive).

Method: GET

Endpoint: /Books/Search?author={author_name} (Replace {author_name} with the author's full name, e.g., J.R.R. Tolkien)

curl Example (searching for "J.R.R. Tolkien"):

curl "http://localhost:8080/Books/Search?author=J.R.R.%20Tolkien"

Note: J.R.R.%20Tolkien is the URL-encoded version of "J.R.R. Tolkien" (spaces become %20).

Tip: In a browser, you can just type http://localhost:8080/Books/Search?author=J.R.R. Tolkien.

3.7. Get Books Cheaper Than or Equal to a Price (GET /Books/Filter?price={price_value}) 💰

List books that are within a certain budget.

What it does: Retrieves all books with a price less than or equal to the specified price_value.

Method: GET

Endpoint: /Books/Filter?price={price_value} (Replace {price_value} with a numeric price, e.g., 20.00)

curl Example (for books cheaper than or equal to 20.00):

curl "http://localhost:8080/Books/Filter?price=20.00"

Tip: In a browser, use http://localhost:8080/Books/Filter?price=20.00.

3.8. Get Total Number of Books (GET /Books/Count) #️⃣

Quickly check how many books are in your collection.

What it does: Returns the total count of all books currently managed by the API.

Method: GET

Endpoint: /Books/Count

curl Example:

curl http://localhost:8080/Books/Count

Tip: Browser friendly: http://localhost:8080/Books/Count.

3.9. Get Most Expensive Book (GET /Books/Max-Price) 💎

Find out which book has the highest price.

What it does: Returns the single book object that has the highest price.

Method: GET

Endpoint: /Books/Max-Price

curl Example:

curl http://localhost:8080/Books/Max-Price

Tip: Browser friendly: http://localhost:8080/Books/Max-Price.

