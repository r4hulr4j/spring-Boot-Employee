INSERT INTO product (id, name, category, price, stock, rating, brand, active) VALUES
(1, 'iPhone 17', 'Mobile', 89999, 20, 4.8, 'Apple', true),
(2, 'Galaxy S30', 'Mobile', 79999, 15, 4.6, 'Samsung', true),
(3, 'Pixel 11', 'Mobile', 74999, 18, 4.7, 'Google', true),
(4, 'OnePlus 15', 'Mobile', 59999, 25, 4.5, 'OnePlus', true),
(5, 'MacBook Air M6', 'Laptop', 109999, 10, 4.9, 'Apple', true),
(6, 'ThinkPad X1', 'Laptop', 129999, 5, 4.7, 'Lenovo', true),
(7, 'Dell XPS 15', 'Laptop', 119999, 8, 4.6, 'Dell', true),
(8, 'HP Spectre', 'Laptop', 99999, 12, 4.4, 'HP', true),
(9, 'Sony WH-1000XM7', 'Headphones', 29999, 30, 4.8, 'Sony', true),
(10, 'AirPods Pro 3', 'Headphones', 24999, 40, 4.7, 'Apple', true),
(11, 'Galaxy Buds 4', 'Headphones', 14999, 35, 4.3, 'Samsung', true),
(12, 'JBL Tune 800', 'Headphones', 5999, 50, 4.2, 'JBL', true),
(13, 'LG UltraFine 27', 'Monitor', 32999, 14, 4.5, 'LG', true),
(14, 'Dell UltraSharp', 'Monitor', 38999, 11, 4.7, 'Dell', true),
(15, 'Samsung Odyssey G7', 'Monitor', 45999, 9, 4.8, 'Samsung', true),
(16, 'Logitech MX Keys', 'Keyboard', 9999, 45, 4.6, 'Logitech', true),
(17, 'Keychron K8', 'Keyboard', 7999, 38, 4.7, 'Keychron', true),
(18, 'Razer BlackWidow', 'Keyboard', 11999, 22, 4.4, 'Razer', false),
(19, 'Asus ROG Strix', 'Laptop', 149999, 6, 4.8, 'Asus', true),
(20, 'Boat Rockerz 550', 'Headphones', 2499, 60, 4.1, 'Boat', true);


INSERT INTO department (title, is_active, created_at) VALUES
('Engineering', true, '2025-01-01'),
('Human Resources', true, '2025-01-05'),
('Finance', true, '2025-01-10'),
('Marketing', true, '2025-01-15'),
('Operations', false, '2025-01-20');



INSERT INTO employees
(name, email, dob, active, role, prime_number)
VALUES
('Rahul Raj', 'rahul@example.com', '1998-05-12', true, 'ADMIN', 2),

('Neeraj Waddar', 'neeraj@example.com', '2000-07-16', true, 'ADMIN', 3),

('Amit Sharma', 'amit@example.com', '1997-08-22', true, 'USER', 3),

('Neha Singh', 'neha@example.com', '1999-03-15', true, 'USER', 5),

('Rohan Gupta', 'rohan@example.com', '1996-11-08', false, 'ADMIN', 7),

('Priya Verma', 'priya@example.com', '2000-02-17', true, 'USER', 11),

('Vikram Patel', 'vikram@example.com', '1995-09-10', true, 'USER', 13),

('Anjali Mehta', 'anjali@example.com', '1998-12-05', true, 'ADMIN', 17),

('Karan Malhotra', 'karan@example.com', '1997-07-14', true, 'USER', 19),

('Sneha Nair', 'sneha@example.com', '1999-04-28', false, 'USER', 23),

('Arjun Rao', 'arjun@example.com', '1996-01-18', true, 'ADMIN', 29),

('Pooja Iyer', 'pooja@example.com', '1998-06-21', true, 'USER', 31),

('Manish Kumar', 'manish@example.com', '1997-10-30', true, 'USER', 37),

('Deepak Yadav', 'deepak@example.com', '1995-05-09', false, 'ADMIN', 41),

('Kavya Reddy', 'kavya@example.com', '2001-08-13', true, 'USER', 43),

('Nikhil Jain', 'nikhil@example.com', '1998-02-24', true, 'USER', 47),

('Meera Das', 'meera@example.com', '1999-09-11', true, 'ADMIN', 53),

('Suresh Pillai', 'suresh@example.com', '1996-03-19', true, 'USER', 59),

('Ritika Kapoor', 'ritika@example.com', '2000-12-07', true, 'USER', 61),

('Aditya Sen', 'aditya@example.com', '1997-04-16', false, 'ADMIN', 67),

('Shreya Bose', 'shreya@example.com', '1999-11-25', true, 'USER', 71);