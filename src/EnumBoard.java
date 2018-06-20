public enum EnumBoard {
    ticTacToeBoard_Height(3),
    ticTacToeBoard_Width(3),
    ticTacToeBoard_Min(0);

    private int length;

    public int getLength() {
        return this.length;
    }

    private EnumBoard(int length) {
        this.length = length;
    }
}
