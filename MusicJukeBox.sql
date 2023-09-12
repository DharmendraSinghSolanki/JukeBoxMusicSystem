create database songs;
use songs;
create table userdetails(user_Id int primary key auto_increment,
userName varchar(30),phone_No varchar(30),email varchar(30),password varchar(50));
select * from userdetails;
desc userdetails;
delete from userdetails;
drop table userdetails;

create table songsList(song_id int primary key auto_increment,
album_name varchar(150),album_genre varchar(30),album_artist varchar(30),album_duration varchar(30),album_path varchar(260));
insert into songsList value(1,"Let_Me_Love","POP","Justin_Biber","3.26","D:\\Wave 42 NIIT Assisment\\Course 7 JukeBox Project\\Songs\\Let_Me_Love_You_320(PagalWorld.com.se).wav");
insert into songsList value(2,"Har_Har_Sambhu","Bhajan","Jettu_Sharma","5.54","D:\\Wave 42 NIIT Assisment\\Course 7 JukeBox Project\\JukeBoxJavaMiniProject\\songs\\Har Har Shambhu Shiv Mahadeva(PagalWorld.com.se).wav");
insert into songsList value(3,"O_Sajan","POP","Neha_Kakkar","4.05","D:\\Wave 42 NIIT Assisment\\Course 7 JukeBox Project\\JukeBoxJavaMiniProject\\songs\\O Sajna - Neha Kakkar.wav");
insert into songsList value(4,"Jai_Shree_Ram","POP","Vikram_Montrose","3.20","D:\\Wave 42 NIIT Assisment\\Course 7 JukeBox Project\\JukeBoxJavaMiniProject\\songs\\Jai-Shree-Ram(PaglaSongs).wav");
select*from songsList;
alter table songsList add constraint Justin_Biber Unique Key (song_id);
delete from songsList;
desc songsList;

create table playList(PL_id int primary key auto_increment,
PL_name varchar(30),user_Id int,PL_Duration int,
foreign key(user_id) references userdetails(user_ID));
select*from playList;

create table playListDetails(PL_id int,song_id int,foreign key(PL_id) references
playList(PL_id),foreign key(song_id)references songsList(song_id));
select *from playListDetails;
drop table playListDetails;
update songsList set album_name='Let_Love_Me' where songs_id=1;