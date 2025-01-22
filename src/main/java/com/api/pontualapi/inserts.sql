-- Serviços de hoje
INSERT INTO venda (id, tipo, descricao, data, valor_total, forma_pagamento, qtd_parcelas, preco_parcela, observacoes)
VALUES
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Troca de bateria', CURRENT_TIMESTAMP, 50.00, 'Dinheiro', NULL, NULL, 'Serviço rápido realizado no balcão'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Ajuste de pulseira', CURRENT_TIMESTAMP, 30.00, 'Pix', NULL, NULL, 'Cliente satisfeita com o ajuste'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Manutenção completa de relógio automático', CURRENT_TIMESTAMP, 250.00, 'Débito', NULL, NULL, 'Manutenção preventiva realizada'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Troca de vidro de relógio', CURRENT_TIMESTAMP, 120.00, 'Crédito', 2, 60.00, 'Parcelado em 2x sem juros'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Lubrificação de relógio', CURRENT_TIMESTAMP, 80.00, 'Pix', NULL, NULL, 'Cliente regular com desconto fidelidade'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Polimento de caixa', CURRENT_TIMESTAMP, 70.00, 'Débito', NULL, NULL, 'Serviço realizado no mesmo dia'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Conserto de relógio digital', CURRENT_TIMESTAMP, 220.00, 'Pix', NULL, NULL, 'Peças originais usadas no reparo'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Substituição de coroa', CURRENT_TIMESTAMP, 150.00, 'Débito', NULL, NULL, 'Serviço técnico realizado com sucesso'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Troca de pulseira', CURRENT_TIMESTAMP, 100.00, 'Dinheiro', NULL, NULL, 'Pulseira de couro original instalada'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Revisão de relógio mecânico', CURRENT_TIMESTAMP, 300.00, 'Crédito', 3, 100.00, 'Parcelado em 3x no cartão');

-- Serviços de ontem
INSERT INTO venda (id, tipo, descricao, data, valor_total, forma_pagamento, qtd_parcelas, preco_parcela, observacoes)
VALUES
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Troca de bateria', CURRENT_DATE - INTERVAL '1 DAY', 50.00, 'Dinheiro', NULL, NULL, 'Serviço rápido realizado no balcão'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Reparo de ponteiros', CURRENT_DATE - INTERVAL '1 DAY', 110.00, 'Pix', NULL, NULL, 'Serviço técnico especializado'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Instalação de vidro antirreflexo', CURRENT_DATE - INTERVAL '1 DAY', 200.00, 'Crédito', 2, 100.00, 'Parcelado em 2x no cartão'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Manutenção de cronômetro', CURRENT_DATE - INTERVAL '1 DAY', 180.00, 'Pix', NULL, NULL, 'Cliente regular com desconto'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Ajuste de calendário', CURRENT_DATE - INTERVAL '1 DAY', 90.00, 'Dinheiro', NULL, NULL, 'Cliente elogiou a agilidade no serviço'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Lubrificação de relógio', CURRENT_DATE - INTERVAL '1 DAY', 80.00, 'Débito', NULL, NULL, 'Serviço finalizado com sucesso'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Troca de pulseira', CURRENT_DATE - INTERVAL '1 DAY', 100.00, 'Pix', NULL, NULL, 'Troca rápida realizada no balcão'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Polimento de caixa', CURRENT_DATE - INTERVAL '1 DAY', 70.00, 'Débito', NULL, NULL, 'Serviço realizado no mesmo dia'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Conserto de relógio analógico', CURRENT_DATE - INTERVAL '1 DAY', 200.00, 'Crédito', 4, 50.00, 'Parcelado em 4x no cartão'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Revisão de relógio digital', CURRENT_DATE - INTERVAL '1 DAY', 250.00, 'Crédito', 5, 50.00, 'Parcelado em 5x no crédito');

-- Serviços de anteontem
INSERT INTO venda (id, tipo, descricao, data, valor_total, forma_pagamento, qtd_parcelas, preco_parcela, observacoes)
VALUES
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Troca de bateria', CURRENT_DATE - INTERVAL '2 DAY', 50.00, 'Dinheiro', NULL, NULL, 'Serviço rápido realizado no balcão'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Lubrificação de relógio', CURRENT_DATE - INTERVAL '2 DAY', 80.00, 'Pix', NULL, NULL, 'Cliente regular com desconto fidelidade'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Conserto de relógio digital', CURRENT_DATE - INTERVAL '2 DAY', 220.00, 'Débito', NULL, NULL, 'Peças originais usadas no reparo'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Substituição de coroa', CURRENT_DATE - INTERVAL '2 DAY', 150.00, 'Débito', NULL, NULL, 'Serviço técnico realizado com sucesso'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Troca de pulseira', CURRENT_DATE - INTERVAL '2 DAY', 100.00, 'Dinheiro', NULL, NULL, 'Pulseira de couro original instalada'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Revisão de relógio mecânico', CURRENT_DATE - INTERVAL '2 DAY', 300.00, 'Crédito', 3, 100.00, 'Parcelado em 3x no crédito'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Ajuste de pulseira', CURRENT_DATE - INTERVAL '2 DAY', 30.00, 'Pix', NULL, NULL, 'Cliente satisfeito com o ajuste'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Troca de vidro de relógio', CURRENT_DATE - INTERVAL '2 DAY', 120.00, 'Crédito', 2, 60.00, 'Parcelado em 2x sem juros'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Manutenção completa de relógio automático', CURRENT_DATE - INTERVAL '2 DAY', 250.00, 'Débito', NULL, NULL, 'Manutenção preventiva realizada'),
(uuid_generate_v4()::TEXT, 'SERVIÇO', 'Polimento de caixa', CURRENT_DATE - INTERVAL '2 DAY', 70.00, 'Débito', NULL, NULL, 'Serviço realizado no mesmo dia');

