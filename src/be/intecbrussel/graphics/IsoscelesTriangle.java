package be.intecbrussel.graphics;

public class IsoscelesTriangle extends Triangle{

    public static int count;

    public IsoscelesTriangle() {
        this(10,10);
    }

    public IsoscelesTriangle(int height, int width) {
        super(height, width, width/2);
    }

    public IsoscelesTriangle(int height, int width, int x, int y) {
        super(height, width, width/2, x, y);
    }

    public IsoscelesTriangle(IsoscelesTriangle iso) {
        super(iso);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setPerpendicular(width/2);
    }

    @Override
    public void setPerpendicular(int perpendicular) {
        super.setPerpendicular(perpendicular);
        super.setWidth(perpendicular * 2);
    }

    public static int getCount(){
        return count;
    }

    @Override
    public String toString() {
        return "IsoScelesTriangle{} " + super.toString();
    }
}
