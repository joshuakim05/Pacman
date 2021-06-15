//small points scattered across board
import greenfoot.*;
public class ball extends Actor
{
    
    public void act(){
        eatPellet();
    }
    
    private void eatPellet(){
        MyWorld world = (MyWorld) getWorld();
        if(getObjectsInRange(12, Pacman.class).size() > 0){
            //Greenfoot.playSound("eat_pellet.wav");
            world.addScore(10);
            world.removeObject(this);
            Greenfoot.playSound("pacman_chomp.wav");
        }
        
    }
    
}
