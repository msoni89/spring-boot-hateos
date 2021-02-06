package com.sample.pagination.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "pinCodes", itemRelation = "pinCode")
@JsonInclude(Include.NON_NULL)
public class PinCodeModel  extends RepresentationModel<PinCodeModel>  {
	
	private Long id;
	private Long pinCode;
	private String postOfficeName; 
	private String city;
	private String district;
	private String state;
	
}
