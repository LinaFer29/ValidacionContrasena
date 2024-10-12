# ValidacionContrasena
Taller 7: Procedimientos y funciones

## Función Validación Contraseña
Dado que el tipo BOOLEAN solo es válido dentro de PL/SQL (procedimientos, funciones, triggers) y no se puede utilizar en una llamada SQL pura (como SELECT o INSERT), el tipo de retorno sera numerico.
```
create or replace NONEDITIONABLE FUNCTION validar_contrasena (
    una_contrasena IN VARCHAR2
) RETURN NUMBER
IS
    longitud VARCHAR2(20) := '^.{13,20}$';
    minuscula VARCHAR2(20) := '[a-z]';
    mayuscula VARCHAR2(20) := '[A-Z]';
    digito VARCHAR2(20) := '\d';
    caracter_especial VARCHAR2(20) := '[^a-zA-Z\d]';
BEGIN
    IF NOT REGEXP_LIKE (una_contrasena, longitud) OR 
       NOT REGEXP_LIKE (una_contrasena, minuscula) OR 
       NOT REGEXP_LIKE (una_contrasena, mayuscula) OR 
       NOT REGEXP_LIKE (una_contrasena, digito) OR 
       NOT REGEXP_LIKE (una_contrasena, caracter_especial) THEN
        RETURN 0; -- Contraseña no válida
    ELSE
        RETURN 1; -- Contraseña válida
    END IF;
END;

```

## Procedimiento Inserción

Este procedimiento se encarga de llamar a la función 'validar_contrasena' para determinar si el usuario se puede insertar en la tabla o no. Adicionalmente, como se requiere un retorno para gestionar un mensaje de exitó, se utilizo un parametro de salida.

```
create or replace NONEDITIONABLE PROCEDURE insertar_usuario_si_valido (
    un_usuario IN VARCHAR2,
    una_contrasena IN VARCHAR2,
    resultado OUT NUMBER
)
IS
BEGIN
    IF validar_contrasena(una_contrasena) = 1 THEN
        
        INSERT INTO Taller_Cuatro (Usuario, Contrasena)
        VALUES (un_usuario, una_contrasena);
        resultado := 1; -- Inserción exitosa
    ELSE
        resultado := 0; -- Contraseña no válida
    END IF;
END;
```

## Procedimiento Mostrar Información de la Tabla 'Taller_Cuatro'

Para devolver la Información de la base de datos, se uso un ref cursor, de esta forma se permitira que el procedimiento sea llamado desde java y se puedan acceder en el proyecto de Sprint Boot.

```
create or replace NONEDITIONABLE PROCEDURE mostrar_taller_cuatro (
    cur_out OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN cur_out FOR
        SELECT id_taller_cuatro, usuario, contrasena
        FROM Taller_Cuatro
        ORDER BY id_taller_cuatro;
END;
```
