import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Collision_Detector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CollisionDetector extends Actor
{
    /**
     * Act - do whatever the Collision_Detector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public boolean intersectingBorder(){
        //return (getObjectsInRange(getImage().getWidth(), Border.class).size() > 0);
        
        
        return(isTouching(Border.class));
    }
    
    
    
    public boolean intersectingTeleportWall(){
        return (isTouching(TeleportWall.class));
    }
}
