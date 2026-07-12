package javaappanimal;

public abstract class Animal {
    private String id;
    private String name;
    private int age;
    private String gender;
    private boolean adopted;

    public Animal(String id, String name, int age, String gender,boolean adopted) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.adopted = adopted;
    }

    public abstract String getType();

    public String getId() { 
        return id; 
    }
    public String getName() {
        return name; 
    }
    public int getAge() {
        return age; 
    }
    public String getGender() {
        return gender; 
    }
    public boolean isAdopted() {
        return adopted; 
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + getType() + " - " + (adopted ? "Adopted" : "Available");
    }
}