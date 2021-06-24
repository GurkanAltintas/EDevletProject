package com.edevlet.project.patterns.command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CheckFeedBackOperation implements FeedBackOperation {

	private FeedBackOperator operator;

	@Override
	public void execute() {
		operator.check();
	}
}
