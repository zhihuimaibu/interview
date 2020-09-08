package proxy;

public class staticPro {
    public static void main(String[] args) {
        proxyPeople proxyPeople = new proxyPeople(new peopleImpl());
        proxyPeople.eat();
    }
}

interface people {
    void eat();
}

class peopleImpl implements people {
    public void eat() {
        System.out.println("吃饭ing");
    }
}

class proxyPeople implements people {

    people people;

    public proxyPeople(people people) {
        this.people = people;
    }

    public void eat() {
        System.out.println("吃饭之前先洗手");
        people.eat();
        System.out.println("吃法之后要漱口");
    }
}

