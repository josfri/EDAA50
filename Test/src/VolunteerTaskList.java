import java.util.ArrayList;

public class VolunteerTaskList {
   
   private ArrayList<VolunteerTask> allTasks;
   
   /** Skapar en tom lista för frivilligpass. */
    VolunteerTaskList() {
    
    allTasks = new ArrayList<VolunteerTask>();
        
    }

    /** Lägger till ett nytt frivilligpass för uppgiften task,
        med starttiden hour och längden length timmar. */
    void add(String task, int hour, int length) {
        
        VolunteerTask vt = new VolunteerTask(task,hour,length);
        for (int i = 0; i < allTasks.size(); i++ ) {
            
            if (allTasks.get(i).getStart() > hour) {
                allTasks.add(i, vt);
                return;
            }
        } allTasks.add(vt);
        
        
    }
    
    /** Returnerar en vektor som innehåller frivilligpassen 
        sorterade stigande efter starttid.
        Om inga frivilligpass är inlagda returneras en tom vektor*/              
    VolunteerTask[] toSortedArray() {
        
        VolunteerTask[]sorted = new VolunteerTask[allTasks.size()];
        int k = 0;
        
        for (VolunteerTask x: allTasks) { //kopiera
            sorted[k] = x;
            k++;
        }
        
        return sorted;

    }

     /** Returnerar en lista med de frivilligpass som är möjliga att arbeta
         om man redan också arbetar de pass som ligger i v.
         D.v.s. metoden returnerar de pass för denna listan som inte 
         kolliderar med något av de pass som finns i listan v. */
     ArrayList<VolunteerTask> possibleTasks(ArrayList<VolunteerTask> v) {
         
         ArrayList<VolunteerTask> possible = new ArrayList<VolunteerTask>();
         
         for (VolunteerTask w : allTasks) {
             
            possible.add(w);
         }
         
         for (int i = 0; i < v.size(); i++) {
             
             for (VolunteerTask w : possible) {
                 
                 if (v.get(i).collidesWith(w)) {
                     possible.remove(w);
                 }
             }
         }
         
         
         return possible;
     }
     
   }