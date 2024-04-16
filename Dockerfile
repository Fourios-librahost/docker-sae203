FROM debian:latest

RUN apt-get update && \
    apt-get -y install openjdk-17-jre && \
    apt-get -y install openjdk-17-jdk && \
    apt-get -y install screen

COPY ./exercice5a /app/exercice5a

# Définition du répertoire de travail
WORKDIR /app

# Commande par défaut à exécuter lorsque le conteneur démarre
CMD ["/bin/bash", "-c", "tr -d '\r' < /app/exercice5a/start.sh > /app/exercice5a/fixed.sh && bash /app/exercice5a/fixed.sh ; tail -f /dev/null"]
