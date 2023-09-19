package org.example;

import animals.BaseAnimal;
import animals.OtherAnimal;
import animals.PackAnimals.Camels;
import animals.PackAnimals.Donkeys;
import animals.PackAnimals.Horses;
import animals.PackAnimals.OtherPack;
import animals.Pets.Cats;
import animals.Pets.Dogs;
import animals.Pets.Hamsters;
import animals.Pets.OtherPet;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner iscanner = new Scanner(System.in);
    public static ArrayList<BaseAnimal> animalList = new ArrayList<>();
    public static void main(String[] args) throws ParseException {
        animalList.add(new Dogs("Мухтар", "2015-02-12", new ArrayList<>(Arrays.asList("Лежать", "Фас", "Сидеть"))));
        animalList.add(new Cats("Мурка", "2003-12-28", new ArrayList<>(Arrays.asList("Лежать", "Играть"))));
        animalList.add(new Cats("Барсик", "2018-01-09", new ArrayList<>(Arrays.asList("Лежать"))));
        animalList.add(new Hamsters("Тимка", "2017-05-12", new ArrayList<>(Arrays.asList("Бегать в колесе"))));
        animalList.add(new Horses("Мерен", "2018-10-14", new ArrayList<>(Arrays.asList("Скакать", "Перепрыгивать"))));
        animalList.add(new Camels("Рыжик", "2016-04-08", new ArrayList<>(Arrays.asList("Сидеть", "Играть"))));
        animalList.add(new Camels("Горбунок", "2013-03-15", new ArrayList<>(Arrays.asList("Бегать", "Лежать"))));
        animalList.add(new Donkeys("Гоша", "2020-05-04", new ArrayList<>(Arrays.asList("Катать"))));



        System.out.println("Список животных");
        int num = 1;
        int num1;
        int num2;
        int num3 = 1;
        int num4 = 1;

        ArrayList skills = new ArrayList<String>();

        while (num != 0) {
            System.out.println("Что Вы хотите сделать?\n1 - просмотреть список животных;\n2 - добавить животное;\n3 - добавить команду\n0 - выйти.");
            System.out.print("Ваш результат: ");
            num = iscanner.nextInt();


            switch (num) {
                case 1:
                    int i = 0;
                    for (BaseAnimal unit : animalList) {
                        i++;
                        System.out.println(i + ". " + unit.getInfo());
                    }
                    break;

                case 2:
                    System.out.println("Какое животное Вы хотите добавить?\n1 - домашнее животное;\n2 - вьючное животное;\n3 - другое;\n0 - выйти.");
                    num1 = iscanner.nextInt();

                    System.out.println("Введите кличку: ");
                    String name = iscanner.next();
                    System.out.println("Введите дату рождения (yyyy-MM-dd): ");
                    String date = iscanner.next();

                    String nameClass = null;
                    String mainClass = null;


                    while (num3 != 0) {
                        System.out.println("1 - добавить навык \n0 - сохранить");
                        num3 = iscanner.nextInt();
                        switch (num3) {
                            case 1:
                                System.out.println("Навык: ");
                                String skill = iscanner.next();
                                skills.add(skill);
                                break;
                        }

                    }


                    if (num1 == 1) {
                        System.out.println("Выбирете вид:\n1 - кошка;\n2 - собака;\n3 - хомяк;\n4 - другое;\n0 - выйти.");
                        num2 = iscanner.nextInt();

                        switch (num2) {

                            case 1:
                                animalList.add(new Cats(name, date, skills));
                                break;
                            case 2:
                                animalList.add(new Dogs(name, date, skills));
                                break;
                            case 3:
                                animalList.add(new Hamsters(name, date, skills));
                                break;
                            case 4:
                                System.out.println("Введите достижение животного: ");
                                nameClass = iscanner.next();
                                animalList.add(new OtherPet(name, nameClass, date, skills));
                        }

                    } else if (num1 == 2) {
                        System.out.println("Выбирете вид:\n1 - лошадь;\n2 - верблюд;\n3 - осел;\n4 - другое;\n0 - выйти.");
                        num2 = iscanner.nextInt();

                        switch (num2) {

                            case 1:
                                animalList.add(new Horses(name, date, skills));
                                break;
                            case 2:
                                animalList.add(new Camels(name, date, skills));
                                break;
                            case 3:
                                animalList.add(new Donkeys(name, date, skills));
                                break;

                            case 4:
                                System.out.println("Введите достижение животного: ");
                                nameClass = iscanner.next();
                                animalList.add(new OtherPack(name, nameClass, date, skills));
                                break;
                        }

                    }else if (num1 == 3) {
                        System.out.println("Введите тип животного: ");
                        mainClass = iscanner.next();

                        System.out.println("Введите достижение животного: ");
                        nameClass = iscanner.next();

                        animalList.add(new OtherAnimal(name, mainClass, nameClass, date, skills));

                    }else if (num1 == 0) {
                        System.exit(0);
                    }

                    break;
                case 3:
                    int k = 0;

                    for (BaseAnimal unit : animalList) {
                        k++;
                        System.out.println(k + ". " + unit.getInfo());
                    }
                    System.out.println("Введите номер животного: ");
                    int pos = iscanner.nextInt();
                    System.out.println(animalList.get(pos-1).getInfo());

                    while (num4 != 0) {
                        System.out.println("1 - добавить навык \n0 - сохранить");
                        num4 = iscanner.nextInt();

                        switch (num4) {
                            case 1:
                                System.out.println("Навык: ");
                                ArrayList oldSkills = animalList.get(pos-1).getSkills();
                                String newSkill = iscanner.next();
                                oldSkills.add(newSkill);
                                animalList.get(pos-1).setSkills(oldSkills);
                                break;
                        }

                    }
                    break;

            }
        }

    }

}