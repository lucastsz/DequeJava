package app;

import model.Deque;

public class AppDeque {
    public static void main(String[] args) {

        Deque<Integer> d = new Deque();
        
        d.InserirNoInicio(5);
        d.InserirNoInicio(4);
        d.InserirNoInicio(3);
        d.InserirNoInicio(2);
        d.InserirNoInicio(1);
        
        d.InserirNoFim(6);
        d.InserirNoFim(7);
        d.InserirNoFim(8);
        
        System.out.println(d.toString());
        
        System.out.println(d.existeDado(5));
        
        System.out.println(d.isEmpty());
        
        System.out.println(d.RecuperarInicio());
        System.out.println(d.RecuperarFim());
        
        d.AlterarInicio(11);
        d.AlterarFim(13);
        
        System.out.println(d.toString());
        
        d.removeInicio();
        d.removeFim();
        
        System.out.println(d.toString());
        
        System.out.println(d.tamanho());
        d.limpa();
        
        System.out.println(d.toString());
        

    }
    
}
