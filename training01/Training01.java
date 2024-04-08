package day02;

public class Training01 {
    public static void main(String[] args) {
        Player sonny = new Player("쏘니");
        Player beckham = new Player("베컴");

        Phone sonnyPhone = new SamsungPhone();
        sonnyPhone.phoneOn(sonny);
        sonnyPhone.ring();
        Phone beckhamPhone = new ApplePhone();
        beckhamPhone.phoneOn(beckham);
        beckhamPhone.ring();
    }
}

class Phone {
    void phoneOn(Player player) {
        System.out.println(player.getPlayerName() + " 폰을 켰습니다.");
        if (player.getPlayerName() == "쏘니") {
            System.out.println("야 내 핸드폰 켜볼게");
        } else {
            System.out.println("turn on");
        }
    }

    void ring() {
        System.out.println("ringing");
    }
}

class SamsungPhone extends Phone {
    void ring() {
        System.out.println("삐비빅");
    }
}

class ApplePhone extends Phone {
    void ring() {
        System.out.println("bbeep");
    }
}


class Player {
    private String name;

    Player(String name) {
        this.name = name;
    }

    String getPlayerName() {
        return name;
    }
}
