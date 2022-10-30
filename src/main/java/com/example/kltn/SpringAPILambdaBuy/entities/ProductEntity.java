package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@Entity()
@Table(name = "product")
public class ProductEntity {
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column()
	private String name;
	
	@Column()
	private String description;
	
	@Column
	private double unitPrice;
	
	@Column()
	private double discount;
	
	@Column()
	private String image;
	
	@Column()
	private String status;
	
	@Column
	private int inStock;
	
	@Column
	private int yearOfManufacture;
	
	@Column()
	private String country;
	
	@Column()
	private boolean special;
	
	@CreatedDate()
	@Column
	private Date createdDate;
	
	@CreatedBy()
	@Column
	private String createdBy;
	
	@Column
	private Date updatedDate;
	
	@Column
	private String updatedBy;
	
	@Column
	private boolean isEnabled;
	
	@Column
	private boolean isDeleted;
	
	@OneToMany(mappedBy = "product")
	Set<OrderDetail> listOrderDetail;
	
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private AdminEntity admin;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private CartEntity cart;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private BrandEntity brand;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private SupplierEntity supplier;

	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductEntity(String id, String name, String description, double unitPrice, double discount, String image,
			String status, int inStock, int yearOfManufacture, String country, boolean special, Date createdDate,
			String createdBy, Date updatedDate, String updatedBy, boolean isDeleted, boolean isEnabled, Set<OrderDetail> listOrderDetail, AdminEntity admin,
			CategoryEntity category, BrandEntity brand) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.discount = discount;
		this.image = image;
		this.status = status;
		this.inStock = inStock;
		this.yearOfManufacture = yearOfManufacture;
		this.country = country;
		this.special = special;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.isDeleted = isDeleted;
		this.isEnabled = isEnabled;
		this.listOrderDetail = listOrderDetail;
		this.admin = admin;
		this.category = category;
		this.brand = brand;
	}

	public ProductEntity(String name, String description, double unitPrice, double discount, String image,
			String status, int inStock, int yearOfManufacture, String country, boolean special, Date createdDate,
			String createdBy, Date updatedDate, String updatedBy, boolean isDeleted, boolean isEnabled, Set<OrderDetail> listOrderDetail, AdminEntity admin,
			CategoryEntity category, BrandEntity brand) {
		super();
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.discount = discount;
		this.image = image;
		this.status = status;
		this.inStock = inStock;
		this.yearOfManufacture = yearOfManufacture;
		this.country = country;
		this.special = special;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.isDeleted = isDeleted;
		this.isEnabled = isEnabled;
		this.listOrderDetail = listOrderDetail;
		this.admin = admin;
		this.category = category;
		this.brand = brand;
	}

	public ProductEntity(String name, String description, double unitPrice, double discount, String image,
			String status, int inStock, int yearOfManufacture, String country, boolean special, Date createdDate,
			String createdBy, boolean isDeleted, boolean isEnabled) {
		super();
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.discount = discount;
		this.image = image;
		this.status = status;
		this.inStock = inStock;
		this.yearOfManufacture = yearOfManufacture;
		this.country = country;
		this.special = special;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.isDeleted = isDeleted;
		this.isEnabled = isEnabled;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean isSpecial() {
		return special;
	}

	public void setSpecial(boolean special) {
		this.special = special;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Set<OrderDetail> getOrderDetails() {
		return listOrderDetail;
	}

	public void setOrderDetails(Set<OrderDetail> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}

	public AdminEntity getAdmin() {
		return admin;
	}

	public void setAdmin(AdminEntity admin) {
		this.admin = admin;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public BrandEntity getBrand() {
		return brand;
	}

	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Set<OrderDetail> getListOrderDetail() {
		return listOrderDetail;
	}

	public void setListOrderDetail(Set<OrderDetail> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
	}

	public SupplierEntity getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierEntity supplier) {
		this.supplier = supplier;
	}

	public boolean geIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	
}
