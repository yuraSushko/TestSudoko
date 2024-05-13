import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

//import  javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Window {
    static final int WIDTH=800;
    static final int HIGHT=600;
    static int numberSelected;
    SudokoLogic sudokoLogic = new SudokoLogic();



    public  void windowConfig(){
        JFrame window = new JFrame();
        window.setVisible(true);
        System.out.println(WIDTH/9);
        window.setLayout(null);
        window.setResizable(false);
        window.setSize(WIDTH,HIGHT);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        buttonsGridCreate(window );
        numbersSelectorCreate(window);
    }






    public JButton[] buttonsGridCreate(JFrame window  ){
        JButton[] buttonsGrid =  new JButton[81];
        ActionListener numberInsert = createListenerForInsert();
        for (int i = 0; i < buttonsGrid.length; i++) {
            buttonsGrid[i]= new JButton();
            window.add(buttonsGrid[i]);
            buttonsGrid[i].addActionListener(numberInsert);
        }
        int count=0;
        for (int rowNum = 0; rowNum < SudokoLogic.ROW_LENGTH; rowNum++) { //  row
            for (int colNum = 0; colNum < SudokoLogic.COL_LENGTH; colNum++) {  //column
                buttonsGrid[count].setName(rowNum+""+colNum);
                int sizeW = Integer.valueOf((int) (WIDTH*0.075));
                int SizeH=sizeW;
                buttonsGrid[count].setBounds(colNum*sizeW,rowNum*sizeW,sizeW,sizeW );
                count++;
            }
        }

        return buttonsGrid;
    }

    public  JButton[] numbersSelectorCreate(JFrame window  ){
        JButton[] numbersSelector =  new JButton[10];
        ActionListener numberSelectorListener= createListenerForSelect();
        int locX=Integer.valueOf((int) ((WIDTH*0.075)*11));
        for (int i = 0; i < numbersSelector.length; i++) {
            numbersSelector[i]= new JButton();
            window.add(numbersSelector[i]);
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
                if(numberSelected!=0){source.setText(numberSelected+"");}
                else{source.setText(null);}
                System.out.println(sudokoLogic.InsertSolutionAndCheckIfValid(x,y,numberSelected));
                //if (!sudokoLogic.InsertSolutionAndCheckIfValid(x,y,numberSelected)) {setForegroundRED}
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
            }
        };
        return numberSelectorListener;

    }

}
