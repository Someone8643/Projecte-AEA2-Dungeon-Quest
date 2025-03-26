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

    // Llista de noms per agafar de forma aleatòria
    private String[] arrayNomsDePersonatges = {"Steve", "Alex"};


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

        // Similar a altres constructors aleatòris
        this.nom = arrayNomsDePersonatges[Aleatori.generarIntAleatoriRang(0, (arrayNomsDePersonatges.length - 1))];
        this.vida = Aleatori.generarIntAleatoriRang(Dificultat.valorFinalObjecteBo(30), Dificultat.valorFinalObjecteBo(110));
        this.atac = Aleatori.generarIntAleatoriRang(Dificultat.valorFinalObjecteBo(30), Dificultat.valorFinalObjecteBo(110));

        this.agilitat = Aleatori.generarIntAleatoriRang(Dificultat.valorFinalObjecteBo(30), Dificultat.valorFinalObjecteBo(70));
        this.forsa = Aleatori.generarIntAleatoriRang(Dificultat.valorFinalObjecteBo(1), Dificultat.valorFinalObjecteBo(8));

        this.equipament = new Tresor[forsa];
    }

    // Constructor per fer servir amb dades de l'usuari i certes variables amb números concrets TODO
    public Personatge(String nom) {

        // L'usuari pot establir
        this.nom = nom;

        // L'usuari no ho controla completament (certes variables són aleatòries dintre d'un rang segons la dificultat)
        // Després es modifica amb el sistema de creació de personatge.
        // Diversos valors tenen un rang aleatori establer de forma concreta.
        this.vida = 100;
        this.atac = Aleatori.generarIntAleatoriRang(Dificultat.valorFinalObjecteBo(40), Dificultat.valorFinalObjecteBo(70));
        this.agilitat = Aleatori.generarIntAleatoriRang(Dificultat.valorFinalObjecteBo(40), Dificultat.valorFinalObjecteBo(60));
        this.forsa = Aleatori.generarIntAleatoriRang(Dificultat.valorFinalObjecteBo(4), Dificultat.valorFinalObjecteBo(6));

        this.equipament = new Tresor[forsa];

        // RECORDAR QUE NO CAL INICIAR INTS
    }


    // // Mètodes

    /**
     * Mètode perquè aquest Personatge ataqui a un Monstre.
     * @param monstre El Monstre a atacar.
     * @return El dany que s'ha fet al monstre per mostrar per pantalla.
     */
    public int atacarMonstre(Monstre monstre) {

        // El dany base és igual a l'atac del personatge
        int dany = this.atac;

        // NO POSAR? MASSA ALEATORI? TODO revisar
        // // Es modifica el dany que farà segons la dificultat (més dificultat, menys dany)
        // dany = Dificultat.valorFinalObjecteBo(dany);

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

    // Mètode per explorar la sala // TODO revisar
    public String explorar(Sala sala) {
        if (sala.getTresor()!=null) {
            // Si la sala conté un tresor, afegir-lo a l'inventari
            Tresor tresor = sala.getTresor();
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

    // Mètode per moure el personatge a una nova posició absoluta
    public void moure(int x, int y) {
        this.posicio[0] = x;
        this.posicio[1] = y;
    }

    // Mètode per moure el personatge cap a una direcció
    public void moureDireccio(char direccio) {

        switch(direccio) {
            case 'N', 'n':

                this.posicio[0] ++;
                break;
            case 'E', 'e':

                this.posicio[1] ++;
                break;
            case 'S', 's':

                this.posicio[0] --;
                break;
            case 'O', 'o':

                this.posicio[1] --;
                break;
            default:
        }
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


    // TODO Revisar getters i setters
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
}
