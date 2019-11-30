package util;

public class Calculate {
    private String method;
    private int a;
    private int b;

    public Calculate() {
    }

    public Calculate(String method, int a, int b) {
        this.method = method;
        this.a = a;
        this.b = b;
    }

    public int doCal(){
        if(method == "add"){
            return a+b;
        } else if(method == "sub"){
            return a-b;
        } else if(method == "mul"){
            return a*b;
        } else if(method == "dev"){
            return a/b;
        }
        return Integer.MIN_VALUE;
    }
}
