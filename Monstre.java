public class Monstre {
    // Propiedades

    private String nom;
    private double vida;
    private int penalitazcio;

    // Constructores

    public Monstre(String nom, double vida, int penalitazcio) {
        this.nom = nom;
        this.vida = vida;
        this.penalitazcio = penalitazcio;
    }

    // Métodos

    @Override
    public String toString() {
        return "Monstre: \n" +
                "\tNom: " + nom + "\n" +
                "\tVida: " + vida +"\n"+
                "\tPenalització: " + penalitazcio + "\n";
    }
}
