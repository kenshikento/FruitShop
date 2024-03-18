package com.store.form;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.ws.rs.FormParam;

public class FormRequest {
	   @Valid
	   @NotEmpty
	   @FormParam("test")
	   public String test;
 }