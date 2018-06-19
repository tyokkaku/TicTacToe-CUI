import java.util.ArrayList;

public class Board {

    public static final String Maru = "○";
    public static final String Batu = "×";
    public static final String None = "  ";


    public static final int ticTacToeBoardHeight = 3;
    public static final int ticTacToeBoardWidth = 3;

    ArrayList<Player> players_ = new ArrayList<>();
    String[][] board_ = new String[ticTacToeBoardHeight][ticTacToeBoardWidth];

    /**
     * ボードのコンストラクタ。
     */
    Board(){
    }

    /**
     * 盤面に持ち駒を置く。
     *
     * @param x
     * @param y
     * @param MaruBatu
     */
    public void putPiece(int x, int y, String MaruBatu) {
        board_[x][y] = MaruBatu;
        System.out.println(board_[x][y]);
        renderBoard();
    }

    /**
     * ボードを描画する
     */
    public void renderBoard() {
        // ボードを描画する
        for(int i = 0; i < ticTacToeBoardWidth; i++){
            System.out.print(" | " + board_[0][i]);
        }
        System.out.println(" | ");
        for(int i = 0; i < ticTacToeBoardWidth; i++){
            System.out.print(" | " + board_[1][i]);
        }
        System.out.println(" | ");
        for(int i = 0; i < ticTacToeBoardWidth; i++){
            System.out.print(" | " + board_[2][i]);
        }
        System.out.println(" | ");
    }

    /**
     * プレイヤーを登録する。
     *
     * @param player1
     * @param player2
     */
    public void registerPlayer(Player player1, Player player2){
        players_.add(player1);
        players_.add(player2);
    }

    /**
     * ゲームを開始する。
     */
    public void startGame(Board board){

        // 盤面を初期化する
        for(int a = 0; a < ticTacToeBoardHeight; a++){
            for(int b = 0; b < ticTacToeBoardWidth; b++){
                board_[a][b] = None;
            }
        }

        int numberOfPlayer = players_.size();
        for(int count = 0; count < 2; count++){
            int currentPlayerNumber = count % numberOfPlayer; // 0 // 1 // 0
//            int nextPlayerNumber = (count + 1) % numberOfPlayer; // 1 // 0 // 1

//            Player nextPlayer = players_.get(nextPlayerNumber);
            Player currentPlayer = players_.get(currentPlayerNumber);

            currentPlayer.play(board);
        }
    }

    /**
     * ボードを文字列で表現する
     */
    @Override
    public String toString() {
        return "まる";
    }
}
