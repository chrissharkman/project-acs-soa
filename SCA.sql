DROP TABLE issue;

CREATE TABLE issue (
    ID INTEGER NOT NULL  PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    numberPlate VARCHAR (50),
    status VARCHAR(100),
    createdDate DATE,
    comment VARCHAR(400),
    vehiculeType VARCHAR(100),
    vehiculeModel VARCHAR(100),
    handOut DATE DEFAULT NULL

);