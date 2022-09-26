package com.desafio.componenteinjecaodedependencia;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.desafio.componenteinjecaodedependencia.entities.Order;
import com.desafio.componenteinjecaodedependencia.services.OrderService;
import com.desafio.componenteinjecaodedependencia.services.ShippingService;

@SpringBootApplication
@ComponentScan({"com.desafio"})
public class ComponenteInjecaoDeDependenciaApplication implements CommandLineRunner {
	
	
	private ShippingService shippingService = new ShippingService(); 
	private OrderService orderService = new OrderService(shippingService);
	
	public static void main(String[] args) {
		SpringApplication.run(ComponenteInjecaoDeDependenciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int code = sc.nextInt();
		double basic = sc.nextDouble();
		double discount = sc.nextDouble();
		
		Order order = new Order(code, basic, discount);
		
		System.out.println("Pedido codigo " + order.getCode());
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(order));
		
		sc.close();
	}

}
