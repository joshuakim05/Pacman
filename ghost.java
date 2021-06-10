import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ghost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ghost extends Actor
{
    /**
     * Act - do whatever the ghost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private CollisionDetector north = new CollisionDetector();
    private CollisionDetector south = new CollisionDetector();
    private CollisionDetector east = new CollisionDetector();
    private CollisionDetector west = new CollisionDetector();
    private boolean createCollisionDetectors = true;
    
    public ghost(){
    
    }
    public void act() 
    {
        // Add your action code here.
        if (createCollisionDetectors){
            getWorld().addObject(north, getX(), getY() - getImage().getWidth() / 2);
            getWorld().addObject(south, getX(), getY() + getImage().getWidth() / 2);
            getWorld().addObject(east, getX() +getImage().getWidth() / 2, getY());
            getWorld().addObject(west, getX() - getImage().getWidth() / 2, getY());
            createCollisionDetectors = false;
        }
        
        updateCollisionDetectors();
        
    }    
    
    private void updateCollisionDetectors(){
        
        north.setLocation(getX(), getY() - getImage().getWidth() / 2);
        south.setLocation(getX(), getY() + getImage().getWidth() / 2);
        east.setLocation(getX() + getImage().getWidth() / 2, getY());
        west.setLocation(getX() - getImage().getWidth() / 2, getY());
    }
}
