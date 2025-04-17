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
    private int vidaInicial;
    private int pocions;

    // Llista de noms per agafar de forma aleatòria
    private final String[] arrayNomsDePersonatges = {"Steve", "Alex"};


    // // Constructors

    // Constructor amb assignació
    public Personatge(String nom, int vida, int atac, int experiencia, int agilitat, int forsa, int[] posicio, Tresor[] equipament, int pocions) {
        this.nom = nom;
        this.vida = vida;
        this.atac = atac;
        this.experiencia = experiencia;
        this.agilitat = agilitat;
        this.forsa = forsa;
        this.posicio = posicio;
        this.equipament = equipament;
        this.vidaInicial = vida;
        this.pocions = pocions;
    }

    // Constructor aleatòri, per donar l'opció a l'usuari
    public Personatge() {

        // Similar a altres constructors aleatòris
        this.nom = arrayNomsDePersonatges[Aleatori.generarIntAleatoriRang(0, (arrayNomsDePersonatges.length - 1))];
        this.vida = Aleatori.generarIntAleatoriRang(Dificultat.valorFinalObjecteBo(30), Dificultat.valorFinalObjecteBo(120));
        this.atac = Aleatori.generarIntAleatoriRang(Dificultat.valorFinalObjecteBo(20), Dificultat.valorFinalObjecteBo(120));

        this.agilitat = Aleatori.generarIntAleatoriRang(Dificultat.valorFinalObjecteBo(1) + 1, 12); // Com amb la força
        this.forsa = Aleatori.generarIntAleatoriRang(Dificultat.valorFinalObjecteBo(1) + 1, 12); // + 1 per evitar que els aleatòris en difícil puguin tenir 0 força encara que és una mica graciós // TODO revisar, potser deixar la possibilitat de 0

        this.equipament = new Tresor[forsa];
        this.vidaInicial = vida;
    }

    // Constructor per fer servir amb dades de l'usuari i certes variables amb números concrets
    public Personatge(String nom) {

        // L'usuari pot establir
        this.nom = nom;

        // L'usuari no ho controla completament (certes variables són aleatòries dintre d'un rang segons la dificultat)
        // Després es modifica amb el sistema de creació de personatge.
        // Diversos valors tenen un rang aleatori establer de forma concreta.
        this.vida = 100;
        this.atac = Aleatori.generarIntAleatoriRang(Dificultat.valorFinalObjecteBo(40), Dificultat.valorFinalObjecteBo(70));
        this.agilitat = Aleatori.generarIntAleatoriRang(Dificultat.valorFinalObjecteBo(2), Dificultat.valorFinalObjecteBo(12));
        this.forsa = Aleatori.generarIntAleatoriRang(Dificultat.valorFinalObjecteBo(2), Dificultat.valorFinalObjecteBo(12));

        this.equipament = new Tresor[forsa];
        this.vidaInicial = vida;

        // RECORDAR QUE NO CAL INICIAR INTS
    }


    // // Mètodes

    /**
     * Mètode per curar al personatge, sense sobrepassar el nivell inicial.
     * @param puntsVida Punts de vida que s'afegeixen.
     */
    public void curar(int puntsVida) {

        vida += puntsVida;

        if (vida > vidaInicial) {
            vida = vidaInicial;
        }
    }


    /**
     * Mètode per utilitzar una de les pocions i regenerar vida, segons la dificultat.
     * @return Cert o fals segons i s'ha pogut fer.
     */
    public boolean utiltzarPocio() {

        if (pocions > 0) {

            curar(Dificultat.valorFinalObjecteBo(20));
            pocions--;

            return true;
        }

        return false;
    }


    /**
     * Mètode que calcula l'equivalent en monedes total dels tresors.
     * @return El total en monedes.
     */
    public int totalMonedes() {

        int total = 0;

        for (Tresor tresor : equipament) {

            if (tresor != null) {
                total += tresor.getValor();
            }
        }

        return total;
    }


    /**
     * Mètode que calcula el total de tresors dintre de l'equipament.
     * @return El total de tresors.
     */
    public int totalTresors() {

        int total = 0;

        for (Tresor tresor : equipament) {

            if (tresor != null) {
                total++;
            }
        }

        return total;
    }


    /**
     * Mètode perquè aquest Personatge ataqui a un Monstre.
     * @param monstre El Monstre a atacar.
     * @return El dany que s'ha fet al monstre per mostrar per pantalla.
     */
    public int atacarMonstre(Monstre monstre) {

        // El dany base és igual a l'atac del personatge
        int dany = this.atac;

        // Reduïm la vida del monstre de forma aleatòria
        // El màxim de dany serà el calculat i el mínim és zero menys si la dificultat és fàcil on sempre es farà un mínim del 20% del dany.
        if (Dificultat.getNivellDeDificultat() == 'F') {

            dany = Aleatori.generarIntAleatoriRang((int)(dany * 0.2), dany);
            monstre.setVida(monstre.getVida() - dany);

        } else {

            dany = Aleatori.generarIntAleatoriRang(0, dany);
            monstre.setVida(monstre.getVida() - dany);
        }

        return dany;  // Retornem el dany causat per mostrar per pantalla
    }


    /**
     * Mètode per explorar una sala.
     * @param sala La sala a explorar (hauria de ser l'actual).
     * @return Retorna un string amb una explicació del que ha passat, per mostrar per pantalla.
     */
    public String explorar(Sala sala) {

        String missatge = "";
        sala.setExplorada(true); // Marquem la sala com explorada

        // Mirar si hi ha tresor, si hi ha, intentar posar en inventari
        if (sala.getTresor() != null) {

            int i = 0;
            while (i < equipament.length && equipament[i] != null) {

                i++;
            }

            if (i > equipament.length) { // No hem trobat lloc

                missatge += "Has trobat un tresor, però el teu inventari està ple per a tresors!";

            } else {

                // Agafem el tresor de la sala i s'elimina d'allí
                equipament[i] = sala.getTresor();
                sala.setTresor(null);

                missatge += "Has trobat un tresor i l'has afegit al teu equipament!";
            }

            // Mirar si també hi ha poció
            if (sala.isTePocio()) {

                sala.setTePocio(false);
                pocions++;
                missatge += "\nHas trobat una poció i l'has guardada!";
            }

        } else if (sala.isTePocio()) { // Mirar si mínim hi ha poció

            sala.setTePocio(false);
            pocions++;
            missatge += "Has trobat una poció i l'has guardada!";

        } else {

            return "La sala està buida, no has trobat absolutament res...";
        }

        return missatge;
    }


    /**
     * Mètode per moure el personatge a una nova posició absoluta
     * @param x Coord x (columna de la matriu)
     * @param y Coord y (fila de la matriu)
     */
    public void moure(int x, int y) {
        this.posicio[0] = x;
        this.posicio[1] = y;
    }


    /**
     * Mètode per moure el personatge cap a una direcció
     * @param direccio
     */
    public void moureDireccio(char direccio) {

        switch(direccio) {
            case 'N', 'n':

                this.posicio[0] --;
                break;
            case 'E', 'e':

                this.posicio[1] ++;
                break;
            case 'S', 's':

                this.posicio[0] ++;
                break;
            case 'O', 'o':

                this.posicio[1] --;
                break;
            default:
        }
    }

    @Override
    public String toString() {

        String stringMostrarEquipament = "Equipament:";
        for (Tresor tresor : equipament) {
            if (tresor != null) {
                stringMostrarEquipament += "\n\t\t" + tresor;
            } else {
                stringMostrarEquipament += "\n\t\t" + "Espai buit per a un tresor.";
            }
        }

        return "Personatge: \n" +
                "\tNom: " + nom + "\n" +
                "\tVida: " + vida +"\n"+
                "\tAtac: " + atac +"\n"+
                "\tExperiència: " + experiencia +"\n"+
                "\tAgilitat: " + agilitat +"\n"+
                "\tForça: " + forsa +"\n"+
                "\tPosició: sala " + (posicio[1] + 1) + " del nivell " + (posicio[1] + 1) + "\n"+
                "\t" + stringMostrarEquipament + "\n" +
                "\tPocions: " + pocions;
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

        // Si amb aquest setter la vida supera la inicial, s'actualitza la vida inicial
        if (this.vida + vida > vidaInicial) {
            this.vida = vida;
        }
    }

    public int getAtac() {
        return atac;
    }

    public void setAtac(int atac) {
        this.atac = atac;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getAgilitat() {
        return agilitat;
    }

    public void setAgilitat(int agilitat) {
        this.agilitat = agilitat;
    }

    public int getForsa() {
        return forsa;
    }

    public void setForsa(int forsa) {
        this.forsa = forsa;
    }

    public int[] getPosicio() {
        return posicio;
    }

    public void setPosicio(int[] posicio) {
        this.posicio = posicio;
    }

    public Tresor[] getEquipament() {
        return equipament;
    }

    public void setEquipament(Tresor[] equipament) {
        this.equipament = equipament;
    }

    public int getPosicioX() {
        return posicio[1];
    }

    public int getPosicioY() {
        return posicio[0];
    }

    public int getVidaInicial() {
        return vidaInicial;
    }

    public void setVidaInicial(int vidaInicial) {
        this.vidaInicial = vidaInicial;
    }

    public int getPocions() {
        return pocions;
    }

    public void setPocions(int pocions) {
        this.pocions = pocions;
    }
}