-- Vendas de hoje
INSERT INTO venda (id, tipo, descricao, data, valor_total, forma_pagamento, qtd_parcelas, preco_parcela, observacoes)
VALUES
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Esportivo Digital', CURRENT_TIMESTAMP, 300.00, 'Dinheiro', NULL, NULL, 'Venda promocional à vista'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Analógico de Luxo', CURRENT_TIMESTAMP, 1500.00, 'Crédito', 5, 300.00, 'Parcelado em 5x sem juros'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Pulseira de Couro Original', CURRENT_TIMESTAMP, 150.00, 'Pix', NULL, NULL, 'Pulseira de alta qualidade'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Smartwatch', CURRENT_TIMESTAMP, 800.00, 'Débito', NULL, NULL, 'Última unidade em estoque'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio de Parede Clássico', CURRENT_TIMESTAMP, 500.00, 'Crédito', 2, 250.00, 'Cliente regular com desconto'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Caixa de Presente para Relógio', CURRENT_TIMESTAMP, 50.00, 'Dinheiro', NULL, NULL, 'Inclui embalagem premium'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Kit de Limpeza para Relógio', CURRENT_TIMESTAMP, 80.00, 'Pix', NULL, NULL, 'Produto novo no catálogo'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Automático Esportivo', CURRENT_TIMESTAMP, 1200.00, 'Crédito', 4, 300.00, 'Parcelado em 4x no cartão'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Digital Infantil', CURRENT_TIMESTAMP, 200.00, 'Débito', NULL, NULL, 'Venda rápida no balcão'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Solar Ecológico', CURRENT_TIMESTAMP, 750.00, 'Pix', NULL, NULL, 'Cliente elogiou o design sustentável');

-- Vendas de ontem
INSERT INTO venda (id, tipo, descricao, data, valor_total, forma_pagamento, qtd_parcelas, preco_parcela, observacoes)
VALUES
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Vintage de Bolso', CURRENT_DATE - INTERVAL '1 DAY', 1200.00, 'Crédito', 6, 200.00, 'Parcelado em 6x sem juros'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Casual Feminino', CURRENT_DATE - INTERVAL '1 DAY', 400.00, 'Débito', NULL, NULL, 'Cliente comprou após ver na vitrine'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Militar Resistente à Água', CURRENT_DATE - INTERVAL '1 DAY', 600.00, 'Pix', NULL, NULL, 'Venda realizada com desconto'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio de Luxo Masculino', CURRENT_DATE - INTERVAL '1 DAY', 2500.00, 'Crédito', 10, 250.00, 'Parcelado em 10x no crédito'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Pulseira Metálica para Relógio', CURRENT_DATE - INTERVAL '1 DAY', 200.00, 'Dinheiro', NULL, NULL, 'Venda realizada no balcão'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio de Mesa Moderno', CURRENT_DATE - INTERVAL '1 DAY', 700.00, 'Débito', NULL, NULL, 'Produto popular em promoção'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Solar Digital', CURRENT_DATE - INTERVAL '1 DAY', 850.00, 'Crédito', 3, 283.33, 'Parcelado em 3x no crédito'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Infantil Colorido', CURRENT_DATE - INTERVAL '1 DAY', 100.00, 'Dinheiro', NULL, NULL, 'Cliente comprou para presente'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Automático de Luxo', CURRENT_DATE - INTERVAL '1 DAY', 3200.00, 'Pix', NULL, NULL, 'Venda realizada com desconto especial'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio com Display Touchscreen', CURRENT_DATE - INTERVAL '1 DAY', 1100.00, 'Débito', NULL, NULL, 'Cliente satisfeito com o produto');

-- Vendas de anteontem
INSERT INTO venda (id, tipo, descricao, data, valor_total, forma_pagamento, qtd_parcelas, preco_parcela, observacoes)
VALUES
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Digital Esportivo', CURRENT_DATE - INTERVAL '2 DAY', 350.00, 'Dinheiro', NULL, NULL, 'Venda realizada rapidamente'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Clássico Feminino', CURRENT_DATE - INTERVAL '2 DAY', 700.00, 'Pix', NULL, NULL, 'Produto popular em promoção'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Analógico Elegante', CURRENT_DATE - INTERVAL '2 DAY', 950.00, 'Crédito', 4, 237.50, 'Parcelado em 4x no crédito'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Digital Resistente', CURRENT_DATE - INTERVAL '2 DAY', 450.00, 'Débito', NULL, NULL, 'Cliente elogiou a durabilidade'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Pulseira de Silicone para Relógio', CURRENT_DATE - INTERVAL '2 DAY', 100.00, 'Dinheiro', NULL, NULL, 'Venda complementar'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Solar Minimalista', CURRENT_DATE - INTERVAL '2 DAY', 800.00, 'Pix', NULL, NULL, 'Produto sustentável vendido com desconto'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio com Alarme Digital', CURRENT_DATE - INTERVAL '2 DAY', 300.00, 'Débito', NULL, NULL, 'Venda realizada no balcão'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio de Parede Clássico', CURRENT_DATE - INTERVAL '2 DAY', 500.00, 'Crédito', 2, 250.00, 'Parcelado em 2x sem juros'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Casual Masculino', CURRENT_DATE - INTERVAL '2 DAY', 400.00, 'Dinheiro', NULL, NULL, 'Cliente comprou para uso diário'),
(uuid_generate_v4()::TEXT, 'VENDA', 'Relógio Digital com Monitor Cardíaco', CURRENT_DATE - INTERVAL '2 DAY', 1200.00, 'Pix', NULL, NULL, 'Produto com alta demanda vendido com desconto');
