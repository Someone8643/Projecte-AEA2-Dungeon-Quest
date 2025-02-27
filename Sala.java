public class Sala {
    //propiedades
    private String tipus;
    private boolean tesoro;
    private boolean monstre;
    private String portes;
    private boolean explorada;

    // Constructores

    public Sala(String tipus, boolean tesoro, boolean monstre, String portes, boolean explorada) {
        this.tipus = tipus;
        this.tesoro = tesoro;
        this.monstre = monstre;
        this.portes = portes;
        this.explorada = explorada;
    }


    // Métodos


    @Override
    public String toString() {
        return "Tipus" + tipus + "\n"+
                "Tesoro" + tesoro +"\n"+
                "Monstre" + monstre +"\n"+
                "Portes='" + portes + "\n"+
                "Explorada" + explorada;
    }
}
