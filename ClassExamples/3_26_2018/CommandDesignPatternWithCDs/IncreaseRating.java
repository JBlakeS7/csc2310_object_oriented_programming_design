import lsdn.Command;
public class IncreaseRating implements Command<CD> {
    public void execute(CD cd) {
        int currentRating = cd.getRating();
        if (currentRating < 10) {
            cd.setRating(currentRating + 1);
        }
    }
}