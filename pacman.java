import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
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
    public int x;
    public int y;
    private CollisionDetectorWide north = new CollisionDetectorWide();
    private CollisionDetectorWide south = new CollisionDetectorWide();
    private CollisionDetectorLong east = new CollisionDetectorLong();
    private CollisionDetectorLong west = new CollisionDetectorLong();
    private boolean createCollisionDetectors = true;
    private int previousX = 323;
    private int previousY = 450;
    public Pacman(){
        image1 = new GreenfootImage("Pac-Man-test.png");
        image2 = new GreenfootImage("pacman-solid-test.png");
        
        //image1 = new GreenfootImage("Pac-Man-test.png");
        //image2 = new GreenfootImage("pacman-solid-test.png");
        timeTillSwitch = 30;
        north.setLocation(0, 0);
        
    }
    
    public int getDirection(){
        return direction;
    }
    
    public void act() 
    {

        if(isTouching(teleportPointLeft.class)){
            setLocation(600, getY());
        }else if(isTouching(teleportPointRight.class)){
            setLocation(44, getY());
        }
        
        if (createCollisionDetectors){
            getWorld().addObject(north, getX(), getY() - getImage().getWidth() / 2);
            getWorld().addObject(south, getX(), getY() + getImage().getWidth() / 2);
            getWorld().addObject(east, getX() +getImage().getWidth() / 2, getY());
            getWorld().addObject(west, getX() - getImage().getWidth() / 2, getY());
            createCollisionDetectors = false;
        }
        
        
        updateCollisionDetectors();
        up();
        

        
        if (direction == 1 && !north.intersectingBorder()){
            //move up
            
            for (int i = 0; i < 10; i++){
                changeImage();
            }
            setLocation(getX(), getY()-3);
        } else if (direction == 2 && !south.intersectingBorder()){
            //down
            for (int i = 0; i < 10; i++){
                changeImage();
            }
            setLocation(getX(), getY()+3);
        } else if (direction == 3 && !west.intersectingBorder()){
            //left
            
            if (west.intersectingTeleportWall()){
                setLocation(getWorld().getWidth() - 30, getY());
                return;
            }
            for (int i = 0; i < 10; i++){
                changeImage();
            }
            setLocation(getX()-3, getY());
            
        } else if (direction == 4 && !east.intersectingBorder()){
            //right
            
            
            if (east.intersectingTeleportWall()){
                setLocation(30, getY());
                return;
            }
            for (int i = 0; i < 10; i++){
                changeImage();
            }
            setLocation(getX()+3, getY());
            
            
        }
        // move();
        
        //setLocation(getX()+x, getY()+y);
        previousX = getX();
        previousY = getY();
        
        
    }    
    
    private void up(){
        
        
        //moves left and does not let off screen
        if(Greenfoot.isKeyDown("up")){
            
            
            
            if (direction == 1){
                return;
            }
            //setLocation(getX(), getY()-3);
            
            //snap to nearest turnpoint
            //turnPoint nearest;
            //for (turnPoint tp : getObjectsInRange(35, turnPoint.class)){
            //    if (direction == 3){
                    //left
            //        if (tp.getX() <= getX()){
                        
            //        }
            //    }
            //}
            
            //find nearest turn point
            
            boolean done = false;
            
            if (direction != 2){
                
                
          
                for (PacmanTurnPoint ptp: getObjectsInRange(20, PacmanTurnPoint.class)){
                    if (done == false){
                        setLocation(ptp.getX(), ptp.getY());
                        
                        done = true;
                        
                    }
                    
                }
                
           
                for (turnPoint tp: getObjectsInRange(12, turnPoint.class)){
                    if (done == false){
                        setLocation(tp.getX(), tp.getY());
                        done = true;
                        
                    }
                    
                    
                
                }

               
            }
            
            if (north.intersectingBorder()){
                return;
                
            }
            
            turnTowards(getX(), 0);
            direction = 1;
            
            
        }else{
            down();
        }
    }
    
    private void down(){
        
        
        if(Greenfoot.isKeyDown("down")){
            
            if (direction == 2){
                return;
            }
            
            if (south.intersectingBorder()){
                return;
            }
            
            turnPoint nearest;
            boolean done = false;
            
            if (direction != 1){
                
                for (PacmanTurnPoint ptp: getObjectsInRange(20, PacmanTurnPoint.class)){
                    if (!done){
                        setLocation(ptp.getX(), ptp.getY());
                        done = true;
                    }
                }
                
                
                for (turnPoint tp: getObjectsInRange(12, turnPoint.class)){
                    if (!done){
                        setLocation(tp.getX(), tp.getY());
                        done = true;
                    }
                
                }

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
            
            if (direction == 3){
                return;
            }
            if (west.intersectingBorder()){
                west.setLocation(getX() - 30, getY());
                return;
            }
            turnPoint nearest;
            boolean done = false;
            
            if (direction != 4){
                
                for (PacmanTurnPoint ptp: getObjectsInRange(20, PacmanTurnPoint.class)){
                    if (!done){
                        setLocation(ptp.getX(), ptp.getY());
                        done = true;
                    }
                }
                for (turnPoint tp: getObjectsInRange(12, turnPoint.class)){
                    if (!done){
                        setLocation(tp.getX(), tp.getY());
                        done = true;
                    }
                
                }
                
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
            
            if (direction == 4){
                return;
            }
            if (east.intersectingBorder()){
                return;
            }
            
            turnPoint nearest;
            boolean done = false;
            
            if (direction != 3){
                for (PacmanTurnPoint ptp: getObjectsInRange(20, PacmanTurnPoint.class)){
                    if (!done){
                        setLocation(ptp.getX(), ptp.getY());
                        done = true;
                    }
                }
                for (turnPoint tp: getObjectsInRange(12, turnPoint.class)){
                    if (!done){
                        setLocation(tp.getX(), tp.getY());
                        done = true;
                    }
                
                }
                
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
    
    // private void move(){
    //         if (isTouching(pacmanStart.class)){
    //             if(Greenfoot.isKeyDown("left")){
    //                 x = -3;
    //                 y = 0;
    //                 turnTowards(0, getY());
                    
    //             }else if(Greenfoot.isKeyDown("right")){
    //                 y = 0;
    //                 x = 3;
    //                 turnTowards(645, getY());
    //             }
    //             setLocation(getX(), getOneIntersectingObject(turnPoint.class).getY());
    //         }
    //         if (isTouching(leftRight.class)){
    //             if(Greenfoot.isKeyDown("left")){
    //                 x = -3;
    //                 y = 0;
    //                 turnTowards(0, getY());
    //             }else if(Greenfoot.isKeyDown("right")){
    //                 y = 0;
    //                 x = 3;
    //                 turnTowards(645, getY());
    //             }
    //             setLocation(getX(), getOneIntersectingObject(turnPoint.class).getY());
    //         }
    //         if (isTouching(bottmLeftTP.class)){
    //             if(Greenfoot.isKeyDown("left")){
    //                 x = -3;
    //                 y = 0;
    //                 turnTowards(0, getY());
    //                 setLocation(getX(), getOneIntersectingObject(turnPoint.class).getY());
    //             }else if(Greenfoot.isKeyDown("down")){
    //                 y = 4;
    //                 x = 0;
    //                 turnTowards(getX(), 650);
    //                 setLocation(getOneIntersectingObject(turnPoint.class).getX(),getY());
    //             }
    //         }
    //         if (isTouching(bottomLeftRightTP.class)){
    //             if(!Greenfoot.isKeyDown("down")){
    //                 if (Greenfoot.isKeyDown("left")){
    //                     x = -3;
    //                     turnTowards(0, getY());
                        
    //                 }else if(Greenfoot.isKeyDown("right")){
    //                     x = 3;
    //                     turnTowards(645, getY());
    //                 }
    //                 y = 0;
    //                 setLocation(getX(), getOneIntersectingObject(turnPoint.class).getY());
    //             }else if (Greenfoot.isKeyDown("down")){
    //                 y = 4;
    //                 x = 0;
    //                 turnTowards(getX(), 650);
    //                 setLocation(getOneIntersectingObject(turnPoint.class).getX(),getY());
    //             }
                
    //         }
    //         if (isTouching(bottomRightTP.class)){
    //             if(Greenfoot.isKeyDown("right")){
    //                 x = 3;
    //                 y = 0;
    //                 turnTowards(645, getY());
    //                 setLocation(getX(), getOneIntersectingObject(turnPoint.class).getY());
    //             }else if(Greenfoot.isKeyDown("down")){
    //                 y = 4;
    //                 x = 0;
    //                 turnTowards(getX(), 650);
    //                 setLocation(getOneIntersectingObject(turnPoint.class).getX(),getY());
    //             }
    //         }
    //         if (isTouching(topBottomRightTP.class)){
    //             if(Greenfoot.isKeyDown("right")){
    //                 x = 3;
    //                 y = 0;turnTowards(645, getY());
    //                 setLocation(getX(), getOneIntersectingObject(turnPoint.class).getY());
    //             }else{
    //                 if (Greenfoot.isKeyDown("up")){
    //                     y = -4;
    //                     turnTowards(getX(), 0);
    //                 }else if (Greenfoot.isKeyDown("down")){
    //                     y= 4;
    //                     turnTowards(getX(), 650);
    //                 }  
    //                 x = 0;
    //                 setLocation(getOneIntersectingObject(turnPoint.class).getX(),getY());            
    //             }
    //         }
    //         if (isTouching(topBottomLeftRightTP.class)){
    //             if(Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("left")){
    //                 if (Greenfoot.isKeyDown("left")){
    //                     x = -3;
    //                     turnTowards(0, getY());
    //                 }else if (Greenfoot.isKeyDown("right")){
    //                     x= 4;
    //                     turnTowards(650, getY());
    //                 } 
    //                 y = 0;
    //                 setLocation(getX(), getOneIntersectingObject(turnPoint.class).getY());
    //             }else{
    //                 if (Greenfoot.isKeyDown("up")){
    //                     y = -4;
    //                     turnTowards(getX(), 0);
    //                 }else if (Greenfoot.isKeyDown("down")){
    //                     y= 4;
    //                     turnTowards(getX(), 650);
    //                 } 
    //                 x = 0;
    //                 setLocation(getOneIntersectingObject(turnPoint.class).getX(), getY());
    //             }                
    //         }
    //         if (isTouching(topBottomLeftTP.class)){
    //             if(Greenfoot.isKeyDown("left")){
    //                 x = -3;
    //                 y = 0;
    //                 turnTowards(0, getY());
    //                 setLocation(getX(), getOneIntersectingObject(turnPoint.class).getY());
    //             }else{
    //                 if (Greenfoot.isKeyDown("up")){
    //                     y = -4;
    //                     turnTowards(getX(), 0);
    //                 }else if (Greenfoot.isKeyDown("down")){
    //                     y= 4;
    //                     turnTowards(getX(), 650);
    //                 } 
    //                 x = 0;
    //                 setLocation(getOneIntersectingObject(turnPoint.class).getX(), getY());
    //             } 
    //         }
    //         if (isTouching(topLeftRight.class)){
    //             if(!Greenfoot.isKeyDown("up")){
    //                 if (Greenfoot.isKeyDown("left")){
    //                     x = -3;
    //                     turnTowards(0, getY());
    //                 }else if(Greenfoot.isKeyDown("right")){
    //                     x= 4;
    //                     turnTowards(650, getY());
    //                 } 
    //                 y = 0;
    //                 setLocation(getX(), getOneIntersectingObject(turnPoint.class).getY());
    //             }else if (Greenfoot.isKeyDown("up")){
    //                 y = -4;
    //                 x = 0;
    //                 turnTowards(getX(), 0);
    //                 setLocation(getOneIntersectingObject(turnPoint.class).getX(), getY());
    //             }
    //         }
    //         if (isTouching(topLeftTP.class)){
    //             if(Greenfoot.isKeyDown("left")){
    //                 x= -4;
    //                 y = 0;
    //                 turnTowards(0, getY());
    //                 setLocation(getX(), getOneIntersectingObject(turnPoint.class).getY());
    //             }else if (Greenfoot.isKeyDown("up")){
    //                 y = -4;
    //                 x = 0;
    //                 turnTowards(getX(), 0);
    //                 setLocation(getOneIntersectingObject(turnPoint.class).getX(), getY());
    //             }
    //         }
    //         if (isTouching(topRightTP.class)){
    //             if(Greenfoot.isKeyDown("right")){
    //                 x= 4;
    //                 y = 0;
    //                 turnTowards(645, getY());
    //                 setLocation(getX(), getOneIntersectingObject(turnPoint.class).getY());
    //             }else if (Greenfoot.isKeyDown("up")){
    //                 y = -4;
    //                 x = 0;
    //                 turnTowards(getX(), 0);
    //                 setLocation(getOneIntersectingObject(turnPoint.class).getX(), getY());
    //             }
    //         }
    // }
}
