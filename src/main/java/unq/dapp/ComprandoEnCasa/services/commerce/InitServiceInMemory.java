package unq.dapp.ComprandoEnCasa.services.commerce;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import unq.dapp.ComprandoEnCasa.model.domain.Category;
import unq.dapp.ComprandoEnCasa.model.domain.Product;
import unq.dapp.ComprandoEnCasa.model.domain.User;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.AttentionSchedule;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.PayMethods;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Sector;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class InitServiceInMemory {

    @Value("${pring.datasource.driverClassName:NONE}")
    private String className;

	@Autowired
	private CommerceService commerceService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@PostConstruct
	public void initialize() {
			fireInitialData();
		}


	private void fireInitialData() {
		//Commerce1
		String nameCommerce = "Soy tu Farmacia";
		String descriptionCommerce = "Red de servicios de atención farmacéutica y perfumerías.";
		Sector sectorCommerce =(Sector.FARMACY);
		String addressCommerce = "Av. Hipólito Yrigoyen 162, Quilmes, Provincia de Buenos Aires";
		String imageCommerce = "https://http2.mlstatic.com/nebulizador-ultrasonico-silencioso-soy-tu-farmacia-D_NQ_NP_951042-MLA31062198598_062019-F.webp";
		List<PayMethods> payMethodsCommerce = new ArrayList<PayMethods>();
		payMethodsCommerce.add(PayMethods.CASH);
		Integer maxDistanceCommerce = 100 ;
		AttentionSchedule attentionScheduleCommerce = new AttentionSchedule();
		Commerce commerce1 = new Commerce(nameCommerce,descriptionCommerce,sectorCommerce, addressCommerce,imageCommerce, payMethodsCommerce,maxDistanceCommerce, attentionScheduleCommerce);

		//Commerce2
		String nameCommerce2 = "La Tanita Pastas";
		String descriptionCommerce2 = "Comida para llevar, Reservas, Asiento, Sillitas altas disponibles, Sirve alcohol, Wi-Fi gratis, Servicio de mesa";
		Sector sectorCommerce2 =(Sector.FOOD);
		String addressCommerce2 = "Colón 272, Quilmes, Provincia de Buenos Aires";
		String imageCommerce2 = "https://dondecomequilmes.com/wp-content/uploads/2016/06/La-Tanita_lgtn2.jpg";
		List<PayMethods> payMethodsCommerce2 = new ArrayList<PayMethods>();
		payMethodsCommerce2.add(PayMethods.CREDIT_CARD);
		payMethodsCommerce2.add(PayMethods.CASH);
		Integer maxDistanceCommerce2 = 300;
		AttentionSchedule attentionScheduleCommerce2 = new AttentionSchedule();

		Commerce commerce2 = new Commerce(nameCommerce2,descriptionCommerce2,sectorCommerce2, addressCommerce2,imageCommerce2, payMethodsCommerce2,maxDistanceCommerce2, attentionScheduleCommerce2);

		//Add commerces

		commerceService.save(commerce1);
		commerceService.save(commerce2);

		//User1

		String usernameUser1 = "userName1";
		String passwordUser1 = "password1";
		String emailUser1 = "user1@gmail.com";
		String nameUser1 = "userName1";
		String lastNameUser1 = "userLastName1";
		User user1 = new User(usernameUser1,passwordUser1,emailUser1,nameUser1,lastNameUser1);

		//User2
		String usernameUser2 = "userName2";
		String passwordUser2 = "password2";
		String emailUser2 = "user2@gmail.com";
		String nameUserUser2 = "userName2";
		String lastNameUser2 = "userLastName2";
		User user2 = new User (usernameUser2,passwordUser2,emailUser2,nameUserUser2,lastNameUser2);

		//Add users
		userService.save(user1);
		userService.save(user2);

		//Product1
		String nameProduct1 = "Perfume Le Male Edt 125 Ml";
		Category categoryProduct1 = Category.CLEANING;
		String brandProduct1 = "Jean Paul Gaultier";
		Integer stockProduct1 = 4;
		Integer priceProduct1 = 6800;
		String imageProduct1 = "https://cdn.batitienda.com/baticloud/images/product_ml_c4b8d08e0f9647f5ba3e40ad49a22caa_637086375184871160_0_m.webp";
		Product product1= new Product(1,nameProduct1,categoryProduct1,brandProduct1,stockProduct1,priceProduct1,imageProduct1);

		//Product2

		String nameProduct2 = "Enjuague Bucal Cuidado Total Zero 250 Ml";
		Category categoryProduct2 = Category.CLEANING;
		String brandProduct2 = "Listerine";
		Integer stockProduct2 = 4;
		Integer priceProduct2 = 270;
		String imageProduct2 = "https://cdn.batitienda.com/baticloud/images/product_ml_8c10ca2c011645bda61d701a28951639_637158394641424446_0_m.webp";
		Product product2= new Product(1,nameProduct2,categoryProduct2,brandProduct2,stockProduct2,priceProduct2,imageProduct2);

		//Product3
		String nameProduct3 = "CocaCola 3L";
		Category categoryProduct3 = Category.DRINK;
		String brandProduct3 = "The Coca-Cola Company";
		Integer stockProduct3 = 4;
		Integer priceProduct3 = 100;
		String imageProduct3 = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR4lZknniLgWZT9rQoYGxi5v_r3P5OV8ilA_9JpJiYJop0lbpoV&usqp=CAU";
		Product product3= new Product(2,nameProduct3,categoryProduct3,brandProduct3,stockProduct3,priceProduct3,imageProduct3);

		//Product4
		String nameProduct4 = "Sprite 3L";
		Category categoryProduct4 = Category.DRINK;
		String brandProduct4 = "The Coca-Cola Company";
		Integer stockProduct4 = 1;
		Integer priceProduct4 = 120;
		String imageProduct4 = "https://supermercado.carrefour.com.ar/media/catalog/product/cache/1/image/1000x/040ec09b1e35df139433887a97daa66f/7/7/7790895064128_02.jpg";
		Product product4= new Product(2,nameProduct4,categoryProduct4,brandProduct4,stockProduct4,priceProduct4,imageProduct4);

		//Product4
		String nameProduct5 = "Sorrentinos Fritos con Salsa de Hongos";
		Category categoryProduct5 = Category.FOOD;
		String brandProduct5 = "La Tanita";
		Integer stockProduct5 = 1;
		Integer priceProduct5 = 120;
		String imageProduct5 = "https://media-cdn.tripadvisor.com/media/photo-s/18/83/3f/82/sorrentinos-fritos-con.jpg";
		Product product5= new Product(2,nameProduct5,categoryProduct5,brandProduct5,stockProduct5,priceProduct5,imageProduct5);

		//Add products
		productService.save(product1);
		productService.save(product2);
		productService.save(product3);
		productService.save(product4);
		productService.save(product5);
	}
}
