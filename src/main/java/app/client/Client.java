package app.client;

import app.controller.MemberController;
import app.controller.TrainerController;

import java.util.Scanner;

public class Client {

    private static MemberController memberController;
    private static TrainerController trainerController;
    private static Scanner scanner;

    public static void main(String[] args) {

        try {
            memberController = new MemberController();
            trainerController = new TrainerController();
            scanner = new Scanner(System.in);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        while (true) {
            System.out.println("Выберите желаемую операцию:");
            System.out.println("1 - операции с клиентами (Member)");
            System.out.println("2 - операции с тренерами (Trainer)");
            System.out.println("0 - выход");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    memberOperations();
                    break;
                case "2":
                    trainerOperations();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Некорректный ввод!");
                    break;
            }
        }
    }

    //  Меню клиентов
    public static void memberOperations() {
        while (true) {
            try {
                System.out.println("Выберите операцию с клиентами:");
                System.out.println("1 - сохранить клиента");
                System.out.println("2 - получить всех клиентов");
                System.out.println("3 - получить клиента по ID");
                System.out.println("4 - удалить клиента по ID");
                System.out.println("5 - удалить клиента по имени");
                System.out.println("6 - восстановить клиента по ID");
                System.out.println("7 - восстановить клиента по имени");
                System.out.println("0 - выход");

                String input = scanner.nextLine();

                switch (input) {
                    case "1":
                        System.out.println("Введите имя клиента:");
                        String name = scanner.nextLine();
                        System.out.println(memberController.save(name));
                        break;
                    case "2":
                        memberController.getAll().forEach(System.out::println);
                        break;
                    case "3":
                        System.out.println("Введите ID клиента:");
                        Long id = Long.parseLong(scanner.nextLine());
                        System.out.println(memberController.getById(id));
                        break;
                    case "4":
                        System.out.println("Введите ID клиента:");
                        id = Long.parseLong(scanner.nextLine());
                        memberController.deleteById(id);
                        break;
                    case "5":
                        System.out.println("Введите имя клиента:");
                        name = scanner.nextLine();
                        memberController.deleteByName(name);
                        break;
                    case "6":
                        System.out.println("Введите ID клиента:");
                        id = Long.parseLong(scanner.nextLine());
                        memberController.restoreById(id);
                        break;
                    case "7":
                        System.out.println("Введите имя клиента:");
                        name = scanner.nextLine();
                        memberController.restoreByName(name);
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("Некорректный ввод!");
                        break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    //  Меню тренеров
    public static void trainerOperations() {
        while (true) {
            try {
                System.out.println("Выберите операцию с тренерами:");
                System.out.println("1 - сохранить тренера");
                System.out.println("2 - получить всех тренеров");
                System.out.println("3 - получить тренера по ID");
                System.out.println("4 - удалить тренера по ID");
                System.out.println("5 - удалить тренера по имени");
                System.out.println("6 - восстановить тренера по ID");
                System.out.println("7 - восстановить тренера по имени");
                System.out.println("0 - выход");

                String input = scanner.nextLine();

                switch (input) {
                    case "1":
                        System.out.println("Введите имя тренера:");
                        String name = scanner.nextLine();
                        System.out.println(trainerController.save(name));
                        break;
                    case "2":
                        trainerController.getAll().forEach(System.out::println);
                        break;
                    case "3":
                        System.out.println("Введите ID тренера:");
                        Long id = Long.parseLong(scanner.nextLine());
                        System.out.println(trainerController.getById(id));
                        break;
                    case "4":
                        System.out.println("Введите ID тренера:");
                        id = Long.parseLong(scanner.nextLine());
                        trainerController.deleteById(id);
                        break;
                    case "5":
                        System.out.println("Введите имя тренера:");
                        name = scanner.nextLine();
                        trainerController.deleteByName(name);
                        break;
                    case "6":
                        System.out.println("Введите ID тренера:");
                        id = Long.parseLong(scanner.nextLine());
                        trainerController.restoreById(id);
                        break;
                    case "7":
                        System.out.println("Введите имя тренера:");
                        name = scanner.nextLine();
                        trainerController.restoreByName(name);
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("Некорректный ввод!");
                        break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
