ALTER TABLE addresses ADD COLUMN PLACE INT;
ALTER TABLE addresses MODIFY COLUMN PLACE LONG;
ALTER TABLE addresses DROP COLUMN PLACE;

INSERT into countries (country) VALUE ('BELARUS');
INSERT into countries (country) VALUE ('UKRAINE');
INSERT into countries (country) VALUE ('POLAND');
INSERT into countries (country) VALUE ('GERMANY');
INSERT into countries (country) VALUE ('ITALY');

INSERT into cities (city) VALUE ('MINSK');
INSERT into cities (city) VALUE ('KIEV');
INSERT into cities (city) VALUE ('WARSAW');
INSERT into cities (city) VALUE ('BERLIN');
INSERT into cities (city) VALUE ('ROME');

INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Kolasa',10,1,1);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Shevchenko',22,2,2);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Mira',11,2,3);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Gothe',25,4,4);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Warszawska',51,3,5);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Kolasa',10,1,1);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Shevchenko',22,2,2);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Mira',11,2,3);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Gothe',25,4,4);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Warszawska',51,3,5);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Kolasa',10,1,1);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Shevchenko',22,2,2);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Mira',11,2,3);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Gothe',25,4,4);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Warszawska',51,3,5);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Kolasa',10,1,1);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Shevchenko',22,2,2);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Mira',11,2,2);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Gothe',25,4,4);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Warszawska',51,3,3);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Kolasa',10,1,1);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Shevchenko',22,2,2);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Mira',11,2,2);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Gothe',25,4,4);
INSERT into addresses (STREET,HOUSE_NUM,COUNTRIES_ID,CITIES_ID) VALUES ('Warszawska',51,3,3);

INSERT into supermarkets (NAME,ADDRESSES_ID,STAFF_NUM,NEW_ARRIVAL_DATE,SQUARE,SECTION_NUM) VALUES ('Mila',1,5,DATE('2017-09-17'),50,2);
INSERT into supermarkets (NAME,ADDRESSES_ID,STAFF_NUM,NEW_ARRIVAL_DATE,SQUARE,SECTION_NUM) VALUES ('Gippo',3,100,DATE('2017-09-17'),250,10);
INSERT into supermarkets (NAME,ADDRESSES_ID,STAFF_NUM,NEW_ARRIVAL_DATE,SQUARE,SECTION_NUM) VALUES ('Auchan',5,150,DATE('2017-09-17'),450,20);
INSERT into supermarkets (NAME,ADDRESSES_ID,STAFF_NUM,NEW_ARRIVAL_DATE,SQUARE,SECTION_NUM) VALUES ('Aldi',4,20,DATE('2017-09-17'),100,5);
INSERT into supermarkets (NAME,ADDRESSES_ID,STAFF_NUM,NEW_ARRIVAL_DATE,SQUARE,SECTION_NUM) VALUES ('Auchan',2,100,DATE('2017-09-17'),350,10);


INSERT into onlineshops (NAME,ADDRESSES_ID,STAFF_NUM,NEW_ARRIVAL_DATE,SITE,MANAGERS_NUM) VALUES ('XiStore',6,5,DATE('2017-09-20'),'xistore.by',2);
INSERT into onlineshops (NAME,ADDRESSES_ID,STAFF_NUM,NEW_ARRIVAL_DATE,SITE,MANAGERS_NUM) VALUES ('ToysLand',7,5,DATE('2017-09-20'),'toysland.by',3);
INSERT into onlineshops (NAME,ADDRESSES_ID,STAFF_NUM,NEW_ARRIVAL_DATE,SITE,MANAGERS_NUM) VALUES ('Mobiland',8,5,DATE('2017-09-20'),'mobiland.ua',5);
INSERT into onlineshops (NAME,ADDRESSES_ID,STAFF_NUM,NEW_ARRIVAL_DATE,SITE,MANAGERS_NUM) VALUES ('HappyBaby',9,5,DATE('2017-09-20'),'happybaby.de',4);
INSERT into onlineshops (NAME,ADDRESSES_ID,STAFF_NUM,NEW_ARRIVAL_DATE,SITE,MANAGERS_NUM) VALUES ('Petshop',10,5,DATE('2017-09-20'),'petshop.pl',2);

INSERT into pavilions (NAME,ADDRESSES_ID,STAFF_NUM,NEW_ARRIVAL_DATE,PLACE_NUM) VALUES ('Mobiland',11,5,DATE('2017-09-25'),2);
INSERT into pavilions (NAME,ADDRESSES_ID,STAFF_NUM,NEW_ARRIVAL_DATE,PLACE_NUM) VALUES ('HobbyStore',12,3,DATE('2017-09-25'),12);
INSERT into pavilions (NAME,ADDRESSES_ID,STAFF_NUM,NEW_ARRIVAL_DATE,PLACE_NUM) VALUES ('Games',13,2,DATE('2017-09-25'),103);
INSERT into pavilions (NAME,ADDRESSES_ID,STAFF_NUM,NEW_ARRIVAL_DATE,PLACE_NUM) VALUES ('VideoMarket',14,1,DATE('2017-09-25'),20);
INSERT into pavilions (NAME,ADDRESSES_ID,STAFF_NUM,NEW_ARRIVAL_DATE,PLACE_NUM) VALUES ('Veraity',15,4,DATE('2017-09-25'),10);

