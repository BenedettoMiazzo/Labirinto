public class Tools {
  public static int distanza_tra_punti(Punto puntoA,Punto puntoB) {
    return Math.abs(puntoA.x - puntoB.x) + Math.abs(puntoA.y - puntoB.y);
  }




  public static Punto from_array_to_point (int[] posizione){
    return new Punto(posizione[0],posizione[1] );
  }
  // ritorna la distanza dal muro piu vicino
  public static int distanza_da_muro (Punto punto,int[][] labirinto){


    int distanza_da_x;
    if (punto.x<labirinto.length-punto.x){
      distanza_da_x=punto.x;
    }else {
      distanza_da_x=labirinto.length-punto.x;
    }


    int distanza_da_y;
    if (punto.y<labirinto[0].length-punto.y){
      distanza_da_y=punto.y;
    }else {
      distanza_da_y=labirinto.length-punto.y;
    }


    if (distanza_da_x<distanza_da_y){
      return distanza_da_x;
    }
    return distanza_da_y;
  }
  public static int[][] inserisciVal (int[][] labirinto,int daInserire,Punto dove){
    labirinto[dove.y][dove.x]=daInserire;
    return labirinto;
  }




  public static void stampa(int[][] labirinto) {
    System.out.print(" -".repeat(labirinto[0].length * 2) + "\n");




    for (int i = 0; i < labirinto.length; i++) {
      System.out.print("|");




      for (int j = 0; j < labirinto[i].length; j++) {
        String value = (labirinto[i][j] == 0) ? "#" : String.valueOf(labirinto[i][j]);
        System.out.print(" " + value + " |");
      }




      System.out.println();
      System.out.print(" -".repeat(labirinto[0].length * 2) + "\n");
    }
  }








  public static Punto scelta_bordo_a_caso(int[][] labirinto) {
    Punto punto = new Punto(0,0);
    int altezza = labirinto.length;
    int larghezza = labirinto[0].length;
    int random = (int) (Math.random() * 2);
    if (random == 0) {
      punto.x = ((int) (Math.random() * 2)) * (larghezza - 1);
      punto.y = (int) (Math.random() * altezza);








    } else {
      punto.y = ((int) (Math.random() * 2)) * (altezza - 1);
      punto.x = (int) (Math.random() * larghezza);
    }
    return punto;
  }








  public static int[] scelta_arrivo(int[][] labirinto) {
    int[] punto = new int[2];
    int altezza = labirinto.length;
    int larghezza = labirinto[0].length;
    punto[0] = ((int) (Math.random() * (larghezza - 2)) + 1);
    punto[1] = ((int) (Math.random() * (altezza - 2)) + 1);
    return punto;
  }
  //non chiamare danto un muro come uno dei 2 punti
  //guardare appunti_x_notazione
  public static Punto[] trova_e_ordina_punti_piu_lontani(Punto punto,Punto arrivo){
    Punto punto00 =new Punto(punto.x-1,punto.y-1);
    Punto punto10 =new Punto(punto.x-1,punto.y);
    Punto punto20 =new Punto((punto.x)-1,(punto.y)+1);
    Punto punto01 =new Punto(punto.x,((punto.y)-1));
    Punto punto21 =new Punto(punto.x,(punto.y)+1);
    Punto punto22 =new Punto(punto.x+1,punto.y-1);
    Punto punto12 =new Punto(((punto.x)+1),punto.y);
    Punto punto02=new Punto(((punto.x)+1),((punto.y)+1));
    Punto[] array={punto00,punto02,punto10,punto01,punto20,punto12,punto21,punto22};
    int indice;
    Punto passacarte;
    for (int x = 1; x < 8; x++) {
      passacarte = array[x];
      indice = x;
      for (int y = x - 1; y >= 0; y--) {
        if (distanza_tra_punti(passacarte, arrivo) < distanza_tra_punti(array[y], arrivo)) {
          array[y + 1] = array[y];
          indice = y;
        } else {
          break;
        }
      }
      array[indice] = passacarte;
    }
    return array;
  }
}


