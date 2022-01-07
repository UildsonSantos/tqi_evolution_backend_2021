INSERT INTO tb_users (first_name, last_name, email, cpf, rg, endereco, numero, bairro, cidade, estado, renda, password) VALUES ('Bob', 'Brown', 'bob@gmail.com', '408.033.980-18', '17.626.156-4', 'Rua Taquari', '961', 'Jardim Paulista', 'Campo Mourão', 'PR', 9544.27, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_users (first_name, last_name, email, cpf, rg, endereco, numero, bairro, cidade, estado, renda, password) VALUES ('Ana', 'Green', 'ana@gmail.com', '968.059.300-22', '12.505.762-3', 'Travessa Cedro', '406', 'Jardim Santa Nilce I', 'Londrina', 'PR', 11716.82, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_roles(authority) VALUES ('ROLE_CLIENT');
INSERT INTO tb_roles(authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_emprestimos (valor, data_primeira_parcela, qtd_parcelas, user_id ) VALUES ( 1239.99, '2022-02-20T10:00:00Z', 23, 1);
INSERT INTO tb_emprestimos (valor, data_primeira_parcela, qtd_parcelas, user_id ) VALUES ( 1239.99, '2022-02-20T10:00:00Z', 23, 1);
INSERT INTO tb_emprestimos (valor, data_primeira_parcela, qtd_parcelas, user_id ) VALUES ( 1239.99, '2022-02-20T10:00:00Z', 23, 1);
INSERT INTO tb_emprestimos (valor, data_primeira_parcela, qtd_parcelas, user_id ) VALUES ( 1239.99, '2022-02-20T10:00:00Z', 23, 1);
INSERT INTO tb_emprestimos (valor, data_primeira_parcela, qtd_parcelas, user_id ) VALUES ( 1239.99, '2022-02-20T10:00:00Z', 23, 1);
INSERT INTO tb_emprestimos (valor, data_primeira_parcela, qtd_parcelas, user_id ) VALUES ( 1239.99, '2022-02-20T10:00:00Z', 23, 2);
INSERT INTO tb_emprestimos (valor, data_primeira_parcela, qtd_parcelas, user_id ) VALUES ( 1239.99, '2022-02-20T10:00:00Z', 23, 2);
INSERT INTO tb_emprestimos (valor, data_primeira_parcela, qtd_parcelas, user_id ) VALUES ( 1239.99, '2022-02-20T10:00:00Z', 23, 2);
INSERT INTO tb_emprestimos (valor, data_primeira_parcela, qtd_parcelas, user_id ) VALUES ( 1239.99, '2022-02-20T10:00:00Z', 23, 2);
INSERT INTO tb_emprestimos (valor, data_primeira_parcela, qtd_parcelas, user_id ) VALUES ( 1239.99, '2022-02-20T10:00:00Z', 23, 2);