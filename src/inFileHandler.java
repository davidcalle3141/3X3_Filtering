import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class inFileHandler {


        private Scanner scanner;
        private File file;
        private int[] header;


    public inFileHandler(String fileName){
            this.file = new File(fileName);
            this.scanner = setScanner(file);
            this.header = scanHeader(scanner);


        }

        private Scanner setScanner(File file) {
            try {
                return new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("File Not Found");
            }
            return null;
        }

        private int[] scanHeader(Scanner scanner){
            int[] header = new int[4];
            for (int i = 0; i< 4; i++){
                header[i]= scanner.nextInt();

            }
            return  header;

        }

        private void CreateFilter(int[] arr){

        }

        public Scanner getScanner(){
            return this.scanner;
        }
        public void closeFile(){
            this.scanner.close();
        }

        public int[] getHeader() {
            return header;
        }
        public String getHeaderString(){

            return header[0]+" "+header[1]+" "+header[2]+" "+header[3];
        }
    }