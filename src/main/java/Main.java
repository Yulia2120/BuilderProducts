
import Models.Category;
import Models.Company;
import Models.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class Main {
            private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    public static void main(String[] args) throws IOException {


            ArrayList<Category> categories = new ArrayList<>();
                    categories.add(new Category(1, "fruits", 5 ));
                    categories.add(new Category(2,"vegetables", 4));
                    categories.add(new Category(3, "confectionery", 3.1));

            ArrayList<Company> companies = new ArrayList<>();
                    companies.add(new Company(1, "Thailand", 4.2 ));
                    companies.add(new Company(2,"Ukraine", 5.0));
                    companies.add(new Company(3, "Turkey", 3.7));
                    companies.add(new Company(4, "USA", 4.9));
                    companies.add(new Company(5,"France", 4.3));


            Collection<Product> products = Arrays.asList(
                    (new Product(1, "Pineapple", 1200.0, 123, 3, categories.get(0), companies.get(0))),
                    (new Product(2, "Carrot", 96.0, 4.5, 5, categories.get(1), companies.get(1))),
                    (new Product(3, "Melon", 1100.8, 101, 3, categories.get(0), companies.get(2))),
                    (new Product(4, "Apple", 110.2, 15, 3,categories.get(0) , companies.get(1))),
                    (new Product(5, "Potato", 70.0, 4.6, 8, categories.get(1), companies.get(1))),
                    (new Product(6, "Cabbage", 900.0, 11.7, 3, categories.get(1), companies.get(1))),
                    (new Product(7, "Snickers", 50.0, 18.7, 3, categories.get(2), companies.get(3))),
                    (new Product(8, "Mars", 50.0, 18.6, 3, categories.get(2), companies.get(3))),
                    (new Product(9, "Nuts", 50.0, 19.7, 3, categories.get(2), companies.get(4))),
                    (new Product(10, "Bounty", 50.0, 23.7, 3, categories.get(2), companies.get(4))));
            System.out.println("Все продукты: ");
            System.out.println("-----------------------------------------------------------------");
            products.forEach(System.out::println);
            System.out.println();



            System.out.println("Все категории: ");
            System.out.println("-----------------------------------------------------------------");
            products.stream().map(Product::getCategory).distinct().forEach(System.out::println);
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Продукты от конкретного производителя: ");
            products.stream().filter(e -> Objects.equals(e.getCompany().getCompanyName(), "USA")).forEach(System.out::println);
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Продукты ценой до 100$: ");
            products.stream().filter(p->p.getPrice()<100).forEach(System.out::println);
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Продукты ниже средней цены в списке среди всех категорий: ");
            double average = products.stream().mapToDouble(Product::getPrice).average().getAsDouble();
            products.stream().filter(p->p.getPrice()< average).forEach(System.out::println);
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Продукты ниже средней цены в списке среди самых НЕ популярных категорий");
            double av =  products.stream().filter((s)-> s.getCategory().getRatingCategory() <4).mapToDouble(Product::getPrice).average().getAsDouble();
            products.stream().filter((s)-> s.getCategory().getRatingCategory() <4).filter(p->p.getPrice()<av).forEach(System.out::println);
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Продукты самого не популярного производителя в самой популярной категорий");
            products.stream().filter((s)-> s.getCompany().getRatingCompany() < 4).filter((s)-> s.getCategory().getRatingCategory() > 4).forEach(System.out::println);
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Продукт весом до 1кг (случайный)");
            List<Product> listProd = products.stream().filter(w->w.getWeight()<1000).toList();
            Random random = new Random();
            int pos = random.nextInt(listProd.size());
            System.out.println(listProd.get(pos));
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Продукты ценой от 1$ до 5$ и весом до 500 грамм");
            products.stream().filter((p)->p.getPrice()>1 && p.getPrice()<5 && p.getWeight() < 500).forEach(System.out::println);




            Supplier<Stream<String>> supplier = () -> {
                    try {

                            return Files.lines(Paths.get(""));
                    } catch (IOException e) {
                            throw new RuntimeException(e);
                    }
            }; //метод вывода stream в консоль



            String json = GSON.toJson(products);
            PrintWriter pwr = new PrintWriter("my_db.json");
            pwr.println(json);
            pwr.close();










    }

}
