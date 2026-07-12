package javaappanimal;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    private static ArrayList<Animal> animals = new ArrayList<>();
    private static ArrayList<Adopter> adopters = new ArrayList<>();
    private static ArrayList<Adoption> adoptions = new ArrayList<>();

    private static final FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        loadData();
        launch(args);
        saveData();
    }

    @Override
    public void start(Stage stage) {
        AdoptionGUI gui = new AdoptionGUI(stage);
        gui.show();
    }

    public static void loadData() {
        animals = fileManager.loadAnimals();
        adopters = fileManager.loadAdopters();
        adoptions = fileManager.loadAdoptions(animals, adopters);

        if (animals == null) 
            animals = new ArrayList<>();
        if (adopters == null) 
            adopters = new ArrayList<>();
        if (adoptions == null)
            adoptions = new ArrayList<>();
    }

    public static void saveData() {
        fileManager.saveAnimals(animals);
        fileManager.saveAdopters(adopters);
        fileManager.saveAdoptions(adoptions);
    }

    public static void addAnimal(Animal animal) {
        animals.add(animal);
        saveData();
    }

    public static void addAdopter(Adopter adopter) {
        adopters.add(adopter);
        saveData();
    } 

    public static boolean adoptAnimal(String animalId, String adopterId) {
        Animal animal = searchAnimalById(animalId);
        Adopter adopter = searchAdopterById(adopterId);

        if (animal == null || adopter == null || animal.isAdopted()) {
            return false;
        }
        Adoption adoption = new Adoption(animal, adopter);
        adoptions.add(adoption);
        saveData();
        return true;
    }

    public static Animal searchAnimalById(String id) {
        for (Animal animal : animals) {
            if (animal.getId().equalsIgnoreCase(id)) {
                return animal;
            }
        }
        return null;
    }

    public static Adopter searchAdopterById(String id) {
        for (Adopter adopter : adopters) {
            if (adopter.getId().equalsIgnoreCase(id)) {
                return adopter;
            }
        }
        return null;
    }

    public static ArrayList<Animal> getAnimals() {
        return animals;
    }

    public static ArrayList<Adopter> getAdopters() {
        return adopters;
    }

    public static ArrayList<Adoption> getAdoptions() {
        return adoptions;
    }

    public static ArrayList<Animal> getAvailableAnimals() {
        ArrayList<Animal> available = new ArrayList<>();

        for (Animal animal : animals) {
            if (!animal.isAdopted()) {
                available.add(animal);
            }
        }

        return available;
    }
}