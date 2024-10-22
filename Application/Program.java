package Application;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products:");
        int n = sc.nextInt();

        for(int i=1;i<=n;i++){
            System.out.println("Product #"+i+" data:");
            System.out.print("Commom, used or imported  (c/u/i)?");
            int ch= sc.next().charAt(0);
            System.out.print("Name:");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price:");
            Double price = sc.nextDouble();
            if (ch =='i') {
               System.out.print("Customs Fee:");
               Double customsFee=  sc.nextDouble();
                list.add(new ImportedProduct( name, price, customsFee));
            }
            else if(ch=='u'){
                System.out.print("Manufacture Data (dd/MM/yyyy):");
                LocalDate manufacturedata = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                list.add(new UsedProduct(name, price, manufacturedata));
            }
            else{
                list.add(new Product(name,price));
            }
        }

        System.out.println("Price tags:");
        for(Product product:list){
            System.out.println(product.priceTag());
        }


        sc.close();
    }
}