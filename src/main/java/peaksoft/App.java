package peaksoft;

import peaksoft.entity.Laptop;
import peaksoft.enums.OperatingSystem;
import peaksoft.services.LaptopService;
import peaksoft.services.LaptopServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        LaptopService service = new LaptopServiceImpl();
//        service.saveLaptop(
//                new Laptop(
//                        "HP", OperatingSystem.LINUX, 128.0, new BigDecimal(700), LocalDate.of(2022,2,13)
//                )
//        );
//        service.saveLaptop(
//                new Laptop(
//                        "DELL", OperatingSystem.WINDOWS, 128.0, new BigDecimal(500), LocalDate.of(2020,1,23)
//                )
//        );
//
//        List<Laptop> laptops = new LinkedList<>();
//        laptops.add(
//                new Laptop(
//                        "MacBook", OperatingSystem.MACOS, 256.99, new BigDecimal(1200), LocalDate.of(2021,6,12)
//                )
//        );
//        laptops.add(
//                new Laptop(
//                        "MacBook M2 pro", OperatingSystem.MACOS, 512.34, new BigDecimal(1950), LocalDate.of(2023,1,12)
//                )
//        );
//        service.saveAll(laptops).forEach(System.out::println);

        //delete
//        System.out.println(service.deleteById(2L));

//        service.deleteAll();

//        for (Map.Entry<OperatingSystem, List<Laptop>> operatingSystemListEntry : service.groupBy().entrySet()) {
//            System.out.println(operatingSystemListEntry);
//        }
        //find all
//        service.findAll().forEach(System.out::println);

        //update
//        service.update(13L, new Laptop(
//                "Lenovo", OperatingSystem.LINUX, 23.88, new BigDecimal(1000), LocalDate.of(2018,1,1)
//                )
//        );

//        service.sortByDifferentColumn("brand", "asc").forEach(System.out::println);

        while (true) {
            String commands = """
                    1.Save laptop
                    2.Save all laptop
                    3.Delete by id
                    4.Delete all
                    5.Find all
                    6.Update
                    7.Grouping by operating system
                    8.Sort by difference column
                    """;
            System.out.println(commands);
            int num = new Scanner(System.in).nextInt();
            switch (num) {
                case 1 -> {
                    service.saveLaptop(
                            new Laptop(
                                    "HP", OperatingSystem.LINUX, 128.0, new BigDecimal(700), LocalDate.of(2022, 2, 13)
                            )
                    );
                    service.saveLaptop(
                            new Laptop(
                                    "DELL", OperatingSystem.WINDOWS, 128.0, new BigDecimal(500), LocalDate.of(2020, 1, 23)
                            )
                    );
                }
                case 2 -> {

                    List<Laptop> laptops = new LinkedList<>();
                    laptops.add(
                            new Laptop(
                                    "MacBook", OperatingSystem.MACOS, 256.99, new BigDecimal(1200), LocalDate.of(2021, 6, 12)
                            )
                    );
                    laptops.add(
                            new Laptop(
                                    "MacBook M2 pro", OperatingSystem.MACOS, 512.34, new BigDecimal(1950), LocalDate.of(2023, 1, 12)
                            )
                    );
                    service.saveAll(laptops).forEach(System.out::println);
                }
                case 3 -> System.out.println(service.deleteById(2L));
                case 4 -> service.deleteAll();
                case 5 -> service.findAll().forEach(System.out::println);
                case 6 -> service.update(2L, new Laptop(
                                "Lenovo", OperatingSystem.LINUX, 23.88, new BigDecimal(1000), LocalDate.of(2018, 1, 1)
                        )
                );
                case 7 -> {
                    for (Map.Entry<OperatingSystem, List<Laptop>> operatingSystemListEntry : service.groupBy().entrySet()) {
                        System.out.println(operatingSystemListEntry);
                    }
                } case 8 -> {
                    System.out.println("Column name: ");
                    String column = new Scanner(System.in).nextLine();
                    System.out.println("asc or desc:");
                    String ascOrDesc = new Scanner(System.in).nextLine();
                    service.sortByDifferentColumn(column, ascOrDesc).forEach(System.out::println);
                }
            }
        }
    }
}
