package byrn;

import java.util.HashMap;

public class NodoCola 
{
 //Declaracion de atributos
 private HashMap dato;
 private NodoCola next;
  
 //Constructor
 public NodoCola(HashMap dato){
 this.dato=dato;
 }
  
 //Metodos getter and setters
 public HashMap getDato() 
 {
 return dato;
 }
 public void setDato(HashMap dato) 
 {
 this.dato = dato;
 }
 public NodoCola getNext() 
 {
 return next;
 }
 public void setNext(NodoCola next) 
 {
 this.next = next;
 }
  
 //Metodo toString
 public String toString()
 {
 String s=" "+dato+" ";
 return s;
 }
 
 
}
