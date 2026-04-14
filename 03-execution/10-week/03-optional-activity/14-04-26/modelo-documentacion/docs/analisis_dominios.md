# Contexto del sistema 
El modelo de datos representa un sistema completo para la gestión de aerolíneas, su dominio principal es el digilenciamiento de operaciones aéreas y comercialización de vuelos. 
El sistema administra lao siguientes procesos:
- Reservas
- Emisión de boletos
- Control de pasajeros
- Operación de vuelos
- Gestión de equipajes
- Programación de millas
- Facturación y pagos

# Dominios funcionales identificados 
La base de datos está segmentada por los siguientes sub-dominios:
- Datos geográficos: ubicación y direcciones
- Aerolínea: información de aerolineas
- Identidad: información de personas
- Seguridad: Usuarios y control de acceso
- Clientes y fidelización: clientes y millas
- Aeropuertos: infraestructura aeroportuaria
- Aeronaves: flota y mantenimiento
- Operación de vuelo: gestión de vuelos
- Ventas y reservas: Comercialización de pasajes
- Check-in y abordaje: proceso de embarque
- Pagos: procesamiento financiero
- Facturación: facturas e impuestos

# Dominios específicos con sus respectivas entidades
### Dominio geográfico 
Entidades principales:
- continent
- country
- state_province
- city
- district
- address
- time_zone
- currency

### Dominio de identidad
Entidades principales:
- person
- person_type
- document_type
- person_document
- contact_type
- person_contact

### Dominio de seguridad
Entidades principales:
- user_account
- user_status
- security_role
- security_permission
- user_role
- role_permission

### Dominio de clientes y fidelización 
Entidades principales:
- customer
- loyalty_program
- loyalty_account
- loyalty_tier
- miles_transaction
- customer_benefit

### Dominio de aeropuertos
Entidades principales:
- airport
- terminal
- boarding_gate
- runway
- airport_regulation

### Dominio de aeronaves 
Entidades principales:
- aircraft_manufacturer
- aircraft_model
- aircraft
- aircraft_cabin
- aircraft_seat
- maintenance_event

### Dominio de operaciones de vuelo
Entidades principales:
- flight
- flight_segment
- flight_status
- flight_delay

### Dominio de ventas y reservas
Entidades principales:
- reservation
- reservation_passenger
- sale
- ticket
- ticket_segment
- fare

### Dominio de check-in y abordaje
Entidades principales:
- check_in
- boarding_pass
- boarding_validation
- boarding_group
- seat_assignment
- baggage

### Dominio de pagos
Entidades principales:
- payment
- payment_transaction
- payment_method
- refund

### Dominio de facturación 
Entidades principales:
- invoice
- invoice_line
- tax
- exchange_rate

# Entidades raíz del negocio
Entidades principales:
- reservation
- flight
- aircraft
- customer
- loyalty_account
- invoice
- payment
