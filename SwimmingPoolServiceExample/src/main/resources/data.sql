INSERT INTO swimmingpool.day (id, name) VALUES ('1', 'Lunes');
INSERT INTO swimmingpool.day (id, name) VALUES ('2', 'Martes');
INSERT INTO swimmingpool.day (id, name) VALUES ('3', 'Miercoles');
INSERT INTO swimmingpool.day (id, name) VALUES ('4', 'Jueves');
INSERT INTO swimmingpool.day (id, name) VALUES ('5', 'Viernes');
INSERT INTO swimmingpool.day (id, name) VALUES ('6', 'Sabado');
INSERT INTO swimmingpool.day (id, name) VALUES ('7', 'Domingo');


INSERT INTO swimmingpool.section (id, end, start) VALUES ('1', '8:00', '7:00');
INSERT INTO swimmingpool.section (id, end, start) VALUES ('2', '9:00', '8:00');
INSERT INTO swimmingpool.section (id, end, start) VALUES ('3', '10:00', '9:00');
INSERT INTO swimmingpool.section (id, end, start) VALUES ('4', '11:00', '10:00');
INSERT INTO swimmingpool.section (id, end, start) VALUES ('5', '12:00', '11:00');
INSERT INTO swimmingpool.section (id, end, start) VALUES ('6', '13:00', '12:00');
INSERT INTO swimmingpool.section (id, end, start) VALUES ('7', '14:00', '13:00');
INSERT INTO swimmingpool.section (id, end, start) VALUES ('8', '15:00', '14:00');
INSERT INTO swimmingpool.section (id, end, start) VALUES ('9', '16:00', '15:00');
INSERT INTO swimmingpool.section (id, end, start) VALUES ('10', '17:00', '16:00');
INSERT INTO swimmingpool.section (id, end, start) VALUES ('11', '18:00', '17:00');
INSERT INTO swimmingpool.section (id, end, start) VALUES ('12', '19:00', '18:00');
INSERT INTO swimmingpool.section (id, end, start) VALUES ('13', '20:00', '19:00');
INSERT INTO swimmingpool.section (id, end, start) VALUES ('14', '21:00', '20:00');
INSERT INTO swimmingpool.section (id, end, start) VALUES ('15', '22:00', '21:00');
INSERT INTO swimmingpool.section (id, end, start) VALUES ('16', '23:00', '22:00');


INSERT INTO swimmingpool.day_section (day,section) (select d.id, s.id
	from swimmingpool.section as s, swimmingpool.day as d);