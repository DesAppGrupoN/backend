package unq.dapp.ComprandoEnCasa.model.domain.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import unq.dapp.ComprandoEnCasa.model.utils.CSVProduct;
import unq.dapp.ComprandoEnCasa.model.utils.OpenCSVReadAndParseToBean;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OpencsvTest {
@Test
        public void testBuilder() throws IOException {
    String[] errorSoon = new String[100];


     OpenCSVReadAndParseToBean open = new OpenCSVReadAndParseToBean();
    List<CSVProduct> res = open.main(errorSoon);
    Assertions.assertEquals(res.size(),3);


}
}
