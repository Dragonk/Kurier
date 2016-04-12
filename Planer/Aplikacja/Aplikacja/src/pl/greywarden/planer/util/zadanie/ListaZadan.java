package pl.greywarden.planer.util.zadanie;

import java.util.*;

public class ListaZadan extends LinkedList<Zadanie>{
    
    public static final ListaZadan ZADANIA = new ListaZadan();
    
    private ListaZadan(){}
    
    public int znajdzIndeksZadaniaPoID(int identyfikator)
    {
        for(int i=0; i<this.size(); i++)
            if(this.get(i).getIdentyfikator()==identyfikator)
                return i;
        return -1;
    }
    @Override
    public boolean add(Zadanie z)
    {
        if (!this.stream().noneMatch((zadanie) -> (zadanie.getIdentyfikator() == z.getIdentyfikator()))) {
            return false;
        }
        super.add(z);
        return true;
    }
}