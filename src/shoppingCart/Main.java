package shoppingCart;

import java.util.Map;
import java.util.Scanner;

/**
 * Driver class
 *
 */
public class Main {

	private static Cart shopCart;
	private static ProductList productListInstance = ProductList.getInstance();
	private static Map<Integer, Product> productList;
	
	/**
	 * This method prints choice Menu
	 * on output console
	 */
	static void printMenu(){
		System.out.print("Menu:\n"
				+ "1. Add product to cart\n"
				+ "2. Remove product from cart\n"
				+ "3. change item quantity\n"
				+ "4. Show cart items\n"
				+ "5. Generate bill\n"
				+ "6. Exit\n"
				+ "Enter your choice: ");
	}
	
	static void showCartItems(){
		System.out.println("Items in cart:");
		Map<Integer, Integer> items = shopCart.getCartItems();
		System.out.println("Product Id\t\t"
				+ "Product Name\t\t"
				+ "Quantity\t\t"
				+ "Price/item");
		for(Integer pid: items.keySet()){
			System.out.println(pid+"\t\t"
					+productList.get(pid).getName()+"\t\t"
							+ items.get(pid)+"\t\t\t"
									+ productList.get(pid).getPrice());
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		shopCart = new ShopCart();
		try{
			System.out.println("Do you want to create own productlist?y/n");
			char c = sc.next().charAt(0);
			if(c == 'y' || c == 'Y'){
				System.out.println("Do you have a productlist file (txt/csv)?y/n");
				c = sc.next().charAt(0);
				if(c == 'y' || c == 'Y'){
					String file = sc.nextLine();
					productList = productListInstance.createProductsListFromFile(file);
				}
				else {
					int exit = 0;
					do{
						System.out.println("Enter product id: ");
						int id = sc.nextInt();
						System.out.println("Enter product Name: ");
						String name = sc.next();
						System.out.println("Enter product price: ");
						Double price = sc.nextDouble();
						productListInstance.add(id, name, price);
						System.out.println("press non zero value to add more");
						exit = sc.nextInt();
					}while(exit == 0);
				}
			}
			else {
				productList = productListInstance.createDemoProductsList();
			}
		}
		catch (Exception e){
			System.out.println("Something went wrong!" + e.getMessage());
			System.exit(0);
		}
		int choice, id, count;
		do{
			printMenu();
			choice = sc.nextInt(); 
			switch(choice){
			case  1:
				System.out.print("Enter product ID: ");
				id = sc.nextInt();
				System.out.print("Enter product count: ");
				count = sc.nextInt();
				shopCart.add(id, count);
				break;
			case 2:
				System.out.print("Enter product ID: ");
				id = sc.nextInt();
				shopCart.remove(id);
				break;
			case 3:
				System.out.print("Enter product ID: ");
				id = sc.nextInt();
				System.out.print("Enter new product count: ");
				count = sc.nextInt();
				if(shopCart.updateQuantity(id, count))
					System.out.println("Cart updated");
				else
					System.out.println("Item not present in the cart");
				break;
			case 4:
				showCartItems();
				break;
			case 5:
				showCartItems();
				System.out.println("**************************************************************************************");
				System.out.println("\t\t\tTotal: "+shopCart.generateBill());
				break;
			case 6:
				System.out.println("Ta-Ta");
				sc.close();
				System.exit(0);
				break;
			default :
				System.out.println("Uh-Oh, You entered wrong choice!");
				
			}
		} while(true);
	}

}
