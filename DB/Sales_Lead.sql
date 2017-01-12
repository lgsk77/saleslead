create table notebook(
  id nvarchar2(20) primary key
);

create table member(
  id nvarchar2(20) primary key,
  password nvarchar2(20) not null,
  name nvarchar2(20) not null,
  phonenumber number not null,
  email nvarchar2(20) not null,
  category nvarchar2(20) not null,
  constraints cate foreign key(category)
  references notebook(id),
  accountno number not null,
  grade number not null
);
