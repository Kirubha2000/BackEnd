CREATE TABLE Register (
    userId INT NOT NULL PRIMARY KEY,
    firstName VARCHAR(30) NOT NULL,
    lastName VARCHAR(30),
    email VARCHAR(30),
    dateOfBirth DATE,
    password VARCHAR(15)
);
