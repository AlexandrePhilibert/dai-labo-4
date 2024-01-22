# Icetrucks

This RESTful API allows you to manage your ice cream trucks and ice creams.

## Demo

You can access the public instance of this service over at https://icecreamtruck.lol

## Members

| Member | Role |
|--------------------------------------------------------------|------------------------|
| [Valentin Ricard](https://github.com/valentin-ricard)        | Writing code           |
| [Alexandre Philibert](https://github.com/AlexandrePhilibert) | Writing Code           |
| [Gwendal Piemontesi](https://github.com/gwendalpiemonte/)    | Deployment             |
| [Guillaume Trüeb](https://github.com/truebguillaume/)        | Secretary + Deployment |

## Deploy the app

If you are a more seasoned sys-admin, you can install Icecream truck Simulator with the following:

**Pre-requisites**:
- You need a working installation of docker (see https://github.com/docker/docker-install for a convenience script)
- The port `443` **MUST** be accessible on the internet
  (the default compose provides a loadbalancer with automatic certificate issuance)
- Get your token to interact with the GHCR repository
  (see [Github's documentation](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-container-registry#authenticating-to-the-container-registry)
  to get started)

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

In order to access the API documentation, go to : https://<your domain>/docs.

## Configure the DNS zone

Create an A record for the API:

```
A <your domain> <the server ip>
```

Create an A record for the whoami service:

```
A whoami.<your domain> <the server ip>
```

## Docker

Build the docker image:

```sh
docker build -t ghcr.io/alexandrephilibert/dai-labo-4:latest
``` 

You can publish the image to ghcr using the following command:

```sh
docker push ghcr.io/alexandrephilibert/dai-labo-4:latest
```

You must have the `package:write` permissions in order to push the image.

Here is the [link](https://github.com/AlexandrePhilibert/dai-labo-4/pkgs/container/dai-labo-4) to the docker image.

## Examples

You can learn more about the design of the documentation on [USAGE.md](USAGE.md).

By default, the application also provides an interactive documentation at `<your server url>/docs`