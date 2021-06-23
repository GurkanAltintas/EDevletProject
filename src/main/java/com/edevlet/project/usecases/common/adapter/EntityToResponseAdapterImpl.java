package com.edevlet.project.usecases.common.adapter;

import java.util.List;

import com.edevlet.project.usecases.common.rest.model.AbstractCommonResponse;
import com.edevlet.project.usecases.common.rest.model.ApiError;
import com.edevlet.project.usecases.common.rest.model.ApiStatus;
import com.edevlet.project.usecases.mail.entity.MailResponse;
import com.edevlet.project.usecases.mail.entity.SendMailResponse;

public class EntityToResponseAdapterImpl implements EntityToResponseAdapter {

	@SuppressWarnings("unchecked")
	@Override
	public <T extends AbstractCommonResponse, K> T convertEntityToResponse(Class<T> desiredResponseType, K entity) {

		if (SendMailResponse.class.isAssignableFrom(desiredResponseType) && entity instanceof MailResponse) {
			return (T) convertToSendMailResponse((MailResponse) entity);
		}

		return null;
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
