package peaksoft.services;

import peaksoft.entity.Laptop;
import peaksoft.enums.OperatingSystem;

import java.util.List;
import java.util.Map;

/**
 * @author kurstan
 * @created at 24.01.2023 13:48
 */
public interface LaptopService {
    Laptop saveLaptop(Laptop laptop);

    List<Laptop> saveAll(List<Laptop> laptops);

    public Laptop deleteById(Long id);

    public void deleteAll();

    public List<Laptop> findAll();

    public Laptop update(Long id, Laptop laptop);

    Map<OperatingSystem, List<Laptop>> groupBy();

    List<Laptop> sortByDifferentColumn(String column, String ascOrDesc);
}
