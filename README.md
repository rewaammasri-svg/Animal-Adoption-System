# Animal Adoption System

A comprehensive desktop application designed to streamline animal shelter operations by managing animal admissions, 
tracking adopter registrations, and logging successful adoptions.

---

## Project Type: JavaFX GUI

This application is built with a **Graphical User Interface (GUI)** using **JavaFX**. It features an interactive sidebar navigation menu, dynamic form pages, and real-time list updates, completely eliminating the need for command-line interaction.

---

# Main Features

## Animal Management
Add animals categorized by species (**Dog, Cat, Bird**) with unique IDs, age, gender, and adoption status tracking.

## Adopter Registration
Maintain a database of registered adopters including their contact information and physical addresses.

## Adoption Transaction Processing
Pair available animals with registered adopters while automatically updating the animal status to **"Adopted"**.

## Flat-File Database Persistent Storage
The system automatically saves and loads all data using text files:

- `animals.txt`
- `adopters.txt`
- `adoptions.txt`

This ensures that data is not lost after closing the application.

## Dynamic Reports & Analytics
The system provides reports showing:

- Total registered animals
- Total adopters
- Total adoptions
- Available animals
- Adopted animals

---

# OOP Concepts Used

This project demonstrates the main principles of **Object-Oriented Programming (OOP)**:

## 1. Inheritance

The abstract `Animal` class acts as a parent class that is extended by:

- `Dog`
- `Cat`
- `Bird`

These subclasses inherit common attributes and behaviors while representing different animal types.

---

## 2. Polymorphism

### Method Overriding
The subclasses override the abstract `getType()` method to return their specific animal type.

### Dynamic Binding
Different animal objects are handled using `Animal` references in classes such as:

- `FileManager`
- `AdoptionGUI`

---

## 3. Encapsulation

All attributes in the main classes:

- `Animal`
- `Adopter`
- `Adoption`

are declared as private and accessed through:

- Getters
- Setters
- Constructors

This protects data and controls how information is modified.

---

## 4. Abstraction

The `Animal` class is declared as an **abstract class** to prevent creating direct Animal objects and to provide a common template for all animal types.

---

# Main Classes

## Main
The starting point of the application. It manages:

- Loading data when the program starts.
- Saving data before closing.
- Coordinating system operations.

## AdoptionGUI
Controls the JavaFX graphical user interface, including:

- Interface layouts using `BorderPane` and `VBox`.
- Navigation between pages.
- User input validation.

## FileManager
Handles file operations:

- Reading data from text files.
- Writing data to text files.
- Saving and restoring system information.

## Animal (Abstract)
The base class for all animals. It contains:

- ID
- Name
- Age
- Gender
- Adoption Status

## Dog / Cat / Bird
Subclasses representing different animal species in the shelter.

## Adopter
Represents a person who wants to adopt an animal and stores adopter details.

## Adoption
Represents the adoption relationship between an `Animal` and an `Adopter`.

---

# How to Run the Project

## Prerequisites

- Java Development Kit (**JDK 11 or higher**)
- JavaFX SDK configured in your IDE

Supported IDEs:

- NetBeans
- IntelliJ IDEA
- Eclipse

---

## Run via IDE

1. Open the project folder in your IDE.

2. Configure the JavaFX SDK library path.

3. Add the following VM Options:

```bash
--module-path "/path/to/javafx-sdk/lib" --add-modules javafx.controls
```

4. Run the `Main` class.

---

# AI Usage Declaration

ChatGPT was used as a learning assistant during the development of this project. 
It helped me understand how to build the JavaFX GUI step by step, explain the code structure,
and clarify programming concepts related to the interface. The project implementation, 
testing, and final decisions were completed by the students.

---

# Students

- Noor Ashraf Hassan Khattab — 2549011048  
- Rewaa Mohammed Ghazi Almasri — 2549011052  
- Raghad Ghassan Ali Jabr — 2549011057
