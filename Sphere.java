public class Sphere extends Shape {
    public double radius = 1d;

    public Sphere(){}
    public Sphere(Vector3 pos){
        position = pos;
    }
    public Sphere(double r){
        radius = r;
    }
    public Sphere(Vector3 pos, double r){
        position = pos;
        radius = r;
    }

    @Override
    public double dist(Vector3 other){
        return position.dist(other)-radius;
    }
}