# spring boot 3

 - Spring Web MVC
 - JSON for Java 
 - Model
 - DB & JPA
 - Docker
 - Postgres DB
 - Instal PostgreSQL Driver and Spring Data JPA Dependencies
 - Datasource Configuration
 - Create DB
 - @Entity
 - Generated Table and Sequence
 - Customer Repository
 - Postman
 - Read Customer API
 - Create Customer API
 - Delete Customer API
 - Update Customer API


 ## docker-compose.yml
        - docker exec -it postgres24 bash
        - psql -U root
        - CREATE DATABASE customer;
        - \l
        - \c customer
        - insert into customer(id, name, email, age)
        - values (nextval('customer_id_sequence'), 'John', 'john@gmail.com', 27);

## postman
       - get - http://localhost:8080/api/v1/customers
       - post - http://localhost:8080/api/v1/customers        
        {    
            "name": "Alex",
            "email": "alex@gmail.com",
            "age": 30
        }
        

       - put - http://localhost:8080/api/v1/customers/1        
        {    
            "name": "Helen",
            "email": "helen@gmail.com",
            "age": 26
        }
        
