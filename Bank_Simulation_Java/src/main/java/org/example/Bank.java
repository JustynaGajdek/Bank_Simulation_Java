package org.example;

public class Bank {

    private Client[] clients;

    public Bank() {
        this.clients = new Client[0];
    }

    public void addClient(Client client) {
        Client[] newClients = new Client[clients.length + 1];
        for (int i = 0; i < clients.length; i++) {
            newClients[i] = clients[i];
        }
        newClients[newClients.length - 1] = client;
        clients = newClients;
        System.out.println("Client added successfully.");
    }


    public void removeClient(String accountNumber) {
        int targetClientIndex = -1;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getAccountNumber().equals(accountNumber)) {
                targetClientIndex = i;
                break;
            }
        }

        if (targetClientIndex != -1) {
            Client[] newClients = new Client[clients.length - 1];
            for (int i = 0, j = 0; i < clients.length; i++) {
                if (i != targetClientIndex) {
                    newClients[j] = clients[i];
                    j++;
                }
            }
            clients = newClients;
            System.out.println("Client removed successfully.");
        } else {
            System.out.println("Client with account number " + accountNumber + " not found.");
        }
    }

    public int getClientCount() {
        return clients.length;
    }

    public Client getClientByAccountNumber(String accountNumber) {
        for (Client client : clients) {
            if (client.getAccountNumber().equals(accountNumber)) {
                return client;
            }
        }
        return null;
    }

    public void deposit(String accountNumber, double amount) {
        Client client = getClientByAccountNumber(accountNumber);
        if (client != null) {
            client.setBalance(client.getBalance() + amount);
            System.out.println("Deposit successful. New balance: " + client.getBalance());
        } else {
            System.out.println("Invalid account number. Deposit failed.");
        }
    }
    public void withdraw(String accountNumber, double amount) {
        Client client = getClientByAccountNumber(accountNumber);
        if (client != null) {
            if (client.getBalance() >= amount) {
                client.setBalance(client.getBalance() - amount);
                System.out.println("Withdrawal successful. New balance: " + client.getBalance());
            } else {
                System.out.println("Sorry, but there are insufficient funds in your account. Your current balance " + client.getBalance() + " is not enough for this withdrawal.");
            }
        } else {
            System.out.println("Invalid account number. Withdrawal failed.");
        }
    }
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        Client fromClient = getClientByAccountNumber(fromAccountNumber);
        Client toClient = getClientByAccountNumber(toAccountNumber);

        if (fromClient != null && toClient != null) {
            if (fromClient.getBalance() >= amount) {
                fromClient.setBalance(fromClient.getBalance() - amount);
                toClient.setBalance(toClient.getBalance() + amount);
                System.out.println("Transfer successful. Amount: " + amount + " transferred from account " + fromAccountNumber + " to account " + toAccountNumber);
            } else {
                System.out.println("Transfer failed. Insufficient funds in the account " + fromAccountNumber);
            }
        } else {
            System.out.println("Transfer failed. Invalid account number(s).");
        }
    }
}


