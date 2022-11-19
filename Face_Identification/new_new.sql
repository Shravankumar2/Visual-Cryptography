/*
SQLyog - Free MySQL GUI v5.19
Host - 5.1.54-community : Database - db_image_copydetect
*********************************************************************
Server version : 5.1.54-community
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `db_image_copydetect`;

USE `db_image_copydetect`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `m_admin` */

DROP TABLE IF EXISTS `m_admin`;

CREATE TABLE `m_admin` (
  `aname` varchar(40) DEFAULT NULL,
  `apass` varchar(40) DEFAULT NULL,
  `addr` varchar(50) DEFAULT NULL,
  `pno` varchar(13) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_admin` */

insert into `m_admin` (`aname`,`apass`,`addr`,`pno`,`email`,`name`) values ('admin','admin','Jayanagar,Banglore.','8553958296','pazhani.kannan@gmail.com','ramesh');

/*Table structure for table `m_classification` */

DROP TABLE IF EXISTS `m_classification`;

CREATE TABLE `m_classification` (
  `c_id` int(10) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(150) NOT NULL,
  `c_remark` varchar(200) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `m_classification` */

insert into `m_classification` (`c_id`,`c_name`,`c_remark`) values (1,'bear','bear');
insert into `m_classification` (`c_id`,`c_name`,`c_remark`) values (2,'deer','deer');
insert into `m_classification` (`c_id`,`c_name`,`c_remark`) values (3,'elephant','elephant');
insert into `m_classification` (`c_id`,`c_name`,`c_remark`) values (4,'lion','lion');

/*Table structure for table `m_image` */

DROP TABLE IF EXISTS `m_image`;

CREATE TABLE `m_image` (
  `img_id` int(10) NOT NULL AUTO_INCREMENT,
  `img_name` varchar(250) NOT NULL,
  `f1_dist` double NOT NULL DEFAULT '0',
  `Rot1_dist` int(11) NOT NULL DEFAULT '0',
  `Rot2_dist` int(10) DEFAULT '0',
  `Rot3_dist` int(10) DEFAULT '0',
  `Rot4_dist` int(10) DEFAULT '0',
  `avg_dist` double DEFAULT '0',
  `cid` int(10) DEFAULT NULL,
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `m_image` */

insert into `m_image` (`img_id`,`img_name`,`f1_dist`,`Rot1_dist`,`Rot2_dist`,`Rot3_dist`,`Rot4_dist`,`avg_dist`,`cid`) values (1,'0_1_2.jpg',0,7,6,7,7,6,1);
insert into `m_image` (`img_id`,`img_name`,`f1_dist`,`Rot1_dist`,`Rot2_dist`,`Rot3_dist`,`Rot4_dist`,`avg_dist`,`cid`) values (2,'1_1_60.jpg',0,9,7,6,7,7,1);
insert into `m_image` (`img_id`,`img_name`,`f1_dist`,`Rot1_dist`,`Rot2_dist`,`Rot3_dist`,`Rot4_dist`,`avg_dist`,`cid`) values (3,'2_1_92.jpg',0,5,5,5,4,4,1);
insert into `m_image` (`img_id`,`img_name`,`f1_dist`,`Rot1_dist`,`Rot2_dist`,`Rot3_dist`,`Rot4_dist`,`avg_dist`,`cid`) values (4,'3_1_90.jpg',0,1,1,1,1,1,1);
insert into `m_image` (`img_id`,`img_name`,`f1_dist`,`Rot1_dist`,`Rot2_dist`,`Rot3_dist`,`Rot4_dist`,`avg_dist`,`cid`) values (5,'4_5607.jpg',0,5,7,7,7,6,3);
insert into `m_image` (`img_id`,`img_name`,`f1_dist`,`Rot1_dist`,`Rot2_dist`,`Rot3_dist`,`Rot4_dist`,`avg_dist`,`cid`) values (6,'5_5608.jpg',0,6,5,6,5,5,3);
insert into `m_image` (`img_id`,`img_name`,`f1_dist`,`Rot1_dist`,`Rot2_dist`,`Rot3_dist`,`Rot4_dist`,`avg_dist`,`cid`) values (7,'6_5615.jpg',0,3,2,4,3,3,3);
insert into `m_image` (`img_id`,`img_name`,`f1_dist`,`Rot1_dist`,`Rot2_dist`,`Rot3_dist`,`Rot4_dist`,`avg_dist`,`cid`) values (8,'7_5628.jpg',0,7,7,7,7,7,3);
insert into `m_image` (`img_id`,`img_name`,`f1_dist`,`Rot1_dist`,`Rot2_dist`,`Rot3_dist`,`Rot4_dist`,`avg_dist`,`cid`) values (9,'8_5304.jpg',0,10,10,11,10,10,2);
insert into `m_image` (`img_id`,`img_name`,`f1_dist`,`Rot1_dist`,`Rot2_dist`,`Rot3_dist`,`Rot4_dist`,`avg_dist`,`cid`) values (10,'9_5308.jpg',0,5,4,5,4,4,2);
insert into `m_image` (`img_id`,`img_name`,`f1_dist`,`Rot1_dist`,`Rot2_dist`,`Rot3_dist`,`Rot4_dist`,`avg_dist`,`cid`) values (11,'10_5311.jpg',0,0,0,0,0,0,2);
insert into `m_image` (`img_id`,`img_name`,`f1_dist`,`Rot1_dist`,`Rot2_dist`,`Rot3_dist`,`Rot4_dist`,`avg_dist`,`cid`) values (12,'11_5314.jpg',0,5,5,5,5,5,2);
insert into `m_image` (`img_id`,`img_name`,`f1_dist`,`Rot1_dist`,`Rot2_dist`,`Rot3_dist`,`Rot4_dist`,`avg_dist`,`cid`) values (13,'12_5400.jpg',0,10,10,10,9,9,4);
insert into `m_image` (`img_id`,`img_name`,`f1_dist`,`Rot1_dist`,`Rot2_dist`,`Rot3_dist`,`Rot4_dist`,`avg_dist`,`cid`) values (14,'13_5479.jpg',0,1,1,1,1,1,4);
insert into `m_image` (`img_id`,`img_name`,`f1_dist`,`Rot1_dist`,`Rot2_dist`,`Rot3_dist`,`Rot4_dist`,`avg_dist`,`cid`) values (15,'14_5444.jpg',0,14,13,16,11,13,4);
insert into `m_image` (`img_id`,`img_name`,`f1_dist`,`Rot1_dist`,`Rot2_dist`,`Rot3_dist`,`Rot4_dist`,`avg_dist`,`cid`) values (16,'15_5432.jpg',0,451,453,450,456,452,4);

/*Table structure for table `m_user` */

DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (
  `s_no` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` varchar(45) DEFAULT NULL,
  `u_pass` varchar(45) DEFAULT NULL,
  `uname` varchar(45) DEFAULT NULL,
  `addr` varchar(100) DEFAULT NULL,
  `pno` varchar(12) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`s_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `m_user` */

insert into `m_user` (`s_no`,`u_id`,`u_pass`,`uname`,`addr`,`pno`,`email`) values (1,'dhs','dhs','dhs','blr','9632587410','jothi@dhsinformatics.com');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
