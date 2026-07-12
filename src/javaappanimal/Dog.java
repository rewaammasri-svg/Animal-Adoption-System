

package javaappanimal;


public class Dog extends Animal {
    
    public Dog(String id, String name, int age, String gender,boolean adopted) {
        super(id, name, age, gender,adopted);
    }
    
    @Override
    public String getType() {
        return "Dog";
    }
}