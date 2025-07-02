public class Elementi {
  private static ElementoInterface[] elementi={new ElementoEsempio()};
  public static void conseguenza (int indice,int[][] labirinto,Personaggio personaggio){
    elementi[indice].conseguenza(labirinto, personaggio);
    System.out.println(elementi[indice].MessaggioOutPut());
  }
  public static Sprite rappresentazione(int indice){
    return elementi[indice].Rappresentazione();
  }
}
