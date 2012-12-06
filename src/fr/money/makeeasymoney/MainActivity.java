package fr.money.makeeasymoney;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.LxpzNQ.OhmYYj122008.Airpush;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class MainActivity extends Activity {
	private Airpush airpush;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Create and setup the AdMob view
		AdRequest request = new AdRequest();
		request.addTestDevice(AdRequest.TEST_EMULATOR);

		AdView adView = new AdView(this, AdSize.BANNER, "a150c07251cb113"); // Put
		// in
		// your
		// secret
		// key
		// here
		adView.loadAd(request);
		adView.bringToFront();
		RelativeLayout layout = (RelativeLayout) findViewById(R.id.main);
		layout.addView(adView);

		if (Integer.parseInt(VERSION.SDK) > 3) {

			airpush = new Airpush(getApplicationContext());

			airpush.startPushNotification(false);// start push notification.

			airpush.startIconAd();// start icon.

			airpush.startSmartWallAd();// start random smart wall ad.

			airpush.startDialogAd();// start dialog ad.

			airpush.startAppWall();// start app wall.

			airpush.startLandingPageAd();// start landing page.

		} else {

			airpush = new Airpush(getApplicationContext());
			airpush.startPushNotification(false);
			airpush.startIconAd();
			airpush.startSmartWallAd();
		}
		
		WebView webView = (WebView) findViewById(R.id.webview1);
		webView.loadUrl("http://www.wikihow.com/Make-Easy-Money");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

			airpush.startSmartWallAd();

		}

		return super.onKeyDown(keyCode, event);

	}

}
