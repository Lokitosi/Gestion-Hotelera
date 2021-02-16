/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 15.0 		*/
/*  Created On : 16-feb.-2021 6:06:52 p. m. 				*/
/*  DBMS       : PostgreSQL 						*/
/* ---------------------------------------------------- */

/* Drop Tables */

DROP TABLE IF EXISTS Consumo CASCADE
;

DROP TABLE IF EXISTS Cuenta CASCADE
;

DROP TABLE IF EXISTS CuentaConsumo CASCADE
;

DROP TABLE IF EXISTS Habitacion CASCADE
;

DROP TABLE IF EXISTS Hotel CASCADE
;

DROP TABLE IF EXISTS Huesped CASCADE
;

DROP TABLE IF EXISTS Pago CASCADE
;

DROP TABLE IF EXISTS Persona CASCADE
;

DROP TABLE IF EXISTS RegistroCI CASCADE
;

DROP TABLE IF EXISTS Reserva CASCADE
;

DROP TABLE IF EXISTS ReservaHabitacion CASCADE
;

DROP TABLE IF EXISTS Telefono CASCADE
;

DROP TABLE IF EXISTS Tipo CASCADE
;

/* Create Tables */

CREATE TABLE Consumo
(
	k_idConsumo varchar(5) NOT NULL,	-- Identificador del consumo, es a groso modo un apuntador de los diferentes productos y servicios
	n_nombre varchar(20) NOT NULL,	-- Nombre del producto o servicio.
	i_tipo char(1) NOT NULL,	-- Brinda informacion, de si lo anterior es o un producto (P) o un servicio (S).
	i_unidad char(1) NOT NULL,	-- Aporta la unidad en la cual es mediada dicho consumo.  Dentro de los posibles valores se tiene: "U" unidades, "T" tiempo, medido en minutos. 
	q_stock smallint NOT NULL,	-- Stock hace relacion a los productos y servicios que estan a disposicion.
	v_valor numeric(7,2) NOT NULL	-- Valor a pagar por cada producto y servicio
)
;

CREATE TABLE Cuenta
(
	k_cuenta varchar(4) NOT NULL,	-- Identificador de la cuenta.
	k_IdPago varchar(4) NULL	-- Identificador del pago relacionado a la cuenta
)
;

CREATE TABLE CuentaConsumo
(
	k_cuenta varchar(4) NOT NULL,	-- Identificador de la cuenta
	k_idConsumo varchar(5) NOT NULL,	-- Identificador de lo consumido
	f_consumo date NOT NULL,	-- Fecha en la que se realizo la peticion del consumo
	q_cantidadPedida smallint NOT NULL	-- Cantidad de lo pedido
)
;

CREATE TABLE Habitacion
(
	k_numero varchar(4) NOT NULL,	-- Numero de la habitacion
	k_idTipo varchar(4) NOT NULL,	-- Tipo de habitacion 
	i_estado char(1) NOT NULL	-- Estado de la habitacion. Dentro de los posibles valores esta "h" habitada, "r" reservada y "d" disponible.
)
;

CREATE TABLE Hotel
(
	k_idHotel varchar(5) NOT NULL,	-- Identificador del hotel
	t_descuento smallint NOT NULL,	-- Descuento relacionado a una cantidad de dias
	q_restriccionAforo smallint NOT NULL	-- Cantidad de huespedes maximo dentro dentro del hotel.
)
;

CREATE TABLE Huesped
(
	k_numeroID numeric(10) NOT NULL,	-- Comparte el identificador de numero de ID con la tabla "Persona" por ser una especializacion.  Numero identificador del huesped
	k_tipo char(2) NOT NULL,	-- Tipo de documento que posee el huesped
	f_nacimiento date NOT NULL,	-- Fecha de nacimiento del huesped
	n_direccion varchar(30) NOT NULL	-- Direccion donde reside el huesped
)
;

CREATE TABLE Pago
(
	k_IdPago varchar(4) NOT NULL,	-- Identificador del pago realizado
	f_pago date NOT NULL	-- Fecha cuando se realiza el pago
)
;

