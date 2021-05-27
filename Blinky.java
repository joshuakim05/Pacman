import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Blinky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blinky extends ghost
{
    /**
     * Act - do whatever the Blinky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean[] intersections = new boolean[31];
     int teleportCount=0;

    public void act() 
    {
        
        //starting position
       if(this.isTouching(TeleportWall.class))
       {
          teleportCount++;
          if(teleportCount%2==1)
          {
            this.setLocation(495,200);
          }
          if(teleportCount%2==0)
          {
           this.setLocation(117,199);
          }
       }
       //move to middle position
        if(getX()!=300&&intersections[30]==false)
        {
        moveLeft();   
        }
        else if(getX()==300&&intersections[30]==false)
        {
         intersections[30]=true;
        }
       //0
        else if(getY()!=160&&intersections[0]==false)
        {
         moveUp();   
        }
        else if(getY()==160&&intersections[0]==false)
        {
         intersections[0]=true;
        }
        
        //1
        else if(getX()!=233&&intersections[1]==false)
        {
            moveLeft();
        }
        else if(getX()==233&&intersections[1]==false)
        {
            intersections[1]=true;
        }
        
        //2
        else if(getY()!=276&&intersections[2]==false)
        {
            moveDown();
        }
       else if(getY()==276&&intersections[2]==false)
        {
            intersections[2]=true;
        }
        
        //3
       else if(getX()!=275&&intersections[3]==false)
        {
            moveRight();
        }
        else if(getX()==275&&intersections[3]==false)
        {
            intersections[3]=true;
        }
        
        //4
         else if(getY()!=319&&intersections[4]==false)
        {
            moveDown();
        }
         else if(getY()==319&&intersections[4]==false)
        {
            intersections[4]=true;
        }
         
        //5
         else if(getX()!=364&&intersections[5]==false)
        {
            moveRight();
        }
         else if(getX()==364&&intersections[5]==false)
        {
            intersections[5]=true;
        }
         
        //6
         else if(getY()!=357&&intersections[6]==false)
        {
            moveDown();
        }
         else if(getY()==357&&intersections[6]==false)
        {
            intersections[6]=true;
        }
         
        //7
         else if(getX()!=322&&intersections[7]==false)
        {
            moveLeft();
        }
         else if(getX()==322&&intersections[7]==false)
        {
            intersections[7]=true;
        }
         
        //8
         else if(getY()!=395&&intersections[8]==false)
        {
            moveDown();
        }
         else if(getY()==395&&intersections[8]==false)
        {
            intersections[8]=true;
        }
         
        //9
         else if(getX()!=491&&intersections[9]==false)
        {
            moveRight();
        }
         else if(getX()==491&&intersections[9]==false)
        {
            intersections[9]=true;
        }
         
        //10
         else if(getY()!=357&&intersections[10]==false)
        {
            moveUp();
        }
         else if(getY()==357&&intersections[10]==false)
        {
            intersections[10]=true;
        }
         
        //11
         else if(getX()!=415&&intersections[11]==false)
        {
            moveLeft();
        }
         else if(getX()==415&&intersections[11]==false)
        {
            intersections[11]=true;
        }
         
        //12
         else if(getY()!=278&&intersections[12]==false)
        {
            moveUp();
        }
         else if(getY()==278&&intersections[12]==false)
        {
            intersections[12]=true;
        }
         
        //13
         else if(getX()!=367&&intersections[13]==false)
        {
            moveLeft();
        }
         else if(getX()==367&&intersections[13]==false)
        {
            intersections[13]=true;
        }
         
        //14
         else if(getY()!=238&&intersections[14]==false)
        {
            moveUp();
        }
         else if(getY()==238&&intersections[14]==false)
        {
            intersections[14]=true;
        }
         
        //15
         else if(getX()!=230&&intersections[15]==false)
        {
            moveLeft();
        }
         else if(getX()==230&&intersections[15]==false)
        {
            intersections[15]=true;
        }
         
        //16
         else if(getY()!=199&&intersections[16]==false)
        {
            moveUp();
        }
         else if(getY()==199&&intersections[16]==false)
        {
            intersections[16]=true;
        }
        
         //17
         else if(getX()!=187&&intersections[17]==false)
        {
            moveLeft();
        }
         else if(getX()==187&&intersections[17]==false)
        {
            intersections[17]=true;
        }
         
        //18
         else if(getY()!=119&&intersections[18]==false)
        {
            moveUp();
        }
         else if(getY()==119&&intersections[18]==false)
        {
            intersections[18]=true;
        }
        
        
         //19
         else if(getX()!=187&&intersections[19]==false)
        {
            moveLeft();
        }
         else if(getX()==187&&intersections[19]==false)
        {
            intersections[19]=true;
        }
         
        //20
         else if(getY()!=119&&intersections[20]==false)
        {
            moveUp();
        }
         else if(getY()==119&&intersections[20]==false)
        {
            intersections[20]=true;
        }
        
         //21
         else if(getX()!=113&&intersections[21]==false)
        {
            moveLeft();
        }
         else if(getX()==113&&intersections[21]==false)
        {
            intersections[21]=true;
        }
         
        //22
         else if(getY()!=29&&intersections[22]==false)
        {
            moveUp();
        }
         else if(getY()==29&&intersections[22]==false)
        {
            intersections[22]=true;
        }
        
         //23
         else if(getX()!=185&&intersections[23]==false)
        {
            moveRight();
        }
         else if(getX()==185&&intersections[23]==false)
        {
            intersections[23]=true;
        }
         
        //24
         else if(getY()!=78&&intersections[24]==false)
        {
            moveDown();
        }
         else if(getY()==78&&intersections[24]==false)
        {
            intersections[24]=true;
        }
        
        
         //25
         else if(getX()!=370&&intersections[25]==false)
        {
            moveRight();
        }
         else if(getX()==370&&intersections[25]==false)
        {
            intersections[25]=true;
        }
         
        //26
         else if(getY()!=121&&intersections[26]==false)
        {
            moveDown();
        }
         else if(getY()==121&&intersections[26]==false)
        {
            intersections[26]=true;
        }
        
        
         //27
         else if(getX()!=324&&intersections[27]==false)
        {
            moveLeft();
        }
         else if(getX()==324&&intersections[27]==false)
        {
            intersections[27]=true;
        }
         
        //28
         else if(getY()!=160&&intersections[28]==false)
        {
            moveDown();
        }
         else if(getY()==160&&intersections[28]==false)
        {
            intersections[28]=true;
        }
        
        //29
         else if(getX()!=300&&intersections[29]==false)
        {
            moveLeft();
        }
         else if(getX()==300&&intersections[29]==false)
        {
            intersections[29]=true;
            for(int i=0;i<intersections.length-1;i++)
            {
                intersections[i]=false;
            }
        }
    }    
}
