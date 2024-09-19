/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DaoInterface;

    import java.util.List;
import models.User;

public interface UserDao {


    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Integer userId);
    User getUserById(Integer userId);
    List<User> getAllUsers();
}

    