CREATE TABLE Persona
(
	k_numeroID numeric(10) NOT NULL,	-- Corresponde al numero identificador de la persona, independientemente cual sea su tipo de documento.
	k_tipo char(2) NOT NULL,	-- Especificacion del tipo de documento que identifica a la persona, dentro de los posibles valores que puede tomar estan TI, CC, RC y CE, que corresponde respectivamente a tarjeta de identidad, cedula de ciudadania, registro civil y cedula de extranjeria.
	n_nombre1 varchar(20) NOT NULL,	-- Primer nombre de la persona
	n_nombre2 varchar(20) NULL,	-- Segundo nombre de la persona (este puede ser vacio).
	n_apellido1 varchar(20) NOT NULL,	-- Primer apellido de la persona
	n_apellido2 varchar(20) NOT NULL	-- Segundo apellido de la persona
)
;

CREATE TABLE RegistroCI
(
	k_registro varchar(5) NOT NULL,	-- Identificar del registro
	k_codigo varchar(4) NOT NULL,	-- Identificador de la reserva
	k_numeroID numeric(10) NOT NULL,	-- Numero identificador del huesped 
	k_tipo char(2) NOT NULL,	-- Tipo de documento que maneja el huesped
	f_inicio date NOT NULL,	-- Fecha de entrada del huesped en referente a la reserva
	f_salida date NOT NULL	-- Fecha de salida del huesped
)
;

CREATE TABLE Reserva
(
	k_codigo varchar(4) NOT NULL,	-- Codigo identificador de la reserva ante el sistema hotelero
	k_idHotel varchar(5) NOT NULL,
	k_numeroID numeric(10) NOT NULL,	-- Numero identificador de la persona encargada de realizar la reserva.
	k_tipo char(2) NOT NULL,	-- Tipo de documento que maneja la persona encargada de realizar la reserva
	k_cuenta varchar(4) NULL,	-- Identificador de la cuenta asociada a dicha reserva, este puede ser nulo, pues puede que el huesped nunca pida un consumo.
	f_inicio date NOT NULL,	-- Fecha de inicio de la reserva
	q_duracion smallint NOT NULL,	-- Cantidad en dias de la duracion que tendra la estadia
	i_estado char(1) NOT NULL,	-- Estado de la reserva, este varia en tres posibles valores, "a" para reservas activas e "i" para reservas inactivas.
	q_cantPersonas smallint NOT NULL	-- Cantidad de personas que se ven involucradas en la reservacion.
)
;

CREATE TABLE ReservaHabitacion
(
	k_numero varchar(4) NOT NULL,	-- Numero de la habitacion
	k_codigo varchar(4) NOT NULL	-- Codigo de la reserva
)
;

CREATE TABLE Telefono
(
	k_numeroID numeric(10) NOT NULL,	-- Numero de identificacion de la persona 
	k_tipo varchar(2) NOT NULL,	-- Tipo de documento que identifica a la persona
	k_telefono numeric(10) NOT NULL	-- Numero telefonico de una persona
)
;

CREATE TABLE Tipo
(
	k_idTipo varchar(4) NOT NULL,	-- Identificador del tipo de habitacion
	n_descripcion varchar(200) NOT NULL,	-- Informa de las caracteristicas de la habitacion
	v_precio numeric(8,2) NOT NULL	-- Valor por noche de la habitacion.
)
;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE Consumo ADD CONSTRAINT PK_Consumo
	PRIMARY KEY (k_idConsumo)
;

ALTER TABLE Consumo ADD CONSTRAINT CK_Tipo CHECK (i_tipo = 's' or i_tipo = 'p')
;

ALTER TABLE Consumo ADD CONSTRAINT CK_Unidad CHECK (i_unidad = 'U' or i_unidad = 'T')
;

ALTER TABLE Consumo ADD CONSTRAINT CK_Stock CHECK (q_stock >= 0)
;

ALTER TABLE Consumo ADD CONSTRAINT CK_Valor CHECK (v_valor > 0)
;

