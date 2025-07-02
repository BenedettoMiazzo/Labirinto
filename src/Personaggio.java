public class Personaggio {
  public Punto posizione =new Punto(0,0);
  public int vita=100;
  public int numero_massimo = 6;
  public int dado() {
    int x = (int) (Math.random() * (numero_massimo - 1)) + 1;
    System.out.println("E' uscito il numero: " + x);
    return x;
  }
  public void scelta_personaggio (){
    
  }
}
