-- 초기
insert into ex2_1 (column1,column2) values ('abc','abc');
select column1, length(column1) as len1,
       column2, length(column2) as len2 from ex2_1;
drop table ex2_1;
create table ex2_10(
  col1 varchar2(10) not null,
  col2 varchar2(10) null,
  create_date date default sysdate
  );
insert into ex2_10 (col1,col2) values ('test','test');
select * from ex2_10;
alter table ex2_10 rename column col1 to col11;
alter table ex2_10 modify col2 varchar2(30);
alter table ex2_10 add col3 number;
alter table ex2_10 drop column col3;
desc ex2_10;
create table ex2_10_1 as select * from ex2_10;
select * from ex2_10_1;
insert into ex2_10 values('abc','abc');
select  col2 as df from ex2_10;
drop table major;
drop table city;

select a.employee_id, a.emp_name, a.department_id, b.department_name
from ora_user.employees a, ora_user.departments b
where a.department_id=b.department_id;

select * from user_indexes;

--서울에 살고있는 학생의 이름;
select student.name from student,city where student.city=city.code and city.city='서울';

--전자 공학과;
select count(student.name) from student,major where student.major=major.code and major.name='컴퓨터공학';

--팀만들기;
create table team(
  code number primary key,
  name nvarchar2(20) not null,
  leader number ,
  constraints leader1 foreign key (leader)
  references student(no)
);

delete from team;

insert into team values(0,'자바타조',17);
insert into team values(1,'보여드리조',25);
insert into team values(2,'동반자',12);
insert into team values(3,'준비됐조',20);
insert into team values(4,'마일리지',29);
insert into team values(5,'어벤져스',6);

--어벤져스 팀장이름
select student.name from student,team where student.no=team.leader and team.name='어벤져스';

--sutdent에 팀 추가
alter table student add team number;
alter table student add constraints team1 foreign key (team) references team(code);

--insert 가 아니라 업데이트
update student set team=5 where no=0;
update student set team=0 where no=1;
update student set team=1 where no=2;
update student set team=2 where no=3;
update student set team=3 where no=4;
update student set team=5 where no=5;
update student set team=5 where no=6;
update student set team=2 where no=7;
update student set team=4 where no=8;
update student set team=0 where no=9;
update student set team=1 where no=10;
update student set team=5 where no=11;
update student set team=2 where no=12;
update student set team=3 where no=13;
update student set team=4 where no=14;
update student set team=5 where no=15;
update student set team=0 where no=16;
update student set team=0 where no=17;
update student set team=1 where no=18;
update student set team=2 where no=19;
update student set team=3 where no=20;
update student set team=4 where no=21;
update student set team=5 where no=22;
update student set team=0 where no=23;
update student set team=2 where no=24;
update student set team=1 where no=25;
update student set team=1 where no=26;
update student set team=3 where no=27;
update student set team=3 where no=28;
update student set team=4 where no=29;
update student set team=4 where no=30;

update student set team=4 where name='김서준';
select student.name from student,team where '자바타조'=team.name and student.team = team.code and student.gender='F';

create table team_1(
  name nvarchar2(20),
  major nvarchar2(20) ,
  city nvarchar2(20) 
);

create table team_1(
  name nvarchar2(20),
  major nvarchar2(20) ,
  city nvarchar2(20) 
);
create table team_2(
  name nvarchar2(20),
  major nvarchar2(20) ,
  city nvarchar2(20) 
);
create table team_3(
  name nvarchar2(20),
  major nvarchar2(20) ,
  city nvarchar2(20) 
);
create table team_4(
  name nvarchar2(20),
  major nvarchar2(20) ,
  city nvarchar2(20) 
);
create table team_5(
  name nvarchar2(20),
  major nvarchar2(20) ,
  city nvarchar2(20) 
);
create table team_6(
  name nvarchar2(20),
  major nvarchar2(20) ,
  city nvarchar2(20) 
);
delete from team_1;
insert into team_1 select student.name,major.name,city.city from student, major, city
where student.city=city.code and student.team=0 and student.major=major.code;

