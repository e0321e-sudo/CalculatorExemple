package walkclass;

import java.util.Scanner;

    class Menu {
        String name;
        int price;
        boolean soldout;

        void printInfo() {
            if (soldout) {
                System.out.println(name + ": 매진(주문불가)");
            } else {
                System.out.println(name + ": " + price + "원");
            }
        }
    }

        public class Main {
            public static void main(String[] args) {

                Menu menu = new Menu();
                menu.name = "핫초코";
                menu.price = 2500;
                menu.soldout = true;

                Menu menu1 = new Menu();
                menu1.name = "레몬에이드";
                menu1.price = 3500;
                menu1.soldout = false;

                Menu menu2 = new Menu();
                menu2.name = "딸기스무디";
                menu2.price = 4000;
                menu2.soldout = false;

                System.out.println("짜잔 café open!");

                Scanner sc = new Scanner(System.in);
                boolean run = true;

                while (run) {
                    System.out.println();
                    System.out.println("1. 메뉴보기  2. 종료");
                    System.out.print("선택> ");
                    int choice = sc.nextInt();

                    if (choice == 1) {
                        menu.printInfo();
                        menu1.printInfo();
                        menu2.printInfo();
                    } else if (choice == 2) {
                        System.out.println();
                        System.out.println(" 감사합니다!*^_^* ");
                        System.out.println("---프로그램 종료---");
                        run = false;
                    } else {
                        System.out.println("잘못된 선택입니다!");
                    }

                    }
                 sc.close();
                }
            }



