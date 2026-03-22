package com.lhosdp.ai;

public class Test {
    // 定义一个包含5个属性的类
    static class Person {
        String name;
        int age;
        String gender;
        String address;
        String email;

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + ", gender='" + gender + "', address='" + address + "', email='" + email + "'}";
        }
    }

    public static void main(String[] args) {
        // 创建Person对象
        Person person = new Person();

        // 循环设置属性值
        for (int i = 0; i < 5; i++) {
            chuli(i, person);
        }

        // 输出对象的所有属性值
        System.out.println(person);
    }

    private static void chuli(int i, Person person){
        switch (i) {
            case 0:
                person.name = "Alice";
                break;
            case 1:
                person.age = 30;
                break;
            case 2:
                person.gender = "Female";
                break;
            case 3:
                person.address = "123 Main St";
                break;
            case 4:
                person.email = "alice@example.com";
                break;
        }

    }
}