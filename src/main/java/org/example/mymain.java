package org.example;

import org.grobid.core.data.BiblioItem;
import org.grobid.core.engines.Engine;
import org.grobid.core.factory.GrobidFactory;
import org.grobid.core.main.GrobidHomeFinder;
import org.grobid.core.utilities.GrobidProperties;

import java.util.Arrays;

public class mymain {
    public static void main(String[] args) throws Exception {

        String pdfPath = "src/main/resources/Attention_Is_All_You_Need.pdf";

        // String pdfPath = "/home/salomon/Desktop/grobid-example/src/test/resources/HAL.pdf";
        try {
            // TODO you need to provide your local path to grobid folder
            String pGrobidHome = "/home/salomon/Desktop/grobid-0.6.0/grobid-home";

            // The GrobidHomeFinder can be instantiate without parameters to verify the grobid home in the standard
            // location (classpath, ../grobid-home, ../../grobid-home)

            // If the location is customised:
            GrobidHomeFinder grobidHomeFinder = new GrobidHomeFinder(Arrays.asList(pGrobidHome));

            //The GrobidProperties needs to be instantiate using the correct grobidHomeFinder or it will use the default
            //locations
            GrobidProperties.getInstance(grobidHomeFinder);

            System.out.println(">>>>>>>> GROBID_HOME=" + GrobidProperties.get_GROBID_HOME_PATH());

            Engine engine = GrobidFactory.getInstance().createEngine();

            // Biblio object for the result
            BiblioItem resHeader = new BiblioItem();
            String tei = engine.processHeader(pdfPath, 1, resHeader);

            System.out.println("tei " + tei);
        } catch (Exception e) {
            // If an exception is generated, print a stack trace
            e.printStackTrace();
        }

        System.out.println("x");
    }

}
