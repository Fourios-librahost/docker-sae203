## Equipe 04
docker-sae203

## Instructions pour lancer l'application

- Vérifiez si docker est installé :
```shell
docker --version
```

- Cloner le référentiel :
 ```shell
git clone git@github.com:Fourios-librahost/docker-sae203.git
```

- Aller au référentiel :
```shell
cd docker-sae203
```

- Construisez l'image décrite dans dockerfile avec docker build : 
```shell
docker build -t puissance4-img .
```

- Lancer le serveur Java :
```shell
docker run --name puissance4 -d -p 5000:5000 puissance4-img
```

- Vérifier que le conteneur associé est actif :
```shell
docker ps
```

- La sortie de ```docker ps``` doit être similaire à :
```shell
CONTAINER ID   IMAGE          COMMAND              CREATED          STATUS          PORTS                                       NAMES
e8a8v206b43c   puissance4-img "      ...       "   30 minutes ago   Up 30 minutes   0.0.0.0:5000->5000/tcp, :::5000->5000/tcp   puissance4
```

## Instructions pour jouer (sur une machine distante)

- Assurez-vous d'être connecter sur le même réseau (Wifi ou filaire)

- Cloner le référentiel :
 ```shell
git clone git@github.com:Fourios-librahost/docker-sae203.git
```

- Aller au référentiel :
```shell
cd docker-sae203/exercice5a
```

- Compilez les fichiers :
```shell
java *.java
```

- Lancez le jeu :
```shell
java ClientPuissance4 <IP>
```
Pour ce qui concerne l'IP, vous devez renseigner l'IP local du serveur.

## Instructions pour supprimer le serveur

- Arrêtez le conteneur avec la commande suivante :
```shell
docker stop puissance4
```

- Encore, si on souhaite supprimer le conteneur, on peut taper :
```shell
docker rm puissance4
```
