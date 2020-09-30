import model.entities.Reservation;
import model.exceptions.DomainExceptions;

import javax.print.attribute.standard.PresentationDirection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            System.out.println("Room number: ");
            int roomNumber = sc.nextInt();

            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date(dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println();

            System.out.println("Enter data to update reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date(dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);

            sc.close();
        } catch(DomainExceptions e){
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (ParseException e){
            System.out.println("You must enter a valid date");
        } catch (RuntimeException e){
            System.out.println("Unexpected error ");

        }
    }
}
