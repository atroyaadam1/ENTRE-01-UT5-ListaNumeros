/**
 * La clase representa a una lista de 
 * números enteros
 * 
 * @author - ANTHONNY TROYA
 * 
 */
import java.util.Arrays;

public class ListaNumeros 
{
    // definir atributos
    private int [] lista;
    private int pos;
    /**
     * Constructor de la clase ListaNumeros 
     * Crea e inicializa adecuadamente los
     * atributos
     * 
     * @param n el tamaño máximo de la lista
     */
    public ListaNumeros(int n) {
        lista = new int[n];
        pos = 0;
    }

    /**
     * Añade un valor siempre al principio de la lista
     * 
     * @param numero el valor que se añade. No se hace nada si la lista está
     *               completa
     * @return true si se ha podido añadir, false en otro caso
     */
    public boolean addElemento(int numero) {
        if (!estaCompleta()){
            lista[pos] = numero;
            pos++;
            return true;
        }
        return false;
    }

    /**
     * devuelve true si la lista está completa, false en otro caso
     * Hacer sin if
     */
    public boolean estaCompleta() {
        // return lista.length == pos; // duda
        return pos == lista.length;

    }

    /**
     * devuelve true si la lista está vacía, false en otro caso. 
     * Hacer sin if
     */
    public boolean estaVacia() {
        // return lista.length == 0;
        return pos == 0;
    }

    /**
     * devuelve el nº de elementos realmente guardados en la lista
     */
    public int getTotalNumeros() {
        return lista.length;

    }

    /**
     * Vacía la lista
     */
    public void vaciarLista() {
        for(int i = 0; i < pos; i++){
            lista[i] = 0;
        }
    }

    /**
     * Representación textual de la lista de la forma indicada 
     * (leer enunciado)
     * 
     * Si la lista está vacía devuelve ""
     */
    public String toString() {
        String str = "";
        if (!estaVacia()){
            for (int i = 0; i < lista.length; i++){
                str += String.format("%8d", lista[i]);
            }
            str += "\n";
            for (int i = 0; i < lista.length; i++){
                str+= String.format("%8d", i);
            }
            return str;
        }
        return "";
    }

    /**
     * Mostrar en pantalla la lista
     */
    public void escribirLista() {
        System.out.println(this.toString());
    }

    /**
     * Búsqueda lineal de numero en la lista
     * @param numero el nº a buscar
     * @return un array con las posiciones en las que se ha encontrado
     *  
     */
    public int[] buscarPosicionesDe(int numero) {
        int [] posiciones = new int [lista.length];
        int total = 0;

        for(int i = 0; i <= pos; i++){
            if(lista[i] == numero){
                posiciones[total] = i;
                total++;
            }
        }
        return posiciones;
    }

    /**
     * Hace una búsqueda binaria del numero indicado devolviendo -1 si no se
     * encuentra o la posición en la que aparece
     * 
     * El array original lista no se modifica 
     * Para ello crea previamente una copia
     * de lista y trabaja con la copia
     * 
     * Usa exclusivamente métodos de la clase Arrays
     * 
     */
    public int buscarBinario(int numero) {
        int total = 0;
        for (int i = 0; i <= lista.length; i++){
            if(lista[i] == numero){
                total++;
            }
        }
        if (total != 0){
            return total;
        } else {
            return Arrays.binarySearch(lista, numero);
        }

    }

    /**
     * borra el primer elemento de la lista
     */
    public void borrarPrimero() {
        for (int  i = 0; i < lista.length; i++){
            if(i == 0){
                lista[i] = 0;
            }
        }
    }

    /**
     *  Invierte cada uno de los grupos de n elementos que hay en lista
     *  
     *  Si el nº de elementos en lista no es divisible entre n los elementos restantes 
     *  quedan igual
     *  
     *  (leer enunciado)
     *  
     */
    public void invertir(int n) {
        int invertir = lista.length;
        for(int i = 0; i <(lista.length / 2); i++){
            int aux = lista[i];
            lista[i] = lista[invertir];
            invertir--;
        }
    }

    /**
     * devuelve un ragged array de 2 dimensiones con tantas filas como valores
     * tenga el atributo lista y rellena el array de la forma indicada
     * (leer enunciado)
     * 
     */
    public int[][] toArray2D() {

        int[][] ragged = new int [lista.length][];

        return ragged;
    }

    /**
     * Punto de entrada a la aplicación 
     * Contiene código para probar los métodos de ListaNumeros
     */
    public static void main(String[] args) {
        ListaNumeros lista = new ListaNumeros(20);

        System.out.println("--- addElemento() y toString() -------");
        int[] valores = {21, -5, 6, -7, 21, -17, 21, 15, 22, 21, 77};
        for (int i = 0; i < valores.length; i++) {
            lista.addElemento(valores[i]);
        }
        System.out.println(lista.toString());

        System.out.println("--- buscarPosiciones() -------");
        int numero = 21;
        System.out.println(lista.toString());
        System.out.println("\t" + numero + " aparece en posiciones ");
        int[] posicion = lista.buscarPosicionesDe(numero);
        for(int i = 0; i < posicion.length; i++){
            System.out.print(posicion[i]);
        }

        System.out.println("---buscarBinario()---");
        if(lista.buscarBinario(numero) == 0){
            System.out.println("El número no está en la lista");

        }else{
            System.out.println("El número está en la lista");
        }

        System.out.println("---invertir()---");
        System.out.println("Lista sin invertir:");
        System.out.println(lista.toString());
        System.out.println("Lista invertida  " + lista.getTotalNumeros() + " elementos en total");
        lista.invertir(2);
        System.out.println(lista.toString());
        System.out.println();

        System.out.println("---toArray2D()---\n");
        int[][] array2d = lista.toArray2D();
        for(int i = 0; i < array2d.length; i++){
            System.out.print((i + 1) + ":");
            for(int g = 0; g < array2d[i].length; g++){
                System.out.print(array2d[i][g] );
            }

        }
    }

}

