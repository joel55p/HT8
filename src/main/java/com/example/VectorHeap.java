package com.example;
import java.util.ArrayList;
/* Esta clase es bien imporante ya que como tal implementa la cola  utilizando un minHeap basado en un arrayList, ademas los tipos de elementos tiene que ser comparables  */

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private ArrayList<E> heap; /*es la lista que va a almecenar los elementos del heap */

    public VectorHeap() {
        heap = new ArrayList<>(); /*Constructor, inicia el propio Heap vacio */
    }

    @Override
    public void add(E element) {
        heap.add(element);
        upHeap(heap.size() - 1);/*agrega el elemento al final y lo sube para mantener la propiedad del heap */
    }

    @Override
    public E remove() { /*elimina el elemento de la cola de prioridad  y devuelve elemento con mayor prioridad*/
        if (heap.isEmpty()) return null;
        
        E min = heap.get(0);/*el primer elemento es el de mayor prioridad, osea raiz*/
        if (heap.size() == 1) {
            heap.remove(0);
        } else {
            heap.set(0, heap.remove(heap.size() - 1)); /*sustituye la raiz por el ultimo elemento */
            downHeap(0);/*pone el heap para abajo */
        }
        return min;
    }
    

    @Override
    public boolean isEmpty() {/*verifica si la cola esta vacia */
        return heap.isEmpty();
    }

    private void upHeap(int index) { /*metodo literal para  reorganizar heap cuando un elemento nuevo se agregue */
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) >= 0) break; /*ChatGPT, 2025 */ 
            swap(index, parent);
            index = parent;
        }
    }

    private void downHeap(int index) { /*metodo literal para  reorganizar heap cuando se elimine la raiz*/
        int leftChild, rightChild, smallest;
        while (index < heap.size() / 2) { /*mientras no sea hoja, osea mientras tengo un hijo */
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            smallest = leftChild;
            if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(leftChild)) < 0) /*se compara con el hijo derecho */
                smallest = rightChild;
            if (heap.get(index).compareTo(heap.get(smallest)) <= 0) break; /*el break es por si orden esta bien */
            swap(index, smallest); /*se cambia con hijo pequeño */
            index = smallest;
        }
    }

    private void swap(int i, int j) { /*metodo para cambiar los elementos de la lista */
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}