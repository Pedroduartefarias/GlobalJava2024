<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
  <h1>WebApp de Monitoramento Climático para Energia Solar</h1>

  <h2>🧑‍💻 Integrantes</h2>
 <ul>
  <li><strong>Pedro Duarte Farias</strong>: Responsável pela criação do projeto Java</li>
  <li><strong>Henrique Baptista</strong>: Responsável pela criação do projeto IoT e DevOps</li>
  <li><strong>Leonardo Dourado</strong>: Responsável pelo projeto de QA</li>
  <li><strong>Gabriel Caverzan</strong>: Responsável pelo projeto de Mobile e Banco de Dados</li>
  <li><strong>Matheus De Castro</strong>: Responsável pelo projeto de C#</li>
</ul>

  <h2>💡 Descrição do Projeto</h2>
  <p>Este projeto tem como objetivo monitorar condições climáticas e fornecer recomendações sobre o uso de energia solar. O sistema usa inteligência artificial generativa para dar dicas sobre economia de energia e otimização do consumo baseado nas condições climáticas. O projeto também inclui funcionalidades de autenticação de usuários e persistência de dados, além de comunicação eficiente entre sistemas e usuários com mensageria assíncrona via RabbitMQ.</p>

  <h3>🚀 Funcionalidades</h3>
  <ul>
    <li><strong>Monitoramento climático</strong>: O WebApp integra com a API OpenWeatherMap para capturar dados climáticos atualizados.</li>
    <li><strong>Recomendações de energia solar</strong>: Usando IA generativa com o Groq, o sistema fornece dicas personalizadas sobre como economizar energia com base no clima.</li>
    <li><strong>Autenticação de usuários</strong>: O Spring Security protege as rotas e permite que apenas usuários autenticados acessem funcionalidades críticas do sistema.</li>
    <li><strong>Mensageria com RabbitMQ</strong>: Usada para gerenciar a comunicação assíncrona e garantir a eficiência no envio de notificações e dados entre componentes do sistema.</li>
    <li><strong>Persistência de dados</strong>: Utiliza Oracle SQL Server para armazenar as informações dos usuários, histórico de recomendações e condições climáticas.</li>
  </ul>

  <h2>🚀 Tecnologias Utilizadas</h2>
  <ul>
    <li><strong>Java 17</strong>: Linguagem de programação principal.</li>
    <li><strong>Spring Boot</strong>: Framework utilizado para construir a aplicação.</li>
    <li><strong>Spring Security</strong>: Gerencia a autenticação e autorização de usuários.</li>
    <li><strong>Spring Data JPA</strong>: Persistência de dados, com integração ao Oracle SQL Server.</li>
    <li><strong>RabbitMQ</strong>: Utilizado para mensageria assíncrona, garantindo a comunicação eficiente entre os componentes do sistema.</li>
    <li><strong>Groq</strong>: Ferramenta de IA generativa usada para fornecer recomendações de economia de energia baseadas no clima.</li>
    <li><strong>OpenWeatherMap API</strong>: API externa para obter dados climáticos em tempo real.</li>
  </ul>

  <h2>📜 Endpoints</h2>
  <h3>Usuários</h3>
  <ul>
    <li><code>POST /login</code>: Realiza o login e retorna o token JWT.</li>
    <li><code>GET /usuarios</code>: Retorna a lista de usuários registrados.</li>
    <li><code>GET /usuarios/{id}</code>: Retorna os dados de um usuário específico.</li>
    <li><code>POST /usuarios</code>: Cadastra um novo usuário.</li>
  </ul>

  <h3>Clima</h3>
  <ul>
    <li><code>GET /clima</code>: Retorna as condições climáticas atuais para a cidade configurada.</li>
    <li><code>GET /recomendacoes</code>: Retorna recomendações personalizadas sobre o uso de energia solar com base nas condições climáticas atuais.</li>
  </ul>

  <h3>Mensageria</h3>
  <ul>
    <li><code>POST /mensagens</code>: Envia uma mensagem para o RabbitMQ.</li>
    <li><code>GET /mensagens</code>: Recupera as mensagens enviadas via RabbitMQ.</li>
  </ul>


  <h2>📝 Conclusão</h2>
  <p>Este projeto integra diversas tecnologias poderosas para garantir que o monitoramento climático e as recomendações para o uso de energia solar sejam eficazes e escaláveis.</p>

  <footer>
    <p>&copy; 2024 Pedro Duarte Farias - Todos os direitos reservados.</p>
  </footer>
</body>
</html>
