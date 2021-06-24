package com.edevlet.project.patterns.adapter;

import java.util.List;

import com.edevlet.project.core.model.AbstractCommonResponse;
import com.edevlet.project.core.model.ApiError;
import com.edevlet.project.core.model.ApiStatus;
import com.edevlet.project.entity.db.Feedback;
import com.edevlet.project.entity.rest.mail.MailResponse;
import com.edevlet.project.entity.rest.mail.SendMailResponse;
import com.edevlet.project.entity.rest.manageuser.GetAllFeedBacksResponse;

public class EntityToResponseAdapterImpl implements EntityToResponseAdapter {

	@SuppressWarnings("unchecked")
	@Override
	public <T extends AbstractCommonResponse, K> T convertEntityToResponse(Class<T> desiredResponseType, K entity) {

		if (SendMailResponse.class.isAssignableFrom(desiredResponseType) && entity instanceof MailResponse) {
			return (T) convertToSendMailResponse((MailResponse) entity);
		}

		if (GetAllFeedBacksResponse.class.isAssignableFrom(desiredResponseType)) {
			return (T) convertToGetAllFeedBacksResponse((List<Feedback>) entity);
		}

		return null;
	}

	private GetAllFeedBacksResponse convertToGetAllFeedBacksResponse(List<Feedback> feedbackList) {
		GetAllFeedBacksResponse response = new GetAllFeedBacksResponse();
		response.setData(feedbackList);
		return response;
	}

	private SendMailResponse convertToSendMailResponse(MailResponse mailResponse) {

		SendMailResponse sendMailResponse = new SendMailResponse();
		if (!mailResponse.isSuccess()) {
			ApiError apiError = new ApiError();
			apiError.setCode(mailResponse.getErrorCode());
			apiError.setExplanation(mailResponse.getErrorMessage());

			sendMailResponse.getResult().setCode(ApiStatus.EXCEPTION.getCode());
			sendMailResponse.getResult().setErrors(List.of(apiError));
		}

		return sendMailResponse;
	}

}
