public class app {
    public static void main(String[] args) {
        Lista lista = new Lista();
        Cliente cliente1 = new Cliente("Henrique", "3333");
        No novoNo1 = new No();
        novoNo1.setCliente(cliente1);
        lista.inserirNoFim(novoNo1);

        Cliente cliente2 = new Cliente("Miguel", "9999");
        No novoNo2 = new No();
        novoNo2.setCliente(cliente2);
        lista.inserirNoFim(novoNo2);

        Cliente cliente3 = new Cliente("Arthur", "4444");
        No novoNo3 = new No();
        novoNo3.setCliente(cliente3);
        lista.inserirNoFim(novoNo3);

        lista.removerNo("4444");
    }
}
