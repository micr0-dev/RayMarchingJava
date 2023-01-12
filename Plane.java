public class Plane extends Shape {

    public Plane(){}
    public Plane(Vector3 pos){
        position = pos;
    }
    
    @Override
    public double dist(Vector3 other){
        return Math.abs(position.z - other.z);
    }
}