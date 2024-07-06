
-- create database
create Database if not exists StudentManagementSystem;
-- Use the database
USE StudentManagementSystem;

-- Drop the table if it exists
DROP TABLE IF EXISTS SMS;

-- Create the table
CREATE TABLE SMS(
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(20) DEFAULT NULL,
    last_name VARCHAR(20) DEFAULT NULL,
    email VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (id)
);

-- Insert sample data into the table
INSERT INTO SMS (first_name, last_name, email) VALUES 
('Ahmed', 'Khan', 'ahmed.khan@example.com'),
('Fatima', 'Ali', 'fatima.ali@example.com'),
('Mohamed', 'Hassan', 'mohamed.hassan@example.com'),
('Ibrahim', 'Suleiman', 'ibrahim.suleiman@example.com'),
('Mariam', 'Hussein', 'mariam.hussein@example.com');
select * from SMS;