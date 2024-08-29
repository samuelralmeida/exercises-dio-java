package funcionalidades.reprodutorMusical;

public class Vlc implements ReprodutorMusical {
    public void tocar() {
        System.out.println("tocando música usando o aplicativo Vlc");
    };
    public void pausar() {
        System.out.println("pausando música usando o aplicativo Vlc");
    };
    public void selecionarMusica(String musica) {
        System.out.println("selecionando a música " + musica + " usando o aplicativo Vlc");
    };
}
