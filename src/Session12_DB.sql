create database session12;
use session12;
create table doctors
(
    id   int primary key auto_increment,
    code varchar(255),
    pass varchar(255)
);
insert into doctors (code, pass)
VALUES ('chubabi', '123'),
       ('monhanho', '123');
CREATE TABLE patients (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100),
    temperature DOUBLE,
    heart_rate INT
);
insert into patients( full_name, temperature, heart_rate) values ('an',34.5,4);
select *from patients;
CREATE TABLE surgeries (
    surgery_id INT PRIMARY KEY AUTO_INCREMENT,
    surgery_name VARCHAR(100),
    base_cost DOUBLE,
    insurance_percent DOUBLE
);
INSERT INTO surgeries (surgery_name, base_cost, insurance_percent) VALUES
('Mo ruot thua', 5000, 0.8),
('Mo tim', 20000, 0.5),
('Mo nao', 30000, 0.3);
DELIMITER $$
CREATE PROCEDURE GET_SURGERY_FEE (in id int,out total_cost double)
begin
    select surgeries.base_cost*surgeries.insurance_percent into total_cost from surgeries surgeries where surgery_id=id;
end $$
DELIMITER $$
set @free=0;
call GET_SURGERY_FEE(1,@free);
select @free;
CREATE table result(
    id int auto_increment primary key ,
    fullname varchar(255),
    depcripsion varchar(255),
    date datetime
);
INSERT INTO result (fullname, depcripsion, date) VALUES
('Nguyen Van A', 'Hb: 13.5, RBC: 4.5, WBC: 6.2, Platelets: 250 → Bình thường', NOW()),
('Tran Thi B', 'Hb: 10.2 → Thiếu máu nhẹ, cần bổ sung sắt', NOW()),
('Le Van C', 'WBC: 12.5 → Nghi nhiễm trùng', NOW()),
('Pham Thi D', 'Platelets: 100 → Giảm tiểu cầu', NOW()),
('Hoang Van E', 'Hb: 15.0, RBC: 5.2 → Bình thường', NOW()),
('Do Thi F', 'WBC: 3.5 → Bạch cầu thấp', NOW()),
('Nguyen Van G', 'Hb: 9.5 → Thiếu máu nặng', NOW()),
('Tran Van H', 'Platelets: 400 → Tiểu cầu cao', NOW()),
('Le Thi I', 'RBC: 3.8 → Hồng cầu thấp', NOW()),
('Pham Van K', 'Các chỉ số ổn định → Bình thường', NOW());