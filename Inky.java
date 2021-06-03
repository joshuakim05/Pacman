import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Inky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inky extends ghost
{
    private int x;
    private int y;
    private int rotx;
    private int roty;
    public void act() 
    {
        move();
    }  
    
    public void move(){
        List<Pacman> pm = getObjectsInRange(1000, Pacman.class);
        for(Pacman p: pm){
            if (p.getRotation() == 90){
                roty = -75;
                rotx=0;
            }else if (p.getRotation() == 180){
                rotx = -75;
                roty=0;
            }else if (p.getRotation() == 270){
                roty = 75;
                rotx=0;
            }else{
                rotx = 75;
                roty=0;
            }
            
            if(p.getX()+rotx> getX()){
                x = 4;
            } else{
                x = -4;
            }
            if(p.getY()-roty< getY()){
                y = -4;
            } else{
                y = 4;
            }
            setLocation(getX()+x, getY()+y);
        }
        
    }   
}
