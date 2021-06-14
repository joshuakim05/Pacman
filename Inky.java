import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Inky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inky extends ghost
{
    //bottom right
    //public int x;
    //public int y;
    private int rotx;
    private int roty;
    private int pacx;
    private int pacy;
    //public int countdown = 500;
    public int scatter = 400;
    public Inky(){
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
          setImage("Inky.png");
          getTarget();
          scatter--;
      }
      setLocation(getX()+x,getY()+y);
    }  
    
    public void getTarget(){
        List<Pacman> pm = getObjectsInRange(1000, Pacman.class);
        for(Pacman p: pm){
            if (p.getRotation() == 90){
                roty = 42;
                rotx=0;
            }else if (p.getRotation() == 180){
                rotx = -42;
                roty=0;
            }else if (p.getRotation() == 270){
                roty = -42;
                rotx=0;
            }else{
                rotx = 42;
                roty=0;
            }
            
            
            pacx = p.getX()+rotx;
            pacy = p.getY()+roty;
            List<Blinky> b = getObjectsInRange(1000, Blinky.class);
            for(Blinky y: b){
                pacx = pacx+(pacx-y.getX());
                pacy = pacy+(pacy-y.getY());
            }
            /*if(pacx> getX()){
                x = 4;
            } else{
                x = -4;
            }
            if(pacy< getY()){
                y = -4;
            } else{
                y = 4;
            }*/
            if(scatter <=400 && scatter>200||scatter<=-200&&scatter>-400||scatter<=-800&&scatter>-950||scatter<=-1350&&scatter>-1500){
                pacx = 620;
                pacy = 568;
            }
            if(Math.abs(getX()-p.getX())<30&&Math.abs(getY()-p.getY())<30){
              close();
          }else{
              far();
          }
        }
        countdown--;
        if (countdown == 0){
            setLocation(322, 224);
            scatter = 400;
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
