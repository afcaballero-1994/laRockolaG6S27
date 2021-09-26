create database Rockola;
use Rockola;
create table autor(
	id_autor int auto_increment,
	nombre_autor varchar(50),
    constraint autor_pk primary key(id_autor)
);

create table genero(
	id_genero int auto_increment,
    nombre_genero varchar(50) not null,
    constraint genero_pk primary key (id_genero)
);

create table album(
	id_album int auto_increment,
    nombre_album varchar(50) not null,
    anio_lanzamiento int not null,
    constraint album_pk primary key (id_album)
);

create table canciones(
	id_cancion int auto_increment,
    nombre_cancion varchar(50) not null,
    duracion_cancion int not null,
    id_genero int,
    id_album int,
    constraint canciones_pk primary key(id_cancion),
    constraint canciones_id_genero_fk foreign key (id_genero) references genero (id_genero),
    constraint canciones_id_album_fk foreign key (id_album) references album (id_album)
);

create table canciones_autor(
	id_cancion int,
    id_autor int,
    constraint canciones_autor_pk primary key (id_cancion, id_autor),
    constraint cancion_autor_id_cancion_fk foreign key (id_cancion) references canciones (id_cancion),
    constraint cancion_autor_id_autor_fk foreign key (id_autor) references autor (id_autor)
);
create table usuarios(
	id_usuario int auto_increment,
    nombre_usuario varchar(50) not null,
    password varchar (50) not null,
    esAdministrador tinyint not null,
    constraint usuarios_pk primary key (id_usuario)
);

create table playlist (
	id_playlist int auto_increment,
    nombre_playlist varchar(50) not null,
    id_cancion int,
    id_usuario int,
    constraint playlist_pk primary key (id_playlist),
    constraint playlist_id_canciones_fk foreign key (id_cancion) references canciones(id_cancion),
    constraint playlist_id_usuario_fk foreign key (id_usuario) references usuarios(id_usuario)
);

create table cancion_playlist(
	id_cancion int,
    id_playlist int,
    constraint cancion_playlist_pk primary key (id_cancion, id_playlist),
    constraint cancion_playlist_id_cancion_fk foreign key (id_cancion) references canciones (id_cancion),
    constraint cancion_playlist_id_playlist_fk foreign key (id_playlist) references playlist (id_playlist)
);

create table usuarios_playlist(
	id_usuario int,
    id_playlist int,
    constraint usuarios_playlist_pk primary key (id_usuario, id_playlist),
    constraint usuarios_playlist_id_usuario_fk foreign key (id_usuario) references usuarios (id_usuario),
    constraint usuarios_playlist_id_playlist_fk foreign key (id_playlist) references playlist (id_playlist)
);

create table sugerencias(
	id_sugerencia int auto_increment,
    nombre_cancion varchar(50),
    nombre_album varchar(50),
    nombre_genero varchar(50),
    nombre_autor varchar(50),
    id_usuario int,
    constraint sugerencias_pk primary key (id_sugerencia),
    constraint sugerencias_usuarios_fk foreign key (id_usuario) references usuarios (id_usuario)
);
