public class Main {
    public static void main(String[] args) {
        Window window = new Window();
        //window.buttonsGridCreate();
        window.windowConfig();


        final int[] ALLOWED_INPUT ={1,2,3,4,5,6,7,8,9};
        boolean inProgrees=true;
        while (inProgrees){window.sudokoLogic.printGrid();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }









}