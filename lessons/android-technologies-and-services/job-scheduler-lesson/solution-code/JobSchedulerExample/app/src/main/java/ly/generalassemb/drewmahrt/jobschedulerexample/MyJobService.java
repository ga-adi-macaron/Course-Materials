package ly.generalassemb.drewmahrt.jobschedulerexample;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.AsyncTask;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by drewmahrt on 11/28/16.
 */

public class MyJobService extends JobService {
    private static final String TAG = "MyJobService";

    private AsyncTask mTask;
    
    @Override
    public boolean onStartJob(final JobParameters jobParameters) {
        Log.d(TAG, "onStartJob: "+jobParameters.getExtras().getString("type"));

        mTask = new AsyncTask<Void,Void,String>(){

            @Override
            protected String doInBackground(Void... voids) {

                //get an instance of a Calendar object
                //NOT the ContentProvider Calendar.
                Calendar cal = Calendar.getInstance();

                cal.setTimeInMillis(System.currentTimeMillis());

                //A helper class to format the time we get into human readable Strings
                SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");

                String newText = "Current Time: " + format.format(cal.getTime());

                return newText;
            }

            @Override
            protected void onPostExecute(String string) {
                super.onPostExecute(string);
                Log.d(TAG, "onPostExecute: "+string);
                jobFinished(jobParameters, true); //tell the JobScheduler we have completed the job
            }
        }.execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.d(TAG, "onStopJob: ");
        if(mTask != null && mTask.getStatus().equals(AsyncTask.Status.RUNNING)){ //check if task is running
            mTask.cancel(false); //cancel task as soon as possible without actually interrupting it
        }
        return false;
    }
}
