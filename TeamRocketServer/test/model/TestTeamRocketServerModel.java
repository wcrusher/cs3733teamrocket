package model;

import db.Manager;
import junit.framework.TestCase;
/**
 * 
 * @author Timothy Kolek
 *
 */
public class TestTeamRocketServerModel extends TestCase {
	public void testServer() {
		TeamRocketServerModel serverModel = new TeamRocketServerModel();
		DLEvent event = new DLEvent("id123", "moderator", "What is the meaning of life?", 5, 3);
		String id = serverModel.addDLEvent(event);
		serverModel.getAdmin();
		Manager.deleteEvent("id123");
		
	}

}
