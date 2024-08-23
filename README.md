# Ticket API

Integración con la API de Zendesk y gestión de carreras.

## Requisitos

- JDK 22
- Maven 3.6 o superior

## Configuración

Antes de ejecutar el proyecto, se debe configurar `url`, `email` y `apiToken` de la API de Zendesk. Se puede hacerlo añadiendo las propiedades necesarias en el archivo `application.yml` dentro del directorio `src/main/resources`.

### Propiedades necesarias en `application.yml`

```yaml
zendesk-api:
  url: "https://miempresa.zendesk.com/api/v2"  # Reemplaza 'miempresa' con tu subdominio real en Zendesk
  email: "usuario@dominio.com"       # Ejemplo de dirección de correo electrónico (reemplaza con tu correo real)
  token: "d2FsajYyM2xsb2VwMTIzNA=="  # Ejemplo de token API (reemplaza con tu token real)
  new-comment: "Comentario de ejemplo agregado automáticamente"  # Comentario de ejemplo

