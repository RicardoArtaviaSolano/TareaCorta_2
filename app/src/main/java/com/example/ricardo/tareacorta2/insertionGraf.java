package com.example.ricardo.tareacorta2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

public class insertionGraf extends AppCompatActivity {


    LineGraphSeries<DataPoint> series2;
    private Button addPt2;
    private EditText plotx2;
    GraphView graph2;
    PointsGraphSeries<DataPoint> xySeries2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion_graf);

        final TextView valorDeY =(TextView)findViewById(R.id.valorYIn);

        double y, x;
        x = 0;

        addPt2 = (Button)findViewById(R.id.addButtonIn);
        plotx2 = (EditText) findViewById(R.id.largoArrayIn);





        final GraphView graph = (GraphView) findViewById(R.id.graficoIn);
        series2 = new LineGraphSeries<DataPoint>();


        for (int i = 0; i < 100; i++) {
            x = x + 1.0;
            y = Math.pow(x*Math.log10(x), 2);
            series2.appendData(new DataPoint(x, y), true, 100);
        }




        graph.addSeries(series2);





        xySeries2 = new PointsGraphSeries<>();
        addPt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!plotx2.getText().toString().equals("")) {
                    Double xLargo2 = Double.parseDouble(plotx2.getText().toString());
                    Double yTiempo2 = Math.pow(xLargo2*Math.log10(xLargo2), 2);
                    xySeries2.appendData(new DataPoint(xLargo2, yTiempo2), true, 1);
                    valorDeY.setText("El algoritmo tarda: " + yTiempo2);
                    graph.addSeries(xySeries2);

                }
            }

        });


        xySeries2.setColor(Color.RED);

    }
}

