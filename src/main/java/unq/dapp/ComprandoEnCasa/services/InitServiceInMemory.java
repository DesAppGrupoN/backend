package unq.dapp.ComprandoEnCasa.services;

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
import unq.dapp.ComprandoEnCasa.model.dtos.ProductDTO;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class InitServiceInMemory {

	@Value("${pring.datasource.driverClassName:NONE}")
	private String className;

	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@PostConstruct
	public void initialize() {
		fireInitialData();
	}


	private void fireInitialData() {

		//User1

		String usernameUser1 = "ramiro";
		String passwordUser1 = "12345";
		String emailUser1 = "reekremag@gmail.com";
		String nameUser1 = "Ramiro";
		String lastNameUser1 = "userLastName1";
		User user1 = new User(usernameUser1, passwordUser1, emailUser1, nameUser1, lastNameUser1);

		//User2
		String usernameUser2 = "grupondes";
		String passwordUser2 = "12345";
		String emailUser2 = "grupondes@gmail.com";
		String nameUserUser2 = "Grupo";
		String lastNameUser2 = "N";
		User user2 = new User (usernameUser2, passwordUser2, emailUser2, nameUserUser2, lastNameUser2);


		this.createNewCommerce("Soy tu Farmacia", "Red de servicios de atención farmacéutica y perfumerías.", Sector.FARMACY, "Av. Hipólito Yrigoyen 162, Quilmes, Provincia de Buenos Aires", "https://http2.mlstatic.com/nebulizador-ultrasonico-silencioso-soy-tu-farmacia-D_NQ_NP_951042-MLA31062198598_062019-F.webp", new ArrayList<PayMethods>() {{add(PayMethods.CASH);}}, 100, user1);
		this.createNewCommerce("La Tanita Pastas", "Comida para llevar, Reservas, Asiento, Sillitas altas disponibles, Sirve alcohol, Wi-Fi gratis, Servicio de mesa", Sector.FOOD, "Colón 272, Quilmes, Provincia de Buenos Aires", "https://dondecomequilmes.com/wp-content/uploads/2016/06/La-Tanita_lgtn2.jpg", new ArrayList<PayMethods>() {{add(PayMethods.CASH); add(PayMethods.CREDIT_CARD);}}, 300, user1);
		this.createNewCommerce("McDonald’s", "Hamburguesas , Pollo, Ensaladas", Sector.FOOD, "Av. Bartolomé Mitre 639, Avellaneda, Provincia de Buenos Aires", "https://d25dk4h1q4vl9b.cloudfront.net/bundles/front/media/images/favicons/favicon-512.png", new ArrayList<PayMethods>() {{add(PayMethods.CASH); add(PayMethods.CREDIT_CARD);}}, 500, user1);
		this.createNewCommerce("Carrefour", "Supermercado", Sector.SUPERMARKER, "Av. Dardo Rocha 849, Bernal, Provincia de Buenos Aires", "https://promosdelbanco.com/wp-content/uploads/2017/04/Carrefour-Supermercados.png", new ArrayList<PayMethods>() {{add(PayMethods.CREDIT_CARD);}}, 500, user1);
		this.createNewCommerce("Coto", "Supermercado", Sector.SUPERMARKER, "Av. Dardo Rocha 849, Bernal, Provincia de Buenos Aires", "https://s3.amazonaws.com/tbs-amex/Chicas/Coto.png", new ArrayList<PayMethods>() {{add(PayMethods.CREDIT_CARD);}}, 500, user1);

		this.createNewCommerce("Farmacity", "cadena de farmacias argentinas", Sector.FARMACY, "AAv. Manuel Belgrano 3049, Buenos Aires", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRiMwrMRAINNIyKalFwKd9yPW6Ys8RvLFw8Bg&usqp=CAU", new ArrayList<PayMethods>() {{add(PayMethods.CREDIT_CARD); add(PayMethods.CREDIT_CARD);}}, 300, user2);
		this.createNewCommerce("Solo empanadas", "Solo empanadas - Volvimos al baile", Sector.FOOD, "Maipú 208, CABA", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQxgLTot8sW77wTiifA04I8g872wa_B3UCw4g&usqp=CAU", new ArrayList<PayMethods>() {{add(PayMethods.CASH);}}, 100, user2);
		this.createNewCommerce("Mostaza", "Cada vez mas grandes", Sector.FOOD, "Av. Bartolomé Mitre 901, Provincia de Buenos Aires", "https://yt3.ggpht.com/a/AGF-l784CnPWjCVqy-f6IB781-fbGpXobkjyVoNeZg=s900-c-k-c0xffffffff-no-rj-mo", new ArrayList<PayMethods>() {{add(PayMethods.CASH); add(PayMethods.CREDIT_CARD);}}, 300, user2);
		this.createNewCommerce("Las medialunas del abuelo", "Medialunas, Facturas, Panificados.", Sector.FOOD, " Av. Bartolomé Mitre 2031, Avellaneda, Provincia de Buenos Aires", "https://lh3.googleusercontent.com/proxy/GmJ260EGLVxWU3NMm3bqDbw4nCyqB3GUiK6B32IoxvblJZhM2NSRfKh9t9cw2Q9NxSC8a4AM3yIPoKF2Phov3P7Mzlcz5DjfH1oKWcgYDTzY1VjJCcI1svZsl3PLejV5LzDhkGEwB2OHOhAWO3_GXDTuqqJgw0ecoPjTHaDRaUghMZjkU6_lAg", new ArrayList<PayMethods>() {{add(PayMethods.CASH); add(PayMethods.CREDIT_CARD);}}, 500, user2);
		this.createNewCommerce("Dia", "Los mejores precios", Sector.FOOD, "Av. Manuel Belgrano 4222, Provincia de Buenos Aires", "https://media-exp1.licdn.com/dms/image/C4E0BAQGw98ft6URCjg/company-logo_200_200/0?e=2159024400&v=beta&t=8tvullfwScZznKYxoO-f64mll1kdrgYJbmJosL7_eQ4", new ArrayList<PayMethods>() {{add(PayMethods.CASH); add(PayMethods.CREDIT_CARD);}}, 500, user2);


		//Add users
		userService.save(user1);
		userService.save(user2);

		createNewProduct("Perfume Le Male Edt 125 Ml", Category.CLEANING, "Jean Paul Gaultier", 4, 6800, "https://cdn.batitienda.com/baticloud/images/product_ml_c4b8d08e0f9647f5ba3e40ad49a22caa_637086375184871160_0_m.webp", 3);
		createNewProduct("Enjuague Bucal Cuidado Total Zero 250 Ml", Category.CLEANING, "Listerine",4, 270, "https://cdn.batitienda.com/baticloud/images/product_ml_8c10ca2c011645bda61d701a28951639_637158394641424446_0_m.webp", 3);
		createNewProduct("CocaCola 3L", Category.DRINK, "The Coca-Cola Company", 4, 100, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR4lZknniLgWZT9rQoYGxi5v_r3P5OV8ilA_9JpJiYJop0lbpoV&usqp=CAU", 7);
		createNewProduct("Sprite 3L", Category.DRINK, "The Coca-Cola Company", 1, 120, "https://supermercado.carrefour.com.ar/media/catalog/product/cache/1/image/1000x/040ec09b1e35df139433887a97daa66f/7/7/7790895064128_02.jpg", 7);
		createNewProduct("CocaCola 3L", Category.DRINK, "The Coca-Cola Company", 4, 100, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR4lZknniLgWZT9rQoYGxi5v_r3P5OV8ilA_9JpJiYJop0lbpoV&usqp=CAU", 17);
		createNewProduct("Sprite 3L", Category.DRINK, "The Coca-Cola Company", 1, 120, "https://supermercado.carrefour.com.ar/media/catalog/product/cache/1/image/1000x/040ec09b1e35df139433887a97daa66f/7/7/7790895064128_02.jpg", 17);
		createNewProduct("Sorrentinos Fritos con Salsa de Hongos", Category.FOOD, "La Tanita", 5, 120, "https://media-cdn.tripadvisor.com/media/photo-s/18/83/3f/82/sorrentinos-fritos-con.jpg", 5);
	}

	private void createNewCommerce(String name, String description, Sector sector, String address, String image, List<PayMethods> payMethods, Integer maxDistance, User user) {
		List<DayOfWeek> days = new ArrayList<DayOfWeek>() {{add(DayOfWeek.MONDAY); add(DayOfWeek.TUESDAY); add(DayOfWeek.WEDNESDAY); add(DayOfWeek.THURSDAY); add(DayOfWeek.FRIDAY);}};
		AttentionSchedule attentionSchedule = new AttentionSchedule(days, LocalTime.of(9, 0), (LocalTime.of(17,0)));

		Commerce commerce = new Commerce(name, description, sector, address, image, payMethods, maxDistance, attentionSchedule, user.getEmail());

		List<Commerce> newCommerceList = user.getCommerceList();
		newCommerceList.add(commerce);
		user.setCommerceList(newCommerceList);
	}

	private void createNewProduct(String name, Category category, String brand, Integer stock, Integer price, String image, Integer id_commerce) {
		ProductDTO product = new ProductDTO();
		product.setName(name);
		product.setCategory(category);
		product.setBrand(brand);
		product.setStock(stock);
		product.setPrice(price);
		product.setImage(image);
		product.setCommerceId(id_commerce);
		productService.save(product);
	}
}