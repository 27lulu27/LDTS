# LDTS - TURMA 10, GRUPO 9 
# PONG-GAME

> Neste projeto procuramos recriar o emocionante mundo do Pong.
> Nesta nossa reinterpretação de um clássico procuramos explorar um lado mais inovador e desafiador do jogo, nunca perdendo o lado nostálgico deste.
> 
> Assim apresentamos um modo clássico, onde procuramos oferecer a experiência de jogar o Pong original, e também modos diferentes, onde o jogador se poderá desafiar, jogando num cenário com vários muros adicionais e aventuando-se com power-ups e vários níveis de dificuldade.
> 
> Um jogador poderá ainda jodar sozinho ou com um amigo a partir do mesmo computador, tentando pontuar o maior número de vezes para ganhar. 
> 
> 
> Este projeto foi desenvolvido por Gabriel Braga (up202207784@up.pt), Luana Lima (up202206845@up.pt) e Miguel Cabral (up202204496@up.pt) para a UC de LDTS no ano 2023/24.


-----
### FUNCIONALIDADES IMPLEMENTADAS

> Exemplos de funcionalidades que implementamos até ao momento da primeira entrega:

- **Menu** - Possiblita a escolha do modo de jogo ("Classic" ou "Different Modes") ou da saída do mesmo ("Exit")
- **Sub-Menus** - Possibilita o jogador escolher se quer jogar com um 2º jogador ou contra o computador, podendo neste último caso escolher um dos três níveis de dificuldade existentes
- **Player** - Muda a posição do jogador da esquerda verticalmente conforme input do utilizador
- **Segundo Player** - Muda a posição do jogador da direita verticalmente conforme input de um segundo utilizador
- **Computador** - Posicionado no mesmo local que o segundo jogador, movimenta-se sozinho na vertica, calculando a posição da bola de forma a que esta colida consigo
- **Bola** - Objeto que se movimenta pela arena, que sempre que colide com algum elemento inverte o seu ângulo de trajetória
- **Paredes** - Delimitam os limites superior e inferior da arena
- **Obstáculos** - Presentes nos modos diferentes, são como paredes que intreferem na trajetória da bola
- **Power-ups** - Presentes nos modos diferentes, quando apanhados pelos jogadores têm três diferentes consequências (adicionar obstáculos temporários, diminuir o tamanh do jogador adversário e aumentar o seu próprio tamnho) de modo a influenciar a complexidade do jogo
- **Pontuação** - Encontra-se no centro superior da arena e sempre que um jogador deixa a bola entrar do seu lado, o jogador adeversário ganha um ponto
- **Game Over** - Quando um jogador consegue chegar aos 10 pontos este ganha e o jogo acaba aparecendo a tela de Game Over que permite abandonar o jogo ou regressar ao menu
- **Níveis de Dificuldade** - Essencialmente mudam a precisão com que o computador calcula a posição de colisão com a bola, sendo que quanto mais difícil maior a precisão

![Jogo.gif](Jogo.gif)
![DM.png](DM.png)
![GO.png](GO.png)



-----
### FUNCIONALIDADES PLANEADAS

- Não existem funcionalidades a implementar num futuro próximo.


-----
### DESIGN

> Modelo UML:

![Modelo_UML.png](Modelo_UML.png)
##

> Problemas com o design do código que enfrentamos até ao momento da primeira entrega:

####
- #### ESTRUTURA DO CÓDIGO

**Contexto do Problema**

Para podermos organizar melhor o nosso código, a fim de ser mais fácil de trabalharmos os três sem conflitos, de testarmos mais a fundo pequenas ações e de gerirmos melhor o código foi necessário escolher a melhor abordagem para o projeto.


**Modelo**

Assim decidimos utilizar o **"MVC Pattern"**, dividindo o código em 3 partes:
   - Model - Representa os dados dos elementos, da arena e do menu do jogo
   - Viewer - Exibe os dados do Model e envia os inputs do utilizador para o Controller
   - Controller - Fornece dados do Model para o Viewer interpretando os inputs do utilizador com base nas regras do jogo
