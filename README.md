# DataSystem

## Descripción
DataSystem es un sistema de gestión empresarial diseñado para la reparación y mantenimiento de equipos de cómputo e impresión. El sistema permite administrar y almacenar toda la información relevante en una base de datos local, facilitando el seguimiento de las reparaciones, el control de inventarios, y la gestión de clientes y órdenes de trabajo.

## Estructura del Proyecto
- **DataBase/**: Contiene el archivo SQL para la base de datos.
- **src/**: Contiene el código fuente del proyecto.

## Requisitos Previos
Antes de configurar el proyecto, asegúrate de tener instalado:
- XAMPP (o cualquier otro servidor local que soporte MySQL)
- MySQL o MariaDB para manejar la base de datos
- Git (opcional, para clonar este repositorio)

## Configuración de la Base de Datos
Sigue estos pasos para configurar la base de datos:

1. **Inicia XAMPP** (o tu servidor local preferido) y asegúrate de que los servicios de Apache y MySQL estén funcionando.

2. **Crea la Base de Datos** en tu servidor local:
   - Abre phpMyAdmin o usa la línea de comandos de MySQL.
   - Crea una base de datos vacía con el nombre `bd_ds`.

3. **Importa el Archivo SQL**:
   - Navega a la carpeta `DataBase/` dentro de este proyecto.
   - Importa el archivo `bd_ds.sql` a la base de datos que acabas de crear.
     - **Usando phpMyAdmin**:
       1. Selecciona la base de datos.
       2. Ve a la pestaña "Importar".
       3. Selecciona el archivo `bd.ds.sql` y haz clic en "Continuar".

## Ejecución del sistema
- Navega a la carpeta `dist`
- Ejecuta el archivo jar `DataSystem.jar`