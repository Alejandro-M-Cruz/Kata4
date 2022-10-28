package Persistency;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class EmailLoader implements Loader {
    private final Loader loader;
    private final List<String> emails = new ArrayList<>();
    
    public EmailLoader(Loader loader) {
        this.loader = loader;
    }
    
    @Override
    public List<String> load() {
        List<String> list = loader.load();
        for (String line : list) {
            if(isEmail(line)) emails.add(line);
        }
        return emails;
    }

    private static final Pattern emailPattern = Pattern.compile("^[\\w-\\.]+@[\\w-]+\\.[\\w]{2,4}$");
    private boolean isEmail(String line) {
        return emailPattern.matcher(line).matches();
    }
}
