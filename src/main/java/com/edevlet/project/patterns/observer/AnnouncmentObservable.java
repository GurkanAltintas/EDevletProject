package com.edevlet.project.patterns.observer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AnnouncmentObservable extends Observable {

	private String newAnnouncment;

}
