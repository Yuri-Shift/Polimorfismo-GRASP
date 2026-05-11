/**
 * Classe PagamentoCartao
 * 
 * Implementa a interface MetodoPagamento para processamento de pagamentos
 * via Cartão de Crédito.
 * 
 * Cada tipo concreto implementa seu próprio comportamento.
 */
public class PagamentoCartao implements MetodoPagamento {

    @Override
    public void processar() {
        System.out.println("Processando pagamento no cartão de crédito...");
    }
}
