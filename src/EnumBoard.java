/**
 * ボード設計の定数
 */

public enum EnumBoard {
    // ボードの枠組み
    ticTacToeBoard_Height(3),
    ticTacToeBoard_Width(3),
    ticTacToeBoard_Min(0);

    private int length;

    public int getLength() {
        return this.length;
    }

    EnumBoard(int length) {
        this.length = length;
    }
}
