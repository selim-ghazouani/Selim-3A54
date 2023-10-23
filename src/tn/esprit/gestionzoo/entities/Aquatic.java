package tn.esprit.gestionzoo.entities;

public non-sealed class Aquatic extends Animal {

    protected String habitat;
    private String name;
    private int age;

    public Aquatic() {
    }

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }


    public void swim() {
        System.out.println("This aquatic animal is swimming.");
    }

    @Override
    public String toString() {
        return super.toString() + ", habitat:" + habitat;
    }

    @Override
    public boolean equals(Object obj) {
        // Vérifier si l'objet en paramètre est le même que l'objet courant (this)
        if (this == obj) {
            return true;
        }

        // Vérifier si l'objet en paramètre est nul ou n'est pas de type Aquatic
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Convertir l'objet en paramètre en objet de type Aquatic
        Aquatic other = (Aquatic) obj;

        // Comparer le nom, l'âge et l'habitat des animaux aquatiques
        return name.equals(other.name) && age == other.age && habitat.equals(other.habitat);
    }
}
