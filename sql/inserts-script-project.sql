SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
INSERT INTO Cargo (id, nome, id_setor)
VALUES 
(1, "Analista TI", 1),
(2, "Administrador Sistema", 1),
(3, "Gestor Comercial", 2),
(4, "Analista Comercial", 2),
(5, "Gestor de Operação", 3),
(6, "Analista de Operação", 3);

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
INSERT INTO setor (id, nome, gerente_id)
VALUES 
(1, "TI", 1),
(2, "Comercial", 2),
(3, "Operação", 3);

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
INSERT INTO Urgencia (escala, dias)
VALUES 
(1, 5),
(2, 4),
(3, 3),
(4, 2),
(5, 1);

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
INSERT INTO usuario (nome, email, senha, cargo, telefone)
VALUES 
('João Silva', 'joao.silva@example.com', 'senha123', 4, '(11) 98765-4321'),
('Maria Santos', 'maria.santos@example.com', 'senha456', 3, '(21) 99876-5432'),
('Pedro Rocha', 'pedro.rocha@example.com', 'senha789', 6, '(31) 98765-4321'),
('Ana Souza', 'ana.souza@example.com', 'senhaqwe', 6, '(41) 99876-5432'),
('José Pereira', 'jose.pereira@example.com', 'senharst', 2, '(85) 98765-4321'),
('Luciana Oliveira', 'luciana.oliveira@example.com', 'senha345', 1, '(11) 98765-4321'),
('Marcos Ferreira', 'marcos.ferreira@example.com', 'senha777', 1, '(21) 99876-5432'),
('Luana Xavier', 'luana.xavier@example.com', 'senha666', 4, '(31) 98765-4321'),
('Paulo Costa', 'paulo.costa@example.com', 'senha789', 6, '(41) 99876-5432'),
('Fernanda Alves', 'fernanda.alves@example.com', 'senhaqwe', 5, '(85) 98765-4321'),
('Juliana Lima', 'juliana.lima@example.com', 'senha123', 1, '(11) 98765-4321'),
('Rafaela Santos', 'rafaela.santos@example.com', 'senha456', 2, '(21) 99876-5432'),
('Gustavo Silva', 'gustavo.silva@example.com', 'senha789', 3, '(31) 98765-4321'),
('Sandra Martins', 'sandra.martins@example.com', 'senhaqwe', 4, '(41) 99876-5432'),
('Roberto Oliveira', 'roberto.oliveira@example.com', 'senharst', 5, '(85) 98765-4321'),
('Mariana Ferreira', 'mariana.ferreira@example.com', 'senha345', 6, '(11) 98765-4321'),
('Carolina Xavier', 'carolina.xavier@example.com', 'senha777', 1, '(21) 99876-5432'),
('Renato Costa', 'renato.costa@example.com', 'senha666', 2, '(31) 98765-4321'),
('Camila Alves', 'camila.alves@example.com', 'senha789', 3, '(41) 99876-5432'),
('Guilherme Souza', 'guilherme.souza@example.com', 'senhaqwe', 4, '(85) 98765-4321');

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
INSERT INTO chamados (id, status, tipo, titulo, descricao, id_setor, id_usuario, id_responsavel, data_abertura, data_fechamento, urgencia, prazo)
VALUES 
(1, "Aberto", "Tipo - Exemplo 1.1", "Título 1", "Descrição exemplo 1", 1, 8, 1, "2023-04-24", NULL, 1, "2023-04-29"),
(2, "Fechado", "Tipo - Exemplo 1.2", "Título 2", "Descrição exemplo 2", 1, 9, 2, "2023-04-20", "2023-04-22", 2, "2023-04-24"),
(3, "Vencido", "Tipo - Exemplo 2.1", "Título 3", "Descrição exemplo 3", 2, 10, 6, "2023-04-21", NULL, 3, "2023-04-24"),
(4, "Fechado", "Tipo - Exemplo 2.2", "Título 4", "Descrição exemplo 4", 3, 12, 7, "2023-04-23", "2023-04-24", 4, "2023-04-25"),
(5, "Aberto", "Tipo - Exemplo 3.1", "Título 5", "Descrição exemplo 5", 3, 13, 8, "2023-04-26", NULL, 5, "2023-04-27"),
(6, "Aberto", "Tipo - Exemplo 3.2", "Título 6", "Descrição exemplo 6", 3, 14, 9, "2023-05-01", NULL, 1, "2023-05-06"),
(7, "Fechado", "Tipo - Exemplo 1.3", "Título 7", "Descrição exemplo 7", 1, 1, 7, "2023-05-10", "2023-05-13", 1, "2023-05-15"),
(8, "Fechado", "Tipo - Exemplo 1.4", "Título 8", "Descrição exemplo 8", 1, 2, 8, "2023-05-12", "2023-05-14", 2, "2023-05-16"),
(9, "Em atendimento", "Tipo - Exemplo 2.3", "Título 9", "Descrição exemplo 3", 2, 10, 9, "2023-05-15", NULL, 3, "2023-05-18"),
(10, "Em atendimento", "Tipo - Exemplo 2.4", "Título 10", "Descrição exemplo 10", 3, 4, 10, "2023-05-18", NULL, 4, "2023-05-20"),
(11, "Aberto", "Tipo - Exemplo 3.3", "Título 11", "Descrição exemplo 11", 3, 5, 11, "2023-05-20", NULL, 5, "2023-05-21"),
(12, "Vencido", "Tipo - Exemplo 3.4", "Título 12", "Descrição exemplo 12", 3, 6, 12, "2023-05-25", NULL, 1, "2023-05-30");