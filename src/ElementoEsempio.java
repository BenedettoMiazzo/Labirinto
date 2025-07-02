public class ElementoEsempio extends ElementoBase {
  @Override
  public void conseguenza(int[][] labirinto,Personaggio personaggio){
    personaggio.vita=personaggio.vita-3;
  }
  @Override
  public String MessaggioOutPut(){
    return "Sei finito su delle Spine e hai persto 3 punti vita";
  }
  @Override
  public Sprite Rappresentazione(){
    Sprite rappresentazione = new Sprite(':',':',':',':');
    return rappresentazione;
  }
}
