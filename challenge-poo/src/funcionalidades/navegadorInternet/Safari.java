package funcionalidades.navegadorInternet;

public class Safari implements NavegadorInternet{
    public void exibirPagina(String url) {
        System.out.println("exibindo página " + url + " usando o Safari");
    };
    public void adicionarNovaAba() {
        System.out.println("adicionando nova aba usando o Safari");
    };
    public void atualizarPagina() {
        System.out.println("atualizando página usando o Safari");
    };
}
