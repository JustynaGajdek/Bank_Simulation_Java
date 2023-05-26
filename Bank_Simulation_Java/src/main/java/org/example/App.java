package org.example;

public class App
{
    public static void main( String[] args )
    {
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