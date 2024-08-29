package funcionalidades.aparelhoTelefonico;

public class Native implements AparelhoTelefonico {
    public void ligar(String numero) {
        System.out.println("ligando para " + numero + " usando app nativo");
    };

    public void atender() {
        System.out.println("atendendo usando aplicativo nativo ");
    };

    public void iniciarCorreioVoz() {
        System.out.println("iniciando correio de voz usando aplicativo nativo");
    };
}
