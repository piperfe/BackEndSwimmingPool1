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



INSERT INTO swimmingpool.day_section (day,section) (select d.id, s.id
	from swimmingpool.section as s, swimmingpool.day as d);

INSERT INTO `swimmingpool`.`region` (`id`, `name`) VALUES ('1', 'ARICA Y PARINACOTA');
INSERT INTO `swimmingpool`.`region` (`id`, `name`) VALUES ('2', 'TARAPACÁ ');
INSERT INTO `swimmingpool`.`region` (`id`, `name`) VALUES ('3', 'ANTOFAGASTA');
INSERT INTO `swimmingpool`.`region` (`id`, `name`) VALUES ('4', 'ATACAMA');
INSERT INTO `swimmingpool`.`region` (`id`, `name`) VALUES ('5', 'COQUIMBO');
INSERT INTO `swimmingpool`.`region` (`id`, `name`) VALUES ('6', 'VALPARAÍSO');
INSERT INTO `swimmingpool`.`region` (`id`, `name`) VALUES ('7', 'LIBERTADOR GRAL. BERNARDO O\'HIGGINS');
INSERT INTO `swimmingpool`.`region` (`id`, `name`) VALUES ('8', 'MAULE');
INSERT INTO `swimmingpool`.`region` (`id`, `name`) VALUES ('9', 'BIOBÍO');
INSERT INTO `swimmingpool`.`region` (`id`, `name`) VALUES ('10', 'LA ARAUCANÍA');
INSERT INTO `swimmingpool`.`region` (`id`, `name`) VALUES ('11', 'LOS RÍOS');
INSERT INTO `swimmingpool`.`region` (`id`, `name`) VALUES ('12', 'LOS LAGOS');
INSERT INTO `swimmingpool`.`region` (`id`, `name`) VALUES ('13', 'AISÉN DEL GRAL. CARLOS IBAÑEZ DEL CAMPO');
INSERT INTO `swimmingpool`.`region` (`id`, `name`) VALUES ('14', 'MAGALLANES Y DE LA ANTÁRTICA CHILENA');
INSERT INTO `swimmingpool`.`region` (`id`, `name`) VALUES ('15', 'METROPOLITANA DE SANTIAGO');



INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('1','Arica','1');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('2','Camarones','1');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('3','Putre','1');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('4','General Lagos','1');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('5','Iquique','2');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('6','Alto Hospicio','2');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('7','Pozo Almonte','2');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('8','Camiña','2');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('9','Colchane','2');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('10','Huara','2');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('11','Pica','2');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('12','Antofagasta','3');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('13','Mejillones','3');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('14','Sierra Gorda','3');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('15','Taltal','3');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('16','Calama','3');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('17','Ollagüe','3');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('18','San Pedro de Atacama','3');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('19','Tocopilla','3');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('20','María Elena','3');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('21','Copiapó','4');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('22','Caldera','4');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('23','Tierra Amarilla','4');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('24','Chañaral','4');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('25','Diego de Almagro','4');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('26','Vallenar','4');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('27','Alto del Carmen','4');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('28','Freirina','4');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('29','Huasco','4');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('30','La Serena','5');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('31','Coquimbo','5');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('32','Andacollo','5');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('33','La Higuera','5');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('34','Paiguano','5');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('35','Vicuña','5');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('36','Illapel','5');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('37','Canela','5');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('38','Los Vilos','5');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('39','Salamanca','5');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('40','Ovalle','5');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('41','Combarbalá','5');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('42','Monte Patria','5');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('43','Punitaqui','5');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('44','Río Hurtado','5');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('45','Valparaíso','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('46','Casablanca','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('47','Concón','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('48','Juan Fernández','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('49','Puchuncaví','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('50','Quintero','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('51','Viña del Mar','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('52','Isla de Pascua','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('53','Los Andes','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('54','Calle Larga','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('55','Rinconada','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('56','San Esteban','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('57','La Ligua','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('58','Cabildo','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('59','Papudo','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('60','Petorca','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('61','Zapallar','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('62','Quillota','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('63','Calera','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('64','Hijuelas','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('65','La Cruz','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('66','Nogales','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('67','San Antonio','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('68','Algarrobo','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('69','Cartagena','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('70','El Quisco','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('71','El Tabo','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('72','Santo Domingo','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('73','San Felipe','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('74','Catemu','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('75','Llaillay','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('76','Panquehue','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('77','Putaendo','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('78','Santa María','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('79','Limache','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('80','Quilpué','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('81','Villa Alemana','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('82','Olmué','6');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('83','Rancagua','7');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('84','Codegua','7');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('85','Coinco','7');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('86','Coltauco','7');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('87','Doñihue','7');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('88','Graneros','7');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('89','Las Cabras','7');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('90','Machalí','7');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('91','Malloa','7');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('92','Mostazal','7');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('93','Olivar','7');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('94','Peumo','7');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('95','Pichidegua','7');
INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('96','Quinta de Tilcoco','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('97','Rengo','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('98','Requínoa','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('99','San Vicente','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('100','Pichilemu','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('101','La Estrella','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('102','Litueche','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('103','Marchihue','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('104','Navidad','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('105','Paredones','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('106','San Fernando','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('107','Chépica','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('108','Chimbarongo','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('109','Lolol','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('110','Nancagua','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('111','Palmilla','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('112','Peralillo','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('113','Placilla','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('114','Pumanque','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('115','Santa Cruz','7');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('116','Talca','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('117','Constitución','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('118','Curepto','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('119','Empedrado','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('120','Maule','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('121','Pelarco','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('122','Pencahue','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('123','Río Claro','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('124','San Clemente','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('125','San Rafael','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('126','Cauquenes','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('127','Chanco','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('128','Pelluhue','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('129','Curicó','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('130','Hualañé','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('131','Licantén','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('132','Molina','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('133','Rauco','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('134','Romeral','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('135','Sagrada Familia','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('136','Teno','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('137','Vichuquén','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('138','Linares','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('139','Colbún','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('140','Longaví','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('141','Parral','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('142','Retiro','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('143','San Javier','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('144','Villa Alegre','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('145','Yerbas Buenas','8');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('146','Concepción','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('147','Coronel','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('148','Chiguayante','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('149','Florida','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('150','Hualqui','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('151','Lota','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('152','Penco','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('153','San Pedro de la Paz','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('154','Santa Juana','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('155','Talcahuano','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('156','Tomé','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('157','Hualpén','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('158','Lebu','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('159','Arauco','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('160','Cañete','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('161','Contulmo','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('162','Curanilahue','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('163','Los Alamos','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('164','Tirúa','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('165','Los Angeles','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('166','Antuco','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('167','Cabrero','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('168','Laja','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('169','Mulchén','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('170','Nacimiento','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('171','Negrete','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('172','Quilaco','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('173','Quilleco','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('174','San Rosendo','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('175','Santa Bárbara','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('176','Tucapel','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('177','Yumbel','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('178','Alto Biobío','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('179','Chillán','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('180','Bulnes','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('181','Cobquecura','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('182','Coelemu','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('183','Coihueco','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('184','Chillán Viejo','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('185','El Carmen','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('186','Ninhue','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('187','Ñiquén','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('188','Pemuco','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('189','Pinto','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('190','Portezuelo','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('191','Quillón','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('192','Quirihue','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('193','Ránquil','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('194','San Carlos','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('195','San Fabián','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('196','San Ignacio','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('197','San Nicolás','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('198','Treguaco','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('199','Yungay','9');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('200','Temuco','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('201','Carahue','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('202','Cunco','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('203','Curarrehue','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('204','Freire','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('205','Galvarino','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('206','Gorbea','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('207','Lautaro','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('208','Loncoche','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('209','Melipeuco','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('210','Nueva Imperial','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('211','Padre Las Casas','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('212','Perquenco','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('213','Pitrufquén','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('214','Pucón','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('215','Saavedra','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('216','Teodoro Schmidt','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('217','Toltén','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('218','Vilcún','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('219','Villarrica','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('220','Cholchol','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('221','Angol','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('222','Collipulli','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('223','Curacautín','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('224','Ercilla','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('225','Lonquimay','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('226','Los Sauces','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('227','Lumaco','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('228','Purén','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('229','Renaico','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('230','Traiguén','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('231','Victoria','10');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('232','Valdivia','11');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('233','Corral','11');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('234','Lanco','11');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('235','Los Lagos','11');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('236','Máfil','11');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('237','Mariquina','11');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('238','Paillaco','11');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('239','Panguipulli','11');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('240','La Unión','11');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('241','Futrono','11');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('242','Lago Ranco','11');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('243','Río Bueno','11');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('244','Puerto Montt','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('245','Calbuco','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('246','Cochamó','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('247','Fresia','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('248','Frutillar','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('249','Los Muermos','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('250','Llanquihue','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('251','Maullín','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('252','Puerto Varas','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('253','Castro','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('254','Ancud','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('255','Chonchi','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('256','Curaco de Vélez','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('257','Dalcahue','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('258','Puqueldón','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('259','Queilén','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('260','Quellón','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('261','Quemchi','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('262','Quinchao','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('263','Osorno','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('264','Puerto Octay','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('265','Purranque','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('266','Puyehue','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('267','Río Negro','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('268','San Juan de la Costa','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('269','San Pablo','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('270','Chaitén','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('271','Futaleufú','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('272','Hualaihué','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('273','Palena','12');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('274','Coihaique','13');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('275','Lago Verde','13');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('276','Aisén','13');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('277','Cisnes','13');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('278','Guaitecas','13');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('279','Cochrane','13');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('280','O\'Higgins','13');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('281','Tortel','13');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('282','Chile Chico','13');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('283','Río Ibáñez','13');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('284','Punta Arenas','14');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('285','Laguna Blanca','14');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('286','Río Verde','14');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('287','San Gregorio','14');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('288','Cabo de Hornos (Ex-Navarino)','14');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('289','Antártica','14');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('290','Porvenir','14');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('291','Primavera','14');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('292','Timaukel','14');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('293','Natales','14');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('294','Torres del Paine','14');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('295','Santiago','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('296','Cerrillos','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('297','Cerro Navia','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('298','Conchalí','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('299','El Bosque','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('300','Estación Central','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('301','Huechuraba','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('302','Independencia','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('303','La Cisterna','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('304','La Florida','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('305','La Granja','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('306','La Pintana','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('307','La Reina','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('308','Las Condes','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('309','Lo Barnechea','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('310','Lo Espejo','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('311','Lo Prado','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('312','Macul','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('313','Maipú','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('314','Ñuñoa','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('315','Pedro Aguirre Cerda','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('316','Peñalolén','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('317','Providencia','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('318','Pudahuel','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('319','Quilicura','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('320','Quinta Normal','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('321','Recoleta','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('322','Renca','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('323','San Joaquín','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('324','San Miguel','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('325','San Ramón','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('326','Vitacura','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('327','Puente Alto','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('328','Pirque','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('329','San José de Maipo','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('330','Colina','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('331','Lampa','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('332','Tiltil','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('333','San Bernardo','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('334','Buin','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('335','Calera de Tango','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('336','Paine','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('337','Melipilla','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('338','Alhué','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('339','Curacaví','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('340','María Pinto','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('341','San Pedro','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('342','Talagante','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('343','El Monte','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('344','Isla de Maipo','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('345','Padre Hurtado','15');

INSERT INTO `swimmingpool`.`commune` (`id`, `name`, `region`) VALUES ('346','Peñaflor','15');

