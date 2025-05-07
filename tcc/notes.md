
# First Notes

fazer levantamento de aplicativos.

fazer tabela comparativa.

Descritores: media de 500 itens.
- Mobile Development
- Kotlin
- Dashboard

qual plataforma usou?
qual foi a filtragem de apps?


# Referências

Citação direta curta: máximo 3 linhas, entre aspas, página e ano.

Citação direta longa: maior de 3 linhas, parágrafo separado, recuo de página a esquerda, fonte 10 e espaçamento simples.

Citação indireta: Mais comum, citar com suas palavras mas baseando em tal autor, utilizar referência somente com nome e ano.

Aplicativos: Precisa referênciar, ver slides.

Leis: Precisa referênciar, ver slides.

Mendeley: site para fazer citações automáticas.


# Desenvolvimento

- Opção 1: Gateway WebRTC Local: um servidor Mediamtx (raspberry) roda na rede local convertendo o stream RTSP em WebRTC e gerencia a conexão P2P. O app se conecta somente com o servidor WebRTC.

- Opção 2: Serviço em nuvem hibrido: a camera envia o stream RTSP para um servidor em nuvem (Ant Media Server, Web Call Server 5), o servidor converte para WebRTC e entrega ao app via P2P. Ainda precisaria de um tunnel reverso para burlar o NAT e enviar RTSP para o servidor da nuvem.
