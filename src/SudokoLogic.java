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

    public  boolean countGreterThanTwoCheck(int[] rowDistinctCount){
        boolean distinct= true;

        for (int i = 1; i < rowDistinctCount.length; i++) {
            if(rowDistinctCount[i]>1){distinct=false;}
        }
        return distinct;
    }
    public  boolean InsertSolutionAndCheckIfValid(int x, int y, int num){
        grid[x][y]=num;
        boolean distinct =true;
        System.out.println("ruuning check");
        for (int i = 0; i < this.grid.length; i++) {
            int[] rowDistinctCount=new int[10];
            int[] ColumnDistinctCount=new int[10];
            for (int j = 0; j < this.grid.length; j++) {
                rowDistinctCount[this.grid[i][j]]++;
                ColumnDistinctCount[this.grid[j][i]]++;
            }
            if(countGreterThanTwoCheck(rowDistinctCount)){distinct=false; i=10; }
            if(countGreterThanTwoCheck(ColumnDistinctCount)){distinct=false; i=10; } ////////////  check if allowed
        }

        int i,j,limRow=3,limCol=3, maxLimRow=grid.length,maxLimCol=grid.length;
        for (i=0; i < limRow; i++) {
            int[] boxDistinctCount=new int[10];
            for (j = 0; j < limCol; j++) {
                boxDistinctCount[grid[i][j]]++;
            }
            if((i+1)%3==0) {
                if (countGreterThanTwoCheck(boxDistinctCount)) {distinct = false; i = maxLimRow; }
                else if(i+3 < maxLimRow) {limRow+=3;limCol+=3;}
            }
        }
        // 0-2, 0-2  ||  3-5, 0-2 || 6-8, 0-2
        // 0-2, 3-5  ||  3-5, 3-5 || 6-8, 3-5
        // 0-2, 6-8  ||  3-5, 6-8 || 6-8, 6-8

        return distinct;
    }
}
