package com.iwe.avengers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.iwe.avenger.dynamodb.entity.Avenger;
import com.iwe.avenger.lambda.exception.AvengerNotFoundException;
import com.iwe.avenger.lambda.response.HandlerResponse;
import com.iwe.avengers.dao.AvangerDAO;

public class RemoveAvengerHandler implements RequestHandler<Avenger, HandlerResponse> {

	private AvangerDAO dao = new AvangerDAO();

	@Override
	public HandlerResponse handleRequest(final Avenger avenger, final Context context) {

		final Avenger retrivedAvenger = dao.find(avenger.getId());

		if (retrivedAvenger == null) {
			throw new AvengerNotFoundException("[NotFound] - Avenger id:" + avenger.getId() + "not found");
		}

		dao.remove(avenger);
		return HandlerResponse.builder().setStatusCode(204).build();
	}
}
