CREATE TABLE customers
(
    ID INTEGER NOT NULL PRIMARY KEY GENERATED   ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    
lastname VARCHAR(100)
  
);
CREATE TABLE certificates
(
    ID INTEGER NOT NULL  PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    customerId INTEGER NOT NULL,
    vehiculeId INTEGER NOT NULL,
    amount DOUBLE NOT NULL,
    status ENUM('x-small', 'small', 'medium', 'large', 'x-large'),
    createdDate DATE,
    comment VARCHAR(400)
);

ALTER TABLE certificates
ADD  FOREIGN KEY (customerId) REFERENCES customers(ID) ;

ALTER TABLE certificates
ADD  FOREIGN KEY (vehiculeId) REFERENCES vehicules(ID) ;

CREATE TABLE vehicules
(
    ID INTEGER NOT NULL PRIMARY KEY GENERATED   ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    vehiculeType VARCHAR(100),
    modele VARCHAR(100)
 );



