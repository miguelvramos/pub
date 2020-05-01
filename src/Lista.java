public class Lista {
    private No inicio;
    private No fim;
    private int quantidade;

    public void inserirNoFim(No novoNo) {
        if (this.inicio == null) {
            this.inicio = novoNo;
            this.fim = this.inicio;
        } else {
            this.fim.setProximo(novoNo);
            this.fim = this.fim.getProximo();
        }
        this.quantidade++;
    }

    public boolean removerNo(String numeroTelefone) {
        if (buscarNoNumeroTelefone(numeroTelefone) != null) {
            if (quantidade == 1) {
                this.inicio = null;
                this.fim = null;
                this.quantidade--;
            } else if(this.inicio.getCliente().getNumeroTelefone().equals(numeroTelefone)) {
                No noProximo = this.inicio.getProximo();
                this.inicio = noProximo;
                this.quantidade--;
            } else if (this.fim.getCliente().getNumeroTelefone().equals(numeroTelefone)) {
                No noAnterior = buscarNoAnterior(numeroTelefone);
                this.fim = noAnterior;
                this.fim.setProximo(null);
                this.quantidade--;
            } else {
                No noAnterior = buscarNoAnterior(numeroTelefone);
                noAnterior.setProximo(noAnterior.getProximo().getProximo());
                this.quantidade--;
            }
            return true;
        } else {
            return false;
        }
    }

    public No buscarNoEspecifico(int numero) {
        No proximoNo = this.inicio;
        int contador = 0;
        while (true) {
            if (contador == numero) {
                return proximoNo;
            } else {
                proximoNo = proximoNo.getProximo();
                contador++;
            }
        }
    }

    public No buscarNoAnterior(String numeroTelefone) {
        No proximoNo = this.inicio;
        while (proximoNo != null) {
            if (proximoNo.getProximo().getCliente().getNumeroTelefone().equals(numeroTelefone)) {
                return proximoNo;
            } else {
                proximoNo = proximoNo.getProximo();
            }
        }
        return null;
    }


    public No buscarNoNumeroTelefone(String numeroTelefone) {
        No proximoNo = this.inicio;
        while (proximoNo != null) {
            if (proximoNo.getCliente().getNumeroTelefone().equals(numeroTelefone)) {
                return proximoNo;
            } else {
                proximoNo = proximoNo.getProximo();
            }
        }
        return null;
    }

    public int getQuantidade() {
        return quantidade;
    }  
}
