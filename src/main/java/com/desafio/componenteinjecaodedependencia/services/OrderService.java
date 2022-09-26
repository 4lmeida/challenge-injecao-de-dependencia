package com.desafio.componenteinjecaodedependencia.services;

import org.springframework.stereotype.Service;

import com.desafio.componenteinjecaodedependencia.entities.Order;

@Service
public class OrderService {
	
	
	private ShippingService shippingService;
	
	public OrderService(ShippingService shippingService) {
		this.shippingService = shippingService;
	}
	
	public double total(Order order) {
		return order.getBasic() - order.getDiscount() / 100.0 * order.getBasic() 
				+ shippingService.shipment(order);
	}
}
