import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Blinky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blinky extends ghost
{
    //top right
    public int x;
    public int y;
    public int countdown = 30;
    public int scatter = 400;
    public int targetx;
    public int targety;
    public Blinky(){
    
    }
    /**
     * Act - do whatever the Blinky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      
      catchPacman();
      
      if(isTouching(teleportPointLeft.class)){
          setLocation(600, getY());
      }else if(isTouching(teleportPointRight.class)){
          setLocation(44, getY());
      }
      List<Pacman> pm = getObjectsInRange(3000, Pacman.class);
      for(Pacman p: pm){
          if(scatter <=400 && scatter>200||scatter<=-200&&scatter>-400||scatter<=-800&&scatter>-950||scatter<=-1350&&scatter>-1500){
              targetx = 620;
              targety = 24;
            }else{
                targetx = p.getX();
                targety = p.getY();
            }
          if(Math.abs(getX()-targetx)<30&&Math.abs(getY()-targety)<30){
               close();
            }else{
                far();
            }
          if (isTouching(GhostStart.class)){
                if(getX()>targetx){
                    x = -4;
                    y = 0;
                }else{
                    y = 0;
                    x = 4;
                }
          }
          if(isTouching(topBoundry.class)){
              setLocation(getX(), 24);
              if(p.getX()>getX()){
                  x=4;
              }else{
                  x=-4;
              }
              y = 0;
          }
          if(isTouching(bottomBoundry.class)){
              setLocation(getX(), 568);
              if(targetx>getX()){
                  x=4;
              }else{
                  x=-4;
              }
              y = 0;
          }
          if(isTouching(leftBoundry.class)){
              setLocation(24, getY());
              if(p.getY()>getY()){
                  y=4;
              }else{
                  y=-4;
              }
              x = 0;
          }
          if(isTouching(rightBoundry.class)){
              setLocation(620, getY());
              if(targetx>getY()){
                  y=4;
              }else{
                  y=-4;
              }
              x = 0;
          }
          scatter--;
        }
        setLocation(getX()+x, getY()+y);
        countdown--;
        if (countdown == 0){
            setLocation(322, 224);
        }
    }
    
    public void far(){
        List<Pacman> pm = getObjectsInRange(3000, Pacman.class);
        for(Pacman p: pm){
            if (isTouching(bottmLeftTP.class)){
                if(getX()-targetx>targety-getY()){
                    x = -4;
                    y = 0;
                }else{
                    y = 4;
                    x = 0;
                }
            }
                if (isTouching(bottomLeftRightTP.class)){
                    if(Math.abs(getX()-targetx)>targety-getY()){
                        if (getX()>targetx){
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
                    if(targetx-getX()>targety-getY()){
                        x = 4;
                        y = 0;
                    }else{
                        y = 4;
                        x = 0;
                    }
                }
                if (isTouching(topBottomRightTP.class)){
                    if(targetx-getX()>Math.abs(targety-getY())){
                        x = 4;
                        y = 0;
                    }else{
                        if (getY()>targety){
                            y = -4;
                        }else{
                            y= 4;
                        }  
                        x = 0;            
                    }
                }
                if (isTouching(topBottomLeftRightTP.class)){
                    if(Math.abs(getX()-targetx)>Math.abs(getY()- targety)){
                        if (getX()>targetx){
                            x = -4;
                        }else{
                            x= 4;
                        } 
                        y = 0;
                    }else{
                        if (getY()>targety){
                            y = -4;
                        }else{
                            y= 4;
                        } 
                        x = 0;
                    }
                }
                if (isTouching(topBottomLeftTP.class)){
                    if(getX()-targetx>Math.abs(getY()- targetx)){
                        x = -4;
                        y = 0;
                    }else{
                        if (getY()>targety){
                            y = -4;
                        }else{
                            y= 4;
                        } 
                        x = 0;
                    }
                }
                if (isTouching(topLeftRight.class)){
                    if(Math.abs(getX()-targetx)>getY()- targety){
                        if (getX()>targetx){
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
                    if(getX()-targetx>getY()- targety){
                        x= -4;
                        y = 0;
                    }else{
                        y = -4;
                        x = 0;
                    }
                }
                if (isTouching(topRightTP.class)){
                    if(targetx-getX()>getY()- targety){
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
                if(targetx-getX()<targety-getY()){
                    x = -4;
                    y = 0;
                }else{
                    y = 4;
                    x = 0;
                }
            }
            if (isTouching(bottomLeftRightTP.class)){
                if(Math.abs(getX()-targetx)<targety-getY()){
                    if (getX()>targetx){
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
                if(getX()-targetx< targety-getY()){
                    x = 4;
                    y = 0;
                }else{
                    y = 4;
                    x = 0;
                }
            }
            if (isTouching(topBottomRightTP.class)){
                if(getX()-targetx< Math.abs(targety-getY())){
                    x = 4;
                    y = 0;
                }else{
                    if (getY()>targety){
                        y = -4;
                    }else{
                        y= 4;
                    }  
                    x = 0;            
                }
            }
            if (isTouching(topBottomLeftRightTP.class)){
                if(Math.abs(getX()-targetx)<Math.abs(getY()- targety)){
                    if (getX()>targetx){
                        x = -4;
                    }else{
                        x= 4;
                    } 
                    y = 0;
                }else{
                    if (getY()<targety){
                        y = -4;
                    }else{
                        y= 4;
                    } 
                    x = 0;
                }
            }
            if (isTouching(topBottomLeftTP.class)){
                if(targetx-getX()<Math.abs(getY()- targety)){
                    x = -4;
                    y = 0;
                }else{
                    if (getY()<targety){
                        y = -4;
                    }else{
                        y= 4;
                    } 
                    x = 0;
                }
            }
            if (isTouching(topLeftRight.class)){
                if(Math.abs(getX()-targetx)<getY()- targety){
                    if (getX()>targetx){
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
                if(targetx-getX()<getY()- targety){
                    x= -4;
                    y = 0;
                }else{
                    y = -4;
                    x = 0;
                }
            }
            if (isTouching(topRightTP.class)){
                if(getX()-targetx<getY()- targety){
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
