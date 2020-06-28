public class ArvoreBinaria {
    private NoArvoreBinaria raiz;
    private String lista = "";

    public void incluir(NoArvoreBinaria novoNo) {
        this.incluir(raiz, novoNo);
    }

    private NoArvoreBinaria incluir(NoArvoreBinaria noAtual, NoArvoreBinaria novoNo) {
        if (noAtual == null) {
            noAtual = novoNo;

            if(this.raiz == null) {
                this.raiz = noAtual;
            }
        } else if (novoNo.getValor() < noAtual.getValor()) {
            noAtual.setEsquerda(incluir(noAtual.getEsquerda(), novoNo));
        } else if (novoNo.getValor() > noAtual.getValor()) {
            noAtual.setDireita(incluir(noAtual.getDireita(), novoNo));
        } else {
            System.out.println("O valor já foi cadastrado!");
        }
        return noAtual;
    }

    public String getLista() {
        central();
        return lista;
    }

    public void setLista(String valor) {
        this.lista = valor;
    }

    public void central() {
        this.central(raiz);
    }

    private void central(NoArvoreBinaria noAtual) {
        if (noAtual == raiz) {
            this.setLista("");
        }
        if (noAtual == null) {
            return;
        }
        central(noAtual.getEsquerda());
        lista += noAtual.getValor() + "\n";
        central(noAtual.getDireita());
    }

    public int localizar(long valor) { return this.localizar(raiz, valor); }

    private int localizar(NoArvoreBinaria noAtual, long valor) {
        if (noAtual == null) {
            return 0;
        }
        if (valor < noAtual.getValor()) {
            localizar(noAtual.getEsquerda(), valor);
        } else if (valor > noAtual.getValor()) {
            localizar(noAtual.getDireita(), valor);
        } else {
            return 1;
        }
        return 0;
    }

    public void limparDados() {
        this.raiz = null;
        this.lista = "";
    }
}
