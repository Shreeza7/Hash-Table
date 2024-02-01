import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] names = new String[73];

        File file = new File("D:\\390\\data.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String s;
        int i = 0;
        while ((s = br.readLine()) != null) {
            names[i] = s;
            i++;
        }
        fr.close();

        HashMe table = new HashMe();
        table.Hash(200, names);
        table.showTable();
        table.reHash(400, names);
        table.showTable();
        table.reHash(700, names);
        table.showTable();
    }

}
