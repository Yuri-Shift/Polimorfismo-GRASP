/**
 * Classe Main - Demonstração do Padrão GRASP Polymorphism
 * 
 * Agora podemos "plugar" qualquer forma de pagamento sem modificar a classe
 * Pedido.
 * Basta criar uma nova classe que implemente MetodoPagamento.
 */
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
