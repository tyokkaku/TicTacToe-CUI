/**
 * ルール設計の定数
 */
public enum EnumRule {
    // 三目並べの勝利条件
    ticTacToeJudgeVictoryNum_Upper(2),
    ticTacToeJudgeVictoryNum_Lower(-2);

    private int num;

    public int getNum(){
        return this.num;
    }

    EnumRule(int num){
        this.num = num;
    }
}
