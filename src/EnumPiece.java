/**
 * 駒の定数
 */
public enum EnumPiece {
    Maru("○"),
    Batu("×"),
    None("  "),
    Out("Out");

    private String name;

    public String getName() {
        return this.name;
    }

    EnumPiece(String name) {
        this.name = name;
    }
}
