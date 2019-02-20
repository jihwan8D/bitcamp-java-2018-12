-- 게시판 테이블 생성
create table x_board(
  board_id int not null primary key,
  title varchar(225) not null,
  contents text null,
  created_date datetime null,
  view_count int null
);
