public class Shape {
    public Vector3 position = Vector3.zero();

    public double dist(Vector3 other){
        return position.dist(other);
    }
}