CREATE TABLE role_service_permissions (
                                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                          role_id VARCHAR(100),
                                          service_name VARCHAR(100),      -- ORDER, PAYMENT
                                          permission_name VARCHAR(100)    -- ORDER_ACCESS
);

CREATE TABLE role_api_permissions (
                                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                      role_id VARCHAR(100),
                                      service_name VARCHAR(100),
                                      path VARCHAR(255),
                                      method VARCHAR(10),
                                      permission_name VARCHAR(100) -- ORDER_DELETE
);

INSERT INTO role_api_permissions (id, role_id, service_name, path, method, permission_name) VALUES (1, 'admin', 'orderservice', '/orderservice/**', 'Get', 'All');
INSERT INTO role_api_permissions (id, role_id, service_name, path, method, permission_name) VALUES (2, 'admin', 'PRODUCTS', '/products/getAll', 'GET', 'Product_Add');

INSERT INTO authservice.role_service_permissions (id, role_id, service_name, permission_name) VALUES (1, 'admin', 'orderservice', 'orderservice');
INSERT INTO authservice.role_service_permissions (id, role_id, service_name, permission_name) VALUES (2, 'admin', 'products', 'productservice');
