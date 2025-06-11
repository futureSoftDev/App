# Bank Application

This repository contains multiple Spring Boot microservices. The `k8s` directory holds Kubernetes manifests for running them in a cluster.

## Running with Kubernetes

1. Ensure container images referenced in the manifests are available (build with Maven Jib or pull from Docker Hub).
2. Apply all resources:

```bash
kubectl apply -f k8s/
```

Each service will be exposed via a `NodePort` defined in its manifest.
