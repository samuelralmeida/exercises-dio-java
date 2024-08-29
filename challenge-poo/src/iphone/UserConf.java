package iphone;

import funcionalidades.navegadorInternet.Chrome;
import funcionalidades.navegadorInternet.NavegadorInternet;

public class UserConf extends IPhone {
    NavegadorInternet chrome = new Chrome();

    public void adicionarNovaAba() {
        chrome.adicionarNovaAba();
    }

    public void atualizarPagina() {
        chrome.atualizarPagina();
    }

    public void exibirPagina(String url) {
        chrome.exibirPagina(url);
    }
}
