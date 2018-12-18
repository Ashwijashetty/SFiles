 CREATE TABLE USERS(
  login_id varchar2(5) primary key,
  password varchar2(10) not null,
  role varchar2(5) not null
   );
   
  insert into users values('admin','admin123','admin');
  insert into users values('mac','mac123','mac');
  
   CREATE TABLE PROGRAMS_OFFERED(
    Program_Name varchar2(20) not null,
    description varchar2(20) not null,
    applicant_eligibility varchar2(40) not null,
    duration number,
    degree_certificate_offered varchar2(10) not null
    );
    
    CREATE TABLE Programs_scheduled(
     scheduled_program_id varchar2(5),
     program_name varchar2(5),
     location varchar2(10),
     start_date date,
     end_date date,
     sessions_per_week number
    );
 CREATE TABLE Programs_scheduled(
    scheduled_program_id varchar2(5) unique,
    program_name varchar2(5) unique,
    location varchar2(10),
    start_date date,
    end_date date,
    sessions_per_week number
    );