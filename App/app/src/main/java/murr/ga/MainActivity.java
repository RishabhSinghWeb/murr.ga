package murr.ga;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.*;
import android.webkit.*;
public class MainActivity extends Activity 
{
	private WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		wv1=findViewById(R.id.webview);
		wv1.setWebViewClient(new MyWebViewClient());
		wv1.getSettings().setJavaScriptEnabled(true);
		wv1.getSettings().setSupportZoom(true);
		wv1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
		wv1.loadUrl("murr.ga");
				
    }
	

	public final class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            Intent i = new Intent(Intent.ACTION_VIEW, request.getUrl());
            startActivity(i);
            return true;
        }

    }

}
