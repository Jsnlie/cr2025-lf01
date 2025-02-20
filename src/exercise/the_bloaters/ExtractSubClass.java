package exercise.the_bloaters;

public class ExtractSubClass {
// todo: extract subclass PartsItem & LaborItem from JobItem

	abstract class JobItem {
		protected int quantity;

		public JobItem(int quantity) {
			this.quantity = quantity;
		}

		public int getQuantity() {
			return quantity;
		}

		public int getTotalPrice() {
			return quantity * getUnitPrice();
		}

		public abstract int getUnitPrice();

	}

	class PartsItem extends JobItem {
		private int unitPrice;

		public PartsItem(int quantity, int unitPrice) {
			super(quantity);
			this.unitPrice = unitPrice;
		}

		@Override
		public int getUnitPrice() {
			return unitPrice;
		}
	}

	class isLabor extends JobItem {
		private Employee employee;

		public PartsItem(int quantity, Employee employee){
			super(quantity);
			this.employee = employee;
		}

		@Override
		public int getUnitPrice() {
			return employee.getRate();
		}
	}

	class Employee {
		private int rate;

		public Employee(int rate) {
			this.rate = rate;
		}

		public int getRate() {
			return rate;
		}
	}

	public void action() {
		Employee kent = new Employee(50);
		JobItem j1 = new JobItem(5, 0, true, kent);
		JobItem j2 = new JobItem(15, 10, false, null);
		int total = j1.getTotalPrice() + j2.getTotalPrice();
		System.out.println(total);
	}

	public static void main(String[] args) {
		new ExtractSubClass().action();
	}
}