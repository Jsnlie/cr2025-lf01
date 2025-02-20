package exercise.the_bloaters;

import java.util.Date;

public class DecomposeConditional {

	class Stadium {
		private final Date SUMMER_START = new Date(1500);
		private final Date SUMMER_END = new Date(2500);
		public double summerRate;
		public double winterRate;
		public double winterServiceCharge;

		public Stadium(double summer, double winter, double service) {
			this.summerRate = summer;
			this.winterRate = winter;
			this.winterServiceCharge = service;
		}

		// TODO: change the conditional logic in this method using
		// decompose conditional

		public boolean Winter(Date date) {
			return date.before(SUMMER_START) || date.after(SUMMER_END);
		}

		public double winterCharge(int quantity) {
			return quantity * winterRate + winterServiceCharge;
		}

		public double summerCharge(int quantity) {
			return quantity * summerRate;
		}

		public double getTicketPrice(Date date, int quantity) {
			if (Winter) {
				return winterCharger(quantity);
			} else {
				return summerCharger(quantity);
			}
		}
	}

	public void test() {
		Stadium s = new Stadium(100, 90, 25);
		System.out.println(s.getTicketPrice(new Date(1000), 10));
		System.out.println(s.getTicketPrice(new Date(2000), 10));
		System.out.println(s.getTicketPrice(new Date(3000), 10));
	}

	public static void main(String[] args) {
		new DecomposeConditional().test();
	}

}
