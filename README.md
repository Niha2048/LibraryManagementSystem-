# Library Management System

## Overview
A Java-based Library Management System that helps librarians manage books, patrons, and lending processes.  
This project demonstrates Object-Oriented Programming (OOP), SOLID principles, and design patterns (Observer, Strategy).

## Features
- **Book Management**
  - Add, remove, update books
  - Search by title, author, or ISBN
- **Patron Management**
  - Add and update patron information
  - Track borrowing history
- **Lending Process**
  - Checkout and return books
- **Inventory Management**
  - Track available and borrowed books
- **Reservation System (Observer Pattern)**
  - Patrons can reserve books and get notified when available
- **Recommendation System (Strategy Pattern)**
  - Suggest books based on borrowing history or popularity
- **Logging**
  - Important events logged to `library.log`

## How to Run
1. Compile the source code:
   javac -d bin src/library/LibraryMain.java
  
2. Run the program:
   java -cp bin library.LibraryMain

## Design Patterns
- **Observer Pattern**: Reservation system notifies patrons when a book becomes available.
- **Strategy Pattern**: Recommendation system allows different algorithms for suggesting books.

## UseCase Diagram
- <img width="1570" height="1692" alt="UseCaseDiagram" src="https://github.com/user-attachments/assets/5da59907-1852-40f3-bc11-044355db20d5" />


## Logging
Uses `java.util.logging` to log events like checkout, return, and notifications.
