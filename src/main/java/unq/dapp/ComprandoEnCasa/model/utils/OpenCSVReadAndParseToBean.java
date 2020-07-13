package unq.dapp.ComprandoEnCasa.model.utils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OpenCSVReadAndParseToBean {
        private static final String SAMPLE_CSV_FILE_PATH = ".\\Productos.csv";

    public static List<CSVProduct> main(MultipartFile csv) throws IOException {
        try (
                Reader reader = new InputStreamReader(csv.getInputStream());
        ) {
            CsvToBean<CSVProduct> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVProduct.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVProduct> csvProductIterator = csvToBean.iterator();
            List<CSVProduct> result = new ArrayList<>();
            while (csvProductIterator.hasNext()) {
                CSVProduct csvProduct = csvProductIterator.next();
                result.add(csvProduct);
                System.out.println("Name : " + csvProduct.getName());
                System.out.println("Category : " + csvProduct.getCategory());
                System.out.println("Brand : " + csvProduct.getBrand());
                System.out.println("Stock : " + csvProduct.getStock());
                System.out.println("Price : " + csvProduct.getPrice());
                System.out.println("Image : " + csvProduct.getImage());
                System.out.println("==========================");

            }
            return result;
        }
    }
}