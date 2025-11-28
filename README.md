# Sudoku 9x9 Challenge

Este repositório serve única e exclusivamente como base para o Sudoku Challenge que será realizado dia 27/11 na Uniguaçu. Abaixo algumas informações sobre a realização do desafio.

## Requisitos:

1. Ter cadastro aqui -> https://career-booster-br.tglab.com/challenge
2. Possuir conhecimentos básicos de lógica de programação e programar em JAVA;
3. Possuir conta no GitHub e dar push ou fork do código em repositório público durante o desafio;
4. Não trocar ideias (ex.: Pair Programming) com os colegas nos primeiros 30 minutos de desafio;
5. Não usar IA, ou pesquisas na internet de maneira geral, na primeira 1h do desafio.

## Desafio

O desafio será avaliado em 2 partes, porém ainda dentro das 1h30 máxima propostas para sua aplicação. Os critérios de avalição são os mesmo para as duas partes:

1. Funcional: funcionou ou não?
2. Qualidade: examinadores avaliarão o código e darão uma nota;
3. Tempo: quanto menos tempo maior a nota.

As duas partes são:

### 1ª Parte - Validador (Validator)

Programar, em JAVA, um programa que valide se uma solução de uma jogada de Sudoku é correta ou não. Para isso será fornecido uma classe que conterá, ao menos, 3 exemplos de solução de Sudoku, onde somente 2 estarão corretas.
> As notas dadas para cada critério SOMARÃO à nota final.

### 2ª Parte - Solucionador (Solver)

Evoluir o programa do 1º Passo para também solucionar uma jogada de Sudoku e exibir o resultado (ex.: `System.out.println(..)`), e claro, utilizar a validação já implementada anteriormente para validar se a solução é correta ou não. Para isso será fornecido uma classe que conterá, ao menos, 3 jogos incompletos de Sudoku em diferentes níveis. Cabe ao programa preencher o jogo com uma solução válida.
> As notas dadas para cada critério MULTIPLICARÃO a nota da 1ª Parte

### Classe SudokuSource

Classe mencionada acima que conterá:

`SudokuSource::getSolvedMatrix(...)` Retorna uma matriz já preenchida/solucionada. Ela deve ser usada no VALIDADOR. Há 3 diferentes matrizes, 2 estão corretas e 1 incorreta.

`SudokuSource::getUnsolvedMatrix(...)` Retorna uma matriz com números faltantes. Ela deve ser usada no SOLUCIONADOR. Há 3 diferentes níveis de matriz, da mais fácil à mais dificil.

## Regras durante o desafio

1. Enquanto programam, os participantes devem commitar o código em repositório público com o nome de sua escolha;
2. Ao finalizar a 1ª Parte o participante deverá commitar o código com a mensagem "validator finished" (ex.: `git commit -m "validator finished"`);
3. Ao finalizar a 2ª Parte o participante deverá commitar o código com a mensagem "solver finished" (ex.: `git commit -m "solver finished"`);
4. As datas do último commit com as mensagens da 1ª e 2ª parte serão utilizadas para calcular o tempo usado no desafio pelo participante em ambas as partes respectivamente;
5. Ao finalizar o desafio o participante deverá mostrar ao examinador o funcionamento do que foi implementado e compartilhar o repositório do GitHub (usar qrcode) para avaliação futura;

## FAQ:

1. O participante pode arrumar o seu código da 1ª Parte na 2ª Parte, mas o tempo utilizado contará para a 2ª Parte;
2. Dúvidas e perguntas durante o desafio devem ser feitas em voz alta para todos os envolvidos ouvirem, já que a dúvida de um pode ser a mesma de outro participante;
