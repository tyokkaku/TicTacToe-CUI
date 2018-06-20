import java.util.ArrayList;

public class Board {

    public static final String Maru = "○";
    public static final String Batu = "×";
    public static final String None = "  ";
    public static final String Out = "Out";

    public static final int ticTacToeBoardHeight = 3;
    public static final int ticTacToeBoardWidth = 3;
    public static final int ticTacToeBoardMin = 0;

    public static final int ticTacToeJudgeVictoryNumUpper = 2;
    public static final int ticTacToeJudgeVictoryNumLower = -2;

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
     * 持ち駒を置けるかどうか判定する。
     *
     * @param x
     * @param y
     */
    public boolean canPutPiece(int x, int y) {
        boolean result;
        if(board_[x][y] == None){
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    /**
     * ボードに置いてある駒の種類を検索する
     *
     * @param x x軸の値
     * @param y y軸の値
     * @return MaruBatu
     */
    public String judgePieceType(int x, int y){
        if(x < ticTacToeBoardMin || y < ticTacToeBoardMin || x >= ticTacToeBoardWidth || y >= ticTacToeBoardHeight){
            return Out;
        }
        String MaruBatu = board_[x][y];
        return MaruBatu;
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
     * 置いた駒の上下左右斜めを検索して駒をカウントする
     *
     * @param x
     * @param y
     * @return 勝利条件を満たすならtrueを返す
     */

    //    putPos[0] = posY; // Y軸を先に代入する
//    putPos[1] = posX;

    public boolean judgeVictory(int y, int x, String MaruBatu, Board board){ // yとxを逆に受け取っている。わかりにくい。
        boolean result = false;
        int MaruBatuCount = 0;
        for(int i = ticTacToeJudgeVictoryNumLower; i < ticTacToeJudgeVictoryNumUpper; i++){
            // 上下を検索する
            if(board.judgePieceType(x, y + i) == MaruBatu){
                System.out.println(x + "," + y + "地点に" + MaruBatu + "を検出しました。");
                MaruBatuCount++;
                System.out.println("カウントを1アップさせます。現在のカウント：" + MaruBatuCount);
                if(MaruBatuCount >= 3){
                    System.out.println("カウントが3以上になりました。trueを返します" + MaruBatuCount);
                    result = true;
                    break;
                }
            }
        }
        return result;
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
     * ゲームを準備する。（盤面を初期化する）
     */

    public void prepareGame(){
        // 盤面を初期化する
        for(int a = 0; a < ticTacToeBoardHeight; a++){
            for(int b = 0; b < ticTacToeBoardWidth; b++){
                board_[a][b] = None; // すべてNoneで初期化する
//                board_[a][b] = Maru; // すべてMaruで初期化する
//                board_[a][b] = Batu; // すべてBatuで初期化する
            }
        }
    }

    /**
     * ゲームを開始する。
     */
    public void startGame(Board board){
        int numberOfPlayer = players_.size();
        for(int count = 0; count < 10; count++){
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
