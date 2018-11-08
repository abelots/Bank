import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Bank {
    static Map users = new HashMap< String, User>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

/*
        CCurrency c= new CCurrency(TypeOfCurrency.USD);
        System.out.println(c.converter(100, TypeOfCurrency.RUB));

        System.out.println(c.getCourse());
        System.out.println(c.getCurrencyName());

        CAccount a= new CAccount(TypeOfCurrency.RUB);
        System.out.println(a.getAmount());
*/
/*        Client x= new Client("user","123");
        x.createAccount(new Currency(TypeOfCurrency.RUB));
        x.accounts.get(0).addAmount(100);
        System.out.println(x.accounts.get(0).getAmount());
        System.out.println(x.accounts.get(0).getCurrencyName());
        x.createAccount(new Currency(TypeOfCurrency.USD));
        x.showAllAсcounts();

        Scanner in = new Scanner(System.in);
        int num= in.nextInt();
        x.deleteAccount(num);
        x.showAllAсcounts();
        */



    Client test=new Client("q","a");
        int temp=test.createAccount(Currency.USD);
        test.getAccount(temp).addAmount(123);
        users.put(test.getLogin(),test);

        int input=0;
        do{
            System.out.println("-------------------");
            System.out.println("0 - Выход");
            System.out.println("1- У меня есть аккаунт");
            System.out.println("2- Зарегистрироваться");
            System.out.println("Введите число ");
            input= in.nextInt();
            switch (input){
                case 0:
                    break;

                case 1:
                    interfaceinMenu();
                    break;

                case 2:
                    interfaceregMenu();
                    break;

                    case 3:
                        Currency.RUB.setCourse(120);
                        break;


                default:
                    System.out.println("try more");
                    break;
            }

        }
        while (input!=0);




    }

    static void interfaceregMenu(){
        boolean check=true;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("-------------------");
            System.out.println("Введите логин");
            String login = in.next();
            if (users.get(login)==null){
                System.out.println("Введите пароль");
                String password = in.next();
                Client x = new Client(login, password);
                users.put(login, x);
                check=false;
            }
            else{
                System.out.println("Логин уже существует");
            }
        }
        while(check);
    }

    static void interfaceinMenu(){
        boolean check=true;
        do {

            Scanner in = new Scanner(System.in);
            System.out.println("-------------------");
            System.out.println("Введите логин");
            String login = in.next();
            if (users.get(login)==null) {
                System.out.println("Такой логин не существует");
            }

            else{
                System.out.println("Введите пароль");
                String password = in.next();
                Client client= (Client) users.get(login);
                if (client.checkPassword(password)) {
                    interfaceclientMenu(client);
                   check=false;
                }
                else {
                    System.out.println("Не верный пароль");
                }
            }
        }
        while(check);
    }

    static void interfaceclientMenu(Client client){
        int input =0;
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
                    interfaceClientCreateAccount(client);
                    break;

 //               case 3:
 //                   interfaceAddAmount(client);
  //                  Currency.RUB.setCourse(120);
  //                  break;


                default:
                    System.out.println("try more");
                    break;
            }
        } while(input!=0);

    }

    static void interfaceClientCreateAccount(Client client)
    {
            System.out.println("-------------------");
            System.out.print("{");
            for(Currency currency : Currency.values()) {
                System.out.print(currency+ " ");
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
                interfaceClientCreateAccount(client);
            }
    }

    static void interfaceAddAmount(Client client)
    {
        try {
            client.showAllAсcounts();
            System.out.println("-------");
            System.out.println("Выберите счет:");
            int id=in.nextInt();
            System.out.println("Введите сумму:");
            double money=in.nextDouble();
            client.getAccount(id).addAmount(money);
        }
        catch(NullPointerException e){
            System.out.println("Такого счета нет");
        }



    }

}

