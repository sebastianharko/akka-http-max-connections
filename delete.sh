#!/bin/sh
kubectl delete deployment akka-deployment
kubectl delete deployment golang-deployment
kubectl delete service akka
kubectl delete service golang
