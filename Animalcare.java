import java.util.ArrayList;
import java.util.Scanner;

class Pet {
    private String name;
    private String type;
    private String condition;

    public Pet(String name, String type, String condition) {
        this.name = name;
        this.type = type;
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return
               '\n'+"Type of Animal='" + name + '\n' +
                ", Rescued From='" + type + '\n' +
                ", Condition=" + condition +'\n'
                ;
    }
}

class PetShop {
    private ArrayList<Pet> pets;

    public PetShop() {
        this.pets = new ArrayList<>();
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void displayPets() {
        System.out.println("Animals in the Organization :");
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }

    public Pet searchPet(String name) {
        for (Pet pet : pets) {
            if (pet.getName().equalsIgnoreCase(name)) {
                return pet;
            }
        }
        return null;
    }
}

public class Animalcare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PetShop petShop = new PetShop();

        while (true) {
            System.out.println("\n-----------Animal care center-----");
            System.out.println("1. Press 1 for the admission of the  animal in the organization");
            System.out.println("2. Press 2 to the present list of animal in the Organization");
            System.out.println("3. Press 3 if you want to search  for a specific type of animal");
            System.out.println("4. Press 4 to exit from the system");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Animal Type : ");
                    String petName = scanner.nextLine();
                    System.out.print("Enter Present location of Animal: ");
                    String petType = scanner.nextLine();
                    System.out.print("Enter Animal Condition:");
                    String petCondition = scanner.nextLine();

                    Pet newPet = new Pet(petName, petType, petCondition);
                    petShop.addPet(newPet);
                    System.out.println("Animal admitted successfully!");
                    break;
                case 2:
                    petShop.displayPets();
                    break;
                case 3:
                    System.out.print("Enter the Type  of the Animal to search: ");
                    String searchName = scanner.nextLine();
                    Pet foundPet = petShop.searchPet(searchName);
                    if (foundPet != null) {
                        System.out.println("Animal is Present: " + foundPet);
                    } else {
                        System.out.println("This type of animal is not present.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for your service . Goodbye!");
                    System.out.println("Contact US:9001273465 \n");
                    System.out.println("Email:animalcare234@gmail.com");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
