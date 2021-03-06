#Quabbly Backend Internship Project

***
#GitHub Repository
https://github.com/Leonardra/quabblyStocks
***
# Project Description
This is a simple CRUD Application where a Stock object can be Created, Retrieved, Updated and Deleted from the database.


#Prerequisites
* Java 11
* Maven
* PostMan
* MySQL


##To build
```shell
mvn clean install
```

##Database
To set up the database, run the sql script in [./resources/db/setup-db.sql](src/main/resources/db/setup-db.sql) on MySQL
##To run
```shell
java -jar ./target/quabblyStocks.jar
```


#Rest API Usage
***

##Create Stock
> #### P0ST http://localhost:8080/api/v1/stocks/

#####Parameter
 ```json
  {
  "name":"Computer",
  "currentPrice":600000.00
 }
```

##Response
####200 OK on successful request

```json
  {
  "id": 2,
  "name": "Computer",
  "currentPrice": 600000.0,
  "createdDate": "2022-02-22",
  "updatedDate": "2022-02-22"
 }
```
***
##Find Stock
> #### GET http://localhost:8080/api/v1/stocks/{id}

#####Parameter
 ```
 Stock Id: Provide the id of the Stock
```

##Response
####302 FOUND on successful request

```json
      {
        "id": 2,
        "name": "Computer",
        "currentPrice": 600000.0,
        "createdDate": "2022-02-22",
        "updatedDate": "2022-02-22"
      }
```
***
##Find All Stocks
> #### GET http://localhost:8080/api/v1/stocks/


##Response
####302 FOUND on successful request

```json
  [
  {
    "id": 1,
    "name": "Television",
    "currentPrice": 400000,
    "createdDate": "2022-02-22",
    "updatedDate": "2022-02-22"
  },
  {
    "id": 2,
    "name": "Computer",
    "currentPrice": 600000,
    "createdDate": "2022-02-22",
    "updatedDate": "2022-02-22"
  }
]
```
***

##Delete Stock
> #### DELETE http://localhost:8080/api/v1/stocks/{id}

#####Parameter
 ```
 Stock Id
```

##Response
####200 OK on successful request
***
##Update Stock
> #### PUT http://localhost:8080/api/v1/stocks/{id}

#####Parameters
Path Parameter: Stock id
 ```json
  {
  "name":"Laptop",
  "currentPrice":600000.00
 }
```

##Response
####200 OK on successful request

```json
      {
      "id": 2,
      "name": "Laptop",
      "currentPrice": 600000,
      "createdDate": "2022-02-22",
      "updatedDate": "2022-02-22"
      }
```


