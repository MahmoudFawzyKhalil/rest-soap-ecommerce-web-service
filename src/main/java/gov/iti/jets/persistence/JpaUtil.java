package gov.iti.jets.persistence;

import gov.iti.jets.domain.enums.Role;
import gov.iti.jets.domain.models.Category;
import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class JpaUtil {
    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory( "rest" );
    }

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public static void main( String[] args ) {

        var em = createEntityManager();
        var tx = em.getTransaction();
        tx.begin();
        System.out.println( em.createQuery( "SELECT c.id FROM Category c", Category.class ).getResultList() );
        tx.commit();
    }
}
