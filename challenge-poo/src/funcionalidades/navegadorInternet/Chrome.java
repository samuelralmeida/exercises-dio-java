package funcionalidades.navegadorInternet;

public class Chrome implements NavegadorInternet{
    public void exibirPagina(String url) {
        System.out.println("exibindo página " + url + " usando o Chrome");
    };
    public void adicionarNovaAba() {
        System.out.println("adicionando nova aba usando o Chrome");
    };
    public void atualizarPagina() {
        System.out.println("atualizando página usando o Chrome");
    };
}
