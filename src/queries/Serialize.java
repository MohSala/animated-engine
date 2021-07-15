package queries;

import models.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Serialize {
    public static void main(String[] args) {
        Customer c1 = new Customer("John", "Bull", "bull@gmail.com", 2002, 12345);
        Customer c2 = new Customer("Esther", "Mukungu", "esther@gmail.com", 2002, 54342);
        Customer c3 = new Customer( "Joe", "Biden", "biden@gmail.com", 2002, 56423);
        Customer c4 = new Customer( "Donny", "Trump", "trump@gmail.com", 2002, 78765);
        Customer c5 = new Customer( "Barack", "Obama", "obama@gmail.com", 2002, 56672);
        Customer c6 = new Customer( "Michelle", "Stone", "stone@gmail.com", 2002, 67442);
        Customer c7 = new Customer( "Stone", "Cold", "cold@gmail.com", 2002, 87642);
        Customer c8 = new Customer( "Hulk", "Hogan", "hogan@gmail.com", 2002, 56765);
        Customer c9 = new Customer( "Bubu", "Harry", "harry@gmail.com", 2002,24523);
        Wallet w1 = new Wallet(1000, c1);
        Wallet w2 = new Wallet(2000, c1);
        Wallet w3 = new Wallet(3000, c2);
        Wallet w4 = new Wallet(4000, c2);
        Wallet w5 = new Wallet(5000, c4);
        Wallet w6 = new Wallet(500,c3);
        Wallet w7 = new Wallet(0,  c3);
        Wallet w8 = new Wallet(250, c4);
        Wallet w9 = new Wallet(30, c5);
        Wallet w10 = new Wallet(790, c6);
        Wallet w11 = new Wallet(99, c7);
        Wallet w12 = new Wallet(5000, c8);
        Wallet w13 = new Wallet(0, c9);
        Transaction t1 = new Transaction(200.0, w1,w2, LocalDateTime.of(2019, 9, 01, 02, 38), w2.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t2 = new Transaction(1,w1,w3, LocalDateTime.of(2019, 9, 01, 02, 38), w9.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t3 = new Transaction(20, w4,w3,LocalDateTime.of(2019, 10, 01, 02, 38), w2.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t4 = new Transaction(1000, w6,w8, LocalDateTime.of(2019, 10, 01, 02, 38), w8.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t5 = new Transaction(35, w5,w1, LocalDateTime.of(2019, 11, 01, 02, 38), w1.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t6 = new Transaction(2, w6,w2, LocalDateTime.of(2019, 12, 01, 02, 38), w2.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t7 = new Transaction(2.5F, w5,w7, LocalDateTime.of(2020, 01, 01, 02, 38), w7.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t8 = new Transaction(10.3F, w1,w2, LocalDateTime.of(2020, 01, 01, 02, 38), w2.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t9 = new Transaction(50, w3,w4, LocalDateTime.of(2020, 02, 01, 02, 38), w4.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t10 = new Transaction(500, w5,w6, LocalDateTime.of(2020, 3, 01, 02, 38), w6.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t11 = new Transaction(50, w7,w8, LocalDateTime.of(2020, 3, 01, 02, 38),w8.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t12 = new Transaction(200, w8,w7, LocalDateTime.of(2020, 3, 01, 02, 38), w7.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t13 = new Transaction(200, w7,w6,  LocalDateTime.of(2020, 04, 01, 02, 38), w6.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t14 = new Transaction(1500, w6,w5,  LocalDateTime.of(2020, 05, 01, 02, 38), w5.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t15 = new Transaction(150, w5,w4, LocalDateTime.of(2020, 06, 01, 02, 38), w4.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t16 = new Transaction(123, w4,w3,  LocalDateTime.of(2021, 01, 01, 02, 38), w3.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t17 = new Transaction(200, w3,w2, LocalDateTime.of(2021, 02, 01, 02, 38), w2.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t18 = new Transaction(88, w2,w1, LocalDateTime.of(2021, 03, 01, 02, 38), w1.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t19 = new Transaction(90, w1,w2,  LocalDateTime.of(2021, 04, 01, 02, 38), w2.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t20 = new Transaction(76, w4,w2, LocalDateTime.of(2021, 06, 01, 02, 38), w2.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t21 = new Transaction(99.9F, w8,w3,  LocalDateTime.of(2021, 06, 01, 02, 38), w3.getCustomer().getCustomerTag(),Status.SUCCESSFUL);
        Transaction t22 = new Transaction(99.99F, w6,w5, LocalDateTime.of(2021, 06, 01, 02, 38), w5.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t23 = new Transaction(22, w3,w2,  LocalDateTime.of(2021, 06, 01, 02, 38), w2.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t24 = new Transaction(44, w1,w4, LocalDateTime.of(2021, 07, 01, 02, 38), w4.getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t25 = new Transaction(450, w1,w5, LocalDateTime.of(2021, 07, 01, 02, 38), w5.getCustomer().getCustomerTag(),Status.SUCCESSFUL);
        w1.setTransactions(Arrays.asList(
                t1,t8,
                t19,t24,
                t25,t5,
                t18,t23
        ));
        //1
        w2.setTransactions(Arrays.asList(
                t2,t18,
                t1,t3,
                t6,t8,
                t17,t19,t20
        ));
        //2
        w3.setTransactions(Arrays.asList(
                t9,t17,
                t23,t9,
                t16,t21
        ));
        //3
        w4.setTransactions(Arrays.asList(
                t3,t16,
                t20,t15,
                t24
        ));
        //4
        w5.setTransactions(Arrays.asList(
                t5,t7,
                t10,t15,
                t14,t22,
                t25
        ));
        //5
        w6.setTransactions(Arrays.asList(
                t4, t6,
                t14, t22,
                t10, t13
        ));
        //6
        w7.setTransactions(Arrays.asList(t11, t13, t7, t12));
        //7
        w8.setTransactions(Arrays.asList(t12, t21, t4, t11));
        //8
        w9.setTransactions(Arrays.asList(t2));
        //9
        w10.setTransactions(Arrays.asList());
        //10
        w10.setTransactions(Arrays.asList());
        //11
        w12.setTransactions(Arrays.asList());
        //12
        w13.setTransactions(Arrays.asList());
        c1.setCards(Arrays.asList(cardList().get(0)));
        c1.setCustomerWallet(Arrays.asList(w1, w2));
        c2.setCards(Arrays.asList(cardList().get(1)));
        c2.setCustomerWallet(Arrays.asList(w2, w3));
        c3.setCards(Arrays.asList(cardList().get(2)));
        c3.setCustomerWallet(Arrays.asList(w6, w7));
        c4.setCards(Arrays.asList(cardList().get(3)));
        c4.setCustomerWallet(Arrays.asList(w8,w3));
        c5.setCards(Arrays.asList(cardList().get(4)));
        c5.setCustomerWallet(Arrays.asList(w9));
        c6.setCards(Arrays.asList(cardList().get(5)));
        c6.setCustomerWallet(Arrays.asList(w10));
        c7.setCards(Arrays.asList(cardList().get(6)));
        c7.setCustomerWallet(Arrays.asList(w11));
        c8.setCards(Arrays.asList(cardList().get(7)));
        c8.setCustomerWallet(Arrays.asList(w12));
        c9.setCards(Arrays.asList(cardList().get(8)));
        c9.setCustomerWallet(Arrays.asList(w13));
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);
        customers.add(c6);
        customers.add(c7);
        customers.add(c8);
        customers.add(c9);
        List<Transaction> transactions = Arrays.asList(
                t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25
        );

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/customer.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(customers);
            out.writeObject(transactions);
//            out.writeObject(walletList());
//            out.writeObject(cardList());
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/customer.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    public static List<Card> cardList(){
        List<Card> cards = Arrays.asList(
                new Card(5399356490908800L, 0011, LocalDate.of(2023, 12, 01) ),
                new Card(5399356490908801L, 0011, LocalDate.of(2023, 12, 01) ),
                new Card(5399356490908802L, 0011, LocalDate.of(2023, 12, 01) ),
                new Card(5399356490908829L, 0011, LocalDate.of(2023, 12, 01) ),
                new Card(5399356490908809L, 0011, LocalDate.of(2023, 12, 01) ),
                new Card(5399356490908863L, 0011, LocalDate.of(2023, 12, 01) ),
                new Card(4456344646467377L, 0011, LocalDate.of(2023, 12, 01) ),
                new Card(4456344646467377L, 0011, LocalDate.of(2023, 12, 01) ),
                new Card(4456344646460001L, 0011, LocalDate.of(2023, 12, 01) )
        );
        return cards;
    }

    public  static List<Wallet> walletList(){
        Wallet w1 = new Wallet(1000, customerList().get(0));
        Wallet w2 = new Wallet(2000, customerList().get(0));
        Wallet w3 = new Wallet(3000, customerList().get(1));
        Wallet w4 = new Wallet(4000, customerList().get(1));
        Wallet w5 = new Wallet(5000, customerList().get(3));
        Wallet w6 = new Wallet(500,customerList().get(2));
        Wallet w7 = new Wallet(0,  customerList().get(2));
        Wallet w8 = new Wallet(250, customerList().get(3));
        Wallet w9 = new Wallet(30, customerList().get(4));
        Wallet w10 = new Wallet(790, customerList().get(5));
        Wallet w11 = new Wallet(99, customerList().get(6));
        Wallet w12 = new Wallet(5000, customerList().get(7));
        Wallet w13 = new Wallet(0, customerList().get(8));

        //transaction per wallet
        //0
        w1.setTransactions(Arrays.asList(
                TransactionList().get(0), TransactionList().get(7),
                TransactionList().get(18), TransactionList().get(23),
                TransactionList().get(24), TransactionList().get(4),
                TransactionList().get(17), TransactionList().get(22)
        ));
        //1
        w2.setTransactions(Arrays.asList(
                TransactionList().get(1), TransactionList().get(17),
                TransactionList().get(0), TransactionList().get(2),
                TransactionList().get(5), TransactionList().get(7),
                TransactionList().get(16), TransactionList().get(18), TransactionList().get(19)
        ));
        //2
        w3.setTransactions(Arrays.asList(
                TransactionList().get(8), TransactionList().get(16),
                TransactionList().get(22), TransactionList().get(8),
                TransactionList().get(15), TransactionList().get(20)
        ));
        //3
        w4.setTransactions(Arrays.asList(
                TransactionList().get(2), TransactionList().get(15),
                TransactionList().get(19), TransactionList().get(14),
                TransactionList().get(23)
        ));
        //4
        w5.setTransactions(Arrays.asList(
                TransactionList().get(4), TransactionList().get(6),
                TransactionList().get(9), TransactionList().get(14),
                TransactionList().get(13), TransactionList().get(21),
                TransactionList().get(24)
        ));
        //5
        w6.setTransactions(Arrays.asList(
                TransactionList().get(3), TransactionList().get(5),
                TransactionList().get(13), TransactionList().get(21),
                TransactionList().get(9), TransactionList().get(12)
        ));
        //6
        w7.setTransactions(Arrays.asList(TransactionList().get(10), TransactionList().get(12), TransactionList().get(6), TransactionList().get(11)));
        //7
        w8.setTransactions(Arrays.asList(TransactionList().get(11), TransactionList().get(20), TransactionList().get(3), TransactionList().get(10)));
        //8
        w9.setTransactions(Arrays.asList(TransactionList().get(1)));
        //9
        w10.setTransactions(Arrays.asList());
        //10
        w10.setTransactions(Arrays.asList());
        //11
        w12.setTransactions(Arrays.asList());
        //12
        w13.setTransactions(Arrays.asList());

        List<Wallet> wallets = Arrays.asList(
                w1, w2, w3, w4,w5,w6,w7,w8,w9,w10,w11,w12,w13
        );
        return wallets;
    }

    public static ArrayList<Customer> customerList(){
        Customer c1 = new Customer("John", "Bull", "bull@gmail.com", 2002, 2002);
        Customer c2 = new Customer("Esther", "Mukungu", "esther@gmail.com", 2002, 2002);
        Customer c3 = new Customer( "Joe", "Biden", "biden@gmail.com", 2002, 2002);
        Customer c4 = new Customer( "Donny", "Trump", "trump@gmail.com", 2002, 2002);
        Customer c5 = new Customer( "Barack", "Obama", "obama@gmail.com", 2002, 2002);
        Customer c6 = new Customer( "Michelle", "Stone", "stone@gmail.com", 2002, 2002);
        Customer c7 = new Customer( "Stone", "Cold", "cold@gmail.com", 2002, 2002);
        Customer c8 = new Customer( "Hulk", "Hogan", "hogan@gmail.com", 2002, 2002);
        Customer c9 = new Customer( "Bubu", "Harry", "harry@gmail.com", 2002,2002);
        c1.setCards(Arrays.asList(cardList().get(0)));
        c1.setCustomerWallet(Arrays.asList(walletList().get(0), walletList().get(1)));
        c2.setCards(Arrays.asList(cardList().get(1))); c2.setCustomerWallet(Arrays.asList(walletList().get(2), walletList().get(3)));
        c3.setCards(Arrays.asList(cardList().get(2))); c3.setCustomerWallet(Arrays.asList(walletList().get(5), walletList().get(6)));
        c4.setCards(Arrays.asList(cardList().get(3))); c4.setCustomerWallet(Arrays.asList(walletList().get(7), (walletList().get(4))));
        c5.setCards(Arrays.asList(cardList().get(4))); c5.setCustomerWallet(Arrays.asList(walletList().get(8)));
        c6.setCards(Arrays.asList(cardList().get(5))); c6.setCustomerWallet(Arrays.asList(walletList().get(9)));
        c7.setCards(Arrays.asList(cardList().get(6))); c7.setCustomerWallet(Arrays.asList(walletList().get(10)));
        c8.setCards(Arrays.asList(cardList().get(7))); c8.setCustomerWallet(Arrays.asList(walletList().get(11)));
        c9.setCards(Arrays.asList(cardList().get(8))); c9.setCustomerWallet(Arrays.asList(walletList().get(12)));
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);
        customers.add(c6);
        customers.add(c7);
        customers.add(c8);
        customers.add(c9);



        return customers;
    }

    public static List<Transaction> TransactionList(){
        //current:  double amount, Wallet sender, Wallet receiver, LocalDateTime transactionDate, String receiverTag, Status status
        Transaction t1 = new Transaction(200.0, walletList().get(0), walletList().get(1), LocalDateTime.of(2019, 9, 01, 02, 38), walletList().get(1).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t2 = new Transaction(1, walletList().get(1), walletList().get(8), LocalDateTime.of(2019, 9, 01, 02, 38), walletList().get(8).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t3 = new Transaction(20, walletList().get(3), walletList().get(1),LocalDateTime.of(2019, 10, 01, 02, 38), walletList().get(1).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t4 = new Transaction(1000, walletList().get(5), walletList().get(7), LocalDateTime.of(2019, 10, 01, 02, 38), walletList().get(7).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t5 = new Transaction(35, walletList().get(4), walletList().get(0), LocalDateTime.of(2019, 11, 01, 02, 38), walletList().get(0).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t6 = new Transaction(2, walletList().get(5), walletList().get(1), LocalDateTime.of(2019, 12, 01, 02, 38), walletList().get(1).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t7 = new Transaction(2.5F, walletList().get(4), walletList().get(6), LocalDateTime.of(2020, 01, 01, 02, 38), walletList().get(6).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t8 = new Transaction(10.3F, walletList().get(0), walletList().get(1), LocalDateTime.of(2020, 01, 01, 02, 38), walletList().get(1).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t9 = new Transaction(50, walletList().get(2), walletList().get(3), LocalDateTime.of(2020, 02, 01, 02, 38), walletList().get(3).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t10 = new Transaction(500, walletList().get(4), walletList().get(5), LocalDateTime.of(2020, 03, 01, 02, 38), walletList().get(5).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t11 = new Transaction(50, walletList().get(6), walletList().get(7), LocalDateTime.of(2020, 03, 01, 02, 38),walletList().get(7).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t12 = new Transaction(200, walletList().get(7), walletList().get(6), LocalDateTime.of(2020, 03, 01, 02, 38), walletList().get(6).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t13 = new Transaction(200, walletList().get(6), walletList().get(5),  LocalDateTime.of(2020, 04, 01, 02, 38), walletList().get(5).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t14 = new Transaction(1500, walletList().get(5), walletList().get(4),  LocalDateTime.of(2020, 05, 01, 02, 38), walletList().get(4).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t15 = new Transaction(150, walletList().get(4), walletList().get(3), LocalDateTime.of(2020, 06, 01, 02, 38), walletList().get(3).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t16 = new Transaction(123, walletList().get(3), walletList().get(2),  LocalDateTime.of(2021, 01, 01, 02, 38), walletList().get(2).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t17 = new Transaction(200, walletList().get(2), walletList().get(1), LocalDateTime.of(2021, 02, 01, 02, 38), walletList().get(1).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t18 = new Transaction(88, walletList().get(1), walletList().get(0), LocalDateTime.of(2021, 03, 01, 02, 38), walletList().get(0).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t19 = new Transaction(90, walletList().get(0), walletList().get(1),  LocalDateTime.of(2021, 04, 01, 02, 38), walletList().get(1).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t20 = new Transaction(76, walletList().get(3), walletList().get(1), LocalDateTime.of(2021, 06, 01, 02, 38), walletList().get(1).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t21 = new Transaction(99.9F, walletList().get(7), walletList().get(2),  LocalDateTime.of(2021, 06, 01, 02, 38), walletList().get(2).getCustomer().getCustomerTag(),Status.SUCCESSFUL);
        Transaction t22 = new Transaction(99.99F, walletList().get(5), walletList().get(4), LocalDateTime.of(2021, 06, 01, 02, 38), walletList().get(4).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t23 = new Transaction(22, walletList().get(2), walletList().get(1),  LocalDateTime.of(2021, 06, 01, 02, 38), walletList().get(1).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t24 = new Transaction(44, walletList().get(0), walletList().get(3), LocalDateTime.of(2021, 07, 01, 02, 38), walletList().get(3).getCustomer().getCustomerTag(), Status.SUCCESSFUL);
        Transaction t25 = new Transaction(450, walletList().get(0), walletList().get(4), LocalDateTime.of(2021, 07, 01, 02, 38), walletList().get(4).getCustomer().getCustomerTag(),Status.SUCCESSFUL);

        List<Transaction> transactions = Arrays.asList(
                t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25
        );

        return transactions;
    }


}
