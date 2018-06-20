import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * プレイヤーを表すクラス。
 */
public class Player {

    // 配列のインデックス。Playerクラスでのみ使用する
    private static int Y_axis = 0;
    private static int X_axis = 1;

    // ボード設計の定数
    int boardHeight = EnumBoard.ticTacToeBoard_Height.getLength();
    int boardWidth = EnumBoard.ticTacToeBoard_Width.getLength();
    int boardMin = EnumBoard.ticTacToeBoard_Min.getLength();

    String name_;
    String Marubatu_;

    /**
     * プレイヤーのコンストラクタ。
     *
     * @param name プレイヤーの名前
     * @param MaruBatu マルかバツかを登録する
     */
    Player(String name, String MaruBatu){
        this.name_ = name;
        this.Marubatu_ = MaruBatu;
    }

    /**
     * プレイする。
     *
     * @param board ボード
     */
    public void play(Board board){

        // ナビゲーション
        System.out.println(this.name_ + "が" + Marubatu_ + "でプレイします");

        board.renderBoard();

        int putPos[] = AskPutPosition(board);

        board.putPiece(putPos[X_axis],putPos[Y_axis],this.Marubatu_);
        System.out.println(this.name_ + "が、X軸：" + putPos[X_axis] + ",Y軸：" + putPos[Y_axis] + "に置きました");

        if(board.judgePieceCount(putPos[X_axis], putPos[Y_axis], this.Marubatu_, board)){
            board.declareWin(this, board);
            return;
        }
    }

    /**
     * プレイヤーに駒を置く場所を入力してもらう
     *
     * @param board ボード
     * @return putPosition 多次元配列の番号
     */
    public int[] AskPutPosition(Board board){
        // 入力された数値を格納する配列
        int putPos[] = new int[2];

        int posX;
        int posY;

        while(true){
            try {
                // 入力を受け付ける
                System.out.println("置く場所を入力してください");

                InputStreamReader in = new InputStreamReader(System.in);
                BufferedReader reader = new BufferedReader(in);

                System.out.print("X軸：");
                String line1 = reader.readLine();
                posX = Integer.parseInt(line1);

                System.out.print("Y軸：");
                String line2 = reader.readLine();
                posY = Integer.parseInt(line2);

                // 範囲外の数値が入力された場合はやり直し
                if(posX < boardMin || posY < boardMin || posX >= boardWidth || posY >= boardHeight){
                    System.out.println("入力値が不正です。盤面の範囲まで入力できます");
                    // 既に置いてある場合もやり直し
                } else if(!board.canPutPiece(posX, posY)) {
                    System.out.println("既に駒が置かれています。もう一度入力してください。");
                    board.renderBoard();
                } else {
                    break;
                }
            } catch(Exception e) {
                System.out.println("入力値が不正です");
            }
        }
        // 二次元配列[Y軸][X軸]で代入する
        putPos[Y_axis] = posY;
        putPos[X_axis] = posX;
        return putPos;
    }
}
