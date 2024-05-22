import java.io.*;

public class Task1 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            File outputFile = new File("output.txt");

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));

            String line;
            int lineCount = 0;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (lineCount == 2) {
                    writer.write(line);
                    writer.newLine();
                } else if (lineCount > 2) {
                    String[] strNums = line.split(" ");
                    for (String strNum : strNums) {
                        try {
                            double num = Double.parseDouble(strNum);
                            if(num > 0) {
                                writer.write(strNum + " ");
                            }
                        } catch (NumberFormatException e) {
                            // не число, пропустить
                        }
                    }
                    writer.newLine();
                }
            }

            reader.close();
            writer.close();
        } catch (IOException ex) {
            System.out.println("Ошибка чтения/записи файла: " + ex.getMessage());
        }
    }

}
