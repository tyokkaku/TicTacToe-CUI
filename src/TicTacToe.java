public class TicTacToe {
    public static void main(String[] args){

        // ボードの生成
        Board board = new Board();

        // プレイヤーの生成
        Player Tyokkaku = new Player("Tyokkaku", Board.Maru);
        Player Heikou = new Player("Heikou", Board.Batu);

        // プレイヤーの登録
        board.registerPlayer(Tyokkaku,Heikou);

        // ゲームの準備
        board.prepareGame();

        // ゲーム開始
        board.startGame(board);
    }
}
