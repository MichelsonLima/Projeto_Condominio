INSERT INTO condomino(id, nome, endereco, telefone, cpf, rg, unidade) VALUES ('1', 'João', 'rua 1', '081818181', '11111111111', '1111111', '11');
INSERT INTO condomino(id, nome, endereco, telefone, cpf, rg, unidade) VALUES ('2', 'Maria', 'rua 2', '082828282', '22222222222', '2222222', '22');
INSERT INTO condomino(id, nome, endereco, telefone, cpf, rg, unidade) VALUES ('3', 'Pedro', 'rua 3', '083838383', '33333333333', '3333333', '33');
INSERT INTO condomino(id, nome, endereco, telefone, cpf, rg, unidade) VALUES ('4', 'Caio', 'rua 4', '084848484', '44444444444', '4444444', '44');

INSERT INTO familia(id, nome, endereco, telefone, cpf, rg, grau_Parentesco, condomino_id) VALUES ('7', 'Almir', 'rua 23', '32546576', '1111122222', '1111222', 'esposa', '2');
INSERT INTO familia(id, nome, endereco, telefone, cpf, rg, grau_Parentesco, condomino_id) VALUES ('8', 'Carlos', 'rua 45', '981772323', '3333322222', '3333222', 'filha', '1');

INSERT INTO sindico(id, nome, endereco, telefone, cpf, rg) VALUES ('9', 'Bernadete', 'rua 90', '35457843', '9999999999', '9999999');

INSERT INTO visitante(id, nome, endereco, telefone, cpf, rg, condomino_id) VALUES ('10', 'Sabrina', 'rua 10', '081989898989', '12123344555', '1234567', '1');
INSERT INTO visitante(id, nome, endereco, telefone, cpf, rg, condomino_id) VALUES ('20', 'Camila', 'rua 11', '081989561111', '22334455667', '2233113', '3');
INSERT INTO visitante(id, nome, endereco, telefone, cpf, rg, condomino_id) VALUES ('30', 'Joana', 'rua 12', '081977777777', '77777777777', '7777777', '3');
INSERT INTO visitante(id, nome, endereco, telefone, cpf, rg, condomino_id) VALUES ('40', 'Carla', 'rua 13', '081999891212', '25252525252', '2525252', '2');

--INSERT INTO prestador_de_servico(nome, endereco, telefone, tipo_Servico, tipo_Juridica_Ou_Fisica, cfp_Ou_Cnpj, condomino_id) VALUES ('Carlos', 'Rua 10', '81987654321', 'encanador', 'pessoa fisica', '34567123456', '1');
--INSERT INTO prestador_de_servico(nome, endereco, telefone, tipo_Servico, tipo_Juridica_Ou_Fisica, cfp_Ou_Cnpj, condomino_id) VALUES ( 'Ronaldo', 'Rua 20', '81991738765', 'eletricista', 'pessoa juridica', '345671230001-39', '4');