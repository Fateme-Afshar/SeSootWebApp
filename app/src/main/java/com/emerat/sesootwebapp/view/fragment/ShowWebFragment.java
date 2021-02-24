package com.emerat.sesootwebapp.view.fragment;

import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.emerat.sesootwebapp.R;
import com.emerat.sesootwebapp.databinding.FragmentShowWebBinding;
import com.emerat.sesootwebapp.utils.LoadingUtils;


public class ShowWebFragment extends Fragment {
    private FragmentShowWebBinding mBinding;

    public ShowWebFragment() {
        // Required empty public constructor
    }

    public static ShowWebFragment newInstance() {
        ShowWebFragment fragment = new ShowWebFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding=
                DataBindingUtil.inflate(inflater,R.layout.fragment_show_web, container, false);

        setupLoadingSite();
        setupBackBtn();
        return mBinding.getRoot();
    }

    private void setupBackBtn(){

        mBinding.webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        if (mBinding.webView.canGoBack()) {
                            mBinding.webView.goBack();
                        }else
                            getActivity().finish();
                    }
                    return false;
                }
                return true;
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setupLoadingSite() {
        if (LoadingUtils.checkHasInternet(getActivity().getSystemService(ConnectivityManager.class))){
            setupWebView();
        }else {
            setupVisibility(View.VISIBLE,View.GONE);
            mBinding.btnRefresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        setupLoadingSite();
                }
            });
        }
    }

    private void setupWebView() {
        setupVisibility(View.GONE,View.VISIBLE);
        mBinding.webView.loadUrl("http://www.3sootcrm.ir/authentication/login");
        mBinding.webView.getSettings().setJavaScriptEnabled(true);
        mBinding.webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest webResourceRequest) {
                return false;
            }
        });
    }

    private void setupVisibility(int noConnectionVisibility,int hasConnectionVisibility){
        mBinding.webView.setVisibility(hasConnectionVisibility);
        mBinding.btnRefresh.setVisibility(noConnectionVisibility);
        mBinding.tvNoConnection.setVisibility(noConnectionVisibility);
        mBinding.animNoConnect.setVisibility(noConnectionVisibility);
    }
}