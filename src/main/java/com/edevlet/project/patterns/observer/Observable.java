package com.edevlet.project.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

	private List<Observer> observerList = new ArrayList<>();

	public void add(Observer observer) {
		observerList.add(observer);
	}

	public void notifyObservers() {
		observerList.forEach(f -> f.update(this));
	}

	public void remove(Observer observer) {
		observerList.remove(observer);
	}

}
