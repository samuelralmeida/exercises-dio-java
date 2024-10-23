## Descrição

Sistema RESTful desenvolvido para calcular e gerenciar a dispensação de medicamentos em uma farmácia, levando em consideração a posologia de cada medicamento e as regras de dispensação. Além de realizar cálculos automáticos da quantidade a ser dispensada, a API registra todas as solicitações e respostas no banco de dados para fins de auditoria.

## Funcionalidades

- Cálculo de dispensação: Calcula a quantidade de comprimidos a serem dispensados com base no tipo de posologia e dias de uso.

- Suporte a múltiplas posologias:

    - Todos os dias
    - Dias alternados
    - Dias da semana (a desenvolver)
    - Dias do mês (a desenvolver)

- Tipos de dispensação:
    - Única
    - Recorrente

- Auditoria: Armazena todas as requisições e respostas para rastreabilidade e auditoria.
- Próxima retirada: Para dispensações recorrentes, calcula a data da próxima retirada.
- A aplicação disponibiliza uma documentação segundo padrão swagger em `/swagger-ui.html`

## Requisitos

- Java 17+
- Gradle (para gerenciamento de dependências)
- Banco de dados (pode ser configurado conforme a escolha, ex: MySQL, PostgreSQL). Localmente usa H2 como banco em memória.
- Spring Boot. Starters usados:
    - Web
    - JPA