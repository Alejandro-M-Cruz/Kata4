package Persistency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileLoader implements Loader {
    private File file;

    public FileLoader(File file) {
        this.file = file;
    }
    
    @Override
    public List<String> load() {
        List<String> list = new ArrayList<>();
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while(true) {
                line = reader.readLine();
                if (line == null) break;
                list.add(line);
            }
        } catch (Exception e) {
            System.out.println("Se ha producido un error al leer el archivo");
        }
        return list;
    }
}
