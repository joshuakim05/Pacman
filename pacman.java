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
    private CollisionDetector north = new CollisionDetector();
    private CollisionDetector south = new CollisionDetector();
    private CollisionDetector east = new CollisionDetector();
    private CollisionDetector west = new CollisionDetector();
    private boolean createCollisionDetectors = true;
    public Pacman(){
        image1 = new GreenfootImage("Pac-Man.png");
        image2 = new GreenfootImage("pacman-solid.png");
        
        image1 = new GreenfootImage("Pac-Man-test.png");
        image2 = new GreenfootImage("pacman-solid-test.png");
        timeTillSwitch = 30;
        north.setLocation(0, 0);
        
    }
    
    public void act() 
    {
        if (createCollisionDetectors){
            getWorld().addObject(north, getX(), getY() - getImage().getWidth() / 2);
            getWorld().addObject(south, getX(), getY() + getImage().getWidth() / 2);
            getWorld().addObject(east, getX() +getImage().getWidth() / 2, getY());
            getWorld().addObject(west, getX() - getImage().getWidth() / 2, getY());
            createCollisionDetectors = false;
        }
        updateCollisionDetectors();
        
        
        
        up();
        changeImage();
        
        
        if (direction == 1 && !north.intersectingBorder()){
            //move up
            
            
            setLocation(getX(), getY()-3);
        } else if (direction == 2 && !south.intersectingBorder()){
            //down
            setLocation(getX(), getY()+3);
        } else if (direction == 3 && !west.intersectingBorder()){
            //left
            if (west.intersectingTeleportWall()){
                setLocation(getWorld().getWidth() - 30, getY());
                return;
            }
            
            setLocation(getX()-3, getY());
            
        } else if (direction == 4 && !east.intersectingBorder()){
            //right
            
            if (east.intersectingTeleportWall()){
                setLocation(30, getY());
                return;
            }
            setLocation(getX()+3, getY());
            
            
        }
        
        
    }    
    
    private void up(){
        
        
        //moves left and does not let off screen
        if(Greenfoot.isKeyDown("up")){
            
            if (north.intersectingBorder()){
                return;
            }
            //setLocation(getX(), getY()-3);
            turnTowards(getX(), 0);
            direction = 1;
        }else{
            down();
        }
    }
    
    private void down(){
        
        
        if(Greenfoot.isKeyDown("down")){
            
            if (south.intersectingBorder()){
                return;
            }
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
            if (west.intersectingBorder()){
                west.setLocation(getX() - 30, getY());
                return;
            }
            
            
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
            if (east.intersectingBorder()){
                return;
            }
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
    
    private void updateCollisionDetectors(){
        
        north.setLocation(getX(), getY() - getImage().getWidth() / 2);
        south.setLocation(getX(), getY() + getImage().getWidth() / 2);
        east.setLocation(getX() + getImage().getWidth() / 2, getY());
        west.setLocation(getX() - getImage().getWidth() / 2, getY());
    }
    
    
}