ALTER TABLE Cuenta ADD CONSTRAINT PK_Cuenta
	PRIMARY KEY (k_cuenta)
;

CREATE INDEX IXFK_Cuenta_Pago ON Cuenta (k_IdPago ASC)
;

CREATE INDEX IXFK_Cuenta_Reserva ON Cuenta (k_cuenta ASC)
;

ALTER TABLE CuentaConsumo ADD CONSTRAINT PK_CuentaConsumo
	PRIMARY KEY (f_consumo,q_cantidadPedida,k_idConsumo,k_cuenta)
;

ALTER TABLE CuentaConsumo ADD CONSTRAINT CK_CantidadPedida CHECK (q_cantidadPedida > 0)
;

CREATE INDEX IXFK_CuentaConsumo_Consumo ON CuentaConsumo (k_idConsumo ASC)
;

CREATE INDEX IXFK_CuentaConsumo_Cuenta ON CuentaConsumo (k_cuenta ASC)
;

CREATE INDEX IXFK_CuentaConsumo_Cuenta_02 ON CuentaConsumo (k_cuenta ASC)
;

ALTER TABLE Habitacion ADD CONSTRAINT PK_Habitacion
	PRIMARY KEY (k_numero)
;

ALTER TABLE Habitacion ADD CONSTRAINT CK_Estado CHECK (i_estado = 'd' or i_estado = 'r' or i_estado = 'h')
;

CREATE INDEX IXFK_Habitacion_Tipo ON Habitacion (k_idTipo ASC)
;

ALTER TABLE Hotel ADD CONSTRAINT PK_Hotel
	PRIMARY KEY (k_idHotel)
;

ALTER TABLE Hotel ADD CONSTRAINT CK_Descuento CHECK (t_descuento >= 0 and t_descuento < 101)
;

ALTER TABLE Hotel ADD CONSTRAINT CK_Aforo CHECK (q_restriccionAforo > 0)
;

ALTER TABLE Huesped ADD CONSTRAINT PK_Huesped
	PRIMARY KEY (k_numeroID,k_tipo)
;

CREATE INDEX IXFK_Huesped_Persona ON Huesped (k_numeroID ASC,k_tipo ASC)
;

ALTER TABLE Pago ADD CONSTRAINT PK_Pago
	PRIMARY KEY (k_IdPago)
;

ALTER TABLE Persona ADD CONSTRAINT PK_Persona
	PRIMARY KEY (k_numeroID,k_tipo)
;

ALTER TABLE Persona ADD CONSTRAINT CK_NumeroID CHECK (k_numeroID > 0)
;

ALTER TABLE Persona ADD CONSTRAINT CK_Tipo CHECK (k_tipo = 'TI' or k_tipo = 'CC' or k_tipo = 'RC' or k_tipo = 'CE')
;

ALTER TABLE RegistroCI ADD CONSTRAINT PK_RegistroCI
	PRIMARY KEY (k_registro)
;

CREATE INDEX IXFK_RegistroCI_Huesped ON RegistroCI (k_numeroID ASC,k_tipo ASC)
;

CREATE INDEX IXFK_RegistroCI_Reserva ON RegistroCI (k_codigo ASC)
;

ALTER TABLE Reserva ADD CONSTRAINT PK_Reserva
	PRIMARY KEY (k_codigo)
;

ALTER TABLE Reserva ADD CONSTRAINT CK_Duracion CHECK (q_duracion > 0)
;

ALTER TABLE Reserva ADD CONSTRAINT CK_Estado CHECK ( i_estado = 'a' or i_estado = 'i'    )
;

ALTER TABLE Reserva ADD CONSTRAINT CK_CantPersonas CHECK (q_cantPersonas >= 1)
;

CREATE INDEX IXFK_Reserva_Cuenta ON Reserva (k_cuenta ASC)
;

CREATE INDEX IXFK_Reserva_Hotel ON Reserva (k_idHotel ASC)
;

CREATE INDEX IXFK_Reserva_Persona ON Reserva (k_numeroID ASC,k_tipo ASC)
;

