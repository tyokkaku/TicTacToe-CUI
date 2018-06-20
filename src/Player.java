import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * プレイヤーを表すクラス。
 */
public class Player {

    // プレイヤー名
    String name_;
    // マルかバツか
    String Marubatu_;

    Board board_;

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
     */
    public void play(Board board){

        System.out.println(this.name_ + "が" + Marubatu_ + "でプレイします");

        // 盤面を描画する
        board.renderBoard();

        // プレイヤーに置く場所を入力してもらう
        int putPos[] = AskPutPosition();

        if(!board.canPutPiece(putPos[0], putPos[1])){
            System.out.print("既に駒が置かれています");
            AskPutPosition();
        } else {

            // 駒を置く
            board.putPiece(putPos[0],putPos[1],this.Marubatu_);
            System.out.println(this.name_ + "が" + putPos[0] + "," + putPos[1] + "に置きました");

            if(board.judgeVictory(putPos[0], putPos[1], this.Marubatu_, board)){
                System.out.println("勝利です");
                return;
            };

//            board.decreaWin(this);
        }
    }


    /**
     * プレイヤーに駒を置く場所を入力してもらう
     *
     * @return putPosition 多次元配列の番号
     */
    public int[] AskPutPosition(){
        // 入力された数値を格納する配列
        int putPos[] = new int[2];

        int posX = 0;
        int posY = 0;

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

                if(posX < board_.ticTacToeBoardMin || posY < board_.ticTacToeBoardMin || posX > board_.ticTacToeBoardWidth || posY > board_.ticTacToeBoardHeight){
                    System.out.print("入力値が不正です。盤面の範囲まで入力できます");
                } else {
                    break;
                }
            } catch(IOException e) {
                System.out.println("入力値が不正です");
            }
        }
        putPos[0] = posY; // Y軸を先に代入する
        putPos[1] = posX;
        return putPos;
    }
}
