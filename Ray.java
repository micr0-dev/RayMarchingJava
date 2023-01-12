public class Ray{
    
    private Vector3 pos = Vector3.zero();
    public Vector3 origin = Vector3.zero();
    public double angleX = 0;
    public double angleY = 0;

    public Ray() {}
    public Ray(double angleX1, double angleY1){
        angleX = angleX1;
        angleY = angleY1;
    }
    public Ray(double angleX1, double angleY1, Vector3 origin1){
        angleX = angleX1;
        angleY = angleY1;
        origin = origin1;
    }
    public Ray(double angleX1, double angleY1, Vector3 origin1, double len){
        angleX = angleX1;
        angleY = angleY1;
        origin = origin1;
        this.traverseRay(len);
    }

    public Vector3 getPos(){ return pos; }

    public double length(){
        return pos.dist(origin);
    }

    public void traverseRay(double dist){
        this.pos.z += dist*Math.sin(Math.toRadians(this.angleY));
        this.pos.x += dist*Math.cos(Math.toRadians(this.angleY))*Math.sin(Math.toRadians(this.angleX));
        this.pos.y += dist*Math.cos(Math.toRadians(this.angleY))*Math.cos(Math.toRadians(this.angleX));
    }

    public String toString(){
        return origin+" "+pos+" "+angleX+", "+angleY;
    }
}