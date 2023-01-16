package functionalities;

public class FilterFactory {
    public static Filter createFilter(int type) {
        switch (type) {
            case 1: return new Filter1();
            default: return new Filter2();
        }

    }
}
