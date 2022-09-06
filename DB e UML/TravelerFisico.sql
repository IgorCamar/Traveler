


CREATE TABLE Servico (
codServico VARCHAR(10) PRIMARY KEY,
valorServico DECIMAL(15),
tipoServico VARCHAR(20),
descricao VARCHAR(200)
);

CREATE TABLE Cliente (
cpf INTEGER PRIMARY KEY,
telefone INTEGER,
loginSenha VARCHAR(25),
email VARCHAR(25),
nome VARCHAR(10)
);

CREATE TABLE Pedido (
numPedido INTEGER PRIMARY KEY,
dataPedido DATETIME,
infoPedido VARCHAR(10),
cpf INTEGER,
codServico VARCHAR(10),
FOREIGN KEY(cpf) REFERENCES Cliente (cpf),
FOREIGN KEY(codServico) REFERENCES Servico (codServico)
)

