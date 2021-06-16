//large orbs which allow pacman to consume ghosts
import greenfoot.*;
public class bigBall extends Actor
{
    
    public void act(){
        eatBigPellet();
    }
    
    private void eatBigPellet(){
        MyWorld world = (MyWorld) getWorld();
        if(getObjectsInRange(12, Pacman.class).size() > 0){
            //Greenfoot.playSound("eat_pellet.wav");
            world.addScore(50);
            world.removeObject(this);
            world.setPowerPellet(true);
            world.resetPowerTimer();
        }
        
    }
}
