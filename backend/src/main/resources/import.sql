INSERT INTO condomino(cpf, rg, unidade) VALUES ('11111111111', '1111111', '11');
INSERT INTO condomino(cpf, rg, unidade) VALUES ('22222222222', '2222222', '22');
INSERT INTO condomino(cpf, rg, unidade) VALUES ('33333333333', '3333333', '33');
INSERT INTO condomino(cpf, rg, unidade) VALUES ('44444444444', '4444444', '44');

INSERT INTO familia(cpf, rg, grau_Parentesco, condomino_id) VALUES ('1111122222', '1111222', 'esposa', '2');
INSERT INTO familia(cpf, rg, grau_Parentesco, condomino_id) VALUES ('3333322222', '3333222', 'filha', '1');

INSERT INTO sindico(cpf, rg) VALUES ('9999999999', '9999999');

INSERT INTO visitante(cpf, rg, condomino_id) VALUES ('12123344555', '1234567', '1');
INSERT INTO visitante(cpf, rg, condomino_id) VALUES ('22334455667', '2233113', '3');
INSERT INTO visitante(cpf, rg, condomino_id) VALUES ('77777777777', '7777777', '3');
INSERT INTO visitante(cpf, rg, condomino_id) VALUES ('25252525252', '2525252', '2');

INSERT INTO prestador_de_servico(nome, endereco, telefone, tipo_Servico, tipo_Juridica_Ou_Fisica, cfp_Ou_Cnpj, condomino_id) VALUES ('Carlos', 'Rua 10', '81987654321', 'encanador', 'pessoa fisica', '34567123456', '1');
INSERT INTO prestador_de_servico(nome, endereco, telefone, tipo_Servico, tipo_Juridica_Ou_Fisica, cfp_Ou_Cnpj, condomino_id) VALUES ('Ronaldo', 'Rua 20', '81991738765', 'eletricista', 'pessoa juridica', '345671230001-39', '4');