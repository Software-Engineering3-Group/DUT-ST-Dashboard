package com.example.dutstdashboard;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Line;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnyChartView chartView = findViewById(R.id.attendanceChart);

        // Create line chart
        Cartesian cartesian = AnyChart.line();

        // Prepare fake data
        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Week 1", 80));
        data.add(new ValueDataEntry("Week 2", 70));
        data.add(new ValueDataEntry("Week 3", 90));
        data.add(new ValueDataEntry("Week 4", 60));
        data.add(new ValueDataEntry("Week 5", 85));
        data.add(new ValueDataEntry("Week 6", 75));

        // Add series
        Line series = cartesian.line(data);

        // Optional styling
        series.name("Attendance %");
        series.hovered().markers().enabled(true);
        series.hovered().markers().type(com.anychart.enums.MarkerType.CIRCLE);
        series.hovered().markers().size(4d);

        cartesian.title("Weekly Attendance");
        cartesian.yAxis(0).title("Attendance %");
        cartesian.xAxis(0).title("Week");

        chartView.setChart(cartesian);
    }
}
