package com.edevlet.project.patterns.command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveFeedBackOperation implements FeedBackOperation {

	private FeedBackOperator operator;

	@Override
	public void execute() {
		operator.save();
	}

}
