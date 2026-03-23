create database Baitapthuchanh;
use Baitapthuchanh;
CREATE TABLE Doctors
(

    doctor_id        INT PRIMARY KEY AUTO_INCREMENT,

    full_name        VARCHAR(100) NOT NULL,

    specialty        VARCHAR(50)  NOT NULL,

    experience_years INT          NOT NULL,

    base_salary      DOUBLE       NOT NULL,

    password         VARCHAR(255) NOT NULL
);
INSERT INTO Doctors (full_name, specialty, experience_years, base_salary, password)
VALUES ('BS. Nguyễn Văn An', 'Nội khoa', 10, 20000000, 'pass_an_123'),

       ('BS. Lê Thị Bình', 'Nhi khoa', 5, 15000000, 'pass_binh_456'),

       ('BS. Trần Quang Đạo', 'Ngoại khoa', 15, 30000000, 'pass_dao_789'),

       ('BS. Phạm Minh Anh', 'Nhi khoa', 3, 12000000, 'pass_anh_abc'),

       ('BS. Hoàng Đức Trung', 'Sản khoa', 8, 18000000, 'pass_trung_xyz');
DELIMITER $$
CREATE PROCEDURE calculate_duty_fee(IN d_id INT, OUT duty_fee DOUBLE)
begin
    SELECT (base_salary / 30) * experience_years into duty_fee from Doctors where doctor_id = d_id;
end$$
DELIMITER $$;
SET @free = 0;
CALL calculate_duty_fee(1, @free);
SELECT @free;