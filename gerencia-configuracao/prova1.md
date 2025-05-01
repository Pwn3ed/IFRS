# Prova 1 - SGC

1) Gerência de configuração é a arte de coordenar o processo de desenvolvimento de software, identificando, organizando e controlando modificações no sistema, garantindo sua integridade ao longo de todo o ciclo de vida.
As 6 subáreas são:
- Gerência de Código Fonte
- Engenharia de Build
- Configuração do Ambiente
- Controle de Mudanças
- Gerenciamento de Releases
- Deployment

2) Alguns dos critérios que classificam um artefato de software como um IC são:
- Possuir um ID único.
- Contribuir para a funcionalidade do sistema.
- Estar sujeito a mudanças.
- Possuir impacto relevante em outros itens.
- Precisar de controle de versão.

Exemplos:
- Arquivo de código-fonte.
- Especificação do sistema.
- Arquivo de teste.

3) Quais as duas estratégias mais comuns para realizar o versionamento do código fonte no que diz respeito a infra-estrutura (bases, repositórios)?
R) As duas estratégias são:
- Centralizado: Possui uma única base de código e precisa ter conexão constante com o servidor para qualquer alteração.
- Descentralizado: Cada desenvolvedor possui uma cópia do repositório e todo seu histórico de versões, permite trabalhar offline e realizar alterações através de branches e merges.

4) O que deve acontecer para que uma nova versão para um item de configuração seja criada no repositório?
R) Deve ser realizado alguma alteração no item, como um simples correção de bug ou adição de novas funcionalidades, geralmente feito através de um commit.

5) Como as fases do ciclo de vida de software (Requisitos, Desenvolvimento, Testes, Implantação e Manutenção), relacionam-se com a gerência de configuração?
R) Todas fases do ciclo de vida de software necessitam de uma gerência de configuração para organizar, versionar e rastrear qualquer mudança feita no sistema, permitindo se ter mais flexibidade e confiabilidade enquanto trabalha, evitando conflitos de arquivos e permitindo voltar atrás caso alguma coisa dê errado.

6.1) Como um sistema de controle de versão (ex.: Git, Mercurial) poderia evitar o problema de "alterações de código perdidas" descrito no estudo de caso?
R) Um sistema de controle de versão evitaria o problema de "alterações de código perdidas" através de ramificações do código (branches), onde cada equipe poderia ter trabalhado em branches separados e após finalizarem, poderiam ter enviado ao repositório e mesclado suas alterações, após análise e revisão do código.

6.2) Quais práticas de GCS ajudariam a empresa TechFlow a rastrear qual desenvolvedor introduziu um bug em produção?
R) A prática de utilizar um versionamento de código, onde cada alteração no projeto fica registrado em um log detalhado, contendo as alterações, quem fez, quando e a descrição das alterações. Mas além dessa prática é interessante a empresa TechFlow acompanhar o projeto e possuir CI/CD, através de testes é possível identificar o bug antes de subir em produção.

6.3) Explique como um repositório remoto (como o GitHub) pode resolver os problemas de "dados compartilhados" e "atualização simultânea".
R) Um repositório remoto teria impedido que múltiplas equipes modificassem a mesma biblioteca simultaneamente e sem coordenação. Pois o sistema de controle de versão gerenciaria as alterações, evitando sobrescritas e permitindo a resolução de conflitos de forma organizada. Se implementado dessa forma desde o começo, a centralização do código e o controle de acesso garantiriam que apenas a versão correta do código fosse implementada.

