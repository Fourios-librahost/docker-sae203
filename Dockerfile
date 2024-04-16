FROM debian:latest

RUN apt-get update && \
    apt-get -y install openjdk-17-jre

COPY ./exercice5a /app/exercice5a

# CMD ["bash","/app/exercice5a/start.sh"]

# Définition du répertoire de travail
WORKDIR /app

# Commande par défaut à exécuter lorsque le conteneur démarre
CMD ["tail", "-f", "/dev/null"]