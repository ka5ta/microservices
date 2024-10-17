package com.example.productservice.mapper;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.model.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-17T10:44:12+0200",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 20.0.2 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl extends ProductMapper {

    @Override
    public ProductDTO toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( product.getId() );
        productDTO.setSku( product.getSku() );
        productDTO.setTitle( product.getTitle() );
        productDTO.setListPrice( product.getListPrice() );
        productDTO.setSalePrice( product.getSalePrice() );
        productDTO.setCategory( product.getCategory() );
        productDTO.setCategoryTree( product.getCategoryTree() );
        productDTO.setAverageProductRating( product.getAverageProductRating() );
        productDTO.setProductUrl( product.getProductUrl() );
        productDTO.setProductImageUrls( product.getProductImageUrls() );
        productDTO.setBrand( product.getBrand() );
        productDTO.setTotalNumberReviews( product.getTotalNumberReviews() );
        productDTO.setReviews( product.getReviews() );

        productDTO.setAvailability( 0 );

        return productDTO;
    }
}
