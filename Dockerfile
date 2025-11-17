FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/demo-app.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM eclipse-temurin:17-jdk
FROM eclipse-temurin:17-jre

docker build -t myuser/demo-app:1.0 .
docker run -p 8080:8080 myuser/demo-app:1.0


docker login
docker push myuser/demo-app:1.0


minikube start

deployment.yaml

apiVersion: apps/v1
kind: Deployment
metadata:
  name: demo-app-deployment
spec:
  replicas: 2
  selector:
    matchLabels:
      app: demo-app
  template:
    metadata:
      labels:
        app: demo-app
    spec:
      containers:
        - name: demo-app
          image: myuser/demo-app:1.0
          ports:
            - containerPort: 8080
            
            
            
service.yaml


service.yaml
apiVersion: v1
kind: Service
metadata:
  name: demo-app-service
spec:
  type: LoadBalancer  # Or NodePort if using Minikube
  selector:
    app: demo-app
  ports:
    - port: 80
      targetPort: 8080


kubectl apply -f deployment.yaml
kubectl apply -f service.yaml


minikube service demo-app-service


kubectl get pods
kubectl get deployments
kubectl get services
kubectl logs <pod-name>

