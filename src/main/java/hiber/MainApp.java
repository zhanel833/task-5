package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);
      User user1 = new User("User5", "Lastname5", "user3@mail.ru");
      User user2 = new User("User6", "Lastname6", "user4@mail.ru");
      userService.add(user1);
      userService.add(user2);
      Car car1 = new Car("Model5", 155);
      Car car2 = new Car("Model6", 466);

      car1.setUser(user1);
      car2.setUser(user2);
      carService.add(car1);
      carService.add(car2);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      Car car = carService.getCarByModelAndSeries("Model5", 155);
      if (car != null) {
         System.out.println("Found Car:");
         System.out.println("Model = " + car.getModel());
         System.out.println("Series = " + car.getSeries());
         System.out.println("User = " + car.getUser().getFirstName());

      }


      context.close();
   }
}
