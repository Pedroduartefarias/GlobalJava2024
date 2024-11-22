<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
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
    <li><strong>Mensageria Assíncrona</strong>: Envio de notificações e mensagens utilizando RabbitMQ.</li>
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
      <pre>
{
  "nome": "Carlos Silva",
  "email": "carlos.silva@email.com",
  "senha": "senha123",
  "role": "USER"
}
      </pre>
      <strong>Resposta:</strong>
      <pre>
HTTP/1.1 201 Created
{
  "id": 1,
  "nome": "Carlos Silva",
  "email": "carlos.silva@email.com",
  "createdAt": "2024-11-22T12:34:56",
  "updatedAt": "2024-11-22T12:34:56"
}
      </pre>
    </li>
    
    <li><strong>POST /login</strong>
      <pre>
{
  "email": "joao.silva@email.com",
  "senha": "senha123"
}
      </pre>
      <strong>Resposta:</strong>
      <pre>
{
  "token": "seu.token.jwt.aqui"
}
      </pre>
    </li>

    <li><strong>GET /usuario/profile</strong>  
      <strong>Cabeçalho:</strong> Authorization: Bearer seu.token.jwt.aqui  
      <strong>Resposta:</strong>
      <pre>
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao.silva@email.com",
  "role": "USER"
}
      </pre>
    </li>
  </ul>

  <h3>Clima</h3>
  <ul>
    <li><strong>GET /api/condicoes-climaticas/{cidade}</strong>  
      <strong>Cabeçalho:</strong> Authorization: Bearer seu.token.jwt.aqui
    </li>
    
    <li><strong>GET /api/recomendacoes/gerar?cidade={cidade}</strong>  
      <strong>Cabeçalho:</strong> Authorization: Bearer seu.token.jwt.aqui  
      <strong>Resposta:</strong>
      <pre>
{
  "id": 2,
  "nome": "Pedro Duarte",
  "email": "pedro.duarte@email.com",
  "senha": "senha1245"
}
      </pre>
    </li>
  </ul>

  <h3>Mensageria</h3>
  <ul>
    <li><strong>POST /api/climate/send-event?message={mensagem}</strong>  
      <strong>Cabeçalho:</strong> Authorization: Bearer seu.token.jwt.aqui  
      <strong>Body:</strong>
      <pre>
{
  "message": "Evento climático em Rondonia"
}
      </pre>
    </li>
  </ul>

  <h2>📝 Como Executar</h2>
  <ol>
    <li>Clone o repositório:
      <pre>
git clone https://github.com/seu-usuario/monitoramento-climatico.git
cd monitoramento-climatico
      </pre>
    </li>
    <li>Instale as dependências:
      <pre>
npm install
      </pre>
    </li>
    <li>Configure o backend em <code>application.properties</code> com a API OpenWeatherMap e RabbitMQ.</li>
    <li>Execute o backend:
      <pre>
./mvnw spring-boot:run
      </pre>
    </li>
    <li>Execute o frontend:
      <pre>
npm start
      </pre>
    </li>
  </ol>

  <h2>🔗 Licença</h2>
  <p>Este projeto é licenciado sob a <a href="LICENSE">MIT License</a>.</p>

  <footer>
    <p>&copy; 2024 Pedro Duarte Farias e Equipe. Todos os direitos reservados.</p>
  </footer>
</body>
</html>
