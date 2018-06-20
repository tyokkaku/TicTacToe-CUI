public enum EnumPiece {
    Maru("○"),
    Batu("×"),
    None("  "),
    Out("Out");

    private String name;

    public String getName() {
        return this.name;
    }

    private EnumPiece(String name) {
        this.name = name;
    }
}
