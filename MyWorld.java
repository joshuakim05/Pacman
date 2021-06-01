import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
   
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(645, 650, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        BorderLong borderLong = new BorderLong();
        addObject(borderLong,325,586);
        Border border = new Border();
        addObject(border,83,4);
        Border border2 = new Border();
        addObject(border2,220,4);
        Border border3 = new Border();
        addObject(border3,415,4);
        Border border4 = new Border();
        addObject(border4,551,4);
        Border border5 = new Border();
        addObject(border5,72,16);
        border5.setRotation(90);
        border5.setLocation(10,81);
        Border border6 = new Border();
        addObject(border6,108,93);
        border6.setRotation(90);
        border6.setLocation(10,110);
    {   
        // Size is at scale width 28, heigh 31, numbers can be changed but scale should stay the same
        //super(812, 899, 1); 
        //setBackground("background.png");
    }
}
}
