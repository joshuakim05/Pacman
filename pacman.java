import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{
    /**
     * Act - do whatever the pacman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //https://gameinternals.com/understanding-pac-man-ghost-behavior
    private GreenfootImage image1;
    private GreenfootImage image2;
    private int timeTillSwitch;
    private int direction = 0;
    public Pacman(){
        image1 = new GreenfootImage("Pac-Man.png");
        image2 = new GreenfootImage("pacman-solid.png");
        timeTillSwitch = 30;
    }
    
    public void act() 
    {
        up();
        changeImage();
        if (direction == 1){
            //move up
            setLocation(getX(), getY()-3);
        } else if (direction == 2){
            //down
            setLocation(getX(), getY()+3);
        } else if (direction == 3){
            //left
            setLocation(getX()-3, getY());
        } else if (direction == 4){
            //right
            setLocation(getX()+3, getY());
        }
    }    
    
    private void up(){
        //moves left and does not let off screen
        if(Greenfoot.isKeyDown("up")){
            //setLocation(getX(), getY()-3);
            turnTowards(getX(), 0);
            direction = 1;
        }else{
            down();
        }
    }
    
    private void down(){
        if(Greenfoot.isKeyDown("down")){
            //setLocation(getX(), getY()+3);
            turnTowards(getX(), getWorld().getHeight());
            direction = 2;
        }else{
            left();
        }
    }
    
    private void left(){
        //moves left and does not let off screen
        if(Greenfoot.isKeyDown("left")){
            //setLocation(getX()-3, getY());
            turnTowards(0, getY());
            direction = 3;
        }else{
            right();
        }
    }
    
    private void right(){
        //moves right and does not let off screen
        if(Greenfoot.isKeyDown("right")){
            //setLocation(getX()+3, getY());
            turnTowards(getWorld().getWidth(), getY());
            direction = 4;
        }
    }
    private void changeImage(){
        if (timeTillSwitch == 0){
            if(getImage() == image1){
                setImage(image2);
            } else{
                setImage(image1);
            }
            timeTillSwitch=30;
        }
        timeTillSwitch--;
    }
}
