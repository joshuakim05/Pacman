import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int score = 0;
    private int lives;
    private int level;
    private int pastLevel=0;
    private int highscore;
    private int pelletCheck = 0;
    private boolean powerPellet = false;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(645, 650, 1); 
        prepare();
        lives = 3;
        showLives();
        showScore();
        showLevel();
        showHighscore();
        //die();
    }
    
    public boolean isPowerPellet(){
        return powerPellet;
    }
    
    public void setPowerPellet(boolean b){
        powerPellet = b;
    }
    
    public void showLevel(){
        showText("Level: " + level, 242, 620);
    }
    
    public void showHighscore(){
        showText("Highscore: " + highscore, 404, 620);
    }
    
    public void showScore(){
        showText("Score: " + score, 550, 620);
    }
    
    public void showLives(){
        showText("Lives: " + lives, 50, 620);
    }
    
    public void addScore(int points){
        score+=points;
        showScore();
    }
    
    public void checkWin(){
        pelletCheck = 0;
        List<ball> b = getObjects(ball.class);
        for(ball p: b){
            pelletCheck++;
        }
        if (pelletCheck==0){
            lives++;
            showLives();
            win();
        }
    }
    
    public void higherscore(){
        if (score>highscore){
            highscore = score;
            showHighscore();
        }
    }
    
    public void act(){
        if (lives == 0){
            if(Greenfoot.isKeyDown("space")){
                List<Pacman> pm = getObjects(Pacman.class);
                List<Blinky> b = getObjects(Blinky.class);
                List<Clyde> c = getObjects(Clyde.class);
                List<Inky> i = getObjects(Inky.class);
                List<Pinky> p = getObjects(Pinky.class);
                for(Pacman s: pm){
                    s.getWorld().removeObject(s);
                }
                for(Blinky s: b){
                    s.getWorld().removeObject(s);
                }
                for(Clyde s: c){
                    s.getWorld().removeObject(s);
                }
                for(Inky s: i){
                    s.getWorld().removeObject(s);
                }
                for(Pinky s: p){
                    s.getWorld().removeObject(s);
                }
                showText(null, 322, 280); 
                prepare();
                lives = 3;
            }
        }
        checkWin();
        higherscore();
    }
    
    public void die(){
        lives--;
        showLives();
        List<Pacman> pm = getObjects(Pacman.class);
        for(Pacman p: pm){
            p.setLocation(323, 450);
            p.x = 0;
            p.y = 0;
        }
        List<Blinky> b = getObjects(Blinky.class);
        for(Blinky g: b){
            g.setLocation(272, 280);
            g.countdown = 30;
            g.x = 0;
            g.y = 0;
        }
        List<Clyde> c = getObjects(Clyde.class);
        for(Clyde g: c){
            g.setLocation(303, 279);
            g.countdown = 300;
            g.x = 0;
            g.y = 0;
        }
        List<Inky> i = getObjects(Inky.class);
        for(Inky g: i){
            g.setLocation(344, 284);
            g.countdown = 500;
            g.x = 0;
            g.y = 0;
        }
        List<Pinky> p = getObjects(Pinky.class);
        for(Pinky g: p){
            g.setLocation(378, 284);
            g.countdown = 180;
            g.x = 0;
            g.y = 0;
        }
        if (lives <= 0){
            showText("Game Over! Press space to play again", 322, 280);
            pastLevel = 0;
            for(Pacman s: pm){
                s.getWorld().removeObject(s);
                s.x = 0;
                s.y = 0;
            }
            for(Blinky s: b){
                s.setLocation(323, 450);
                s.x = 0;
                s.y = 0;
                s.countdown = -1;
            }
            for(Clyde s: c){
                s.setLocation(323, 450);
                s.x = 0;
                s.y = 0;
                s.countdown = -1;
            }
            for(Inky s: i){
                s.setLocation(323, 450);
                s.x = 0;
                s.y = 0;
                s.countdown = -1;
            }
            for(Pinky s: p){
                s.setLocation(323, 450);
                s.x = 0;
                s.y = 0;
                s.countdown = -1;
            }
        }
    }
        
    public void win(){
        pastLevel++;
        List<Pacman> pm = getObjects(Pacman.class);
        for(Pacman p: pm){
            p.getWorld().removeObject(p);
        }
        List<Blinky> b = getObjects(Blinky.class);
        for(Blinky g: b){
            g.getWorld().removeObject(g);
        }
        List<Clyde> c = getObjects(Clyde.class);
        for(Clyde g: c){
            g.getWorld().removeObject(g);
        }
        List<Inky> i = getObjects(Inky.class);
        for(Inky g: i){
            g.getWorld().removeObject(g);
        }
        List<Pinky> p = getObjects(Pinky.class);
        for(Pinky g: p){
            g.getWorld().removeObject(g);
        }
        prepare();
        level += pastLevel;
        showLevel();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        level = 1;
        score = 0;
        showLevel();
        showLives();
        showScore();
        Pacman pacman = new Pacman();
        addObject(pacman, 323, 450);
        pacmanStart pS = new pacmanStart();
        addObject(pS, 323, 450);
        Blinky blinky = new Blinky();
        blinky.countdown = 30;
        addObject(blinky, 24, 24);
        Clyde clyde = new Clyde();
        clyde.countdown = 300;
        addObject(clyde, 24, 568);
        Inky inky = new Inky();
        inky.countdown = 500;
        addObject(inky, 620, 568);
        Pinky pinky = new Pinky();
        pinky.countdown = 180;
        addObject(pinky, 620, 24);

        blinky.setLocation(272,280);
        clyde.setLocation(303,279);
        pinky.setLocation(344,284);
        inky.setLocation(378,284);

        BorderLong borderLong = new BorderLong();
        addObject(borderLong,325,586);
        BorderLong borderLong2 = new BorderLong();
        addObject(borderLong2, 325, 4);

        Border border = new Border();
        addObject(border,72,16);
        border.setRotation(90);
        border.setLocation(7,81);
        Border border2 = new Border();
        addObject(border2,108,93);
        border2.setRotation(90);
        border2.setLocation(7,110);

        BorderTop top1 = new BorderTop();
        addObject(top1, 322, 42);
        Border border3 = new Border();
        border3.setRotation(90);
        addObject(border3, getWidth() - 5, 80);

        Border border4 = new Border();
        addObject(border4,337,129);
        removeObject(border4);
        BorderShort borderShort = new BorderShort();
        addObject(borderShort,49,184);
        BorderShort borderShort2 = new BorderShort();
        addObject(borderShort2,86,184);

        BorderShort borderShort3 = new BorderShort();
        addObject(borderShort3,581,102);
        borderShort3.setRotation(90);
        borderShort3.setLocation(getWidth() - 5,141);
        BorderShort borderShort4 = new BorderShort();
        addObject(borderShort4,598,185);
        borderShort4.setLocation(602,184);
        BorderShort borderShort5 = new BorderShort();
        addObject(borderShort5,562,184);
        borderShort5.setLocation(562,184);
        BorderShort borderShort6 = new BorderShort();
        addObject(borderShort6,120,215);
        borderShort6.setRotation(90);
        borderShort6.setLocation(121,215);
        BorderShort borderShort7 = new BorderShort();
        addObject(borderShort7,491,209);
        borderShort7.setRotation(90);
        borderShort7.setLocation(521,220);

        borderShort6.setLocation(124,219);
        BorderShort borderShort8 = new BorderShort();
        addObject(borderShort8,561,254);
        BorderShort borderShort9 = new BorderShort();
        addObject(borderShort9,609,254);
        BorderShort borderShort10 = new BorderShort();
        addObject(borderShort10,84,253);
        BorderShort borderShort11 = new BorderShort();
        addObject(borderShort11,37,253);
        BorderShort borderShort12 = new BorderShort();
        addObject(borderShort12,40,302);
        BorderShort borderShort13 = new BorderShort();
        addObject(borderShort13,86,302);
        BorderShort borderShort14 = new BorderShort();
        addObject(borderShort14,609,299);
        BorderShort borderShort15 = new BorderShort();
        addObject(borderShort15,562,299);
        BorderShort borderShort16 = new BorderShort();
        addObject(borderShort16,600,366);
        BorderShort borderShort17 = new BorderShort();
        addObject(borderShort17,562,366);
        BorderShort borderShort18 = new BorderShort();
        addObject(borderShort18,455,324);
        borderShort18.setRotation(90);
        borderShort18.setLocation(521,333);
        BorderShort borderShort19 = new BorderShort();
        addObject(borderShort19,122,336);
        borderShort19.setRotation(90);
        borderShort19.setLocation(125,333);
        BorderShort borderShort20 = new BorderShort();
        addObject(borderShort20,85,366);
        BorderShort borderShort21 = new BorderShort();
        addObject(borderShort21,47,365);
        borderShort21.setLocation(48,366);

        BorderShort borderShort22 = new BorderShort();
        addObject(borderShort22,22,390);
        borderShort22.setRotation(90);
        borderShort22.setLocation(7,405);
        BorderShort borderShort23 = new BorderShort();
        addObject(borderShort23,82,466);
        borderShort23.setRotation(90);
        borderShort23.setLocation(7,420);
        BorderShort borderShort24 = new BorderShort();
        addObject(borderShort24,256,438);
        borderShort24.setRotation(90);
        borderShort24.setLocation(7,537);
        BorderShort borderShort25 = new BorderShort();
        addObject(borderShort25,411,293);
        borderShort25.setRotation(90);
        borderShort25.setLocation(7,548);
        BorderShort borderShort26 = new BorderShort();
        addObject(borderShort26, getWidth() - 5,405);
        borderShort26.setRotation(90);

        BorderShort borderShort27 = new BorderShort();
        addObject(borderShort27,getWidth() - 5,420);
        borderShort27.setRotation(90);
        BorderShort borderShort28 = new BorderShort();
        addObject(borderShort28,getWidth() - 5,537);
        borderShort28.setRotation(90);
        BorderShort borderShort29 = new BorderShort();
        addObject(borderShort29,getWidth() - 5,548);
        borderShort29.setRotation(90);

        //BorderSide borderSide = new BorderSide();
        //addObject(borderSide,30,474);
        //BorderSide borderSide2 = new BorderSide();
        //addObject(borderSide2,599,466);
        //borderSide2.setRotation(180);
        //borderSide2.setLocation(616,476);

        BorderSide1 borderSide1 = new BorderSide1();
        addObject(borderSide1,5 ,476);
        BorderSide2 borderSide2 = new BorderSide2();
        addObject(borderSide2,33,479);
        BorderSide3 borderSide3 = new BorderSide3();
        addObject(borderSide3,642,476);
        BorderSide4 borderSide4 = new BorderSide4();
        addObject(borderSide4,613,479);

        BorderRoundMedium borderRoundMedium = new BorderRoundMedium();
        addObject(borderRoundMedium,88,67);
        borderRoundMedium.setLocation(93,67);
        BorderRoundMedium borderRoundMedium2 = new BorderRoundMedium();
        addObject(borderRoundMedium2,555,67);
        BorderRoundLarge borderRoundLarge = new BorderRoundLarge();
        addObject(borderRoundLarge,217,67);
        BorderRoundLarge borderRoundLarge2 = new BorderRoundLarge();
        addObject(borderRoundLarge2,430,67);

        BorderRoundSmall borderRoundSmall = new BorderRoundSmall();
        addObject(borderRoundSmall,93,135);
        BorderRoundSmall borderRoundSmall2 = new BorderRoundSmall();
        addObject(borderRoundSmall2,555,135);

        BorderTLong borderTLong = new BorderTLong();
        addObject(borderTLong,184,193);
        BorderTWide borderTWide = new BorderTWide();
        addObject(borderTWide,229,191);
        borderTWide.setLocation(231,190);

        //Side T pieces at the top
        BorderTLong borderTLong2 = new BorderTLong();
        addObject(borderTLong2,463,193);
        borderTLong2.setRotation(180);
        BorderTWide borderTWide2 = new BorderTWide();
        addObject(borderTWide2,416,191);
        borderTWide2.setRotation(180);

        //Upright T pieces
        BorderTBottom borderTBottom = new BorderTBottom();
        addObject(borderTBottom,325,171);
        BorderTTop borderTTop = new BorderTTop();
        addObject(borderTTop,325,136);
        BorderTTop borderTTop2 = new BorderTTop();
        addObject(borderTTop2,325,363);
        BorderTBottom borderTBottom2 = new BorderTBottom();
        addObject(borderTBottom2,325,400);
        BorderTTop borderTTop3 = new BorderTTop();
        addObject(borderTTop3,325,477);
        BorderTBottom borderTBottom3 = new BorderTBottom();
        addObject(borderTBottom3,325,513);

        //Left L piece
        BorderLTop borderLTop = new BorderLTop();
        addObject(borderLTop,92,420);
        BorderLBottom borderLBottom = new BorderLBottom();
        addObject(borderLBottom,114,457);

        //Right L piece
        BorderLRightTop borderLRightTop = new BorderLRightTop();
        addObject(borderLRightTop,556,420);
        BorderLRightBottom borderLRightBottom = new BorderLRightBottom();
        addObject(borderLRightBottom,533,457);

        //Near Bottom, round pieces
        BorderRoundSmallBottom borderRoundSmallBottom = new BorderRoundSmallBottom();
        addObject(borderRoundSmallBottom,430,421);
        BorderRoundSmallBottom borderRoundSmallBottom2 = new BorderRoundSmallBottom();
        addObject(borderRoundSmallBottom2,217,421);
        borderRoundSmallBottom2.setLocation(219,421);

        //Round vertical border pieces
        BorderRoundVertical borderRoundVertical = new BorderRoundVertical();
        addObject(borderRoundVertical,463,335);
        BorderRoundVertical borderRoundVertical2 = new BorderRoundVertical();
        addObject(borderRoundVertical2,184,335);

        //Bottom left T
        BorderTLeftBottom borderTLeftBottom = new BorderTLeftBottom();
        addObject(borderTLeftBottom,161,538);
        BorderTTopBottom borderTTopBottom = new BorderTTopBottom();
        addObject(borderTTopBottom,185,501);

        //Bottom right T
        BorderTRightBottom borderTRightBottom = new BorderTRightBottom();
        addObject(borderTRightBottom,492,538);
        BorderTTopBottom borderTTopBottom2 = new BorderTTopBottom();
        addObject(borderTTopBottom2,467,501);

        //coin things

        //         int j=0;
        //         for(int i=359;i>14;i-=15)
        //         {
        //               addObject(new ball(),414,i);
        //                 j++;
        //                addObject(new ball(),184,i);
        //                j++;
        //         }
        //         for(int i=324;i<414;i+=15)
        //         {
        //             addObject(new ball(),i,29);
        //                j++;
        //         }
        //          for(int i=429;i<504;i+=15)
        //         {
        //             addObject(new ball(),i,29);
        //                j++;
        //         }
        //         for(int i=113;i<503;i+=15)
        //         {
        //              addObject(new ball(),i,397);
        //              j++;
        //         }
        //          for(int i=199;i<401;i+=15)
        //         {
        //              addObject(new ball(),i,81);
        //              j++;
        //              addObject(new ball(),i,318);
        //              j++;
        //         }
        //         for(int i=233;i<369;i+=15)
        //         {
        //              addObject(new ball(),i,239);
        //              j++;
        //              addObject(new ball(),i,161);
        //              j++;
        //         }
        //         for(int i=177;i<237;i+=15)
        //         {
        //              addObject(new ball(),233,i);
        //              j++;
        //              addObject(new ball(),366,i);
        //              j++;
        //         }
        //         for(int i=110;i<184;i+=15)
        //         {
        //              addObject(new ball(),i,29);
        //              j++;
        //         }
        //         for(int i=199;i<280;i+=15)
        //         {
        //              addObject(new ball(),i,29);
        //              j++;
        //         }
        //          for(int i=199;i<280;i+=15)
        //         {
        //              addObject(new ball(),i,279);
        //              j++;
        //         }
        //         for(int i=320;i<410;i+=15)
        //         {
        //              addObject(new ball(),i,279);
        //              j++;
        //         }
        //          for(int i=428;i<492;i+=15)
        //         {
        //              addObject(new ball(),i,360);
        //              j++;
        //         }
        //          for(int i=169;i>108;i-=15)
        //         {
        //              addObject(new ball(),i,359);
        //              j++;
        //         }
        //          for(int i=134;i<179;i+=15)
        //         {
        //              addObject(new ball(),i,200);
        //              j++;
        //         }
        //          for(int i=431;i<491;i+=15)
        //         {
        //              addObject(new ball(),i,200);
        //              j++;
        //         }
        //           for(int i=134;i<171;i+=15)
        //         {
        //              addObject(new ball(),i,279);
        //              j++;
        //               addObject(new ball(),i,80);
        //              j++;
        //         }
        //          for(int i=109;i<171;i+=15)
        //         {
        //              addObject(new ball(),i,123);
        //              j++;
        //         }
        //          for(int i=430;i<468;i+=15)
        //         {
        //              addObject(new ball(),i,80);
        //              j++;
        //              addObject(new ball(),i,122);
        //              j++;
        //               addObject(new ball(),i,279);
        //              j++;
        //         }
        //          for(int i=230;i<277;i+=15)
        //         {
        //              addObject(new ball(),i,357);
        //              j++;

        //         }

        //              addObject(new ball(),200,200);
        //              j++;
        //              addObject(new ball(),215,200);
        //              j++;
        //               addObject(new ball(),397,200);
        //              j++;
        //              addObject(new ball(),383,200);
        //              j++;
        //              addObject(new ball(),486,96);
        //              j++;
        //              addObject(new ball(),486,110);
        //              j++;
        //              addObject(new ball(),486,123);
        //              j++;
        //              addObject(new ball(),473,123);
        //              j++;
        //              addObject(new ball(),486,300);
        //              j++;
        //              addObject(new ball(),486,318);
        //              j++;
        //              addObject(new ball(),486,47);
        //              j++;
        //               addObject(new ball(),486,63);
        //              j++;
        //               addObject(new ball(),472,318);
        //              j++;
        //              addObject(new ball(),458,318);
        //              j++;
        //              addObject(new ball(),458,333);
        //              j++;
        //              addObject(new ball(),458,348);
        //              j++;
        //              addObject(new ball(),488,371);
        //              j++;
        //              addObject(new ball(),488,383);
        //              j++;
        //              addObject(new ball(),109,373);
        //              j++;
        //              addObject(new ball(),109,385);
        //              j++;
        //              addObject(new ball(),275,370);
        //              j++;
        //              addObject(new ball(),275,385);
        //              j++;
        //              addObject(new ball(),364,334);
        //              j++;
        //              addObject(new ball(),229,331);
        //              j++;
        //              addObject(new ball(),229,346);
        //              j++;
        //              addObject(new ball(),110,47);
        //              j++;
        //              addObject(new ball(),110,63);
        //              j++;
        //              addObject(new ball(),109,95);
        //              j++;
        //              addObject(new ball(),109,110);
        //              j++;
        //              addObject(new ball(),113,301);
        //              j++;
        //              addObject(new ball(),113,319);
        //              j++;
        //              addObject(new ball(),129,319);
        //              j++;
        //              addObject(new ball(),144,319);
        //              j++;
        //              addObject(new ball(),144,334);
        //              j++;
        //              addObject(new ball(),144,347);
        //              j++;

        /*     addObject(new ball(),200,200);
        j++;
        addObject(new ball(),215,200);
        j++;
        addObject(new ball(),397,200);
        j++;
        addObject(new ball(),383,200);
        j++;
        addObject(new ball(),486,96);
        j++;
        addObject(new ball(),486,110);
        j++;
        addObject(new ball(),486,123);
        j++;
        addObject(new ball(),473,123);
        j++;
        addObject(new ball(),486,300);
        j++;
        addObject(new ball(),486,318);
        j++;
        addObject(new ball(),486,47);
        j++;
        addObject(new ball(),486,63);
        j++;
        addObject(new ball(),472,318);
        j++;
        addObject(new ball(),458,318);
        j++;
        addObject(new ball(),458,333);
        j++;
        addObject(new ball(),458,348);
        j++;
        addObject(new ball(),488,371);
        j++;
        addObject(new ball(),488,383);
        j++;
        addObject(new ball(),109,373);
        j++;
        addObject(new ball(),109,385);
        j++;
        addObject(new ball(),275,370);
        j++;
        addObject(new ball(),275,385);
        j++;
        addObject(new ball(),364,334);
        j++;
        addObject(new ball(),229,331);
        j++;
        addObject(new ball(),229,346);
        j++;
        addObject(new ball(),110,47);
        j++;
        addObject(new ball(),110,63);
        j++;
        addObject(new ball(),109,95);
        j++;
        addObject(new ball(),109,110);
        j++;
        addObject(new ball(),113,301);
        j++;
        addObject(new ball(),113,319);
        j++;
        addObject(new ball(),129,319);
        j++;
        addObject(new ball(),144,319);
        j++;
        addObject(new ball(),144,334);
        j++;
        addObject(new ball(),144,347);
        j++;

        //              addObject(new ball(),275,45);
        //              j++;
        //              addObject(new ball(),275,62);
        //              j++;
        //              addObject(new ball(),324,45);
        //              j++;
        //              addObject(new ball(),324,62);
        //              j++;

        //              addObject(new ball(),323,384);
        //              j++;
        //              addObject(new ball(),323,372);
        //              j++;
        //              addObject(new ball(),323,359);
        //              j++;
        //              addObject(new ball(),337,359);
        //              j++;

        //              addObject(new ball(),231,97);
        //              j++;
        //              addObject(new ball(),253,120);
        //              j++;
        //              addObject(new ball(),266,120);
        //              j++;
        //              addObject(new ball(),278,120);
        //              j++;
        //              addObject(new ball(),278,135);
        //              j++;
        //              addObject(new ball(),278,148);
        //              j++;

        //              addObject(new ball(),368,97);
        //              j++;
        //              addObject(new ball(),368,109);
        //              j++;
        //              addObject(new ball(),368,122);
        //              j++;
        //              addObject(new ball(),354,122);
        //              j++;
        //              addObject(new ball(),339,122);
        //              j++;
        //              addObject(new ball(),324,122);
        //              j++;
        //              addObject(new ball(),324,136);
        //              j++;
        //              addObject(new ball(),324,149);
        //              j++;

        //              addObject(new ball(),234,254);
        //              j++;
        //              addObject(new ball(),234,269);
        //              j++;
        //              addObject(new ball(),369,254);
        //              j++;
        //              addObject(new ball(),369,269);
        //              j++;

        //              addObject(new ball(),274,293);
        //              j++;
        //              addObject(new ball(),274,307);
        //              j++;
        //              addObject(new ball(),321,293);
        //              j++;
        //              addObject(new ball(),321,307);
        //              bottomRightTP bottomRightTP = new bottomRightTP();
        //             addObject(bottomRightTP,31,34);
        //             bottomLeftRightTP bottomLeftRightTP = new bottomLeftRightTP();
        //             addObject(bottomLeftRightTP,143,32);
        //             bottmLeftTP bottmLeftTP = new bottmLeftTP();
        //             addObject(bottmLeftTP,282,30);
        //             bottomRightTP bottomRightTP2 = new bottomRightTP();
        //             addObject(bottomRightTP2,359,30);
        //             bottomLeftRightTP bottomLeftRightTP2 = new bottomLeftRightTP();
        //             addObject(bottomLeftRightTP2,494,29);
        //             bottmLeftTP bottmLeftTP2 = new bottmLeftTP();
        //             addObject(bottmLeftTP2,610,32);
        //             topBottomRightTP topBottomRightTP = new topBottomRightTP();
        //             addObject(topBottomRightTP,29,108);
        //             topBottomLeftRightTP topBottomLeftRightTP = new topBottomLeftRightTP();
        //             addObject(topBottomLeftRightTP,141,108);
        //             bottomLeftRightTP bottomLeftRightTP3 = new bottomLeftRightTP();
        //             addObject(bottomLeftRightTP3,215,107);
        //             topLeftRight topLeftRight = new topLeftRight();
        //             addObject(topLeftRight,279,102);
        //             topLeftRight topLeftRight2 = new topLeftRight();
        //             addObject(topLeftRight2,352,105);
        //             bottomLeftRightTP bottomLeftRightTP4 = new bottomLeftRightTP();
        //             addObject(bottomLeftRightTP4,428,112);
        //             topBottomLeftRightTP topBottomLeftRightTP2 = new topBottomLeftRightTP();
        //             addObject(topBottomLeftRightTP2,493,104);
        //             topBottomLeftTP topBottomLeftTPI = new topBottomLeftTP();
        //             addObject(topBottomLeftTPI,607,104);
        //             topRightTP topRightTP = new topRightTP();
        //             addObject(topRightTP,31,163);
        //             topBottomLeftTP topBottomLeftTP2 = new topBottomLeftTP();
        //             addObject(topBottomLeftTP2,144,168);
        //             topRightTP topRightTP2 = new topRightTP();
        //             addObject(topRightTP2,214,164);
        //             bottmLeftTP bottmLeftTP3 = new bottmLeftTP();
        //             addObject(bottmLeftTP3,288,167);
        //             bottomRightTP bottomRightTP3 = new bottomRightTP();
        //             addObject(bottomRightTP3,359,163);
        //             topLeftTP topLeftTPI = new topLeftTP();
        //             addObject(topLeftTPI,429,163);
        //             topBottomRightTP topBottomRightTP2 = new topBottomRightTP();
        //             addObject(topBottomRightTP2,494,164);
        //             topLeftTP topLeftTP4I = new topLeftTP();
        //             addObject(topLeftTP4I,613,163);
        //             bottomRightTP bottomRightTP4 = new bottomRightTP();
        //             addObject(bottomRightTP4,216,221);
        //             topLeftRight topLeftRight3 = new topLeftRight();
        //             addObject(topLeftRight3,278,225);
        //             topLeftRight topLeftRight4 = new topLeftRight();
        //             addObject(topLeftRight4,359,225);
        //             bottmLeftTP bottmLeftTP5 = new bottmLeftTP();
        //             addObject(bottmLeftTP5,426,222);
        //             topBottomLeftRightTP topBottomLeftRightTP3 = new topBottomLeftRightTP();
        //             addObject(topBottomLeftRightTP3,139,279);
        //             topBottomLeftTP topBottomLeftTP3 = new topBottomLeftTP();
        //             addObject(topBottomLeftTP3,211,280);
        //             topBottomRightTP topBottomRightTP3 = new topBottomRightTP();
        //             addObject(topBottomRightTP3,417,278);
        //             topBottomLeftRightTP topBottomLeftRightTP4 = new topBottomLeftRightTP();
        //             addObject(topBottomLeftRightTP4,495,281);
        //             topBottomRightTP topBottomRightTP4 = new topBottomRightTP();
        //             addObject(topBottomRightTP4,218,335);
        //             topBottomLeftTP topBottomLeftTP4 = new topBottomLeftTP();
        //             addObject(topBottomLeftTP4,425,338);
        //             bottomRightTP bottomRightTP5 = new bottomRightTP();
        //             addObject(bottomRightTP5,29,392);
        //             topBottomLeftRightTP topBottomLeftRightTP5 = new topBottomLeftRightTP();
        //             addObject(topBottomLeftRightTP5,148,392);
        //             topLeftRight topLeftRight5 = new topLeftRight();
        //             addObject(topLeftRight5,223,390);
        //             bottmLeftTP bottmLeftTP6 = new bottmLeftTP();
        //             addObject(bottmLeftTP6,286,393);
        //             bottomRightTP bottomRightTP6 = new bottomRightTP();
        //             addObject(bottomRightTP6,357,397);
        //             topLeftRight topLeftRight6 = new topLeftRight();
        //             addObject(topLeftRight6,426,389);
        //             topBottomLeftRightTP topBottomLeftRightTP6 = new topBottomLeftRightTP();
        //             addObject(topBottomLeftRightTP6,494,391);
        //             bottmLeftTP bottmLeftTP7 = new bottmLeftTP();
        //             addObject(bottmLeftTP7,609,392);
        //             topRightTP topRightTP3 = new topRightTP();
        //             addObject(topRightTP3,27,449);
        //             bottmLeftTP bottmLeftTP8 = new bottmLeftTP();
        //             addObject(bottmLeftTP8,83,449);
        //             topBottomRightTP topBottomRightTP5 = new topBottomRightTP();
        //             addObject(topBottomRightTP5,153,454);
        //             bottomLeftRightTP bottomLeftRightTP5 = new bottomLeftRightTP();
        //             addObject(bottomLeftRightTP5,211,453);
        //             topLeftRight topLeftRight7 = new topLeftRight();
        //             addObject(topLeftRight7,286,449);
        //             topLeftRight topLeftRight8 = new topLeftRight();
        //             addObject(topLeftRight8,359,447);
        //             bottomLeftRightTP bottomLeftRightTP6 = new bottomLeftRightTP();
        //             addObject(bottomLeftRightTP6,430,454);
        //             topBottomLeftTP topBottomLeftTP5 = new topBottomLeftTP();
        //             addObject(topBottomLeftTP5,493,452);
        //             bottomRightTP bottomRightTP7 = new bottomRightTP();
        //             addObject(bottomRightTP7,563,452);
        //             topLeftTP topLeftTP2 = new topLeftTP();
        //             addObject(topLeftTP2,613,445);
        //             bottomRightTP bottomRightTP8 = new bottomRightTP();
        //             addObject(bottomRightTP8,28,509);
        //             topLeftRight topLeftRight9 = new topLeftRight();
        //             addObject(topLeftRight9,71,504);
        //             topLeftTP topLeftTP3 = new topLeftTP();
        //             addObject(topLeftTP3,140,508);
        //             topRightTP topRightTP4 = new topRightTP();
        //             addObject(topRightTP4,216,507);
        //             bottmLeftTP bottmLeftTP9 = new bottmLeftTP();
        //             addObject(bottmLeftTP9,286,508);
        //             bottomRightTP bottomRightTP9 = new bottomRightTP();
        //             addObject(bottomRightTP9,356,508);
        //             topLeftTP topLeftTP4 = new topLeftTP();
        //             addObject(topLeftTP4,424,506);
        //             topRightTP topRightTP5 = new topRightTP();
        //             addObject(topRightTP5,498,509);
        //             topLeftRight topLeftRight10 = new topLeftRight();
        //             addObject(topLeftRight10,563,505);
        //             bottmLeftTP bottmLeftTP10 = new bottmLeftTP();
        //             addObject(bottmLeftTP10,617,511);
        //             topRightTP topRightTP6 = new topRightTP();
        //             addObject(topRightTP6,27,562);
        //             topLeftRight topLeftRight11 = new topLeftRight();
        //             addObject(topLeftRight11,286,566);
        //             topLeftRight topLeftRight12 = new topLeftRight();
        //             addObject(topLeftRight12,358,566);
        //             topLeftTP topLeftTP5 = new topLeftTP();
        //             addObject(topLeftTP5,618,568);

        addObject(new ball(),274,293);
        j++;
        addObject(new ball(),274,307);
        j++;
        addObject(new ball(),321,293);
        j++;*/

        //add powerup balls
        //addObject(man.getBigBall1(),113,78);
        //addObject(man.getBigBall2(),113,280);
        //addObject(man.getBigBall3(),486,78);
        //addObject(man.getBigBall4(),486,280);
        bottomRightTP bottomRightTP = new bottomRightTP();
        addObject(bottomRightTP,24,24);
        bottomLeftRightTP bottomLeftRightTP = new bottomLeftRightTP();
        addObject(bottomLeftRightTP,147,24);
        bottmLeftTP bottmLeftTP = new bottmLeftTP();
        addObject(bottmLeftTP,286,24);
        bottomRightTP bottomRightTP2 = new bottomRightTP();
        addObject(bottomRightTP2,358,24);
        bottomLeftRightTP bottomLeftRightTP2 = new bottomLeftRightTP();
        addObject(bottomLeftRightTP2,497,24);
        bottmLeftTP bottmLeftTP2 = new bottmLeftTP();
        addObject(bottmLeftTP2,620,24);
        //second row
        topBottomRightTP topBottomRightTP = new topBottomRightTP();
        addObject(topBottomRightTP,24,106);
        topBottomLeftRightTP topBottomLeftRightTP = new topBottomLeftRightTP();
        addObject(topBottomLeftRightTP,147,106);
        bottomLeftRightTP bottomLeftRightTP3 = new bottomLeftRightTP();
        addObject(bottomLeftRightTP3,218,106);
        topLeftRight topLeftRight = new topLeftRight();
        addObject(topLeftRight,286,106);
        topLeftRight topLeftRight2 = new topLeftRight();
        addObject(topLeftRight2,358,106);
        bottomLeftRightTP bottomLeftRightTP4 = new bottomLeftRightTP();
        addObject(bottomLeftRightTP4,429,106);
        topBottomLeftRightTP topBottomLeftRightTP2 = new topBottomLeftRightTP();
        addObject(topBottomLeftRightTP2,497,106);
        topBottomLeftTP topBottomLeftTPI = new topBottomLeftTP();
        addObject(topBottomLeftTPI,620,106);
        //third row
        topRightTP topRightTP = new topRightTP();
        addObject(topRightTP,24,165);
        topBottomLeftTP topBottomLeftTP2 = new topBottomLeftTP();
        addObject(topBottomLeftTP2,147,165);
        topRightTP topRightTP2 = new topRightTP();
        addObject(topRightTP2,218,165);
        bottmLeftTP bottmLeftTP3 = new bottmLeftTP();
        addObject(bottmLeftTP3,286,165);
        bottomRightTP bottomRightTP3 = new bottomRightTP();
        addObject(bottomRightTP3,358,165);
        topLeftTP topLeftTPI = new topLeftTP();
        addObject(topLeftTPI,429,165);
        topBottomRightTP topBottomRightTP2 = new topBottomRightTP();
        addObject(topBottomRightTP2,497,165);
        topLeftTP topLeftTP4I = new topLeftTP();
        addObject(topLeftTP4I,620,165);
        //fourth row
        bottomRightTP bottomRightTP4 = new bottomRightTP();
        addObject(bottomRightTP4,218,224);
        topLeftRight topLeftRight3 = new topLeftRight();
        addObject(topLeftRight3,286,224);
        GhostStart gs = new GhostStart();
        addObject(gs, 322, 224);
        topLeftRight topLeftRight4 = new topLeftRight();
        addObject(topLeftRight4,358,224);
        bottmLeftTP bottmLeftTP5 = new bottmLeftTP();
        addObject(bottmLeftTP5,429,224);
        //fifth row
        topBottomLeftRightTP topBottomLeftRightTP3 = new topBottomLeftRightTP();
        addObject(topBottomLeftRightTP3,147,279);
        topBottomLeftTP topBottomLeftTP3 = new topBottomLeftTP();
        addObject(topBottomLeftTP3,218,279);
        topBottomRightTP topBottomRightTP3 = new topBottomRightTP();
        addObject(topBottomRightTP3,429,279);
        topBottomLeftRightTP topBottomLeftRightTP4 = new topBottomLeftRightTP();
        addObject(topBottomLeftRightTP4,499,279);
        //sixth 
        topBottomRightTP topBottomRightTP4 = new topBottomRightTP();
        addObject(topBottomRightTP4,218,339);
        topBottomLeftTP topBottomLeftTP4 = new topBottomLeftTP();
        addObject(topBottomLeftTP4,429,339);
        //seventh
        bottomRightTP bottomRightTP5 = new bottomRightTP();
        addObject(bottomRightTP5,24,393);
        topBottomLeftRightTP topBottomLeftRightTP5 = new topBottomLeftRightTP();
        addObject(topBottomLeftRightTP5,147,393);
        topLeftRight topLeftRight5 = new topLeftRight();
        addObject(topLeftRight5,218,393);
        bottmLeftTP bottmLeftTP6 = new bottmLeftTP();
        addObject(bottmLeftTP6,286,393);
        bottomRightTP bottomRightTP6 = new bottomRightTP();
        addObject(bottomRightTP6,358,393);
        topLeftRight topLeftRight6 = new topLeftRight();
        addObject(topLeftRight6,429,393);
        topBottomLeftRightTP topBottomLeftRightTP6 = new topBottomLeftRightTP();
        addObject(topBottomLeftRightTP6,497,393);
        bottmLeftTP bottmLeftTP7 = new bottmLeftTP();
        addObject(bottmLeftTP7,620,393);
        //eight
        topRightTP topRightTP3 = new topRightTP();
        addObject(topRightTP3,24,449);
        bottmLeftTP bottmLeftTP8 = new bottmLeftTP();
        addObject(bottmLeftTP8,78,449);
        topBottomRightTP topBottomRightTP5 = new topBottomRightTP();
        addObject(topBottomRightTP5,147,449);
        bottomLeftRightTP bottomLeftRightTP5 = new bottomLeftRightTP();
        addObject(bottomLeftRightTP5,218,449);
        topLeftRight topLeftRight7 = new topLeftRight();
        addObject(topLeftRight7,286,449);
        topLeftRight topLeftRight8 = new topLeftRight();
        addObject(topLeftRight8,358,449);
        bottomLeftRightTP bottomLeftRightTP6 = new bottomLeftRightTP();
        addObject(bottomLeftRightTP6,429,449);
        topBottomLeftTP topBottomLeftTP5 = new topBottomLeftTP();
        addObject(topBottomLeftTP5,497,449);
        bottomRightTP bottomRightTP7 = new bottomRightTP();
        addObject(bottomRightTP7,567,449);
        topLeftTP topLeftTP2 = new topLeftTP();
        addObject(topLeftTP2,620,449);
        //ninth
        bottomRightTP bottomRightTP8 = new bottomRightTP();
        addObject(bottomRightTP8,24,506);
        topLeftRight topLeftRight9 = new topLeftRight();
        addObject(topLeftRight9,78,506);
        topLeftTP topLeftTP3 = new topLeftTP();
        addObject(topLeftTP3,147,506);
        topRightTP topRightTP4 = new topRightTP();
        addObject(topRightTP4,218,506);
        bottmLeftTP bottmLeftTP9 = new bottmLeftTP();
        addObject(bottmLeftTP9,286,506);
        bottomRightTP bottomRightTP9 = new bottomRightTP();
        addObject(bottomRightTP9,358,506);
        topLeftTP topLeftTP4 = new topLeftTP();
        addObject(topLeftTP4,429,506);
        topRightTP topRightTP5 = new topRightTP();
        addObject(topRightTP5,497,506);
        topLeftRight topLeftRight10 = new topLeftRight();
        addObject(topLeftRight10,567,506);
        bottmLeftTP bottmLeftTP10 = new bottmLeftTP();
        addObject(bottmLeftTP10,620,506);
        //tenth
        topRightTP topRightTP6 = new topRightTP();
        addObject(topRightTP6,24,568);
        // leftRight leftRight = new leftRight();
        // addObject(leftRight,78,568);
        // leftRight leftRight2 = new leftRight();
        // addObject(leftRight2,147,568);
        // leftRight leftRight3 = new leftRight();
        // addObject(leftRight3,218,568);
        topLeftRight topLeftRight11 = new topLeftRight();
        addObject(topLeftRight11,286,568);
        topLeftRight topLeftRight12 = new topLeftRight();
        addObject(topLeftRight12,358,568);
        // leftRight leftRight4 = new leftRight();
        // addObject(leftRight4,429,586);
        // leftRight leftRight5 = new leftRight();
        // addObject( leftRight5,497, 568);
        // leftRight leftRight6 = new leftRight();
        // addObject(leftRight6,567,568);
        topLeftTP topLeftTP5 = new topLeftTP();
        addObject(topLeftTP5,620,568);
        //
        teleportPointLeft teleportPointLeft = new teleportPointLeft();
        addObject(teleportPointLeft,13,278);
        teleportPointRight teleportPointRight = new teleportPointRight();
        addObject(teleportPointRight,637,278);
        topBoundry topBoundry = new topBoundry();
        addObject(topBoundry,321,5);
        bottomBoundry bottomBoundry = new bottomBoundry();
        addObject(bottomBoundry,322,623);
        leftBoundry leftBoundry = new leftBoundry();
        addObject(leftBoundry,9,324);
        rightBoundry rightBoundry = new rightBoundry();
        addObject(rightBoundry,641,325);

        //Pellets
        ball ball = new ball();
        addObject(ball,34,107);
        ball ball2 = new ball();
        addObject(ball2,34,87);
        ball ball3 = new ball();
        addObject(ball3,34,51);
        ball ball4 = new ball();
        addObject(ball4,34,31);
        ball ball5 = new ball();
        addObject(ball5,34,163);
        ball ball6 = new ball();
        addObject(ball6,34,135);

        ball ball7 = new ball();
        addObject(ball7,57,31);
        ball ball8 = new ball();
        addObject(ball8,80,31);
        ball ball9 = new ball();
        addObject(ball9,104,31);
        ball ball10 = new ball();
        addObject(ball10,126,31);

        ball ball11 = new ball();
        addObject(ball11,150,31);
        ball ball12 = new ball();
        addObject(ball12,174,31);
        ball ball13 = new ball();
        addObject(ball13,196,31);
        ball ball14 = new ball();
        addObject(ball14,220,31);
        ball ball15 = new ball();
        addObject(ball15,245,31);
        ball ball16 = new ball();
        addObject(ball16,268,31);
        ball ball17 = new ball();
        addObject(ball17,289,31);

        ball ball18 = new ball();
        addObject(ball18,150,50);
        ball ball19 = new ball();
        addObject(ball19,150,69);
        ball ball20 = new ball();
        addObject(ball20,150,87);
        ball ball21 = new ball();
        addObject(ball21,150,107);
        ball ball22 = new ball();
        addObject(ball22,150,124);
        ball ball23 = new ball();
        addObject(ball23,150,144);

        ball ball24 = new ball();
        addObject(ball24,150,164);
        ball ball25 = new ball();
        addObject(ball25,150,184);
        ball ball26 = new ball();
        addObject(ball26,150,204);
        ball ball27 = new ball();
        addObject(ball27,150,221);
        ball ball28 = new ball();
        addObject(ball28,150,240);
        ball ball29 = new ball();
        addObject(ball29,150,258);
        ball ball30 = new ball();
        addObject(ball30,150,278);
        ball ball31 = new ball();
        addObject(ball31,150,297);
        ball ball32 = new ball();
        addObject(ball32,150,318);
        ball ball33 = new ball();
        addObject(ball33,150,336);
        ball ball34 = new ball();
        addObject(ball34,150,354);
        ball ball35 = new ball();
        addObject(ball35,150,372);
        ball ball36 = new ball();
        addObject(ball36,150,393);
        ball ball37 = new ball();
        addObject(ball37,150,411);
        ball ball38 = new ball();
        addObject(ball38,150,429);
        ball ball39 = new ball();
        addObject(ball39,150,446);
        ball39.setLocation(150,452);
        ball39.setLocation(150,449);
        ball ball40 = new ball();
        addObject(ball40,150,469);
        ball ball41 = new ball();
        addObject(ball41,150,489);
        ball ball42 = new ball();
        addObject(ball42,150,508);
        ball ball43 = new ball();

        addObject(ball43,57,107);
        ball ball44 = new ball();
        addObject(ball44,80,107);
        ball ball45 = new ball();
        addObject(ball45,103,107);
        ball ball46 = new ball();
        addObject(ball46,127,107);
        ball ball47 = new ball();
        addObject(ball47,173,107);
        ball ball48 = new ball();
        addObject(ball48,196,107);

        ball ball49 = new ball();
        addObject(ball49,219,107);
        ball ball50 = new ball();
        addObject(ball50,243,107);
        ball ball51 = new ball();
        addObject(ball51,266,107);

        ball ball52 = new ball();
        addObject(ball52,289,107);
        ball ball53 = new ball();
        addObject(ball53,312,107);
        ball ball54 = new ball();
        addObject(ball54,335,107);

        ball ball55 = new ball();
        addObject(ball55,359,107);
        ball ball56 = new ball();
        addObject(ball56,382,107);
        ball ball57 = new ball();
        addObject(ball57,404,107);

        ball ball58 = new ball();
        addObject(ball58,428,107);
        ball ball59 = new ball();
        addObject(ball59,451,107);
        ball ball60 = new ball();
        addObject(ball60,474,107);
        ball ball61 = new ball();
        addObject(ball61,498,107);
        ball ball62 = new ball();
        addObject(ball62,520,107);
        ball ball63 = new ball();
        addObject(ball63,544,107);
        ball ball64 = new ball();
        addObject(ball64,567,107);
        ball ball65 = new ball();
        addObject(ball65,590,107);
        ball ball66 = new ball();
        addObject(ball66,612,107);

        ball ball67 = new ball();
        addObject(ball67,290,50);
        ball ball68 = new ball();
        addObject(ball68,290,70);
        ball ball69 = new ball();
        addObject(ball69,290,88);
        ball ball70 = new ball();
        addObject(ball70,219,126);
        ball ball71 = new ball();
        addObject(ball71,219,147);
        ball ball72 = new ball();
        addObject(ball72,219,164);

        ball ball73 = new ball();
        addObject(ball73,358,87);
        ball ball74 = new ball();
        addObject(ball74,358,68);
        ball ball75 = new ball();
        addObject(ball75,358,49);
        ball ball76 = new ball();
        addObject(ball76,358,31);
        ball ball77 = new ball();
        addObject(ball77,382,30);

        ball ball78 = new ball();
        addObject(ball78,405,30);
        ball ball79 = new ball();
        addObject(ball79,428,30);
        ball ball80 = new ball();
        addObject(ball80,451,30);
        ball ball81 = new ball();
        addObject(ball81,476,30);
        ball ball82 = new ball();
        addObject(ball82,498,30);
        ball ball83 = new ball();
        addObject(ball83,521,30);
        ball ball84 = new ball();
        addObject(ball84,544,30);
        ball ball85 = new ball();
        addObject(ball85,568,30);
        ball ball86 = new ball();
        addObject(ball86,590,30);
        ball ball87 = new ball();

        addObject(ball87,613,30);
        ball ball88 = new ball();
        addObject(ball88,613,50);
        ball ball89 = new ball();
        addObject(ball89,613,89);
        ball ball90 = new ball();
        addObject(ball90,613,125);
        ball ball91 = new ball();
        addObject(ball91,613,145);
        ball ball92 = new ball();
        addObject(ball92,613,165);

        ball ball93 = new ball();
        addObject(ball93,497,49);
        ball ball94 = new ball();
        addObject(ball94,497,71);
        ball ball95 = new ball();
        addObject(ball95,497,88);
        ball ball96 = new ball();
        addObject(ball96,497,126);
        ball ball97 = new ball();
        addObject(ball97,497,145);
        ball ball98 = new ball();
        addObject(ball98,497,164);
        ball ball99 = new ball();
        addObject(ball99,497,184);
        ball ball100 = new ball();
        addObject(ball100,497,202);
        ball ball101 = new ball();
        addObject(ball101,497,221);
        ball ball102 = new ball();
        addObject(ball102,497,241);
        ball ball103 = new ball();
        addObject(ball103,497,260);
        ball ball104 = new ball();
        addObject(ball104,497,280);
        ball ball105 = new ball();
        addObject(ball105,497,299);
        ball ball106 = new ball();
        addObject(ball106,497,317);
        ball ball107 = new ball();
        addObject(ball107,497,334);
        ball ball108 = new ball();
        addObject(ball108,497,355);
        ball ball109 = new ball();
        addObject(ball109,497,373);
        ball ball110 = new ball();
        addObject(ball110,497,391);
        ball ball111 = new ball();
        addObject(ball111,497,413);
        ball ball112 = new ball();
        addObject(ball112,497,429);
        ball ball113 = new ball();
        addObject(ball113,497,449);
        ball ball114 = new ball();
        addObject(ball114,497,469);
        ball ball115 = new ball();
        addObject(ball115,497,489);
        ball ball116 = new ball();
        addObject(ball116,497,507);

        ball ball117 = new ball();
        addObject(ball117,58,164);
        ball ball118 = new ball();
        addObject(ball118,80,164);
        ball ball119 = new ball();
        addObject(ball119,103,164);
        ball ball120 = new ball();
        addObject(ball120,127,164);
        ball ball121 = new ball();
        addObject(ball121,522,164);
        ball ball122 = new ball();
        addObject(ball122,544,164);
        ball ball123 = new ball();
        addObject(ball123,568,164);
        ball ball124 = new ball();
        addObject(ball124,591,164);
        ball ball125 = new ball();
        addObject(ball125,428,126);
        ball ball126 = new ball();
        addObject(ball126,428,146);
        ball ball127 = new ball();
        addObject(ball127,428,165);
        ball ball128 = new ball();

        addObject(ball128,244,165);
        ball ball129 = new ball();
        addObject(ball129,265,165);
        ball ball130 = new ball();
        addObject(ball130,289,165);
        ball ball131 = new ball();
        addObject(ball131,359,165);
        ball ball132 = new ball();
        addObject(ball132,383,165);
        ball ball133 = new ball();
        addObject(ball133,405,165);
        ball ball134 = new ball();
        addObject(ball134,289,185);
        ball ball135 = new ball();
        addObject(ball135,289,201);
        ball ball136 = new ball();
        addObject(ball136,289,221);
        ball ball137 = new ball();

        addObject(ball137,358,184);
        ball ball138 = new ball();
        addObject(ball138,358,201);
        ball ball139 = new ball();
        addObject(ball139,358,222);
        ball ball140 = new ball();

        addObject(ball140,220,222);
        ball ball141 = new ball();
        addObject(ball141,244,222);
        ball ball142 = new ball();
        addObject(ball142,265,222);
        ball ball143 = new ball();
        addObject(ball143,313,222);
        ball ball144 = new ball();
        addObject(ball144,336,222);
        ball ball145 = new ball();
        addObject(ball145,381,222);
        ball ball146 = new ball();
        addObject(ball146,406,222);
        ball ball147 = new ball();
        addObject(ball147,429,222);

        ball ball148 = new ball();
        addObject(ball148,219,241);
        ball ball149 = new ball();
        addObject(ball149,219,259);
        ball ball150 = new ball();
        addObject(ball150,219,279);
        ball ball151 = new ball();
        addObject(ball151,219,298);
        ball ball152 = new ball();
        addObject(ball152,219,317);
        ball ball153 = new ball();
        addObject(ball153,219,335);
        ball ball154 = new ball();
        addObject(ball154,219,354);
        ball ball155 = new ball();
        addObject(ball155,219,374);
        ball ball156 = new ball();
        addObject(ball156,219,394);

        ball ball157 = new ball();
        addObject(ball157,428,241);
        ball ball158 = new ball();
        addObject(ball158,428,259);
        ball ball159 = new ball();
        addObject(ball159,428,279);
        ball ball160 = new ball();
        addObject(ball160,428,298);
        ball ball161 = new ball();
        addObject(ball161,428,317);
        ball ball162 = new ball();
        addObject(ball162,428,335);
        ball ball163 = new ball();
        addObject(ball163,428,354);
        ball ball164 = new ball();
        addObject(ball164,428,374);
        ball ball165 = new ball();
        addObject(ball165,428,394);

        ball ball166 = new ball();
        addObject(ball166,174,278);
        ball ball167 = new ball();
        addObject(ball167,197,278);
        ball ball168 = new ball();
        addObject(ball168,450,278);
        ball ball169 = new ball();
        addObject(ball169,476,278);

        ball ball170 = new ball();
        addObject(ball170,243,337);
        ball ball171 = new ball();
        addObject(ball171,265,337);
        ball ball172 = new ball();
        addObject(ball172,288,337);
        ball ball173 = new ball();
        addObject(ball173,312,337);
        ball ball174 = new ball();
        addObject(ball174,335,337);
        ball ball175 = new ball();
        addObject(ball175,359,337);
        ball ball176 = new ball();
        addObject(ball176,383,337);
        ball ball177 = new ball();
        addObject(ball177,404,337);

        ball ball178 = new ball();
        addObject(ball178,35,393);
        ball ball179 = new ball();
        addObject(ball179,57,393);
        ball ball180 = new ball();
        addObject(ball180,80,393);
        ball ball181 = new ball();
        addObject(ball181,103,393);
        ball ball182 = new ball();
        addObject(ball182,126,393);
        ball ball183 = new ball();
        addObject(ball183,174,393);
        ball ball184 = new ball();
        addObject(ball184,197,393);
        ball ball185 = new ball();
        addObject(ball185,242,393);
        ball ball186 = new ball();
        addObject(ball186,266,393);
        ball ball187 = new ball();
        addObject(ball187,287,393);
        ball ball188 = new ball();
        addObject(ball188,360,393);
        ball ball189 = new ball();
        addObject(ball189,382,393);
        ball ball190 = new ball();
        addObject(ball190,405,393);
        ball ball191 = new ball();
        addObject(ball191,451,393);
        ball ball192 = new ball();
        addObject(ball192,475,393);
        ball ball193 = new ball();
        addObject(ball193,520,393);
        ball ball194 = new ball();
        addObject(ball194,546,393);
        ball ball195 = new ball();
        addObject(ball195,568,393);
        ball ball196 = new ball();
        addObject(ball196,590,393);
        ball ball197 = new ball();
        addObject(ball197,613,393);

        ball ball198 = new ball();
        addObject(ball198,34,412);
        ball ball199 = new ball();
        addObject(ball199,34,450);
        ball ball200 = new ball();
        addObject(ball200,288,413);
        ball ball201 = new ball();
        addObject(ball201,288,432);
        ball ball202 = new ball();
        addObject(ball202,288,451);
        ball ball203 = new ball();
        addObject(ball203,359,414);
        ball ball204 = new ball();
        addObject(ball204,359,432);
        ball ball205 = new ball();
        addObject(ball205,359,450);
        ball ball206 = new ball();
        addObject(ball206,613,412);
        ball ball207 = new ball();
        addObject(ball207,613,450);

        ball ball208 = new ball();
        addObject(ball208,56,450);
        ball ball209 = new ball();
        addObject(ball209,80,450);
        ball ball210 = new ball();
        addObject(ball210,567,450);
        ball ball211 = new ball();
        addObject(ball211,591,450);

        ball ball212 = new ball();
        addObject(ball212,80,470);
        ball ball213 = new ball();
        addObject(ball213,80,490);
        ball ball214 = new ball();
        addObject(ball214,80,507);
        ball ball215 = new ball();
        addObject(ball215,567,470);
        ball ball216 = new ball();
        addObject(ball216,567,490);
        ball ball217 = new ball();
        addObject(ball217,567,507);

        ball ball218 = new ball();
        addObject(ball218,176,450);
        ball ball219 = new ball();
        addObject(ball219,197,450);
        ball ball220 = new ball();
        addObject(ball220,218,450);
        ball ball221 = new ball();
        addObject(ball221,241,450);
        ball ball222 = new ball();
        addObject(ball222,265,450);
        ball ball223 = new ball();
        addObject(ball223,382,450);
        ball ball224 = new ball();
        addObject(ball224,404,450);
        ball ball225 = new ball();
        addObject(ball225,428,450);
        ball ball226 = new ball();
        addObject(ball226,450,450);
        ball ball227 = new ball();
        addObject(ball227,472,450);

        ball ball228 = new ball();
        addObject(ball228,219,469);
        ball ball229 = new ball();
        addObject(ball229,219,488);
        ball ball230 = new ball();
        addObject(ball230,219,508);
        ball ball231 = new ball();
        addObject(ball231,429,469);
        ball ball232 = new ball();
        addObject(ball232,429,488);
        ball ball233 = new ball();
        addObject(ball233,429,508);

        ball ball234 = new ball();
        addObject(ball234,35,507);
        ball ball235 = new ball();
        addObject(ball235,57,507);
        ball ball236 = new ball();
        addObject(ball236,104,507);
        ball ball237 = new ball();
        addObject(ball237,127,507);
        ball ball238 = new ball();
        addObject(ball238,243,507);
        ball ball239 = new ball();
        addObject(ball239,265,507);
        ball ball240 = new ball();
        addObject(ball240,288,507);
        ball ball241 = new ball();
        addObject(ball241,359,507);
        ball ball242 = new ball();
        addObject(ball242,382,507);
        ball ball243 = new ball();
        addObject(ball243,405,507);
        ball ball244 = new ball();
        addObject(ball244,521,507);
        ball ball245 = new ball();
        addObject(ball245,545,507);
        ball ball246 = new ball();
        addObject(ball246,591,507);
        ball ball247 = new ball();
        addObject(ball247,614,507);

        ball ball248 = new ball();
        addObject(ball248,34,527);
        ball ball249 = new ball();
        addObject(ball249,34,545);
        ball ball250 = new ball();
        addObject(ball250,34,565);
        ball ball251 = new ball();
        addObject(ball251,613,526);
        ball ball252 = new ball();
        addObject(ball252,613,547);
        ball ball253 = new ball();
        addObject(ball253,613,566);

        ball ball254 = new ball();
        addObject(ball254,57,565);
        ball ball255 = new ball();
        addObject(ball255,80,565);
        ball ball256 = new ball();
        addObject(ball256,103,565);
        ball ball257 = new ball();
        addObject(ball257,127,565);
        ball ball258 = new ball();
        addObject(ball258,150,565);
        ball ball259 = new ball();
        addObject(ball259,173,565);
        ball ball260 = new ball();
        addObject(ball260,196,565);
        ball ball261 = new ball();
        addObject(ball261,219,565);
        ball ball262 = new ball();
        addObject(ball262,243,565);
        ball ball263 = new ball();
        addObject(ball263,265,565);
        ball ball264 = new ball();
        addObject(ball264,289,565);
        ball ball265 = new ball();
        addObject(ball265,314,565);
        ball ball266 = new ball();
        addObject(ball266,335,565);
        ball ball267 = new ball();
        addObject(ball267,358,565);
        ball ball268 = new ball();
        addObject(ball268,382,565);
        ball ball269 = new ball();
        addObject(ball269,404,565);
        ball ball270 = new ball();
        addObject(ball270,428,565);
        ball ball271 = new ball();
        addObject(ball271,451,565);
        ball ball272 = new ball();
        addObject(ball272,475,565);
        ball ball273 = new ball();
        addObject(ball273,497,565);
        ball ball274 = new ball();
        addObject(ball274,520,566);
        ball ball275 = new ball();
        addObject(ball275,544,565);
        ball ball276 = new ball();
        addObject(ball276,568,565);
        ball ball277 = new ball();
        addObject(ball277,590,565);

        ball ball278 = new ball();
        addObject(ball278,289,527);
        ball ball279 = new ball();
        addObject(ball279,289,545);
        ball ball280 = new ball();
        addObject(ball280,358,526);
        ball ball281 = new ball();
        addObject(ball281,358,545);

        //Ghost spawn
        GhostSpawnPiece ghostSpawnPiece = new GhostSpawnPiece();
        addObject(ghostSpawnPiece,275,244);
        GhostSpawnPiece ghostSpawnPiece2 = new GhostSpawnPiece();
        addObject(ghostSpawnPiece2,373,244);
        GhostSpawnLong ghostSpawnLong = new GhostSpawnLong();
        addObject(ghostSpawnLong,323,311);

        GhostSpawnVertical ghostSpawnVertical = new GhostSpawnVertical();
        addObject(ghostSpawnVertical,244,272);
        GhostSpawnVertical ghostSpawnVertical2 = new GhostSpawnVertical();
        addObject(ghostSpawnVertical2,244,283);

        GhostSpawnVertical ghostSpawnVertical3 = new GhostSpawnVertical();
        addObject(ghostSpawnVertical3,402,272);
        GhostSpawnVertical ghostSpawnVertical4 = new GhostSpawnVertical();
        addObject(ghostSpawnVertical4,402,283);
        GhostSpawnDoor ghostSpawnDoor = new GhostSpawnDoor();
        addObject(ghostSpawnDoor,324,244);
        bigBall bigBall = new bigBall();
        addObject(bigBall,33,68);
        bigBall bigBall2 = new bigBall();
        addObject(bigBall2,613,67);
        bigBall bigBall3 = new bigBall();
        addObject(bigBall3,34,431);
        bigBall bigBall4 = new bigBall();
        addObject(bigBall4,613,450);
        bigBall3.setLocation(34, 450);

        ball199.setLocation(34,431);
        bigBall bigBall5 = new bigBall();
        addObject(bigBall3,34,450);
        bigBall4.setLocation(613,450);
        
        ball207.setLocation(613,431);
        
    }
    
    
    //         // Size is at scale width 28, heigh 31, numbers can be changed but scale should stay the same
    //         //super(812, 899, 1); 
    //         //setBackground("background.png");
}
        





