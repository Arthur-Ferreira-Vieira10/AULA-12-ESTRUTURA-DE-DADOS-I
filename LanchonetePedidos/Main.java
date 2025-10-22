public class Main {
    public static void main(String[] args) {
        ListaPedidos lista = new ListaPedidos();

        // Criando pedidos
        Pedido p1 = new Pedido(1, "Arthur", "X-Burger", 2, 25.00, "Normal");
        Pedido p2 = new Pedido(2, "Pedro", "Suco", 1, 8.00 * 1.10, "Prioritário");
        Pedido p3 = new Pedido(3, "Maria", "Pizza", 1, 40.00 * 1.20, "Urgente");
        Pedido p4 = new Pedido(4, "Lúcia", "Batata", 3, 15.00, "Normal");

        // Inserções
        lista.inserirFim(p1);
        lista.inserirMedio(p2);
        lista.inserirInicio(p3);
        lista.inserirFim(p4);

        // Impressão geral
        lista.imprimirLista();

        // Busca
        System.out.println("\n🔎 Busca por ID 2:");
        System.out.println(lista.buscarPorId(2));

        // Mostrar próximos pedidos
        System.out.println();
        lista.buscarPorPosicao(3);

        // Remoções
        System.out.println("\n➡️ Removendo início (pedido atendido)");
        lista.removerInicio();

        System.out.println("\n➡️ Removendo fim (cancelamento)");
        lista.removerFim();

        System.out.println("\n➡️ Removendo posição 1 (cancelamento específico)");
        lista.removerPosicao(1);

        // Resultado final
        System.out.println("\n📋 Lista final após remoções:");
        lista.imprimirLista();

        System.out.println("\nTamanho final da lista: " + lista.tamanho());
    }
}

