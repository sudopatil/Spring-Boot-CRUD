The url for api calls are as followed :(using postman or crul)
To post new data in DB POST : http://localhost:8080/product
raw body : {
                    "name": "IPhone 16",
                    "price": 199.99,
                    "description": "The storage of this device is just amazing."
          }

To get all data from DB GET : http://localhost:8080/product
To get a specific product from DB GET: http://localhost:8080/product/id
To update a specific product from DB UPDATE: http://localhost:8080/product/id  
To delete a specific product from DB DELETE: http://localhost:8080/product/id
