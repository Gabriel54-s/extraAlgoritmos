public class Nodo
{
    private int valor;
    private Nodo siguiente;

    public Nodo(int valor)
    {
        this.valor= valor;
        this.siguiente=null;
    }

    public int getValor()
    {
        return this.valor;
    }

    public Nodo getSiguiente()
    {
        return this.siguiente;
    }

    public void setSiguiente(Nodo siguente)
    {
        this.siguiente= siguiente;
    }

    
}