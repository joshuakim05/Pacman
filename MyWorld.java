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

        BorderSide borderSide = new BorderSide();
        addObject(borderSide,30,474);
        BorderSide borderSide2 = new BorderSide();
        addObject(borderSide2,599,466);
        borderSide2.setRotation(180);
        borderSide2.setLocation(616,476);

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

        // int j=0;
        // for(int i=359;i>14;i-=15)
        // {
               // addObject(ball.get(j),414,i);
               // j++;
               // addObject(ball.get(j),184,i);
               // j++;
        // }
        // for(int i=324;i<414;i+=15)
        // {
            // addObject(ball.get(j),i,29);
               // j++;
        // }
         // for(int i=429;i<504;i+=15)
        // {
            // addObject(ball.get(j),i,29);
               // j++;
        // }
        // for(int i=113;i<503;i+=15)
        // {
             // addObject(ball.get(j),i,397);
             // j++;
        // }
         // for(int i=199;i<401;i+=15)
        // {
             // addObject(ball.get(j),i,81);
             // j++;
             // addObject(ball.get(j),i,318);
             // j++;
        // }
        // for(int i=233;i<369;i+=15)
        // {
             // addObject(ball.get(j),i,239);
             // j++;
             // addObject(ball.get(j),i,161);
             // j++;
        // }
        // for(int i=177;i<237;i+=15)
        // {
             // addObject(ball.get(j),233,i);
             // j++;
             // addObject(ball.get(j),366,i);
             // j++;
        // }
        // for(int i=110;i<184;i+=15)
        // {
             // addObject(ball.get(j),i,29);
             // j++;
        // }
        // for(int i=199;i<280;i+=15)
        // {
             // addObject(ball.get(j),i,29);
             // j++;
        // }
         // for(int i=199;i<280;i+=15)
        // {
             // addObject(ball.get(j),i,279);
             // j++;
        // }
        // for(int i=320;i<410;i+=15)
        // {
             // addObject(ball.get(j),i,279);
             // j++;
        // }
         // for(int i=428;i<492;i+=15)
        // {
             // addObject(ball.get(j),i,360);
             // j++;
        // }
         // for(int i=169;i>108;i-=15)
        // {
             // addObject(ball.get(j),i,359);
             // j++;
        // }
         // for(int i=134;i<179;i+=15)
        // {
             // addObject(ball.get(j),i,200);
             // j++;
        // }
         // for(int i=431;i<491;i+=15)
        // {
             // addObject(ball.get(j),i,200);
             // j++;
        // }
          // for(int i=134;i<171;i+=15)
        // {
             // addObject(ball.get(j),i,279);
             // j++;
              // addObject(ball.get(j),i,80);
             // j++;
        // }
         // for(int i=109;i<171;i+=15)
        // {
             // addObject(ball.get(j),i,123);
             // j++;
        // }
         // for(int i=430;i<468;i+=15)
        // {
             // addObject(ball.get(j),i,80);
             // j++;
             // addObject(ball.get(j),i,122);
             // j++;
              // addObject(ball.get(j),i,279);
             // j++;
        // }
         // for(int i=230;i<277;i+=15)
        // {
             // addObject(ball.get(j),i,357);
             // j++;
             
        // }
          
        // addObject(ball.get(j),200,200);
             // j++;
             // addObject(ball.get(j),215,200);
             // j++;
              // addObject(ball.get(j),397,200);
             // j++;
             // addObject(ball.get(j),383,200);
             // j++;
             // addObject(ball.get(j),486,96);
             // j++;
             // addObject(ball.get(j),486,110);
             // j++;
             // addObject(ball.get(j),486,123);
             // j++;
             // addObject(ball.get(j),473,123);
             // j++;
             // addObject(ball.get(j),486,300);
             // j++;
             // addObject(ball.get(j),486,318);
             // j++;
             // addObject(ball.get(j),486,47);
             // j++;
              // addObject(ball.get(j),486,63);
             // j++;
              // addObject(ball.get(j),472,318);
             // j++;
             // addObject(ball.get(j),458,318);
             // j++;
             // addObject(ball.get(j),458,333);
             // j++;
             // addObject(ball.get(j),458,348);
             // j++;
             // addObject(ball.get(j),488,371);
             // j++;
             // addObject(ball.get(j),488,383);
             // j++;
             // addObject(ball.get(j),109,373);
             // j++;
             // addObject(ball.get(j),109,385);
             // j++;
             // addObject(ball.get(j),275,370);
             // j++;
             // addObject(ball.get(j),275,385);
             // j++;
             // addObject(ball.get(j),364,334);
             // j++;
             // addObject(ball.get(j),229,331);
             // j++;
             // addObject(ball.get(j),229,346);
             // j++;
             // addObject(ball.get(j),110,47);
             // j++;
             // addObject(ball.get(j),110,63);
             // j++;
             // addObject(ball.get(j),109,95);
             // j++;
             // addObject(ball.get(j),109,110);
             // j++;
             // addObject(ball.get(j),113,301);
             // j++;
             // addObject(ball.get(j),113,319);
             // j++;
             // addObject(ball.get(j),129,319);
             // j++;
             // addObject(ball.get(j),144,319);
             // j++;
             // addObject(ball.get(j),144,334);
             // j++;
             // addObject(ball.get(j),144,347);
             // j++;
             
             // addObject(ball.get(j),275,45);
             // j++;
             // addObject(ball.get(j),275,62);
             // j++;
             // addObject(ball.get(j),324,45);
             // j++;
             // addObject(ball.get(j),324,62);
             // j++;
             
             // addObject(ball.get(j),323,384);
             // j++;
             // addObject(ball.get(j),323,372);
             // j++;
             // addObject(ball.get(j),323,359);
             // j++;
             // addObject(ball.get(j),337,359);
             // j++;
             
             // addObject(ball.get(j),231,97);
             // j++;
             // addObject(ball.get(j),253,120);
             // j++;
             // addObject(ball.get(j),266,120);
             // j++;
             // addObject(ball.get(j),278,120);
             // j++;
             // addObject(ball.get(j),278,135);
             // j++;
             // addObject(ball.get(j),278,148);
             // j++;
             
             // addObject(ball.get(j),368,97);
             // j++;
             // addObject(ball.get(j),368,109);
             // j++;
             // addObject(ball.get(j),368,122);
             // j++;
             // addObject(ball.get(j),354,122);
             // j++;
             // addObject(ball.get(j),339,122);
             // j++;
             // addObject(ball.get(j),324,122);
             // j++;
             // addObject(ball.get(j),324,136);
             // j++;
             // addObject(ball.get(j),324,149);
             // j++;
             
             // addObject(ball.get(j),234,254);
             // j++;
             // addObject(ball.get(j),234,269);
             // j++;
             // addObject(ball.get(j),369,254);
             // j++;
             // addObject(ball.get(j),369,269);
             // j++;
             
             // addObject(ball.get(j),274,293);
             // j++;
             // addObject(ball.get(j),274,307);
             // j++;
             // addObject(ball.get(j),321,293);
             // j++;
             // addObject(ball.get(j),321,307);
    // }
    
    
            // Size is at scale width 28, heigh 31, numbers can be changed but scale should stay the same
            //super(812, 899, 1); 
            //setBackground("background.png");

    
        
}}
