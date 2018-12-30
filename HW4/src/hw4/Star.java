/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;

import java.util.Comparator;

/**
 *
 * @author jeremy
 */
public class Star {
    // data
     public String number = ""; // used fo string.isEmpty
     public String name = "";
     public double distance;
     public double xPosition;
     public double yPosition;
     public double zPosition;
    
     //constructors
     
    public Star (String thenum, String thename, double dist, double x, double y,double z)
    {
        number = thenum;
        name = thename;
        distance = dist;
        xPosition = x;
        yPosition = y;
        zPosition = z;
    }
    
    public Star (String thenum, double dist, double x, double y,double z)
    {
        number = thenum;
        distance = dist;
        xPosition = x;
        yPosition = y;
        zPosition = z;
    }
    
    public void distanceCalc (Star CWS) //implimtation of the 3d distance formula
    {//CWS = currently working star
        double diffX = (this.xPosition)-(CWS.xPosition);//abs value not needed because they will be squared
        double diffY = (this.yPosition)-(CWS.yPosition);
        double diffZ = (this.zPosition)-(CWS.zPosition);
        
        diffX = diffX*diffX;
        diffY = diffY*diffY;
        diffZ = diffZ*diffZ;
        
        double squSum = diffX+ diffY + diffZ;
        
        this.distance = Math.sqrt(squSum);
    }
    
    
}

class SortByDistance implements Comparator<Star> //this class allows one to use native java sort on ADT star  
{
    
    public int compare(Star a, Star b)
    {
        
        if(a.distance > b.distance){
            return 1;
        }
        
        else if (a.distance < b.distance)
        {
            return -1;
        }
        
        else{
            return 0;
        }
    }
    
}
