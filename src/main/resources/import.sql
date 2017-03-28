insert into statistic(drawn,level,lost,won,played,points)value(10,3,11,15,20,400);
insert into statistic(drawn,level,lost,won,played,points)value(5,1,13,12,20,300);
insert into statistic(drawn,level,lost,won,played,points)value(15,4,2,13,20,100);
insert into statistic(drawn,level,lost,won,played,points)value(20,5,30,11,20,200);
insert into statistic(drawn,level,lost,won,played,points)value(25,1,15,22,100,200);

insert into profile(about_me,life_motto,name,surname)value('hdskjahdsj','jdlksa','Grzegorz','Jakistam');
insert into profile(about_me,life_motto,name,surname)value('hdskjahdsj','jdlksa','Marek','Jakistam2');
insert into profile(about_me,life_motto,name,surname)value('hdskjahdsj','jdlksa','Patryk','Jakistam3');
insert into profile(about_me,life_motto,name,surname)value('hdskjahdsj','jdlksa','Waldek','Jakistam4');
insert into profile(about_me,life_motto,name,surname)value('hdskjahdsj','jdlksa','Henryk','Jakistam5');

insert into user(email,login,password,profile_id,statistic_id)value('aa@aa.pl','pierwszy','asd',1,1);
insert into user(email,login,password,profile_id,statistic_id)value('bb@aa.pl','drugi','asd',2,2);
insert into user(email,login,password,profile_id,statistic_id)value('cc@aa.pl','trzeci','asd',3,3);
insert into user(email,login,password,profile_id,statistic_id)value('dd@aa.pl','czwarty','asd',4,4);
insert into user(email,login,password,profile_id,statistic_id)value('ee@aa.pl','piaty','asd',5,5);

insert into matches(black_player_won,white_player_won,black_player_id,white_player_id)value(true,false,1,2);
insert into matches(black_player_won,white_player_won,black_player_id,white_player_id)value(false,true,2,3);
insert into matches(black_player_won,white_player_won,black_player_id,white_player_id)value(false,true,3,4);
insert into matches(black_player_won,white_player_won,black_player_id,white_player_id)value(true,false,4,5);
insert into matches(black_player_won,white_player_won,black_player_id,white_player_id)value(true,false,5,1);