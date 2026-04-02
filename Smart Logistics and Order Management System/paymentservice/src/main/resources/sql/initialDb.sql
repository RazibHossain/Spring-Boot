CREATE TABLE payments (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          order_id BIGINT,
                          amount DOUBLE,
                          status VARCHAR(50),
                          transaction_id VARCHAR(255),
                          created_at DATETIME
);