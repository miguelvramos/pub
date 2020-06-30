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

    public boolean removerNo(long numeroTelefone) {
        if (buscarNoNumeroTelefone(numeroTelefone)) {
            if (quantidade == 1) {
                this.inicio = null;
                this.fim = null;
            } else if(this.inicio.getCliente().getNumeroTelefone() == numeroTelefone) {
                No noAux = this.inicio;
                No noProximo = this.inicio.getProximo();
                this.inicio = noProximo;
                noAux.setProximo(null);
            } else if (this.fim.getCliente().getNumeroTelefone() == numeroTelefone) {
                No noAnterior = buscarNoAnterior(numeroTelefone);
                this.fim = noAnterior;
                this.fim.setProximo(null);
            } else {
                No noAnterior = buscarNoAnterior(numeroTelefone);
                No noAux = noAnterior.getProximo();
                noAnterior.setProximo(noAnterior.getProximo().getProximo());
                noAux.setProximo(null);
            }
            this.quantidade--;
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

    public No buscarNoAnterior(long numeroTelefone) {
        No proximoNo = this.inicio;
        while (proximoNo != null) {
            if (proximoNo.getProximo().getCliente().getNumeroTelefone() == numeroTelefone) {
                return proximoNo;
            } else {
                proximoNo = proximoNo.getProximo();
            }
        }
        return null;
    }


    public boolean buscarNoNumeroTelefone(long numeroTelefone) {
        No proximoNo = this.inicio;
        while (proximoNo != null) {
            if (proximoNo.getCliente().getNumeroTelefone() == numeroTelefone) {
                return true;
            } else {
                proximoNo = proximoNo.getProximo();
            }
        }
        return false;
    }

    public void limparDados() {
        this.inicio = null;
        this.quantidade = 0;
        this.fim = null;
    }

    public int getQuantidade() {
        return quantidade;
    }  
}
