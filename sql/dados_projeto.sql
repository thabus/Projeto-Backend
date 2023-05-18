SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

INSERT INTO departamento (nome, localizacao, gerente_id)
VALUES 
("TI", "101", 1),
("Comercial", "102", 2),
("Operação", "103", 3);

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
INSERT INTO funcionario
VALUES 
(1, "Pedro", "Silva", "pedro@gmail.com", "992222222", "12345678910", 4),
(2, "Caio", "Augusto", "caio@gmail.com", "911332222", "12345678811", 5),
(3, "Talita", "Santos", "talita@gmail.com", "955555555", "12345678777", 6),
(4, "Ana", "Valência", "ana@gmail.com", "99111111", "66545678910", 4),
(5, "Felipe", "Siqueira", "felipe@gmail.com", "993333333", "12345678444", 5),
(6, "Joana", "Paula", "joana@gmail.com", "999111111", "12345678221", 6),
(7, "José", "Cristo", "jose@gmail.com", "98224444", "12345678446", 4);


SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
INSERT INTO cliente
VALUES 
(11, "Marina", "Silva", "marinas@gmail.com", "992222224", "12345678918", "55666777000133"),
(21, "Lucas", "Souza", "souza@gmail.com", "911332227", "12345678817", "01234567000189"),
(31, "Sofia", "Castro", "sofiac@gmail.com", "955555558", "12345678779", "98765432000121"),
(41, "Felipe", "Mendes", "felipem@gmail.com", "99111116", "66545678916", "12345678000176"),
(51, "Ana Paula ", "Lima", "analima@gmail.com", "993333333", "12345678443", "87654321000143"),
(61, "Gustavo", "Almeida", "gustavoal@gmail.com", "999111112", "1234567821", "11223344000190"),
(71, "Isabela", "Santos", "isabelasa@gmail.com", "98224441", "12345678445", "99888777000122");

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
INSERT INTO usuario
VALUES 
(8,"souza@gmail.com", "5jD#kP7@", null, 21),
(9,"ana@gmail.com", "f9Lz$2Qx", 4, null),
(10,"sofiac@gmail.com", "g7hT@1pM", null, 31),
(11, "felipem@gmail.com", "3tE*bD5p", null, 41),
(12,"caio@gmail.com", "$p4zL#k9", 2, null),
(13,"pedro@gmail.com", "q6S!xR7w", 1, null),
(14,"isabelasa@gmail.com", "2mK@8cN1", null, 71),
(15,"talita@gmail.com", "#tD9kL6*", 3, null),
(16,"joana@gmail.com", "xF7$zT2@", 6, null),
(17,"gustavoal@gmail.com", "@jP5kQ8%", null, 61);

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
INSERT INTO chamados
VALUES 
(1, "Aberto", 4, "Falha no sistema de login da rede interna", "dificuldades para acessar a rede interna da empresa", 8, 1, "2023-04-24", "2023-04-28", "Normal", "2023-04-28"),
(2, "Fechado", 4, "Problema de conexão com servidor de e-mail", "dificuldades para enviar e-mails a partir de suas contas corporativas", 9, 2, "2023-04-20", "2023-04-22", "Normal", "2023-04-23"),
(3, "Vencido", 5, "Problema com envio de pedidos", "pedidos não estão sendo enviados corretamente", 10, 6, "2023-04-20", "2023-04-23", "Normal", "2023-04-22"),
(4, "Fechado", 5, "Produto com defeito", "produtos que eles receberam apresentam defeitos", 12, 7, "2023-04-20", "2023-04-22", "Normal", "2023-04-23"),
(5, "Aberto", 6, "Problema na linha de produção", "problema na linha de produção da fábrica", 13, 8, "2023-04-23", "2023-04-29", "Normal", "2023-04-29"),
(6, "Aberto", 6, "Falha no processo de embalagem", "recebendo produtos com problemas na embalagem", 14, 9, "2023-04-24", "2023-04-28", "Normal", "2023-04-29");


