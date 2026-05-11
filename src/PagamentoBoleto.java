/**
 * Classe PagamentoBoleto
 * 
 * Implementa a interface MetodoPagamento para processamento de pagamentos
 * via Boleto Bancário.
 * 
 * Cada tipo concreto implementa seu próprio comportamento.
 */
public class PagamentoBoleto implements MetodoPagamento {

    @Override
    public void processar() {
        System.out.println("Gerando boleto bancário...");
    }
}
