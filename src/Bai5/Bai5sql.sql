CREATE database bai5;
use bai5;
CREATE TABLE patients
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    fullname   VARCHAR(255),
    age        INT,
    department VARCHAR(255),
    checkin date,
    checkout date,
    priceofday double
);
INSERT INTO patients (fullname, age, department, checkin, checkout, priceofday) VALUES
('Nguyen Van A', 25, 'Nội', '2026-03-20', '2026-03-25', 500000),
('Tran Thi B', 30, 'Ngoại', '2026-03-18', '2026-03-22', 700000),
('Le Van C', 45, 'Tim mạch', '2026-03-15', '2026-03-21', 1200000),
('Pham Thi D', 50, 'Thần kinh', '2026-03-10', '2026-03-19', 1500000),
('Hoang Van E', 60, 'Hô hấp', '2026-03-12', '2026-03-20', 900000);
DELIMITER $$
CREATE PROCEDURE CALCULATE_DISCHARGE_FEE (in p_id int,out total_fee double)
begin
    select priceofday*(datediff(checkout,checkin))into total_fee from patients where id=p_id;
end $$
DELIMITER $$
set @free=0;
call CALCULATE_DISCHARGE_FEE(1,@free);
select @free;
