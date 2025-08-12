INSERT INTO product (name, price, description, manufactureDate) VALUES ('Laptop Pro 15', 45900.00, 'Low performance laptop for professionals', '2020-02-01');
INSERT INTO product (name, price, description, manufactureDate) VALUES ('Wireless Mouse', 790.00, 'Ergonomic wireless mouse', '2021-05-15');
INSERT INTO product (name, price, description, manufactureDate) VALUES ('Mechanical Keyboard', 2890.00, 'RGB backlit mechanical keyboard', '2022-08-10');
INSERT INTO product (name, price, description, manufactureDate) VALUES ('Smartphone X', 32900.00, 'Flagship smartphone with OLED display', '2023-01-20');
INSERT INTO product (name, price, description, manufactureDate) VALUES ('Noise Cancelling Headphones', 5990.00, 'Over-ear headphones with active noise cancellation', '2019-11-05');

INSERT INTO CustomerTier (id, name) VALUES (1, 'Bronze');
INSERT INTO CustomerTier (id, name) VALUES (2, 'Silver');
INSERT INTO CustomerTier (id, name) VALUES (3, 'Gold');
INSERT INTO CustomerTier (id, name) VALUES (4, 'Platinum');




INSERT INTO customer (name, address, email, phone, birthDay,customerTier_id) VALUES ('Somchai Prasert', '123 Sukhumvit Rd, Bangkok', 'somchai@example.com', '0812345678', '1995-07-12',1);
INSERT INTO customer (name, address, email, phone, birthDay, customerTier_id) VALUES ('Somsri Dee', '456 Rama IV Rd, Bangkok', 'somsri@example.com', '0898765432', '1990-05-20', 2);
INSERT INTO customer (name, address, email, phone, birthDay, customerTier_id) VALUES ('Chaiyo Phetkasem', '789 Phetkasem Rd, Nonthaburi', 'chaiyo@example.com', '0922334455', '1988-11-01', 1);
INSERT INTO customer (name, address, email, phone, birthDay, customerTier_id) VALUES ('Malee Srichan', '101 Ratchada Rd, Bangkok', 'malee@example.com', '0656789012', '1992-02-28', 3);
