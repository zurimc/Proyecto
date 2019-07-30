package com.lab.sdt.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean
@ViewScoped
public class lineChartBean {
	 private LineChartModel lineModel;

	  @PostConstruct
	  public void init() {
	      lineModel = new LineChartModel();
	      LineChartSeries s = new LineChartSeries();
	      s.setLabel("Population");

	      s.set(1, 5.20);
	      s.set(2, 19.63);
	      s.set(3, 59.01);
	      s.set(4, 139.76);
	      s.set(5, 300.4);
	      s.set(6, 630);

	      lineModel.addSeries(s);
	      lineModel.setLegendPosition("e");
	      Axis y = lineModel.getAxis(AxisType.Y);
	      y.setMin(0.5);
	      y.setMax(700);
	      y.setLabel("Millions");

	      Axis x = lineModel.getAxis(AxisType.X);
	      x.setMin(0);
	      x.setMax(7);
	      x.setTickInterval("1");
	      x.setLabel("Number of Years");

	  }

	  public LineChartModel getLineModel() {
	      return lineModel;
	  }
}
