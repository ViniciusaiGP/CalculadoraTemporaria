package calculadoratemporaria;

import java.util.Calendar;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class CalculadoraTemporaria {

    double _Month2, _Month, _CalcTimeHours, _CalcTimeMin, _CalcTimeSec;
    int _CalcTimeYears, _Day, _Year, _Day2, _Year2;
    String _DayAUX, _MonthAUX, _YearAUX, _DayAUX2, _MonthAUX2, _YearAUX2;

    static CalculadoraTemporaria time = new CalculadoraTemporaria();

    public double CalcTimeDay(String DataCompleta, String DataCompleta2) {
        double total;

        _DayAUX = DataCompleta;
        _DayAUX = _DayAUX.substring(0, 2);
        _Day = Integer.parseInt(_DayAUX);

        _DayAUX2 = DataCompleta2;
        _DayAUX2 = _DayAUX2.substring(0, 2);
        _Day2 = Integer.parseInt(_DayAUX2);

        this._Day = (_Day2 - _Day);

        total = _Day + time.CalcTimeMonth(DataCompleta, DataCompleta2) + time.CalcTimeYear(DataCompleta, DataCompleta2);

        return total;
    }

    public double CalcTimeMonth(String DataCompleta, String DataCompleta2) {
        double AUX = 30.4167;

        _MonthAUX = DataCompleta;
        _MonthAUX = _MonthAUX.substring(3, 5);
        _Month = Integer.parseInt(_MonthAUX);

        _MonthAUX2 = DataCompleta2;
        _MonthAUX2 = _MonthAUX2.substring(3, 5);
        _Month2 = Integer.parseInt(_MonthAUX2);

        this._Month = _Month * AUX;
        this._Month2 = _Month2 * AUX;
        this._Month = _Month2 - _Month;//transformo em dias

        return _Month;
    }

    public double CalcTimeYear(String DataCompleta, String DataCompleta2) {
        double AnoBi, AUX, Year;
        int total;

        _YearAUX = DataCompleta;
        _YearAUX = _YearAUX.substring(6, 10);
        _Year = Integer.parseInt(_YearAUX);

        _YearAUX2 = DataCompleta2;
        _YearAUX2 = _YearAUX2.substring(6, 10);
        _Year2 = Integer.parseInt(_YearAUX2);

        total = (_Year - _Year2);
        AnoBi = total / 4;
        AUX = total - AnoBi;
        Year = (AUX * 365) + (AnoBi * 366);

        return Year;
    }

    public int CalcTimeHours(String DataCompleta, String DataCompleta2) {

        _CalcTimeHours = time.CalcTimeDay(DataCompleta, DataCompleta2) * 24;

        Double num = _CalcTimeHours;
        int Integer = num.intValue();

        return Integer;
    }

    public int CalcTimeMin(String DataCompleta, String DataCompleta2) {

        _CalcTimeMin = _CalcTimeHours * 60;

        Double num2 = _CalcTimeMin;
        int Integer2 = num2.intValue();

        return Integer2;
    }

    public int CalcTimeSec(String DataCompleta, String DataCompleta2) {

        _CalcTimeSec = _CalcTimeMin * 60;

        Double num3 = _CalcTimeSec;
        int Integer3 = num3.intValue();

        return Integer3;
    }

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        String DataCompleta, DataCompleta2;
        Scanner scanner = new Scanner(System.in);

        DataCompleta = JOptionPane.showInputDialog(null, "Informe o ano inicial(ex: ano atual): ");
        DataCompleta2 = JOptionPane.showInputDialog(null, "Informe o ano final: ");

        JOptionPane.showMessageDialog(null, "\nQuantidade de horas: " + time.CalcTimeHours(DataCompleta, DataCompleta2)
                + "\nQuantidade de minutos: " + time.CalcTimeMin(DataCompleta, DataCompleta2)
                + "\nQuantidade de segundos: " + time.CalcTimeSec(DataCompleta, DataCompleta2));
    }
}