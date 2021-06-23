package com.edevlet.project.usecases.common.command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveFeedBackOperation implements FeedBackOperation {

	private FeedBackOperator operator;

	@Override
	public void execute() {
		operator.save();
	}

}
