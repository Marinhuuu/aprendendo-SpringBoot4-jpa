package com.educandoweb.couse.config;

import java.time.Instant;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.couse.entities.Category;
import com.educandoweb.couse.entities.Order;
import com.educandoweb.couse.entities.User;
import com.educandoweb.couse.enums.OrderStatus;
import com.educandoweb.couse.repositories.CategoryRepository;
import com.educandoweb.couse.repositories.OrderRepository;
import com.educandoweb.couse.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	private final UserRepository userRepository; // injeção de dependencia

	private final OrderRepository orderRepository; // injeção de dependencia

	private final CategoryRepository categoryRepository; // injeção de dependencia

	public TesteConfig(UserRepository userRepository, OrderRepository orderRepository,
			CategoryRepository categoryRepository) {
		this.userRepository = userRepository;						//construtor
		this.orderRepository = orderRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3)); // salva no banco
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.CANCELADO);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.ENVIADO);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.ESPERANDO_PAGAMENTO);

		userRepository.saveAll(Arrays.asList(u1, u2));// salva no banco
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));// salva no banco

	}

}
