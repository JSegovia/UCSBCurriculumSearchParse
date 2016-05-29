import java.util.ArrayList;



public class ClassParser {
	
	static ArrayList<Lecture> courses = new ArrayList<Lecture>();
	
	public static void main(String[] args) {
		UCSBCurriculumSearch courses = new UCSBCurriculumSearch();
		ArrayList<String> lectures = courses.loadCourses();
		
		parse(lectures);	
	}
	
	
	static ArrayList<Lecture> parse(ArrayList<String> lectures){
		
		
		Lecture newCourse;
		
		int counter = -1;//used for the index of courses
		
		int index = 1; //Start at Anth 2
		String currentLect = lectures.get(index); //set to Anth 2
		String lectDays;
		String lectTimes;
		String lectLocation;
		String lectOcc;
		String sectDays;
		String sectTimes;
		String sectLocation;
		String sectOcc;
		Boolean isSect = false;
		
		
		for(int i = 0; i < lectures.size(); i++){
			if(isSect == false){
				lectDays = lectures.get(index+5);
				lectTimes = lectures.get(index+6);
				lectLocation = lectures.get(index+7);
				lectOcc = lectures.get(index+8);
				
				newCourse = new Lecture(currentLect,lectDays, lectTimes, lectLocation, lectOcc);
				courses.add(newCourse);
				counter++;
				
				if(index+11 < lectures.size()){
					//System.out.println("lect if 1");
					if(lectures.get(index+11).equals(currentLect)){
						//System.out.println("lect if 2");
						isSect = true;
					}
					else{
						//System.out.println("lect else");
						currentLect = lectures.get(index+11);
					}
					index = index+11;
				}
				
			}
			else{
				sectDays = lectures.get(index+5);
				sectTimes = lectures.get(index+6);
				sectLocation = lectures.get(index+7);
				sectOcc = lectures.get(index+8);
				
				
				courses.get(counter).addSection(sectDays, sectTimes, sectLocation, sectOcc);
				
				if(index+11 < lectures.size()){
					if(!(lectures.get(index+11).equals(currentLect))){
						isSect = false;
						currentLect = lectures.get(index+11);
					}
				
					index = index+11;
				}
			}
		}
		return courses;
	}
	

}
