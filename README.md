Projeto criado a partir do template do Spring.

Tools:
* Intellij
* Java 8
* Maven

Database:
* H2 (banco de dados em memória - já está configurado no projeto)
* Caso necessário utilizar o console, após subir o projeto acesse:
    * http://localhost:8080/h2-console
        * driver class -> org.h2.Driver
        * jdbc url -> jdbc:h2:mem:testdb
        * username -> sa
        * password -> password

* Obs.: As configs do database encontram-se dentro do projeto

Objetivo do projeto:
* Ser uma API para ser consumida por diferentes clientes.
* Listar clientes através da rota: /clients/list
* Listar produtos através da rota: /products/list
* Cadastrar possíveis compradores para determinados produtos através da rota: /clients/save
    Body:
    {
        "client": {
            "name": "Helio"
        },
        "product": {
            "codigo": 35,
            "description": "Teclado de computador"
        }
    }

Regra de negócio:
* A API Cadastra possíveis compradores para determinados produtos (1 para 1).
* Estrutura do banco de dados não deve ser alterada (alter table, alter columns, etc) para a solução não seguir outra linha de resolução.
* Na tabela de clientes apenas um único nome é permitido (conforme especificação da tabela).
* Na tabela de produtos apenas um único código é permitido (conforme especificação da tabela).
* Sempre que um Cliente for cadastrado na base de dados, obrigatoriamente o mesmo Produto deve ser cadatrado também.
* Sempre que um Produto for cadastrado na base de dados, obrigatoriamente o mesmo Cliente deve ser cadastrado também.
* Sempre que um Cliente e Produto for cadastrado, a tabela de logs obrigatoriamente precisa ter esses registros.
* Obs.: Lembre-se que essa API cadastra possíveis compradores para determinados produtos.
        Portanto, não existe relação direta entre eles na base de dados (e nem precisa).

Para resolver 1:
* Após o projeto ter sido criado, foi identificado alguns comportamentos não desejados pelos clientes.
* Eles estão reclamando que a API está confundindo os consumidores.
* Ela funciona. Porém, devido a alguns cenários eles perderam confiança nela. Atualmente eles precisam:
    * Cadastrar os dados (através das rotas citadas)
    * Realizar consultas na API (através das rotas citadas) para ter certeza do que foi de fato cadastrado. Isso não está sendo viável.
***Expectativa do cliente: O ideal é que a API se resolva e seja coerente com suas respostas.

* Além disso, a tabela de log deve exibir o que de fato foi cadastrado no sistema. Pela reclamação deles, não é o que acontece.
* A evidência que temos é um trecho do log com um pequeno exemplo:
    Cliente [Helio] registrado.
    Produto [Teclado de computador] registrado.
    Produto [Teclado de computador] registrado.
	Cliente [Joaquim] registrado.
***Expectativa do cliente: Futuramente a idéia é expor os registros de log através de uma rota.
   (Não se preocupe com isso, não é necessário implementar nesse exercício.)
   Porém, a expecativa do cliente é que os dados sejam sempre coerentes de acordo com a regra de negócio descrita.

Para resolver 2:
* Algum desenvolvedor comitou algum código quebrado e os testes pararam de funcionar.
****Expecativa do líder técnico: Resolva os problemas. Dica: Tente resolver sem alterar a lógica de implementação dos testes.


Para implementar:
* Identificado que as rotas estão expostas e isso está causando desconforto nos clientes.
***Expectativa do cliente: Implemente qualquer mecanismo de segurança que funcione com ROLES.
  Por exemplo: A role USER consegue apenas ver os métodos de consulta.
               A role ADMIN consegue ver os métodos de consulta e de gravação.
  Partindo do princípio que não temos nada, qualquer lógica é bem vinda.
  Pode ser o mais simples possível (desde que funcione).

  Entregável:
  Projeto para download (de preferência em algum repositório).


***Diferencial:***
Caso queira, faça deploy do seu projeto em um ambiente cloud e disponibilize a URL.