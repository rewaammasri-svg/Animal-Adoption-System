
package javaappanimal;


public class Cat extends Animal {
    
    public Cat(String id, String name, int age, String gender, boolean adopted) {
        super(id, name, age, gender,adopted);
    }
    
    @Override
    public String getType() {
        return "Cat";
    }
}