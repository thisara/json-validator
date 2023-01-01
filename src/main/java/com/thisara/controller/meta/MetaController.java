package com.thisara.controller.meta;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import com.thisara.controller.dto.meta.PostMetaDTO;
import com.thisara.exception.SchemaValidationException;
import com.thisara.service.CarService;
import com.thisara.service.exception.ServiceException;
import com.thisara.utils.response.SuccessResponse;

/*
 * Copyright the original author.
 * 
 * @author Thisara Alawala
 * @author https://mytechblogs.com
 * @author https://www.youtube.com/channel/UCRJtsC5VYYhmKnEqAGLKc2A
 * @since 2021-05-30
 */
@RestController
@RequestMapping("/meta")
public class MetaController {

	private static Logger logger = Logger.getLogger(MetaController.class.getName());

	@Autowired
	private CarService carService;
	
	@Autowired
	private ObjectMapper objectMapper;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessResponse> persist(
			@RequestBody @Valid PostMetaDTO postCarDTO) 
			throws ServiceException, Exception {
	
		JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
	   
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

		JsonNode jsonNode = objectMapper.convertValue(postCarDTO, JsonNode.class);//writeValueAsString(postCarDTO);
		
		//JsonNode mySchema = JsonLoader.fromFile(file);
		ClassPathResource cp = new ClassPathResource("meta-schema.json");
		
		//TODO: Check file exists
		//TODO: Load from glue schema repo
		JsonSchema schema = factory.getSchema(new FileInputStream(cp.getFile()));
		
		Set<ValidationMessage> validationResult = schema.validate(jsonNode);
		
		if(validationResult.isEmpty()) {
			logger.info(">>> NO ERRORS!");
			//carService.save(postCarDTO);
		} else {
			validationResult.forEach(vm -> logger.info("ERRORS!" + vm.getMessage() + " : " + vm.getSchemaPath()));
			throw new SchemaValidationException("Schema validation error!");
		}
		
		return new ResponseEntity<SuccessResponse>(
				new SuccessResponse("Successfully created.", HttpStatus.OK.toString(), LocalDateTime.now().toString()),
				HttpStatus.OK);
	}

}
