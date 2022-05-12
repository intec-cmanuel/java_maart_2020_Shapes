package be.intecbrussel.graphics;

import java.util.Arrays;

public class Drawing {
    private Shape[] shapeArray;
    private int size;

    public Drawing() {
        shapeArray = new Shape[100];
    }

    public void add(Shape s) {
        int index = findFirstAvailableArraySlot();

        boolean isNotAlreadyInDrawing = !containsShape(s);
        boolean indexIsMinusOne = index == -1;

        if (isNotAlreadyInDrawing) {
            if (indexIsMinusOne) {
                shapeArray = Arrays.copyOf(shapeArray, shapeArray.length + 1);
                index = shapeArray.length - 1;
            }

            shapeArray[index] = s;
            size++;
        }
    }

    public void remove(Shape s) {
        int index = indexOfShape(s);
        if (index != -1) {
            shapeArray[index] = null;
            size--;
        }
    }

    public void clear() {
        Arrays.fill(shapeArray, null);
    }

    public int getSize() {
        return size;
    }

    private int indexOfShape(Shape s) {
        for (int index = 0; index < shapeArray.length; index++) {
            if (shapeArray[index] != null && shapeArray[index].equals(s)) {
                return index;
            }
        }
        return -1;
    }

    private boolean containsShape(Shape s) {
        return indexOfShape(s) != -1;
    }

    private int findFirstAvailableArraySlot() {
        for (int index = 0; index < shapeArray.length; index++) {
            if (shapeArray[index] == null) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("This is my drawing:\n");
        for (Shape shape : shapeArray) {
            if (shape != null) {
                toString.append(shape).append("\n");
            }
        }
        toString.append("Size is: ").append(size);
        return toString.toString();
    }
}
