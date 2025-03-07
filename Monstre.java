public class Monstre {
    // // Propietats

    private String nom;
    private double vida;
    private int penalitazcio;

    // // Constructors

    public Monstre(String nom, double vida, int penalitazcio) {
        this.nom = nom;
        this.vida = vida;
        this.penalitazcio = penalitazcio;
    }

    // Constructor aleatòri
    public Monstre() {




    }

    // // Mètodes

    @Override
    public String toString() {
        return "Monstre: \n" +
                "\tNom: " + nom + "\n" +
                "\tVida: " + vida +"\n"+
                "\tPenalització: " + penalitazcio + "\n";
    }

    // // Getters i Setters
    // TODO



}


