TRUNCATE TABLE Person;
ALTER TABLE Person ADD COLUMN role VARCHAR(100) NOT NULL;
UPDATE Person set role='ROLE_ADMIN' where id=9;