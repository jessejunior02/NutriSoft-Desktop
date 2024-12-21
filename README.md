# **NutriSoft**

### **Descrição**
**NutriCalc** é uma aplicação Java desktop projetada para calcular e fornecer insights relacionados ao gasto calórico diário, Índice de Massa Corporal (IMC) e recomendações personalizadas para melhorar a saúde e o bem-estar dos usuários.

---

## **Funcionalidades**
- Cálculo do gasto calórico basal e total com base em sexo, peso, altura, idade e nível de atividade física.
- Cálculo do IMC com mensagens sobre a condição atual do usuário.
- Recomendações personalizadas com base no IMC e no gasto calórico total, apenas informar o consumo (Kcal).
- Interface gráfica amigável e intuitiva, construída com Swing.

---

## **Tecnologias Utilizadas**
- **Java SE 11** ou superior
- **Swing**: Para construção da interface gráfica.
- **Eclipse** (opcional): Ambiente de desenvolvimento.

---

## **Pré-requisitos**
Para rodar o projeto localmente, é necessário ter instalado:
- Java JDK 11 ou superior.
- IDE (recomendado: Eclipse) ou um editor de texto com suporte a Java.
- Git (para clonar o repositório).

---

## **Como Rodar o Projeto**

### **1. Clonar o Repositório**
```bash
git clone https://github.com/seu-usuario/NutriSoft-Desktop.git
cd NutriSoft-Desktop
```

### **2. Compilar o Projeto**
Abra o projeto na sua IDE preferida ou compile manualmente usando o terminal:
```bash
javac -d bin src/**/*.java
```

### **3. Executar a Aplicação**
Navegue até a pasta `bin` e execute a aplicação:
```bash
java -cp bin src.Main
```

---

## **Estrutura do Projeto**
Abaixo está a estrutura básica do projeto:

```
NutriSoft-Desktop/
├── src/                      # Arquivo principal da aplicação
|    Main.java
│   ├── views/                # Classes responsáveis pela interface gráfica
|   |   ├── MainFrame.java
│   │   ├── GastoCaloricoFrame.java
|   |   ├── IMCFrame.java
│   │   └── RecomendacoesFrame.java
│   ├── models/               # Classes de lógica e regras de negócio
│   │   ├── RecomendacoesModel.java
|   |   ├── GastoCaloricoModel.java
|   |   └── IMCModel.java
│   └── controllers/          # Classes para cálculos e manipulação de dados
│       └── MainController.java
└── README.md                 # Documentação do projeto
```

---

## **Funcionalidades em Detalhes**

### **1. Cálculo do Gasto Calórico**
O cálculo utiliza fórmulas que consideram o peso, altura, idade, sexo e o nível de atividade física. O resultado é dividido em **gasto basal** e **gasto total**.

### **2. Cálculo do IMC**
Com base na altura e no peso, o sistema calcula o Índice de Massa Corporal e classifica o usuário em categorias como:
- Abaixo do peso
- Peso normal
- Sobrepeso
- Obesidade

### **3. Recomendações**
O sistema oferece sugestões de ações baseadas nos resultados do IMC e do gasto calórico total, com o objetivo de ajudar o usuário a melhorar sua saúde.

---

## **Contribuição**
Contribuições são bem-vindas! Para colaborar:
1. Faça um fork do repositório.
2. Crie uma nova branch (`git checkout -b feature/nome-da-feature`).
3. Submeta um pull request após realizar as alterações.

---

## **Autor**
Desenvolvido por **Jesse Paiva C. Junior**.

- GitHub: [https://github.com/jessejunior02](https://github.com/jessejunior02)
- E-mail: [jessepcarvalhojunior02@gmail.com](mailto:jessepcarvalhojunior02@gmail.com)
