package tn.esprit.gestionzoo.entities;

import java.util.ArrayList;

public class Zoo {

    public static final int NUMBER_OF_CAGES = 25;
    private Animal[] animals;
    private String name, city;
    private int nbrAnimals;



    public Zoo() {
    }

    public Zoo(String name, String city) {
        animals = new Animal[NUMBER_OF_CAGES];
        this.name = name;
        this.city = city;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals > z2.nbrAnimals)
            return z1;
        return z2;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank())
            System.out.println("The Zoo name cannot be empty");
        else
            this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrAnimals() {
        return nbrAnimals;
    }

    public void setNbrAnimals(int nbrAnimals) {
        this.nbrAnimals = nbrAnimals;
    }

    void displayZoo() {
        System.out.println("Name: " + name + ", City: " + city + ", N° Cages: " + NUMBER_OF_CAGES + " N° animals: " + nbrAnimals);
    }

    public boolean addAnimal(Animal animal) {
        if (searchAnimal(animal) != -1)
            return false;
        if (isZooFull())
            return false;
        animals[nbrAnimals] = animal;
        nbrAnimals++;
        return true;
    }

    public boolean removeAnimal(Animal animal) {
        int indexAnimal = searchAnimal(animal);
        if (indexAnimal == -1)
            return false;
        for (int i = indexAnimal; i < nbrAnimals; i++) {
            animals[i] = animals[i + 1];
        }
        animals[nbrAnimals] = null;
        this.nbrAnimals--;
        return true;
    }

    public void displayAnimals() {
        System.out.println("List of animals of " + name + ":");
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

    public int searchAnimal(Animal animal) {
        int index = -1;
        for (int i = 0; i < nbrAnimals; i++) {
            if (animal.getName() == animals[i].getName())
                return i;
        }
        return index;
    }

    public boolean isZooFull() {
        return nbrAnimals == NUMBER_OF_CAGES;
    }

    @Override
    public String toString() {
        return "Zoo{ Name: " + name + ", City: " + city + ", N° Cages: " + NUMBER_OF_CAGES + " N° animals: " + nbrAnimals + "}";
    }

    Aquatic[] aquaticAnimals = new Aquatic[10];
    int aquaticCount = 0;
    public void addAquaticAnimal(Aquatic aquatic) {
        aquaticAnimals[aquaticCount] = aquatic;
        aquaticCount++;
        System.out.println("Animal aquatique ajouté au zoo.");
    }
    private Penguin[] penguins; // Tableau pour stocker les pingouins
    private int penguinCount; // Compteur du nombre de pingouins actuellement dans le zoo


    // Méthode pour trouver la profondeur maximale de nage des pingouins dans le zoo
    public float maxPenguinSwimmingDepth() {
        float maxDepth = 0; // Initialiser la profondeur maximale à 0

        for (int i = 0; i < penguinCount; i++) {
            float currentDepth = penguins[i].getSwimmingDepth(); // Obtenir la profondeur de nage du pingouin actuel
            if (currentDepth > maxDepth) {
                maxDepth = currentDepth; // Mettre à jour la profondeur maximale si la profondeur actuelle est plus grande
            }
        }

        return maxDepth; // Retourner la profondeur maximale de nage des pingouins dans le zoo
    }
    public void displayNumberOfAquaticsByType() {
        int numberOfDolphins = 0; // Initialiser le compteur de dauphins à 0
        int numberOfPenguins = 0; // Initialiser le compteur de pingouins à 0

        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                numberOfDolphins++; // Incrémenter le compteur de dauphins
            } else if (aquaticAnimals[i] instanceof Penguin) {
                numberOfPenguins++; // Incrémenter le compteur de pingouins
            }
        }

        System.out.println("Nombre de dauphins dans le zoo : " + numberOfDolphins);
        System.out.println("Nombre de pingouins dans le zoo : " + numberOfPenguins);
    }





}