<body>
  <h1>🌞 WebApp de Monitoramento Climático para Energia Solar</h1>

  <h2>🧑‍💻 Integrantes</h2>
  <ul>
    <li><strong>Pedro Duarte Farias</strong>: Responsável pela criação do projeto em Java.</li>
    <li><strong>Henrique Baptista</strong>: Responsável pela criação do projeto IoT e DevOps.</li>
    <li><strong>Leonardo Dourado</strong>: Responsável pelo projeto de QA.</li>
    <li><strong>Gabriel Caverzan</strong>: Responsável pelo projeto Mobile e Banco de Dados.</li>
    <li><strong>Matheus De Castro</strong>: Responsável pelo projeto em C#.</li>
  </ul>

  <h2>💡 Descrição do Projeto</h2>
  <p>
    O <strong>WebApp de Monitoramento Climático para Energia Solar</strong> foi projetado para monitorar condições climáticas 
    e fornecer recomendações personalizadas sobre o uso eficiente de energia solar. Utilizando IA generativa, o sistema sugere 
    ações que promovem a economia de energia. O sistema também suporta autenticação segura e envio de notificações baseadas em 
    eventos climáticos.
  </p>

  <h2>🚀 Funcionalidades</h2>
  <ul>
    <li><strong>Monitoramento Climático</strong>: Integração com a API OpenWeatherMap para obter informações climáticas em tempo real.</li>
    <li><strong>Recomendações Personalizadas</strong>: IA generativa usando Groq fornece dicas baseadas em condições específicas.</li>
    <li><strong>Autenticação e Autorização</strong>: Implementação com Spring Security para proteger o acesso às funcionalidades.</li>
    <li><strong>Persistência de Dados</strong>: Utilização do Oracle SQL Server para armazenar informações de usuários, clima e histórico de recomendações.</li>
  </ul>

  <h2>⚙️ Tecnologias Utilizadas</h2>
  <ul>
    <li><strong>Java 17</strong>: Linguagem principal do backend.</li>
    <li><strong>Spring Boot</strong>: Framework para simplificar o desenvolvimento de aplicações.</li>
    <li><strong>Spring Security</strong>: Gerenciamento de autenticação e autorização.</li>
    <li><strong>Spring Data JPA</strong>: Persistência de dados com suporte ao Oracle SQL Server.</li>
    <li><strong>RabbitMQ</strong>: Mensageria assíncrona.</li>
    <li><strong>Groq</strong>: IA generativa para recomendações baseadas em clima.</li>
    <li><strong>OpenWeatherMap API</strong>: Dados climáticos em tempo real.</li>
  </ul>

  <h2>📜 Endpoints da API</h2>
  
  <h3>Usuários</h3>
  <ul>
    <li><strong>POST /usuario</strong>
      <pre><code>{
  "nome": "Carlos Silva",
  "email": "carlos.silva@email.com",
  "senha": "senha123",
  "role": "USER"
}</code></pre>
      <strong>Resposta:</strong>
      <pre><code>HTTP/1.1 201 Created
{
  "id": 1,
  "nome": "Carlos Silva",
  "email": "carlos.silva@email.com",
  "createdAt": "2024-11-22T12:34:56",
  "updatedAt": "2024-11-22T12:34:56"
}</code></pre>
    </li>

    <li><strong>POST /login</strong>
      <pre><code>{
  "email": "joao.silva@email.com",
  "senha": "senha123"
}</code></pre>
      <strong>Resposta:</strong>
      <pre><code>{
  "token": "seu.token.jwt.aqui"
}</code></pre>
    </li>

    <li><strong>GET /usuario/profile</strong>
      <strong>Cabeçalho:</strong> <code>Authorization: Bearer seu.token.jwt.aqui</code>
      <strong>Resposta:</strong>
      <pre><code>{
  "id": 1,
  "nome": "João Silva",
  "email": "joao.silva@email.com",
  "role": "USER"
}</code></pre>
    </li>
  </ul>

  <h3>Clima</h3>
  <ul>
    <li><strong>GET /api/condicoes-climaticas/{cidade}</strong>
      <strong>Cabeçalho:</strong> <code>Authorization: Bearer seu.token.jwt.aqui</code>
    </li>
    
    <li><strong>GET /api/recomendacoes/gerar?cidade={cidade}</strong>
      <strong>Cabeçalho:</strong> <code>Authorization: Bearer seu.token.jwt.aqui</code>
      <strong>Resposta:</strong>
      <pre><code>{
  "recomendacoes": [
    "Limpe os painéis solares regularmente para maior eficiência.",
    "Reduza o uso de eletrodomésticos durante picos de calor."
  ]
}</code></pre>
    </li>
  </ul>

  <h3>Mensageria</h3>
  <ul>
    <li><strong>POST /api/climate/send-event?message={mensagem}</strong>
      <strong>Cabeçalho:</strong> <code>Authorization: Bearer seu.token.jwt.aqui</code>
      <strong>Body:</strong>
      <pre><code>{
  "message": "Evento climático em Rondônia"
}</code></pre>
    </li>
  </ul>

  <h2>📝 Como Executar</h2>
  <ol>
    <li>Clone o repositório:
      <pre><code>git clone https://github.com/P/monitoramento-climatico.git</code></pre>
    </li>
    <li>Configure o banco de dados e as chaves da API no arquivo <code>application.properties</code>.</li>
    <li>Execute o docker:
      <pre><code>docker-compose up -d</code></pre>
    </li>
  </ol>

  <h2>🔗 Link para o video</h2>
  <p>https://youtu.be/xw88-g75RK0?si=itXlmiou0ZFj4STA</p>
</body>
</html>
