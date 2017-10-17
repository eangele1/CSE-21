public class Student {
	private Date birthday;
	private Preference pref;
	private String name;
	private char gender;
	private Boolean matched = false;
	int score = 0;

	public Student (String name, char gender, Date birthday, Preference pref){
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.pref = pref;
	}

	public void setName(String name){
		this.name = name;
	}
	public void setGender(char gender){
		this.gender = gender;
	}

	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	public void setMatched(Boolean matched){
		this.matched = matched;
	}

	public void setPref(Preference pref){
		this.pref = pref;
	}

	public String getName(){
		return name;
	}

	public char getGender(){
		return gender;
	}

	public Date getBirthday(){
		return birthday;
	}
	public Preference getPref(){
		return pref;
	}
	public boolean getMatched(){
		return matched;
	}



	public int compare(Student st){
		if (this.gender==st.gender){
			int a = pref.compare(st.getPref());
			int b = birthday.compare(st.getBirthday());

			score = (40 - a) + (60 - b);
		}
		if (score > 100){
			return score = 100;
		}
		else if (score <= 100 && score >= 0 ){
			return score;
		}
		else 
			return score = 0;

	}
}