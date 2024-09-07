# Local Keycloak
## Build Image
```shell
docker build . -t mykeycloak
```

## 使用外部網路
```shell
docker network create keycloak_network
```

## Docker Compose

```shell
docker compose up -d
```
