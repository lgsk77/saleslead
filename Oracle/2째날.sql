

drop sequence seq_1;

create SEQUENCE seq_1
increment by 1
start with 0
minvalue 0
maxvalue 100
nocycle
nocache;

insert into major values(seq_1.currval,'');
insert into major values(seq_1.nextval,'정보보안');
insert into major values(seq_1.nextval,'컴퓨터공학');
insert into major values(seq_1.nextval,'기계공학');
insert into major values(seq_1.nextval,'전기공학');
insert into major values(seq_1.nextval,'전자정보공학');
insert into major values(seq_1.nextval,'정보공학');
insert into major values(seq_1.nextval,'중어중문학');
insert into major values(seq_1.nextval,'수학');
insert into major values(seq_1.nextval,'행정학');
insert into major values(seq_1.nextval,'기계정보학');
insert into major values(seq_1.nextval,'산업공학');
insert into major values(seq_1.nextval,'경영정보학');

delete  from major;


create table major(
  code number primary key,
  name nvarchar2(20) NOT null);  
create table city(
  code number primary key,
  name nvarchar2(20) NOT NULL);
create table students(
  no number primary key,
  name nvarchar2(20) NOT NULL,
  gender char(1) NOT NULL,
  constraints check1 check(gender in('m','f')),
  major number NOT NULL,
  constraints major1 foreign key(major)
  references major(code),
  city number NOT NULL,
  constraints city1 foreign key(city)
  references city(code),
  created_at date default sysdate);
  
  drop table major;
  drop table city;
  drop table students;
  
  drop sequence seq_1;
  drop sequence seq_2;
  drop sequence seq_3;
  
  
  
  create sequence seq_2 start with 0
                        increment by 1
                        minvalue 0
                        maxvalue 100
                        nocycle
                        nocache;
                        
  delete from city;
                        
  select seq_2.currval from dual;
  
  drop sequence seq_2;
  insert into city values(seq_2.nextval,'서울');
  insert into city values(seq_2.nextval,'부천');
  insert into city values(seq_2.nextval,'창원');
  insert into city values(seq_2.nextval,'부산');
  insert into city values(seq_2.nextval,'인천');
  insert into city values(seq_2.nextval,'수원');
  insert into city values(seq_2.nextval,'대구');
  insert into city values(seq_2.nextval,'충주');
  insert into city values(seq_2.nextval,'구미');
  insert into city values(seq_2.nextval,'광명');
  
  select * from city;
  select * from major;
  select * from students;
create sequence seq_3
increment by 1
start with 0
minvalue 0
maxvalue 100
nocycle
nocache;

delete from students;
drop sequence seq_3;

select * from students;
select * from major;


insert into students(no,name,gender,major,city) values(seq_3.currval,'','m',0,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'강동훈','m',9,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'곽다인','f',1,5);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'김기호','m',1,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'김동근','m',5,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'김서준','m',1,1);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'김아연','f',5,7);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'김우성','m',7,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'김지혜','f',4,9);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'라건주','f',1,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'민동연','m',1,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'박민호','m',3,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'박정은','f',0,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'박중균','m',8,8);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'박지용','m',10,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'박찬준','m',1,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'박창환','m',1,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'박초롱','f',1,5);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'박태준','m',3,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'방가은','f',2,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'양성준','m',5,4);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'유희상','m',4,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'윤장원','m',1,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'이명구','m',5,4);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'이명우','m',2,9);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'이수진','f',6,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'이창주','m',4,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'이호성','m',11,3);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'임연주','f',1,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'정종찬','m',1,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'조인환','m',1,0);
insert into students(no,name,gender,major,city) values(seq_3.nextval,'최민진','f',4,1);


select * from students;

select a.no, a.name, a.gender, b.name as major, c.name as city, a.team
from students a, major b, city c
where a.major = b.code and a.city = c.code
order by a.no asc;

/*  여까지 만들기*/


select name from students where city = 0 ;
select count(name) from students where city=0;

select a.name from students a, city b
where a.city = b.code and b.name = '서울'
order by a.name desc;


select name from students where major = 4;

select count(name) from students where major = 4;
select count(a.name) from students a, major b
where a.major = b.code and b.name = '전자정보공학';

select * from students;


/*-----------------------------------------------------------------*/

create table team(
  code number primary key,
  name nvarchar2(20) not null,
  leader number ,
  constraints leader1 foreign key (leader)
  references students (no)
  );
  
  
  insert into team values(0,'자바타조',17);
  insert into team values(1,'보여드리조',25);
  insert into team values(2,'동반자',12);
  insert into team values(3,'준비됐조',20);
  insert into team values(4,'마일리지',29);
  insert into team values(5,'어벤져스',6);
  
  select * from students;
  
  select a.name from students a, team b
  where a.no =b.leader and b.name='어벤져스';
