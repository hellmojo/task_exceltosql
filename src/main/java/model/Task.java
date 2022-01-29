package model;


import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;

public class Task {
    @ExcelCellName("id")
    private int id;
    @ExcelCellName("company")
    private String company;
    @ExcelCellName("date")
    private String date;
    @ExcelCell(3)
    int factQlicData1;
    @ExcelCell(4)
    int factQlicData2;
    @ExcelCell(5)
    int factQoilData1;
    @ExcelCell(6)
    int factQoilData2;
    @ExcelCell(7)
    int forecastQlicData1;
    @ExcelCell(8)
    int forecastQlicData2;
    @ExcelCell(9)
    int forecastQoilData1;
    @ExcelCell(10)
    int forecastQoilData2;


    public int getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getDate() {
        return date;
    }

    public int getFactQlicData1() {
        return factQlicData1;
    }

    public int getFactQlicData2() {
        return factQlicData2;
    }

    public int getFactQoilData1() {
        return factQoilData1;
    }

    public int getFactQoilData2() {
        return factQoilData2;
    }

    public int getForecastQlicData1() {
        return forecastQlicData1;
    }

    public int getForecastQlicData2() {
        return forecastQlicData2;
    }

    public int getForecastQoilData1() {
        return forecastQoilData1;
    }

    public int getForecastQoilData2() {
        return forecastQoilData2;
    }
}
