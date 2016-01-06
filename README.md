이 프로그램을 실행 시키기 위해서는

오라클을 설치하시고

첨부된 SQL 문을 실행하여 Database 를 생성하는 과정을 

거쳐야 함을 알려드립니다.


=== 테이블 생성 쿼리 ===

create table member(
userid varchar2(20),
password varchar2(20), 
name varchar2(20),
phone varchar2(20),
addr varchar2(50),
birth varchar2(20),
que varchar2(30),
ans varchar2(30),
constraint member_pk primary key (userid)
);

create sequence food_cate_seq
start with 1;

create table food_cate(
food_cate_seq number,
cate_name varchar2(20),
constraint food_cate_pk primary key (food_cate_seq)
);

insert into food_cate(food_cate_seq, cate_name) 
values(food_cate_seq.nextval, '한식');

create sequence store_seq
start with 1;

create table store(
store_seq number,
biz_name varchar2(40) not null,
food_cate_seq number not null,
constraint store_pk primary key (store_seq),
constraint store_food_cate_fk 
foreign key (food_cate_seq)
references food_cate(food_cate_seq)
);

insert into store(store_seq, biz_name, food_cate_seq )
values(store_seq.nextval, '고봉민김밥', '1');


create sequence menu_seq
start with 1;

create table menu(
menu_seq number not null,
food_name varchar2(40) not null,
profile varchar2(20),
constraint menu_pk primary key (menu_seq)
);

insert into menu(menu_seq, food_name, profile )
values(menu_seq.nextval, '떡볶이', 'default.png');

insert into menu(menu_seq, food_name, profile )
values(menu_seq.nextval, '까르보나라 떡볶이', 'default.png');

insert into menu(menu_seq, food_name, profile )
values(menu_seq.nextval, '순대', 'default.png');

insert into menu(menu_seq, food_name, profile )
values(menu_seq.nextval, '돈까스', 'default.png');

insert into menu(menu_seq, food_name, profile )
values(menu_seq.nextval, '김치볶음밥', 'default.png');

insert into menu(menu_seq, food_name, profile )
values(menu_seq.nextval, '닭발', 'default.png');


create sequence store_menu_seq
start with 1;

create table store_menu(
store_menu_seq number not null,
store_seq number not null,
menu_seq number not null,
price number not null,

constraint store_menu_pk primary key (store_menu_seq),
constraint store_menu_store_fk 
foreign key (store_seq)
references store(store_seq),
constraint store_menu_menu_fk 
foreign key (menu_seq)
references menu(menu_seq)
);

insert into store_menu(store_menu_seq, store_seq, menu_seq, price)
values(store_menu_seq.nextval,'1', '1', '4000');

insert into store_menu(store_menu_seq, store_seq, menu_seq, price)
values(store_menu_seq.nextval,'1', '2', '6000');

insert into store_menu(store_menu_seq, store_seq, menu_seq, price)
values(store_menu_seq.nextval,'1', '3', '4000');

insert into store_menu(store_menu_seq, store_seq, menu_seq, price)
values(store_menu_seq.nextval,'1', '4', '6000');

insert into store_menu(store_menu_seq, store_seq, menu_seq, price)
values(store_menu_seq.nextval,'1', '5', '6000');

insert into store_menu(store_menu_seq, store_seq, menu_seq, price)
values(store_menu_seq.nextval,'1', '6', '15000');


