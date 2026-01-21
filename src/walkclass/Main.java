package walkclass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Menu {
    private String name;//이름
    private int price;//가격
    private int stock;//재고
    private boolean soldOut;//품절여부

    Menu(String name, int price){
        this.name = name;
        this.price = price;
        this.stock = 0;
        this.soldOut = true;
    }

    public String getName() {return name;}
    public int getPrice() {return price;}
    public int getStock() {return stock;}
    public boolean isSoldOut() {return soldOut;}

    void restock (int amount){
        this.stock += amount;
        if(stock > 0) soldOut = false;
        }
    void sell (int amount){
        if(soldOut){
            System.out.println("현재 품절입니다.");
            return;
        }
        if(amount <= 0){
            System.out.println("판매수량은 1개 이상이여야 합니다.");
            return;
        }
        if(stock < amount){
            System.out.println("재고가 부족합니다.");
        }
        stock -= amount;
        if (stock == 0) soldOut = true;
    }
    void printInfo() {
        if (soldOut) {
            System.out.println(name + ": SOLD OUT");
        } else {
            System.out.println(name + ": " + price + "원 (남은재고: " + stock + ")");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        List<Menu> menus = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        Menu americano = new Menu("아메리카노", 3500);
        americano.restock(3);

        Menu hotchoco = new Menu("핫초코", 3000);
        hotchoco.restock(1);

        Menu smoothie = new Menu("딸기스무디", 4500);
        smoothie.restock(5);

        menus.add(americano);
        menus.add(hotchoco);
        menus.add(smoothie);

        while(run){
            System.out.println();
            System.out.println("1.메뉴보기 2.판매 3.종료");
            System.out.print("선택> ");
            int choice = sc.nextInt();

            if(choice == 1){
                int totalPrice = 0;

                for(Menu menu : menus){
                    menu.printInfo();
                    if(!menu.isSoldOut()) totalPrice += menu.getPrice();
                    continue;
                }

                System.out.println("-----------------------");
                System.out.println("총 금액(품절 제외): "+ totalPrice + "원");
            } else if (choice == 2) {
                System.out.print("판매할 메뉴 이름: ");
                String target = sc.next();

                System.out.print("판매 수량: ");
                int amount = sc.nextInt();

                boolean found = false;
                for (Menu menu : menus) {
                    if (menu.getName().equals(target)) {
                        menu.sell(amount);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("해당 메뉴가 없습니다.");
                }
            } else if (choice == 3) {
                System.out.println("-+-+-+-+-+-+-+-+-+-+-+-");
                System.out.println("프 로 그 램 즉 시 종 료");
                run = false;
            } else {
                System.out.println("잘못된 선택입니다.");
            }
        }
        sc.close();
    }
}