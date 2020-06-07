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
		Sector sector =(Sector.FARMACY);
		String address = "Av.Callo 110";
		List<PayMethods> payMethods = new ArrayList<PayMethods>();
		payMethods.add(PayMethods.CASH);
		Integer maxDistance = 100 ;
		AttentionSchedule attentionSchedule = new AttentionSchedule();
		Commerce commerce = new Commerce(sector, address, payMethods,maxDistance, attentionSchedule);

		//Commerce2
		Sector sector2 =(Sector.FOOD);
		String address2 = "Av.Mitre 550";
		List<PayMethods> payMethods2 = new ArrayList<PayMethods>();
		payMethods2.add(PayMethods.CREDIT_CARD);
		payMethods2.add(PayMethods.CASH);
		Integer maxDistance2 = 300;
		AttentionSchedule attentionSchedule2 = new AttentionSchedule();
		Commerce commerce2 = new Commerce(sector2, address2, payMethods2,maxDistance2, attentionSchedule2);

		//Add commerce

		commerceService.save(commerce);
		commerceService.save(commerce2);

		//User1

		String username1 = "userName1";
		String password1 = "password1";
		String email1 = "user1@gmail.com";
		String name1 = "userName1";
		String lastName1 = "userLastName1";
		User user1 = new User(username1,password1,email1,name1,lastName1);

		//User2
		String username2 = "userName2";
		String password2 = "password2";
		String email2 = "user2@gmail.com";
		String name2 = "userName2";
		String lastName2 = "userLastName2";
		User user2 = new User (username2,password2,email2,name2,lastName2);

		userService.save(user1);
		userService.save(user2);

		//Product1
		String productName1 = "Sprite 3L";
		Category productCategory1 = Category.BEBIBAS;
		String productBrand1 = "The Coca-Cola Company";
		Integer productStock1 = 4;
		Integer productPrice1 = 100;
		String productImage1 = "https://supermercado.carrefour.com.ar/media/catalog/product/cache/1/image/1000x/040ec09b1e35df139433887a97daa66f/7/7/7790895064128_02.jpg";
		Product product1= new Product("1",productName1,productCategory1,productBrand1,productStock1,productPrice1,productImage1);

		//Product2
		String productName2 = "CocaCola 3L";
		Category productCategory2 = Category.BEBIBAS;
		String productBrand2 = "The Coca-Cola Company";
		Integer productStock2 = 4;
		Integer productPrice2 = 100;
		String productImage2 = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR4lZknniLgWZT9rQoYGxi5v_r3P5OV8ilA_9JpJiYJop0lbpoV&usqp=CAU";
		Product product2= new Product("1",productName2,productCategory2,productBrand2,productStock2,productPrice2,productImage2);

		//Product3

		Product product3= new Product("2",productName2,productCategory2,productBrand2,productStock2,productPrice2,productImage2);

		productService.save(product1);
		productService.save(product2);
		productService.save(product3);
	}
}
