import javafx.application.Application;
import javafx.stage.Stage;

public class UserTitle extends Application {
    @Override
    public void start(Stage window) {
        Parameters parameters = getParameters();
        String userTitle = parameters.getNamed().get("userTitle");

        window.setTitle(userTitle);
        window.show();
    }
}
