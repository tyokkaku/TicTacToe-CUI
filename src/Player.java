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

        // 駒を置く
        board.putPiece(putPos[0],putPos[1],this.Marubatu_);

        System.out.println(this.name_ + "が" + putPos[0] + "," + putPos[1] + "に置きました");
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
            // 入力を受け付ける
            System.out.println("置く場所を入力してください");

            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(in);
            try {
                System.out.print("X軸：");
                String line = reader.readLine();
                posX = Integer.parseInt(line);

                System.out.print("Y軸：");
                String line2 = reader.readLine();
                posY = Integer.parseInt(line2);
            } catch(IOException e) {
                System.out.println("入力値が不正です");
            }
            putPos[0] = posX;
            putPos[1] = posY;
            return putPos;
        }
    }
}
