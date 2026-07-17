#  Animal Adoption System

A desktop application developed using **Java** and **JavaFX** to manage animals, adopters, and adoption records. The system applies Object-Oriented Programming (OOP) concepts and stores data using text files.

---

#  Project Description

The **Animal Adoption System** is designed to help animal shelters organize the adoption process. It allows users to add animals, register adopters, perform adoption operations, generate reports, and save all data using text files.

This project was developed as part of the **Object-Oriented Programming (OOP)** course.

---

#  Main Features

## Animal Management
- Add new animals.
- Support different animal types (Dog, Cat, Bird).
- Store animal information.
- Track adoption status.

## Adopter Management
- Register adopters.
- Store adopter information.
- View adopter records.

## Adoption Management
- Adopt available animals.
- Prevent duplicate adoptions.
- Save adoption records.

## Reports
- Total animals.
- Available animals.
- Adopted animals.
- Total adopters.
- Total adoptions.

## File Handling

The application automatically saves and loads data using:

- `animals.txt`
- `adopters.txt`
- `adoptions.txt`

---

#  OOP Concepts Used

### Encapsulation
Private attributes are accessed through public getter and setter methods.

### Abstraction
The `Animal` class is implemented as an abstract class.

### Inheritance

```
Animal
├── Dog
├── Cat
└── Bird
```

### Polymorphism
Different animal types are handled using the `Animal` reference.

### Association
The `Adoption` class links an `Animal` object with an `Adopter` object.

---

# 📦 Main Classes

| Class | Responsibility | Key Attributes | Key Methods |
|------|----------------|----------------|-------------|
| **Main** | Starts the application, loads/saves data, and manages animals, adopters, and adoptions. | `animals`, `adopters`, `adoptions`, `fileManager` | `loadData()`, `saveData()`, `addAnimal()`, `addAdopter()`, `adoptAnimal()` |
| **Animal** *(Abstract)* | Defines the common properties and behaviors shared by all animals. | `id`, `name`, `age`, `gender`, `adopted` | `getType()`, `isAdopted()`, `setAdopted()` |
| **Dog** | Represents a dog available for adoption. | Inherited from `Animal` | `getType()` |
| **Cat** | Represents a cat available for adoption. | Inherited from `Animal` | `getType()` |
| **Bird** | Represents a bird available for adoption. | Inherited from `Animal` | `getType()` |
| **Adopter** | Stores adopter information. | `id`, `name`, `phone`, `address` | Getters, `toString()` |
| **Adoption** | Represents an adoption record between an animal and an adopter. | `animal`, `adopter`, `date` | Getters, `toString()` |
| **FileManager** | Saves and loads application data using text files. | — | `saveAnimals()`, `loadAnimals()`, `saveAdopters()`, `loadAdopters()`, `saveAdoptions()`, `loadAdoptions()` |
| **AdoptionGUI** | Provides the JavaFX graphical user interface. | JavaFX components | GUI pages and event handling |

---

#  Project Structure

```
Animal-Adoption-System
│
├── src
│   └── javaappanimal
│       ├── Main.java
│       ├── Animal.java
│       ├── Dog.java
│       ├── Cat.java
│       ├── Bird.java
│       ├── Adopter.java
│       ├── Adoption.java
│       ├── FileManager.java
│       └── AdoptionGUI.java
│
├── animals.txt
├── adopters.txt
├── adoptions.txt
└── README.md
```
---

#  How to Run

## Requirements

- Java JDK 8 or later
- JavaFX
- NetBeans IDE

## Steps

1. Clone or download the repository.
2. Open the project in NetBeans.
3. Configure JavaFX if needed.
4. Run `Main.java`.
5. Use the graphical interface to manage the adoption system.

---

#  Screenshots

### Home Page

*(Add screenshot here)*

### Add Animal

*(Add screenshot here)*

### Add Adopter

*(Add screenshot here)*

### Adoption Page

*(Add screenshot here)*

### Reports

*(Add screenshot here)*

---

#  AI Usage Declaration

ChatGPT was used as a learning assistant during the development of this project. It was used to explain Java concepts, Object-Oriented Programming principles, JavaFX components, debugging, and documentation preparation. All code was reviewed, understood, and modified by the project team before submission.

---

#  Team Members

| Student | Student ID |
|---------|------------|
|Rewaa Mohammed Ghazi Almasri |2549011052 |
| Noor ashraf hassan khattab | 2549011048 |
| Raghad Ghassan Ali Jabr | 2549011057 | 

---

#  Video Presentation

**Video Link:**

(https://youtu.be/-hhTWenULGQ?si=TctQRiv9MwuzPPxb)


#  Course Information

- **Course:** Object-Oriented Programming (OOP)
- **Instructor:** Dr. Suheir Harb
- **Academic Year:** 2026
