# okk-siscom
Siscom ERP - Uma volta ao passado

Recriando um sistema ERP lá de 2008 feito em Java Swing para uma nova versão Web com novas tecnologias e arquitetura.

Siscom era um sistema de ERP feito em desktop utilizando Java Swing. Um ERP comum com cadastrados de fornecedores, vendas, controle de estoque e etc.

Recriar esse sistemas com novas tecnologias e agora para Web está sendo uma atividade interessante, onde aborda uma nova maneira de pensar em como desenvolver software em contraste com o passado lá de 2008.

Está nova roupagem, utilizá como base um backend com Java 17 e Spring Boot e Angular 17 para frontend.
O foco também estará no uso de frameworks e ferramentas na parte de qualidade de softwware, boas praticas e testes, em especial, testes unitários, de integração e mutação.

## Ferramentas utilizadas até o momento

### Backend
- Java 17
- Maven
- Spring Boot versão 3.x
- Flyway
- Docker e Docker Composer
- Banco de dados Oracle
- TestContainers
- AssertJ
- RestAssured

### Frontend
- Angular 17

### Considerações
Conforme acontece o desenvolvimento e vá surgindo a necessidade, novas ferramentas serão adicionadas a solução a fim de resolver um determinado problema.

Não há muito o que mostrar, mas você pode clonar o repositório na sua máquina local e simular alguns cadastros ou rodas os testes de intefração que valida algumas regras de negócio.

### Baixando e executando o projeto

Com Docker na sua máquina e de preferencia o JDK 17, podemos executar o maven para rodar os testes de integração e unitários com o comando abaixo:

#### Clonando o projeto
> git clone https://github.com/BSTK/okk-siscom.git

#### Backend - Instalando as depências
> cd ./okk-siscom/okk-siscom-backend \
> mvn clean install

#### Backend - Rodando os testes
> mvn test

#### Frontend - Instalando as depências
> npm install \
> npm start


## Considerações Finais

Esta documento está sendo atualizado a medida que o desnevolvimento avança.
