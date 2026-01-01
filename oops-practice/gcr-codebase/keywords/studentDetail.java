 class studentDetail
{
	public static void main(String[] args) {
		student s=new student("jatin",42069,"A");
		student s1=new student("Vishal",69420,"O");
		s.totalCount();
		s.updateGrade(s,"C");
		s1.updateGrade(s1,"A");
		
		
		
	}
}
class student
{
    private static int totalstudent=0;
    private static String universityName="GLA University";
    private String name;
    private final int rollNumber;
    private String grade;
    public student( String name,int rollNumber,String grade)
    {
        this.name=name;
        this.rollNumber=rollNumber;
        this.grade=grade;
        totalstudent+=1;
    }
    public void totalCount()
    {
        System.out.println("total student Enrolled : "+totalstudent);
    }
    public static void displayTotalStudents()
    {
        
        System.out.println("University name is : "+universityName);

        
    }
    public void displaying()
    {
        System.out.println("Roll no is : "+rollNumber+"\nName is : "+name);
    }
    public void updateGrade(Object obj, String newGrade) {

        if (obj instanceof student) {
            student s = (student) obj;
            s.grade = newGrade;
            student.displayTotalStudents();
            s.displaying();
            System.out.println("Grade is : " + s.grade);
        } else {
            System.out.println("Invalid student object");
        }
    }
    
}