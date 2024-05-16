import javax.sound.sampled.Line;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

//import  javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Window extends JFrame {
    static final int WIDTH=800;
    static final int HIGHT=600;
    static final int BUFFER=4;
    static int numberSelected;
    SudokoLogic sudokoLogic = new SudokoLogic();
    private JButton[] numbersSelector;



    public  void windowConfig(){
        this.setVisible(true);
        System.out.println(WIDTH/9);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(WIDTH,HIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        MainScene mainScene = new MainScene(0,0,WIDTH,HIGHT);
        mainScene.setVisible(true);
        mainScene.repaint();
        this.add(mainScene);
        mainScene.repaint();
        this.buttonsGridCreate();
        this.numbersSelectorCreate();
    }






    public JButton[] buttonsGridCreate(  ){
        JButton[] buttonsGrid =  new JButton[81];
        ActionListener numberInsert = createListenerForInsert();
        for (int i = 0; i < buttonsGrid.length; i++) {
            buttonsGrid[i]= new JButton();
            this.add(buttonsGrid[i]);
            buttonsGrid[i].addActionListener(numberInsert);
        }
        int count=0,  bufferCOL=0,bufferROW=0;
        for (int rowNum = 0; rowNum < SudokoLogic.ROW_LENGTH; rowNum++) { //  row
            if( (rowNum)%3==0 ){bufferCOL+=BUFFER;}
            bufferROW=0;
            for (int colNum = 0; colNum < SudokoLogic.COL_LENGTH; colNum++) {  //column
                if( (colNum)%3==0 ){bufferROW+=BUFFER;}
                buttonsGrid[count].setName(rowNum+""+colNum);
                int sizeW = Integer.valueOf((int) (WIDTH*0.075));
                int SizeH=sizeW;
                buttonsGrid[count].setBounds (( colNum*sizeW )+bufferROW ,(rowNum*sizeW)+bufferCOL ,sizeW ,sizeW );

                count++;
            }
        }

        return buttonsGrid;
    }

    public  JButton[] numbersSelectorCreate( ){
        numbersSelector =  new JButton[10];
        ActionListener numberSelectorListener= createListenerForSelect();
        int locX=Integer.valueOf((int) ((WIDTH*0.075)*11));
        for (int i = 0; i < numbersSelector.length; i++) {
            numbersSelector[i]= new JButton();
            this.add(numbersSelector[i]);
            numbersSelector[i].setText(i+1+"");
            numbersSelector[i].setName(i+1+"");
            numbersSelector[i].setBounds( locX, (int) (WIDTH*0.07)*i,(int)(WIDTH*0.07),(int)(WIDTH*0.07) );
            numbersSelector[i].addActionListener(numberSelectorListener);
        }
        numbersSelector[9].setName("0");
        numbersSelector[9].setText("Del");
         return numbersSelector;
    }



    public ActionListener createListenerForInsert(){
        ActionListener buttonClickListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                String buttonLabel = source.getName();
                System.out.println(buttonLabel + " clicked." );
                int x =Integer.parseInt(buttonLabel) /10; int y=Integer.parseInt(buttonLabel) %10;
                if(numberSelected!=0){source.setText(numberSelected+"");source.setBackground(null);}
                else{source.setText(null);source.setBackground(null);}
                /// because it cecjes all grid if there is two mistakes there is bug with backroud set back default
                if (!sudokoLogic.InsertSolutionAndCheckIfValid(x,y,numberSelected)) {source.setBackground(RED);}
                else{source.setBackground(null);}
            }
        };
        return buttonClickListener;
    }

    public  ActionListener createListenerForSelect() {
        ActionListener numberSelectorListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                String buttonLabel = source.getName();
                numberSelected=Integer.parseInt(buttonLabel);
                /*int[] countNumbersAnswered= sudokoLogic.countToatalAnswers();
                int count=0;
                for (int i = 0; i < countNumbersAnswered.length; i++) {
                    if(countNumbersAnswered[i]==9){
                        count++;
                        numbersSelector[i].setBackground(GREEN);
                    }
                    else{numbersSelector[i].setBackground(null);}
                }*/


            }
        };
        return numberSelectorListener;

    }

}