INSERT into goods (GOOD_NAME,AMOUNT) VALUE ('chocolate',25);
INSERT into goods (GOOD_NAME,AMOUNT) VALUE ('sweets',50);
INSERT into goods (GOOD_NAME,AMOUNT) VALUE ('ice cream',20);
INSERT into goods (GOOD_NAME,AMOUNT) VALUE ('ice cake',5);
INSERT into goods (GOOD_NAME,AMOUNT) VALUE ('coca-cola',3);
INSERT into goods (GOOD_NAME,AMOUNT) VALUE ('fanta',3);
INSERT into goods (GOOD_NAME,AMOUNT) VALUE ('sprite',2);
INSERT into goods (GOOD_NAME,AMOUNT) VALUE ('milk',5);
INSERT into goods (GOOD_NAME,AMOUNT) VALUE ('yogurt',8);
INSERT into goods (GOOD_NAME,AMOUNT) VALUE ('cheese',12);
INSERT into goods (GOOD_NAME,AMOUNT) VALUE ('beer',8);
INSERT into goods (GOOD_NAME,AMOUNT) VALUE ('kvas',3);

INSERT into factorystores (NAME,ADDRESSES_ID,SQUARE,LOADER_NUM) VALUES ('Roshen',16,700,5);
INSERT into factorystores (NAME,ADDRESSES_ID,SQUARE,LOADER_NUM) VALUES ('Gosha',17,500,5);
INSERT into factorystores (NAME,ADDRESSES_ID,SQUARE,LOADER_NUM) VALUES ('Coca-Cola',18,1200,10);
INSERT into factorystores (NAME,ADDRESSES_ID,SQUARE,LOADER_NUM) VALUES ('Savushkin',19,1000,10);
INSERT into factorystores (NAME,ADDRESSES_ID,SQUARE,LOADER_NUM) VALUES ('Heineken',20,1200,12);

INSERT into factorystores_has_goods (FACTORYSTORES_ID,GOODS_ID) VALUES (1,1);
INSERT into factorystores_has_goods (FACTORYSTORES_ID,GOODS_ID) VALUES (1,2);
INSERT into factorystores_has_goods (FACTORYSTORES_ID,GOODS_ID) VALUES (2,3);
INSERT into factorystores_has_goods (FACTORYSTORES_ID,GOODS_ID) VALUES (2,4);
INSERT into factorystores_has_goods (FACTORYSTORES_ID,GOODS_ID) VALUES (3,5);
INSERT into factorystores_has_goods (FACTORYSTORES_ID,GOODS_ID) VALUES (3,6);
INSERT into factorystores_has_goods (FACTORYSTORES_ID,GOODS_ID) VALUES (3,7);
INSERT into factorystores_has_goods (FACTORYSTORES_ID,GOODS_ID) VALUES (4,8);
INSERT into factorystores_has_goods (FACTORYSTORES_ID,GOODS_ID) VALUES (4,9);
INSERT into factorystores_has_goods (FACTORYSTORES_ID,GOODS_ID) VALUES (4,10);
INSERT into factorystores_has_goods (FACTORYSTORES_ID,GOODS_ID) VALUES (5,11);
INSERT into factorystores_has_goods (FACTORYSTORES_ID,GOODS_ID) VALUES (5,12);

INSERT into producers (PRODUCER_NAME,ORDERS_NUM) VALUE ('Mikita',10);
INSERT into producers (PRODUCER_NAME,ORDERS_NUM) VALUE ('Bosch',8);
INSERT into producers (PRODUCER_NAME,ORDERS_NUM) VALUE ('Milka',45);
INSERT into producers (PRODUCER_NAME,ORDERS_NUM) VALUE ('AlpenGold',32);
INSERT into producers (PRODUCER_NAME,ORDERS_NUM) VALUE ('Bergoff',20);
INSERT into producers (PRODUCER_NAME,ORDERS_NUM) VALUE ('Luminarc',18);
INSERT into producers (PRODUCER_NAME,ORDERS_NUM) VALUE ('Zara',100);
INSERT into producers (PRODUCER_NAME,ORDERS_NUM) VALUE ('Bershka',120);
INSERT into producers (PRODUCER_NAME,ORDERS_NUM) VALUE ('Federichi',80);
INSERT into producers (PRODUCER_NAME,ORDERS_NUM) VALUE ('Nescafe',95);

