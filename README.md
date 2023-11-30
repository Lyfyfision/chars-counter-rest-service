
# Letters counter

A really small project for only 1 purpose - take an input string, count all letters in it and sort by descending order of each letter's occurrences


## API Reference

#### Count letters

```http
  POST /api/letter-count
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `input` | `string` | **Required**. Your input string for count(only alphabetical chars) |





## Documentation

[Documentation](http://localhost:8080/swagger-ui/index.html)


## Running Tests

To run tests, run the following command

```bash
  mvn test
```


## Run Locally

Clone the project

```bash
  git clone https://github.com/Lyfyfision/chars-counter-rest-service.git
```

Go to the project directory

```bash
  cd charcounter
```

Build project

```bash
  mvn package
```

Start the server

```bash
  java -cp target/charcounter-0.0.1-SNAPSHOT.jar
```

