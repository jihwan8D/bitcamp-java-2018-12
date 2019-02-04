package jihwan_practice.abstarct_example;

public class AnimalExample {

  public static void main(String[] args) {
    Cat cat = new Cat();
    Dog dog = new Dog();

    cat.sound();
    dog.sound();

    cat.breath();
    System.out.println();

    Animal animal = new Cat();

    animal.sound();
    System.out.println();
    
    animalSound(new Cat());
    animalSound(new Dog());
    
    System.out.println(cat instanceof Animal);

  }
  public static void animalSound(Animal type) {
    type.sound();
  }
}