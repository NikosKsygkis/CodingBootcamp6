-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: teamproject
-- ------------------------------------------------------
-- Server version	8.0.13
drop database if exists teamproject;
create database teamproject;
use teamproject;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Temporary view structure for view `allpublished`
--

DROP TABLE IF EXISTS `allpublished`;
/*!50001 DROP VIEW IF EXISTS `allpublished`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `allpublished` AS SELECT 
 1 AS `id`,
 1 AS `category`,
 1 AS `title`,
 1 AS `article_img`,
 1 AS `username`,
 1 AS `pub_date`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creator_id` int(11) NOT NULL,
  `sub_date` datetime DEFAULT NULL,
  `pub_date` datetime DEFAULT NULL,
  `category` enum('SCIENCE','ART','ENVIRONMENT','TECHNOLOGY','GENERAL') NOT NULL,
  `title` varchar(120) NOT NULL,
  `article` varchar(10000) NOT NULL,
  `question` varchar(400) DEFAULT NULL,
  `is_saved` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `creator_id` (`creator_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`creator_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (2,2,'2019-01-24 19:51:07','2019-01-24 20:12:06','ENVIRONMENT','Should we stop eating meat? Not while humans are the real weapons of climate destruction ','As we are starting to see the effects of climate change materialise in front of our eyes, people are looking for things they can do to help heal our planet. One common theme has been a call to stop eating meat, mainly due to methane emissions from cows.\r\n\r\nThis is a simple answer, but I suggest it is an answer to the wrong question.\r\n\r\nHow did nature get things so horribly wrong when she allowed cows to evolve? After all, they are evil weapons of climate destruction, are not they?\r\n\r\nLet us start with a few basics.\r\n\r\nCows are ruminant animals. This means they have a multi-chambered stomach, one part of which is called a rumen. This is a fermentation vat containing billions of microbes breaking down the plants the animal eats. As part of this process, some of these microbes produce methane.\r\n\r\nLots of animals produce some methane, including horses, dogs, termites, people and even kangaroos.\r\n\r\nRuminants evolved 50 million years ago, and today there are almost 200 different species. So ruminant animals have a rich ecological diversity and a long evolutionary history.\r\n\r\nOther ruminants include the American elk, Chinese goral, Himalayan tahr, Japanese serow, Reindeer, Siberian ibex, water buffalo and yak. There are mountain, marsh, snow and swamp ruminants. There are American, Chinese, Japanese, Spanish, even Siberian ruminants.\r\n\r\nIf nature got it wrong when she allowed ruminants to evolve, she got it wrong at a global scale.\r\n\r\nBut maybe she did not get it wrong after all? Maybe it is not her, maybe it is us?\r\n\r\nInstead of asking ,what do we humans need to do to reduce ruminant methane emissions, we should be asking what have we humans done that has so unbalanced the natural methane cycle.\r\n\r\nBacteria that eat methane live in healthy, properly managed soils beneath the feet of healthy, properly managed livestock. (Remember, nature does not do waste.)\r\n\r\nThese methane-eating bacteria (methanotrophs) act as a balance to the methane produced by the methane generating bacteria (methanogens) in the rumens of the livestock above ground. This is the missing part of the natural methane cycle that we need to restore.\r\n\r\nI believe there is a massive difference between livestock and properly managed livestock.','Would you stop eating meat to save the environment?',0),(4,3,'2019-01-24 20:01:20','2019-01-24 20:11:42','ART','Azealia Banks: fearless truthteller or relentless troll? ','She is addicted to controversial, often bigoted outbursts recently against the population of Ireland. Yet fans continue to root for the rapper because she is the opposite of safe. Last week, in the most high-profile celebrity aviation incident since Kate Moss popularised the term basic bitch in a row with easyJet staff about sandwiches, the American rapper Azealia Banks removed herself from an Aer Lingus flight after calling a flight attendant an ugly Irish bitch. According to a tearful video she posted on Instagram, Banks said a flight attendant asked her questions she could not answer without checking her passport, which she had stored in the overhead locker. As she looked for her passport, the situation escalated. A fellow passenger told Mail Online they felt the crew were heavy-handed. Sign up for the Sleeve Notes email: music news, bold reviews and unexpected extras Read more After disembarking the flight voluntarily, Banks called the Aer Lingus staff ugly Irish women, threatening to throw geese into the engine of the plane. When the incident sparked a semi-serious tabloid row about the beauty or lack thereof of Irish women, Banks apologised to her Irish fans, calling herself the Queen of Ireland and asking that they throw baked potatoes at her if they were offended by her comments. Is there a tougher gig than being Banks s publicist? You wonder if they get strapped into the same spinning chair they use to stress-test astronauts. Since breaking out in 2011 with 212, her fast-flowing celebration of cunnilingus, Banks gift for controversy would challenge even the most battle-hardened PR professional. In 2017, she accepted a plea deal after an incident in which she bit a New York City bouncer on the breast and spat on her. In 2016, she claimed that the actor Russell Crowe assaulted her during a party in a Beverly Hills hotel room. Prosecutors dropped the case after other partygoers told police that they had witnessed Banks threaten to attack a woman with broken glass. In 2015, she was removed from a Delta flight after calling an attendant a fucking faggot. A year later, she called Zayn Malik a curry-scented bitch, and asked for Sarah Palin to be gangbanged.','Do you like her songs?',0),(5,4,'2019-01-24 20:09:26','2019-01-24 20:11:32','TECHNOLOGY','How a 57-hour Donkey Kong game struck a blow against online toxicity ','One of the defining features of politics in the 21st century has been the way online cultural phenomena can cross over into the real world.\r\n\r\nUnfortunately, perhaps because the internet seems to bring out the worst in people, those phenomena have largely been, well, awful.\r\n\r\nThe defining example is Gamergate: the 2014 campaign of online misogynist harassment that acted as a breeding ground for many of the figures who would go on to enjoy varying degrees of prominence in the alt-right: Milo Yiannopoulos, Mike Cernovich, Ben Shapiro and various others who saw an opportunity to gain real-world popularity. Steve Bannon, whose website Breitbart became the de facto house journal of Gamergate, made it all the way to the White House. When the history of this era is written  if there is anyone around to write it future generations will marvel at the fact that the canary in the coalmine for the rise of the far right was a bunch of gamers angry at not getting laid.\r\n\r\nHappily, though, last weekend has proved that the internet can also be a force for good. Over the course of 57 long hours, Harry Brewis, who goes by the online handle Hbomberguy, sat playing Donkey Kong 64, trying to gain a 101% completion rate for all the game s achievements, while raising money for Mermaids, a UK-based organisation that supports gender diverse young people, and which has recently come under attack from tabloids and concerned celebrities alike. (It was comedian Graham Linehan s attacks on the charity that spurred Brewis to start the stream in the first place.)\r\n\r\nIf you have not heard of Brewis until now, you are not alone. Until last weekend he was best known for his YouTube channel, which aims to provided well-sourced and reasoned responses to the arguments of the far right. (His most popular videos include measured responses to flat earthers, pick-up artists, advocates of the theory that soy makes men feminine and a truly absurd Swedish far-right type who goes by the name The Golden One.) As such, he is part of a small but burgeoning population of online personalities whose politics serve as an antidote to the far-right views that have dominated online politics in recent years.','Do you play video-games?',0),(7,5,'2019-01-24 21:37:52','2019-01-24 22:52:08','SCIENCE','New treatment for Alzheimer Disease','One of the barriers to understanding the heterogeneity in these early populations is the difficulty in isolating cognitive domains for measurement. Most neuropsychological (NP) tests require a number of cognitive processes and, therefore, measures of multiple domains. In the previous issue of Alzheimer\'s Research & Therapy, Tatsuoka and colleagues [1] get around this problem by identifying the multiplicity of cognitive domains measured by each NP test and also the level of ability in that domain that is required for maximum performance on the test. They use this information in a Bayesian statistical model that is designed to separate out the effects of different cognitive functions on the NP outcomes. Based on NP data collected in MCI subjects in the Alzheimer\'s Disease Neuroimaging Initiative (ADNI) study, the approach yielded several potential combinations of cutoffs for baseline NP test scores and apolipoprotein E (APOE) status values which predict imminent risk of progression to AD over the course of a 24-month period.\r\n\r\nImportantly, the authors also illustrate that more commonly applied methods, such as factor analysis and logistic regression, are not able to achieve the same level of success in predicting a diagnosis of AD, presumably because the specific domains are not able to be separated with those models. Separation of specific domains also allows grouping of the specific combinations of deficits into diagnostic subgroups (for example, amnestic single-domain MCI, amnestic multidomain MCI, and non-amnestic multidomain MCI) which then can be analyzed in terms of biomarkers and disease outcomes','Would you donate for Alzheimer Treatment Research?',0),(8,5,'2019-01-24 21:46:11','2019-01-24 22:52:14','GENERAL','The most succesfull restaurant in Athens!','Restaurants are important in generating income for many Asian countries. Therefore, determinants for restaurant service quality need to be identified, especially for the important segments (i.e., youths). This paper examines the importance of service environment (servicescape and human service), food quality and price from the youth\'s perspective. The types of restaurant investigated were the fine dining, fast food, and food court restaurants. A total of 407 usable questionnaires were analysed. The key determinants on satisfaction and loyalty were human service and price. The impact of servicescape on customer satisfaction and loyalty was relatively smaller, except for fast food restaurants.\r\nRestaurants are important in generating income for many Asian countries. Therefore, determinants for restaurant service quality need to be identified, especially for the important segments (i.e., youths). This paper examines the importance of service environment (servicescape and human service), food quality and price from the youth\'s perspective. The types of restaurant investigated were the fine dining, fast food, and food court restaurants. A total of 407 usable questionnaires were analysed. The key determinants on satisfaction and loyalty were human service and price. The impact of servicescape on customer satisfaction and loyalty was relatively smaller, except for fast food restaurants.\r\n\r\nRestaurants are important in generating income for many Asian countries. Therefore, determinants for restaurant service quality need to be identified, especially for the important segments (i.e., youths). This paper examines the importance of service environment (servicescape and human service), food quality and price from the youth\'s perspective. The types of restaurant investigated were the fine dining, fast food, and food court restaurants. A total of 407 usable questionnaires were analysed. The key determinants on satisfaction and loyalty were human service and price. The impact of servicescape on customer satisfaction and loyalty was relatively smaller, except for fast food restaurants.','Would you visit the restaurant?',0),(9,6,'2019-01-24 21:55:53','2019-01-24 22:52:20','TECHNOLOGY','New Graphics Card in town..',' Pros: I ordered this card through GCI Micro, a third party seller to NewEgg. The product arrived in the amount of time I had expected and was in mint condition, new as described. I installed the card and within a few minutes started getting random color splotches on the screen. I swapped cords and ran various monitor setups between the three screens and finally accepted that the card was a lemon. I immediately contacted the seller via email on a Sunday night and issued the RMA from NewEgg. Within an hour there was a response back from the seller offering to ship a new card with one-day shipping at no cost to me. The bent over backwards to make it right, which is a rarity today. I received the card yesterday and installed it today, ran passmark on it, and have no issues. I highly recommend this company.\r\nIt\'s an absolute beast for gaming. I can\'t bottleneck this thing even when I try. I do mostly 1080p gaming (some 4K) and 90 fps VR. You know you have a good card when you enjoy your games to the fullest and not have to think about it. \r\n\r\nCons: Bad card on arrival \r\nPaid about $900 for this 6 months ago. Prices have shot up since then. I wouldn\'t pay $1400 for this; go with GTX 20xx instead. ','Would you spend 500$ to buy?',0),(11,8,'2019-01-24 22:07:47','2019-01-24 22:52:34','ART','The Doors new hidden album..','The Doors were an American rock band formed in Los Angeles in 1965, with vocalist Jim Morrison, keyboardist Ray Manzarek, guitarist Robby Krieger, and drummer John Densmore. They were among the most controversial and influential rock acts of the 1960s, mostly because of Morrison\'s lyrics and his erratic stage persona, and the group was widely regarded as representatives of the era\'s counterculture.[4] After Morrison\'s death in 1971, the remaining members continued as a trio until disbanding in 1973.[5][6]\r\n\r\nThe band got its name from the title of Aldous Huxley\'s book The Doors of Perception, which itself was a reference to a quote by William Blake. After signing with Elektra Records, the Doors released eight albums in five years, some of which are considered to be the greatest of all time, including The Doors (1967), Strange Days (1967), and L.A. Woman (1971). By the end of 1971 the Doors had sold over 4 million albums domestically and nearly 8 million singles.[7]\r\n\r\nMorrison died of unknown circumstances in 1971. Afterward, the surviving trio released three albums in the 1970s, two of which featured earlier recordings by Morrison, and over the decades reunited on stage in various configurations. In 2002, Manzarek and Krieger started playing together again, renaming themselves as the Doors of the 21st Century, with Ian Astbury of the Cult on vocals. Densmore opted to sit out and, along with the Morrison estate, sued the duo over proper use of the band\'s name and won. After a short time as Riders On the Storm, they settled on the name Manzarek-Krieger and continued to tour until Manzarek\'s death in 2013.\r\n\r\nThe Doors were the first US band to accumulate eight consecutive gold and platinum LP\'s.[8] According to the RIAA, they have sold 33 million records in the US[9] and over 100 million records worldwide,[10] making them one of the best-selling bands of all time.[11] The Doors have been listed as one of the greatest artists of all time by many magazines, including Rolling Stone, which ranked them 41st on its list of the \"100 Greatest Artists of All Time\"\".[12] In 1993, they were inducted into the Rock and Roll Hall of Fame. \"','Are you a fan of The Doors?',0),(15,11,'2019-01-24 23:10:09','2019-01-24 23:21:08','ART','Modern Art Excibition tomorrow at 20:00','The birth of modernism and modern art can be traced to the Industrial Revolution. This period of rapid changes in manufacturing, transportation, and technology began around the mid-18th century and lasted through the 19th century, profoundly affecting the social, economic, and cultural conditions of life in Western Europe, North America, and eventually the world. New forms of transportation, including the railroad, the steam engine, and the subway, changed the way people lived, worked, and traveled, expanding their worldview and access to new ideas. As urban centers prospered, workers flocked to cities for industrial jobs and urban populations boomed.\n \n Before the 19th century, artists were most often commissioned to make artwork by wealthy patrons or institutions like the church. Much of this art depicted religious or mythological scenes that told stories intended to instruct the viewer. During the 19th century, many artists started to make art based in their own, personal experiences and about topics that they chose. With the publication of psychologist Sigmund Freuds The Interpretation of Dreams (1899) and the popularization of the idea of a subconscious mind, many artists began exploring dreams, symbolism, and personal iconography as avenues for the depiction of their subjective experiences. Challenging the notion that art must realistically depict the world, some artists experimented with the expressive use of color, non-traditional materials, and new techniques and mediums. Among these new mediums was photography, whose invention in 1839 offered radical possibilities for depicting and interpreting the world.','Are you interested in modern art?',0),(17,13,'2019-01-24 23:30:21','2019-01-24 23:37:00','SCIENCE','Revolution in ion propulsion engines!','An ion thruster or ion drive is a form of electric propulsion used for spacecraft propulsion. It creates thrust by accelerating positive ions with electricity. The term refers strictly to gridded electrostatic ion thrusters, and is often incorrectly loosely applied to all electric propulsion systems including electromagnetic plasma thrusters.[citation needed]\r\n\r\nAn ion thruster ionizes a neutral gas by extracting some electrons out of atoms, creating a cloud of positive ions. These thrusters rely mainly on electrostatics as ions are accelerated by the Coulomb force along an electric field. Temporarily stored electrons are finally reinjected by a neutralizer in the cloud of ions after it has passed through the electrostatic grid, so the gas becomes neutral again and can freely disperse in space without any further electrical interaction with the thruster. Electromagnetic thrusters on the contrary use the Lorentz force to accelerate all species (free electrons as well as positive and negative ions) in the same direction whatever their electric charge, and are specifically referred as plasma propulsion engines, where the electric field is not in the direction of the acceleration.[1][2]\r\n\r\nIon thrusters in operational use have an input power need of 17 kW, exhaust velocity 2050 km/s, thrust 25250 millinewtons and efficiency 6580%[3][4] though experimental versions have achieved 100kW, 5N.[5]\r\n\r\nThe Deep Space 1 spacecraft, powered by an ion thruster, changed velocity by 4.3 km/s while consuming less than 74 kilograms of xenon. The Dawn spacecraft broke the record, with a velocity change of 10 km/s.[3][4]\r\n\r\nApplications include control of the orientation and position of orbiting satellites (some satellites have dozens of low-power ion thrusters) and use as a main propulsion engine for low-mass robotic space vehicles (such as Deep Space 1 and Dawn).[3][4]\r\n\r\nIon thrust engines are practical only in the vacuum of space and cannot take vehicles through the atmosphere because ion engines do not work in the presence of ions outside the engine. Additionally, the engine\'s minuscule thrust cannot overcome any significant air resistance. Spacecraft rely on conventional chemical rockets to initially reach orbit. ','Do you believe that the new ion propulsion system will be a game-changer in space travel?',0),(18,12,NULL,NULL,'ART','sdgsdgs sgds','sdgsdgsdg sdgsdgsdg sdgsdgsdg sdgsdgsdg sdgsdgsdg','fds sd gsdgs?',1),(19,3,'2019-01-25 12:39:23','2019-01-25 12:40:35','ENVIRONMENT','Forest','The birth of modernism and modern art can be traced to the Industrial Revolution. This period of rapid changes in manufacturing, transportation, and technology began around the mid-18th century and lasted through the 19th century, profoundly affecting the social, economic, and cultural conditions of life in Western Europe, North America, and eventually the world. New forms of transportation, including the railroad, the steam engine, and the subway, changed the way people lived, worked, and traveled, expanding their worldview and access to new ideas. As urban centers prospered, workers flocked to cities for industrial jobs and urban populations boomed. Before the 19th century, artists were most often commissioned to make artwork by wealthy patrons or institutions like the church. Much of this art depicted religious or mythological scenes that told stories intended to instruct the viewer. During the 19th century, many artists started to make art based in their own, personal experiences and about topics that they chose. With the publication of psychologist Sigmund FreudÃÂs The Interpretation of Dreams (1899) and the popularization of the idea of a subconscious mind, many artists began exploring dreams, symbolism, and personal iconography as avenues for the depiction of their subjective experiences. Challenging the notion that art must realistically depict the world, some artists experimented with the expressive use of color, non-traditional materials, and new techniques and mediums. Among these new mediums was photography, whose invention in 1839 offered radical possibilities for depicting and interpreting the world.','Did you liked the article?',0);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_images`
--

DROP TABLE IF EXISTS `article_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `article_images` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL,
  `caption` varchar(45) DEFAULT NULL,
  `article_img` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `article_id` (`article_id`),
  CONSTRAINT `article_images_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_images`
--

LOCK TABLES `article_images` WRITE;
/*!40000 ALTER TABLE `article_images` DISABLE KEYS */;
INSERT INTO `article_images` VALUES (1,2,'cows','https://i.guim.co.uk/img/media/c529d2c4badc42d243c6fd3e5799c516510d7db1/0_338_5184_3110/master/5184.jpg?width=620&quality=85&auto=format&fit=max&s=eae1a767c3d51545beae9630bcc6b5a4'),(2,2,'meat','https://i.dietdoctor.com/wp-content/uploads/2019/01/Cut-red-meat-eating-by-80-percent-to-save-the-planet.jpg?auto=compress%2Cformat&w=1600&h=900&fit=crop'),(3,4,'singer','https://i.guim.co.uk/img/media/6b7ea2de7e8110e33d4c1cee922d84a2406cffdb/0_200_3000_1800/master/3000.jpg?width=1300&quality=85&auto=format&fit=max&s=d0a975e6e5ac2021b99dc37afbf802b2'),(4,4,'singer1','https://i.guim.co.uk/img/media/9942f99d69cfaf15a6fe980fd07586de49d3c046/418_521_2903_1819/master/2903.jpg?width=860&quality=85&auto=format&fit=max&s=fc0d0c9063d5042d8bcf5983ea850382'),(5,5,'DonkeyKong','https://i.guim.co.uk/img/media/ec872109947a35f09940a0f521c24f59c284034c/122_0_1798_1079/master/1798.png?width=620&quality=85&auto=format&fit=max&s=b0eb81a482d961b72db9149b655855b8'),(6,5,'videogames','https://www.philosophytalk.org/system/files/0d7c8c6a3a60f9a29dda44de48c5b34f.jpg'),(66,7,'Hospital','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyY7ezpqekoE-jwoxKNDZcvRzITvBmqrTX_gUFg_Q4kAGIQnA6Yw'),(67,8,'','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReNQn0y0-pCdN31B6iAtRx4cngAlixvOfti-6W2M91jUal-ekd'),(68,8,'','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2pm3VILhUnRQ-uNeAav4Np8FLPC2isXCJRMeD3o0QnA97VK4U'),(69,9,'','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfk_imCSOB7KgBX7yIlSv9mbq3HLIzUdulc_tKReGtn-oxkIF-'),(70,9,'','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRCkupBmi2ulbQP77Re1GBuxYWpidw1GqJdXc1FqNFtYa2PcZE'),(73,11,'','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1VzIUh_abTtP_OGiWOiLwklfCYCkeeDlOGtpp8TNEZ0z02laP'),(74,11,'','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRrdiQu4q5vsXU4Mmjo0TENAiPMFAplgTnd2vBvihYGnpsCstsq5A'),(85,15,'','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaBbMwPHwT6TowxuuEawLxmlvxU7Wh1maZz4uOmGEPItldkGsB'),(86,15,'','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsIma6Nn3YiWnuTRC_VNmQGO3kuK6MAbXBie3yFix8-gs8kKqYnw'),(90,17,'','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaTuU_T3P4sWsofAgMAIJV0myljELBkR20jvwTMC1-7Kuza2AdiA'),(91,19,'asda','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1Y3LyVcp8CzHX2nfet0xZKJ8_d8l2U45GxmpvuLNG8KWzYnafUw');
/*!40000 ALTER TABLE `article_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_reader`
--

DROP TABLE IF EXISTS `article_reader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `article_reader` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL,
  `reader_id` int(11) NOT NULL,
  `is_like` enum('L','D') DEFAULT NULL,
  `question_answer` enum('YES','NO','OTHER') DEFAULT NULL,
  `comment` varchar(1000) DEFAULT NULL,
  `sub_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `article_id` (`article_id`),
  KEY `reader_id` (`reader_id`),
  CONSTRAINT `article_reader_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE CASCADE,
  CONSTRAINT `article_reader_ibfk_2` FOREIGN KEY (`reader_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_reader`
--

LOCK TABLES `article_reader` WRITE;
/*!40000 ALTER TABLE `article_reader` DISABLE KEYS */;
INSERT INTO `article_reader` VALUES (1,15,3,'L',NULL,NULL,NULL),(2,15,3,NULL,'YES',NULL,NULL),(3,15,3,NULL,NULL,'comment','2019-01-25 12:37:41'),(4,15,4,NULL,'NO',NULL,NULL),(5,15,4,NULL,NULL,'dsfdsdggsd','2019-01-25 12:41:44'),(6,15,4,'D',NULL,NULL,NULL),(7,8,4,'L',NULL,NULL,NULL),(8,8,4,NULL,'NO',NULL,NULL);
/*!40000 ALTER TABLE `article_reader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `birthdate` date NOT NULL,
  `gender` enum('Male','Female','Other') NOT NULL,
  `reg_date` datetime NOT NULL,
  `is_active` enum('Active','Inactive') NOT NULL,
  `is_admin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$10$2rS.UNOgVv458FLXy4krxu0bnxA0Q9Tv.c6zHFPxHzl03NpzbxBTS','sgnhsrthstr@sgdnsgts','aetnhateha','gfnsfyjsry','2004-12-27','Male','2019-01-24 18:05:01','Active',1),(2,'user1','$2a$10$4GN.cH1yTz.FCPMUgET3TespHuF4lyVTw62ITYYXzhgsEhk9XVpHK','ethaet@rdyjsrjsrtj','trsjsrtj','sryjsryjs','2005-01-01','Male','2019-01-24 18:05:42','Inactive',0),(3,'user2','12345','gftjsftsjf@dfjdfyj','zxczcxczxc','yrjdyjdy','2005-01-01','Male','2019-01-24 18:06:07','Active',0),(4,'user3','$2a$10$HYHXERdYjLNZgQm5CGnX0OgXVj9Y8LLktDDDnHZHsS94vnhQ3ORmG','strhsrt@jdrysryjyrj','dfyjdy','dyjkdykdkd','2004-12-26','Male','2019-01-24 18:07:03','Active',0),(5,'user4','$2a$10$wLAwVaFpzlBsAWX8KMVJtuoOdXV4Qz5nhWsk2opMH8a.PUBCgnvnG','dthstjsrt@dyrjdyjd','hfjdhjkdh','xfjfkxgfhm','2004-12-27','Other','2019-01-24 18:07:34','Active',0),(6,'user5','$2a$10$dA.LSqHbI8fRJZDafFLnBOEaeZWcBNjj8L16VVXako/7L4ePBqEk.','gsfgjfxg@xfjdf','fgjrsjsry','syjdyjd','2004-12-27','Other','2019-01-24 18:07:59','Active',0),(7,'user6','$2a$10$pVRi00NeQPQ67ciGE5R73e/pLX7HVWDbBXWhTIcTm21dpbyaMg6gS','dtjsrt@dyjkdty','srtjsrj','srjsryjsryj','2004-12-27','Female','2019-01-24 18:08:29','Active',0),(8,'user7','$2a$10$1R8XhrLbAyto5KRLTO..ge6bIFfzJoISqtyEobon4AsAov.od9jQO','dthsth@tehsth','sethsrthssgnsft','ethsrthjssrtjsrtj','2005-01-01','Male','2019-01-24 18:08:59','Active',0),(9,'user8','$2a$10$eYRqBUBDwygB2hQEqwEPYunTBP8LI8e3/oqDHyQoU0qBEw0HpWIrm','tsdjhstj@dnhst','strjpat','strjsrtp','2005-01-01','Female','2019-01-24 18:09:23','Active',0),(10,'user9','$2a$10$XGf.0rsynWiyw16yU6of3ugMuRrYIX.UP2QrAOw.jmZywjbH2baVm','thjstgjhtrshs@hsdgh','etuetbgfx','aethab','2004-12-27','Female','2019-01-24 18:09:46','Active',0),(11,'user10','$2a$10$BCBE6BWWnEJ8RaDCnpBabewBU89vYtSsNpHlsnE.QWrC/RkYelGsq','ethset@aehaet','dthst','zdghsg','2005-01-01','Male','2019-01-24 18:10:05','Active',0),(12,'user11','$2a$10$ytOiPRda.fFaosKUW5koU.N7eoj1xO2kTPTXRn8RaImRLTk30JOqi','ethseths@ethste','sths','tehsrts','2005-01-01','Male','2019-01-24 18:10:28','Active',0),(13,'user12','$2a$10$Zld7YsVYhabjT3iTWY4LxO7iIAJ0oRQPvkXswUFrwHP268IZpzASC','ddgsgf@dnhsdgdn','fsbsdgth','dggthjsrtj','2004-12-26','Male','2019-01-24 18:10:50','Active',0),(14,'user13','$2a$10$hM17UY47D0SbVo4jgnjureQ8uHOsqV5SqV.5CpeSwJImEn2Gu9aP6','dfhsghs@zdfhdhf','dghsdgths','sthstrh','2005-01-01','Female','2019-01-24 18:11:09','Active',0),(15,'user14','$2a$10$avsI4mg1LztW3avYBDXlpOCVQNDjY/sf7mKvQe666BZX5KzQuzh.G','ethst@ahsdth','dghsgdth','strjsrtj','2005-01-01','Male','2019-01-24 18:12:04','Active',0),(16,'user15','$2a$10$LtAh4BU65JfHvBdt4i6NmOJwvrolNGCkY2p9nlzqAdTZkHfJi3gxO','sryjryj@tghjsfj','sgtjsrt','srtjsy','2005-01-01','Male','2019-01-24 18:12:24','Active',0),(17,'user16','$2a$10$GG6/sVMUg5htMlsqnLLxye0r2UbNQKPT.oWTg0lRqgYVBCQV0nSSe','sthst@shstrj','dggthjstgj','sgjsrtjs','2005-01-01','Female','2019-01-24 18:12:43','Active',0),(18,'user17','$2a$10$85bkQ9DTIkA06TuxUyoYY.CJ7KZON0fQzXoXwODYeevT4oPjRs3EO','sthst@haethte','fgjsf','sryjsrygn','2005-01-01','Other','2019-01-24 18:13:04','Active',0),(19,'user18','$2a$10$A3Kt8Q1MtpRpSlCkOqW4gOJ8Y8sojpnGL7KpMptvndnI11xxOgZ/O','dgzhst@ehts','dhstdjst','srjsrbngbf','2005-01-01','Female','2019-01-24 18:13:23','Active',0),(20,'user19','$2a$10$tPv5b.R/B72Ihm1ISksoWe/LK1Ed5oXkI7dOsT0fGgQa9qHnpJmo6','fhesths@sdgnhsg','sghsrtjsr','sfgjsryjsr','2004-12-27','Female','2019-01-24 18:13:51','Active',0),(21,'user20','$2a$10$iJOpYEKNi6fjBZHMal3Zau/tNfr3IEwlFCCm5E.jBt4/JnwdXGlD2','trjsrjsr@hstjrtjsr','ethsrtjsrtj','srtjsrjsrj','2005-01-01','Female','2019-01-24 18:14:13','Active',0),(22,'user25','$2a$10$oLS80II/CZfrOLxpmpuAGusvezOwkqQfdvCe7.0Puq6AlD6D0Utye','dasda@asd','asd','asdsa','1999-01-11','Male','2019-01-25 12:35:17','Active',0),(23,'god','$2a$10$DTzYB2ADyY7/d8T1OoeDX.Eb1g6DiJHBthDkoWoBbyF6EmmP33hsK','god@god','god','god','2005-01-01','Male','2019-01-25 13:59:37','Active',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `allpublished`
--

/*!50001 DROP VIEW IF EXISTS `allpublished`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `allpublished` AS select `article`.`id` AS `id`,`article`.`category` AS `category`,`article`.`title` AS `title`,`article_images`.`article_img` AS `article_img`,`user`.`username` AS `username`,`article`.`pub_date` AS `pub_date` from ((`article_images` join `article` on((`article`.`id` = `article_images`.`article_id`))) join `user` on((`article`.`creator_id` = `user`.`id`))) group by `article`.`id` having (`article`.`pub_date` is not null) order by `article`.`pub_date` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-25 14:14:04
