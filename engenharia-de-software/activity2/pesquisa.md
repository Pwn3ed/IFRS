# Pesquisa sobre falha de software

## Git

- Durante as férias de julho estava assistindo vídeos no youtube do `Fabio Akitta` - canal incrível para jogar na cara do programador conceitos básicos que são de suma importância para a carreira de desenvolvedor, mas que muitos não sabem - e ele contou a história do Github, como foi fundado, porque se destacou no mercado, etc...

- O caso do Git exemplifica como a engenharia de software é capaz de mudar a vida inteira do software.

- Antes de 2005 (lançamento do Git), os sistemas de versionamento de código mais famosos eram o SVN (Subversion), CVS (Concurrent), e o BitKepper (onde era salvo o Kernel do Linux até quebrarem a parceria e cobrarem pelo uso) provavelmente o professor já deve ter passado muitos perrengues neles. Esses versionadores vieram para resolver o problema de múltiplos desenvolvedores trabalhando no mesmo código, e também, para salvar o histórico de alterações caso algum novo código quebre o que já estava funcionando, podendo reverter para a versão anterior facilmente. Esta solução para projetos pequenos, funcionava muito bem, o problema maior surgia quando o projeto começava a crescer, que surge a necessidade de trabalhar com multíplas branches, e a necessidade de mergear elas, por conta do algorítmo de merge ultrapassado que estava sendo utilizado, demorava muito para realizar o merge e algumas vezes quebrava o código, por isso era uma solução que os programadores não podiam confiar e tinham que evitar ao máximo precisar de um merge.

- Essa história foi contada por Linus Torvalds em uma palestra, então, ele apresentou o Git, pela necessidade de salvar seu repositório do Linux de forma segura, ele próprio encontrou o grande gargalo dos versionadores de código existentes e o consertou, através do conceito de "Tarball" e de "Patch", foi possível salvar apenas as diferenças do código, melhorando considerávelmente a performance. E o merge também foi melhorado, através das "Pull Requests" foi possível identificar os conflitos e resolver manualmente, ou utilizar a lógica de manter sempre os arquivos mais recentes no repositório, facilitando e melhorando a performance do merge.

- Com isso o Git ganhou muito mercado e virou exemplo de versionador de código a ser seguido, não somente, mas exemplo de como a engenharia de software faz diferença, se aplicada desde o começo do processo de desenvolvimento de software, analisando criticamente os pontos de gargalo e simplificando a lógica do software, se torna mais leve e menos propenso a erros, e no caso de um versionador de código, era algo extremamente necessário que até então ninguém tinha conseguido pensar nessa solução, tanto que é contado que o Git foi desenvolvido em poucas semanas, devido ao seu ótimo planejamento.

