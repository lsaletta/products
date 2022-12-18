CREATE TABLE PRODUCTS
(
    ID          INT PRIMARY KEY,
    SEQUENCE INT
)
AS
SELECT *
FROM CSVREAD('./src/main/resources/product.csv');

CREATE TABLE SIZES
(
    ID          INT PRIMARY KEY,
    PRODUCTID INT,
    BACKSOON BOOLEAN,
    SPECIAL BOOLEAN
)
AS
SELECT *
FROM CSVREAD('./src/main/resources/size.csv');

CREATE TABLE STOCKS
(
    SIZEID          INT PRIMARY KEY,
    QUANTITY INT
)
AS
SELECT *
FROM CSVREAD('./src/main/resources/stock.csv');