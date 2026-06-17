-- Demo data
INSERT INTO users (username, password, email, phone, address, role, created_at, updated_at) VALUES
('admin', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 'admin@bookstore.com', '13800000001', 'Beijing Haidian St 1', 'ADMIN', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('reader01', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 'reader01@example.com', '13800000002', 'Shanghai Pudong', 'CUSTOMER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('booklover', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 'booklover@example.com', '13800000003', 'Guangzhou Tianhe', 'CUSTOMER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO books (isbn, title, author, publisher, description, price, stock, category, cover_image_url, created_at, updated_at) VALUES
('978-7-111-11111-1', 'Software Engineering Intro', 'Zhang Haifan', 'Tsinghua UP', 'Classic SE textbook', 59.00, 100, 'CS', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('978-7-111-22222-2', 'Thinking in Java', 'Bruce Eckel', 'China Machine Press', 'Java classic', 89.00, 80, 'CS', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('978-7-111-33333-3', 'Spring in Action', 'Craig Walls', 'Posts Press', 'Spring guide', 79.00, 60, 'CS', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('978-7-111-44444-4', 'Mythical Man-Month', 'F. Brooks', 'Tsinghua UP', 'SE management', 49.00, 120, 'SE', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('978-7-111-55555-5', 'Intro to Algorithms', 'T. Cormen', 'China Machine Press', 'Algorithm bible', 128.00, 50, 'CS', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('978-7-111-66666-6', 'Understanding JVM', 'Zhou Zhiming', 'China Machine Press', 'JVM deep dive', 79.00, 70, 'CS', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('978-7-111-77777-7', 'Three-Body Problem', 'Liu Cixin', 'Chongqing Press', 'Sci-fi novel', 45.00, 200, 'Sci-Fi', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('978-7-111-88888-8', '100 Years of Solitude', 'G. Marquez', 'Nanhai Pub', 'Magical realism', 39.50, 150, 'Fiction', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('978-7-111-99999-1', 'Design Patterns', 'E. Gamma', 'China Machine Press', 'GoF patterns', 69.00, 85, 'CS', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('978-7-111-99999-2', 'Refactoring', 'M. Fowler', 'Posts Press', 'Code refactoring', 75.00, 90, 'SE', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('978-7-111-99999-3', 'To Live', 'Yu Hua', 'Writer Press', 'Life story', 35.00, 180, 'Fiction', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('978-7-111-99999-4', 'AI Modern Approach', 'S. Russell', 'Tsinghua UP', 'AI textbook', 158.00, 40, 'CS', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);