## Equipe 04
- Mohamed-Bilel CHRIKI
- Théo PORET
- Yanis YACHIR
- Marilou ZIRI
  
# Projet : Puissance 4
### Les différentes tâches
- Création du Puissance 4 en java
- Création du Serveur et du Client en java
- Mise en relation avec le docker

Le Puissance 4 final se présente sous la forme ci-dessous :
![Image](./connect4.png)

## Puissance 4

Pour la création du Puissance 4, nous l'affichons avec une interface graphique en swing. Notre puissance 4 est constitué d'une frame pour qu'il soit en en dehors d'un terminal et que cela soit plus simple à utiliser plutôt que de rentre des coordonnées dans le terminal, cela est donc plus simple pour jouer. 
![Image](./image.png)

Nous avons donc ajouté sur cette frame des boutons dans les cases du tableau pour éviter d'utiliser des flèches ou de rentrer des coordonnées.
![Image](./Capture_decran_du_2024-04-16_18-19-53.png)

Quant à la création du serveur et du client, nous avons fait en sorte qu'il y'ait une connexion entre le client et le serveur, le client n'a juste qu'à renseigner l'IP et lorsque deux clients sont connectés, la partie peut commencer. 
![Image](./img.png)

Cela fait, une frame pour chaque client se mettant à jour automatiquement après qu'un des joueurs ait placé un jeton apparait et les joueurs peuvent commencer la partie.
//image debut de  game

A la fin, quand un joueur gagne, un message sortant dans les terminaux des clients indique le gagnant et les frames se ferment.
![Image](./imge.png)

## Docker

Enfin le docker fait fonctionner le serveur, une fois le conteneur lancer, les fichiers sont compiler et le serveur est lancé, c'est lui qui récupère les coups des joueurs et qui envoie le positionnement des différents jetons dans le tableau.

Tout cela a permis de faire fonctionner en réseau notre Puissance 4.

## Problèmes rencontrés :

- Nous avons eu des problèmes par rapport à la mise en relation entre les deux clients avec le docker (localhost et adresse IP).
- L'interface graphique devait passer par le client et pas uniquement par le serveur, ce qui était faisable en local.

