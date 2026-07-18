
package javaappanimal;
import java.util.Date;

public class Adoption {
    
    private Animal animal;
    private Adopter adopter;
    private Date date;
    
    
    
    public Adoption(Animal animal, Adopter adopter) {
        this(animal, adopter, new Date());
    }

    public Adoption(Animal animal, Adopter adopter,Date date) {
        this.animal = animal;
        this.adopter = adopter;
        this.date = date;
        this.animal.setAdopted(true);
    }

    public Animal getAnimal() { 
        return animal; 
    }
    public Adopter getAdopter() { 
        return adopter; 
    }
    public Date getDate() { 
        return date; 
    }

    @Override
    public String toString() {
        return animal.getName() + " adopted by " + adopter.getName() + " on " + date;
    }
}
