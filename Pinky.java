import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Pinky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pinky extends ghost
{
    /**
     * Act - do whatever the Pinky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int x;
    public int y;
    private int rotx;
    private int roty;
    private int pacx;
    private int pacy;
    public int countdown = 180;
    public Pinky(){
    
    }
    public void act() 
    {
      catchPacman();
      if(isTouching(teleportPointLeft.class)){
          setLocation(600, getY());
      }else if(isTouching(teleportPointRight.class)){
          setLocation(44, getY());
      }
      if(isTouching(topBoundry.class)){
          setLocation(getX(), 24);
          if(pacx>getX()){
              x=4;
            }else{
                x=-4;
            }
        }
      if(isTouching(bottomBoundry.class)){
          setLocation(getX(), 568);
          if(pacx>getX()){
              x=4;
          }else{
              x=-4;
          }
      }
      if(isTouching(leftBoundry.class)){
          setLocation(getY(), 24);
          if(pacy>getY()){
              y=4;
            }else{
                y=-4;
            }
      }
      if(isTouching(rightBoundry.class)){
          setLocation(getY(), 620);
          if(pacy>getY()){
              y=4;
          }else{
              y=-4;
          }
      }
      if (isTouching(GhostStart.class)){
          if(getX()>pacx){
              x = -3;
              y = 0;
            }else{
                y = 0;
                x = 3;
            }
      }
        target();
        setLocation(getX()+x, getY()+y);
      countdown--;
      if (countdown == 0){
            setLocation(322, 224);
        }
    }  
    
    public void target(){
        List<Pacman> pm = getObjectsInRange(1000, Pacman.class);
        for(Pacman p: pm){
            if (p.getRotation() == 90){
                roty = 84;
                rotx=0;
            }else if (p.getRotation() == 180){
                rotx = -84;
                roty=0;
            }else if (p.getRotation() == 270){
                roty = -84;
                rotx=0;
            }else{
                rotx = 84;
                roty=0;
            }
            
            /*if(p.getX()+rotx> getX()){
                x = 4;
            } else{
                x = -4;
            }
            if(p.getY()-roty< getY()){
                y = -4;
            } else{
                y = 4;
            }*/
            pacx = p.getX()+rotx;
            pacy = p.getY()+roty;
            //setLocation(getX()+x, getY()+y);
          if(Math.abs(getX()-p.getX())<30&&Math.abs(getY()-p.getY())<30){
              close();
          }else{
              far();
          }
        }
    }
    
    public void far(){
        if (isTouching(bottmLeftTP.class)){
            if(getX()-pacx>pacy-getY()){
                x = -4;
                y = 0;
            }else{
                y = 4;
                x = 0;
            }
        }
        if (isTouching(bottomLeftRightTP.class)){
            if(Math.abs(getX()-pacx)>pacy-getY()){
                if (getX()>pacx){
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
            if(pacx-getX()>pacy-getY()){
                x = 4;
                y = 0;
            }else{
                y = 4;
                x = 0;
            }
        }
        if (isTouching(topBottomRightTP.class)){
            if(pacx-getX()>Math.abs(pacy-getY())){
                x = 4;
                y = 0;
            }else{
                if (getY()>pacy){
                    y = -4;
                }else{
                    y= 4;
                }  
                x = 0;  
            }
        }
        if (isTouching(topBottomLeftRightTP.class)){
            if(Math.abs(getX()-pacx)>Math.abs(getY()- pacy)){
                if (getX()>pacx){
                    x = -4;
                }else{
                    x= 4;
                } 
                y = 0;
            }else{
                if (getY()>pacy){
                    y = -4;
                }else{
                    y= 4;
                } 
                x = 0;
            }
        }
        if (isTouching(topBottomLeftTP.class)){
            if(getX()-pacx>Math.abs(getY()- pacy)){
                x = -4;
                y = 0;
            }else{
                if (getY()>pacy){
                    y = -4;
                }else{
                    y= 4;
                } 
                x = 0;
            }
        }
        if (isTouching(topLeftRight.class)){
            if(Math.abs(getX()-pacx)>getY()- pacy){
                if (getX()>pacx){
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
            if(getX()-pacx>getY()- pacy){
                x= -4;
                y = 0;
            }else{
                y = -4;
                x = 0;
            }
        }
        if (isTouching(topRightTP.class)){
            if(pacx-getX()>getY()- pacy){
                x= 4;
                y = 0;
            }else{
                y = -4;
                x = 0;
            }
        }
    }
    public void close(){
        if (isTouching(bottmLeftTP.class)){
            if(pacx-getX()<pacy-getY()){
                x = -4;
                y = 0;
            }else{
                y = 4;
                x = 0;
            }
        }
        if (isTouching(bottomLeftRightTP.class)){
            if(Math.abs(getX()-pacx)<pacy-getY()){
                if (getX()>pacx){
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
            if(getX()-pacx< pacy-getY()){
                x = 4;
                y = 0;
            }else{
                y = 4;
                x = 0;
            }
        }
        if (isTouching(topBottomRightTP.class)){
            if(getX()-pacx< Math.abs(pacy-getY())){
                x = 4;
                y = 0;
            }else{
                if (getY()>pacy){
                    y = -4;
                }else{
                    y= 4;
                }  
                x = 0; 
            }
        }
        if (isTouching(topBottomLeftRightTP.class)){
            if(Math.abs(getX()-pacx)<Math.abs(getY()- pacy)){
                if (getX()>pacx){
                    x = -4;
                }else{
                    x= 4;
                } 
                y = 0;
            }else{
                if (getY()<pacy){
                    y = -4;
                }else{
                    y= 4;
                }
                x = 0;
            }
        }
        if (isTouching(topBottomLeftTP.class)){
            if(pacx-getX()<Math.abs(getY()- pacy)){
                x = -4;
                y = 0;
            }else{
                if (getY()<pacy){
                    y = -4;
                }else{
                    y= 4;
                } 
                x = 0;
            }
        }
        if (isTouching(topLeftRight.class)){
            if(Math.abs(getX()-pacx)<getY()- pacy){
                if (getX()>pacx){
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
            if(pacx-getX()<getY()- pacy){
                x= -4;
                y = 0;
            }else{
                y = -4;
                x = 0;
            }
        }
        if (isTouching(topRightTP.class)){
            if(getX()-pacx<getY()- pacy){
                x= 4;
                y = 0;
            }else{
                y = -4;
                x = 0;
            }
        }
    }  
}
