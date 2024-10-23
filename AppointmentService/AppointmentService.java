import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private Map<String, Appointment> appointments = new HashMap<>();

    public boolean addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID must be unique");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
        return true;
    }

    public boolean deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID not found");
        }
        appointments.remove(appointmentId);
        return true;
    }

    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
