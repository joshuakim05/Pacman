import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; 
/**
 * Write a description of class Clyde here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clyde extends ghost
{
    private int x;
    private int y;
    
    public Clyde(){
    
    }
    /**
     * Act - do whatever the Clyde wants to do. This method is calle( whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      if(isTouching(teleportPointLeft.class)){
          setLocation(600, getY());
      }else if(isTouching(teleportPointRight.class)){
          setLocation(44, getY());
      }
      List<Pacman> pm = getObjectsInRange(3000, Pacman.class);
      for(Pacman p: pm){
          if(Math.abs(getX()-p.getX())<30&&Math.abs(getY()-p.getY())<30){
              close();
          }else{
              far();
          }
          if(isTouching(topBoundry.class)){
              setLocation(getX(), 24);
              if(p.getX()>getX()){
                  x=4;
              }else{
                  x=-4;
              }
          }
          if(isTouching(bottomBoundry.class)){
              setLocation(getX(), 568);
              if(p.getX()>getX()){
                  x=4;
              }else{
                  x=-4;
              }
          }
          if(isTouching(leftBoundry.class)){
              setLocation(getY(), 24);
              if(p.getY()>getY()){
                  y=4;
              }else{
                  y=-4;
              }
          }
          if(isTouching(rightBoundry.class)){
              setLocation(getY(), 620);
              if(p.getY()>getY()){
                  y=4;
              }else{
                  y=-4;
              }
          }
      }
      move();
    }
       
    
    public void move(){
        List<Pacman> pm = getObjectsInRange(3000, Pacman.class);
        for(Pacman p: pm){
            if(Math.abs(getX()-p.getX())<=84 && Math.abs(getY()-p.getY())<=84){
                x = -x;
                y = -y;
            }
        }
        setLocation(getX()+x, getY()+y);
        /*
        public void move(){
        List<Pacman> pm = getObjectsInRange(3000, Pacman.class);
        for(Pacman p: pm){
            if(Math.abs(getX()-p.getX())<=150 && Math.abs(getY()-p.getY())<150){
                x = -x;
                y = -y;
            }else{
                if (p.getX()>getX()){
                    x = 4;
                } else{
                    x=-4;
                }
                if(p.getY()< getY()){
                    y = -4;
                } else{
                    y = 4;
                }
                setLocation(getX()+x, getY()+y);
            }
        }
    }
        */
    }
    
    public void far(){
        List<Pacman> pm = getObjectsInRange(3000, Pacman.class);
        for(Pacman p: pm){
            if (isTouching(bottmLeftTP.class)){
                if(getX()-p.getX()>p.getY()-getY()){
                    x = -4;
                    y = 0;
                }else{
                    y = 4;
                    x = 0;
                }
            }
                if (isTouching(bottomLeftRightTP.class)){
                    if(Math.abs(getX()-p.getX())>p.getY()-getY()){
                        if (getX()>p.getX()){
                            x = -4;
                        }else{
                            x = 4;
                        }
                        y = 0;
                    }else{
                        y = 4;
                        x = 0;
                    }
                }
                if (isTouching(bottomRightTP.class)){
                    if(p.getX()-getX()>p.getY()-getY()){
                        x = 4;
                        y = 0;
                    }else{
                        y = 4;
                        x = 0;
                    }
                }
                if (isTouching(topBottomRightTP.class)){
                    if(p.getX()-getX()>Math.abs(p.getY()-getY())){
                        x = 4;
                        y = 0;
                    }else{
                        if (getY()>p.getY()){
                            y = -4;
                        }else{
                            y= 4;
                        }  
                        x = 0;            
                    }
                }
                if (isTouching(topBottomLeftRightTP.class)){
                    if(Math.abs(getX()-p.getX())>Math.abs(getY()- p.getY())){
                        if (getX()>p.getX()){
                            x = -4;
                        }else{
                            x= 4;
                        } 
                        y = 0;
                    }else{
                        if (getY()>p.getY()){
                            y = -4;
                        }else{
                            y= 4;
                        } 
                        x = 0;
                    }
                }
                if (isTouching(topBottomLeftTP.class)){
                    if(getX()-p.getX()>Math.abs(getY()- p.getY())){
                        x = -4;
                        y = 0;
                    }else{
                        if (getY()>p.getY()){
                            y = -4;
                        }else{
                            y= 4;
                        } 
                        x = 0;
                    }
                }
                if (isTouching(topLeftRight.class)){
                    if(Math.abs(getX()-p.getX())>getY()- p.getY()){
                        if (getX()>p.getX()){
                            x = -4;
                        }else{
                            x= 4;
                        } 
                        y = 0;
                    }else{
                        y = -4;
                        x = 0;
                    }
                }
                if (isTouching(topLeftTP.class)){
                    if(getX()-p.getX()>getY()- p.getY()){
                        x= -4;
                        y = 0;
                    }else{
                        y = -4;
                        x = 0;
                    }
                }
                if (isTouching(topRightTP.class)){
                    if(p.getX()-getX()>getY()- p.getY()){
                        x= 4;
                        y = 0;
                    }else{
                        y = -4;
                        x = 0;
                    }
                }         
        }
    }
    public void close(){
        List<Pacman> pm = getObjectsInRange(3000, Pacman.class);
        for(Pacman p: pm){
            if (isTouching(bottmLeftTP.class)){
                if(p.getX()-getX()<p.getY()-getY()){
                    x = -4;
                    y = 0;
                }else{
                    y = 4;
                    x = 0;
                }
            }
            if (isTouching(bottomLeftRightTP.class)){
                if(Math.abs(getX()-p.getX())<p.getY()-getY()){
                    if (getX()>p.getX()){
                        x = -4;
                    }else{
                        x = 4;
                    }
                    y = 0;
                }else{
                    y = 4;
                    x = 0;
                }
            }
            if (isTouching(bottomRightTP.class)){
                if(getX()-p.getX()< p.getY()-getY()){
                    x = 4;
                    y = 0;
                }else{
                    y = 4;
                    x = 0;
                }
            }
            if (isTouching(topBottomRightTP.class)){
                if(getX()-p.getX()< Math.abs(p.getY()-getY())){
                    x = 4;
                    y = 0;
                }else{
                    if (getY()>p.getY()){
                        y = -4;
                    }else{
                        y= 4;
                    }  
                    x = 0;            
                }
            }
            if (isTouching(topBottomLeftRightTP.class)){
                if(Math.abs(getX()-p.getX())<Math.abs(getY()- p.getY())){
                    if (getX()>p.getX()){
                        x = -4;
                    }else{
                        x= 4;
                    } 
                    y = 0;
                }else{
                    if (getY()<p.getY()){
                        y = -4;
                    }else{
                        y= 4;
                    } 
                    x = 0;
                }
            }
            if (isTouching(topBottomLeftTP.class)){
                if(p.getX()-getX()<Math.abs(getY()- p.getY())){
                    x = -4;
                    y = 0;
                }else{
                    if (getY()<p.getY()){
                        y = -4;
                    }else{
                        y= 4;
                    } 
                    x = 0;
                }
            }
            if (isTouching(topLeftRight.class)){
                if(Math.abs(getX()-p.getX())<getY()- p.getY()){
                    if (getX()>p.getX()){
                        x = -4;
                    }else{
                        x= 4;
                    } 
                    y = 0;
                }else{
                    y = -4;
                    x = 0;
                }
            }
            if (isTouching(topLeftTP.class)){
                if(p.getX()-getX()<getY()- p.getY()){
                    x= -4;
                    y = 0;
                }else{
                    y = -4;
                    x = 0;
                }
            }
            if (isTouching(topRightTP.class)){
                if(getX()-p.getX()<getY()- p.getY()){
                    x= 4;
                    y = 0;
                }else{
                    y = -4;
                    x = 0;
                }
            }
        }
    }
}
