package generalassembly.yuliyakaleda.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
  private static final int NOTIFICATION_ID = 1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button notification = (Button) findViewById(R.id.notification);
    Button inboxStyle = (Button) findViewById(R.id.inbox_style);
    Button bigTextStyle = (Button) findViewById(R.id.big_text_style);
    Button bigPictureStyle = (Button) findViewById(R.id.big_picture_style);

    notification.setOnClickListener(this);
    inboxStyle.setOnClickListener(this);
    bigTextStyle.setOnClickListener(this);
    bigPictureStyle.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.notification:
        showNormalNotification();
        break;
      case R.id.inbox_style:
        showInboxStyleNotification();
        break;
      case R.id.big_text_style:
        showBigTextStyle();
        break;
      case R.id.big_picture_style:
        showBigPictureStyle();
        break;
    }
  }

  private void showBigPictureStyle() {
    NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
    bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.nature)).build();

    Intent intent = new Intent(this, SecondActivity.class);
    // use System.currentTimeMillis() to have a unique ID for the pending intent
    PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
    mBuilder.setSmallIcon(android.R.drawable.ic_dialog_alert);
    mBuilder.setContentTitle("Notification Alert, Click Me!");
    mBuilder.setContentText("Hi, This is Android Notification Detail!");
    mBuilder.setContentIntent(pIntent);
    mBuilder.setPriority(Notification.PRIORITY_MAX);
    mBuilder.setStyle(bigPictureStyle);

    NotificationManager mNotificationManager =
        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    // NOTIFICATION_ID allows you to update the notification later on.
    mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
  }

  private void showBigTextStyle() {
    //Assign inbox style notification
    NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
    bigText.bigText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
    bigText.setBigContentTitle("Big Text Notification");
    bigText.setSummaryText("By: Author of Lorem ipsum");

    Intent intent = new Intent(this, SecondActivity.class);
    // use System.currentTimeMillis() to have a unique ID for the pending intent
    PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
    mBuilder.setSmallIcon(android.R.drawable.ic_dialog_alert);
    mBuilder.setContentTitle("Notification Alert, Click Me!");
    mBuilder.setContentText("Hi, This is Android Notification Detail!");
    mBuilder.setContentIntent(pIntent);
    mBuilder.setPriority(Notification.PRIORITY_MAX);
    mBuilder.setStyle(bigText);

    NotificationManager mNotificationManager =
        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    // NOTIFICATION_ID allows you to update the notification later on.
    mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
  }

  private void showInboxStyleNotification() {
    NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
    inboxStyle.setBigContentTitle("Inbox Notification");
    inboxStyle.addLine("Message 1.");
    inboxStyle.addLine("Message 2.");
    inboxStyle.addLine("Message 3.");
    inboxStyle.addLine("Message 4.");
    inboxStyle.addLine("Message 5.");
    inboxStyle.setSummaryText("+2 more");

    Intent intent = new Intent(this, SecondActivity.class);
    // use System.currentTimeMillis() to have a unique ID for the pending intent
    PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
    mBuilder.setSmallIcon(android.R.drawable.ic_dialog_alert);
    mBuilder.setContentTitle("Notification Alert, Click Me!");
    mBuilder.setContentText("Hi, This is Android Notification Detail!");
    mBuilder.setContentIntent(pIntent);
    mBuilder.setPriority(Notification.PRIORITY_MAX);
    mBuilder.setStyle(inboxStyle);

    NotificationManager mNotificationManager =
        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    // NOTIFICATION_ID allows you to update the notification later on.
    mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
  }

  private void showNormalNotification() {
    Intent intent = new Intent(this, SecondActivity.class);
    // use System.currentTimeMillis() to have a unique ID for the pending intent
    PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
    mBuilder.setSmallIcon(android.R.drawable.ic_dialog_alert);
    mBuilder.setContentTitle("Notification Alert, Click Me!");
    mBuilder.setContentText("Hi, This is Android Notification Detail!");
    mBuilder.setContentIntent(pIntent);
    mBuilder.setAutoCancel(true);
    mBuilder.setPriority(Notification.PRIORITY_MAX);
    mBuilder.setContentInfo("More Info");

    mBuilder.addAction(android.R.drawable.ic_input_add,"Hello",pIntent);
    mBuilder.addAction(android.R.drawable.ic_input_get,"Hello2",pIntent);

    NotificationManager mNotificationManager =
        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    // NOTIFICATION_ID allows you to update the notification later on.
    mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
  }

}
