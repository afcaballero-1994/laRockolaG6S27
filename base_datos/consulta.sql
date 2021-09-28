select c.nombre_cancion, c.duracion_cancion, a.nombre_album, a.anio_lanzamiento, g.nombre_genero, au.nombre_autor
from album a
inner join canciones c on a.id_album = c.id_album
inner join canciones_autor ca on ca.id_cancion = c.id_cancion
inner join autor au on au.id_autor = ca.id_autor
inner join genero g on g.id_genero =  c.id_genero
where nombre_cancion = 'Familia' and estaEliminada = 0;

select au.nombre_autor
from canciones c 
inner join canciones_autor ca on c.id_cancion = ca.id_cancion
inner join autor au on ca.id_autor = au.id_autor
where nombre_cancion = 'Familia' and estaEliminada = 0;

select c.nombre_cancion, c.duracion_cancion, a.nombre_album, a.anio_lanzamiento, g.nombre_genero
from album a
inner join canciones c on a.id_album = c.id_album
inner join genero g on g.id_genero =  c.id_genero
where estaEliminada = 0;