Os três pacotes são independentes mas interagem entre si para que o jogo funcione e flua.


**Implementação**

![MVC_Pattern.png](MVC_Pattern.png)

Estes pacotes podem ser encontrados em:
   - [Model](../src/main/java/com/mlg/pong/model)
   - [Viewer](../src/main/java/com/mlg/pong/viewer)
   - [Controller](../src/main/java/com/mlg/pong/controller)


**Consequências**

Este modelo torna o código mais fácil de testar e torna-o mais organizado, facilitando modificações. Apesar de não ser um modelo que estavessemos habituados a utilizar noutros projetos, tem-se revelado uma boa opção. 

###
- #### ESTADO DO JOGO

**Contexto do Problema**

No nosso jogo o jogador poderá alternar entre vários estados, como o menu, o jogo clássico e os diferentes modos. Desta forma o programa deve ser capaz de lidar com estes estados de forma simples e eficiente, podendo facilmente alternar entre os estados conforme o desejo do utilizador. 


**Modelo**

Assim decidimos utilizar o **"State Pattern"**, fazendo com que um objeto tenha o seu comportamento determinado pelo esstado em que se encontra.


**Implementação**

![State_Pattern.png](State_Pattern.png)

Este pacote pode ser encontrado em:
- [States](../src/main/java/com/mlg/pong/states)


**Consequências**

Este modelo possibilita que o utilizador mude o estado do jogo várias vezes ao longo de uma mesma sessão, traduzindo estas mudanças de uma forma mais clara no código, não sendo necessário usar várias flags e conjuntos de condições. Apesar de serem criadas mais classes, a abordagem do programa acaba por se mostrar mais simples.


###
- #### GUI

**Contexto do Problema**

Usar o Lanterna diretamente como uma forma de desenhar todos os elementos das classes presentes no Viewer tornar-se-ia imprudente e dificultaria os testes, sendo por isso necessário encontrarmos uma solução.


**Modelo**

Assim dicidimos utilizar o **"Adapter Pattern"**, adicionando uma interface GUI com os métodos usados pelas classes, permitindo que sejam feitas mudanças com menos frequência nas classes gerais, evitando a sua dependência com o Laterna.


**Implementação**

![Adapter_Pattern.png](Adapter_Pattern.png)

Este pacote pode ser encontrado em:
- [GUI](../src/main/java/com/mlg/pong/gui)


**Consequências**

Este modelo possibilita que o Viewer se torne independente do Lanterna, sendo assim possível testar se este o consegue chamar de forma eficiente.



-----
### *CODE SMELLS* DETETADOS

**Feature Envy**
Devido ao padrão MVC, as classes dos pacotes Viewer e Controller acessam mais os dados do pacote Model do que os seus próprios. Isso viola o princípio do encapsulamento e pode dificultar a manutenção do código, uma vez que os métodos o Viewer e Controller dependem muito dos dados do Model.

**Shotgun Surgery**
Por exemplo, se quisermos mudar o comportamento da bola, além de termos de fazer esta alteração, também teriamos de mudar a forma como outros objetos interagem com esta (isEmpty(), step(), ...), e talvez até mesmo a forma como é desenhada(drawBall()). 

**Parallel Inheritance Hierarchies**
Sempre que desejarmos adicionar uma nova classe ao pacote Model, temos de adicionar uma nova classe aos pacotes Viewer e Controller. Isso torna o código mais difícil de manter e aumenta sua fragilidade.

**Switch Statements**
Várias classes contêm instruções if...else complexas. Isso torna o código mais difícil de ler e entender.

**Dispensables Comments** 
Usamos em alguns sítios alguns comentários para nos ajudar a guiar e a ler melhor o código.



-----
### TESTES

- *Coverage Report*
![Coverage_Report.png](Tests.png)


-----
### AUTO-AVALIAÇÃO

> - Gabriel: 33.3%
> - Luana: 33.3%
> - Miguel: 33.3%
