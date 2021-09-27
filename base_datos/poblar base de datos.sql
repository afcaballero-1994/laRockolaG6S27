set @nombre_autor = 'Jhon';
set @nombre_genero = 'Rock';
set @nombre_album = '100 mas buscados';
set @nombre_cancion = 'Mellancoly';

insert into autor (nombre_autor) values (@nombre_autor);
insert into genero (nombre_genero) values (@nombre_genero);
insert into album (nombre_album, anio_lanzamiento) values (@nombre_album, 2010);
insert into canciones (nombre_cancion, duracion_cancion, id_genero, id_album) values ('Yarakuza', 250, 
(select id_genero from genero where nombre_genero = @nombre_genero),
(select id_album from album where nombre_album = @nombre_album) );
insert into canciones (nombre_cancion, duracion_cancion, id_genero, id_album) values (@nombre_cancion, '12:50', 
(select id_genero from genero where nombre_genero = @nombre_genero),
(select id_album from album where nombre_album = @nombre_album) );

insert into canciones_autor (id_cancion, id_autor)
select id_cancion, id_autor from canciones, autor
where nombre_cancion = @nombre_cancion and nombre_autor = @nombre_autor;

insert into album (nombre_album, anio_lanzamiento) values ('Evolve', 2017);

delete from canciones where id_cancion = 2