------------테이블에 team컬럼추가(외래키)----------  
  alter table students add team number;
  alter table students add constraints team1 foreign key(team)
  references team(code);
  
update students set team=5 where no=0;
update students set team=0 where no=1;
update students set team=1 where no=2;
update students set team=2 where no=3;
update students set team=4 where no=4;
update students set team=5 where no=5;
update students set team=5 where no=6;
update students set team=2 where no=7;
update students set team=4 where no=8;
update students set team=0 where no=9;
update students set team=1 where no=10;
update students set team=5 where no=11;
update students set team=2 where no=12;
update students set team=3 where no=13;
update students set team=4 where no=14;
update students set team=5 where no=15;
update students set team=0 where no=16;
update students set team=0 where no=17;
update students set team=1 where no=18;
update students set team=2 where no=19;
update students set team=3 where no=20;
update students set team=4 where no=21;
update students set team=5 where no=22;
update students set team=0 where no=23;
update students set team=2 where no=24;
update students set team=1 where no=25;
update students set team=1 where no=26;
update students set team=3 where no=27;
update students set team=3 where no=28;
update students set team=4 where no=29;
update students set team=4 where no=30;

 select * from students;
 ------------마일리지조 몇명인지-----------
 select count(a.name) from students a, team b
 where a.team=b.code and b.name ='마일리지';
 --------자바타조 여자 수강생-----
 
 select count(a.name) from students a, team b
 where a.team=b.code and b.name ='자바타조' and a.GENDER='f';
 
 drop table team6;
 
 create table team_1 (
 name nvarchar2(10),
 major nvarchar2(10),
 city nvarchar2(10));
 
 create table team_2 (
 name nvarchar2(10),
 major nvarchar2(10),
 city nvarchar2(10));
 
 create table team_3 (
 name nvarchar2(10),
 major nvarchar2(10),
 city nvarchar2(10));
 
 create table team_4 (
 name nvarchar2(10),
 major nvarchar2(10),
 city nvarchar2(10));
 
 create table team_5 (
 name nvarchar2(10),
 major nvarchar2(10),
 city nvarchar2(10));
 
 create table team_6 (
 name nvarchar2(10),
 major nvarchar2(10),
 city nvarchar2(10));
 
insert into team_1 values('곽다인','컴퓨터공학','수원');

delete from  team_1 ;

insert into team_1(name,major,city)
select a.name, b.name, c.name from students a, major b, city c
where a.major=b.code and a.city=c.code and a.team =0;

insert into team_2(name,major,city)
select a.name, b.name, c.name from students a, major b, city c
where a.major=b.code and a.city=c.code and a.team =1;

insert into team_3(name,major,city)
select a.name, b.name, c.name from students a, major b, city c
where a.major=b.code and a.city=c.code and a.team =2;

insert into team_4(name,major,city)
select a.name, b.name, c.name from students a, major b, city c
where a.major=b.code and a.city=c.code and a.team =3;

insert into team_5(name,major,city)
select a.name, b.name, c.name from students a, major b, city c
where a.major=b.code and a.city=c.code and a.team =4;

insert into team_6(name,major,city)
select a.name, b.name, c.name from students a, major b, city c
where a.major=b.code and a.city=c.code and a.team =5;

select * from team_6;

 create table merge_1 (
 name nvarchar2(10),
 major nvarchar2(10),
 city nvarchar2(10));
 
insert into merge_1 
select * from team_4;

select*from merge_1;

 select * from students;

merge into merge_1 
  using (select a.no, a.name, a.gender, b.name as major, c.name as city, a.team
       from students a, major b, city c
       where a.major = b.code and a.city = c.code and a.gender = 'f') e
    on(merge_1.name = e.name)
  when matched then
    update set merge_1.major=e.major,merge_1.city=e.city
  when not matched then
    insert (merge_1.name,merge_1.major,merge_1.city) values (e.name,e.major,e.city);
    
select a.no, a.name, a.gender, b.name as major, c.name as city, a.team  
from students a, major b, city c
where a.major = b.code and a.city = c.code and a.gender = 'f'
order by a.no asc;

create table distance(
  city nvarchar2(20),
  dis number
);

insert into distance values('부천',35);
insert into distance values('창원',364);
insert into distance values('부산',392);
insert into distance values('인천',43);
insert into distance values('수원',44);
insert into distance values('대구',285);
insert into distance values('충주',126);
insert into distance values('구미',243);
insert into distance values('광명',26);

select dis from distance;

select greatest(select dis from distance),
least(select dis from distance)
    from distance;

select greatest(1,2,3,2),
least(1,2,3,2)
    from distance;

