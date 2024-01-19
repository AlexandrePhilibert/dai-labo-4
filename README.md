# Icetrucks

This RESTful API allows you to manage your ice cream trucks and ice creams.

## Members

| Member | Role |
|--------------------------------------------------------------|------------------------|
| [Valentin Ricard](https://github.com/valentin-ricard)        | Writing code           |
| [Alexandre Philibert](https://github.com/AlexandrePhilibert) | Writing Code           |
| [Gwendal Piemontesi](https://github.com/gwendalpiemonte/)    | Deployment             |
| [Guillaume Trüeb](https://github.com/truebguillaume/)        | Secretary + Deployment |

## Server setup

In case you just started with a fresh linux install and you want to install this software, 
a detailed manual is available over at [SERVER_SETUP.md](SERVER_SETUP.md)

## Deploy the app

If you are a more seasoned sys-admin, you can install Icecream truck Simulator with the following:

**Pre-requisites**:
- You need a working installation of docker
- The port `443` **MUST** be accessible on the internet
  (the default compose provides a loadbalancer with automatic certificate issuance)

After that, you can download the prepared [docker-compose.yaml file](./docker-compose.yml),
configure it to your liking, and profit 💸💸💸
```shell
wget https://github.com/AlexandrePhilibert/dai-labo-4/raw/main/docker-compose.prod.yml
mv docker-compose.prod.yaml docker-compose.yaml
# Replace everything within angle brackets with your values
${VISUAL:-${EDITOR:-vi}} "docker-compose.yaml"
# Start the container stack
docker compose up -d
# Wait a minute for the certificates to be issued, and tada!
```

## Access the app

In order to access the app (the swagger), go to : https://icecreamtruck.lol/docs.

## Configure the DNS zone

Create an A record for the API:

```
A icecreamtruck.lol <the server ip>
```

Create an A record for the whoami:

```
A whoami.icecreamtruck.lol <the server ip>
```

## Docker

Build the docker image:

```sh
docker build -t ghcr.io/alexandrephilibert/icecreamtruck:latest
``` 

You can publish the image to ghcr using the following command:

```sh
docker push ghcr.io/alexandrephilibert/icecreamtruck:latest
```

You must have the `package:write` permissions in order to push the image.

Here is the [link](https://github.com/AlexandrePhilibert/dai-labo-4/pkgs/container/icecreamtruck) to the docker image.

## Examples

TODO