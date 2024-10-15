# dat250-expass3.md

### Technical Issues and Resolution

During the installation and use of MongoDB, I did not encounter any significant issues. The installation process followed the official MongoDB documentation, and all necessary tools (MongoDB Compass and MongoDB Shell) were successfully installed. However, there was a problem encountered while running the Map-Reduce operation within MongoDB Compass due to trying to output results into the `local` database, which is restricted for internal use only.

### Screenshots

1. **Validation of Installation Package**:
  <img width="707" alt="ss1-dat250" src="https://github.com/user-attachments/assets/84d34e92-4b79-4821-9df3-31f93ccf16c6">


2. **Experiment 1 Results (CRUD Operations)**:
   
  <img width="707" alt="ss3-dat250" src="https://github.com/user-attachments/assets/e5c8d3a6-8f49-4ec3-bf44-5cb2534470e4">
  <img width="707" alt="ss3-dat250" src="https://github.com/user-attachments/assets/17cb6dba-bd53-409c-ba36-daf85b04a8b1">
  <img width="707" alt="ss4-dat250" src="https://github.com/user-attachments/assets/4e62e576-21c4-42ff-8828-911ec5ff88f6">
  <img width="707" alt="ss5-dat250" src="https://github.com/user-attachments/assets/57c0e239-e060-4ab9-a96d-c4f480dffc32">

### Experiment 2: Map-Reduce Example and Custom Operation

For Experiment 2, the Map-Reduce example was successfully executed with the following steps:

#### Example Operation

The Map-Reduce function aggregated the total `price` of orders per customer (`cust_id`), which was a basic aggregation example.

**Map Function**:
```javascript
var mapFunction = function() {
    emit(this.cust_id, this.price);
};
```

**Reduce Function**:
```javascript
var reduceFunction = function(keyCustId, valuesPrices) {
    return Array.sum(valuesPrices);
};
```

**Execution**:
```javascript
db.orders.mapReduce(
    mapFunction,
    reduceFunction,
    { out: "total_orders_per_customer" }
);
```

Results:
The collection `total_orders_per_customer` contained the aggregated total order value for each customer, grouped by `cust_id`.

#### Custom Operation

The custom Map-Reduce operation I implemented aggregated the total quantity of items purchased by each customer across all orders. This provides an overview of how many individual items were purchased by each customer, regardless of the price.

**Custom Map Function**:
```javascript
var mapFunction2 = function() {
    var totalQty = this.items.reduce((sum, item) => sum + item.qty, 0);
    emit(this.cust_id, totalQty);
};
```

**Reduce Function**:
```javascript
var reduceFunction2 = function(keyCustId, valuesQty) {
    return Array.sum(valuesQty);
};
```

**Execution**:
```javascript
db.orders.mapReduce(
    mapFunction2,
    reduceFunction2,
    { out: "total_qty_per_customer" }
);
```

### Reasoning Behind the Custom Map-Reduce Operation

The custom Map-Reduce operation that I implemented, which aggregates the total quantity of items purchased by each customer, is particularly useful for analyzing purchasing behavior. Unlike simply summing the total value of orders, it gives insights into the number of individual items purchased.
