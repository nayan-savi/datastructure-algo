package queen;

public class QueenAttack {
    public static void main(String[] args) {
        int rQ = 3;
        int cQ = 3;
        int rO = 7;
        int cO = 5;
        System.out.println("Can I Attack Queen?");
        boolean result = canQueenAttack(rQ, cQ, rO, cO);
        System.out.println(result ? "Yes" : "No");
    }

    public static boolean canQueenAttack(int rQ, int cQ, int rO, int cO) {
        if(rQ == rO || cQ == cO || Math.abs(rQ - rO) == Math.abs(cQ - cO)) {
            return true;
        }
        return false;
    }
}
