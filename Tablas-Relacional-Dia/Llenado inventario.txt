INSERT INTO hotel (k_idhotel,t_descuento,q_restriccionaforo) VALUES ('HT001',20,500);

INSERT INTO tipo (k_idtipo, n_descripcion, v_precio) VALUES ('T001','Contiene cama simple, baño, televisor pequeño y utensilios de aseo personal', 75000.00);
INSERT INTO tipo (k_idtipo, n_descripcion, v_precio) VALUES ('T002','Contiene cama doble, baño con jacuzzi, televisor de 40 pulgadas, sala amoblada y utensiolios de aseo', 150000.00);
INSERT INTO tipo (k_idtipo, n_descripcion, v_precio) VALUES ('T003','Contiene cama doble y sencilla, baño, pscina, televisor de 60 pulgadas y aspectos de la T002', 200000.00);

INSERT INTO habitacion (k_numero, k_idtipo, i_estado) VALUES ('H001','T001','d');
INSERT INTO habitacion (k_numero, k_idtipo, i_estado) VALUES ('H002','T001','d');
INSERT INTO habitacion (k_numero, k_idtipo, i_estado) VALUES ('H003','T001','d');
INSERT INTO habitacion (k_numero, k_idtipo, i_estado) VALUES ('H004','T001','d');
INSERT INTO habitacion (k_numero, k_idtipo, i_estado) VALUES ('H005','T002','d');
INSERT INTO habitacion (k_numero, k_idtipo, i_estado) VALUES ('H006','T002','d');
INSERT INTO habitacion (k_numero, k_idtipo, i_estado) VALUES ('H007','T002','d');
INSERT INTO habitacion (k_numero, k_idtipo, i_estado) VALUES ('H008','T002','d');
INSERT INTO habitacion (k_numero, k_idtipo, i_estado) VALUES ('H009','T003','d');
INSERT INTO habitacion (k_numero, k_idtipo, i_estado) VALUES ('H010','T003','d');
INSERT INTO habitacion (k_numero, k_idtipo, i_estado) VALUES ('H011','T003','d');
INSERT INTO habitacion (k_numero, k_idtipo, i_estado) VALUES ('H012','T003','d');

INSERT INTO consumo (k_idconsumo, n_nombre, i_tipo, i_unidad, q_stock, v_valor) VALUES ('CP001','Almuerzo','p','U',100,12000);
INSERT INTO consumo (k_idconsumo, n_nombre, i_tipo, i_unidad, q_stock, v_valor) VALUES ('CP002','Shampoo','p','U',1000,5600);
INSERT INTO consumo (k_idconsumo, n_nombre, i_tipo, i_unidad, q_stock, v_valor) VALUES ('CP003','Acondicionador','p','U',800,6000);
INSERT INTO consumo (k_idconsumo, n_nombre, i_tipo, i_unidad, q_stock, v_valor) VALUES ('CS001','MiniBar','s','T',4,20000);
INSERT INTO consumo (k_idconsumo, n_nombre, i_tipo, i_unidad, q_stock, v_valor) VALUES ('CS002','Masajista','s','T',10,30000);
INSERT INTO consumo (k_idconsumo, n_nombre, i_tipo, i_unidad, q_stock, v_valor) VALUES ('CS003','AtencionCuarto','s','T',100,5000);
INSERT INTO consumo (k_idconsumo, n_nombre, i_tipo, i_unidad, q_stock, v_valor) VALUES ('CS004','Gimnasio','s','T',1,15000);