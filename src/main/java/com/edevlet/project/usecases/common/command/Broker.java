package com.edevlet.project.usecases.common.command;

import java.util.ArrayList;
import java.util.List;

public class Broker {
	private List<FeedBackOperation> orderList = new ArrayList<FeedBackOperation>();

	public void placeOrders() {

		orderList.forEach(FeedBackOperation::execute);
		orderList.clear();
	}

	public void takeOrder(FeedBackOperation order) {
		orderList.add(order);
	}
}
