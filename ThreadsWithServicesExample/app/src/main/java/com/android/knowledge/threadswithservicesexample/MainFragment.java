package com.android.knowledge.threadswithservicesexample;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private static final String TAG = MainFragment.class.getSimpleName();
    public static final String KEY_SONG = "key_song";
    private static MainFragment mMainFragment;
    private Button mDownloadButton;
    private DownloadThread mDownloadThread;

    public static MainFragment getInstance() {
        if (null == mMainFragment) {
            mMainFragment = new MainFragment();
        }
        return mMainFragment;
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        /*final DownloadThread mDownloadThread = new DownloadThread();
        mDownloadThread.setName("DownloadThread");
        mDownloadThread.start();*/

        mDownloadButton = (Button) view.findViewById(R.id.downloadButton);

        mDownloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Downloading.....", Toast.LENGTH_SHORT).show();

                /*Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        downloadSong();
                    }
                };*/

                //Thread thread = new Thread(runnable);
                /*Thread thread = new DownloadThread();
                thread.setName("DownloadThread");
                thread.start();*/

                // Send the message to the handler for the processing
                for (String song : Playlist.SONGS) {
                    /*Message message = Message.obtain();
                    message.obj = song;*/

                    //Intent intent = new Intent(getActivity(), DownloadService.class);
                    Intent intent = new Intent(getActivity(), DownloadIntentService.class);
                    intent.putExtra(KEY_SONG, song);
                    getContext().startService(intent);
                    //mDownloadThread.mDownloadHandler.sendMessage(message);
                }

            }
        });

        return view;

    }

   /* *//**
     *
     *//*
    private void downloadSong() {
        Log.d(TAG, "START of downloadSong");
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis() + (10 * 1000);
        while(System.currentTimeMillis() < endTime) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "COMPLETION of downloadSong");
    }*/


}
