package unq.dapp.ComprandoEnCasa.model.utils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.web.multipart.MultipartFile;
import unq.dapp.ComprandoEnCasa.model.domain.Product;

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

    public static List<Product> main(MultipartFile csv) throws IOException {
        try (
                Reader reader = new InputStreamReader(csv.getInputStream());
        ) {
            CsvToBean<Product> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Product.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<Product> csvProductIterator = csvToBean.iterator();
            List<Product> result = new ArrayList<>();
            while (csvProductIterator.hasNext()) {
                Product csvProduct = csvProductIterator.next();
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