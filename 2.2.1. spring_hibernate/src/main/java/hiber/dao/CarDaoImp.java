package hiber.dao;
import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

   @Autowired
   private SessionFactory sessionFactory;


   @Override
   @Transactional
   public void add(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   public List<Car> listCar() {
      TypedQuery<Car> query2 = sessionFactory.getCurrentSession().createQuery("from Car");
      return query2.getResultList();
   }
}
