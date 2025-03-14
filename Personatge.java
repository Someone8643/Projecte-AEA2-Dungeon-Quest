import java.util.Arrays;

public class Personatge {

    // // Propietats

    private String nom;
    private int vida;
    private int atac;
    private int experiencia;
    private int agilitat;
    private int forsa;
    private int[] posicio = new int[2]; // Recordar que es x (fil) i y (col)
    private Tresor[] equipament;

    // // Constructors

    // Constructor amb assignació
    public Personatge(String nom, int vida, int atac, int experiencia, int agilitat, int forsa, int[] posicio, Tresor[] equipament) {
        this.nom = nom;
        this.vida = vida;
        this.atac = atac;
        this.experiencia = experiencia;
        this.agilitat = agilitat;
        this.forsa = forsa;
        this.posicio = posicio;
        this.equipament = equipament;
    }

    // Constructor aleatòri, per donar l'opció a l'usuari TODO
    public Personatge() {
        this.nom = nom;
        this.vida = vida;
        this.atac = atac;
        this.experiencia = experiencia;
        this.agilitat = agilitat;
        this.forsa = forsa;
        this.posicio = posicio;
        this.equipament = new Tresor[forsa];


    }

    // Constructor per fer servir amb dades de l'usuari i certes variables amb números concrets TODO
    public Personatge(String nom) {
        // L'usuari pot establir
        this.nom = nom;

        // L'usuari no controla completament? (que fer? utilitzar random?) TODO Aplicar sistema de punts
        this.vida = 100;
        this.atac = atac;
        this.agilitat = agilitat;
        this.forsa = forsa;

        this.equipament = new Tresor[forsa];

        // RECORDAR QUE NO CAL INICIAR INTS
    }
    // Mètode per atacar un monstre
    public int atacar(Monstre monstre) {
        // Calcular el dany causat per l'atac
        int dany = this.atac;  // El dany base és igual a l'atac del personatge
        monstre.reduirVida(dany);  // Reduïm la vida del monstre amb el dany causat

        return dany;  // Retornem el dany causat
    }

    // Mètode per explorar la sala
    public String explorar(Sala sala) {
        if (sala.conteTresor()) {
            // Si la sala conté un tresor, afegir-lo a l'inventari
            Tresor tresor = sala.obtenirTresor();
            if (equipament.length < forsa) {
                for (int i = 0; i < equipament.length; i++) {
                    if (equipament[i] == null) {
                        equipament[i] = tresor;
                        return "Has trobat un tresor i l'has afegit al teu equipament!";
                    }
                }
            } else {
                return "El teu inventari està ple!";
            }
        }
        return "La sala està buida, no has trobat res.";
    }

    // Mètode per moure el personatge a una nova posició
    public void moure(int x, int y) {
        this.posicio[0] = x;
        this.posicio[1] = y;
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
