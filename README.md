#  Animal Adoption System

A desktop application developed using **Java** and **JavaFX** to manage animals, adopters, and adoption records. The system applies Object-Oriented Programming (OOP) concepts and stores data using text files.

---

#  Project Description

The **Animal Adoption System** aims to provide a platform that connects animal shelters with people interested in adopting animals. The system was developed using Java and is based on the principles of Object-Oriented Programming (OOP).

The system enables shelter staff to add animal information and record adoption requests. It applies key OOP concepts, including Encapsulation, Inheritance, Polymorphism, and Abstraction, to organize the code and make the system easier to develop, maintain, and extend.

The system also helps reduce manual procedures, organize animal and adopter records, and increase the chances of finding safe and suitable homes for animals.

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

#  Main Classes

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


### Home Page

<img width="1002" height="685" alt="image" src="https://github.com/user-attachments/assets/dfcd4310-e995-4f10-a454-fdac73348946" />


### Add Animal

<img width="1001" height="682" alt="image" src="https://github.com/user-attachments/assets/484a1968-3405-45f4-9156-15fe1f566a7e" />


### Add Adopter

<img width="997" height="682" alt="image" src="https://github.com/user-attachments/assets/144279b4-7c4a-4593-9bd3-10c76e1e5a36" />


### Adoption Page

<img width="997" height="686" alt="image" src="https://github.com/user-attachments/assets/d2f45546-8c53-488c-9d6c-5c5afb6f320b" />


### Reports

<img width="992" height="677" alt="image" src="https://github.com/user-attachments/assets/482ecb08-fcfc-4d7b-b590-aa31bcceb1c2" />


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
