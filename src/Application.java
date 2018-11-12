import java.util.Scanner;


public class Application {
    static Bank bank = new Bank();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        Client test = new Client("q", "a");
        int temp = test.createAccount(Currency.USD);
        test.getAccount(temp).addAmount(123);
        bank.addUser(test);


        int input = 0;
        do {
            System.out.println("-------------------");
            System.out.println("0 - Выход");
            System.out.println("1- У меня есть аккаунт");
            System.out.println("2- Зарегистрироваться");
            System.out.println("Введите число ");
            input = in.nextInt();
            switch (input) {
                case 0:
                    break;

                case 1:
                    screenInMenu();
                    break;

                case 2:
                    screenRegMenu();
                    break;

                case 3:
                    Currency.RUB.setRate(120);
                    break;


                default:
                    System.out.println("try more");
                    break;
            }

        }
        while (input != 0);


    }

    static void screenRegMenu() {
        boolean check = true;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("-------------------");
            System.out.println("Введите логин");
            String login = in.next();

            System.out.println("Введите пароль");
            String password = in.next();
            Client x = new Client(login, password);
            BankError error =bank.addUser(x);
            if (error!=BankError.OK){
                System.out.println(error.text);

            }else{
                check=true;
            }


        }
        while (check);
    }

    static void screenInMenu() {
        boolean check = true;
        do {

            Scanner in = new Scanner(System.in);
            System.out.println("-------------------");
            System.out.println("Введите логин");
            String login = in.next();
            if (bank.getUser(login) == null) {
                System.out.println("Такой логин не существует");
            } else {
                System.out.println("Введите пароль");
                String password = in.next();
                Client client = (Client) bank.getUser(login);
                if (client.checkPassword(password)) {
                    screenClientMenu(client);
                    check = false;
                } else {
                    System.out.println("Не верный пароль");
                }
            }
        }
        while (check);
    }

    static void screenClientMenu(Client client) {
        int input = 0;
        do {
            System.out.println("-------------------");
            System.out.println("0- Выйти");
            System.out.println("1- Показать все счета");
            System.out.println("2- Создать счет");
            System.out.println("3- Положить деньги насчет");
            System.out.println("4- Купить валюту");
            System.out.println("Введите число ");
            input = in.nextInt();
            switch (input) {
                case 0:
                    break;

                case 1:
                    client.showAllAсcounts();

                    break;

                case 2:
                    screenClientCreateAccount(client);
                    break;

                case 3:
                    screenAddAmount(client);
                    break;


                default:
                    System.out.println("try more");
                    break;
            }
        } while (input != 0);

    }

    static void screenClientCreateAccount(Client client) {
        System.out.println("-------------------");
        System.out.print("{");
        for (Currency currency : Currency.values()) {
            System.out.print(currency + " ");
        }
        System.out.println("}");
        System.out.println("Введите валюту");

        Currency currency;
        String valuta = in.next().toUpperCase();
        try {
            currency = Currency.valueOf(valuta);
            client.createAccount(currency);

        } catch (IllegalArgumentException e) {
            System.out.println("Такой валюты нет");
            screenClientCreateAccount(client);
        }
    }

    static void screenAddAmount(Client client) {
        try {
            client.showAllAсcounts();
            System.out.println("-------");
            System.out.println("Выберите счет:");
            int id = in.nextInt();
            System.out.println("Введите сумму:");
            double money = in.nextDouble();
            client.getAccount(id).addAmount(money);
        } catch (NullPointerException e) {
            System.out.println("Такого счета нет");
        }


    }

}

