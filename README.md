# Request Dispatcher

Projeto desenvolvido em Spring Boot que distribui solicitações de clientes para os atendentes corretos. O sistema, implementado em Java, distribui as solicitações com base no tipo de solicitação. O sistema respeita a capacidade máxima de atendentes e enfileira solicitações quando todos os atendentes estão ocupados.

## Funcionalidades

- **Distribuição Inteligente**: Solicitações são direcionadas ao time correto com base no tipo de solicitação.
  - Problemas com cartão -> Time de Cartões
  - Contratação de empréstimo -> Time de Empréstimos
  - Outros assuntos -> Time de Outros Assuntos
- **Capacidade Máxima**: Cada atendente pode atender no máximo 3 solicitações simultaneamente.
- **Fila de Espera**: Solicitações são enfileiradas se todos os atendentes do time específico estiverem ocupados.

## Testando a API

Para testar a API, você pode usar uma interface gráfica como o [Postman](https://www.postman.com/downloads/) ou uma extensão do navegador, como o Restlet Client (para Chrome) ou RESTClient (para Firefox). Também é possível testar alguns endpoints diretamente no navegador, mas isso é limitado aos métodos GET e POST com parâmetros de consulta (query parameters).

### Usando Postman

**Postman** é uma ferramenta gráfica muito útil para testar APIs. Você pode baixar o Postman [aqui](https://www.postman.com/downloads/).

#### Passos para testar a API usando Postman

1. Abra o Postman.
2. Crie uma nova requisição.
3. Selecione o Método HTTP:
   - `GET` para obter informações.
   - `POST` para enviar dados.
4. Insira a URL do endpoint.
5. Adicione Parâmetros ou Corpo da Requisição:
   - Para métodos `POST`, adicione os parâmetros no corpo (body) da requisição.

#### Exemplos de Requisições

##### 1. Adicionar Solicitação

- **Método**: POST
- **URL**: `http://localhost:8080/api/request`
- **Parâmetros**:
  - **Key**: `id`, **Value**: `1`
  - **Key**: `type`, **Value**: `Problemas com cartão`

No Postman:
- Selecione `POST`.
- Coloque a URL: `http://localhost:8080/api/request`.
- Vá para a aba `Body` e selecione `x-www-form-urlencoded`.
- Adicione as chaves `id` e `type` com seus respectivos valores.

##### 2. Adicionar Atendente

- **Método**: POST
- **URL**: `http://localhost:8080/api/attendant`
- **Parâmetros**:
  - **Key**: `team`, **Value**: `Cartões`
  - **Key**: `attendantId`, **Value**: `1`

No Postman:
- Selecione `POST`.
- Coloque a URL: `http://localhost:8080/api/attendant`.
- Vá para a aba `Body` e selecione `x-www-form-urlencoded`.
- Adicione as chaves `team` e `attendantId` com seus respectivos valores.

##### 3. Processar Filas

- **Método**: POST
- **URL**: `http://localhost:8080/api/process`

No Postman:
- Selecione `POST`.
- Coloque a URL: `http://localhost:8080/api/process`.
- Não é necessário adicionar nenhum corpo (body).

### Testando Diretamente no Navegador

Se você deseja testar rapidamente um endpoint que aceita parâmetros de consulta, você pode simplesmente inserir a URL no navegador. Isso é útil principalmente para métodos `GET` ou `POST` com parâmetros de consulta.

#### Exemplo de Requisições

##### 1. Adicionar Solicitação

Não é recomendado testar um endpoint `POST` diretamente no navegador com parâmetros de consulta. Use Postman ou CURL para isso.

##### 2. Adicionar Atendente

Não é recomendado testar um endpoint `POST` diretamente no navegador com parâmetros de consulta. Use Postman ou CURL para isso.

##### 3. Processar Filas

Não é recomendado testar um endpoint `POST` diretamente no navegador com parâmetros de consulta. Use Postman ou CURL para isso.
