package edu.ufp.inf.lp2.p01_intro;


import java.util.Objects;

public class Date {

    private short day;
    private short month;
    private int year;

    public Date() {
    }

    public static void main() {

    }

    public Date(short day, short month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date date)) return false;
        return day == date.day && month == date.month && year == date.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    public int compareTo(Date d) {

        if (this.year == d.year && this.month == d.month && this.day == d.day) {
            return 0;
        } else if (this.year == d.year) {
            if (this.month == d.month) {
                return (this.day - d.day) / Math.abs(this.day - d.day);
            } else {
                return (this.month - d.month) / Math.abs(this.month - d.month);
            }
        } else {
            return (this.year - d.year) / Math.abs(this.year - d.year);
        }

    }


    public boolean afterDate(Date d) {
        return false;
    }

    public boolean beforeDate(Date d) {
        return false;
    }

    public int diferenceDays(Date d) {
        return 0;
    }

    public int diferenceMonths(Date d) {
        return 0;
    }

    public int diferenceYears(Date d) {
        return 0;
    }

    public void incrementDate0() {
    }

    public long daysCrawlerRecursiveAux(Date begin, Date end) {
        return 0;
    }

    public int daysCrawlerRecursive(Date begin, Date end) {
        return 0;
    }

    public int daysCrawler(Date begin, Date end) {
        return 0;
    }

    public int monthsCrawler(Date begin, Date end) {
        return 0;
    }

    public boolean isLeapYear(int year) {
        return false;
    }

    public int daysMonth(short month, int year) {
        return 0;
    }

    public int daysBetweenMonths(short beginDay, short beginMonth, short endDay, short endMonth, int year) {
        return 0;
    }

    public int monthsBetweenMonths(short beginDay, short beginMonth, short endDay, short endMonth, int year) {
        return 0;
    }

    public void newOperation() {
    }

    public short getDay() {
        return day;
    }

    public void setDay(short day) {
        this.day = day;
    }

    public short getMonth() {
        return month;
    }

    public void setMonth(short month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static void main(String[] args) {

    }
}