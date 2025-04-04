package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

/*Pruebas unitareas */
public class VectorHeapTest {

    @Test
    public void testAddSingleElement() { /*para un solo elemento */
        /*un vectorHeap vacio */
        VectorHeap<Integer> heap = new VectorHeap<>();
        
        /*verifica si vacio pues */
        assertTrue(heap.isEmpty());
        
        /*añade elemento */
        heap.add(10);
        
        /*ve si ya no esta vacio */
        assertFalse(heap.isEmpty());
        
        /*verifica que el elemento si se agrega de manera nice*/
        assertEquals(Integer.valueOf(10), heap.remove());
        
        /*verifica que ya no hay elementos */
        assertTrue(heap.isEmpty());
    }
    

    
    @Test
    public void testAddElementsRandomOrder() {
        /*Vector heap vacio */
        VectorHeap<Integer> heap = new VectorHeap<>();
        
        /*se agrega en random order */
        heap.add(5);
        heap.add(2);
        heap.add(8);
        heap.add(1);
        heap.add(10);
        
        /*ahora si ve el orden segun el meanheap */
        assertEquals(Integer.valueOf(1), heap.remove());
        assertEquals(Integer.valueOf(2), heap.remove());
        assertEquals(Integer.valueOf(5), heap.remove());
        assertEquals(Integer.valueOf(8), heap.remove());
        assertEquals(Integer.valueOf(10), heap.remove());
        assertTrue(heap.isEmpty());
    }
    


    @Test
    public void testRemoveFromEmptyHeap() {
        /*vector heap vacio */
        VectorHeap<Integer> heap = new VectorHeap<>();
        
       /*ve si al retiral algo de un vacio da null y ya */
        assertNull(heap.remove());
    }
    
    @Test
    public void testWithPacienteObjects() {
      /* VectorHeap para objetos Paciente */
        VectorHeap<Paciente> heap = new VectorHeap<>();
        
       /*pues crea asi diferentes codigos de prioridad */
        Paciente p1 = new Paciente("Juan", "Fractura", 'B');
        Paciente p2 = new Paciente("María", "Apendicitis", 'A');
        Paciente p3 = new Paciente("Pedro", "Resfriado", 'C');
        
        /* Agregar pacientes al heap */
        heap.add(p1);
        heap.add(p2);
        heap.add(p3);
        
        /* ve si se van los elementos en el orden correcto , osea segun prioridad*/
        assertEquals('A', heap.remove().getCodigo());
        assertEquals('B', heap.remove().getCodigo());
        assertEquals('C', heap.remove().getCodigo());
        assertTrue(heap.isEmpty());
    }
    

}