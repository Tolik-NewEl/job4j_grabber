CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

INSERT INTO company (id,name)
VALUES
  (1,'Imperdiet Dictum Corp.'),
  (2,'Nibh LLC'),
  (3,'Porttitor Foundation'),
  (4,'Libero Integer Associates'),
  (5,'Cursus Integer LLP'),
  (6,'Integer In Magna PC'),
  (7,'Ultrices Incorporated'),
  (8,'Et Corp.'),
  (9,'Felis Limited'),
  (10,'Sed Pede Cum Corp.');

INSERT INTO person (id,name,company_id)
VALUES
  (1,'Nero Gibson',7), (2,'Cody Waters',9), (3,'Erica Hamilton',4),
  (4,'Jelani Winters',5), (5,'Dieter Levy',9), (6,'Cruz Bell',10),
  (7,'Len Morrison',4), (8,'Cameron Roy',1), (9,'Megan Flynn',3),
  (10,'Anne Buchanan',6), (11,'Charles Mccoy',7), (12,'Axel Thornton',8),
  (13,'Damon Cooke',2), (14,'Dale Hammond',3), (15,'Xanthus Edwards',7),
  (16,'Cora Weaver',10), (17,'Cruz Barber',1), (18,'Lance Mcdaniel',9),
  (19,'Meghan Dominguez',1), (20,'Emerson Spencer',5), (21,'Clarke Sykes',6),
  (22,'Sydney Arnold',7), (23,'Alexa Mcfadden',3), (24,'Fletcher Morton',6),
  (25,'Mari Padilla',2), (26,'Gavin Romero',9), (27,'Constance Mcmillan',3),
  (28,'Ivan Kent',5), (29,'Brandon Kramer',7), (30,'Hilda Mcclain',5),
  (31,'Kalia Adkins',8), (32,'Zachary Beach',8), (33,'Beck Estrada',5),
  (34,'Sybill Conner',1), (35,'Bianca Arnold',2), (36,'Iliana Tanner',9),
  (37,'Juliet Jarvis',5), (38,'Nevada Kim',8), (39,'Kasper Livingston',3),
  (40,'Melanie Bolton',2), (41,'Shay Sears',5), (42,'Guy Knapp',3),
  (43,'Maggy Massey',5), (44,'Jerry Bowers',6), (45,'Aristotle Randolph',5),
  (46,'Callum Chang',3), (47,'Lev Walsh',8), (48,'Hiroko Kelley',3),
  (49,'Avye Cain',1), (50,'Margaret Stokes',4), (51,'Claudia Mcdonald',7),
  (52,'Irene Hodges',8), (53,'Fitzgerald Justice',8), (54,'Tana Gay',6),
  (55,'Ivana Lyons',2), (56,'Teegan Hunt',7), (57,'Emerald Gibbs',10),
  (58,'Wesley Reid',5), (59,'Christine Blake',6), (60,'Ashely Lowery',2);

select p.name, c.name from person as p
join company as c on p.company_id = c.id
where p.company_id != 5;

select c.name, count(p.company_id) from company as c
join person as p on c.id = p.company_id
group by c.name
having count(p.company_id) = (
	select count(company_id) as c from person
	group by company_id
	order by c DESC
	limit 1
);