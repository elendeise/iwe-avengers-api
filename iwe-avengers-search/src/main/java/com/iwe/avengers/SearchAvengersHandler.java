package com.iwe.avengers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.iwe.avenger.dynamodb.entity.Avenger;
import com.iwe.avenger.lambda.response.HandlerResponse;
import com.iwe.avengers.dao.AvangerDAO;

public class SearchAvengersHandler implements RequestHandler<Avenger, HandlerResponse> {

	private AvangerDAO dao = new AvangerDAO();

	@Override
	public HandlerResponse handleRequest(final Avenger avenger, final Context context) {

		final String id = avenger.getId();

		context.getLogger().log("[#] - Searching Avenger with id: " + id);

		final Avenger retrivedAvenger = dao.find(id);

		final HandlerResponse response = HandlerResponse.builder().setStatusCode(200).setObjectBody(retrivedAvenger)
				.build();

		context.getLogger().log("[#] - Avenger Found!: ");

		return response;
	}
}
