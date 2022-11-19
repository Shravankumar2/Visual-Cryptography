/*
SQLyog - Free MySQL GUI v5.19
Host - 5.0.15-nt : Database - image_encryption
*********************************************************************
Server version : 5.0.15-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `image_encryption`;

USE `image_encryption`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `m_admin` */

DROP TABLE IF EXISTS `m_admin`;

CREATE TABLE `m_admin` (
  `id` int(5) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `adminid` varchar(20) NOT NULL,
  `address` varchar(50) default NULL,
  `phone` varchar(15) default NULL,
  `email` varchar(50) default NULL,
  PRIMARY KEY  (`id`,`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_admin` */

insert into `m_admin` (`id`,`name`,`password`,`adminid`,`address`,`phone`,`email`) values (1,'aaa','admin','admin','T.R. Nagar','9916876548','munna.kumar@gmail.com');
insert into `m_admin` (`id`,`name`,`password`,`adminid`,`address`,`phone`,`email`) values (2,'Vasantha','v','Vasantha','T.R. Nagar','9916876548','munna.kumar@gmail.com');

/*Table structure for table `m_department` */

DROP TABLE IF EXISTS `m_department`;

CREATE TABLE `m_department` (
  `dept_code` int(10) NOT NULL auto_increment,
  `dept_name` varchar(50) NOT NULL,
  PRIMARY KEY  (`dept_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_department` */

insert into `m_department` (`dept_code`,`dept_name`) values (1,'All');
insert into `m_department` (`dept_code`,`dept_name`) values (2,'IT');
insert into `m_department` (`dept_code`,`dept_name`) values (3,'Development');
insert into `m_department` (`dept_code`,`dept_name`) values (4,'Management');
insert into `m_department` (`dept_code`,`dept_name`) values (5,'Sales');
insert into `m_department` (`dept_code`,`dept_name`) values (6,'Finance');
insert into `m_department` (`dept_code`,`dept_name`) values (7,'Maintainance');
insert into `m_department` (`dept_code`,`dept_name`) values (8,'Marketing');

/*Table structure for table `m_designation` */

DROP TABLE IF EXISTS `m_designation`;

CREATE TABLE `m_designation` (
  `desig_code` int(10) NOT NULL auto_increment,
  `desig_name` varchar(100) NOT NULL,
  PRIMARY KEY  (`desig_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_designation` */

insert into `m_designation` (`desig_code`,`desig_name`) values (1,'All');
insert into `m_designation` (`desig_code`,`desig_name`) values (2,'Software Developer');
insert into `m_designation` (`desig_code`,`desig_name`) values (3,'Software Engineer');
insert into `m_designation` (`desig_code`,`desig_name`) values (4,'HR Marketing');
insert into `m_designation` (`desig_code`,`desig_name`) values (5,'HR Sales');
insert into `m_designation` (`desig_code`,`desig_name`) values (6,'HR Finance');
insert into `m_designation` (`desig_code`,`desig_name`) values (7,'Project Manager');
insert into `m_designation` (`desig_code`,`desig_name`) values (8,'Project Leader');

/*Table structure for table `m_image` */

DROP TABLE IF EXISTS `m_image`;

CREATE TABLE `m_image` (
  `img_id` int(10) NOT NULL auto_increment,
  `img_name` varchar(100) NOT NULL,
  `img_subject` varchar(225) NOT NULL,
  PRIMARY KEY  (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_image` */

insert into `m_image` (`img_id`,`img_name`,`img_subject`) values (25,'images.jpg','dgg');
insert into `m_image` (`img_id`,`img_name`,`img_subject`) values (26,'image.jpg','ggg');
insert into `m_image` (`img_id`,`img_name`,`img_subject`) values (27,'srtnshot.bmp','aaa');

/*Table structure for table `m_user` */

DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (
  `u_code` int(10) NOT NULL auto_increment,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `u_name` varchar(100) NOT NULL,
  `dept_code` int(10) NOT NULL,
  `design_code` int(10) NOT NULL,
  `u_address` varchar(200) NOT NULL,
  `u_city` varchar(100) default NULL,
  `u_cell` varchar(100) default NULL,
  `u_phone` bigint(20) default NULL,
  `u_email` varchar(100) default NULL,
  PRIMARY KEY  (`u_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_user` */

insert into `m_user` (`u_code`,`username`,`password`,`u_name`,`dept_code`,`design_code`,`u_address`,`u_city`,`u_cell`,`u_phone`,`u_email`) values (3,'rahul','rahul','Rahul',1,1,'Harohalli','Salam','08025302916',9916876542,'since.rahul@gmail.com');
insert into `m_user` (`u_code`,`username`,`password`,`u_name`,`dept_code`,`design_code`,`u_address`,`u_city`,`u_cell`,`u_phone`,`u_email`) values (4,'ritika','ritika','Ritika Sharma',3,1,'Ashok Vihar','Delhi','08025302917',9916876543,'since.ritika@gmail.com');
insert into `m_user` (`u_code`,`username`,`password`,`u_name`,`dept_code`,`design_code`,`u_address`,`u_city`,`u_cell`,`u_phone`,`u_email`) values (5,'sonam','sonam','Sonam Singh',1,1,'Gyan Nagar','Bhopal','08025302918',9916876544,'since.sonam@gmail.com');
insert into `m_user` (`u_code`,`username`,`password`,`u_name`,`dept_code`,`design_code`,`u_address`,`u_city`,`u_cell`,`u_phone`,`u_email`) values (8,'pritee','pritee','Preeti Ray',2,2,'Vasantpur','Jaipur','08025302919',9916876547,'since.priteeray@gmail.com');
insert into `m_user` (`u_code`,`username`,`password`,`u_name`,`dept_code`,`design_code`,`u_address`,`u_city`,`u_cell`,`u_phone`,`u_email`) values (39,'kumar','kumar','Munna Kumar Singh',5,5,'J. P. Nagar','Bangalore','08025302917',9916876540,'kumarmunna.india@gmail.com');
insert into `m_user` (`u_code`,`username`,`password`,`u_name`,`dept_code`,`design_code`,`u_address`,`u_city`,`u_cell`,`u_phone`,`u_email`) values (41,'arpit','arpit','Arpit Singh',3,5,'Jayanagar','Bangalore','08025302919',9916876546,'testmycvsprojects@gmail.com');
insert into `m_user` (`u_code`,`username`,`password`,`u_name`,`dept_code`,`design_code`,`u_address`,`u_city`,`u_cell`,`u_phone`,`u_email`) values (42,'rajan','rajan','Rajan',2,2,'sfsd','sdfsd','3434',5656,'rajan@dhsinformatics.com');
insert into `m_user` (`u_code`,`username`,`password`,`u_name`,`dept_code`,`design_code`,`u_address`,`u_city`,`u_cell`,`u_phone`,`u_email`) values (43,'Vasantha','Van','Vasantha',2,3,'JayaNagar','Bangalore','3354346469',2324354545,'Van@gmail.com');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
