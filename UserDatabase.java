package finalProjectMainPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public class UserDatabase {
  private Set<UserInformation> users;

  public UserDatabase() {
    users = new HashSet<>();
  }

  public void addUser(UserInformation user) {
    users.add(user);
  }

  public void removeUser(String username) {
    UserInformation userToRemove = null;
    for (UserInformation user : users) {
      if (user.getGuestName().equals(username)) {
        userToRemove = user;
        break;
      }
    }
    if (userToRemove != null) {
      users.remove(userToRemove);
    }
  }

  public UserInformation getUserByUsername(String username) {
    for (UserInformation user : users) {
      if (user.getGuestName().equals(username)) {
        return user;
      }
    }
    return null;
  }

  public Set<UserInformation> getAllUsers() {
    return users;
  }

  public void saveToFile(String filename) {
    try (FileOutputStream fio = new FileOutputStream("filename")) {
      ObjectOutputStream out = new ObjectOutputStream(fio);
      out.writeObject(users.toString());
    } catch (IOException e) {
      System.err.println("Error: Unable to save user data to the file.");
    }
  }

  public void loadFromFile(String filename) {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("/home/dci-student/eclipse-workspace/FinalProject/src/registration.txt"))) {
      Object obj = in.readObject();
      if (obj instanceof Set) {
        users = (Set<UserInformation>) obj;
      }
    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Error: Unable to load user data from the file.");
    }
  }
}