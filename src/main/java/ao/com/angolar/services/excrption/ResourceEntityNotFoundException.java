package ao.com.angolar.services.excrption;

public class ResourceEntityNotFoundException extends RuntimeException {

    public ResourceEntityNotFoundException (String msg) {
        super(msg);
    }
}
