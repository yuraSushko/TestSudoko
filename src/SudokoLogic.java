public class SudokoLogic {
    static final int ROW_LENGTH=9;
    static final int COL_LENGTH=9;
    private int[][] grid= new int[ROW_LENGTH][COL_LENGTH];



    public  void printGrid() {

        for (int i = 0; i < this.grid.length ; i++) {
            for (int j = 0; j < this.grid.length ; j++) {
                System.out.print(this.grid[i][j]  + " ");
            }
            System.out.println();
        }
    }

    public int[] countToatalAnswers(){
        int[] coutTot= new int[10];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                coutTot[grid[i][j]]++;
            }
        }
        return coutTot;
    }

    public  boolean countIsDistinctCheck(int[] rowDistinctCount){
        boolean distinct= true;

        for (int i = 1; i < rowDistinctCount.length; i++) {
            if(rowDistinctCount[i]>1){distinct=false;}
        }
        return distinct;
    }


    //change to be location place (col+1%3  go stepps up  || row+1%3 go stepps up )
    public  boolean InsertSolutionAndCheckIfValid(int x, int y, int num){
        grid[x][y]=num;
        boolean distinct =true;
        System.out.println("ruuning check");
        for (int row = 0; row < this.grid.length; row++) {
            int[] rowDistinctCount=new int[10];
            int[] ColumnDistinctCount=new int[10];
            for (int col = 0; col < this.grid.length; col++) {
                rowDistinctCount[this.grid[row][col]]++;
                ColumnDistinctCount[this.grid[col][row]]++;
            }
            if(!countIsDistinctCheck(rowDistinctCount)){distinct=false; row=10; }
            if(!countIsDistinctCheck(ColumnDistinctCount)){distinct=false; row=10; }
        }
        // 00 , 03 , 06 , 30 , 33 , 36 , 60 ,63 , 66
        if(distinct) {
            for (int i = 0; i < this.grid.length; i += 3) {
                for (int j = 0; j < this.grid.length; j += 3) {
                    distinct = checkBoxHasDistinctNums(i, j);
                    System.out.println("check box distinct? " + distinct + " i: " + i + " j: " + j);
                    if (!distinct) {
                        j = 10;
                        i = 10;
                        break;
                    }
                }
            }
        }
        return distinct;
    }
    public  boolean checkBoxHasDistinctNums(int row, int col){
        boolean distinct =true;
        int[] boxDistinctCount=new int[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boxDistinctCount[grid[row+i][col+j]]++;
                System.out.println(grid[row+i][col+j]);
            }
        }
        if(!countIsDistinctCheck(boxDistinctCount)){distinct=false;}
        return distinct;
    }





}
