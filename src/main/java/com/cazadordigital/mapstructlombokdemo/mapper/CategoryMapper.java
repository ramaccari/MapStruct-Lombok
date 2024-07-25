package com.cazadordigital.mapstructlombokdemo.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cazadordigital.mapstructlombokdemo.dto.GetCategory;
import com.cazadordigital.mapstructlombokdemo.entity.Category;

@Mapper
public interface CategoryMapper {

	public CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

	@Mappings({ 
		@Mapping(source = "id", target = "categoryId"), 
		@Mapping(source = "name", target = "categoryName")		
		})
	GetCategory toDto(Category category);

	@InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "status", ignore = true)
    })
	Category toEntity(GetCategory getCategory);

	List<GetCategory> toDtoList(List<Category> categoryList);

	List<Category> toEntityList(List<GetCategory> getCategoryList);

}
