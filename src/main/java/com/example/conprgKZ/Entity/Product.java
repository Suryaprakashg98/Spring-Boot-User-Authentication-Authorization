package com.example.conprgKZ.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String sku;
    private String name;
    private double price;
    private int discount;
    private String offerEnd;
    private boolean isNew;
    private double rating;
    private int saleCount;
 
    @ElementCollection
    @CollectionTable(name = "categories", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "category")
    private List<String> category;  

    @ElementCollection
    @CollectionTable(name = "tags", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "tag")
    private List<String> tag;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<Variation> variation;

    @ElementCollection
    @CollectionTable(name = "images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "image")
    private List<String> image;

    @Column(columnDefinition = "TEXT")
    private String shortDescription;

    @Column(columnDefinition = "TEXT")
    private String fullDescription;

    
    
   	public Product() {
		
	}
   	
   	public Product(Long id, String sku, String name, double price, int discount, String offerEnd, boolean isNew,
			double rating, int saleCount, List<String> category, List<String> tag, List<Variation> variation,
			List<String> image, String shortDescription, String fullDescription) {
		super();
		this.id = id;
		this.sku = sku;
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.offerEnd = offerEnd;
		this.isNew = isNew;
		this.rating = rating;
		this.saleCount = saleCount;
		this.category = category;
		this.tag = tag;
		this.variation = variation;
		this.image = image;
		this.shortDescription = shortDescription;
		this.fullDescription = fullDescription;
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getOfferEnd() {
		return offerEnd;
	}

	public void setOfferEnd(String offerEnd) {
		this.offerEnd = offerEnd;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}

	public List<String> getCategory() {
		return category;
	}

	public void setCategory(List<String> category) {
		this.category = category;
	}

	public List<String> getTag() {
		return tag;
	}

	public void setTag(List<String> tag) {
		this.tag = tag;
	}

	public List<Variation> getVariation() {
		return variation;
	}

	public void setVariation(List<Variation> variation) {
		this.variation = variation;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", sku=" + sku + ", name=" + name + ", price=" + price + ", discount=" + discount
				+ ", offerEnd=" + offerEnd + ", isNew=" + isNew + ", rating=" + rating + ", saleCount=" + saleCount
				+ ", category=" + category + ", tag=" + tag + ", variation=" + variation + ", image=" + image
				+ ", shortDescription=" + shortDescription + ", fullDescription=" + fullDescription + "]";
	}

} 