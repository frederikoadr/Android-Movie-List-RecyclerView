package com.adrian.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    public  static  final  String EXTRA_PERSON = "extra_person";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvObject = findViewById(R.id.tv_object_received);
        TextView tvObject2 = findViewById(R.id.tv_object_received2);
        TextView genre = findViewById(R.id.genre);
        TextView imdb = findViewById(R.id.imdb_text);
        TextView storyline = findViewById(R.id.storyline_text);
        ImageView ivObject = findViewById(R.id.iv_object_received);

        Hero person = getIntent().getParcelableExtra(EXTRA_PERSON);
        //ivObject.;
        assert person != null;
        Picasso.get().load(person.getPhoto()).into(ivObject);
        tvObject.setText(person.getName());
        tvObject2.setText(person.getDescription());
        genre.setText(person.getMainDesc());
        imdb.setText(person.getImdb());
        storyline.setText(person.getStoryline());
        storyline.setMovementMethod(new ScrollingMovementMethod());
    }
}
