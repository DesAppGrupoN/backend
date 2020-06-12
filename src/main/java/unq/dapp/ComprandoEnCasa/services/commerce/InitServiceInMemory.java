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
		String addressCommerce = "Av.Callo 110";
		String imageCommerce = "https://http2.mlstatic.com/nebulizador-ultrasonico-silencioso-soy-tu-farmacia-D_NQ_NP_951042-MLA31062198598_062019-F.webp";
		List<PayMethods> payMethodsCommerce = new ArrayList<PayMethods>();
		payMethodsCommerce.add(PayMethods.CASH);
		Integer maxDistanceCommerce = 100 ;
		AttentionSchedule attentionScheduleCommerce = new AttentionSchedule();
		Commerce commerce1 = new Commerce(nameCommerce,descriptionCommerce,sectorCommerce, addressCommerce,imageCommerce, payMethodsCommerce,maxDistanceCommerce, attentionScheduleCommerce);

		//Commerce2
		String nameCommerce2 = "Ringo";
		String descriptionCommerce2 = "Delicious Food Express";
		Sector sectorCommerce2 =(Sector.FOOD);
		String addressCommerce2 = "Av.Mitre 550";
		String imageCommerce2 = "https://i.pinimg.com/originals/0b/8a/0d/0b8a0dafba62324247e9febcd7083874.jpg";
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
		String nameProduct1 = "Sprite 3L";
		Category categoryProduct1 = Category.BEBIBAS;
		String brandProduct1 = "The Coca-Cola Company";
		Integer stockProduct1 = 1;
		Integer priceProduct1 = 120;
		String imageProduct1 = "https://supermercado.carrefour.com.ar/media/catalog/product/cache/1/image/1000x/040ec09b1e35df139433887a97daa66f/7/7/7790895064128_02.jpg";
		Product product1= new Product(1,nameProduct1,categoryProduct1,brandProduct1,stockProduct1,priceProduct1,imageProduct1);

		//Product2
		String nameProduct2 = "CocaCola 3L";
		Category categoryProduct2 = Category.BEBIBAS;
		String brandProduct2 = "The Coca-Cola Company";
		Integer stockProduct2 = 4;
		Integer priceProduct2 = 100;
		String imageProduct2 = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR4lZknniLgWZT9rQoYGxi5v_r3P5OV8ilA_9JpJiYJop0lbpoV&usqp=CAU";
		Product product2= new Product(1,nameProduct2,categoryProduct2,brandProduct2,stockProduct2,priceProduct2,imageProduct2);

		//Product3
		Integer stockProduct3 = 5 ;
		Integer priceProduct3 = 150;
		Product product3= new Product(2,nameProduct2,categoryProduct2,brandProduct2,stockProduct3,priceProduct3,imageProduct2);

		//Add products
		productService.save(product1);
		productService.save(product2);
		productService.save(product3);
	}
}
