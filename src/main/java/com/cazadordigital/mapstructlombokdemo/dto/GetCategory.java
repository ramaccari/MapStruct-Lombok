package com.cazadordigital.mapstructlombokdemo.dto;

import lombok.Builder;

@Builder
public record GetCategory (long categoryId, String categoryName) {


}
