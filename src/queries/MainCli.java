//package queries;
//
//import java.util.Scanner;
//
//public class MainCli {
//
//    Employee[] emps = null;
//    public static void main(String[] args) {
//        new Main();
//    }
//
//    Main(){
//
//        System.out.println("A. See a report of all accounts.\n"
//                + "B. Make a deposit.\n"
//                + "C. Make a withdrawal.\n"
//                + "Make a selection (A/B/C): ");
//
//        Scanner sc = new Scanner(System.in);
//        String input = sc.next();
//
//        emps = new Employee[3];
//        emps[0] = new Employee("Jim Daley", 2000, 9, 4);
//        emps[1] = new Employee("Bob Reuben", 1998, 1, 5);
//        emps[2] = new Employee("Susan Randolph", 1997, 2,13);
//        emps[0].createNewChecking(10500);
//        emps[0].createNewSavings(1000);
//        emps[0].createNewRetirement(9300);
//        emps[1].createNewChecking(34000);
//        emps[1].createNewSavings(27000);
//        emps[2].createNewChecking(10038);
//        emps[2].createNewSavings(12600);
//        emps[2].createNewRetirement(9000);
//
//        if(input.equalsIgnoreCase("A")){
//            for(Employee emp: emps) {
//                System.out.println(emp.getFormattedAcctInfo());
//            }
//        } else if(input.equalsIgnoreCase("B")
//                || input.equalsIgnoreCase("C")) {
//            for(int i = 0; i<emps.length; i++) {
//                System.out.println(i +"." +  emps[i].getName());
//            }
//            System.out.println("Select an employee: (type a number)");
//
//            int inputEmpIndex = sc.nextInt();
//
//            MyStringList list = emps[inputEmpIndex].getNamesOfAccounts();
//            for(int i = 0; i<list.size(); i++) {
//                System.out.println(i +"." +  list.get(i));
//            }
//            System.out.println("Select an account: (type a number)");
//            int inputAccIndex = sc.nextInt();
//
//            System.out.println("Deposit amount: ");
//            double inputDeposit = sc.nextDouble();
//
//            emps[inputEmpIndex].deposit(inputAccIndex, inputDeposit);
//            System.out.println("$" + inputDeposit + " has been deposited in the "
//                    + list.get(inputAccIndex) + " account of " + emps[inputEmpIndex].getName());
//        }else {
//            System.out.println("Wrong input to the console. Try again");
//            sc.next();
//        }
//
//        sc.close();
//    }
//}
