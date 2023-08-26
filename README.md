# RPM
RPM is a simple API project manager for basic usage. In the future (perhaps), there will be an interface for it. However, for the moment, it is just a simple REST API.

# Getting Started

- Create the database using the [migration file](src/main/resources/migrations/migration.sql).
- Set up environment variables as follows
 
```shell
    DB_PASSWORD=12345678 #your password 
    DB_URL=jdbc:postgresql://localhost:5432/prog2final
    DB_USERNAME=postgres #your postgresql username
```
 
- That's it! You are now able to run the server.

# Swagger

- Here is the URL for the Swagger documentation of this API: 
  - https://petstore.swagger.io/?url=https://gist.githubusercontent.com/RickaPrincy/888fb9c3e9b966e7d3678bae60e7f24e/raw/ebe1a64c618f6e36ca234f74aa4596fbe34b2827/yaml
- You can also view it [here](./docs/swagger.yml)
