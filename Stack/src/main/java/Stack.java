import java.util.ArrayList;
import java.util.Scanner;

public class Stack {
    private int size;
    private ArrayList<Integer> elements;

    public Stack(int size) {
        this.size = size;
        this.elements = new ArrayList<>(size);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public boolean isFull() {
        return elements.size() >= size;
    }

    public int getSize() {
        return elements.size();
    }

    public void push(int value) {
        if (!isFull()) {
            elements.add(value);
            System.out.println("Dodano element " + value + " na wierzch stosu.");
        } else {
            System.out.println("Stos jest pełny. Nie można dodać do niego więcej elementów.");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            int deletedElement = elements.remove(elements.size() - 1);
            System.out.println("Usunięto element " + deletedElement + " z wierzchołka stosu.");
            return deletedElement;
        } else {
            System.out.println("Stos jest pusty. Nie można nic z niego usunąć.");
            return -1;
        }
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stos jest pusty");
        } else {
            System.out.println("Maksymalne rozmiar stosu wynosi: " + size);
            System.out.println("Aktualny rozmiar stosu to: " + getSize());
            System.out.println("Stos zawiera następujące elementy: ");
            for (int i = elements.size() - 1; i >= 0; i--) {
                System.out.println(elements.get(i));
            }
            System.out.println("Czy stos jest pusty? " + isEmpty());
            System.out.println("Czy stos jest pełny? " + isFull());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack stack = new Stack(10);
        int i = 1;
        while (i > 0) {
        System.out.println("Jaką czynność w obrębie stosu chciałbyś wykonać?" +
                "\n1. Push - dodać element do stosu." +
                "\n2. Pop - usunąć element ze stosu." +
                "\n3. Print - uzyskać informacje o stosie." +
                "\n4. Exit - zakończ działanie programu.");
        int decyzja = in.nextInt();
            if (decyzja == 1) {
                System.out.println("Jaki element chciałbyś dodać do stosu: ");
                int dodawanyElement = in.nextInt();
                stack.push(dodawanyElement);
            } else if (decyzja == 2) {
                stack.pop();
            } else if (decyzja == 3) {
                stack.printStack();
            } else if (decyzja == 4) {
                System.out.println("Program zostanie teraz zamknięty.");
                i--;
            } else {
                System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
            }
        }
    }
}
