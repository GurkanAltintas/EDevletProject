package com.edevlet.project.usecases.common.rest.exception;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.edevlet.project.usecases.common.rest.model.ApiError;
import com.edevlet.project.usecases.common.rest.model.ApiResult;
import com.edevlet.project.usecases.common.rest.model.ApiStatus;
import com.edevlet.project.usecases.common.rest.model.GlobalExceptionResponse;
import com.edevlet.project.usecases.common.rest.utils.JsonConverter;

@ControllerAdvice
public class CustomGlobalExceptionResolver {

	@ExceptionHandler(value = { RuntimeException.class })
	public void handleException(HttpServletRequest request, HttpServletResponse response, RuntimeException e)
			throws IOException {

		ApiError error = new ApiError();
		error.setCode(e.getMessage());
		error.setExplanation(ExceptionUtils.getStackTrace(e));

		System.out.println(ExceptionUtils.getStackTrace(e));

		ApiResult apiResult = new ApiResult();
		apiResult.setCode(ApiStatus.EXCEPTION.getCode());
		apiResult.setDetail("A runtime exception occurred");

		apiResult.setErrors(List.of(error));

		GlobalExceptionResponse globalExceptionResponse = new GlobalExceptionResponse();
		globalExceptionResponse.setResult(apiResult);

		// TODO: monadda da cagre bulalım
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(HttpStatus.OK.value());

		response.getWriter().write(JsonConverter.getInstance().objectToJson(globalExceptionResponse));
	}

}
