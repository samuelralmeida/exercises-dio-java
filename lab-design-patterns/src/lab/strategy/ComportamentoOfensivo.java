package lab.strategy;

public class ComportamentoOfensivo implements Comportamento {
    @Override
    public void mover() {
        System.out.println("movendo-se ofensivamente");
        
    }
}
