# --- !Ups
INSERT INTO User(id, email, password, fullname, isadmin) VALUES(NEXTVAL('UserSeq'), 'a@mail.com', 'pass', 'tanaka ichirou', true);
INSERT INTO User(id, email, password, fullname, isadmin) VALUES(NEXTVAL('UserSeq'), 'b@mail.com', 'pass', 'tanaka jirou', false);
INSERT INTO User(id, email, password, fullname, isadmin) VALUES(NEXTVAL('UserSeq'), 'c@mail.com', 'pass', 'tanaka suburou', false);
INSERT INTO User(id, email, password, fullname, isadmin) VALUES(NEXTVAL('UserSeq'), 'd@mail.com', 'pass', 'tanaka tarou', false);

# --- !Downs
DELETE FROM User;