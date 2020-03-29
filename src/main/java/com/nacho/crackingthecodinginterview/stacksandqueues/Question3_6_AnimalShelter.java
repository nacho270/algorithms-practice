package com.nacho.crackingthecodinginterview.stacksandqueues;

import java.util.LinkedList;

/**
 * An animal shelter holds dogs and cats. When people want to adopt, the shelter has "first in first out rule". In that sense people will
 * received the first animal that was enterded the system or they can say if they want a cat or a dog and will receive the first cat or dog
 * that entered the system.
 *
 * Implement the system with the functions: enqueue, dequeAny, dequeDog, dequeCat.
 */
public class Question3_6_AnimalShelter {

  private static abstract class Animal {
    private int order;

    abstract String getType();

    public int getOrder() {
      return order;
    }

    public void setOrder(final int order) {
      this.order = order;
    }

    @Override
    public String toString() {
      return getType();
    }
  }

  private static class Dog extends Animal {

    @Override
    String getType() {
      return "dog";
    }
  }

  private static class Cat extends Animal {

    @Override
    String getType() {
      return "cat";
    }
  }

  private static class AnimalShelter {

    private int order = 0;

    // used 2 lists instead of of animals.
    // Using 1 list of Animal, would imply traversing the list filtering by type when dequeuing dog or cat.
    private LinkedList<Dog> dogs = new LinkedList<>();
    private LinkedList<Cat> cats = new LinkedList<>();

    public void enqueue(final Animal animal) {
      animal.setOrder(order++);
      if (animal instanceof Dog) {
        dogs.addLast((Dog) animal);
      } else {
        cats.addLast((Cat) animal);
      }
    }

    public Animal dequeueAny() {
      if (dogs.isEmpty()) {
        return cats.poll();
      } else if (cats.isEmpty()) {
        return dogs.poll();
      }
      final Cat cat = cats.peek();
      final Dog dog = dogs.peek();
      if (cat.getOrder() < dog.getOrder()) {
        return dequeueCat();
      }
      return dequeueDog();
    }

    public Dog dequeueDog() {
      return dogs.poll();
    }

    public Cat dequeueCat() {
      return cats.poll();
    }
  }

  public static void main(final String[] args) {
    final AnimalShelter as = new AnimalShelter();
    as.enqueue(new Dog());
    System.out.println(as.dequeueAny());
    as.enqueue(new Cat());
    as.enqueue(new Dog());
    System.out.println(as.dequeueAny());
    System.out.println(as.dequeueDog());
    as.enqueue(new Cat());
    System.out.println(as.dequeueCat());
  }
}
