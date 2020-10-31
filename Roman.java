import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
//imports needed to run the code
/**
 * The method getRoman and romanNum will take the RomanNumeral.txt and change the Roman numeral to arabic numeral
 * The method getArabic and arabicNum will take the RomanToArabicNumeral.txt and chang the numbers back to Roman Numerals
 *
 * Arnav Pawar
 * 12/17/18
 */
public class Roman
{
   public void getRoman()
   {//change the file
       try
       {
           Scanner input = new Scanner(new File("RomanNumeral.txt"));  
           //input
           BufferedWriter out= new BufferedWriter(new FileWriter("RomanToArabicNumeral.txt"));
           //output
           //calls the two text docs that will be used and changed
           String letter;
           while(input.hasNextLine())
           {
               letter = input.nextLine();
               if(letter.length()>0)
               {
                   int counter =romanNum(letter);
                   
                   out.write(Integer.toString(counter));
                   out.newLine();
               }
           }   
           
           input.close();
           out.close();
        }
        catch(IOException e)
        //if error is found then print this
        {
            System.out.println("File not found");
        }
   }
   public int romanNum(String line)
   {
       int counter=0;
       for(int i=0;i<line.length();i++)
       {
           char value = line.charAt(i);
           
           if(value=='I')
           {
               counter+=1;
           }
           else if(value=='V')
           {
               counter+=5;
           }
           else if(value=='X')
           {
               counter+=10;
           }
           else if(value=='L')
           {
               counter+=50;
           }
           else if(value=='C')
           {
               counter+=100;
           }
           else if(value=='D')
           {
               counter+=500;
           }
           else if(value=='M')
           {
               counter+=1000;
           }        
           else if(line.contains("IV"))
           {
               counter-=2;
            }
           else if(line.contains("IX"))
           {
               counter-=2;
           }
           else if(line.contains("XL"))
           {
               counter-=20;
           }
           else if(line.contains("XC"))
           {
               counter-=20;
           }
           else if(line.contains("CD"))
           {
               counter-=200;
           }
           else if(line.contains("CM"))
           {
               counter-=200;
           }
       }
       //returns the countere that was being changed for giving a numeral value to the strings
       return counter;
    }
    ////////////////////ARABIC/TO/ROMAN///////////////////////////
     public void getArabic()
     {        
        try
        {    
            Scanner in = new Scanner(new File("RomanToArabicNumeral.txt"));
            //input
            BufferedWriter out = new BufferedWriter(new FileWriter("ArabicToRoman.txt"));
            //output
            String line;
            while(in.hasNextLine())
            {
                line = in.nextLine();               
                if (line.length() > 0)
                {                    
                    String convertedLine;
                    convertedLine = arabicNum(line);
                    
                    out.write(convertedLine);
                    out.newLine();
                }
            }            
            in.close(); 
            out.close();}
        catch(IOException e)
        //if error is found then print this
        {
            System.out.println("File not found");           
        }
    }
     public String arabicNum(String line)
     {       
          int arabic = Integer.parseInt(line);
        //convets the string into an integer
        String roman ="";
        //creates a new string value which will hold the calue of the roman num
        //while loops for each digit of 10
        // subtracts once vaule is converted from total
  
       while(arabic >=1000){
       
            arabic -=1000;
            roman+="M";
        }
       while(arabic >=500){
           arabic -=500;
           roman +="D";
       }
       while(arabic >=100){
           arabic -=100;
           roman +="C";
       }
       while(arabic >=1000){
           arabic -=50;
           roman +="L";
       }
       while(arabic >=10){
           arabic -=10;
           roman+="X";
       }
       while(arabic>=5){
           arabic -=5;
           roman +="V";
       }
       while(arabic >=1){
           arabic -=1;
           roman+="I";
       }
        
       return roman;
    }

  }


