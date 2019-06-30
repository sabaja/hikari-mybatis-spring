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

create table user(
ID int(10) NOT NULL AUTO_INCREMENT,  
   NAME varchar(100) NOT NULL,
   EMAIL varchar(255) NOT NULL,
   PRIMARY KEY ( ID )
   );

Commit;

select * from student;