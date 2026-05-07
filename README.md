**Sistema de Venda de Ingressos:**
Um sistema de linha de comando desenvolvido em Java com foco na aplicação prática de Tratamento de Exceções e Delegação de Responsabilidades através de Exceções de Domínio.

**📖 Sobre o Projeto**
Este projeto simula o fluxo de vendas do backend de uma plataforma de eventos. O objetivo principal da aplicação é demonstrar como criar um fluxo contínuo e à prova de falhas, protegendo as regras de negócio sem que o programa "quebre" (crash) diante de requisições ou dados inválidos do usuário.

**Funcionalidades e Regras de Negócio:**
O sistema inicia solicitando a configuração de um evento (nome, total de assentos e limite de ingressos por pessoa). Em seguida, entra em um laço contínuo de vendas onde as seguintes validações ocorrem:

Validação de Quantidade Mínima: O usuário não pode tentar comprar uma quantidade negativa de ingressos.

Política Anti-Cambista: A quantidade solicitada em uma única compra não pode exceder o limite estabelecido por pessoa no cadastro do evento.

Validação de Lotação: A quantidade solicitada não pode ser maior do que a quantidade de assentos que ainda restam disponíveis.

Encerramento Limpo: O sistema pode ser encerrado a qualquer momento ao digitar a quantidade 0.

**Estrutura do Código e Arquitetura:**
A lógica foi desenhada separando claramente as responsabilidades de negócio da interação com o usuário:

entities.Event (Classe de Domínio): Mantém o estado dos assentos e contém o método sellTickets. É esta classe que detém o poder de aprovar a venda ou de acionar o erro (throw) caso alguma das regras de negócio seja violada.

entities.DomainException (Exceção Personalizada): Herda de RuntimeException. É utilizada exclusivamente para empacotar e transportar os erros de regra de negócio gerados pela classe Event.

application.Program (Fluxo Principal): Responsável por interagir com o usuário via Scanner. O diferencial estrutural é a utilização de um bloco try-catch posicionado dentro de um laço de repetição (while (true)). Isso garante que, caso a classe Event dispare uma exceção, o erro seja capturado, exibido no console, e o programa retorne ao início do laço para uma nova tentativa, mantendo o sistema operante.
