select user from dual;
select table_name from user_tables;
select table_name from user_tables;
select * from user_tables;
create table ex2_1 (
colum1  char(10),
colum2  varchar2(10),
colum3  nvarchar2(10),
colum4  number
);
select * from ex2_1;
insert into ex2_1(colum1,COLUM2) VALUES ('abc','abc');
select colum1, LENGTH(colum1) as len1,
      colum2, LENGTH(colum2) as len2 from ex2_1;
      
      DROP TABLE ex2_1;
      
      CREATE TABLE ex2_10(
      Col1 varchar2(10) not null,
      Col2 varchar2(10) null,
      Create_date date default sysdate);
      
      insert into ex2_10(COL1,COL2) VALUES ('test','test');
      
      select * from ex2_10;
      
      insert into ex2_10(COL1,COL2) VALUES ('hallo','');
      
      ALTER TABLE ex2_10 RENAME COLUMN col1 TO col11;
      
         ALTER TABLE ex2_10 modify  col2 varchar2(30);
         
  ALTER TABLE ex2_10 add col3 number;
  
  alter table ex2_10 drop column col3;
  
  create table ex2_10_1 as select*from ex2_10;
  
  select*from ex2_10_1;
  
  create table tbl_major(
  m_code number ,
  m_name nvarchar2(10));
  
   create table tbl_city(
  c_code number ,
  c_name nvarchar2(10));
  
  create table tbl_students(
  s_number number,
  s_name nvarchar2(10),
  s_gender nvarchar2(10)
  constraints check1 check (s_gender in('male','female'),
  s_major number

  
  select * from user_indexes;
  
  