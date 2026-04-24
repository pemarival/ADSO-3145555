# Descripción del dominio 
El sistema pertenece al dominio de gestión de operaciones de aerolíneas y servicios asociados al transporte aéreo. Su propósito es administrar la información relacionada con aerolíneas, aeropuertos, aeronaves, vuelos, reservas de pasajeros, emisión de tiquetes, procesos de check-in, embarque, manejo de equipaje, pagos y facturación.

Además, el sistema integra funcionalidades de gestión de clientes y programas de fidelización, permitiendo registrar usuarios, acumular millas, administrar niveles de membresía y otorgar beneficios a los pasajeros frecuentes.

El dominio también incluye soporte para operaciones operativas del aeropuerto y del vuelo, como la gestión de puertas de embarque, retrasos, mantenimiento de aeronaves y asignación de asientos.

# Alcance y límites del dominio 
### Alcance
El sistema cubre los siguientes procesos principales:
- Gestión de aerolíneas, aeronaves y aeropuertos.
- Gestión de vuelos y segmentos de vuelo.
- Registro de personas, clientes y usuarios del sistema.
- Gestión de reservas y venta de tiquetes.
- Procesos de check-in y embarque de pasajeros.
- Administración de equipaje.
- Procesamiento de pagos y reembolsos.
- Facturación e impuestos asociados a ventas.
- Administración de programas de fidelización y acumulación de millas.
- Gestión de seguridad del sistema (usuarios, roles y permisos).

### Límites del dominio
El sistema no cubre:
- Control de tráfico aéreo.
- Gestión meteorológica.
- Planificación de rutas aéreas a nivel aeronáutico.
- Operación física de aeronaves.
- Sistemas externos de pago o bancos (solo se registra la transacción).
- Sistemas de seguridad aeroportuaria o migración.

Estos sistemas pueden integrarse externamente pero no forman parte del dominio central.

# Dominios funcionales identificados
Del modelo de datos se pueden identificar los siguientes subdominios funcionales:
- Datos geográficos: ubicación y direcciones
- Aerolínea: información de aerolineas
- Identidad: información de personas
- Seguridad: usuarios y control de acceso
- Clientes y fidelización: clientes y millas
- Aeropuertos: infraestructura aeroportuaria
- Aeronaves: flota y mantenimiento
- Operación de vuelo: gestión de vuelos
- Ventas, reservas y boletas: comercialización de pasajes
- Abordaje: proceso de embarque
- Pagos: procesamiento financiero
- Facturación: facturas e impuestos

# Entidades principales del dominio
Las entidades más importantes del sistema son:
Airline – Aerolínea que opera los vuelos.
Airport – Aeropuerto donde se realizan operaciones.
Aircraft – Aeronave utilizada en vuelos.
Flight – Vuelo programado por una aerolínea.
Flight Segment – Tramo de vuelo entre dos aeropuertos.
Person – Individuo registrado en el sistema.
Customer – Persona registrada como cliente de la aerolínea.
Reservation – Reserva de viaje realizada por un cliente.
Ticket – Documento que confirma el derecho a viajar.
Seat Assignment – Asignación de asiento en un vuelo.
Check-in – Proceso de registro previo al embarque.
Boarding Pass – Documento que permite abordar el avión.
Payment – Pago realizado por una venta.
Invoice – Documento fiscal asociado a la venta.

# Relaciones entre entidades
Relaciones geográficas:
- Un continente tiene muchos países.
- Un país tiene muchos estados o provincias.
- Un estado tiene muchas ciudades.
- Una ciudad tiene muchos distritos.
- Un distrito tiene muchas direcciones.

Relaciones operativas:
- Una aerolínea opera muchos vuelos.
- Un vuelo puede tener varios segmentos de vuelo.
- Un segmento conecta dos aeropuertos.

Relaciones comerciales:
- Un cliente puede realizar muchas reservas.
- Una reserva puede tener varios pasajeros.
- Una reserva genera una venta.
- Una venta produce uno o varios tickets.

Relaciones de viaje:
- Un ticket puede tener varios segmentos de vuelo.
- Cada ticket_segment puede tener una asignación de asiento.

Relaciones de embarque:
- Un ticket_segment genera un check-in.
- Un check-in produce un boarding pass.

Relaciones financieras:
- Una venta tiene uno o varios pagos.
- Un pago puede tener transacciones o reembolsos.

# Proceso del dominio
El funcionamiento general del sistema sigue el siguiente flujo:
1. Se registra una persona y se convierte en cliente.
2. El cliente selecciona un itinerario y crea una reserva.
3. Se registra una venta asociada a la reserva.
4. El cliente realiza el pago mediante un método de pago.
5. Se emite un ticket para cada pasajero.
6. Se asigna asiento para cada segmento del vuelo.
7. El pasajero realiza el check-in antes del vuelo.
8. Se genera el pase de abordar.
9. Se valida el boarding pass en la puerta de embarque.
10. El vuelo se realiza y el pasajero completa el viaje.

# Reglas de negocio 
Algunas reglas importantes derivadas del modelo:

- Un vuelo no puede tener el mismo aeropuerto de origen y destino.
- Un ticket_segment solo puede existir una vez por vuelo y ticket.
- Un asiento no puede asignarse a dos pasajeros en el mismo vuelo.
- Un cliente solo puede tener una cuenta de fidelización por programa.
- Un número de ticket debe ser único.
- Un equipaje debe tener peso mayor a cero.
- Un reembolso no puede ser mayor que el pago original.
- Un asiento solo puede asignarse a un pasajero por segmento de vuelo.
- Una reserva tiene un código único.

# Datos clave del dominio 
Datos críticos:
- Número de vuelo
- Código de reserva
- Número de ticket
- Número de asiento
- Código de aeropuerto
- Código de aerolínea
- Número de cuenta de fidelización
- Número de factura
- Referencia de pago

# Glosario de términos 
Aerolinea (Airline)
Empresa que opera vuelos comerciales.

Aeropuerto (Airport)
Infraestructura donde aterrizan y despegan aeronaves.

Reserva (Reservation)
Solicitud de viaje realizada por un cliente antes de pagar.

Ticket
Documento que confirma el derecho a viajar.

Segmento de vuelo (Flight Segment)
Tramo entre dos aeropuertos dentro de un vuelo.

Check-in
Proceso mediante el cual un pasajero confirma su presencia en el vuelo.

Boarding Pass
Documento que permite abordar el avión.

Cabina (Cabin Class)
Clase del asiento dentro del avión (económica, ejecutiva, etc).

Programa de fidelización
Sistema que otorga beneficios o millas a pasajeros frecuentes.

Millas
Puntos acumulados por vuelos realizados.

# Conclusiones 
El dominio modelado representa un sistema integral de gestión de aerolíneas, cubriendo tanto procesos operativos, comerciales y financieros.

El modelo presenta características importantes de diseño:

- Alta normalización (3FN) para evitar redundancia.
- Separación clara de subdominios funcionales.
- Uso consistente de identificadores UUID.
- Control de integridad referencial mediante claves foráneas.
- Implementación de reglas de negocio mediante constraints.

Esta estructura permite que el sistema sea escalable, mantenible y extensible, facilitando futuras integraciones con sistemas externos como motores de reserva, sistemas de pago o plataformas de gestión aeroportuaria.
