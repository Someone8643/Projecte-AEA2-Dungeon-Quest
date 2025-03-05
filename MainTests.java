public class MainTests {

    public static void main(String[] args) {

        System.out.println(Aleatori.generarIntAleatoriRang(0, 5));

        System.out.println(Aleatori.generarDoubleAleatoriRang(0, 5));


        System.out.println(Aleatori.tirarMoneda());

        int vegadescert = 0;
        for (int i = 0; i < 100; i++) {

            if (Aleatori.percentatgeProbabilitat(70)) {
                vegadescert++;
            }

        }

        System.out.println(vegadescert);







        Tresor tresor = new Tresor();

        System.out.println(tresor);




    }



}
