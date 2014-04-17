package org.edu.stiffy.algo;

/**
 * This program calculates actual angle between hour and minute hand
 * 
 * @see http://en.wikipedia.org/wiki/Clock_angle_problem
 * @author manishdevraj
 * 
 */
public class ClockHandAngle {
	private static int hour;
	private static int minutes;

	public static void main(String[] args) {
		if (args.length == 2) {
			try {
				hour = new Integer(args[0]).intValue();
				minutes = new Integer(args[1]).intValue();
				if (validClock(hour, minutes)) {
					double angle = findAngle(hour, minutes);

					System.out.println("Clock -: " + args[0] + " : " + args[1]
							+ " has angle of " + angle + "¼");
				} else {
					System.err.println("Invalid values :- " + args[0] + " : "
							+ args[1]);
				}

			} catch (NumberFormatException numFormatEx) {
				System.err.println("Cannot convert time into number values: "
						+ args[0] + " : " + args[1]);
			}
		} else {
			System.err
					.println("Insufficient input arguments, please provide hour and minute (12 clock format) to find angle!!!");
		}

	}

	private static boolean validClock(final int hour, final int mins) {
		boolean isValid = false;
		if ((hour >= 0 && hour <= 11) && (mins >= 1 && mins <= 60)) {
			isValid = true;
		}
		return isValid;
	}

	private static double findAngle(final int hour, final int mins) {
		return (60 * hour - 11 * mins) * 0.5;
	}
}
