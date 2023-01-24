package peaksoft.services;

import peaksoft.entity.Laptop;
import peaksoft.enums.OperatingSystem;
import peaksoft.repositories.LaptopRepository;

import java.util.List;
import java.util.Map;

/**
 * @author kurstan
 * @created at 24.01.2023 13:48
 */
public class LaptopServiceImpl implements LaptopService{
    LaptopRepository repository = new LaptopRepository();
    @Override
    public Laptop saveLaptop(Laptop laptop) {
        return repository.saveLaptop(laptop);
    }

    @Override
    public List<Laptop> saveAll(List<Laptop> laptops) {
        return repository.saveAll(laptops);
    }

    @Override
    public Laptop deleteById(Long id) {
        return repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public List<Laptop> findAll() {
        return null;
    }

    @Override
    public Laptop update(Long id, Laptop laptop) {
        return null;
    }

    @Override
    public Map<OperatingSystem, List<Laptop>> groupBy() {
        return repository.groupBy();
    }

    @Override
    public List<Laptop> sortByDifferentColumn(String column, String ascOrDesc) {
        return repository.sortByDifferentColumn(column, ascOrDesc);
    }
}
