import javax.swing.*;

public class Lista {
    private No inicio;
    private No fim;
    private int quantidade;

    public void inserirNoFim(No novoNo) {
        if (this.buscarNoNumeroTelefone(novoNo.getCliente().getNumeroTelefone()) == null) {
            if (this.inicio == null) {
                this.inicio = novoNo;
                this.fim = this.inicio;
            } else {
                this.fim.setProximo(novoNo);
                this.fim = this.fim.getProximo();
            }
            this.quantidade++;
        } else {
            JOptionPane.showMessageDialog(null, "Esse número já existe.");
        }
    }

    public boolean removerNo(String numeroTelefone) {
        if (buscarNoNumeroTelefone(numeroTelefone) != null) {
            if (quantidade == 1) {
                this.inicio = null;
                this.fim = null;
            } else if(this.inicio.getCliente().getNumeroTelefone().equals(numeroTelefone)) {
                No noAux = this.inicio;
                No noProximo = this.inicio.getProximo();
                this.inicio = noProximo;
                noAux.setProximo(null);
            } else if (this.fim.getCliente().getNumeroTelefone().equals(numeroTelefone)) {
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
