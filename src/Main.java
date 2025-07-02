import java.util.Locale;
import java.util.Scanner;
import java.util.Random;

public class Main {
  // int[.] = y int[][.] = x
  // l array ha y=0 in cima e x=0 a sinistra
  // 1 rappresenta cella di partenza
  // 2 rappresenta il percorso
  // 3 rappresenta l arrivo
  public static int[][] labirinto = new int[10][10];
  public static Personaggio personaggio = new Personaggio();
  
  public static void movimento(char direzione) {
    switch (direzione) {
      case 'w':
        personaggio.posizione.y--;
        break;
      case 'a':
        personaggio.posizione.x--;
        break;
      case 's':
        personaggio.posizione.y++;
        break;
      case 'd':
        personaggio.posizione.x++;
        break;
      default:
        System.out.println("impossibile");
    }
  }
  public static char direzione() {
    Scanner sc = new Scanner(System.in);
    String inserimento;
    char carattere;
    do {
      System.out.println("Inserisci direzione");
      inserimento = sc.next();
      inserimento = inserimento.toLowerCase(Locale.ROOT);
      carattere = inserimento.charAt(0);
    } while (carattere != 'w' && carattere != 'a' && carattere != 's' && carattere != 'd');
    sc.close();
    return carattere;
  }

  public static boolean menu() {
    //placeholder
    return true;
  }

  public static void disegna_labirinto(int[][]labirinto,Punto posizione) {

  }

  public static boolean valuta_conseguenze(int[][] labirinto,Personaggio personaggio){
    //placeholder
    return true;
  }

  public static boolean controlla_direzione(int[][] labirinto,Punto posizione,char direzione){
    //placeholder
    return true;
  }

  public static void genera_labirinto() {
    Punto punto_corrente = Tools.scelta_bordo_a_caso(labirinto);
    Punto arrivo = Tools.from_array_to_point(Tools.scelta_arrivo(labirinto));
    Tools.inserisciVal(labirinto,1,punto_corrente);
    Tools.inserisciVal(labirinto,3,arrivo);
    int distanza_da_soddisfare = labirinto.length*4;
    Punto[] punti=Tools.trova_e_ordina_punti_piu_lontani(punto_corrente,arrivo);
    Tools.inserisciVal(labirinto,2,punti[0]);
    punto_corrente=punti[0];


    while (distanza_da_soddisfare>0){
      if (Tools.distanza_tra_punti(punto_corrente,arrivo)<=1){
        break;
      }
      punti=Tools.trova_e_ordina_punti_piu_lontani(punto_corrente,arrivo);
      
      Punto punto_lavorato = punti[0];
      if (punto_lavorato==arrivo){
        break;
      }
      Tools.inserisciVal(labirinto,2,punto_lavorato);
      punto_corrente=punto_lavorato;
      distanza_da_soddisfare--;
    }
    Tools.stampa(labirinto);
  }




  public static void main(String[] args) {
    int dado;
    boolean continua = true;
    boolean controllo = true;
    char direzione;

    do {
      continua=menu();
      if (continua) {
       personaggio.scelta_personaggio();
       genera_labirinto();
       do {
        dado=personaggio.dado();
        disegna_labirinto(labirinto,personaggio.posizione);
        for(int x=0;x<dado;x++){
          do {
            direzione=direzione();
          } while (!controlla_direzione(labirinto,personaggio.posizione,direzione));
          movimento(direzione);
          controllo=valuta_conseguenze(labirinto,personaggio);
          disegna_labirinto(labirinto,personaggio.posizione);
          if (controllo) {
            break;
          }
        }
       } while (controllo);

      }
    } while (continua);
  }
}
