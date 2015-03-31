/* DROP COMPLETE STRUCTURE TO INITIALIZE CORRECTLY */

DROP TABLE certificates;
DROP TABLE vehicles;
DROP TABLE vehicleTypes;
DROP TABLE constances;
DROP TABLE customers;
DROP TABLE status;


/* CREATE STRUCTURE */

CREATE TABLE vehicleTypes (
    category VARCHAR (100) NOT NULL PRIMARY KEY
);

CREATE TABLE status
(
    mode VARCHAR(100) NOT NULL PRIMARY KEY
);

CREATE TABLE constances
(
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    keyValue INTEGER NOT NULL,
    description VARCHAR(200)
);

CREATE TABLE customers
(
    id INTEGER NOT NULL PRIMARY KEY GENERATED   ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    lastname VARCHAR(100)
);

CREATE TABLE vehicles
(
    identificationNumber INTEGER NOT NULL PRIMARY KEY,
    typeCategory VARCHAR(100),
    modele VARCHAR(100),
    amount DOUBLE NOT NULL,
    CONSTRAINT fk_vhcTypeCategory FOREIGN KEY (typeCategory) REFERENCES vehicleTypes (category) 
);

CREATE TABLE certificates
(
    id INTEGER NOT NULL  PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    customerId INTEGER NOT NULL,
    vehicleIdentificationNumber INTEGER NOT NULL,
    status VARCHAR(100),
    createdDate DATE,
    comment VARCHAR(400),
    CONSTRAINT fk_status FOREIGN KEY (status) REFERENCES status(mode),
    CONSTRAINT fk_customer FOREIGN KEY (customerId) REFERENCES customers(id) ON DELETE CASCADE,
    CONSTRAINT fk_vhcId FOREIGN KEY (vehicleIdentificationNumber) REFERENCES vehicles(identificationNumber) ON DELETE CASCADE 
);

/* ADD MODEL DATA */






