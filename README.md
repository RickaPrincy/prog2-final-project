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
- You can create some mock data using the file [insert.sql](./src/main/resources/mock/insert.sql)
  - https://petstore.swagger.io/?url=https://gist.githubusercontent.com/RickaPrincy/888fb9c3e9b966e7d3678bae60e7f24e/raw/0de5d3d8908b614ba2a3d2cc344e6a6a19ec99b2/yaml 
# Swagger

- Here is the URL for the Swagger documentation of this API: 
  -  
- You can also view it [here](./docs/swagger.yml)
