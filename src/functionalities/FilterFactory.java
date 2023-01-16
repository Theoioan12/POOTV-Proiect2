// Buliga Theodor Ioan
// 323 CA

package functionalities;

public final class FilterFactory {
    /**
     *
     * @param type
     * @return
     */
    public static Filter createFilter(final int type) {
        switch (type) {
            case 1: return new Filter1();
            default: return new Filter2();
        }

    }
    private FilterFactory() {

    }
}
