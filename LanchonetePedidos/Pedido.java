public class Pedido {
    int id_pedido;
    String nome_cliente;
    String item;
    int quantidade;
    double valor;
    String tipo;
    Pedido proximo; // ponteiro para o próximo nó

    public Pedido(int id_pedido, String nome_cliente, String item, int quantidade, double valor, String tipo) {
        this.id_pedido = id_pedido;
        this.nome_cliente = nome_cliente;
        this.item = item;
        this.quantidade = quantidade;
        this.valor = valor;
        this.tipo = tipo;
        this.proximo = null;
    }

    @Override
    public String toString() {
        return "[ID: " + id_pedido +
               ", Cliente: " + nome_cliente +
               ", Item: " + item +
               ", Qtd: " + quantidade +
               ", Valor: R$ " + String.format("%.2f", valor) +
               ", Tipo: " + tipo + "]";
    }
}
