DROP DATABASE IF EXISTS calendar_data;
CREATE DATABASE calendar_data;

use calendar_data;


CREATE TABLE events(
    id int,
    name varchar(30),
    start DATETIME,
    end DATETIME
);


ALTER TABLE events
ADD PRIMARY KEY (id);

CREATE TABLE persons(
    id int,
    name varchar(20),
    surname varchar(20)
);

ALTER TABLE persons
ADD PRIMARY KEY (id);

CREATE TABLE notifications(
    id int,
    description varchar(40),
    notify_date DATETIME
);

ALTER TABLE notifications
ADD PRIMARY KEY (id);

CREATE TABLE event_person(
    person_id int,
    event_id int
);

ALTER TABLE event_person
ADD FOREIGN KEY (person_id) REFERENCES persons(id);
ALTER TABLE event_person
ADD FOREIGN KEY (event_id) REFERENCES events(id);

CREATE TABLE notifications_events(
    event_id int,
    notification_id int
);


DESCRIBE persons;
DESCRIBE event_person;
DESCRIBE notifications_events;
DESCRIBE notifications;
