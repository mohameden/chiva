/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;

CREATE TABLE `tbl_detail_facture_services` (
  `detail_fact_service_id` varchar(20) NOT NULL DEFAULT '',
  `recu_id` varchar(20) DEFAULT NULL,
  `acte_id` int(11) DEFAULT NULL,
  `nom_acte` varchar(250) DEFAULT NULL,
  `nbr_actes` int(11) DEFAULT NULL,
  `urgence_acte` tinyint(1) DEFAULT NULL,
  `depl` tinyint(1) DEFAULT NULL,
  `hospitalisation_id` varchar(25) DEFAULT NULL,
  `prix` double(20,2) DEFAULT NULL,
  `prix_urg` double(20,2) DEFAULT NULL,
  `prix_depl` double(20,2) DEFAULT NULL,
  `statut` varchar(12) DEFAULT NULL,
  `operateur` varchar(12) DEFAULT NULL,
  `montant_total` double(20,2) DEFAULT NULL,
  `facture_id` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `medecin_id` int(11) DEFAULT NULL,
  `infirmier_id` int(11) DEFAULT NULL,
  `medecin_existe` varchar(2) DEFAULT NULL,
  `infirmier_existe` varchar(2) DEFAULT NULL,
  `prix_reel` double(20,2) NOT NULL DEFAULT '0.00',
  `cote_clinique` double(20,2) NOT NULL DEFAULT '0.00',
  `cote_clinique_majore` double(20,2) NOT NULL DEFAULT '0.00',
  `qpacteur` int(11) DEFAULT '0',
  `qpassistant` int(11) DEFAULT '0',
  `date_detail` date NOT NULL DEFAULT '0000-00-00',
  `detail_fact_id` varchar(20) NOT NULL,
  `pourcentage` int(11) DEFAULT '50',
  PRIMARY KEY (`detail_fact_service_id`),
  KEY `acte_id` (`acte_id`),
  KEY `recu_id` (`recu_id`),
  KEY `facture_id` (`facture_id`),
  KEY `medecin_id` (`medecin_id`),
  KEY `infirmier_id` (`infirmier_id`),
  KEY `detail_fact_id` (`detail_fact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
