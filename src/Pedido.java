/**
 * Classe Pedido
 * 
 * Módulo de alto nível que depende da abstração (interface MetodoPagamento).
 * Não conhece detalhes concretos de cada tipo de pagamento.
 * 
 * Este é o ponto-chave do padrão GRASP Polymorphism:
 * - Sem if/else, switch ou instanceof
 * - Apenas chama o método processar() da interface
 * - O polimorfismo garante a implementação correta
 */
public class Pedido {

    private MetodoPagamento metodoPagamento; // Dependência da abstração

    /**
     * Construtor com injeção de dependência
     * 
     * @param metodoPagamento implementação de MetodoPagamento a ser utilizada
     */
    public Pedido(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    /**
     * Finaliza o pedido processando o pagamento através de chamada polimórfica.
     * Não há if/else, switch ou instanceof aqui!
     */
    public void finalizar() {
        metodoPagamento.processar(); // Chamada polimórfica
    }
}
