package EnumMethod;

import static EnumMethod.OutCome.DRAW;
import static EnumMethod.OutCome.LOSE;
import static EnumMethod.OutCome.WIN;

public enum  RoShamBo2 implements Competitor<RoShamBo2>{
    PAPER(DRAW,LOSE,WIN),
    SCISSORS(WIN,DRAW,LOSE),
    ROCK(LOSE,WIN,DRAW);
    private OutCome vPAPER,vSCISSORS,vROCK;
    RoShamBo2(OutCome vPAPER,OutCome vSCISSORS,OutCome vROCK){
        vPAPER = vPAPER;
        vSCISSORS = vSCISSORS;
        vROCK = vROCK;

    }

    @Override
    public OutCome compete(RoShamBo2 competitor) {
        switch (competitor){
            default:
            case PAPER:return vPAPER;
            case ROCK:return vROCK;
            case SCISSORS:return vSCISSORS;
        }
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class,20);
    }
}
