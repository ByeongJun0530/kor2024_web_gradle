insert into category (cate_name) values ("패션");
insert into category (cate_name) values ("가전");
insert into category (cate_name) values ("식품");
insert into category (cate_name) values ("스포츠/레저");
insert into category (cate_name) values ("뷰티");

insert into member (mname, mid, mpwd) values ("김아무", "qwe1", "asd1");
insert into member (mname, mid, mpwd) values ("최아무", "qwe2", "asd2");
insert into member (mname, mid, mpwd) values ("이아무", "qwe3", "asd3");
insert into member (mname, mid, mpwd) values ("오아무", "qwe4", "asd4");
insert into member (mname, mid, mpwd) values ("박아무", "qwe5", "asd5");

insert into product (pro_name, cate_no) values ("피스터블 초콜릿", 3);
insert into product (pro_name, cate_no) values ("핸드크림", 5);
insert into product (pro_name, cate_no) values ("냉장고", 2);
insert into product (pro_name, cate_no) values ("축구화", 4);
insert into product (pro_name, cate_no) values ("경량패딩", 1);

insert into order_list (order_amount, address, mno, pro_no) values (3, "서울시 송파구", 1, 3);
insert into order_list (order_amount, address, mno, pro_no) values (4, "울산광역시 중구", 2, 1);
insert into order_list (order_amount, address, mno, pro_no) values (5, "인천광역시 미추홀구", 3, 2);
insert into order_list (order_amount, address, mno, pro_no) values (6, "서울시 은평구", 4, 5);
insert into order_list (order_amount, address, mno, pro_no) values (7, "양주시 양주1동", 5, 4);
