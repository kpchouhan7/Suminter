package com.example.loginregister;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class imagepage extends AppCompatActivity {

    GridView coursesGV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagepage);

        coursesGV = findViewById(R.id.idGVcourses);

        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();
        courseModelArrayList.add(new CourseModel("DAA", R.drawable.seven));
        courseModelArrayList.add(new CourseModel("JAVA", R.drawable.seven));
        courseModelArrayList.add(new CourseModel("C++", R.drawable.seven));
        courseModelArrayList.add(new CourseModel("Python", R.drawable.seven));
        courseModelArrayList.add(new CourseModel("DDL", R.drawable.seven));
        courseModelArrayList.add(new CourseModel("LAAC", R.drawable.seven));

        CourseGVAdapter adapter = new CourseGVAdapter(this, courseModelArrayList);
        coursesGV.setAdapter(adapter);
    }
}
