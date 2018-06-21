import java.util.ArrayList;

public class Board {

    /**
     * 持ち駒(Piece)の定数
     */
    String None = EnumPiece.None.getName();
    String Out = EnumPiece.Out.getName();

    /**
     * ボード設計の定数
     */
    int boardHeight = EnumBoard.ticTacToeBoard_Height.getLength();
    int boardWidth = EnumBoard.ticTacToeBoard_Width.getLength();
    int boardMin = EnumBoard.ticTacToeBoard_Min.getLength();

    /**
     * ルール設計の定数
     */
    int judgeVictoryNum_Upper = EnumRule.ticTacToeJudgeVictoryNum_Upper.getNum();
    int judgeVictoryNum_Lower = EnumRule.ticTacToeJudgeVictoryNum_Lower.getNum();

    /** プレイヤーを格納する */
    private ArrayList<Player> players_ = new ArrayList<>();

    /** ボードを用意する */
    private String[][] board_ = new String[boardHeight][boardWidth];

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
    void putPiece(int x, int y, String MaruBatu) {
        board_[y][x] = MaruBatu;
    }

    /**
     * 持ち駒を置けるかどうか判定する。
     *
     * @param x
     * @param y
     */
    boolean canPutPiece(int x, int y) {
        return (board_[y][x].equals(None));
    }

    /**
     * ボードに置いてある駒の種類を検索する
     *
     * @param x x軸の値
     * @param y y軸の値
     * @return MaruBatu
     */
    String judgePieceType(int x, int y){
        if(x < boardMin || y < boardMin || x >= boardWidth || y >= boardHeight){
            return Out;
        }
        return board_[y][x];
    }

    /**
     * ボードを描画する
     */
    void renderBoard() {
        // ボードを描画する
        System.out.println("     0    1    2    ");
        System.out.print("0 ");
        for(int i = 0; i < boardWidth; i++){
            System.out.print(" | " + board_[0][i]);
        }
        System.out.println(" | ");
        System.out.print("1 ");
        for(int i = 0; i < boardWidth; i++){
            System.out.print(" | " + board_[1][i]);
        }
        System.out.println(" | ");
        System.out.print("2 ");
        for(int i = 0; i < boardWidth; i++){
            System.out.print(" | " + board_[2][i]);
        }
        System.out.println(" | ");
        System.out.println("                    ");
    }

    /**
     * 置いた駒の上下左右斜めを検索して駒をカウントする
     *
     * @param x x軸の値
     * @param y y軸の値
     * @return 勝利条件を満たすならtrueを返す
     */
    boolean judgePieceCount(int x, int y, String MaruBatu, Board board) { // yとxを逆に受け取っている。わかりにくい。

        boolean result = false;

        // 全方位分のカウントストック
        int maruBatuCount_vertical = 0;
        int maruBatuCount_horizon = 0;
        int maruBatuCount_slightRight = 0;
        int maruBatuCount_slightLeft = 0;

        for (int i = judgeVictoryNum_Lower; i < judgeVictoryNum_Upper; i++) {
            // 上下を検索する
            if (board.judgePieceType(x, y + i).equals(MaruBatu)) {
                maruBatuCount_vertical++;
                if (maruBatuCount_vertical >= 3) {
                    result = true;
                    break;
                }
            }
            // 左右を検索する
            if (board.judgePieceType(x + i, y).equals(MaruBatu)) {
                maruBatuCount_horizon++;
                if (maruBatuCount_horizon >= 3) {
                    result = true;
                    break;
                }
            }
            // 斜め右を検索する
            if (board.judgePieceType(x + i, y - i).equals(MaruBatu)) {
                maruBatuCount_slightRight++;
                if (maruBatuCount_slightRight >= 3) {
                    result = true;
                    break;
                }
            }
            // 斜め左を検索する
            if (board.judgePieceType(x + i, y + i).equals(MaruBatu)) {
                maruBatuCount_slightLeft++;
                if (maruBatuCount_slightLeft >= 3) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 勝利を宣言する。
     *
     * @param player 勝利宣言したプレイヤー
     * @param board 最終結果を表示するボード
     */
    void declareWin(Player player, Board board){
        board.renderBoard();
        System.out.println(player.name_ + "の勝利です！");
        players_.remove(players_.indexOf(player));
    }

    /**
     * プレイヤーを登録する。
     *
     * @param player1 先手のプレイヤー
     * @param player2 後手のプレイヤー
     */
    void registerPlayer(Player player1, Player player2){
        players_.add(player1);
        players_.add(player2);
    }

    /**
     * ゲームを準備する。（盤面を初期化する）
     */
    void prepareGame(){
        // 盤面を初期化する
        for(int a = 0; a < boardHeight; a++){
            for(int b = 0; b < boardWidth; b++){
                board_[a][b] = None; // すべてNoneで初期化する
            }
        }
    }

    /**
     * ゲームを開始する。
     */
    void startGame(Board board){
        int numberOfPlayer = players_.size();
        for(int count = 0; 1 < players_.size(); count++){
                int currentPlayerNumber = count % numberOfPlayer; // 0 // 1 // 0
                //  nextPlayerを使用する場合は以下を使う
                //  int nextPlayerNumber = (count + 1) % numberOfPlayer; // 1 // 0 // 1
                //  Player nextPlayer = players_.get(nextPlayerNumber);
                Player currentPlayer = players_.get(currentPlayerNumber);
                currentPlayer.play(board);
                if(count == boardWidth * boardHeight - 1){
                    board.renderBoard();
                    System.out.println("引き分けです！");
                    break;
                }
        }
    }
}
