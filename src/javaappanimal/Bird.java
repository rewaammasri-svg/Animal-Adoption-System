


package javaappanimal;


public class Bird extends Animal {
    
    public Bird(String id, String name, int age, String gender, boolean adopted) {
        super(id, name, age, gender,adopted);
    }

    @Override
    public String getType() {
        return "Bird";
    }
}