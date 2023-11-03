package Task13.src;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(new Product(1, "Book", 73, false, LocalDate.of(2023, 11, 3)),
                new Product(2, "Newspaper", 100, true, LocalDate.of(2023, 10, 27)),
                new Product(3, "Doll", 260.99, true, LocalDate.of(2022, 12, 15)),
                new Product(4, "Toy", 350, false, LocalDate.of(2022, 8, 23)),
                new Product(5, "Book", 300, true, LocalDate.of(2023, 10, 3)),
                new Product(6, "Doll", 400, true, LocalDate.of(2021, 12, 15)),
                new Product(7, "Book", 450.25, true, LocalDate.of(2023, 9, 23)),
                new Product(7, "Book", 45, false, LocalDate.of(2023, 9, 23)));

        List<Product> booksOver250Price = products.stream().filter(p -> p.getType().equals("Book") && p.getPrice() > 250).toList();
        System.out.println("Продукти, категорія яких еквівалентна “Book” та ціна більш ніж 250 : " + booksOver250Price);

        List<Product> discountedBooks = products.stream().filter(p -> p.getType().equals("Book") && p.isDiscountAvailable()).map(p -> {
            return new Product(p.getId(), p.getType(), p.getPrice() * 0.9, p.isDiscountAvailable(), p.getDateAdded());
        }).toList();
        System.out.println("Продукти, категорія яких еквівалентна “Book” і з можливістю застосування знижки. Ціна з урахування 10% знижки : " + discountedBooks);

        Product cheapestBook = products.stream().filter(p -> p.getType().equals("Book")).
                min(Comparator.comparing(Product::getPrice)).orElseThrow(() -> new NoSuchElementException("Продукт [категорія: Book] не знайдено"));
        System.out.println("Найдешевший продукт з категорії “Book” : " + cheapestBook);

        List<Product> lastThreeAddedProducts = products.stream().sorted(Comparator.comparing(Product::getDateAdded).reversed()).limit(3).toList();
        System.out.println("Три останні додані продукти : " + lastThreeAddedProducts);

        double totalCost = products.stream().filter(p -> p.getDateAdded().getYear() == LocalDate.now().getYear() &&
                p.getType().equals("Book") && p.getPrice() <= 75).mapToDouble(Product::getPrice).sum();
        System.out.println("Загальної вартості продуктів, які відповідають наступним критеріям:" +
                "\n - продукт додано протягом поточного року" +
                "\n - продукт має тип “Book” " +
                "\n- ціна продукту не перевищує 75 " + "\n  = " + totalCost);

        Map<String, List<Product>> groupedProducts = products.stream().collect(Collectors.groupingBy(Product::getType));
        System.out.println("Групування об'єктів за типом продукту : " + groupedProducts);

    }


}
