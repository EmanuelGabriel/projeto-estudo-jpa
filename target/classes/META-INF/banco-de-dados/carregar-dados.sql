insert into Cliente (id, nome) values (1, 'Pedro Alves Cabral');
insert into Cliente (id, nome) values (2, 'Bruno Nunes Martins');
insert into Cliente (id, nome) values (3, 'Eli Soares Bezerra');

insert into Dominio (id, nome) values (1, 'Banco de Dados MySQL');
insert into Dominio (id, nome) values (2, 'LDAP');

insert into Usuario (id, nome, login, senha, dominio_id, ultimoAcesso) values (1, 'Francisco Alves da Bezerra', 'francisco', '12345', 1, sysdate());
insert into Usuario (id, nome, login, senha, dominio_id, ultimoAcesso) values (2, 'Carla do Nascimento', 'carla', '78978', 2, sysdate());
insert into Usuario (id, nome, login, senha, dominio_id, ultimoAcesso) values (3, 'Isabel da Fonseca', 'isafonseca', '454545', 2, sysdate());






