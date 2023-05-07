  public class VolunteerTask {  
      
      private String task;
      private int hour;
      private int length;
  
  /** Skapar ett frivilligpass för uppgiften task, med 
        starttiden hour och längden length timmar. */
    public VolunteerTask(String task, int hour, int length) {
        this.task = task;
        this.hour = hour;
        this.length = length;
    }
 
    /** Returnerar starttiden för frivilligpasset */
    public int getStart() {
       
        return hour;
    }
    
    public int getStop() {
        
        return hour+length;
    }
 
    /** Returnerar true om frivilligpasset helt 
        eller delvis kolliderar med
        frivilligpasset vt, annars false. */
    public boolean collidesWith(VolunteerTask vt) {
        
        if ((hour < vt.getStart() && vt.getStart() < hour + length) || (hour < vt.getStop() && vt.getStop() < hour + length)) {
            return true;
        } return false;
    }
 
    /** Returnerar frivilligpasset som en sträng 
        enligt följande exempel: "Handla åt Gun 17-19" */
    public String toString() {
        
        return task + " " + hour + "-" + getStop();
        
    }
    
    
    
  }