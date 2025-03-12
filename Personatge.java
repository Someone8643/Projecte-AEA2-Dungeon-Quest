import java.util.Arrays;

public class Personatge {

    // // Propietats

    private String nom;
    private int vida;
    private int atac;
    private int experiencia;
    private int agilitat;
    private int forsa;
    private int[][]posicio;
    private int[] equipament;

    // // Constructors

    // Constructor amb assignació
    public Personatge(String nom, int vida, int atac, int experiencia, int agilitat, int forsa, int[][] posicio, int[] equipament) {
        this.nom = nom;
        this.vida = vida;
        this.atac = atac;
        this.experiencia = experiencia;
        this.agilitat = agilitat;
        this.forsa = forsa;
        this.posicio = posicio;
        this.equipament = equipament;
    }

    // // Mètodes

    /**
     * Mètode perquè aquest Personatge ataqui a un Monstre.
     * @param atac TODO
     * @return
     */
    public int atacar(int atac) {

        return 999;
    }

    // Explorar, passar la sala


    // Moure, passar la matriu per comprovacions



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

    // TODO Getters i Setters






}
