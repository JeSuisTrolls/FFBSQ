package Model.Classes.Autres;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Outils {
	
	public static String[] sort(String[] t)
	{
		LinkedList<String> l = new LinkedList<>(Arrays.asList(t));
        Collections.sort(l);
        t = l.toArray(new String[0]);
        
        return t;
	}
	
	/*
	 * Transforme un LinkedList en tableau de chaines
	 */
	public static String[] LinkedListToArray(LinkedList<String> lkdList)
	{
		// Conversion de la LinkedList<String> en tableau de String
        String[] array = lkdList.toArray(new String[0]);
        
        return array;
	}
	
	/*
	 * Transforme un ArrayList en tableau de chaines
	 */
	public static String[] ArrayListToArray(ArrayList<String> arrayList)
	{
		// Conversion de la LinkedList<String> en tableau de String
        String[] array = arrayList.toArray(new String[0]);
        
        return array;
	}

}
