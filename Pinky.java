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
    //top left
    /**
     * Act - do whatever the Pinky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //public int x;
    //public int y;
    private int rotx;
    private int roty;
    private int pacx;
    private int pacy;
    //public int countdown = 180;
    public int scatter = 400;
    public Pinky(){
        super(500, 0, 0);
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
              x = -4;
              y = 0;
            }else{
                y = 0;
                x = 4;
            }
      }
      World w = getWorld();
      MyWorld b = (MyWorld) w;
      if (b.isPowerPellet()){
        random();
        setImage("ghost-vulnerable.png");
      }else{
          setImage("Pinky.png");
          target();
          scatter--;
      }
      if (b.level == 1){
            if(x ==-4){
                x=-3;
            }else if(x == 4){
                x = 3;
            }else if (y == -4){
                y = -3;
            }else if(y == 4){
                y = 3;
            }
        }
      setLocation(getX()+x, getY()+y);
      countdown--;
      if (countdown == 0){
            setLocation(322, 224);
            scatter = 400;
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
          if(scatter <=400 && scatter>200||scatter<=-200&&scatter>-400||scatter<=-800&&scatter>-950||scatter<=-1350&&scatter>-1500){
              pacx = 24;
              pacy = 24;
          }
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
    public void random(){
        if (isTouching(bottmLeftTP.class)){
            if(Greenfoot.getRandomNumber(2)==1){
                x = -4;
                y = 0;
                setLocation(getX()-21, getY());
            }else{
                y = 4;
                x = 0;
                setLocation(getX(), getY()+21);
            }
        }
        if (isTouching(bottomLeftRightTP.class)){
            if(Greenfoot.getRandomNumber(3)!=0){
                if (Greenfoot.getRandomNumber(2) == 1){
                    x = -4;
                    setLocation(getX()-21, getY());
                }else{
                    x = 4;
                    setLocation(getX()+21, getY());
                }
                y = 0;
            }else{
                y = 4;
                x = 0;
                setLocation(getX(), getY()+21);
            }
        }
        if (isTouching(bottomRightTP.class)){
            if(Greenfoot.getRandomNumber(2)==1){
                x = 4;
                y = 0;
                setLocation(getX()+21, getY());
            }else{
                y = 4;
                x = 0;
                setLocation(getX(), getY()+21);
            }
        }
        if (isTouching(topBottomRightTP.class)){
            if(Greenfoot.getRandomNumber(3)==0){
                x = 4;
                y = 0;
                setLocation(getX()+21, getY());
            }else{
                if (Greenfoot.getRandomNumber(2)==1){
                    y = -4;
                    setLocation(getX(), getY()-21);
                }else{
                    y= 4;
                    setLocation(getX(), getY()+21);
                }  
                x = 0;  
            }
        }
        if (isTouching(topBottomLeftRightTP.class)){
            if(Greenfoot.getRandomNumber(2) == 0){
                if (Greenfoot.getRandomNumber(2)==1){
                    x = -4;
                    setLocation(getX()-21, getY());
                }else{
                    x= 4;
                    setLocation(getX()+21, getY());
                } 
                y = 0;
            }else{
                if (Greenfoot.getRandomNumber(2)== 1){
                    y = -4;
                    setLocation(getX(), getY()-21);
                }else{
                    y= 4;
                    setLocation(getX(), getY()+21);
                } 
                x = 0;
            }
        }
        if (isTouching(topBottomLeftTP.class)){
            if(Greenfoot.getRandomNumber(3) == 0){
                x = -4;
                y = 0;
                setLocation(getX()-21, getY());
            }else{
                if (Greenfoot.getRandomNumber(2) == 0){
                    y = -4;
                    setLocation(getX(), getY()-21);
                }else{
                    y= 4;
                    setLocation(getX(), getY()+21);
                } 
                x = 0;
            }
        }
        if (isTouching(topLeftRight.class)){
            if(Greenfoot.getRandomNumber(3)!=0){
                if (Greenfoot.getRandomNumber(2)==1){
                    x = -4;
                    setLocation(getX()-21, getY());
                }else{
                    x= 4;
                    setLocation(getX()+21, getY());
                }
                y = 0;
            }else{
                y = -4;
                x = 0;
                setLocation(getX(), getY()-21);
            }
        }
        if (isTouching(topLeftTP.class)){
            if(Greenfoot.getRandomNumber(2)==1){
                x= -4;
                y = 0;
                setLocation(getX()-21, getY());
            }else{
                y = -4;
                x = 0;
                setLocation(getX(), getY()-21);
            }
        }
        if (isTouching(topRightTP.class)){
            if(Greenfoot.getRandomNumber(2)==0){
                x= 4;
                y = 0;
                setLocation(getX()+21, getY());
            }else{
                y = -4;
                x = 0;
                setLocation(getX(), getY()-21);
            }
        }
    }
}
