package co.com.popstyle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.popstyle.service.ICorreoService;


@RestController
public class CorreoController {

	@Autowired
	private ICorreoService correoServicio;
	
	@PostMapping(value="/envio-correo", consumes = "application/json",  produces = "application/json")
	public String pruebaController(@RequestBody String json) {
		
		String respuesta = correoServicio.enviarCorreo(json);
		
		if(respuesta.equals("OK"))
			return("El correo ha sido envíado correctamente !!!");
		
		return respuesta;
		
	}

	
/*	
	@PostMapping("/envio-correo")
	public String pruebaController() {

		String endPoint = "https://api.sendinblue.com/v3/smtp/email";
		String json = "";

		try {

			// Headers
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.add("api-key",
					"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");
			headers.add("content-type", "application/json");
			headers.add("accept", "application/json");

			json = "{\r\n" + "   \"sender\":{\r\n"
					+ "      \"name\":\"Enviado API POP Style Envio Notificaciones\",\r\n"
					+ "      \"email\":\"harbeybriceno329728@correo.itm.edu.co\"\r\n" + "   },\r\n" + "   \"to\":[\r\n"
					+ "      {\r\n" + "         \"email\":\"harbey2008@hotmail.com\",\r\n"
					+ "         \"name\":\"Correo Harbey Hotmail\"\r\n" + "      }\r\n" + "   ],\r\n"
					+ "   \"subject\":\"Prueba Envío Notificaciones API POP Style\",\r\n"
//					+ "   \"htmlContent\":\"<html><head></head><body><p>Este es mi primer correo electrónico transaccional enviado desde API POP Style OK.</p></body></html>\"\r\n"
					+ "   \"htmlContent\":\"<html><head></head><body><p>Este es mi primer correo electrónico transaccional enviado desde API POP Style OK. <br> Se generó el turno a nombre del usuario: Harbey Briceño<br> Para la Fecha: 03-05-2023 a la Hora: 06: 00 PM <br> Con el Barbero: Pepito Perez Para el Servicio de : Corte de Cabello <br> </p></body></html>\"\r\n"
					+ "}";

			HttpEntity<String> entity = new HttpEntity<String>(json, headers);

			HttpEntity<String> respuesta = restTemplate.postForEntity(endPoint, entity, String.class);

			return respuesta.getBody();

		} catch (Exception e) {
			// System.out.println("Error al consumir ws:"+ e.getStackTrace());
			return "Error al consumir https://api.sendinblue.com/v3/smtp/email:" + e.getMessage() + "\n Causa:"
					+ e.getLocalizedMessage() + "\n Por Favor revisar los elementos de la Solicitud:\n Metodo: /email"
					+ "\n URI Peticion:" + endPoint + "\n ObjetoJSON:" + json;
		}
	}

	@PostMapping(value="/envio-correo-json", consumes = "application/json",  produces = "application/json")
	public String pruebaControllerObjetos(@RequestBody String jsonRequest) {

		String endPoint = "https://api.sendinblue.com/v3/smtp/email";
		String bodyCorreo = "";
		ParametrosPeticion peticion = new ParametrosPeticion();

		try {

			// Headers
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.add("api-key",
					"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");
			headers.add("content-type", "application/json");
			headers.add("accept", "application/json");
			
			HttpEntity<String> entity = new HttpEntity<String>(jsonRequest, headers);

			HttpEntity<String> respuesta = restTemplate.postForEntity(endPoint, entity, String.class);

			return respuesta.getBody();

		} catch (Exception e) {
			// System.out.println("Error al consumir ws:"+ e.getStackTrace());
			return "Error al consumir https://api.sendinblue.com/v3/smtp/email:" + e.getMessage() 
					+ "\n Causa:"+ e.getLocalizedMessage() 
					+ "\n Por Favor revisar los elementos de la Solicitud:\n Metodo: /email"
					+ "\n URI JSON Petición:" +jsonRequest;
		}
	}
	*/
}
