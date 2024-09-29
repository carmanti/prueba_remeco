import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Predictor {

    // Horario
    private static final List<List<Integer>> restriccionesDia = new ArrayList<>();

    static {
        restriccionesDia.add(Arrays.asList(1, 2));
        restriccionesDia.add(Arrays.asList(3, 4));
        restriccionesDia.add(Arrays.asList(5, 6));
        restriccionesDia.add(Arrays.asList(7, 8));
        restriccionesDia.add(Arrays.asList(9, 0));
    }

    public boolean puedeCircular(Vehiculo vehiculo, String fecha, String hora) {
        LocalDate localDate = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int diaSemana = localDate.getDayOfWeek().getValue();

        LocalTime horaActual = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));

        int ultimoDigito = Integer.parseInt((vehiculo.getUltimoDigito()));

        if (diaSemana >= 1 && diaSemana <= 5) {
            List<Integer> restringidos = restriccionesDia.get(diaSemana - 1);

            if (horarioRestringido(horaActual)) {
                if (restringidos.contains(ultimoDigito)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean horarioRestringido(LocalTime horaActual) {

        LocalTime inicioManana = LocalTime.of(7, 0);
        LocalTime finManana = LocalTime.of(9, 30);
        LocalTime inicioTarde = LocalTime.of(16, 0);
        LocalTime finTarde = LocalTime.of(21, 0);

        return (horaActual.isAfter(inicioManana) && horaActual.isBefore(finManana)) ||
                (horaActual.isAfter(inicioTarde) && horaActual.isBefore(finTarde));
    }
}
