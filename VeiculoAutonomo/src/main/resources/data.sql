INSERT INTO tb_pessoa(nome_pessoa, telefone_pessoa, email_pessoa, senha_pessoa) VALUES('Antonio', '912345678', 'antonio@email.com', 'admin');
INSERT INTO tb_pessoa(nome_pessoa, telefone_pessoa, email_pessoa, senha_pessoa) VALUES('Bruna', '987654321', 'bruna@email.com', 'admin');

INSERT INTO tb_frota(marca_veiculo, modelo_veiculo, cor_veiculo, placa_veiculo, ano_veiculo) VALUES('Fiat', 'Argo', 'vermelho', 'ABC1234', '2018');
INSERT INTO tb_frota(marca_veiculo, modelo_veiculo, cor_veiculo, placa_veiculo, ano_veiculo) VALUES('Hyundai', 'HB20', 'branca', 'DEF5678', '2019');

INSERT INTO tb_pagamento(desc_pagamento) VALUES('Cartao');
INSERT INTO tb_pagamento(desc_pagamento) VALUES('Dinheiro');
INSERT INTO tb_pagamento(desc_pagamento) VALUES('PayPal');

INSERT INTO tb_viagem(fk_id_pessoa, fk_id_veiculo, fk_id_pagamento, origem_viagem, destino_viagem)  VALUES(1, 2, 1, 'Rua Teste origem', 'Rua Teste destino');
INSERT INTO tb_viagem(fk_id_pessoa, fk_id_veiculo, fk_id_pagamento, origem_viagem, destino_viagem)  VALUES(2, 1, 3, 'Rua Teste origem', 'Rua Teste destino');

INSERT INTO tb_porta(status_porta) VALUES('fechar');

INSERT INTO tb_viagemstatus(status_viagem) VALUES('finalizar');

