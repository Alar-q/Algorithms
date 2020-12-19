package File;

import java.io.*;

public class BufferedIO {

    public static void writeDoubleToTxt(String fileName, double[] array){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(fileName, true))) {
            for (double value : array) {
                writter.write(value + "\n");//write() - записать
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readDoubleFromTxt(String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            double d;
            String line;
            while ( (line = reader.readLine()) != null) {
                d = Double.parseDouble(line);
                //Делай что надо
                System.out.println(d +"\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
