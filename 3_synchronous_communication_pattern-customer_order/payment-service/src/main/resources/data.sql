--CREATE TABLE payments (
--    id BIGINT AUTO_INCREMENT PRIMARY KEY,
--    amount DOUBLE,
--    payment_method VARCHAR(255),
--    status VARCHAR(255),
--    order_id BIGINT
--);

insert into payments (amount, payment_method, status, order_id) values (100.50, 'CREDIT_CARD', 'COMPLETED', 1);
insert into payments (amount, payment_method, status, order_id) values (250.75, 'PAYPAL', 'PENDING', 2);