insert into team_1 select student.name,major.name,city.city from student, major, city
where student.city=city.code and student.team=0 and student.major=major.code;

insert into team_2 select student.name,major.name,city.city from student, major, city
where student.city=city.code and student.team=1 and student.major=major.code;

insert into team_3 select student.name,major.name,city.city from student, major, city
where student.city=city.code and student.team=2 and student.major=major.code;

insert into team_4 select student.name,major.name,city.city from student, major, city
where student.city=city.code and student.team=3 and student.major=major.code;

insert into team_5 select student.name,major.name,city.city from student, major, city
where student.city=city.code and student.team=4 and student.major=major.code ;

insert into team_6 select student.name,major.name,city.city from student, major, city
where student.city=city.code and student.team=5 and student.major=major.code;

delete from team_4 where name='김서준';

-- merge tabel 만들고 자기 팀으로 만들기 -> 여성인 사람 merge

create table merge_1(
  name nvarchar2(20),
  major nvarchar2(20),
  city nvarchar2(20) 
);

insert into merge_1 select student.name,major.name,city.city from student, major, city
where student.city=city.code and student.team=3 and student.major=major.code;
--내 답 
merge into merge_1 m
  using(select student.name,student.gender,major.name,city.city from student,major,city 
  where student.city=city.code and student.major=major.code) s
  on (s.name = m.name)
when matched then
  update set m.major = m.major
when not matched then
  insert (m.name,m.major,m.city) values (s.name,s.name,s.city)
  where (s.gender='F');

-- 강사님 답
merge into merge_1 m
  using(select student.name,student.gender,major.name as major,city.city as city from student,major,city 
  where student.city=city.code and student.major=major.code student.gender='F') s
  on (s.name = m.name)
when not matched then
  insert (m.name,m.major,m.city) values (s.name,s.major,s.city);

COMMIT;

select rownum,rowid,name||'천재' from merge_1 where rownum<5;

select a.name,b.city as city,
  case when b.code=0 then '도시'
    else '시골'
  end as city_grade
from student a, city b where a.city = b.code order by city_grade;

SELECT name from student where name like '정%';
select name from student where name like '%찬';
select name from student where name like '%종%';
select name from student where name like '정%찬';

select greatest(code,leader) from team;

select count(distinct city) from student;

select distinct major from student order by major;
select distinct b.name from student a, major b where a.major=b.code;
select sum(distinct major) from student;
select min(no),max(no) from student;

select major.name, count(*) from student,major where major.CODE=student.MAJOR group by major.name order by major.name;

select b.name as major, c.city as city, count(a.no)
from student a, major b, city c
where a.major=b.code and a.city=c.code
group by b.name,c.city
having count(a.no)>5;

select b.name as major, c.city as city, count(a.no)
from student a, major b, city c
where a.major=b.code and a.city=c.code
group by rollup( b.name, c.city);

-- 합집합
select name from student where team=0
union
select name from student where team=2;

select name from student where team=2 or team=0;

--중복 x
select name from student where team=1
union
select name from student where gender='F';

--중복
select name from student where team=1
union all
select name from student where gender='F';

--교집합
select name from student where team=3
intersect
select name from student where gender='F';

--차집합
select name from student where gender='F'
minus
select name from student where team=5;

--안티조인
select name from student where no not in ( select no from student where team=0);
select name from student a
where not exists (select 1 from student b where a.no=b.no and b.team=0);

select name from student where no not in (select no from student where city=0);
select name from student a where not exists (select no from student b where a.no=b.no and b.city=0);

select a.no,a.name from student a, student b
where a.city =b.city and a.no < b.no and a.city=0;

insert into student values(nextval,"chan",'M',15,15,10);
select a.name, b.name as major,c.city as city,d.CITY
from student a, major b, city c,team_1 d
where a.major=b.code(+) and a.city= c.code(+) and a.name=d.name(+);

select a.name,b.name from student a,major b; 