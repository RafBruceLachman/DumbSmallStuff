import java.util.Locale;

public class GimTwelfHorTime{
	static String ampm = "a.m.";
	
	public static void main(String... args){
		makeNonMilitary(args);
	}
	static void makeNonMilitary(String... time){
		try{
			int hours = Integer.parseInt(time[0]);
			int minutes = Integer.parseInt(time[1]);
			minutes = parseMinutes(minutes);
			hours = getNonMilitaryHours(hours);
			if(hours == 12 && minutes > 0){
				ampm = "p.m.";
			}
			System.out.println("Given time is: " + formatTime(hours) + ":" + formatTime(minutes) + " " + ampm);
		}catch(NumberFormatException notNumber){
			System.out.println("NOT A NUMBER!!!!!!");
		}catch(IllegalArgumentException notHour){
			System.out.println(notHour.getMessage());
		}catch(ArrayIndexOutOfBoundsException noargument){
			System.out.println("NO HOUR AND/OR MINUTES GIVEN!!!");
			System.out.println("pass two numbers, please! [hours minutes]");
		}
	};

	private static int getNonMilitaryHours(int hours) throws IllegalArgumentException{
		if(hours < 13){
			return hours;
		}else if(hours > 13 && hours < 25){
			if(hours == 24){
				return 0;
			}
			int NewHours = hours - 12;
			ampm = "p.m.";
			return NewHours;
		}else{
			throw new IllegalArgumentException("NOT A VALID HOUR!!!!");
		}
	}

	private static int parseMinutes(int minutes) throws IllegalArgumentException{
		if(minutes >= 0 && minutes < 60){
			return minutes;
		}else{
			throw new IllegalArgumentException("AMOUNT OF MINUTES NOT VALID!!!!");
		}
	}

	static String formatTime(int timeUnit){
		String timeString = String.format(Locale.US, "%02d", timeUnit);
		return timeString;
	}
}
