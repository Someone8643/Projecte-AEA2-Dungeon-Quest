public class Monstre {

    // ** Com està implementat **
    // Existeixen noms per als monstres i s'assignen de forma aleatòria amb repetició.
    // Els altres atributs es generen aleatòriament amb mínims i màxims.

    // // Propietats

    private String nom;
    private int vida;
    private int atac;
    private int penalitazcio;
    private int vidaInicial;

    // // Llista de noms que tenim
    private String[] arrayNomsDeMonstres = {"TEMPMONSTRE1", "TEMPMONSTRE2", "TEMPMONSTRE3", "TEMPMONSTRE4"};

    // // Constructors

    // Constructor amb assignació
    public Monstre(String nom, int vida, int atac, int penalitazcio) {
        this.nom = nom;
        this.vida = vida;
        this.atac = atac;
        this.penalitazcio = penalitazcio;
        this.vidaInicial = vida;
    }

    // Constructor aleatòri
    public Monstre() {

        // Assignem un nom aleatori de la llista que tenim
        this.nom = arrayNomsDeMonstres[Aleatori.generarIntAleatoriRang(0, (arrayNomsDeMonstres.length - 1))];

        // Es genera un nivell de vida de forma aleatòria. Min 10, max 100
        this.vida = Aleatori.generarIntAleatoriRang(Dificultat.valorFinalObjecteDolent(10), Dificultat.valorFinalObjecteDolent(100));

        // Es genera un nivell d'atac. Min 5, max 70
        this.atac = Aleatori.generarIntAleatoriRang(Dificultat.valorFinalObjecteDolent(5), Dificultat.valorFinalObjecteDolent(60));

        // Es genera una penalització per fugir de forma aleatòria. Min 5, max 30
        this.penalitazcio = Aleatori.generarIntAleatoriRang(5, 30);

        this.vidaInicial = vida;
    }


    // // Mètodes

    /**
     * Mètode per penalitzar (fer mal) a un personatge que ha escapat d'una sala o s'ha retirat d'un combat.
     * @param personatgeAPenalitzar L'objecte Personatge a penalitzar.
     * @return Es retorna la penalització que s'ha aplicat per mostrar per pantalla.
     */
    public int penalitzarPersonatge(Personatge personatgeAPenalitzar){

        personatgeAPenalitzar.setVida(personatgeAPenalitzar.getVida() - this.penalitazcio);

        return this.penalitazcio;
    }


    /**
     * Mètode perquè aquest Monstre ataqui a un Personatge.
     * @param personatge El Personatge a atacar.
     * @return El dany que s'ha fet al Personatge per mostrar per pantalla.
     */
    public int atacarPersonatge(Personatge personatge) {

        // El dany base és igual a l'atac del monstre
        int dany = atac;

        // Reduïm la vida del personatge de forma aleatòria
        // El màxim de dany serà el calculat i el mínim és zero menys si la dificultat és difícil on sempre es farà un mínim del 20% del dany.
        if (Dificultat.getNivellDeDificultat() == 'D') {

            dany = Aleatori.generarIntAleatoriRang((int)(dany * 0.2), dany);
            personatge.setVida(personatge.getVida() - dany);

        } else {

            dany = Aleatori.generarIntAleatoriRang(0, dany);
            personatge.setVida(personatge.getVida() - dany);
        }

        return dany;  // Retornem el dany causat per mostrar per pantalla
    }


    @Override
    public String toString() {
        return "Monstre: \n" +
                "\t\tNom: " + nom + "\n" +
                "\t\tVida: " + vida +"\n"+
                "\t\tAtac: " + atac +"\n"+
                "\t\tPenalització: " + penalitazcio + ".\n";
    }


    // // Getters i Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getPenalitazcio() {
        return penalitazcio;
    }

    public void setPenalitazcio(int penalitazcio) {
        this.penalitazcio = penalitazcio;
    }

    public String[] getArrayNomsDeMonstres() {
        return arrayNomsDeMonstres;
    }

    public void setArrayNomsDeMonstres(String[] arrayNomsDeMonstres) {
        this.arrayNomsDeMonstres = arrayNomsDeMonstres;
    }

    public int getAtac() {
        return atac;
    }

    public void setAtac(int atac) {
        this.atac = atac;
    }

    public int getVidaInicial() {
        return vidaInicial;
    }

    public void setVidaInicial(int vidaInicial) {
        this.vidaInicial = vidaInicial;
    }
}


