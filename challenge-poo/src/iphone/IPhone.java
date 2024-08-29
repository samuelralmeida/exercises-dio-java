package iphone;

import funcionalidades.aparelhoTelefonico.AparelhoTelefonico;
import funcionalidades.aparelhoTelefonico.Native;
import funcionalidades.navegadorInternet.NavegadorInternet;
import funcionalidades.navegadorInternet.Safari;
import funcionalidades.reprodutorMusical.ITunes;
import funcionalidades.reprodutorMusical.ReprodutorMusical;

public class IPhone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {
    AparelhoTelefonico telefone = new Native();
    NavegadorInternet safari = new Safari();
    ReprodutorMusical iTunes = new ITunes();

    public void ligar(String numero) {    
        telefone.ligar(numero);
    };

    public void atender() {
        telefone.atender();
    };

    public void iniciarCorreioVoz() {
        telefone.iniciarCorreioVoz();
    };

    public void exibirPagina(String url) {
        safari.exibirPagina(url);
    };

    public void adicionarNovaAba() {
        safari.adicionarNovaAba();
    };

    public void atualizarPagina() {
        safari.atualizarPagina();
    };

    public void tocar() {
        iTunes.tocar();
    };

    public void pausar() {
       iTunes.pausar();
    };

    public void selecionarMusica(String musica) {
       iTunes.selecionarMusica(musica);
    };
}
