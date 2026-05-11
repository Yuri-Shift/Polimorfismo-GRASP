<!-- Use this file to provide workspace-specific custom instructions to Copilot. For more details, visit https://code.visualstudio.com/docs/copilot/copilot-customization#_use-a-githubcopilotinstructionsmd-file -->

## Instruções do Projeto - GRASP Polymorphism

Este projeto demonstra o padrão GRASP Polymorphism através de um sistema de processamento de pagamentos em Java.

### Objetivo Educacional

- Ensinar como usar polimorfismo para evitar if/else e switch statements
- Demonstrar a inversão de dependência e injeção de dependência
- Mostrar como estender funcionalidades sem modificar código existente (Open/Closed Principle)

### Estrutura do Projeto

- `src/MetodoPagamento.java`: Interface que define o contrato
- `src/PagamentoCartao.java`: Implementação para Cartão de Crédito
- `src/PagamentoBoleto.java`: Implementação para Boleto Bancário
- `src/PagamentoPix.java`: Implementação para Pix
- `src/Pedido.java`: Classe de domínio que usa polimorfismo
- `src/Main.java`: Programa demonstrativo

### Padrão de Código

- Todos os nomes de classes, métodos e variáveis em português
- Comentários didáticos explicando a lógica
- Cada classe tem uma responsabilidade clara
- Use interfaces para definir contratos

### Como Adicionar Novo Método de Pagamento

1. Criar nova classe que implemente `MetodoPagamento`
2. Implementar `processar(double valor)` e `obterDescricao()`
3. NÃO modificar a classe `Pedido` - ela já funciona com qualquer novo tipo!

### Compilação e Execução

```bash
javac -d bin src/*.java
java -cp bin Main
```

### Princípios Aplicados

- GRASP Polymorphism
- SOLID Principles
- Dependency Injection
- Open/Closed Principle
