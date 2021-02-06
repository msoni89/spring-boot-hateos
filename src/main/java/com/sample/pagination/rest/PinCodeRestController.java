package com.sample.pagination.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sample.pagination.assemblers.PinCodeAssembler;
import com.sample.pagination.entity.PinCodeEntity;
import com.sample.pagination.model.PinCodeModel;
import com.sample.pagination.repository.IPinCodeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Pincode API")
@RestController
public class PinCodeRestController {

	@Autowired
	private IPinCodeRepository pinCodeRepository;

	@Autowired
	private PinCodeAssembler pinCodeModelAssembler;

	@Autowired
	private PagedResourcesAssembler<PinCodeEntity> pagedResourcesAssembler;

	@ApiOperation(value = "Get pin-code details by ID")
	@GetMapping(value= "/api/pin-code/id/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PinCodeModel> getPinCodeById(@PathVariable("id") Long id) {
		return pinCodeRepository.findById(id).map(pinCodeModelAssembler::toModel).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@ApiOperation(value = "Get all paginated pin codes")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "ok"), @ApiResponse(code=500, message="bad request")})
	@GetMapping(value= "/api/pin-code-list",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PagedModel<PinCodeModel>> getAllPinCodes(Pageable pageable) {
		Page<PinCodeEntity> albumEntities = pinCodeRepository.findAll(pageable);
		PagedModel<PinCodeModel> collModel = pagedResourcesAssembler.toModel(albumEntities, pinCodeModelAssembler);
		return new ResponseEntity<>(collModel, HttpStatus.OK);
	}

}
