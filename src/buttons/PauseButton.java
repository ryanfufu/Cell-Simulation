package buttons;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

/*
 * PlayButton class that inherits the ActionButton
 * Creates a PlayButton action that specifically pauses the grid simulation
 * @author Ryan Fu
 */
public class PauseButton extends ActionButton{
				
	private final String BUTTON_NAME = myResources.getString("Pause");

	public PauseButton(Color buttonColor) {
		super(buttonColor);
		this.setButtonText(BUTTON_NAME);
		this.setPauseEvent();
	}
	/*
	 * private method to set the action event to play
	 */
	private void setPauseEvent() {
		this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        pause();// activate the play method
		    }
		});
	}
	
	private void pause() {
		setPlayBoolean(false);
	}
}
