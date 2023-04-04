public class GimTwelfHorTime{
	static String ampm = "a.m.";
	
	public static void main(String... args){
		makeNonMilitary(args);
	}
	static void makeNonMilitary(String... time){
		try{
			int hours = Integer.parseInt(time[0]);
			int minutes = Integer.parseInt(time[1]);
			hours = getNonMilitaryHours(hours);
			if(hours == 12 && minutes > 0){
				ampm = "p.m.";
			}
			System.out.println("Given time is: " + hours + ":" + minutes + " " + ampm);
		}catch(NumberFormatException notNumber){
			System.out.println("NOT A NUMBER!!!!!!");
		}catch(IllegalArgumentException notHour){
			System.out.println(notHour.getMessage());
		}catch(ArrayIndexOutOfBoundsException noargument){
			System.out.println("NO HOUR AND/OR MINUTES GIVEN!!!");
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
}
