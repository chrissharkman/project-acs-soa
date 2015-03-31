/* DROP COMPLETE STRUCTURE TO INITIALIZE CORRECTLY */

DROP TABLE issues;
DROP TABLE vehiculeTypes;
DROP TABLE customers;
DROP TABLE vehicles;
DROP TABLE status;


/* CREATE STRUCTURE */ 

CREATE TABLE vehiculeTypes (
    category VARCHAR (100) NOT NULL PRIMARY KEY
);

CREATE TABLE customers
(
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    lastname VARCHAR(100)
);

CREATE TABLE status
(
    mode VARCHAR(100) NOT NULL PRIMARY KEY
);

CREATE TABLE vehicles (
	identificationNumber VARCHAR(17) NOT NULL PRIMARY KEY,
	model VARCHAR(100),
	typeCategory VARCHAR(100),
	CONSTRAINT fk_vhcTypeCategory FOREIGN KEY (vehiculeTypeCategory) REFERENCES vehiculeTypes (category) 
)

CREATE TABLE issues (
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    numberPlate VARCHAR (50),
    vehicleIdentificationNumber VARCHAR(17) NOT NULL,
    customerId INTEGER NOT NULL,
    status VARCHAR(100),
    comment VARCHAR(400),
    createdDate DATE, 
    handOut DATE DEFAULT NULL,
    closeIssueDate DATE DEFULT NULL,
    CONSTRAINT fk_customer FOREIGN KEY (customerId) REFERENCES customers(id) ON DELETE CASCADE,
    CONSTRAINT fk_vhcId FOREIGN KEY (vehicleIdentificationNumber) REFERENCES vehicles(identificationNumber) ON DELETE CASCADE
);

/* ADD MODEL DATA */

