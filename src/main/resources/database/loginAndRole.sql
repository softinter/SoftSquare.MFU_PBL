
----------------//Start LOGIN
-------//Create Table LOGIN
CREATE TABLE IF NOT EXISTS `LOGIN` (
  `LGID` int(100) NOT NULL AUTO_INCREMENT,
  `LGUSERNAME` varchar(30) NOT NULL,
  `LGPASSWORD` varchar(20) NOT NULL,
  `LGROLEID` int(100) NOT NULL,
  `CREATE_USER` varchar(10) NOT NULL,
  `CREATE_DATE` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `UPDATE_USER` varchar(10) NOT NULL,
  `UPDATE_DATE` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`LGID`),
  UNIQUE KEY `LOGIN` (`LGUSERNAME`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

-------//Insert Table LOGIN
INSERT INTO `LOGIN` (`LGID`, `LGUSERNAME`, `LGPASSWORD`, `LGROLEID`, `CREATE_USER`, `CREATE_DATE`, `UPDATE_USER`, `UPDATE_DATE`) VALUES
(1, 'admin', 'adminadmin', 1, 'admin', '2015-08-06 10:41:47.245609', 'admin', '2015-08-06 10:41:47.245609');

----------------//End LOGIN




----------------//Start ROLE
-------//Create Table ROLE
CREATE TABLE IF NOT EXISTS `ROLE` (
  `ROLEID` int(100) NOT NULL AUTO_INCREMENT,
  `ROLECODE` varchar(30) NOT NULL,
  `ROLENAME` varchar(20) NOT NULL,
  `CREATE_USER` varchar(10) NOT NULL,
  `CREATE_DATE` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `UPDATE_USER` varchar(10) NOT NULL,
  `UPDATE_DATE` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`ROLEID`),
  UNIQUE KEY `LOGIN` (`ROLECODE`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

-------//Insert Table ROLE
INSERT INTO `ROLE` (`ROLEID`, `ROLECODE`, `ROLENAME`, `CREATE_USER`, `CREATE_DATE`, `UPDATE_USER`, `UPDATE_DATE`) VALUES
(1, 'admin', 'administrator', 'admin', '2015-08-06 10:41:47.245609', 'admin', '2015-08-06 10:41:47.245609');

