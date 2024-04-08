package day04;
import java.util.HashMap;
import java.util.Scanner;

public class Training02 {
    public static void main(String[] args) {
        MainController mainController= new MainController();
        mainController.start();
    }
}

class User{
    String email;
    String name;
    String password;


    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

}


class Controller{
    Scanner in = new Scanner(System.in);
    static int userNum = 0;
    static int loginNum = -1;
    HashMap<Integer,User> UserList = new HashMap<Integer,User>();

    void signUp(){
        if(loginNum != -1) {
            System.out.println("로그아웃 후 이용해주세요");
            return;
        }

        System.out.println("아이디를 입력하세요");
        String email  = in.next();
        System.out.println("이름을 입력하세요");
        String name = in.next();
        System.out.println("비밀번호를 입력하세요");
        String password = in.next();

        User user = new User(email, name, password);
        UserList.put(userNum, user);
        System.out.println(UserList.get(userNum).name + "님 회원가입을 축하합니다.");
        userNum++;
    }

    void login() {
        while (true) {
            System.out.println("아이디를 입력하세요");
            String email = in.next();

            UserList.forEach((key,value) -> {
                if (value.email.equals(email)) {
                    System.out.println("비밀번호를 입력하세요");
                    String password = in.next();
                    if(value.password.equals(password)) {
                        System.out.println(value.name + "님 로그인 하였습니다.");
                        loginNum = key;
                    } else {
                        System.out.println("비밀번호가 틀렸습니다.");
                    }
                }
            });

            if (loginNum == -1)
                System.out.println("아이디가 존재하지 않습니다.");
            else
                break;
        }

    }

    void updateUser() {
        if (loginNum == -1) {
            System.out.println("로그인 후 이용해주세요.");
            return;
        }

        System.out.println("무엇을 수정하시겠습니까?");
        System.out.println("1. id 2. name 3. password");
        int tempKey = in.nextInt();

        if (tempKey == 1) {
            User tempUser = UserList.get(loginNum);
            tempUser.email = in.next();
            UserList.put(loginNum,tempUser);
            System.out.println("수완 (수정완료라는 뜼)");
        } else if (tempKey == 2) {
            User tempUser = UserList.get(loginNum);
            tempUser.name = in.next();
            UserList.put(loginNum,tempUser);
            System.out.println("수완 (수정완료라는 뜼)");
        } else if(tempKey == 3) {
            User tempUser = UserList.get(loginNum);
            tempUser.password = in.next();
            UserList.put(loginNum,tempUser);
            System.out.println("수완 (수정완료라는 뜼)");
        }
    }

    void logout () {
        loginNum = -1;
    }

    void deleteUser() {
        if (loginNum != -1) {
            UserList.remove(loginNum);
            System.out.println("탈퇴했습니다.");
            userNum--;
            loginNum = -1;
        } else {
            System.out.println("로그인 후 이용해주세요.");
        }
    }
}

class MainController{
    Controller controller;
    Scanner in = new Scanner(System.in);

    public MainController() {
        this.controller =  new Controller();
    }

    void start(){
        while (true) {
            if (Controller.loginNum == -1)
                System.out.println("1: 회원가입 / 2: 로그인 / 3: 회원정보 수정 / 4: 탈퇴 / 0: 종료");
            else
                System.out.println("1: 회원가입 / 2: 로그아웃 / 3: 회원정보 수정 / 4: 탈퇴 / 0: 종료");

            int nextKey = in.nextInt();

            if (nextKey == 1) {
                controller.signUp();
            } else if (nextKey == 2) {
                if (Controller.loginNum == -1)
                    controller.login();
                else
                    controller.logout();
            } else if (nextKey == 3) {
                controller.updateUser();
            } else if (nextKey == 4) {
                controller.deleteUser();
            } else {
                System.out.println("종료되었습니다.");
                break;
            }
        }
    }
}