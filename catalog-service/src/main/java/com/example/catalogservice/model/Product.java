package com.example.catalogservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="products")
@Getter @Setter
public class Product {

    @Id
    @Column(name = "uniq_id")
    private UUID id;
    private String sku;
    @Column(name = "name_title")
    private String title;
    @Column(name = "list_price")
    private String listPrice;
    @Column(name = "sale_price")
    private String salePrice;
    private String category;
    @Column(name = "category_tree")
    private String categoryTree;
    @Column(name = "average_product_rating")
    private String averageProductRating;
    @Column(name = "product_url")
    private String productUrl;
    @Column(name = "product_image_urls")
    private String productImageUrls;
    private String brand;
    @Column(name = "total_number_reviews")
    private String totalNumberReviews;
    private String reviews;
}
