package lab.strategy;

// faz muito uso de polimorfismo
public class Robo {

    private Comportamento strategy;

    public void setStrategy(Comportamento strategy) {
        this.strategy = strategy;
    }

    public void mover() {
        strategy.mover();
    }


}
