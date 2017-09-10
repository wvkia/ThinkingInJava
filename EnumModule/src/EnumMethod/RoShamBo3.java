package EnumMethod;
//实现competetor的实现第一个分发
public enum  RoShamBo3 implements Competitor<RoShamBo3>{
    ROCK{
        @Override
        public OutCome compete(RoShamBo3 competitor) {
            return compete(SCISSORS,competitor);
        }
    },
    SCISSORS{
        @Override
        public OutCome compete(RoShamBo3 competitor) {
            return compete(PAPER,competitor);
        }
    }
    ,PAPER{
        @Override
        public OutCome compete(RoShamBo3 competitor) {
            return compete(ROCK,competitor);
        }
    };
    //两个参数的方法实现第二个分发
    OutCome compete(RoShamBo3 loser,RoShamBo3 oppo){
        return ((oppo == this) ? OutCome.DRAW:((oppo == loser)?OutCome.WIN:OutCome.LOSE));
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo3.class,20);
    }

}
