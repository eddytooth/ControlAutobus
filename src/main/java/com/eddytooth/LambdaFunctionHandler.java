package com.eddytooth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<Request, Response> {

	@Override
	public Response handleRequest(Request model, Context context) {
		// TODO Auto-generated method stub

		Request nuevoModelo = model;
		Response respuesta = new Response();
		String chain;

		String groupsRequest = nuevoModelo.getGroup();
		int tamanoMax = 0;
		String[] elementos = groupsRequest.split(",");

		int[] grupos = new int[elementos.length];

		for (int i = 0; i < elementos.length; i++) {
			grupos[i] = Integer.parseInt(elementos[i]);
		}

		int totalGrupos = grupos.length;

		for (int j = 0; j < totalGrupos; j++) {
			tamanoMax += grupos[j];
		}

		int[] calc = new int[totalGrupos];
		calc[0] = grupos[0];

		for (int k = 1; k < totalGrupos; k++) {
			calc[k] = grupos[k] + calc[k - 1];
		}

		//
		List<Integer> ocupacion = new ArrayList<>();
		for (int l = 0; l < totalGrupos; l++) {
			if (calc[totalGrupos - 1] % calc[l] == 0) {
				int value = l;
				for (int m = calc[l]; value >= 0; value = Arrays.binarySearch(calc, value, totalGrupos, m += calc[l])) {

				}
				if (~value == totalGrupos) {
					ocupacion.add(calc[l]);
				}
			}
		}

		StringBuffer sb = new StringBuffer();
		for (int tm : ocupacion) {
			sb.append(tm + " ");
		}

		chain = sb.toString();
		respuesta.setBusSize(chain);

		return respuesta;
	}
}
