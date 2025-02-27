public class Tesor {

    //propiedades
    private String nom;
    private double valor;
    private double pes;

    // Constructores

    public Tesor(String nom, double valor, double pes) {
        this.nom = nom;
        this.valor = valor;
        this.pes = pes;
    }

    // Métodos

    @Override
    public String toString() {
        return
                "Nom " + nom + "\n"+
                "Valor " + valor +"\n"+
                "Pes " + pes;
    }
}
