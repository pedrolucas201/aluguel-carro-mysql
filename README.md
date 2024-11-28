
---

```markdown
# RentCarApplication

**RentCarApplication** é uma aplicação Java para gerenciamento de veículos, clientes e aluguéis. Desenvolvida utilizando JavaFX para a interface gráfica, MySQL como banco de dados e Maven para gerenciamento de dependências.

---

## 📋 Funcionalidades

- Cadastro e listagem de veículos.
- Integração com banco de dados MySQL.
- Interface gráfica dinâmica utilizando JavaFX.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17 (Amazon Corretto)**
- **JavaFX 21**
- **MySQL**
- **Maven**

---

## 📂 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   ├── com/
│   │   │   ├── rentcar/
│   │   │   │   ├── app/                 # Classe principal para iniciar a aplicação
│   │   │   │   ├── config/              # Configuração do banco de dados
│   │   │   │   ├── controller/          # Controladores para interface e lógica
│   │   │   │   ├── model/               # Classes de modelo (entidades)
│   │   │   │   ├── repository/          # Acesso ao banco de dados
│   │   │   │   ├── service/             # Camada de serviços e lógica de negócio
│   ├── resources/
│   │   ├── database/                    # Arquivo SQL para inicialização do banco
│   │   │   └── RentCar.sql
│   │   ├── com/rentcar/view/            # Arquivos FXML para interface gráfica
│   │   │   └── VeiculoView.fxml
```

---

## ⚙️ Pré-Requisitos

1. **Java 17** (Recomenda-se Amazon Corretto ou OpenJDK)
2. **MySQL**
3. **Maven**
4. **JavaFX SDK** (Configuração do `--module-path` obrigatória)

---

## 🚀 Configuração do Ambiente

### 1. Configuração do Banco de Dados

1. Instale e configure o MySQL.
2. Crie o banco de dados:
   ```sql
   CREATE DATABASE RentCar;
   ```
3. Crie o usuário do banco e conceda permissões:
   ```sql
   CREATE USER 'rentcar_user'@'localhost' IDENTIFIED BY 'Pedro201!';
   GRANT ALL PRIVILEGES ON RentCar.* TO 'rentcar_user'@'localhost';
   FLUSH PRIVILEGES;
   ```
4. Importe o arquivo `RentCar.sql`:
   ```bash
   mysql -u rentcar_user -p RentCar < src/main/resources/database/RentCar.sql
   ```

---

### 2. Configuração do Projeto

#### Clonar o Repositório

```bash
git clone <URL_DO_REPOSITORIO>
cd RentCarApplication
```

#### Compilar o Projeto com Maven

```bash
mvn clean compile
```

#### Executar o Projeto com Maven

```bash
mvn exec:java -Dexec.mainClass=com.rentcar.app.Main
```

---

### 3. Configuração do JavaFX

Baixe o **JavaFX SDK** em [gluonhq.com](https://gluonhq.com/products/javafx/) e configure o `--module-path`. Para executar o `.jar`, use o comando:

```bash
java --module-path C:\javafx-sdk-21.0.5\lib --add-modules javafx.controls,javafx.fxml -jar target/RentCarApplication-1.0-SNAPSHOT.jar
```

---

## 📋 Estrutura do Banco de Dados

O banco contém as seguintes tabelas:

- **Cliente**
- **Veículo**
- **Categoria_Veiculo**
- **Aluguel**
- **Funcionário**
- **Manutenção**

As relações entre tabelas seguem as melhores práticas de integridade referencial.

---

## 📖 Exemplo de Uso

1. **Cadastro de Veículos**
    - Preencha os campos no formulário de veículos e clique em "Salvar".
    - O veículo será salvo no banco de dados e listado na tabela.

2. **Listagem de Veículos**
    - Todos os veículos cadastrados no banco são exibidos na tabela.

---

## 🐞 Debugging

### Logs de Erro
Os logs da aplicação são exibidos no console. Utilize `System.out.println` para adicionar mensagens personalizadas para depuração.

### Testar Conexão com o Banco
Use o método `DatabaseConnection.testConnection()` para verificar a conexão com o banco de dados.

---

## 📜 Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.

---

## ✉️ Contato

- **Desenvolvedor**: Pedro Gomes
- **E-mail**: pedrolkas15@gmail.com
- **LinkedIn**: http://www.linkedin.com/in/pedro-gomes-3a7184300

---
