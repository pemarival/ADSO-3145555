# Seguimiento Técnico del Proyecto

## 1. Información general

**Proyecto:** Gestión y versionado de base de datos
**Tecnologías principales:**

* PostgreSQL
* Liquibase
* Docker
* Git

**Objetivo del proyecto**

Diseñar e implementar una arquitectura para la gestión del esquema de base de datos utilizando migraciones versionadas, contenedores para el entorno de desarrollo y documentación de decisiones arquitectónicas.

---

# 2. Estado de historias de usuario

| HU     | Descripción                                   | Estado      | Fecha  | Observaciones                                                |
| ------ | --------------------------------------------- | ----------- | -----  | ------------------------------------------------------------ |
| HU-001 | Identificar y documentar dominios funcionales | Hecho       |15-04-26|Aprendí el orden de un análisis de domininios                 |
| HU-002 | Organizar estructura base del repositorio     | Hecho       |15-04-26|No organicé inmediatamente la estructura                      |
| HU-003 | Contenerizar PostgreSQL                       | Hecho       |20-04-26|No usé una carpeta de docker para poner la imagen de liquibase|
| HU-004 | Contenerizar o integrar Liquibase             | Hecho       |20-04-26|Usé liquibase de manera externa y no dentro del contenedor    |
| HU-005 | Separar DDL en changelogs por dominio         | Hecho       |20-04-26|Se me olvidó agregar la carpeta rollback                      |
| HU-006 | Estrategia de roles y permisos                | Hecho       |20-04-26|Ubiqué mal los permisos pero los corregí                      |
| HU-007 | Plan de datos de prueba                       | Hecho       |20-04-26|Las inserciones funcionaron perfectamente                     |
| HU-008 | Documentación y seguimiento técnico           | Hecho       |20-04-26|Creación de documento                                         |

---

# 3. Registro de avances

## Fecha: 2026-04-20

### Actividades realizadas

* Descripción de tareas realizadas
* Manejo de versiones
* Configuración de entorno
* Inserción de datos
* Documentación 

### Resultados

* Resultado obtenido
* Problemas encontrados
* Soluciones aplicadas

---

# 4. Estructura inicial del proyecto

```
modelo-postgresql-estructura/

├── docs
│   
```

---

# 5. Decisiones técnicas iniciales

## Base de datos

Se selecciona PostgreSQL como sistema gestor de base de datos por su estabilidad, soporte de estándares SQL y facilidad de integración con herramientas de migración.

## Gestión de migraciones

Se utiliza Liquibase para:

* versionar el esquema de la base de datos
* gestionar cambios mediante changelogs
* garantizar reproducibilidad del esquema

## Contenedorización

Se utiliza Docker para levantar PostgreSQL en entorno local y evitar dependencias de instalación en el sistema operativo.

---

# 6. Riesgos técnicos identificados

| Riesgo                    | Descripción                              | Mitigación                    |
| ------------------------- | ---------------------------------------- | ----------------------------- |
| Conflictos en migraciones | Cambios simultáneos en el esquema        | Uso de changelogs versionados |
| Problemas de conexión     | Configuración incorrecta del driver JDBC | Verificación del classpath    |
| Dependencias entre tablas | Orden incorrecto de creación             | Separación por dominios       |

---

# 7. Próximas actividades

1. Esperar a que el instructor me asigne una nota.

---

# 8. Historial de cambios del documento

| Fecha      | Autor     | Descripción            |
| ---------- | -----     | ---------------------- |
| 2026-04-20 | pemarival | Finalización total     |

```
```
