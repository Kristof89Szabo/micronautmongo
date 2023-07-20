- Open a terminal inside the docker container:

```
docker exec -it mongocontainername mongosh
```

- Authenticate against admin database (inside mongo container)

```
use admin 
db.auth("user","password")
```

- Insert a new fruit

```
 use fruit
 db.fruit.insertOne("alma")
```

- Get a specific fruit by name

```
db.fruit.find({name:"fruitname"})
```

- Get All fruit

```
db.fruit.find({})
```


#### Function

- Filter out all the fruit which price is 5.
```mongodb-json
db.fruit.aggregate([{$match: {price: 5}}])
```

- Group the fruit by price and show only the prices:
```mongodb-json
db.fruit.aggregate([{$group : {_id:"$price"}  }])
```

- Group by price and count how many fruit has price 5:
```mongodb-json
db.fruit.aggregate([{$match: {price: 5}}, {$count:"quantity of fruit"}])
```

[READ MORE](https://www.mongodb.com/docs/manual/aggregation/)


#### Validation

It creates a "products" collection and sets a validator that requires all documents in the collection to have the "name"
and "price" properties.

```micronaut-mongodb-json
db.createCollection("products", {
    validator: {
        $jsonSchema: {
            required: ["name","price"]
        }
    }
}
)
```

Let's create a somewhat complicated validation:

The "name" property specifies that the value should be a string (bsonType: "string") and should match the provided
pattern (pattern: "[A-Z}.*").

The "price" property specifies that the value should be an integer (bsonType: "int") and should have a minimum value of
1000 (minimum 1000) and a maximum value of 30000 (maximum 30000).

```micronaut-mongodb-json
db.createCollection("products", {
    validator: {
        $jsonSchema: {
            properties: {
                name: {bsonType: "string", pattern: "[A-Z].*"]},
                price: {bsonType: "int", minimum 1000, maximum 30000}
            }
        }
    }
}
)
```


### From terminal

You can send request from terminal :

```
curl -v -u sherlock:password localhost:8080/fruit
```





