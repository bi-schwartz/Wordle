import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Test
{
   public static void main(String arg[])
    {
        System.out.print("\f");
        System.out.println("Feedback:");
        System.out.println("A - correct character at correct place");
        System.out.println("B - correct character at incorrect place");
        System.out.println("C - incorrect character\n");
        
     Scanner in = new Scanner(System.in);   
     
     //Create a new array list with default word.
     MyArrayList <Character> defaultWord = new MyArrayList<>();
     defaultWord.add(0, 'a');
     defaultWord.add(1, 'g');
     defaultWord.add(2, 'r');
     defaultWord.add(3, 'e');
     defaultWord.add(4, 'e');
     
     //Create a new array list to store returned list.
     MyArrayList <String> output = new MyArrayList<>();
     
     String wordE, wordFF; //Verables to store the word entered and the word from the list.
     File f1=new File("input.txt");   
     Boolean valid = false;
     for(int x=0;x<5;x++)//run 5 time user get 5 guesses.
       {
           System.out.println("\nGuess the five-letter word.");
           wordE = in.nextLine();
        if(wordE.length()==5) //Check if word entered is a 5 letter word.
          {
           try{ //Open the file to read the words in the list.
               FileReader fr = new FileReader(f1);
               BufferedReader br = new BufferedReader(fr);
               while((wordFF=br.readLine())!=null)
               {
                   if(wordFF.equals(wordE))//check if the word entered is in the list
                   {
                       valid = true;
                   }
               }

               if(valid)
               {                   
                //Call checkChar to check the validity of the chars and store the info.
                output = output.checkChar(wordE, defaultWord);
               }
           
               fr.close();
          }
          catch (IOException e) {
              System.out.println("File Read Error");
          } 
          
          }
          else valid = false; 
                 
        System.out.println("The entered word is a valid 5 letter word: " + valid); 
         
        if(valid)
        {
            //display the feedback of the entered word
            System.out.println(output.toString());
            //display the result of the feedback (Winner, Try again, Looser)
            System.out.println(output.checkWin(output, x));
            
            //Stop if user guessed correct word
            if(output.checkWin(output, x) == "You win")
            {
                break;
            }
            //Display correct word if user doesn't have any remaining guesses
            if(output.checkWin(output, x) == "You loose")
            {
                String stringWord = "";
                for(int i = 0; i < 5; i++)
                {
                    stringWord += defaultWord.get(i);
                }
                System.out.println("The correct word is: " + stringWord);
            }
        }
        valid = false;
        //output.clear();
       }
    }  
    
}
