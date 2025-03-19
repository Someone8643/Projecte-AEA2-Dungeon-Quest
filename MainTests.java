public class MainTests {

    public static void main(String[] args) {

Tresor oro = new Tresor("Oro",10,30.4);
Tresor palta = new Tresor("Palta",20,30.4);
Monstre diablo = new Monstre("diablo",20,50);
Monstre Diablo2 = new Monstre();
Monstre rojo = new Monstre("rojo",20,40);

        Personatge P1 = new Personatge("youssef",100,200,2,3,5,new int[]{0,0},new Tresor[]{palta});
        Personatge P2 = new Personatge("oriol",90,200,4,40,50,new int[]{0,0},new Tresor[]{oro});

        System.out.println(P1);
        System.out.println(P2);
        System.out.println(Diablo2);






    }



}
