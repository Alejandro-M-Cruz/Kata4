package Kata4;

import Persistency.EmailLoader;
import Persistency.FileLoader;
import Persistency.Loader;
import View.HistogramDisplay;
import View.Histogram;
import java.io.File;
import java.util.List;

public class Kata4 {

    public static void main(String[] args) {
        Histogram<String> histogram = new Histogram<String>();
        Loader emailLoader = new EmailLoader(new FileLoader(new File("email.txt")));
        List<String> emails = emailLoader.load();
        for (String email : emails) {
            histogram.increment(email.split("@")[1]);
        }
        HistogramDisplay histogramDisplay = new HistogramDisplay("Histogram", histogram);
        histogramDisplay.execute();
    }
    
}
