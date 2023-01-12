public class Cube extends Shape {
    
    public Vector3 scale = Vector3.one();

    public Cube(){}
    public Cube(Vector3 pos){
        position = pos;
    }

    public Cube(Vector3 pos, Vector3 s){
        position = pos;
        scale = s;
    }

    @Override
    public double dist(Vector3 other){
        // vec3 diffrence = abs(relativePos) - boxSize;
        // return min(max(diffrence.x,max(diffrence.y,diffrence.z)),0.0) + length(max(diffrence,0.0));

        Vector3 relativePos = position.subtract(other);
        
        return Math.sqrt(Math.pow(Math.max(relativePos.x - scale.x,0),2) + Math.pow(Math.max(relativePos.y - scale.y,0),2) + Math.pow(Math.max(relativePos.z - scale.z,0),2));

    }
}

