import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Console;

public class FileInsDel {

    public static void main(String[] args) {
        String TxtFileName = " ";    

        Console console = System.console();

        TxtFileName = console.readLine("Please input the text file name:");

        if (!TxtFileName.contains(".txt")){
            System.err.println("The file type is not correct.");
            System.exit(0);
        }  

        File TxtFile = new File(TxtFileName);

        if (!TxtFile.exists()){
            System.out.println("No such file or directory.");
            System.exit(0);
        }

        LinkedList list = new LinkedList();

        try {
            FileInputStream fis = new FileInputStream(TxtFile);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String msg;
            while ( ( msg = br.readLine()) != null ) {
                String[] param = msg.split(":");
                if ("i".equals(param[0])) {
                    list.insert(list, Integer.parseInt(param[1]));
                } else if ("d".equals(param[0])) {
                    list.delete(list, Integer.parseInt(param[1]));
                } 
            }            
            br.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        list.showList(list);

    }
}
