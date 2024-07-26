package com.cazadordigital.mapstructlombokdemo.dto;

import lombok.Builder;

@Builder
public record GetProduct (long productId, String productName, String creationDate, GetCategory productCategory, String price) {

}
