package model.entities;

import model.exceptions.DomainExceptions;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;


    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(){

    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainExceptions{
        if (!checkOut.after(checkIn)) {
            throw new DomainExceptions("Check-Out date must be after Check-In date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration(){
        //Diferenca entre datas:
        //Comeca calculando a diferenca entre as datas em milisegundos
        long diff = checkOut.getTime() - checkIn.getTime();
        //Pra converter de milisegundos para dia
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates (Date checkIn, Date checkOut) throws DomainExceptions{

        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)){
           throw new DomainExceptions("Must be in the future");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainExceptions("Check-Out date must be after Check-In date");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {

        return  " Reservation: " +
                " Room: " + roomNumber +
                "\n Check-In Date: " + sdf.format(checkIn) +
                "\n Check-Out Date: " + sdf.format(checkOut) +
                "\n Duration: " + duration() + " nights";
    }
}
