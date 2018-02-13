
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutFileHandler {
    File outFile;
    private String dir;
    OutFileHandler(String directory){
        this.dir = directory;
        this.outFile = new File(directory);



    }


    public void writeToFile(int[][] array, int numrows, int numcolumns, String header){
        FileWriter fwriter = null;
        BufferedWriter writer = null;

        try{
            fwriter = new FileWriter(outFile, true);
            writer = new BufferedWriter(fwriter);
            writer.write(header);
            writer.newLine();
            int row = 1;
            int column=1;
            for (int i = 0; i < numrows*numcolumns; i++) {
                writer.write(array[row][column]+" ");

                if(column==numcolumns){
                    writer.newLine();
                    row++;
                    column=1;
                    continue;
                }
                column++;

            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}