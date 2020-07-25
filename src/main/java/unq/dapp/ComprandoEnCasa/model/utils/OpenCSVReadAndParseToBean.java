package unq.dapp.ComprandoEnCasa.model.utils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.web.multipart.MultipartFile;
import unq.dapp.ComprandoEnCasa.model.domain.Product;
import unq.dapp.ComprandoEnCasa.model.dtos.ProductDTO;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OpenCSVReadAndParseToBean {

    public static List<ProductDTO> main(MultipartFile csv) throws IOException {
        try (
                Reader reader = new InputStreamReader(csv.getInputStream());
        ) {
            CsvToBean<ProductDTO> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(ProductDTO.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<ProductDTO> csvProductIterator = csvToBean.iterator();
            List<ProductDTO> result = new ArrayList<>();
            while (csvProductIterator.hasNext()) {
                ProductDTO csvProduct = csvProductIterator.next();
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