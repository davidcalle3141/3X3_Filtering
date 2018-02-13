import java.util.Scanner;

public class Averager {
    private int numRows;
    private int numCols;
    private int minVal;
    private int maxVal;
    private int newMin;
    private int newMax;
    private int[] neighborArray;
    private int[][] tempArray;
    private int [][] mirrorFramedAry;

    public Averager(int[] header) {
        this.numRows = header[0];
        this.numCols = header[1];
        this.minVal = header[2];
        this.maxVal = header[3];
        this.tempArray = new int[numRows+2][numCols+2];
        this.mirrorFramedAry= new int[numRows+2][numCols+2];


    }
    public void loadMirrorAry(Scanner scanner) {
        int row=1;
        int column =1;

        while(scanner.hasNext()){
            int i= scanner.nextInt();
            mirrorFramedAry[row][column]=i;

            if(column==numCols){
                column=1;
                row++;

                System.out.println(i);
                continue;
            }
           column++;
        }

    MirrorFrame(mirrorFramedAry);
    }
    public void MirrorFrame(int[][] arr){
        int pos;
        //top
        for (pos = 1; pos < numCols; pos++) {
            int b= arr[1][pos];
            System.out.println(b);
            arr[0][pos]=  arr[1][pos];

        }
        arr[0][pos+1]= arr[1][pos];
        //bottom
        for(pos = numCols; pos>0; pos--){

            arr[numRows+1][pos]=arr[numRows][pos];
        }

        arr[numRows+1][pos]= arr[numRows+1][pos+1];
        //right
        for (pos = 1; pos<numRows; pos++){
            arr[pos][numCols+1]= arr[pos][numCols];

        }

        arr[pos+1][numCols+1]= arr[pos+1][numCols];
        //left
        for(pos = numRows; pos>0;pos--){
            arr[pos][0]= arr[pos][1];

        }//System.out.println(pos);
        arr[0][pos]= arr[1][pos];


        }





    public int[] getNeighbors(int row, int column, int[][] arr){
        int[] neighbors =new int[9];
        int tempColumn= column-1;
        int tempRow = row-1;
        int count = 0;

        for (int i = 0; i <neighbors.length; i++) {
            count++;
           neighbors[i]= arr[tempRow][tempColumn];
            if(count % 3==0){
                tempRow++;
                tempColumn=column-1;
                continue;
            }
            tempColumn++;

        }
    return neighbors;

    }
    public int getArrayAverage(int[] neighbors){
        int sum=0;

        for (int neighbor : neighbors) {
            sum = sum + neighbor;
        }
       return sum/9;


    }
    public void processAveraging(){
        int colums =1;
        int row=1;
        int count = 0;
        while(count != numRows*numCols){
            count++;


            int avgValue  = getArrayAverage(
                    getNeighbors(row,colums,mirrorFramedAry));
            if(avgValue< minVal)minVal=avgValue;
            if(avgValue> maxVal)maxVal=avgValue;


            tempArray[row][colums]= avgValue;


              if(colums%numCols==0){
                row++;//rows
                colums=1;//columns
                  continue;

            }
            colums++;
        }
        System.out.println(count);
    }

    public int[][] getTempArray(){
        return tempArray;
    }

    public int getNumRows() {
        return numRows;
    }
    public int getNumCols(){
        return numCols;
    }

    public String getNewHeader(){
        return numRows+" "+numCols+" "+minVal+" "+maxVal;
    }

}
