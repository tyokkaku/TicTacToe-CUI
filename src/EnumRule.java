public enum EnumRule {

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
