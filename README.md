# Programação Desktop

# Padrões GRASP

# Polymorphism (Polimorfismo)

## Definição

● Definição: Quando alternativas ou comportamentos relacionados variam por tipo (classe), atribua responsabilidades pelo comportamento — usando operações polimórficas — aos tipos para os quais o comportamento varia. O usuário do tipo deve usar operações polimórficas em vez de ramificações explícitas baseadas no tipo (if/else, switch, instanceof).

● Problema: Como tratar alternativas baseadas no tipo? Como criar componentes de software plugáveis? Quando uma lógica usa if/else ou switch para testar tipos, qualquer novo tipo exige modificar o código existente, gerando alto acoplamento e baixa coesão.

## Forma Incorreta

```java
// VIOLAÇÃO DO POLYMORPHISM: A classe Pedido conhece detalhes concretos de cada 
// forma de pagamento. Se amanhã adicionarmos "Pix", teremos que modificar este código.
// Isso cria alto acoplamento e dificulta a manutenção.
public class Pedido {
    private String tipoPagamento; // "cartao", "boleto"

    public Pedido(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public void processarPagamento() {
        if (tipoPagamento.equals("cartao")) {
            System.out.println("Processando pagamento no cartão de crédito...");
        } else if (tipoPagamento.equals("boleto")) {
            System.out.println("Gerando boleto bancário...");
        }
        // E se surgir um novo tipo? Teremos que voltar aqui e alterar!
    }
}
```

**Problemas:**
- A classe Pedido conhece detalhes de implementação de cada tipo de pagamento
- Difícil de estender: adicionar um novo método exige modificar Pedido
- Alto acoplamento: Pedido depende de tipos concretos
- Violação do Princípio Aberto/Fechado: código precisa ser modificado para novos tipos
- Baixa coesão: responsabilidades de diferentes tipos misturadas em uma classe

## Forma Correta

```java
// Abstração que define o contrato para todas as formas de pagamento
public interface MetodoPagamento {
    void processar();
}

// Cada tipo concreto implementa seu próprio comportamento
public class PagamentoCartao implements MetodoPagamento {
    @Override
    public void processar() {
        System.out.println("Processando pagamento no cartão de crédito...");
    }
}

public class PagamentoBoleto implements MetodoPagamento {
    @Override
    public void processar() {
        System.out.println("Gerando boleto bancário...");
    }
}

public class PagamentoPix implements MetodoPagamento {
    @Override
    public void processar() {
        System.out.println("Gerando QR Code para pagamento via Pix...");
    }
}

// Módulo de alto nível depende da abstração, não de detalhes concretos
public class Pedido {
    private MetodoPagamento metodoPagamento; // Dependência da abstração!

    public Pedido(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento; // Injeção de dependência
    }

    public void finalizar() {
        metodoPagamento.processar(); // Chamada polimórfica!
    }
}
```

**Benefícios:**
- Cada tipo de pagamento em uma classe separada com responsabilidade única
- Pedido depende apenas da abstração (interface MetodoPagamento)
- Novos tipos de pagamento podem ser adicionados SEM MODIFICAR Pedido
- Código sem if/else ou switch verificando tipo
- Respeita o Princípio Aberto/Fechado (Open/Closed)
- Alta coesão e baixo acoplamento
- Fácil de testar: cada implementação isolada

## Uso

```java
// Agora podemos "plugar" qualquer forma de pagamento sem modificar a classe Pedido.
// Basta criar uma nova classe que implemente MetodoPagamento.
public class Main {
    public static void main(String[] args) {
        Pedido pedido1 = new Pedido(new PagamentoCartao());
        pedido1.finalizar();

        Pedido pedido2 = new Pedido(new PagamentoBoleto());
        pedido2.finalizar();

        Pedido pedido3 = new Pedido(new PagamentoPix());
        pedido3.finalizar();

        // Se amanhã criarmos PagamentoCripto, nada aqui precisa mudar.
    }
}
```

**O que demonstra o padrão:**
- A classe `Pedido` não conhece tipos específicos de pagamento
- Usa apenas a interface `MetodoPagamento` (abstração)
- Polimorfismo garante que a implementação correta é executada em tempo de execução
- Novos tipos podem ser adicionados através de novas implementações de `MetodoPagamento`
- Código cliente trabalha com abstrações, não com tipos concretos

## Estrutura do Projeto

```
GRASP-Polymorphism/
├── src/
│   ├── MetodoPagamento.java      (Interface)
│   ├── PagamentoCartao.java      (Implementação 1)
│   ├── PagamentoBoleto.java      (Implementação 2)
│   ├── PagamentoPix.java         (Implementação 3)
│   ├── Pedido.java               (Classe de domínio)
│   └── Main.java                 (Programa de demonstração)
└── README.md
```

## Como Compilar e Executar

### Compilar

```bash
# A partir do diretório raiz do projeto
javac -encoding UTF-8 -d bin src/*.java
```

### Executar

```bash
# A partir do diretório raiz do projeto
java -cp bin Main
```

## Conceitos Relacionados

- **Polimorfismo de Subtipo**: Subclasses podem ser usadas onde o tipo de interface é esperado
- **Injeção de Dependência**: Pedido recebe MetodoPagamento via construtor
- **Princípio Aberto/Fechado (OCP)**: Aberto para extensão, fechado para modificação
- **Inversão de Dependência (DIP)**: Classes de alto nível dependem de abstrações
- **Princípio da Responsabilidade Única (SRP)**: Cada classe tem uma razão para mudar

## Aplicações Práticas

1. **Processamento de Pagamentos**: Múltiplos gateways (Stripe, PayPal, Square)
2. **Formatos de Arquivo**: Leitores/escritores (PDF, XML, JSON)
3. **Bancos de Dados**: Diferentes drivers (MySQL, PostgreSQL, MongoDB)
4. **Sistemas de Autenticação**: OAuth, JWT, SAML
5. **Transporte**: HTTP, HTTPS, WebSocket
6. **Notificações**: Email, SMS, Push Notifications

## Conclusão

O padrão GRASP Polymorphism é fundamental para criar código flexível, extensível e de fácil manutenção. Ao usar interfaces e deixar que o polimorfismo dirija o comportamento, você escreve código que se fecha para modificação, mas permanece aberto para extensão.
