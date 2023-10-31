import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerClass {
    
    boolean justRan = false; //This is just to fix Task from runnning more than once in a second

    TimerClass(){}

    //Sets up Task class to run every Friday at 
    public void runTask() {
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("America/Chicago"));    //current time and date

        ZoneId z = ZoneId.of( "America/Chicago" ); //just sets zone
        LocalDate today = LocalDate.now(z); //current date
        DayOfWeek dow = DayOfWeek.of(5) ;  // Friday = 5.
        LocalTime lt = LocalTime.of(23,59,59); //first field is hours (23== 11pm), second field is minutes, third is seconds
        LocalDate ld = today.with(TemporalAdjusters.next(dow)); //Gets next friday

        //check if it should happen today
        if(!justRan && today.getDayOfWeek()==dow){
            int value = lt.compareTo(currentTime.toLocalTime()); 
            //if triggers when lt (desired time) hasn't happened yet
            if(value > 0){
                //should happen today so instead of next friday make ld this friday (today)
                ld = today;
            }
        }
        justRan = false;

        ZonedDateTime nextRun = ZonedDateTime.of(ld,lt,z); //Now will get this zone's time using ld (localDate) lt (localTime) and z (Zone)
        // System.out.println(nextRun); //Outs next run time

        Duration duration = Duration.between(currentTime, nextRun); 
        long initialDelay = duration.getSeconds();  

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1); //just # of tasks so in this case 1 
        scheduler.schedule(new Task(), initialDelay, TimeUnit.SECONDS);  //Runs new task instance after delay
    }

    class Task extends TimerTask {
        public void run() {
            justRan = true; //need to set true so I don't just run this multiple times every friday at midnight
            runTask();  //makes sure Task is setup to run next friday at midnight too
        
            //Instead of system.out below do actual report generation
            System.out.println("Task performed NOW");
        }
    };

    

}
