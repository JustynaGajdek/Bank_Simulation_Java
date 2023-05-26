package org.example;

public class App
{
    public static void main( String[] args )
    {
// Napisz program, który będzie symulować działanie banku. Zaimplementuj klasy:
//a. Klasę Client, reprezentującą klienta banku. Klasa powinna zawierać pola:
// name (typu String), accountNumber (typu String) oraz balance (typu double chyba że dasz radę inaczej),
// reprezentujące odpowiednio imię i nazwisko klienta, numer konta oraz saldo.
//b. Klasę Bank, reprezentującą bank. Klasa powinna zawierać pole clients, będące tablicą obiektów typu Client,
// oraz metody:
//
//addClient(Client client): dodająca nowego klienta do tablicy clients,
//removeClient(String accountNumber): usuwająca klienta o podanym numerze konta z tablicy clients,
//getClientCount(): zwracająca liczbę klientów w banku,
//getClientByAccountNumber(String accountNumber): zwracająca obiekt klienta o podanym numerze konta,
//deposit(String accountNumber, double amount): dokonująca wpłaty na konto klienta o podanym numerze konta,
//withdraw(String accountNumber, double amount): dokonująca wypłaty z konta klienta o podanym numerze konta,
//transfer(String fromAccountNumber, String toAccountNumber, double amount): dokonująca przelewu z jednego
// konta na drugie.
//c. Klasę Main, w której znajdzie się metoda main, a w niej kod, w którym:
//i. Stworzysz obiekt banku.
//ii. Dodasz kilku klientów do banku, korzystając z metody addClient.
//iii. Wywołasz odpowiednie metody, aby dokonać wpłat, wypłat i przelewów między kontami klientów.
//iv. Wypiszesz na ekranie informacje o wszystkich klientach w banku.
//Twoim zadaniem jest implementacja klas Client, Bank oraz metody main zgodnie z podanymi wymaganiami.

        Bank bank;
        bank = new Bank();

        Client client1 = new Client("Jan Kowalski", "12312312312", 200);
        bank.addClient(client1);

        Client client2 = new Client("Jan Nowak", "45612378961", 100);
        bank.addClient(client2);

        Client client3 = new Client("Jsn Byk", "98745612364", 1000);
        bank.addClient(client3);

        bank.deposit("12312312312", 1000);
        bank.deposit("45612378961", 500);
        bank.deposit("98745612364", 200);

        bank.withdraw("12312312312", 300);
        bank.withdraw("45612378961", 100);
        bank.withdraw("98745612364", 50);

        bank.transfer("12312312312", "98745612364", 200);
        bank.transfer("45612378961", "12312312312", 100);

        System.out.println("Clients in the bank:");
        for (int i = 0; i < bank.getClientCount(); i++) {
            Client client = bank.getClientByIndex(i);
            System.out.println("Account Number: " + client.getAccountNumber());
            System.out.println("Client Name: " + client.getName());
            System.out.println("Account Balance: " + client.getBalance());
            System.out.println();
        }

    }
}