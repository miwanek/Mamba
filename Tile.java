package sample;

public class Tile {
    private double x;
    private double y;
    private boolean  web;
    Tile()
    {
        web = false;
    }

    public void setCoordinates(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public void setWeb()
    {
        web = true;
    }
}
