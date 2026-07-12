
package javaappanimal;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

  /************************Sava Animals*****************************************/
    public void saveAnimals(ArrayList<Animal> animals) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("animals.txt"))) {
           
            for (Animal a : animals) {
                pw.println(a.getType() + "," + a.getId() + "," + a.getName() + "," +
                        a.getAge() + "," + a.getGender() + "," + a.isAdopted());
            }
            pw.close();
        } catch (IOException ex) {
            System.out.println("Error saving animals.");
        }
    }
  /************************Load Animals*****************************************/
    public ArrayList<Animal> loadAnimals() {
        
    ArrayList<Animal> animals = new ArrayList<>();
    try {
        File file = new File("animals.txt");
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] data = line.split(",");
                
                String type = data[0];
                String id = data[1];
                String name = data [2];
                int age = Integer.parseInt(data[3]);
                String gender = data [4];
                boolean adopted = Boolean.parseBoolean(data[5]);
                
                Animal animal = null;
                
                if(type.equals("Dog")){
                    animal = new Dog(id, name, age,gender,adopted);
                }
                else if(type.equals("Cat")){
                    animal = new Cat(id,name,age,gender,adopted);
                }
                else {
                    animal = new Bird(id,name,age,gender,adopted);
                }
                
                if (animal != null) {
                     animals.add(animal);
                }
            }
            input.close();
        }
    } catch (Exception e) {
            System.out.println(e.getMessage());    
    }
    return animals;

}
  /************************Sava Adopters*****************************************/
    public void saveAdopters(ArrayList<Adopter> adopters) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("adopters.txt"))) {
            for (Adopter a : adopters) {
                pw.println(a.getId() + "," + a.getName() + "," + a.getPhone() + "," + a.getAddress());
            }
         pw.close();
        } 
        catch (IOException e) {
            System.out.println("Error saving adopters.");
        }
    }
  /************************Load Adopters*****************************************/
    public ArrayList<Adopter> loadAdopters() {
        
        ArrayList<Adopter> adopters = new ArrayList<>();
        File file = new File("adopters.txt");

        if (!file.exists()) 
            return adopters;

        try (Scanner input = new Scanner(file)) {
            
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.trim().isEmpty()) {
                continue;
                }

            String[] data = line.split(",", -1);

            if (data.length < 4) {
                continue;
            }
                adopters.add(new Adopter(  data[0], data[1], data[2], data[3]));
            }
            input.close();
        } catch (IOException e) {
            System.out.println("Error loading adopters.");
        }
        return adopters;
    }
  /************************Sava Adoptions*****************************************/

    public void saveAdoptions(ArrayList<Adoption> adoptions) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("adoptions.txt"))) {
            for (Adoption a : adoptions) {
                pw.println(a.getAnimal().getId() + "," + a.getAdopter().getId() + "," + a.getDate());
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error saving adoptions.");
        }
    }
    
    /************************Load Adoptions*****************************************/

    public ArrayList<Adoption> loadAdoptions(ArrayList<Animal> animals, ArrayList<Adopter> adopters) {

    ArrayList<Adoption> adoptions = new ArrayList<>();

    try {
        File file = new File("adoptions.txt");
        if (!file.exists()) {
            return adoptions;
        }
        Scanner input = new Scanner(file);
        
        while (input.hasNextLine()) {
            String line = input.nextLine();
            
            if (line.trim().isEmpty()) {
                continue;
            }

            String[] data = line.split(",", -1);

            if (data.length < 2) {
                continue;
            }
            
            String animalId = data[0];
            String adopterId = data[1];
            Animal animal = null;
            Adopter adopter = null;

            for (Animal a : animals) {
                if (a.getId().equals(animalId)) {
                    animal = a;
                    break;
                }
            }
            
            for (Adopter ad : adopters) {
                if (ad.getId().equals(adopterId)) {
                    adopter = ad;
                    break;
                }
            }

            if (animal != null && adopter != null) {
                Adoption adoption =new Adoption(animal, adopter);
                adoptions.add(adoption);
            }
        }
        input.close();
    } catch (Exception e) {
        System.out.println("Error Loading Adoptions.");
    }
    return adoptions;
}
}