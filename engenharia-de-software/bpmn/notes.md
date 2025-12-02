---

## Mapeamento BPM: Processo de CI/CD de uma aplicação Next.js

### Participantes (Swimlanes)
- Desenvolvedor
- Repositório (GitHub/GitLab)
- Pipeline CI (GitHub Actions, GitLab CI, etc.)
- Registro de Imagens (Docker Hub, etc.)
- Ambiente de Produção (Servidor com Docker Compose)

### Fluxo principal
1. Desenvolvedor faz commit/push no repositório (evento inicial)
2. Repositório dispara pipeline CI automaticamente
3. Pipeline executa build da aplicação (Docker)
4. Pipeline executa testes automáticos
5. Gateway: Build e testes passaram?
   - Não: Notifica desenvolvedor sobre falha e encerra o pipeline
   - Sim: Continua o fluxo
6. Pipeline envia imagem Docker para o registro (Docker Hub ou privado)
7. Pipeline realiza deploy no servidor de produção usando Docker Compose
8. Reinicia o container/aplicação com a nova imagem via Docker Compose (ex: `docker compose up -d`)
9. Notifica desenvolvedor sobre sucesso

### Eventos e artefatos opcionais
- Notificações por e-mail/Slack
- Artefato de build (imagem Docker)
- Logs de execução

### Pontos de decisão/erros
- Falha em testes ou build (gateway de erro)
- Falha no deploy ou reinício (notificação de erro)

### Como desenhar o diagrama BPMN
1. Abra https://app.diagrams.net/ ou https://demo.bpmn.io/
2. Crie swimlanes para cada participante
3. Adicione eventos de início (commit/push) e fim (notificações)
4. Adicione tarefas automáticas (build, testes, envio de imagem, deploy com Docker Compose, reinício)
5. Use gateways para decisões (build/testes passaram?)
6. Conecte as atividades com setas (sequence flows)
7. Exporte como PNG/SVG para entregar

---

## Entregáveis para a faculdade
- `bpmn/notes.md` com o mapeamento BPM do processo de CI/CD Next.js usando Docker e Docker Compose
- Imagem do diagrama (PNG ou SVG) exportada da ferramenta
- (Opcional) Arquivo `.bpmn` ou `.drawio` do diagrama

Se quiser, posso gerar o arquivo visual do diagrama para você. Basta pedir!
