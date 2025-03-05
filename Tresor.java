public class Tresor {

    // Propiedades

    private String nom;
    private double valor;
    private double pes;

    // Constructores

    public Tresor(String nom, double valor, double pes) {
        this.nom = nom;
        this.valor = valor;
        this.pes = pes;
    }

    // Métodos

    @Override
    public String toString() {
        return
                "Tresor: \n" +
                "\tNom " + nom + "\n"+
                "\tValor " + valor +"\n"+
                "\tPes " + pes +"\n";
    }
}
