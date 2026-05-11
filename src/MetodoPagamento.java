/**
 * Interface MetodoPagamento
 * 
 * Define o contrato para diferentes métodos de pagamento.
 * Esta interface é o ponto central do padrão GRASP Polymorphism.
 * 
 * Abstração que permite que diferentes formas de pagamento implementem
 * seu próprio comportamento de forma polimórfica.
 * Elimina a necessidade de if/else, switch ou instanceof na classe cliente.
 */
public interface MetodoPagamento {

    /**
     * Processa o pagamento de acordo com o tipo específico implementado.
     * Cada implementação define sua própria lógica.
     */
    void processar();
}
