CREATE TABLE pessoa (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nome TEXT NOT NULL,
  idade INTEGER,
  email TEXT,
  telefone TEXT,
  endereco TEXT
);

INSERT INTO pessoa (nome, idade, email, telefone, endereco) VALUES ('João', 25, 'joao@gmail.com', '(66) 98765-4321', 'Rua A, 123');
INSERT INTO pessoa (nome, idade, email, telefone, endereco) VALUES ('Maria', 30, 'maria@gmail', '(66) 12345-6789', 'Rua B, 456');
