package peaksoft.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.congiration.DatabaseConnection;
import peaksoft.entity.Laptop;
import peaksoft.enums.OperatingSystem;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author kurstan
 * @created at 24.01.2023 13:47
 */
public class LaptopRepository {

    private EntityManagerFactory entityManagerFactory = DatabaseConnection.createEntityManagerFactory();

    public Laptop saveLaptop(Laptop laptop){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(laptop);
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptop;
    }

    public List<Laptop> saveAll(List<Laptop> laptops){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (Laptop laptop : laptops) {
            entityManager.persist(laptop);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptops;
    }

    public Laptop deleteById(Long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Laptop laptop = entityManager.createQuery("select l from Laptop l where l.id = :id", Laptop.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.remove(laptop);
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptop;
    }

    public void deleteAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Laptop> laptops = entityManager.createQuery("select l from Laptop l ", Laptop.class).getResultList();
        for (Laptop laptop : laptops) {
            entityManager.remove(laptop);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Laptop> findAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Laptop> laptops = entityManager.createQuery("select l from Laptop l", Laptop.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptops;
    }

    public Laptop update(Long id, Laptop laptop){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Laptop result = entityManager.createQuery("select l from Laptop l where l.id = :id", Laptop.class)
                .setParameter("id", id)
                .getSingleResult();
        result.setBrand(laptop.getBrand());
        result.setOperatingSystem(laptop.getOperatingSystem());
        result.setMemory(laptop.getMemory());
        result.setPrice(laptop.getPrice());
        result.setDateOfIssue(laptop.getDateOfIssue());
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public Map<OperatingSystem, List<Laptop>> groupBy(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Map<OperatingSystem, List<Laptop>> selectLFromLaptopL = entityManager.createQuery("select l from Laptop l ", Laptop.class).getResultList()
                .stream()
                .collect(Collectors.groupingBy(Laptop::getOperatingSystem));
        entityManager.getTransaction().commit();
        entityManager.close();

        return selectLFromLaptopL;
    }

     public List<Laptop> sortByDifferentColumn(String column, String ascOrDesc){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Laptop> laptops = entityManager
                .createQuery(LaptopRepository.getSortQuery(column, ascOrDesc), Laptop.class)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptops;
    }
    private static String getSortQuery(String column, String ascOrDesc){
        String query = null;
        if (column.equalsIgnoreCase("brand")) {
            if (ascOrDesc.equalsIgnoreCase("asc")) {
                query = "select l from Laptop l order by l.brand";
            } else if (ascOrDesc.equalsIgnoreCase("desc")) {
                query = "select l from Laptop l order by l.brand desc";
            }
        } else if (column.equalsIgnoreCase("operatingSystem")){
            if (ascOrDesc.equalsIgnoreCase("asc")) {
                query = "select l from Laptop l order by l.operatingSystem ";
            } else if (ascOrDesc.equalsIgnoreCase("desc")) {
                query = "select l from Laptop l order by l.operatingSystem desc";
            }
        } else if (column.equalsIgnoreCase("memory")) {
            if (ascOrDesc.equalsIgnoreCase("asc")) {
                query = "select l from Laptop l order by l.memory ";
            } else if (ascOrDesc.equalsIgnoreCase("desc")) {
                query = "select l from Laptop l order by l.memory desc";
            }
        } else if (column.equalsIgnoreCase("price")) {
            if (ascOrDesc.equalsIgnoreCase("asc")) {
                query = "select l from Laptop l order by l.price";
            } else if (ascOrDesc.equalsIgnoreCase("desc")) {
                query = "select l from Laptop l order by l.price desc";
            }
        } else if (column.equalsIgnoreCase("dateOfIssue")) {
            if (ascOrDesc.equalsIgnoreCase("asc")) {
                query = "select l from Laptop l order by l.dateOfIssue";
            } else if (ascOrDesc.equalsIgnoreCase("desc")) {
                query = "select l from Laptop l order by l.dateOfIssue desc";
            }
        }
        return query;
    }
}
