public class Main {

    public static void main(String[] args) {
        String inFileName = args[0];
        String outfileName =args[1];
        inFileHandler inFileHandler = new inFileHandler(inFileName);
        Averager averager = new Averager(inFileHandler.getHeader());
        averager.loadMirrorAry(inFileHandler.getScanner());
        averager.processAveraging();
        OutFileHandler outfile = new OutFileHandler(outfileName);
        outfile.writeToFile(averager.getTempArray(),averager.getNumRows(),
                averager.getNumCols(),averager.getNewHeader());


        inFileHandler.closeFile();
    }
}