ALTER TABLE ReservaHabitacion ADD CONSTRAINT PK_ReservaHabitacion
	PRIMARY KEY (k_numero,k_codigo)
;

CREATE INDEX IXFK_ReservaHabitacion_Habitacion ON ReservaHabitacion (k_numero ASC)
;

CREATE INDEX IXFK_ReservaHabitacion_Reserva ON ReservaHabitacion (k_codigo ASC)
;

ALTER TABLE Telefono ADD CONSTRAINT PK_Telefono
	PRIMARY KEY (k_numeroID,k_tipo,k_telefono)
;

ALTER TABLE Telefono ADD CONSTRAINT CK_Telefono CHECK (k_telefono > 0)
;

CREATE INDEX IXFK_Telefono_Persona ON Telefono (k_numeroID ASC,k_tipo ASC)
;

ALTER TABLE Tipo ADD CONSTRAINT PK_Tipo
	PRIMARY KEY (k_idTipo)
;

ALTER TABLE Tipo ADD CONSTRAINT CK_Precio CHECK (v_precio > 0)
;

/* Create Foreign Key Constraints */

ALTER TABLE CuentaConsumo ADD CONSTRAINT FK_CuentaConsumo_Consumo
	FOREIGN KEY (k_idConsumo) REFERENCES Consumo (k_idConsumo) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE CuentaConsumo ADD CONSTRAINT FK_CuentaConsumo_Cuenta
	FOREIGN KEY (k_cuenta) REFERENCES Cuenta (k_cuenta) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Habitacion ADD CONSTRAINT FK_Habitacion_Tipo
	FOREIGN KEY (k_idTipo) REFERENCES Tipo (k_idTipo) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Huesped ADD CONSTRAINT FK_Huesped_Persona
	FOREIGN KEY (k_numeroID,k_tipo) REFERENCES Persona (k_numeroID,k_tipo) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE RegistroCI ADD CONSTRAINT FK_RegistroCI_Huesped
	FOREIGN KEY (k_numeroID,k_tipo) REFERENCES Huesped (k_numeroID,k_tipo) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE RegistroCI ADD CONSTRAINT FK_RegistroCI_Reserva
	FOREIGN KEY (k_codigo) REFERENCES Reserva (k_codigo) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Reserva ADD CONSTRAINT FK_Reserva_Cuenta
	FOREIGN KEY (k_cuenta) REFERENCES Cuenta (k_cuenta) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Reserva ADD CONSTRAINT FK_Reserva_Hotel
	FOREIGN KEY (k_idHotel) REFERENCES Hotel (k_idHotel) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Reserva ADD CONSTRAINT FK_Reserva_Persona
	FOREIGN KEY (k_numeroID,k_tipo) REFERENCES Persona (k_numeroID,k_tipo) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE ReservaHabitacion ADD CONSTRAINT FK_ReservaHabitacion_Habitacion
	FOREIGN KEY (k_numero) REFERENCES Habitacion (k_numero) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE ReservaHabitacion ADD CONSTRAINT FK_ReservaHabitacion_Reserva
	FOREIGN KEY (k_codigo) REFERENCES Reserva (k_codigo) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Telefono ADD CONSTRAINT FK_Telefono_Persona
	FOREIGN KEY (k_numeroID,k_tipo) REFERENCES Persona (k_numeroID,k_tipo) ON DELETE No Action ON UPDATE No Action
;

/* Create Table Comments, Sequences for Autonumber Columns */

COMMENT ON TABLE Consumo
	IS 'Hace parte del inventario de productos y servicios que posee el hotel. '
;

COMMENT ON COLUMN Consumo.k_idConsumo
	IS 'Identificador del consumo, es a groso modo un apuntador de los diferentes productos y servicios'
;

COMMENT ON COLUMN Consumo.n_nombre
	IS 'Nombre del producto o servicio.'
;

COMMENT ON COLUMN Consumo.i_tipo
	IS 'Brinda informacion, de si lo anterior es o un producto (P) o un servicio (S).'
;

COMMENT ON COLUMN Consumo.i_unidad
	IS 'Aporta la unidad en la cual es mediada dicho consumo.

