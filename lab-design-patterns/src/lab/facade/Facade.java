package lab.facade;

// Voltado para simplificar interações com subsistemas externos
// Abstrai a integração com cep e salva no crm
public class Facade {

    public void migrarCliente(String nome, String cep) {
        String cidade = SubSistemaCep.getInstance().recuperarCidade(cep);
        String estado = SubSistemaCep.getInstance().recuperarEstado(cep);
        
        SubSistemaCrm.gravarCliente(nome, cep, cidade, estado);
    }

}
