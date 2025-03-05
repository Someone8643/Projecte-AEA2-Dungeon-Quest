import java.util.Arrays;

public class Persontge {

    // Propiedades

    private String nom;
    private int vida;
    private int atac;
    private int experiencia;
    private int agilitat;
    private int forsa;
    private int[][]posicio;
    private int[] equipament;

    // Constructores

    public Persontge(String nom, int vida, int atac, int experiencia, int agilitat, int forsa, int[][] posicio, int[] equipament) {
        this.nom = nom;
        this.vida = vida;
        this.atac = atac;
        this.experiencia = experiencia;
        this.agilitat = agilitat;
        this.forsa = forsa;
        this.posicio = posicio;
        this.equipament = equipament;
    }

    // Métodos
    public String atacar(int atac) {

        return null;
    }

    @Override
    public String toString() {
        return "Personatge: \n" +
                "\tNom: " + nom + "\n" +
                "\tVida: " + vida +"\n"+
                "\tAtac: " + atac +"\n"+
                "\tExperiència: " + experiencia +"\n"+
                "\tAgilitat: " + agilitat +"\n"+
                "\tForça: " + forsa +"\n"+
                "\tPosició: " + Arrays.toString(posicio) +"\n"+
                "\tEquipament: " + Arrays.toString(equipament) +"\n";
    }
}
