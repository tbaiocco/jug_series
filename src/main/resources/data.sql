DROP TABLE IF EXISTS musicians;

CREATE TABLE musicians (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);

INSERT INTO musicians (first_name, last_name, career) VALUES
  ('Jim', 'Morrison', 'Vocals in The Doors. Died in July 3rd 1971.'),
  ('David', 'Gilmour', 'Guitar and vocals in Pink Floyd, Solo career'),
  ('Rory', 'Gallagher', 'Guitar and vocals in Taste, Solo career. Died in June 14th 1995.'),
  ('Levon', 'Helm', 'Drums and vocals in The Band, Solo career. Died in April 19th 2012.');