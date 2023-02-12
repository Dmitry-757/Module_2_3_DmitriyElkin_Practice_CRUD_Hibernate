
CREATE TABLE if not exists `specialty_tbl` (
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `name` varchar(255) DEFAULT NULL,
                                 `status` varchar(255) DEFAULT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE if not exists `skills_tbl` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `name` varchar(255) DEFAULT NULL,
                              `status` varchar(255) DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE if not exists `developers_tbl` (
                                  `id` bigint NOT NULL AUTO_INCREMENT,
                                  `firstName` varchar(255) DEFAULT NULL,
                                  `lastName` varchar(255) DEFAULT NULL,
                                  `status` varchar(255) DEFAULT NULL,
                                  `specialtyId` bigint DEFAULT NULL,
                                  PRIMARY KEY (`id`),
                                  KEY `FKjw6pfgemsw6plo0vgn0h9ne5i` (`specialtyId`),
                                  CONSTRAINT `FKjw6pfgemsw6plo0vgn0h9ne5i` FOREIGN KEY (`specialtyId`) REFERENCES `specialty_tbl` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE if not exists `developers_tbl_skills_tbl` (
                                             `Developer_id` bigint NOT NULL,
                                             `skills_id` bigint NOT NULL,
                                             PRIMARY KEY (`Developer_id`,`skills_id`),
                                             UNIQUE KEY `UK_l7ngqbssgq02s2p3cxgmk8jb3` (`skills_id`),
                                             CONSTRAINT `FKbwr6gb8qn36v8cfjuki147yph` FOREIGN KEY (`skills_id`) REFERENCES `skills_tbl` (`id`),
                                             CONSTRAINT `FKgtd8wwm44cgx18u797wiao4n1` FOREIGN KEY (`Developer_id`) REFERENCES `developers_tbl` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci