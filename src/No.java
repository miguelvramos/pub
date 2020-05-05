public class No {
    private Cliente cliente;
    private No proximo;

    public Cliente getCliente() {
        return cliente;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
