create database eip_ajax;
use eip_ajax;
DROP TABLE IF EXISTS `dept`;
create table dept
(
    dept_id     int auto_increment primary key,
    dept_name   varchar(30)  not null,
    dept_office varchar(30)  not null
)AUTO_INCREMENT=100;


DROP TABLE IF EXISTS `employee`;
create table employee
(
    emp_id    int auto_increment primary key,
    id_number varchar(20)  not null,
    emp_name  varchar(20)  not null,
    gender    varchar(10)  null,
    birth     varchar(20)  not null,
    photo     longblob     not null,
    email     varchar(30)  not null,
    phone     varchar(30)  not null,
    tel       varchar(30)  null,
    address   varchar(30)  not null
)AUTO_INCREMENT=1000;

DROP TABLE IF EXISTS `emergency`;
create table emergency
(
    emergency_id            int auto_increment primary key,
    emergency_name          varchar(30)  not null,
    emergency_phone         varchar(30)  not null,
    emergency_relationship  varchar(30)  not null,
    emp_id                  int          not null,
    constraint emergency_ibfk_1 foreign key (emp_id) references employee (emp_id)
);

DROP TABLE IF EXISTS `login`;
create table login
(
    emp_id     int           not null primary key,
    password   varchar(255)  not null,
    constraint login_ibfk_1 foreign key (emp_id) references employee (emp_id)
);


DROP TABLE IF EXISTS `title`;
create table title
(
    title_id    int auto_increment primary key,
    title_name  varchar(30)  not null
)AUTO_INCREMENT=100;

DROP TABLE IF EXISTS `employee_info`;
create table employee_info
(
    emp_id   int not null primary key,
    dept_id  int not null,
    title_id int not null,
    constraint employee_info_ibfk_1 foreign key (emp_id) references employee (emp_id),
    constraint employee_info_ibfk_2 foreign key (dept_id) references dept (dept_id),
    constraint employee_info_ibfk_3 foreign key (title_id) references title (title_id)
);

#打卡:
DROP TABLE IF EXISTS `office_regions`;
create table office_regions
(
    regions_id   int auto_increment,
    latitude     double      not null,
    longitude    double      not null,
    regions_name varchar(20) not null,
    constraint office_regions_pk
        primary key (regions_id)
);

DROP TABLE IF EXISTS `clock_time`;
create table clock_time
(
    clock_time_id int auto_increment,
    emp_id        int         not null,
    time          datetime    not null,
    type          varchar(10) not null,
    regions_id    int         null,
    constraint clock_time_pk
        primary key (clock_time_id),
    constraint clock_time_employee_emp_id_fk
        foreign key (emp_id) references employee (emp_id),
    constraint clock_time_office_regions_regions_id_fk
        foreign key (regions_id) references office_regions (regions_id)
);

DROP TABLE IF EXISTS `attendance`;
create table attendance
(
    attendance_id int auto_increment,
    date          date          not null,
    emp_id        int           not null,
    total_hours   decimal(4, 2) not null,
    status        varchar(10)   not null,
    constraint attendance_pk
        primary key (attendance_id),
    constraint attendance_employee_emp_id_fk
        foreign key (emp_id) references employee (emp_id)
);

INSERT INTO dept(dept_name, dept_office)
VALUES('人事','就人事'),('行政','就行政'),('總務','就總務');

INSERT INTO title(title_name)
VALUES('工讀生'),('菜鳥'),('組長'),('經理');



INSERT INTO employee(id_number, emp_name, gender, birth, photo,Phone, Tel, Address, Email)
VALUES
    ('A123456789', 'anddie', '男', '1997-09-04', '12345','0912345678', '02-12345678', '台北市中山區', 'u06m4d93@gmail.com'),
    ('B987654321', '陳美麗', '女', '1985-05-15', '54321','0987654321', NULL, '新北市板橋區', 'lisi@email.com'),
    ('C456789012', '李大宇', '男', '1992-11-30', '98765','0912345678', '02-23456789', '台北市信義區', 'wangwu@email.com'),
    ('D789012345', '林靜心', '女', '1988-07-20', '67890','0912345678', '03-12345678', '桃園市中壢區', 'liuqi@email.com'),
    ('E234567890', '張文彬', '男', '1995-03-05', '23456','0987654321', '03-23456789', '新竹市東區', 'chenba@email.com'),
    ('F567890123', '黃美玲', '女', '1997-12-18', '78901','0912345678', '04-12345678', '台中市西屯區', 'qianjiu@email.com'),
    ('G890123456', '劉小華', '男', '1987-09-02', '34567','0987654321', '04-23456789', '台中市北區', 'sunti@email.com'),
    ('H123456789', '陳怡君', '女', '1994-06-10', '89012','0912345678', '05-12345678', '台南市東區', 'zhouyiyi@email.com'),
    ('I345678901', '吳宏偉', '男', '1998-04-03', '45678','0987654321', '05-23456789', '台南市南區', 'wushi@email.com'),
    ('J678901234', '許雅琪', '女', '1991-08-05', '01234','0987654321', '02-34567890', '台北市大安區', 'zhaoliu@email.com');

INSERT INTO employee_info(emp_id, dept_id, title_id)
VALUES(1000,100,103),
      (1001,101,101),
      (1002,100,100),
      (1003,100,102),
      (1004,100,100),
      (1005,100,100),
      (1006,100,101),
      (1007,100,101),
      (1008,101,103),
      (1009,102,103);

INSERT INTO emergency(emergency_name, emergency_phone, emergency_relationship, emp_id)
VALUES
    ('張三', '091-111-1111', '父親', 1000),
    ('李四', '092-222-2222', '母親', 1001),
    ('王五', '093-333-3333', '兄弟', 1002),
    ('陳六', '094-444-4444', '姐妹', 1003),
    ('林七', '095-555-5555', '其他', 1004),
    ('吳八', '096-666-6666', '朋友', 1005),
    ('朱九', '097-777-7777', '父親', 1006),
    ('鄭十', '098-888-8888', '母親', 1007),
    ('郭十一', '099-999-9999', '兄弟', 1008),
    ('廖十二', '091-101-1010', '姐妹', 1009);





INSERT INTO login(emp_id, password)
 VALUES
                                       (1000,'100'),
                                       (1001,'950215'),
                                       (1002,'880930'),
                                       (1003,'920712'),
                                       (1004,'850425'),
                                       (1005,'981103'),
                                       (1006,'910618'),
                                       (1007,'970308'),
                                       (1008,'871220'),
                                       (1009,'941005');


