package com.example.prabh.recycler_view;

import java.util.ArrayList;

/**
 * Created by prabh on 14-04-2016.
 */
public class Data {
    public static ArrayList<Information> getData()
    {
        ArrayList<Information> data = new ArrayList<>();
        int[] images = {
                R.drawable.lion,R.drawable.dog,R.drawable.cat,R.drawable.bird,R.drawable.dogandcat,R.drawable.lift

        };
        String[] Categories = {"lion","dog","cat","bird","friends","lift"};

        for(int i=0;i<images.length;i++)
        {
            Information current = new Information();
            current.title = Categories[i];
            current.imageId = images[i];
            data.add(current); //adding all the information to array list that contain information
        }

        return data;
    }


}
