package co.com.popstyle.service.impl;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.com.popstyle.service.ICorreoService;

@Service
public class CorreoServiceImpl implements ICorreoService {

	private static final Logger logger = LogManager.getLogger(CorreoServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.sendinblue.url}")
	private String endPoint;

	@Value("${api.sendinblue.api-key}")
	private String apiKey;

	@Override
	public String enviarCorreo(String data) {

		String endPoint = "https://api.sendinblue.com/v3/smtp/email";

		try {

			// Headers
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.add("api-key", apiKey);
			headers.add("content-type", "application/json");
			headers.add("accept", "application/json");

			HttpEntity<String> entity = new HttpEntity<String>(data, headers);

			ResponseEntity<String> respuesta = restTemplate.postForEntity(endPoint, entity, String.class);

			//logger.info("Respuesta del ws: status = "+respuesta.getStatusCodeValue());
			
			if (respuesta.getStatusCodeValue() == 201) {
				logger.info("El correo ha sido envíado correctamente !!!");
				return "OK";
			} else {

				logger.error("No se pudo envíar el correo, intentelo nuevamente o comuniquese con soporte 3124563937");
				return ("No se pudo envíar el correo, intentelo nuevamente o comuniquese con soporte 3124563937");
			}

		} catch (Exception e) {
			// System.out.println("Error al consumir ws:"+ e.getStackTrace());
			logger.error(
					"Error al consumir https://api.sendinblue.com/v3/smtp/email:\" + e.getMessage() + \"\\n Causa:\"\r\n"
							+ "					+ e.getLocalizedMessage() + \"\\n Por Favor revisar los elementos de la Solicitud:\\n Metodo: /email\"\r\n"
							+ "					+ \"\\n URI JSON Petición:\" + data");
			return "Error al consumir https://api.sendinblue.com/v3/smtp/email:" + e.getMessage() + "\n Causa:"
					+ e.getLocalizedMessage() + "\n Por Favor revisar los elementos de la Solicitud:\n Metodo: /email"
					+ "\n URI JSON Petición:" + data;
		}
	}

}