INSERT into logisticstores (NAME,ADDRESSES_ID,SQUARE,LOADER_NUM,NEW_ARRIVAL_DATE) VALUES ('StroyLogistic',21,5000,10,DATE('2017-09-25'));
INSERT into logisticstores (NAME,ADDRESSES_ID,SQUARE,LOADER_NUM,NEW_ARRIVAL_DATE) VALUES ('SweetL',22,2000,5,DATE('2017-09-25'));
INSERT into logisticstores (NAME,ADDRESSES_ID,SQUARE,LOADER_NUM,NEW_ARRIVAL_DATE) VALUES ('HomeLogistic',23,3000,8,DATE('2017-09-25'));
INSERT into logisticstores (NAME,ADDRESSES_ID,SQUARE,LOADER_NUM,NEW_ARRIVAL_DATE) VALUES ('ClothStore',24,2000,5,DATE('2017-09-25'));
INSERT into logisticstores (NAME,ADDRESSES_ID,SQUARE,LOADER_NUM,NEW_ARRIVAL_DATE) VALUES ('MealsGood',25,5000,10,DATE('2017-09-25'));

INSERT into logisticstores_has_producers (LOGISTICSTORES_ID,PRODUCERS_ID) VALUES (1,1);
INSERT into logisticstores_has_producers (LOGISTICSTORES_ID,PRODUCERS_ID) VALUES (1,2);
INSERT into logisticstores_has_producers (LOGISTICSTORES_ID,PRODUCERS_ID) VALUES (2,3);
INSERT into logisticstores_has_producers (LOGISTICSTORES_ID,PRODUCERS_ID) VALUES (2,4);
INSERT into logisticstores_has_producers (LOGISTICSTORES_ID,PRODUCERS_ID) VALUES (3,5);
INSERT into logisticstores_has_producers (LOGISTICSTORES_ID,PRODUCERS_ID) VALUES (3,6);
INSERT into logisticstores_has_producers (LOGISTICSTORES_ID,PRODUCERS_ID) VALUES (4,7);
INSERT into logisticstores_has_producers (LOGISTICSTORES_ID,PRODUCERS_ID) VALUES (4,8);
INSERT into logisticstores_has_producers (LOGISTICSTORES_ID,PRODUCERS_ID) VALUES (5,9);
INSERT into logisticstores_has_producers (LOGISTICSTORES_ID,PRODUCERS_ID) VALUES (5,10);

SELECT NAME,STAFF_NUM,SQUARE,SECTION_NUM,NEW_ARRIVAL_DATE,COUNTRY,CITY,STREET,HOUSE_NUM from supermarkets,addresses,countries,cities
WHERE supermarkets.ADDRESSES_ID=addresses.ID
AND addresses.COUNTRIES_ID=countries.idCOUNTRIES
AND addresses.CITIES_ID=cities.idCITIES
ORDER BY SQUARE;

UPDATE onlineshops SET NEW_ARRIVAL_DATE='2017-10-01' WHERE ID=3;

SELECT DISTINCT NAME,SITE,STAFF_NUM,MANAGERS_NUM,NEW_ARRIVAL_DATE,COUNTRY,CITY,STREET,HOUSE_NUM from onlineshops AS os
LEFT JOIN addresses AS adr
ON adr.ID=os.ADDRESSES_ID
LEFT JOIN countries AS cntr
ON cntr.idCOUNTRIES=adr.COUNTRIES_ID
LEFT JOIN cities AS c
ON c.idCITIES=adr.CITIES_ID
WHERE NEW_ARRIVAL_DATE='2017-09-20'
ORDER BY STAFF_NUM;

SELECT NAME,PRODUCER_NAME,MAX(ORDERS_NUM) from logisticstores AS ls
LEFT JOIN logisticstores_has_producers AS lspr
ON lspr.LOGISTICSTORES_ID=ls.ID
LEFT JOIN producers AS pr
ON pr.ID=lspr.PRODUCERS_ID
GROUP BY ORDERS_NUM
ORDER BY ORDERS_NUM DESC;

SELECT NAME,COUNT(AMOUNT) AS NUM_GOODS,SQUARE,LOADER_NUM,COUNTRY,CITY,STREET,HOUSE_NUM from factorystores AS fs
LEFT JOIN factorystores_has_goods AS fsg
ON fsg.FACTORYSTORES_ID=fs.ID
LEFT JOIN goods AS g
ON g.ID=fsg.GOODS_ID
LEFT JOIN addresses AS adr
ON adr.ID=fs.ADDRESSES_ID
LEFT JOIN countries AS cntr
ON cntr.idCOUNTRIES=adr.COUNTRIES_ID
LEFT JOIN cities AS c
ON c.idCITIES=adr.CITIES_ID
GROUP BY NAME
HAVING COUNT(AMOUNT)>2
ORDER BY AMOUNT
