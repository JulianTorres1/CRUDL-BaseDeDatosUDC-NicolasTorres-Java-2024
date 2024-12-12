# CRUDL-BaseDeDatosUDC-NicolasTorres-Java-2024

## Descripción
Este proyecto es una aplicación basada en Java que realiza operaciones CRUDL (Crear, Leer, Actualizar, Eliminar, Listar) en una base de datos PostgreSQL. Está diseñado para gestionar registros de vehículos en una base de datos llamada **Concesionarios**.

## Características
- **Listar Registros**: Recuperar y mostrar todos los registros de una tabla especificada.
- **Insertar Registro**: Agregar un nuevo registro a una tabla especificada.
- **Actualizar Registro**: Modificar un registro existente en una tabla especificada.
- **Eliminar Registro**: Eliminar un registro de una tabla especificada.
- **Filtrar Registros por Precio**: Mostrar registros ordenados por precio en orden ascendente o descendente.

## Tecnologías Utilizadas
- Java
- Maven
- PostgreSQL

## Requisitos Previos
- Java 23 o superior
- Maven
- PostgreSQL

## Configuración
1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/JulianTorres1/CRUDL-BaseDeDatosUDC-NicolasTorres-Java-2024.git
   cd CRUDL-BaseDeDatosUDC-NicolasTorres-Java-2024
   ```

2. **Configurar la base de datos:**
    - Asegúrese de que PostgreSQL esté instalado y en funcionamiento.
    - Cree una base de datos llamada **Concesionarios**.
    - Actualice los detalles de conexión a la base de datos en `src/main/java/org/example/DB/DBManager.java` si es necesario.

### Configuración de la Base de Datos
Asegúrate de tener PostgreSQL instalado y en funcionamiento.

Crea una base de datos en PostgreSQL:

```sql
CREATE DATABASE Concesionarios;
```

Ejecuta el script SQL para crear las tablas necesarias:

```sql
CREATE TABLE Vehiculos (
    num_bastidor VARCHAR(50) NOT NULL,
    nombre_modelo VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    descuento DECIMAL(10, 2) NOT NULL,
    potencia_fiscal INT NOT NULL,
    cilindrada INT NOT NULL,
    en_stock BOOLEAN NOT NULL,
    id_concesionario INT NOT NULL,
    id_servicio INT NOT NULL,
    fecha_agregado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (num_bastidor)
);
```

Configura la conexión a la base de datos en tu proyecto:

```java
public class DBManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/Concesionarios";
    private static final String USER = "root";
    private static final String PASSWORD = "Delfin23";
```

## Estructura del Proyecto
- `pom.xml`: Archivo de configuración de Maven.
- `src/main/java/org/example/DB/DBManager.java`: Contiene métodos para operaciones en la base de datos.
- `src/main/java/org/example/Main.java`: Clase principal para ejecutar la aplicación.

## Licencia
Este proyecto está licenciado bajo la Licencia MIT. Consulte el archivo `LICENSE` para más detalles.

## Autor
**Nicolas Torres**

