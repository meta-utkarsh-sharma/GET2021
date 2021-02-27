package shoppingCart;

/*
 * Product class to create a new Product
 * that can be added to cart
 *  
 */
class Product {
	private final Integer id;
	private String name;
	private Double price;
	private Integer stock = 100;
	
	/**
	 * @param id id of the product
	 * @param name name of the product
	 * @param price price of the product
	 * @param stock number of quantity available
	 */
	public Product(Integer id, String name, Double price, Integer stock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	
	/**
	 * @param id
	 * @param name
	 * @param price
	 */
	public Product(Integer id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * @return the stock
	 */
	public Integer getStock() {
		return stock;
	}
	
	/**
	 * @param stock the stock to set
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if(this.hashCode() != other.hashCode())
			return false;
		return true;
	}
	
	
		
}
