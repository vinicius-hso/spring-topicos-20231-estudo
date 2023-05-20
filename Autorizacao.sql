use anotacao;

drop table if exists aut_autorizacao;
drop table if exists uau_usuario_autorizacao;

create table aut_autorizacao (
  aut_id bigint unsigned not null auto_increment,
  aut_nome varchar(20) not null,
  primary key (aut_id),
  unique key uni_aut_nome (aut_nome)
);

create table uau_usuario_autorizacao (
  usr_id bigint unsigned not null,
  aut_id bigint unsigned not null,
  primary key (usr_id, aut_id),
  foreign key aut_usuario_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade,
  foreign key aut_autorizacao_fk (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);

insert into aut_autorizacao (aut_nome)
    values ('ROLE_ADMIN');
insert into aut_autorizacao (aut_nome)
    values ('ROLE_USER');

insert into uau_usuario_autorizacao (usr_id, aut_id) 
    values (1, 1);
insert into uau_usuario_autorizacao (usr_id, aut_id) 
    values (2, 2);
insert into uau_usuario_autorizacao (usr_id, aut_id) 
    values (3, 2);