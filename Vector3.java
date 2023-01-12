class Vector3{
    public double x,y,z;

    public Vector3(){
        x = 0d;
        y = 0d;
        z = 0d;
    }

    public Vector3(double x1, double y1, double z1){
        x = x1;
        y = y1;
        z = z1;
    }

    public static Vector3 up() { return new Vector3(0d, 0d, 1d);}
    public static Vector3 down() { return new Vector3(0d, 0d, -1d);}
    public static Vector3 back() { return new Vector3(0d, -1d, 0d);}
    public static Vector3 forward() { return new Vector3(0d, 1d, 0d);}
    public static Vector3 left() { return new Vector3(-1d, 0d, 0d);}
    public static Vector3 right() { return new Vector3(1d, 0d, 0d);}
    public static Vector3 zero() { return new Vector3(0d, 0d, 0d);}
    public static Vector3 one() { return new Vector3(1d, 1d, 1d);}
    

    public double magnitude(){
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
    }

    public double sqrMagnitude(){
        return Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2);
    }

    public double dist(Vector3 other){
        return Math.sqrt(Math.pow((this.x-other.x),2)+Math.pow((this.y-other.y),2)+Math.pow((this.z-other.z),2));
    }

    public static Vector3 Normalize(Vector3 value){
        double magTemp = value.magnitude();
        return new Vector3(value.x/magTemp,value.y/magTemp,value.z/magTemp);
    }

    public Vector3 normalaized(){
        double magTemp = this.magnitude();
        return new Vector3(this.x/magTemp,this.y/magTemp,this.z/magTemp);
    }
    
    public boolean Equals(Vector3 other){
        if (this.x==other.x && this.y==other.y && this.z==other.z){ return true;}
        return false;
    }
    
    public static Vector3 add(Vector3 a, Vector3 b){
        return new Vector3(a.x+b.x,a.y+b.y,a.z+b.z);
    }

    public Vector3 add(Vector3 b){
        return new Vector3(this.x+b.x,this.y+b.y,this.z+b.z);
    }

    public static Vector3 subtract(Vector3 a, Vector3 b){
        return new Vector3(a.x-b.x,a.y-b.y,a.z-b.z);
    }

    public Vector3 subtract(Vector3 b){
        return new Vector3(this.x-b.x,this.y-b.y,this.z-b.z);
    }

    public static Vector3 multiply(Vector3 a, Vector3 b){
        return new Vector3(a.x*b.x,a.y*b.y,a.z*b.z);
    }

    public Vector3 multiply(double b){
        return new Vector3(this.x*b,this.y*b,this.z*b);
    }

    public static Vector3 divide(Vector3 a, Vector3 b){
        return new Vector3(a.x/b.x,a.y/b.y,a.z/b.z);
    }

    public Vector3 divide(double b){
        return new Vector3(this.x/b,this.y/b,this.z/b);
    }
    
    public Vector3 abs(){
        return new Vector3(Math.abs(this.x),Math.abs(this.y),Math.abs(this.z));
    }

    public static Vector3 max(Vector3 a, Vector3 b){
        if (a.sqrMagnitude() > b.sqrMagnitude()){
            return a;
        }
        return b;
    }

    public static Vector3 min(Vector3 a, Vector3 b){
        if (a.sqrMagnitude() < b.sqrMagnitude()){
            return a;
        }
        return b;
    }

    public static Vector3 negative(Vector3 a){
        return new Vector3(-a.x,-a.y,-a.z);
    }

    public String toString(){
        return "("+this.x+", "+this.y+", "+this.z+")";
    }
}