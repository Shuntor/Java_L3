/* Creation des bases */

CREATE TABLE Locaux VALUES(
	idL int PRIMARY KEY,
	nom varchar(150),
	adresse varchar(150));

CREATE TABLE OS VALUES(
	idO int PRIMARY KEY,
	nom varchar(150),
	version varchar(150));

CREATE TABLE Salles VALUES(
	idS int PRIMARY KEY,
	numero int,
	FOREIGN KEY (idL) REFERENCES Locaux (idL));

CREATE TABLE Appareils VALUES(
	idA int PRIMARY KEY,
	nom varchar(150),
	typeA varchar(150),
	adrMac varchar(150),
	idS varchar(150),
	idO int,
	FOREIGN KEY (idS) REFERENCES Salles (idS),
	FOREIGN KEY (idO) REFERENCES OS (idO));
	

	