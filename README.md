# Batalha de Heróis - Java RPG

## Sobre o Projeto
Este repositório contém a implementação de um **Jogo de RPG com Sistema de Batalhas** desenvolvido em Java como parte do desafio final do módulo de Backend do curso 3035Teach. O jogo permite ao jogador escolher diferentes classes de personagens e enfrentar inimigos em uma arena de batalha, utilizando conceitos de programação orientada a objetos, herança e polimorfismo.

## Funcionalidades
- **Sistema de Classes de Personagens:**
    - **Guerreiro (Warrior):** Especialista em combate corpo a corpo com alta resistência.
    - **Mago (Mage):** Domina magias poderosas, mas tem menor resistência física.
    - **Arqueiro (Archer):** Especialista em ataques à distância com precisão.
- **Sistema de Batalha:**
    - Arena de combate onde os personagens enfrentam inimigos diversos.
    - Mecânicas de turno com opções de ataque, defesa e habilidades especiais.
    - Cálculo de dano baseado nos atributos do personagem e do inimigo.
- **Progressão de Personagem:**
    - Ganho de experiência após vitórias em batalhas.
    - Sistema de níveis que aumenta os atributos do personagem.
    - Desbloqueio de novas habilidades conforme o avanço.
- **Variedade de Inimigos:**
    - Diferentes tipos de inimigos com comportamentos e estatísticas únicas.
    - Níveis de dificuldade progressivos.

## Estrutura do Projeto
O projeto está organizado em classes que representam diferentes elementos do jogo:
- **`Character`**: Classe base para todos os personagens jogáveis e inimigos.
- **`Warrior`, `Mage`, `Archer`**: Classes específicas de personagens jogáveis com habilidades únicas.
- **`Enemy`**: Representa os adversários que os jogadores enfrentam.
- **`BattleArena`**: Gerencia o sistema de combate e interações entre personagens.
- **`GameEngine`**: Orquestra toda a lógica do jogo e a interface com o usuário.

## Mecânicas do Jogo
- **Atributos dos Personagens:**
    - **Vida (HP)**: Determina quanto dano um personagem pode suportar.
    - **Ataque**: Influencia no dano causado aos inimigos.
    - **Defesa**: Reduz o dano recebido de ataques inimigos.
    - **Velocidade**: Determina a ordem de ataque em combate.
- **Habilidades Especiais:**
    - Cada classe possui habilidades únicas com efeitos distintos.
    - Uso limitado por recursos como mana ou energia.
- **Sistema de Combate por Turnos:**
    - Os personagens mais rápidos agem primeiro.
    - Escolha entre atacar, defender, usar habilidades ou itens.

<div align="center">
  <a href="https://www.3035tech.com/" target="_blank"
  ><img
    src="https://d9hhrg4mnvzow.cloudfront.net/lp.3035tech.com/96c1669d-logo-teach-horiz-branco_1000000000000000000028.png"
    style="
      width: 100px;
      padding: 10px;
      border-radius: 10px;
    "
     target="_blank"
  /></a>
</div>
