SELECT nombres, edad, identificacion, activo
FROM Estudiantes e
WHERE e.activo IS NULL AND edad >= 18 AND Identificacion LIKE "1%"