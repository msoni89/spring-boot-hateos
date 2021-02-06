package com.sample.pagination.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.sample.pagination.entity.PinCodeEntity;
import com.sample.pagination.model.PinCodeModel;
import com.sample.pagination.rest.PinCodeRestController;

@Component
public class PinCodeAssembler extends RepresentationModelAssemblerSupport<PinCodeEntity, PinCodeModel> {

	public PinCodeAssembler() {
		super(PinCodeRestController.class, PinCodeModel.class);
	}

	@Override
	public PinCodeModel toModel(PinCodeEntity entity) {
		PinCodeModel model = instantiateModel(entity);

		model.add(linkTo(methodOn(PinCodeRestController.class).getPinCodeById(entity.getId())).withSelfRel());

		model.setId(entity.getId());
		model.setPinCode(entity.getPinCode());
		model.setPostOfficeName(entity.getPostOfficeName());
		model.setCity(entity.getCity());
		model.setDistrict(entity.getDistrict());
		model.setState(entity.getState());
		return model;
	}

}
