import java.util.Scanner;

public class Masmorra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvengut joc DungeonQuest");
        System.out.println("estas prepart per jugar (si o no)");
        String name = sc.nextLine();
        if (name.equals("si")) {
            System.out.println("Joc DungeonQuest");
            System.out.println("....................");
        }else {
            System.out.println("Cuant estes preparat entra a jugar ");
        }

    }
    //Finalment, hi haurà una classe masmorra (estàtica) per controlar el joc:
    //Contenir els arrays de tots els tresors i monstres que hi haurà al joc.
    //Crear la masmorra (MxN) i omplir-la de sales aleatòriament.
    //Impressió de la masmorra amb les sales explorades (*), sales sense explorar (-) i posició actual del personatge (&).
    //Mostrar opcions (moure, explorar i/o atacar).
    //Comprovar si el joc ha finalitzat o no i mostrar resultats.
}
