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
>>>>>>> 67cd7dce1c15d5888f0e9dc0b8a9d855985dc929
             
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
             
             addObject(new ball(),274,293);
             j++;
             addObject(new ball(),274,307);
             j++;
             addObject(new ball(),321,293);
             j++;*/
        //top
        bottomRightTP bottomRightTP = new bottomRightTP();
        addObject(bottomRightTP,24,32);
        bottomLeftRightTP bottomLeftRightTP = new bottomLeftRightTP();
        addObject(bottomLeftRightTP,147,32);
        bottmLeftTP bottmLeftTP = new bottmLeftTP();
        addObject(bottmLeftTP,286,32);
        bottomRightTP bottomRightTP2 = new bottomRightTP();
        addObject(bottomRightTP2,358,32);
        bottomLeftRightTP bottomLeftRightTP2 = new bottomLeftRightTP();
        addObject(bottomLeftRightTP2,497,32);
        bottmLeftTP bottmLeftTP2 = new bottmLeftTP();
        addObject(bottmLeftTP2,620,32);
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
        topLeftRight topLeftRight11 = new topLeftRight();
        addObject(topLeftRight11,286,568);
        topLeftRight topLeftRight12 = new topLeftRight();
        addObject(topLeftRight12,358,568);
        topLeftTP topLeftTP5 = new topLeftTP();
        addObject(topLeftTP5,620,568);
    }
    
    
    //         // Size is at scale width 28, heigh 31, numbers can be changed but scale should stay the same
    //         //super(812, 899, 1); 
    //         //setBackground("background.png");
}
        





