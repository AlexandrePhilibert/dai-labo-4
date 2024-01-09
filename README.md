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

TODO

## Deploy the app

TODO 

## Access the app

In order to access the app (the swagger), go to : https://icecreamtruck.lol/redoc.

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