public class Searcher {
    private int[] array;
    private Nodo lista;

    public Searcher(int[] array)
    {
        this.array=array;
        this.lista=null;
    }
    public Searcher(Nodo raiz)
    {
        this.array=null;
        this.lista=raiz;
    }
    public Searcher(int[] array,Nodo raiz)
    {
        this.array=array;
        this.lista=raiz;   
    }
    public void setArray(int[] array)
    {
        this.array=array;
    }
    
    public void setLista(Nodo nodo)
    {
        this.lista= nodo;
    }
    public void printArray()
    {
        if(this.array!=null)
        {
            for(int i=0;i<this.array.length;i++)
            {
                System.out.print(array[i]+" ");
            }
        }
        else
        {
            System.out.println("no hay un arreglo");
        }
    }
    public void printLista()
    {
        Nodo aux=this.lista;
        if(aux!=null)
        {
            while (aux!=null) {
                System.out.print(aux.getValor() + " ");
                aux=aux.getSiguiente();
            }
        }
        else
        {
            System.out.println("no hay ninguna lista");
        }
    } 

    public int[] busquedaSecuencialArray(int mostWanted)
    {
        int[] valorfinal={0,-1,0};
        //el indice 0 de esta lista significa si existe o no, existe= valorfinal[0] igual 1, caso contrario no existe,
        //el segundo valor es el indice y el tercer valor es el valor
        if(array!=null)
        {
            for(int i=0;i<array.length;i++)
            {
                if(array[i]==mostWanted)
                {
                    valorfinal[0]=1;
                    valorfinal[1]=i;
                    valorfinal[2]=array[i];
                }
            }
        }
        else
        {
            System.out.println("no hay ningun array");
        }
        return valorfinal;
    }

    public int[] busquedaSecuencialLista(int mostWanted)
    {
        int[] valorfinal={0,-1,0};
        if(lista!=null)
        {
            Nodo aux=this.lista;
            int contador=0;
            while (aux!=null) 
            {
                contador+=1;
                if(aux.getValor()==mostWanted)
                {
                    valorfinal[0]=1;
                    valorfinal[1]=contador;
                    valorfinal[2]=aux.getValor();
                    aux=null;
                }
                else
                {
                    aux=this.lista.getSiguiente();
                }     
            }
        }
        return valorfinal;
    }

    public int[] busquedaBinariaArray(int mostWanted)
    {
        int [] valor= {0,-1,0};
        int pivote=0;

        if(array!=null)
        {
            int inicio=0;
            int ultimo=array.length-1;
            boolean vericador=true;
            int contador=0;
            while (vericador&& inicio<=ultimo) 
            {
                int centro=((inicio+ultimo)/2);
                if(mostWanted== array[centro])
                {
                    vericador=false;
                    valor[0]=1;
                    valor[1]=centro;
                    valor[2]=array[centro];
                }
                else if(mostWanted<array[centro])
                {
                    ultimo=centro-1;
                }
                else
                {
                    inicio=centro+1;
                }
            }
        }
        return valor;
    }

    public int contarTamañoLista()
    {
        int tamaño=-1;
        if(lista!=null)
        {
            Nodo aux=lista;
            while (aux!=null)
            {
                tamaño+=1;
                aux=lista.getSiguiente();
            }
        }
        return tamaño;
    }

    
    public void bubbleSort()
    {
        if(this.array!=null)
        {
            for(int j=1;j<array.length;j++)
            {
                for(int i=0;i<array.length;i++)
                {
                    if(array[i]>array[j])
                    {
                        int aux=array[j];
                        array[j]=array[i];
                        array[i]=aux;
                    }
                }
            }
        }
    }
    public void insertionSortArray()
    {
        if(array!=null&& array.length>1)
        {
            for(int i=1;i<array.length-1;i++)
            {
                int temp=array[i];
                int j=i-1;
                while ((j>=0&&temp<= array[j]))
                {
                    array[j-1]=array[j-1];
                    j=j-1;    
                }
                array[j+1]=temp;
            }
        }
    }
    public void seleccionSortArray()
    {
        if(array!=null)
        {
            int menor=array[0];
            for(int i=0;i<array.length;i++)
            {
                for(int j=0;j<array.length;j++)
                {
                    if(menor>array[j])
                    {
                        menor=array[j];
                    }
                }
                array[i]=menor;
            }
        }
    }
    public void insertionSort()
    {
        if(lista!=null)
        {
            Nodo puntero=lista.getSiguiente();
            Nodo anterior=lista;
            while (puntero!=null)
            {
                if(puntero.getValor()<anterior.getValor())
                {
                    if(anterior.getValor()==lista.getValor())
                    {
                        Nodo aux=puntero.getSiguiente();
                        Nodo auxP=anterior;
                        puntero.setSiguiente(anterior);
                        anterior.setSiguiente(aux);
                        this.lista=puntero;
                        puntero=puntero.getSiguiente();
                        anterior=auxP;
                    }
                    else
                    {
                        if(puntero.getValor()<anterior.getValor())
                        {
                            Nodo aux=puntero.getSiguiente();
                            puntero.setSiguiente(anterior);
                            anterior.setSiguiente(aux);
                            anterior=lista;
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) 
    {
        int[] arreglo={0,2,0,1,8,7,10};
        Searcher nuevo=new Searcher(arreglo);
        nuevo.printArray();
        nuevo.insertionSortArray();
        System.out.println("");
        nuevo.printArray();
    }
}

