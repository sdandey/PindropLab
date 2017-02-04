CREATE TABLE `PhoneFraudTopics` (
  `Topic Name` varchar(100) NOT NULL,
  `Topic Link` varchar(1000) DEFAULT NULL,
  `Number of Comments` int(11) DEFAULT NULL,
  `Latest Comment` varchar(100) DEFAULT NULL,
  `Category` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Topic Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
