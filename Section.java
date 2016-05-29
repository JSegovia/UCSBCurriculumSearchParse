
public class Section{
	
	String day;
	String time;
	String occupancy;
	String location;
	
	Section(String day, String time, String location, String occupancy){
		this.day = day;
		this.time = time;
		this.location = location;
		this.occupancy = occupancy;
		
	}

	String getDays(){
		return this.day;
	}
	String getTime(){
		return this.time;
	}
	String getLocation(){
		return this.location;
	}
	String getOcc(){
		return this.occupancy;
	}
	void print(){
		System.out.println(day);
		System.out.println(time);
		System.out.println(occupancy);
	}
}
