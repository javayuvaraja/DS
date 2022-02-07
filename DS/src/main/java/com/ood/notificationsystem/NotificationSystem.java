package com.ood.notificationsystem;

public interface Notifiable {
	public void sendNotification(String msg);

	public void getNotified(Notification notification);
}

public class Employee implements Notifiable {
	private String id;
	private String name;
	private Employee manager;
	private Queue notifications;
	private boolean leafLevel;
	private boolean optedOutNotifications;

	Employee(String id, String name, boolean leafLevel) {
		this.id = id;
		this.name = name;
		this.leafLevel = leafLevel;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	@Override
	public void sendNotification(String msg) {
		Notification notification = new Notification(this, msg);
		if (leafLevel) {
			List<Employee> peers = ((Manager) manager).getSubordinates();
			for (Employee peer : peers) {
				peer.getNotified(notification);
			}
		} else {
			Queue<Employee> queue = new LinkedList<>();
			queue.add(this);
			while (!queue.isEmpty()) {
				int size = queue.size();
				while (size > 0) {
					Employee emp = queue.poll();
					if (!emp.isOptedOutNotifications()) {
						emp.getNotified(notification);
					}
					if (!emp.leafLevel) {
						for (Employee e : ((Manager) emp).getSubordinates()) {
							queue.add(e);
						}
					}
					size--;
				}
			}
		}
	}

	@Override
	public void getNotified(Notification notification) {
		notifications.offer(notification);
	}

	public boolean isLeafLevel() {
		return leafLevel;
	}

	public void setLeafLevel(boolean leafLevel) {
		this.leafLevel = leafLevel;
	}

	public boolean isOptedOutNotifications() {
		return optedOutNotifications;
	}

	public void setOptedOutNotifications(boolean optedOutNotifications) {
		this.optedOutNotifications = optedOutNotifications;
	}
}

public class Developer extends Employee {
	List skills;

	public Developer(String id, String name) {
		super(id, name, true);
	}

	public List getSkills() {
		return skills;
	}

	public void setSkills(List skills) {
		this.skills = skills;
	}

}

public class Manager extends Employee {
	List subordinates;

	Manager(String id, String name, Grade grade, Designation designation) {
		super(id, name, false);
		subordinates = new ArrayList();
	}

	public void addIntoTeam(Employee employee) {
		subordinates.add(employee);
	}

	public void removeFromTeam(Employee employee) {
		subordinates.remove(employee);
	}

	public List getSubordinates() {
		return subordinates;
	}

	public void addSubordinate(Employee subordinate) {
		subordinates.add(subordinate);
	}

}