 
public class MyArrayList<E> 
{ 
    private int size; // Number of elements in the list
    private E[] data;
    /** Create an empty list */
    public MyArrayList() {
         data = (E[])new Object[100];// cannot create array of generics
         size = 0; // Number of elements in the list
    }
  
    public void add(int index, E e) {   
      // Ensure the index is in the right range
      if (index < 0 || index > size)
        throw new IndexOutOfBoundsException
          ("Index: " + index + ", Size: " + size); 
      // Move the elements to the right after the specified index
      for (int i = size - 1; i >= index; i--)
        data[i + 1] = data[i];
      // Insert new element to data[index]
      data[index] = e;
      // Increase size by 1
      size++;
    }

    public boolean contains(Object e) {
      for (int i = 0; i < size; i++)
        if (e.equals(data[i])) return true;
      return false;
    }

    public E get(int index) {
      if (index < 0 || index >= size)
        throw new IndexOutOfBoundsException
          ("Index: " + index + ", Size: " + size);
      return data[index];
    }
  
    public E remove(int index) {
      if (index < 0 || index >= size)
        throw new IndexOutOfBoundsException
          ("Index: " + index + ", Size: " + size);
      E e = data[index];
      // Shift data to the left
      for (int j = index; j < size - 1; j++)
        data[j] = data[j + 1];
      data[size - 1] = null; // This element is now null
      // Decrement size
      size--;
      return e;
    }

    public String toString() {
      String result=" ";
      for (int i = 0; i < size; i++) {
        result+= data[i];
        if (i < size - 1) result+=", ";
      }
      return result.toString() + "]";
    }

    public int size() {
      return size;
    }
  
    public boolean sortList() {
       E hold;
       for (int i = 0; i < size-1; i++)
        {
          for (int j = 0; j<size-1; j++)
           {        
            if(((Comparable)data[j]).compareTo(data[j+1])>0)
             {
              hold= data[j+1];
              data[j+1]=data[j];
              data[j]=hold;
             }       
          }
        } 
       return true;          
    }
   
    public MyArrayList <String> checkChar(String wordE, MyArrayList <Character> defaultWord)
    {
        MyArrayList <String> feedback = new MyArrayList<>();
        
        for(int i = 0; i <5; i++)
        {
            if(wordE.charAt(i) == defaultWord.get(i))
            {
                feedback.add(i, "A");// correct char at correct place
            }
            else
            {
                feedback.add(i, "C");//char doesn't exist
            }
        }
        
        for(int i = 0; i <5; i++)
        {
            for(int j = 0; j <5; j++)
            {
                if((wordE.charAt(i) == defaultWord.get(j)) && feedback.get(i) != "A")
                {
                    feedback.remove(i);
                    feedback.add(i, "B"); // correct char at wrong place
                }
            }
        }
        return feedback;
    }
    
    public String checkWin(MyArrayList <String> feedback, int count)
    {
        String message = "";
        for(int i = 0; i < 5; i++)
        {
            if((feedback.contains("B") || feedback.contains("C")) && count <4)
            {
                message = "Try again";
            }
            else if(count >= 4)
            {
                message = "You loose"; 
            }
            else
            {
                message = "You win";
            }
        }
        
        return message;
    }
}