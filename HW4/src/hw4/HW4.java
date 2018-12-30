/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;


/**
 *
 * @author jeremy
 */
public class HW4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Star> baseStars = new ArrayList<Star>();
        parser(baseStars);
        
        Star CWS; //currently working star
        Queue<Star> order = new LinkedList<>(); //needed data for preducing a queue
        
        order.add(baseStars.get(0)); //block adds sol to order and sets up next nearest star as CWS 
        baseStars.remove(0);
        order.add(baseStars.get(0));
        CWS = baseStars.get(0);
        baseStars.remove(0);
        double distanceTotal = 0;
        int size = baseStars.size(); //needs to be fixed for this to work
        
        for (int j = 0; j < size; j++) //places all stars into order and claculates there distances O(n^2)
        {
            for (int i = 0; i < baseStars.size(); i++)
            {
                baseStars.get(i).distanceCalc(CWS);
                
            }
            Collections.sort(baseStars, new SortByDistance());
            order.add(baseStars.get(0));
            CWS = baseStars.get(0);
            baseStars.remove(0);
        }
        
        while (!(order.isEmpty())) //prints results. is distructive 
        {
            distanceTotal += order.peek().distance;
            if (order.peek().name.isEmpty())
            {
                System.out.println("Number of Star: "  + order.peek().number + " Diastance added: " + order.peek().distance );
            }
            else
            {
                System.out.println("Name of Star: "  + order.peek().name + " Diastance added: " + order.peek().distance );
            }
            order.remove();
        }
        System.out.println("Diastance of path: " + distanceTotal);
            
        
    }
    
    //based on https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
    public static void parser(ArrayList<Star> theStars)
    {
        String csvFile = "hygxyz.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        
        String name;
        String number;
        double distFloat = 0;
        double xFloat = 0;
        double yFloat = 0;
        double zFloat = 0;
        
        Star tempStar;
        SortByDistance readin = new SortByDistance();
        
        int count = 0;
        ArrayList testints = new ArrayList();
        testints.add(1);
        testints.add(50);
        testints.add(6);
        
        
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] nextStar = line.split(cvsSplitBy);

               // System.out.println("Star ID : "+ nextStar[0]+" distance :" + nextStar[9]);
                
                distFloat = Float.parseFloat(nextStar[9]);
                if (distFloat <= 10)
                {
                   //System.out.println("Star ID : "+ nextStar[0]+" distance :" + nextStar[9]+ " xpos : "+ nextStar[17] ); 
                   
                   count++;
                   xFloat = Float.parseFloat(nextStar[17]);
                   yFloat = Float.parseFloat(nextStar[18]);
                   zFloat = Float.parseFloat(nextStar[19]);
                   
                   if (nextStar[6].isEmpty()){
                       tempStar = new Star(nextStar[0],distFloat,xFloat,yFloat,zFloat);
                   }
                   
                   else{
                       tempStar = new Star(nextStar[0],nextStar[6],distFloat,xFloat,yFloat,zFloat);
                   }
                   
                  theStars.add(tempStar);
                }

            }
            System.out.println(count);
            Collections.sort(theStars, new SortByDistance());
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
