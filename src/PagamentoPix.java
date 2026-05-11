/**
 * Classe PagamentoPix
 * 
 * Implementa a interface MetodoPagamento para processamento de pagamentos
 * via Pix.
 * 
 * Cada tipo concreto implementa seu próprio comportamento.
 */
public class PagamentoPix implements MetodoPagamento {

    @Override
    public void processar() {
        System.out.println("Gerando QR Code para pagamento via Pix...");
    }
}
