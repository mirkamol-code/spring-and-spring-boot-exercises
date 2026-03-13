-- TODO: 13 - Add seed data for the orders table
--  INSERT INTO orders (description, status, total_amount, customer_email, order_date, internal_notes)
--  VALUES ('Laptop', 'PENDING', 999.99, 'john@mail.com', '2024-01-15', 'rush delivery');
--  Add at least 3 more rows with different statuses
INSERT INTO orders (description, status, total_amount, customer_email, order_date, internal_notes)
VALUES ('Gaming Mouse', 'PENDING', 59.99, 'alice@example.com', '2026-03-10', 'Deliver in the afternoon');

INSERT INTO orders (description, status, total_amount, customer_email, order_date, internal_notes)
VALUES ('Mechanical Keyboard', 'SHIPPED', 129.50, 'bob@example.com', '2026-03-11', 'Tracking number sent');

INSERT INTO orders (description, status, total_amount, customer_email, order_date, internal_notes)
VALUES ('27-inch Monitor', 'DELIVERED', 299.00, 'charlie@example.com', '2026-03-12', 'Left at front desk');