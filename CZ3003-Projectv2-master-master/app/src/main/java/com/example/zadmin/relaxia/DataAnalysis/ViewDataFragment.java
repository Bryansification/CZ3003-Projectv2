package com.example.zadmin.relaxia.DataAnalysis;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zadmin.relaxia.Common.Shared;
import com.example.zadmin.relaxia.MainActivity;
import com.example.zadmin.relaxia.R;
import com.example.zadmin.relaxia.Utilities.Utils;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import static com.example.zadmin.relaxia.R.id.graphView;

/**
 * Created by Shide on 4/4/17.
 */

public class ViewDataFragment extends Fragment {

    private static final String TAG = "ViewDataFragmentClass";
    private GraphView mGraphView;
    private DataPoint[] values;
    private ScoreDataBaseHandler mScoreDataBaseHandler = ScoreDataBaseHandler.getInstance(Shared.context);

    private ImageView mBackgroundImage;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_data_fragment, container, false);

        values = mScoreDataBaseHandler.dbToCoords();
        mBackgroundImage = (ImageView) view.findViewById(R.id.background_image);

        mGraphView = (GraphView) view.findViewById(graphView);
        LineGraphSeries<DataPoint> lineGraphSeries = new LineGraphSeries<>(values);
        mGraphView.addSeries(lineGraphSeries);

        mGraphView.getViewport().setXAxisBoundsManual(true);
        mGraphView.getViewport().setMinX(0);
        mGraphView.getViewport().setMaxX(6);


        mGraphView.getViewport().setScrollable(true);

        mGraphView.setTitle("Child's Progress Report");
        mGraphView.setTitleTextSize(48);

        mGraphView.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);

        mGraphView.getGridLabelRenderer().setHorizontalAxisTitle("Attempts");
        mGraphView.getGridLabelRenderer().setHorizontalAxisTitleTextSize(48);


        mGraphView.getGridLabelRenderer().setVerticalAxisTitle("Stars Earned");
        mGraphView.getGridLabelRenderer().setVerticalAxisTitleTextSize(48);

        mGraphView.getViewport().setScrollable(true);

        return view;

    }


}
