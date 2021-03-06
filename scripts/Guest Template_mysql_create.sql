CREATE TABLE `Cliente` (
	`id_cliente` INT NOT NULL AUTO_INCREMENT,
	`nome_cliente` varchar(50) NOT NULL,
	`endereco_cliente` TEXT(100) NOT NULL,
	`email_cliente` varchar(50) NOT NULL,
	`cpf_cliente` INT(11) NOT NULL UNIQUE,
	PRIMARY KEY (`id_cliente`)
);

CREATE TABLE `Categoria` (
	`id_categoria` INT NOT NULL AUTO_INCREMENT,
	`nome_categoria` varchar(15) NOT NULL UNIQUE,
	`descricao_categoria` varchar(500) NOT NULL,
	PRIMARY KEY (`id_categoria`)
);

CREATE TABLE `Marca` (
	`id_marca` INT NOT NULL AUTO_INCREMENT,
	`nome_marca` varchar(50) NOT NULL UNIQUE,
	`descricao_marca` varchar(500) NOT NULL,
	PRIMARY KEY (`id_marca`)
);

CREATE TABLE `Produto` (
	`id_produto` INT NOT NULL AUTO_INCREMENT,
	`id_categoria` INT NOT NULL,
	`id_marca` INT NOT NULL,
	`nome_produto` varchar(50) NOT NULL,
	`descricao_produto` varchar(500) NOT NULL,
	`preco_produto` DECIMAL(6,2) NOT NULL,
	PRIMARY KEY (`id_produto`)
);

CREATE TABLE `ItemVenda` (
	`id_produto` INT NOT NULL,
	`id_venda` INT NOT NULL,
	`qtd` INT NOT NULL
);

CREATE TABLE `Venda` (
	`id_venda` INT NOT NULL AUTO_INCREMENT,
	`data_venda` DATE NOT NULL,
	`total_venda` DECIMAL(6,2) NOT NULL,
	`id_cliente` INT NOT NULL,
	`qtd_venda` INT NOT NULL,
	PRIMARY KEY (`id_venda`)
);

ALTER TABLE `Produto` ADD CONSTRAINT `Produto_fk0` FOREIGN KEY (`id_categoria`) REFERENCES `Categoria`(`id_categoria`);

ALTER TABLE `Produto` ADD CONSTRAINT `Produto_fk1` FOREIGN KEY (`id_marca`) REFERENCES `Marca`(`id_marca`);

ALTER TABLE `ItemVenda` ADD CONSTRAINT `ItemVenda_fk0` FOREIGN KEY (`id_produto`) REFERENCES `Produto`(`id_produto`);

ALTER TABLE `ItemVenda` ADD CONSTRAINT `ItemVenda_fk1` FOREIGN KEY (`id_venda`) REFERENCES `Venda`(`id_venda`);

ALTER TABLE `Venda` ADD CONSTRAINT `Venda_fk0` FOREIGN KEY (`id_cliente`) REFERENCES `Cliente`(`id_cliente`);

