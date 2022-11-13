

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

```
JENKINS_HOST: localhost
JENKINS_USER: user
JENKINS_PASS: bitnami
```
**************************************************

### Jenkins to Server
Ubuntu 20.04

Java 11
```
sudo apt-get update
sudo apt-get install openjdk-11-jdk -y
java -version
```
Jenkins
```
wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -
sudo apt-add-repository "deb https://pkg.jenkins.io/debian-stable binary/"
sudo apt-get update
sudo apt-get install jenkins -y
```



Para solucionar el problema de certificado:
```
sudo apt-get upgrade -y
```

bonus fix ubuntu
Fixing “Unable to lock the administration directory (/var/lib/dpkg/)” error

- deshabilitar las actualizaciones automaticas
- software & updates> update> Download and install automatically

ps aux | grep -i dpkg
```
sudo killall apt apt-get
```
- delete todos estos archivos
```
  sudo rm /var/lib/dpkg/lock
  sudo rm /var/lib/apt/lists/lock
  sudo rm /var/cache/apt/archives/lock
```



### Jenkins to Docker
Agregar usurio ubuntu al grupo docker
sudo usermod -aG docker $(whoami)

Agregar usurio jenkins al grupo docker
sudo usermod -aG docker jenkins

sudo reboot

