package com.example.implicit_intent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button searchButton;
    private Button dialButton;
    private Button playButton;
    private Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchButton = findViewById(R.id.web_search_button);
        dialButton = findViewById(R.id.dial_number_button);
        playButton = findViewById(R.id.play_music_button);
        shareButton = findViewById(R.id.share_pdf_button);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "VITAP";
                Uri searchUri = Uri.parse("https://www.google.com/search?q=" + query);
                Intent searchIntent = new Intent(Intent.ACTION_VIEW, searchUri);
                startActivity(searchIntent);
            }
        });

        dialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "1234567890";
                Uri dialUri = Uri.parse("tel:" + phoneNumber);
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, dialUri);
                startActivity(dialIntent);
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse("/storage/emulated/0/Download/y2mate.com - Mike Posner  I Took A Pill In Ibiza Seeb Remix Explicit.mp3"), "audio/*");
                startActivity(intent);
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pdfFilePath = "/path/to/pdf/file.pdf";
                Uri pdfUri = Uri.parse(pdfFilePath);
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("application/pdf");
                shareIntent.putExtra(Intent.EXTRA_STREAM, pdfUri);
                startActivity(Intent.createChooser(shareIntent, "Share PDF"));
            }
        });
    }
}
