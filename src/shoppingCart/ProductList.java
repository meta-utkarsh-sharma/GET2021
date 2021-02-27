package shoppingCart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ProductList Class
 */
public class ProductList {

	//private single instance variable
	private static ProductList productListInstance = null;
	private final String DEMO_PROD = "products.txt";
	private final Map<Integer,Product> products;

	/**
	 * class constructor
	 * @throws FileNotFoundException 
	 */
	private ProductList(String filePath) throws FileNotFoundException {
		products = new HashMap<Integer, Product>();
		createProductsListFromFile(filePath);
	}
	
	/**
	 * default constructor
	 */
	private ProductList() {
		products = new HashMap<Integer, Product>();
	}
	
	/**
	 * Method getInstance creates only instance
	 * i.e. productListInstance and
	 * @return productListInstance
	 */
	public static ProductList getInstance(){
		if(productListInstance == null){
			productListInstance = new ProductList();
		}
		return productListInstance;
	}

	/**
	 * @return the products
	 */
	public Map<Integer,Product> getProducts() {
		return Collections.unmodifiableMap(products);
	}
	
	

	/**
	 * @param filePath
	 * @return the products
	 * @throws FileNotFoundException 
	 */
	public Map<Integer, Product> createProductsListFromFile(String filePath) throws FileNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(filePath);
		Scanner sc = new Scanner(fileInputStream);
		while(sc.hasNextLine()){
			String line[] = sc.nextLine().split(",");
			int id = Integer.parseInt(line[0]);
			String name = line[1];
			double price = Double.valueOf(line[2]);
			Product product = new Product(id, name, price);
			products.put(id, product);
		}
		sc.close();
		return products;
	}
	
	
	/**
	 * create Demo products list
	 * @throws FileNotFoundException 
	 */
	public Map<Integer, Product> createDemoProductsList() throws FileNotFoundException {
		System.out.println("Creating demo products list from: " + DEMO_PROD);
		return createProductsListFromFile(DEMO_PROD);
	}


	/**
	 * @param id
	 * @param name
	 * @param price
	 */
	public void add(Integer id, String name, Double price) {
		Product newProduct = new Product(id, name, price);
		products.putIfAbsent(id, newProduct);
	}


	/**
	 * @param id
	 * @return boolean
	 */
	public boolean contains(int id) {
		return products.containsKey(id);
	}

	
}
