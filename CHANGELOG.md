

### Contenedores
Para construir el contenedor

```
docker build . -f Dockerfile.development -t <TAG_IDENTIFICADOR> --network host


# Deploy Jenkins to Docker
docker pull bitnami/jenkins:latest
docker network create jenkins-network
docker volume create --name jenkins_data
docker run -d -p 80:8080 --name jenkins \
  --network jenkins-network \
  --volume jenkins_data:/bitnami/jenkins \
  bitnami/jenkins:latest

```
