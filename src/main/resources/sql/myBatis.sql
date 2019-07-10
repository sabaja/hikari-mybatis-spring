create schema MYBATIS;

use MYBATIS;

DROP TABLE IF EXISTS student;
CREATE TABLE  student(
   ID int(10) NOT NULL AUTO_INCREMENT,  
   NAME varchar(100) NOT NULL,
   BRANCH varchar(255) NOT NULL,
   PERCENTAGE int(3) NOT NULL,  
   PHONE int(10) NOT NULL,
   EMAIL varchar(255) NOT NULL,
   PRIMARY KEY ( ID )
);

DROP TABLE IF EXISTS users;
create table users(
ID int(10) NOT NULL AUTO_INCREMENT,  
   NAME varchar(100) NOT NULL,
   EMAIL varchar(255) NOT NULL,
   PRIMARY KEY ( ID )
   );

Commit;

select * from student;

select id, name, email from user;
select * from users;

truncate users;

CREATE TABLE users (SELECT * FROM user);

SHOW VARIABLES LIKE "general_log%";

SET GLOBAL log_output = 'TABLE';
SET GLOBAL general_log = 'ON';

select * from mysql.general_log 
where user_host like '%127.%'
order by event_time desc;