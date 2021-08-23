CREATE USER 'GothicLlamasDBBot'@'%' IDENTIFIED BY 'password';

GRANT DELETE ON GothicLlamasDB.* TO 'GothicLlamasDBBot'@'%';
GRANT INSERT ON GothicLlamasDB.* TO 'GothicLlamasDBBot'@'%';
GRANT SELECT ON GothicLlamasDB.* TO 'GothicLlamasDBBot'@'%';
GRANT UPDATE ON GothicLlamasDB.* TO 'GothicLlamasDBBot'@'%';



