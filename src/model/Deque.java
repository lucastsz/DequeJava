package model;

public class Deque<T> {

    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos;

    public Deque() {
    }

    private Deque(Celula primeira, Celula ultima) {
        this.primeira = primeira;
        this.ultima = ultima;
    }

    private Deque(Celula primeira) {
        this.primeira = primeira;
    }

    //--------------------------------------------------------------------------
    public void InserirNoInicio(T elemento) {
        adiciona(0, elemento);
    }
    
    public void InserirNoFim(T elemento) {
        adiciona(totalDeElementos, elemento);
    }
    
    private void InserirFim(T elemento) {
        if (this.totalDeElementos == 0) {
            Celula nova = new Celula(elemento);
            this.primeira = nova;
            this.ultima = nova;
        } else {
            Celula nova = new Celula(this.primeira, elemento);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
        }
        this.totalDeElementos++;
    }
    
        public boolean existeDado(T elemento) {
        Celula atual = this.primeira;

        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return true;
            }
            atual = atual.getProxima();
        }
        return false;
    }
        
        public boolean isEmpty() {
        return totalDeElementos == 0;
    }
        
        
    public T RecuperarInicio() {
        return pega(0);
    }

    public T RecuperarFim() {
        return pega(totalDeElementos - 1);
    }

    public void AlterarInicio(T elemento) {
        removeInicio();
        InserirNoInicio(elemento);
    }

    public void AlterarFim(T elemento) {
        removeFim();
        InserirNoFim(elemento);
    }
    
    public void removeInicio() {
        if (!this.posicaoOcupada(0)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        this.primeira = this.primeira.getProxima();
        this.totalDeElementos--;

        if (this.totalDeElementos == 0) {
            this.ultima = null;
        }
    }

    public void removeFim() {
        if (!this.posicaoOcupada(this.totalDeElementos - 1)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        if (this.totalDeElementos == 1) {
            this.removeInicio();
        } else {
            Celula penultima = this.ultima.getAnterior();
            penultima.setProxima(null);
            this.ultima = penultima;
            this.totalDeElementos--;
        }
    }
    
        public int tamanho() {
        return this.totalDeElementos;
    }



    public void limpa() {
        totalDeElementos = 0;
    }
    //--------------------------------------------------------------------------


    private void adiciona(T elemento) {
        if (this.totalDeElementos == 0) {
            this.InserirFim(elemento);
        } else {
            Celula nova = new Celula(elemento);
            this.ultima.setProxima(nova);
            nova.setAnterior(this.ultima);
            this.ultima = nova;
            this.totalDeElementos++;
        }
    }

    private void adiciona(int posicao, T elemento) {
        if (posicao == 0) { // No começo.
            this.InserirFim(elemento);
        } else if (posicao == this.totalDeElementos) { // No fim.
            this.adiciona(elemento);
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula proxima = anterior.getProxima();
            Celula nova = new Celula(anterior.getProxima(), elemento);
            nova.setAnterior(anterior);
            anterior.setProxima(nova);
            proxima.setAnterior(nova);
            this.totalDeElementos++;
        }
    }

    //--------------------------------------------------------------------------
    private void remove(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        if (posicao == 0) {
            this.removeInicio();
        } else if (posicao == this.totalDeElementos - 1) {
            this.removeFim();
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula atual = anterior.getProxima();
            Celula proxima = atual.getProxima();

            anterior.setProxima(proxima);
            proxima.setAnterior(anterior);

            this.totalDeElementos--;
        }
    }

    //--------------------------------------------------------------------------


    //--------------------------------------------------------------------------
    private T pega(int posicao) {
        return (T) this.pegaCelula(posicao).getElemento();
    }

    //--------------------------------------------------------------------------
    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.totalDeElementos;
    }

    private Celula pegaCelula(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        Celula atual = primeira;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }
        return atual;
    }

    @Override
    public String toString() {
        // Verificando se a Lista está vazia
        if (this.totalDeElementos == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        Celula atual = primeira;

        // Percorrendo até o penúltimo elemento.
        for (int i = 0; i < this.totalDeElementos - 1; i++) {
            builder.append(atual.getElemento());
            builder.append(" -> ");
            atual = atual.getProxima();
            builder.append(" <- ");
        }

        // último elemento
        builder.append(atual.getElemento());
        builder.append(" ->]");

        return builder.toString();
    }
}
