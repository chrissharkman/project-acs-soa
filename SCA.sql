/* DROP COMPLETE STRUCTURE TO INITIALIZE CORRECTLY */

DROP TABLE issues;
DROP TABLE vehicles;
DROP TABLE vehicleTypes;
DROP TABLE customers;
DROP TABLE status;

/* CREATE STRUCTURE */ 

CREATE TABLE vehicleTypes (
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
	CONSTRAINT fk_vhcTypeCategory FOREIGN KEY (typeCategory) REFERENCES vehicleTypes (category) 
);

CREATE TABLE issues (
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    numberPlate VARCHAR (50),
    vehicleIdentificationNumber VARCHAR(17) NOT NULL,
    customerId INTEGER NOT NULL,
    status VARCHAR(100),
    comment VARCHAR(400),
    createdDate DATE, 
    handOut DATE DEFAULT NULL,
    closeIssueDate DATE DEFAULT NULL,
    CONSTRAINT fk_customer FOREIGN KEY (customerId) REFERENCES customers(id) ON DELETE CASCADE,
    CONSTRAINT fk_vhcId FOREIGN KEY (vehicleIdentificationNumber) REFERENCES vehicles(identificationNumber) ON DELETE CASCADE
);

/* ADD MODEL DATA */

INSERT INTO vehicleTypes 
  (category) 
VALUES 
  ('car'),('moto'),('truck');

INSERT INTO customers
  (lastname) 
VALUES 
  ('Christian'),('Florent'),('Jolene'),('Alissa');

INSERT INTO status 
  (mode) 
VALUES 
  ('approved'),('refused'),('requires modification'),('created');

INSERT INTO vehicles
  (identificationNumber,typeCategory,model) 
VALUES 
  ('CH111','car','m1'),('CH222','car','m2'),('CH333','moto','m4'),
  ('CH444','truck','m6'),('CH555','truck','m8');