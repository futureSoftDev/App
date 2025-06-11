# Kubernetes manifests

This directory contains Kubernetes resources for running the services that make up the bank application.

Apply all manifests using:

```bash
kubectl apply -f k8s/
```

The manifests assume images are available in a registry as referenced in each Deployment.
