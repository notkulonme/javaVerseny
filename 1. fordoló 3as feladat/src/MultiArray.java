import java.util.ArrayList;

public class MultiArray {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public MultiArray()
    {
    }
    public void set(int index, int index2, int elem)
    {
        ArrayList<Integer> atmeneti = list.get(index);
        atmeneti.set(index2,elem);
        list.set(index,atmeneti);
    }
    public void add(int index, int elem)//add element to the array
    {
        //System.out.println("nem alma");
        if(index <= list.size()-1)
        {
            //System.out.println("alma");
            ArrayList<Integer> atmeneti = new ArrayList<>();
            atmeneti.add(elem);
            list.set(index, atmeneti);
            //System.out.println("elment added to the list");
        }
        else
        {
            for (int i = index;i >= list.size()-1;i--)
            {
                ArrayList<Integer> belsoLista = new ArrayList<>();
                list.add(belsoLista);
            }
            ArrayList<Integer> atmeneti2 = new ArrayList<>();
            atmeneti2.add(elem);
            list.set(index, atmeneti2);
            //System.out.println("elment added to the list");
        }
    }
    public void addArray(ArrayList<Integer> addableArray)
    {
        list.add(addableArray);
    }
    public int get(int index, int index2)//returns a specific element
    {
        return list.get(index).get(index2);
    }
    public int size()//returns the number of element from the array
    {
        return list.size();
    }
    public int length()//returns the number of indexes inside the array
    {
        return list.size()-1;
    }
    public ArrayList<Integer> getArray(int index)
    {
        return list.get(index);
    }
    public int innerArraySize(int index)
    {
        return list.get(index).size();
    }
}