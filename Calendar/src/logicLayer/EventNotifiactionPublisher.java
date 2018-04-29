/**
 * 
 */
package logicLayer;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import dataLayer.Event.Notification;

/**
 * @author plisik
 *
 */
public class EventNotifiactionPublisher {

	public interface NotificationReciver {
		public void reciveNotification(String message);

	}

	public interface NotifiactionSource {
		List<Notification> getAllNotifications();
	}

	private class NotifiactionTask extends TimerTask {

		Notification n;
		NotificationReciver reciver;

		@Override
		public void run() {
			reciver.reciveNotification(n.getDescripton());

		}

		/**
		 * @param n
		 */
		public NotifiactionTask(Notification n, NotificationReciver reciver) {
			super();
			this.n = n;
			this.reciver = reciver;
		}

	}

	List<NotificationReciver> recivers = new LinkedList<NotificationReciver>();
	Timer timer = new Timer();
	NotifiactionSource source;
	public EventNotifiactionPublisher(NotifiactionSource source) {
		this.scheduleAllNotifications(source.getAllNotifications());
		this.source=source;

	}

	public void addReciver(NotificationReciver reciver) {
		recivers.add(reciver);
	}

	private void scheduleAllNotifications(List<Notification> notifySet) {
		/*
		 * schedule every notification for every receiver
		 */
		for (Notification n : notifySet) {
			for (NotificationReciver receiver : recivers) {
				NotifiactionTask task = new NotifiactionTask(n, receiver);
				timer.schedule(task, n.getDate());
			}

		}
	}
/**
 * Delete all notifications and reschedule all
 */
	public void update() {
		timer.purge();
		scheduleAllNotifications(source.getAllNotifications());
	}

}
