package funcionalidades.reprodutorMusical;

public class ITunes implements ReprodutorMusical {
    public void tocar() {
        System.out.println("tocando música usando o aplicativo iTunes");
    };
    public void pausar() {
        System.out.println("pausando música usando o aplicativo iTunes");
    };
    public void selecionarMusica(String musica) {
        System.out.println("selecionando a música " + musica + " usando o aplicativo iTunes");
    };
}
