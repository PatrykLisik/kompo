CREATE TABLE events(
    id int,
    name varchar(30),
    start date,
    end date

);

CREATE TABLE persons(
    id int,
    name varchar(20),
    surname varchar(20)
);

CREATE TABLE notifications(
    id int,
    description varchar(40),
    notify_date date
);

CREATE TABLE event_person(
    person_id int,
    event_id int
);

CREATE TABLE notifications_events(
    event_id int,
    notification_id int
);
