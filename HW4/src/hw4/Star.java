/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;

/**
 *
 * @author jeremy
 */
public class Star {
    
    public int number;
     public String name;
     public float distance;
     public float xPosition;
     public float yPosition;
     public float zPosition;
    
    public Star (int thenum, String thename, float dist, float x, float y,float z)
    {
        number = thenum;
        name = thename;
        distance = dist;
        xPosition = x;
        yPosition = y;
        zPosition = z;
    }
    
    public Star (int thenum, float dist, float x, float y,float z)
    {
        number = thenum;
        distance = dist;
        xPosition = x;
        yPosition = y;
        zPosition = z;
    }
    
    
}
