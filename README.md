# Java Crud & Test

Small crud in java and test mockito, using spring framework and postgres.


## SQL TABLES

```bash
CREATE TABLE person (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
```

```bash
CREATE TABLE address (
    id BIGSERIAL PRIMARY KEY,
    person_id BIGINT,
    city VARCHAR(255) NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(id)
);
```


## Author

- [@jairoseo](https://github.com/jairoseo/)


