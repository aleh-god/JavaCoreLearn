package Home.GOD;

public class MegaBox {
    int width; // ширина коробки
    int height; // высота коробки
    int depth; // глубина коробки

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setDim(int depth, int height, int width) {
        this.depth = depth;
        this.height = height;
        this.width = width;
    }
    public int getVolume () {
        int volume;
        volume = this.depth * this.height * this.width;
        return volume;
    }
}