Dentro de los posibles valores se tiene: "U" unidades, "T" tiempo, medido en minutos. '
;

COMMENT ON COLUMN Consumo.q_stock
	IS 'Stock hace relacion a los productos y servicios que estan a disposicion.'
;

COMMENT ON COLUMN Consumo.v_valor
	IS 'Valor a pagar por cada producto y servicio'
;

COMMENT ON TABLE Cuenta
	IS 'Cuenta para el manejo de los consumos. Esta puede ser o no creada, pues depende de las acciones del huesped.'
;

COMMENT ON COLUMN Cuenta.k_cuenta
	IS 'Identificador de la cuenta.'
;

COMMENT ON COLUMN Cuenta.k_IdPago
	IS 'Identificador del pago relacionado a la cuenta'
;

COMMENT ON TABLE CuentaConsumo
	IS 'Tabla encargada de almacenar los datos correspondientes del cargo de consumos a una cuenta.'
;

COMMENT ON COLUMN CuentaConsumo.k_cuenta
	IS 'Identificador de la cuenta'
;

COMMENT ON COLUMN CuentaConsumo.k_idConsumo
	IS 'Identificador de lo consumido'
;

COMMENT ON COLUMN CuentaConsumo.f_consumo
	IS 'Fecha en la que se realizo la peticion del consumo'
;

COMMENT ON COLUMN CuentaConsumo.q_cantidadPedida
	IS 'Cantidad de lo pedido'
;

COMMENT ON TABLE Habitacion
	IS 'Tiene la informacion relacionada a habitacion'
;

COMMENT ON COLUMN Habitacion.k_numero
	IS 'Numero de la habitacion'
;

COMMENT ON COLUMN Habitacion.k_idTipo
	IS 'Tipo de habitacion '
;

COMMENT ON COLUMN Habitacion.i_estado
	IS 'Estado de la habitacion. Dentro de los posibles valores esta "h" habitada, "r" reservada y "d" disponible.'
;

COMMENT ON TABLE Hotel
	IS 'Contienen la informacion referente a cuestiones del Hotel'
;

COMMENT ON COLUMN Hotel.k_idHotel
	IS 'Identificador del hotel'
;

COMMENT ON COLUMN Hotel.t_descuento
	IS 'Descuento relacionado a una cantidad de dias'
;

COMMENT ON COLUMN Hotel.q_restriccionAforo
	IS 'Cantidad de huespedes maximo dentro dentro del hotel.'
;

COMMENT ON TABLE Huesped
	IS 'Encierra todos los datos correspondientes al huesped, y lo necesario para generar su estadia.

Es una especializacion solapada de Persona. '
;

COMMENT ON COLUMN Huesped.k_numeroID
	IS 'Comparte el identificador de numero de ID con la tabla "Persona" por ser una especializacion.

Numero identificador del huesped'
;

COMMENT ON COLUMN Huesped.k_tipo
	IS 'Tipo de documento que posee el huesped'
;

COMMENT ON COLUMN Huesped.f_nacimiento
	IS 'Fecha de nacimiento del huesped'
;

COMMENT ON COLUMN Huesped.n_direccion
	IS 'Direccion donde reside el huesped'
;

COMMENT ON TABLE Pago
	IS 'Almacenamiento de los datos relacionados a cada uno de los pagos'
;

COMMENT ON COLUMN Pago.k_IdPago
	IS 'Identificador del pago realizado'
;

COMMENT ON COLUMN Pago.f_pago
	IS 'Fecha cuando se realiza el pago'
;

COMMENT ON TABLE Persona
	IS 'Tabla correspondiente a los datos de la persona, engloba todos los datos del usuario que no corresponde a lo relacionado con el hotel. '
;

COMMENT ON COLUMN Persona.k_numeroID
	IS 'Corresponde al numero identificador de la persona, independientemente cual sea su tipo de documento.'
;

COMMENT ON COLUMN Persona.k_tipo
	IS 'Especificacion del tipo de documento que identifica a la persona, dentro de los posibles valores que puede tomar estan TI, CC, RC y CE, que corresponde respectivamente a tarjeta de identidad, cedula de ciudadania, registro civil y cedula de extranjeria.'
