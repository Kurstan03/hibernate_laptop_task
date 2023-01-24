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

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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

        service.sortByDifferentColumn("price","afasd").forEach(System.out::println);
    }
}
