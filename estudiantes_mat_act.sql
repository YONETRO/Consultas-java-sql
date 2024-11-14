SELECT e.nombres, e.apellidos, m.idMateria , m.nombre 
FROM Estudiantes e
JOIN Materias m ON e.idEstudiante = m.idMateria 
WHERE e.activo = '1' AND m.activo = 's';
