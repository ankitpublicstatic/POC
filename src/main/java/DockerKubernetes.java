/*

Kubernetes / K8 : alternate of k8s: Marathon, Docker compose


POD > Pod can have single container or multiple container, Pod having single IP address, 

Node > Node can have single pod or multi Pod,

Cluster > Multiple node wrapped with a single cluster. 

Replica Sets > For handling down time of POD.

Service > Service is handling about communication between One set of Pods to another set of Pods like

Frontend Pod > connect with Backend Pod that time if Backend Pod goes down then new backend pod will up but Backend pod ip will change, same Service will act like static IP with service DNS name so frontend pod will communicate via Service DNS name instead of Backend pod ip address. 

Service type: Cluster IP, Node Port, Load Balancer

Deployment:
==========

Deployments are kubernetes objects that are used for managing pods. 
You can scale your app by increasing the number of running pods or update the running application using Deployment object. 

$ kubectl create deployment first-deployment - image=<Docker_Image_Name> --port=8080 --replicas=4

Secrets & ConfigMap> Use to store Password, API Key, Configuration. 
===================
Secrets: Encrypted text, ConfigMap: Plain Text
 
ETCD: Kubernetes uses etcd as a key-value database store. It stores the configuration of the Kubernetes cluster in etcd. 

It stores all the secret and ConfigMap data inside etcd database. 

Max limits is 1 mb to store secrets. 

$ brew install kubectl

$ brew install hyperkit

$ brew list

$ brew install minikube

$ minikube start

$ minikube status

$ kubectl cluster-info

$ kubectl get nodes

$ minikube stop



Dockerfile > For Create docker images
=============


FROM openjdk:8
EXPOSE 8080
ADD target/spring-app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

$ minikube start

$ minikube status

$ eval $(minikube docker-env)

$ cd project-folder

$ ls -l

$ docker build -t springapp-k8s-app:1.0 .

$ docker images

$ kubectl create deployment spring-boot-k8s --image=springboot-k8s-demo:1.0 --port=8080  # will create new deployment object

$ kubectl get deployment  

$ kubectl describe deployment spring-boot-k8s  

$ kubectl get pods

$ kubectl logs spring-boot-pod-name

$ kubectl expose deployment spring-boot-k8s --type=NodePort # will create new service

$ kubectl get service

$ minikube service spring-boot-k8s --url # to access your endpoint of container which is running in pod  

$ minikube dashboard # to access GUI K8s dashboard  


Deployment.yaml > For deploy docker images on k8 pods container
================


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
          imagePullPolicy: IfNotPresent
          ports:
            - containerPort: 8080
            

$ kubectl apply -f deployment.yaml

$ kubectl get deployments

$ kubectl get pods

$ kubectl logs <pod-name> > to check app running logs as well            




service.yaml > For handling load balancer for which pod/container to send the request to serve the application
============




#type: NodePort/ClusterIp/LoadBalancer

$ kubectl apply -f service.yaml
$ kubectl get svc # to get service info 
$ kubectl get service
$ kubectl get nodes -o wide # to get access of node IP. 
$ minikube ip

to get access of deployed app as service in k8 we have to use <node-ip>:<node-port>

http://192.168.10.4:32208/

$ minikube dashboard

minikube service demo-app-service



kubectl get services

$ kubectl delete deployment spring-boot-k8s

$ kubectl get pods

$ kubectl delete service spring-boot-k8s

$ kubectl get svc 

$ minikube stop  

$ minikube delete  

mysql_deployment.yaml
======================

apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: mysql-pv-claim
  labels: 
    app: mysql
    tier: database
spec:
  accessModes: 
    - ReadWriteOnce # This specifies the mode of the claim that we are trying to create.  
  resources:
    requests:
      storage: 1Gi # This will tell kubernetes about the amount of space we are trying to claim

---
# Configure 'Deployment' of mysql server.  

apiVersion: apps/v1
kind: Deployment
metadata:
  name: mysql
  labels: 
    app: mysql
    tier: database
spec:
  replicas: 2
  selector:
    matchLabels:
      app: mysql
      tier: database
  strategy:
    type: Recreate
  template:
    metadata:
      labels:
        app: mysql
        tier: database
    spec:
      containers:
        - name: mysql
          args:
            - "--ignore-db-dir=lost+found"
          image: mysql:5.7 # image from docker-hub
          env:
            - name: MYSQL_ROOT_PASSWORD
              value: root
              valueFrom:
                secretKeyref:
                  name: mysql-secret
                  key: password  
            - name: MYSQL_DATABASE
              #value: ankit 
              valueFrom:
                configMapKeyref:
                  name: db-config
                  key: dbName 
          imagePullPolicy: IfNotPresent
          ports:
            - containerPort: 3306
              name: mysql
          volumeMounts: # Mounting volume obtained from Persistent Volume claim
            - name: mysql-persistent-storage
              mountPath: /var/lib/mysql  # This is the path in the container on which the mounting will take place. 
      volumes:
        - name: mysql-persistent-storage
        PersistentVolumeClaim:
          claimName: mysql-pv-claim


---
# Define a Service To expose mysql to other Services

apiVersion: v1
kind: Service
metadata:
  name: mysql
  labels:
    app: mysql
    tier: database
spec:
  selector:
    app: mysql
    tier: database
  clusterIP: None # We use DNS, Thus ClusterIp is not relevant
  ports:
    - port: 3306 # The port that the service is running on in the cluster
      targetPort: 3306 # The port exposed by the 

$ kubectl apply -f mysql_deployment.yaml

$ kubectl get pods

$ kubectl exec -it <mysql_pod_name> /bin/bash  

$ mysql -h mysql -u root -p root  

$ show database

$ use ankit


application.properties file java spring boot appp

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://${DB_HOST}/${DB_NAME}?useSSL=false
    username: ${DB_USERNAME}  
    password: ${DB_PASSWORD}  
    hikari:
      initialization-fail-timeout: 0
  jpa:
    database-platform: org.hibernate.dialect.MySQL5Dialect
    generate-ddl: true  
    show-sql: true  
    hibernate:
      ddl-auto: update  

$ docker build -t spring-boot-curd-k8s:1.0 .


app_deployment.yaml


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
          imagePullPolicy: IfNotPresent
          ports:
            - containerPort: 8080
          env: # Setting Environmental Variables
            - name: DB_HOST
              #value: mysql  
              valueFrom:
                configMapKeyref:
                  name: db-config
                  key: host 
            - name: DB_NAME
              #value: mysql 
              valueFrom:
                configMapKeyref:
                  name: db-config
                  key: dbName 
            - name: DB_USERNAME
              # value: root  
              valueFrom:
                secretKeyref:
                  name: mysql-secret
                  key: username

            - name: DB_PASSWORD
              #value: root  
              valueFrom:
                secretKeyref:
                  name: mysql-secret
                  key: password
---


apiVersion: v1
kind: Service
metadata:
  name: demo-app-service
spec:
  # type: LoadBalancer  # Or NodePort if using Minikube
  selector:
    app: demo-app
  ports:
    - protocol: "TCP"
      port: 8080 # The port that the service is running on in the cluster
      targetPort: 8080 # The port exposed by the service
  type: NodePort # type of service


mysql_configmap.yaml
==========================

apiVersion: v1
kind: ConfigMap  
metadata:
  name: db-config
data:
  host: mysql  
  dbName: ankit


mysql-secrets.yaml
==================
apiVersion: v1
kind: Secret  
metadata:
  name: mysql-secret
data:
  username: cm9vdA==  
  password: cm9vdA==


echo -n 'root' | base64

*/
