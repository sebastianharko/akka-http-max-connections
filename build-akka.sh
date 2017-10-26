#!/bin/sh
sbt clean
sbt universal:packageBin
docker build -t akka-http-max-connections:0.1 .
docker tag akka-http-max-connections:0.1 sebastianharko/akka-http-max-connections:0.1
docker push sebastianharko/akka-http-max-connections:0.1