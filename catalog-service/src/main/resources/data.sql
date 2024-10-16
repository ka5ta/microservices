drop table if exists products cascade;
drop table if exists inventory cascade;

CREATE TABLE PRODUCTS (
    uniq_id UUID PRIMARY KEY,
    sku VARCHAR(15),
    name_title VARCHAR(150),
    description VARCHAR,
    list_price VARCHAR(25),
    sale_price VARCHAR(25),
    category VARCHAR(50),
    category_tree VARCHAR(100),
    average_product_rating VARCHAR(25),
    product_url VARCHAR,
    product_image_urls VARCHAR,
    brand VARCHAR(50),
    total_number_reviews VARCHAR(25),
    reviews VARCHAR

) as select * from CSVREAD('classpath:jcpenney_com-ecommerce_sample.csv');


CREATE TABLE INVENTORY (
    uniq_id UUID,
    availability NUMERIC,
    FOREIGN KEY (uniq_id) REFERENCES PRODUCTS(uniq_id)
) as select uniq_id, FLOOR(RAND() * 1000) from PRODUCTS;