;

COMMENT ON COLUMN Persona.n_nombre1
	IS 'Primer nombre de la persona'
;

COMMENT ON COLUMN Persona.n_nombre2
	IS 'Segundo nombre de la persona (este puede ser vacio).'
;

COMMENT ON COLUMN Persona.n_apellido1
	IS 'Primer apellido de la persona'
;

COMMENT ON COLUMN Persona.n_apellido2
	IS 'Segundo apellido de la persona'
;

COMMENT ON TABLE RegistroCI
	IS 'Informacion relacionada al huesped y la reserva, manejando asi el Check in y Check Out de los huespedes asociados a una reserva.'
;

COMMENT ON COLUMN RegistroCI.k_registro
	IS 'Identificar del registro'
;

COMMENT ON COLUMN RegistroCI.k_codigo
	IS 'Identificador de la reserva'
;

COMMENT ON COLUMN RegistroCI.k_numeroID
	IS 'Numero identificador del huesped '
;

COMMENT ON COLUMN RegistroCI.k_tipo
	IS 'Tipo de documento que maneja el huesped'
;

COMMENT ON COLUMN RegistroCI.f_inicio
	IS 'Fecha de entrada del huesped en referente a la reserva'
;

COMMENT ON COLUMN RegistroCI.f_salida
	IS 'Fecha de salida del huesped'
;

COMMENT ON TABLE Reserva
	IS 'Almacena la informacion basica de la reserva.'
;

COMMENT ON COLUMN Reserva.k_codigo
	IS 'Codigo identificador de la reserva ante el sistema hotelero'
;

COMMENT ON COLUMN Reserva.k_numeroID
	IS 'Numero identificador de la persona encargada de realizar la reserva.'
;

COMMENT ON COLUMN Reserva.k_tipo
	IS 'Tipo de documento que maneja la persona encargada de realizar la reserva'
;

COMMENT ON COLUMN Reserva.k_cuenta
	IS 'Identificador de la cuenta asociada a dicha reserva, este puede ser nulo, pues puede que el huesped nunca pida un consumo.'
;

COMMENT ON COLUMN Reserva.f_inicio
	IS 'Fecha de inicio de la reserva'
;

COMMENT ON COLUMN Reserva.q_duracion
	IS 'Cantidad en dias de la duracion que tendra la estadia'
;

COMMENT ON COLUMN Reserva.i_estado
	IS 'Estado de la reserva, este varia en tres posibles valores, "a" para reservas activas e "i" para reservas inactivas.'
;

COMMENT ON COLUMN Reserva.q_cantPersonas
	IS 'Cantidad de personas que se ven involucradas en la reservacion.'
;

COMMENT ON TABLE ReservaHabitacion
	IS 'Relaciona las reservas y las habitaciones.'
;

COMMENT ON COLUMN ReservaHabitacion.k_numero
	IS 'Numero de la habitacion'
;

COMMENT ON COLUMN ReservaHabitacion.k_codigo
	IS 'Codigo de la reserva'
;

COMMENT ON TABLE Telefono
	IS 'Almacena los de los numeros telefonicos asociados a una persona'
;

COMMENT ON COLUMN Telefono.k_numeroID
	IS 'Numero de identificacion de la persona '
;

COMMENT ON COLUMN Telefono.k_tipo
	IS 'Tipo de documento que identifica a la persona'
;

COMMENT ON COLUMN Telefono.k_telefono
	IS 'Numero telefonico de una persona'
;

COMMENT ON TABLE Tipo
	IS 'Brinda informacion del tipo de habitacion'
;

COMMENT ON COLUMN Tipo.k_idTipo
	IS 'Identificador del tipo de habitacion'
;

COMMENT ON COLUMN Tipo.n_descripcion
	IS 'Informa de las caracteristicas de la habitacion'
;

COMMENT ON COLUMN Tipo.v_precio
	IS 'Valor por noche de la habitacion.'
;
