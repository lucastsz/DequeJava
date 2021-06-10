package model;

public class Celula<T> {
  private Celula proxima;
  private Celula anterior;
  private T elemento;

  public Celula(Celula proxima, T elemento) {
    this.proxima = proxima;
    this.elemento = elemento;
  }

    public Celula() {
    }

  
  
  public Celula(T elemento) {
    this.elemento = elemento;
  }

  public void setProxima(Celula proxima) {
    this.proxima = proxima;
  }

  public Celula getProxima() {
    return proxima;
  }

    public Celula getAnterior() {
        return anterior;
    }

    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }
  
  public T getElemento() {
    return elemento;
  }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
  
  
  
}
