CREATE TABLE orders (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        customer_name VARCHAR(255) ,
                        customer_email VARCHAR(255) ,
                        order_date DATETIME ,
                        status VARCHAR(50) 
) ENGINE=InnoDB;

CREATE TABLE order_items (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             product_name VARCHAR(255) ,
                             product_code VARCHAR(255) ,
                             quantity INT ,
                             unit_price DECIMAL(10,2) ,
                             subtotal DECIMAL(10,2) ,
                             order_id BIGINT,

                             CONSTRAINT fk_order_items_order
                                 FOREIGN KEY (order_id)
                                     REFERENCES orders(id)
                                     ON DELETE CASCADE
) ENGINE=InnoDB;

alter table order_items
    add product_id int null;