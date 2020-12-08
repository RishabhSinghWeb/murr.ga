package murr.ga;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.*;
import android.webkit.*;
public class MainActivity extends Activity 
{
	private WebView wv;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		wv = findViewById(R.id.webview);
		wv.setWebViewClient(new MyWebViewClient());
		wv.getSettings().setJavaScriptEnabled(true);
		wv.getSettings().setSupportZoom(true);
		wv.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
		wv.loadUrl("murr.ga");
	}

	public final class MyWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
			Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
			startActivity(intent);
			return true;
		}
		
	}
	
}
