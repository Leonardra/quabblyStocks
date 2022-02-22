create database stockDb;
create user 'stock_user'@'localhost' identified by 'myPassword';
grant all privileges on stockDb.* to 'stock_user'@'localhost';

flush privileges;