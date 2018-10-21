System in HTML 5,CSS 3, Struts,Maven, Java,Jstl, Mysql,Hibernate,Gson,DisplayTable, Bootstrap,Javascript,
Ajax,Gson, AngularJs e Jquery by Rafael F.S

Database:

CREATE TABLE IF NOT EXISTS `services` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(64) COLLATE utf8_bin NOT NULL,
  `descricao` varchar(128) COLLATE utf8_bin NOT NULL,
  `conteudo` text COLLATE utf8_bin NOT NULL,
  `img` text COLLATE utf8_bin NOT NULL,
  `data_mod` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `nome` (`nome`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;




Set hibernate.cfg with DB config
