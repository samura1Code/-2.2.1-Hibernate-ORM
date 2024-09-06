package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      CarService carService = context.getBean(CarService.class);

//      Car firstCar = new Car("BMW", 1);
//      Car secondCar = new Car("Audi", 2);
//      Car thirdCar = new Car("Mercedes", 3);
//      Car fourthCar = new Car("Ford", 4);
//
//      carService.add(firstCar);
//      carService.add(secondCar);
//      carService.add(thirdCar);
//      carService.add(fourthCar);
//
//
      UserService userService = context.getBean(UserService.class);
//
//      userService.add(new User("User1", "Lastname1", "user1@mail.ru", firstCar));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru", secondCar));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru", thirdCar));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru", fourthCar));
//
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = " + user.getId());
//         System.out.println("First Name = " + user.getFirstName());
//         System.out.println("Last Name = " + user.getLastName());
//         System.out.println("Email = " + user.getEmail());
//
//         Car userCar = user.getCar();
//         if (userCar != null) {
//            System.out.println("Car: " + userCar.getModel() + " (Series: " + userCar.getSeries() + ")");
//         } else {
//            System.out.println("No car assigned.");
//         }
//         System.out.println();
//      }

      try {
         User user = userService.getUserByCar("Mazda", 1);
         System.out.println(user.toString());
      } catch (Exception e) {
            System.out.println("Такой тачки нет! " + e.getMessage());
      }

      context.close();
   }
}
