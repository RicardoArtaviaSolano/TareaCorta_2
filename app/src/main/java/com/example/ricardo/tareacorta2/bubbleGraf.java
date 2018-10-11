package com.example.ricardo.tareacorta2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;


public class bubbleGraf extends AppCompatActivity {



    LineGraphSeries<DataPoint> series;
    private Button addPt;
    private EditText plotx;
    GraphView graph;
    PointsGraphSeries<DataPoint> xySeries;







    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_graf);

        final TextView valorDeY =(TextView)findViewById(R.id.valorY);

        double y, x;
        x = 0;

        addPt = (Button)findViewById(R.id.addButton);
        plotx = (EditText) findViewById(R.id.largoArray);





        final GraphView graph = (GraphView) findViewById(R.id.grafico);
        series = new LineGraphSeries<DataPoint>();


        for (int i = 0; i < 100; i++) {
            x = x + 1.0;
            y = Math.pow(x, 2);
            series.appendData(new DataPoint(x, y), true, 100);
        }




        graph.addSeries(series);





        xySeries = new PointsGraphSeries<>();
        addPt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!plotx.getText().toString().equals("")) {
                    Double xLargo = Double.parseDouble(plotx.getText().toString());
                    Double yTiempo = Math.pow(xLargo, 2);
                    xySeries.appendData(new DataPoint(xLargo, yTiempo), true, 1);
                    valorDeY.setText("El algoritmo tarda: " + yTiempo);
                    graph.addSeries(xySeries);

                }
            }

        });


        xySeries.setColor(Color.RED);

    }
}


