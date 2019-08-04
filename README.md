# MyWallet - hobby project (Spring Boot/Maven/AngularJS)
> This is a simple RESTful web application written in Java/Maven/Spring Boot/PostgreSQL for back-end and AngularJS for front-end development.
This project is intended to be a demonstration of how a REST API can be structured and designed using Spring Boot/Actuator and Spring Data.

## Requirement

1. JDK 1.8+ 
2. Maven 3.2+
3. PostgreSQL
4. Bootstrap 3.3+, Jquery 2.1+ and Datetimepicker for Bootstrap 3 if you use JDK9 this dependency required

## Installation

To run this application, first need to install couple of packages: jdk 1.8 and maven.

```sh
sudo apt-get install openjdk-8-jre
sudo apt-get install maven
```

## Usage

The relevant endpoints for this application are ``/api/v1/users`` and ``/api/v1/users/{id}/expenses``. 
All endpoints have the basic CRUD actions. For example, to view all users, one can navigate to:

```sh
http://localhost:8081/api/v1/users
```

Which should return the following JSON: 

```sh
{
    "content": [
        {
            "id": 1,
            "dateCreated": "2019-07-18T14:09:30.359+0000",
            "dateLastUpdated": "2019-07-18T14:09:30.359+0000",
            "firstName": "flo",
            "lastName": "akos",
            "email": "flo@gmail.com",
            "expenses": [
                {
                    "id": 2,
                    "dateCreated": "2019-07-18T14:09:59.431+0000",
                    "dateLastUpdated": "2019-07-18T14:09:59.431+0000",
                    "details": "traveling cost",
                    "amount": 1000
                }
            ]
        }
    ],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 1,
        "unpaged": false,
        "paged": true
    },
    "totalPages": 17,
    "totalElements": 17,
    "last": false,
    "number": 0,
    "size": 1,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "numberOfElements": 1,
    "first": true,
    "empty": false
}
```

For testing all the CRUD actions, I recommend using Postman.
