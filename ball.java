//small points scattered across board
import greenfoot.*;
import java.util.*;
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
            List<Pacman> pm = world.getObjects(Pacman.class);
            Pacman pacman = pm.get(0);
            if (pacman.getChompTimer() == 0){
                Greenfoot.playSound("pacman_chomp.wav");
                pacman.setChompTimer(4);
            } else {
                pacman.setChompTimer(pacman.getChompTimer() - 1);
            }
        }
        
    }
    
    
}
