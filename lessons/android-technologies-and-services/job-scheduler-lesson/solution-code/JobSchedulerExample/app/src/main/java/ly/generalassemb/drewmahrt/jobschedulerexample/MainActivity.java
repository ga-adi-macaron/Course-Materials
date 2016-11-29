package ly.generalassemb.drewmahrt.jobschedulerexample;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final int PERIODIC_JOB_ID = 1;
    public static final int RESCHEDULED_JOB_ID = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        PersistableBundle periodicBundle = new PersistableBundle();
        periodicBundle.putString("type","Periodic");

        JobInfo periodicJobInfo = new JobInfo.Builder(PERIODIC_JOB_ID,new ComponentName(this,MyJobService.class))
                .setExtras(periodicBundle)
                .setPeriodic(5000)
                .build();

        //jobScheduler.schedule(periodicJobInfo);

        PersistableBundle rescheduledBundle = new PersistableBundle();
        rescheduledBundle.putString("type","Rescheduled");

        JobInfo rescheduledJobInfo = new JobInfo.Builder(RESCHEDULED_JOB_ID,new ComponentName(this,MyJobService.class))
                .setExtras(rescheduledBundle)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setBackoffCriteria(5000,JobInfo.BACKOFF_POLICY_LINEAR)
                .build();

        jobScheduler.schedule(rescheduledJobInfo);
    }
}
