package com.datastructure.sort;

public class Pair {
    int num1;
    int num2;

    public Pair(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (num1 != pair.num1) return false;
        return num2 == pair.num2;
    }

    @Override
    public int hashCode() {
        int result = num1;
        result = 31 * result + num2;
        return result;
    }

    @Override
    public String toString() {
        return "(" + num1 + ", " + num2 + ")";
    }
}
