/**
 * 三目並べ
 */
public class TicTacToe {
    public static void main(String[] args){

        // 持ち駒(Piece)の定数
        String Maru = EnumPiece.Maru.getName();
        String Batu = EnumPiece.Batu.getName();

        // ボードの生成
        Board board = new Board();

        // プレイヤーの生成
        Player Tyokkaku = new Player("Tyokkaku", Maru);
        Player Heikou = new Player("Heikou", Batu);

        // プレイヤーの登録
        board.registerPlayer(Tyokkaku,Heikou);

        // ゲームの準備
        board.prepareGame();

        // ゲーム開始
        board.startGame(board);
    }
}
