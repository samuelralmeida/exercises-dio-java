package lab.facade;

// Simula um subsistema externo para o facade interagir
public class SubSistemaCrm {

    private SubSistemaCrm() {
        super();
    }

    public static void gravarCliente(String nome, String cep, String estado, String cidade) {
        System.out.println("Cliente salvo no sistema de crm");
        System.out.println(nome);
        System.out.println(cep);
        System.out.println(estado);
        System.out.println(cidade);

    }
}
