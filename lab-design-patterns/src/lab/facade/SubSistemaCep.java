package lab.facade;

// Simula um subsistema externo para o facade interagir
public class SubSistemaCep {

    private static SubSistemaCep instance = new SubSistemaCep();

    private SubSistemaCep() {
        super();
    }

    public static SubSistemaCep getInstance() {
        return instance;
    }

    public String recuperarCidade(String cep) {
        return "Belo Horizonte";
    }

    public String recuperarEstado(String cep) {
        return "Minas Gerais";
    }
}
