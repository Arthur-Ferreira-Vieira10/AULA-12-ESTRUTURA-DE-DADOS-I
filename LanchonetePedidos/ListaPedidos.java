public class ListaPedidos {
    private Pedido cabeca;
    private Pedido cauda;
    private int tamanho;

    public ListaPedidos() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    // ---------- Funções utilitárias ----------
    public boolean estaVazia() {
        return cabeca == null;
    }

    public int tamanho() {
        return tamanho;
    }

    public Pedido obterCabeca() {
        return cabeca;
    }

    public Pedido obterCauda() {
        return cauda;
    }

    // ---------- Inserções ----------
    public void inserirInicio(Pedido novo) { // Pedido Urgente
        if (buscarPorId(novo.id_pedido) != null) {
            System.out.println("❌ Pedido duplicado (ID " + novo.id_pedido + ") rejeitado.");
            return;
        }

        novo.proximo = cabeca;
        cabeca = novo;
        if (cauda == null) cauda = novo;
        tamanho++;
    }

    public void inserirFim(Pedido novo) { // Pedido Normal
        if (buscarPorId(novo.id_pedido) != null) {
            System.out.println("❌ Pedido duplicado (ID " + novo.id_pedido + ") rejeitado.");
            return;
        }

        if (estaVazia()) {
            cabeca = novo;
            cauda = novo;
        } else {
            cauda.proximo = novo;
            cauda = novo;
        }
        tamanho++;
    }

    public void inserirMedio(Pedido novo) { // Pedido Prioritário
        if (buscarPorId(novo.id_pedido) != null) {
            System.out.println("❌ Pedido duplicado (ID " + novo.id_pedido + ") rejeitado.");
            return;
        }

        if (estaVazia() || tamanho == 1) {
            inserirFim(novo);
            return;
        }

        int meio = tamanho / 2;
        Pedido atual = cabeca;
        for (int i = 0; i < meio - 1; i++) {
            atual = atual.proximo;
        }
        novo.proximo = atual.proximo;
        atual.proximo = novo;
        if (novo.proximo == null) cauda = novo;
        tamanho++;
    }

    // ---------- Remoções ----------
    public void removerInicio() {
        if (estaVazia()) {
            System.out.println("❌ Lista vazia.");
            return;
        }
        System.out.println("✅ Pedido atendido: " + cabeca);
        cabeca = cabeca.proximo;
        tamanho--;
        if (cabeca == null) cauda = null;
    }

    public void removerFim() {
        if (estaVazia()) {
            System.out.println("❌ Lista vazia.");
            return;
        }
        if (tamanho == 1) {
            System.out.println("🚫 Pedido cancelado: " + cabeca);
            cabeca = cauda = null;
        } else {
            Pedido atual = cabeca;
            while (atual.proximo != cauda) {
                atual = atual.proximo;
            }
            System.out.println("🚫 Pedido cancelado: " + cauda);
            atual.proximo = null;
            cauda = atual;
        }
        tamanho--;
    }

    public void removerPosicao(int k) {
        if (k < 0 || k >= tamanho) {
            System.out.println("❌ Posição inválida!");
            return;
        }

        if (k == 0) {
            removerInicio();
            return;
        }

        Pedido atual = cabeca;
        for (int i = 0; i < k - 1; i++) {
            atual = atual.proximo;
        }
        System.out.println("🚫 Pedido cancelado: " + atual.proximo);
        atual.proximo = atual.proximo.proximo;

        if (atual.proximo == null) cauda = atual;
        tamanho--;
    }

    // ---------- Buscas ----------
    public Pedido buscarPorId(int id) {
        Pedido atual = cabeca;
        while (atual != null) {
            if (atual.id_pedido == id) return atual;
            atual = atual.proximo;
        }
        return null;
    }

    public void buscarPorPosicao(int n) {
        if (estaVazia()) {
            System.out.println("Lista vazia!");
            return;
        }

        Pedido atual = cabeca;
        int cont = 0;
        System.out.println("🔎 Próximos " + n + " pedidos:");
        while (atual != null && cont < n) {
            System.out.println(atual);
            atual = atual.proximo;
            cont++;
        }
    }

    // ---------- Impressão ----------
    public void imprimirLista() {
        if (estaVazia()) {
            System.out.println("Lista de pedidos vazia!");
            return;
        }

        System.out.println("📋 Lista de Pedidos em ordem de atendimento:");
        Pedido atual = cabeca;
        while (atual != null) {
            System.out.println(atual);
            atual = atual.proximo;
        }
    }
}
