package mk.icelabs.gwt.polymer.client.ui.util;


import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;

/**
 * Instances of this class are immutable and as such any mutation methods return
 * new DateWrapper instances.
 */
@SuppressWarnings("deprecation")
public class DateWrapper {

  /**
   * Represents the different unit values that the
   * {@link DateWrapper#add(Unit, int)} method takes
   */
  public enum Unit {
    DAY, HOUR, MILLI, MINUTE, MONTH, SECOND, YEAR
  }

  protected static String format(Date date, String format) {
    return DateTimeFormat.getFormat(format).format(date);
  }

  protected static String format(float date, String format) {
    long d = new Float(date).longValue();
    return DateTimeFormat.getFormat(format).format(new Date(d));
  }

  private Date date;

  /**
   * Creates a new instance with the current time.
   */
  public DateWrapper() {
    this(System.currentTimeMillis());
  }

  /**
   * Creates a new instance with the given date.
   * 
   * @param date the date
   */
  public DateWrapper(Date date) {
    this.date = date;
  }

  /**
   * Creates a new instance with the given values.
   * 
   * @param year the year
   * @param month the month
   * @param day the day
   */
  public DateWrapper(int year, int month, int day) {
    this(new Date(year - 1900, month, day));
  }

  /**
   * Creates a new instance with the given time in milliseconds.
   * 
   * @param time the time in milliseconds
   */
  public DateWrapper(long time) {
    this(new Date(time));
  }

  /**
   * Provides a convenient method of performing basic date arithmetic. This
   * method does not modify the DateWrapper instance being called - it creates
   * and returns a new DateWrapper instance containing the resulting date value.
   * 
   * @see #addMillis(int)
   * @see #addSeconds(int)
   * @see #addMinutes(int)
   * @see #addHours(int)
   * @see #addDays(int)
   * @see #addMonths(int)
   * @see #addYears(int)
   * 
   * @param unit the {@link Unit}
   * @param quantity the quantity to add
   * 
   * @return the new DateWrapper
   */
  public DateWrapper add(Unit unit, int quantity) {
    Date d = null;
    switch (unit) {
      case MILLI:
        return new DateWrapper(date.getTime() + quantity);
      case SECOND:
        d = (Date) date.clone();
        d.setSeconds(d.getSeconds() + quantity);
        return new DateWrapper(d);
      case MINUTE:
        d = (Date) date.clone();
        d.setMinutes(d.getMinutes() + quantity);
        return new DateWrapper(d);
      case HOUR:
        d = (Date) date.clone();
        d.setHours(d.getHours() + quantity);
        return new DateWrapper(d);
      case DAY:
        d = (Date) date.clone();
        d.setHours(d.getHours() + (quantity * 24));
        return new DateWrapper(d);
      case MONTH:
        d = (Date) date.clone();
        int day = getDate();
        if (day > 28) {
          day = Math.min(day, getFirstDayOfMonth().addMonths(quantity).getLastDateOfMonth().getDate());
        }
        d.setDate(day);
        d.setMonth(getMonth() + quantity);
        return new DateWrapper(d);
      case YEAR:
        d = (Date) date.clone();
        d.setYear(d.getYear() + quantity);
        return new DateWrapper(d);
    }
    return null;
  }

  /**
   * Returns a new DateWrapper with days added
   * 
   * @see #add(DateWrapper.Unit, int)
   * @return a new DateWrapper with days added
   */
  public DateWrapper addDays(int days) {
    return add(Unit.DAY, days);
  }

  /**
   * Returns a new DateWrapper with hours added
   * 
   * @see #add(DateWrapper.Unit, int)
   * @return a new DateWrapper with hours added
   */
  public DateWrapper addHours(int hours) {
    return add(Unit.HOUR, hours);
  }

  /**
   * Returns a new DateWrapper with millis added
   * 
   * @see #add(DateWrapper.Unit, int)
   * @return a new DateWrapper with millis added
   */
  public DateWrapper addMillis(int millis) {
    return add(Unit.MILLI, millis);
  }

  /**
   * Returns a new DateWrapper with minutes added
   * 
   * @see #add(DateWrapper.Unit, int)
   * @return a new DateWrapper with minutes added
   */
  public DateWrapper addMinutes(int minutes) {
    return add(Unit.MINUTE, minutes);
  }

  /**
   * Returns a new DateWrapper with months added
   * 
   * @see #add(DateWrapper.Unit, int)
   * @return a new DateWrapper with months added
   */
  public DateWrapper addMonths(int months) {
    return add(Unit.MONTH, months);
  }

  /**
   * Returns a new DateWrapper with seconds added
   * 
   * @see #add(DateWrapper.Unit, int)
   * @return a new DateWrapper with seconds added
   */
  public DateWrapper addSeconds(int seconds) {
    return add(Unit.SECOND, seconds);
  }

  /**
   * Returns a new DateWrapper with years added
   * 
   * @see #add(DateWrapper.Unit, int)
   * @return a new DateWrapper with years added
   */
  public DateWrapper addYears(int years) {
    return add(Unit.YEAR, years);
  }

  /**
   * Returns a new Date instance
   * 
   * @return a new Date instance
   */
  public Date asDate() {
    return new Date(getTime());
  }

  public boolean before(DateWrapper dateWrapper) {
    return dateWrapper == null || getTime() < dateWrapper.getTime();
  }

  /**
   * Returns a new instance with the time portion
   * (hours/minutes/seconds/milliseconds) cleared.
   * 
   * @return a new instance with the time portion
   *         (hours/minutes/seconds/milliseconds) cleared.
   */
  public DateWrapper clearTime() {
    return new DateWrapper(getFullYear(), getMonth(), getDate());
  }

  public DateWrapper clone() {
    return new DateWrapper(getTime());
  }

  /**
   * Returns the day of the month
   * 
   * @return the day of the month
   */
  public int getDate() {

    return date.getDate();
  }

  /**
   * Returns the day of the week
   * 
   * @return the day of the week
   */
  public int getDay() {
    return date.getDay();
  }

  /**
   * Returns the day of the week
   * 
   * @return the day of the week
   */
  public int getDayInWeek() {
    return date.getDay();
  }

  /**
   * Returns the day of the year
   * 
   * @return the day of the year
   */
  public int getDayOfYear() {
    int num = 0;
    for (int i = 0; i < getMonth(); i++) {
      num += new DateWrapper(1, i, 1).getDaysInMonth();
    }
    return getDate() + num;
  }

  /**
   * Returns the number of days in the month.
   * 
   * @return the number of days in the month.
   */
  public int getDaysInMonth() {
    switch (getMonth()) {
      case 1:
        return (((getFullYear() % 4) == 0 && (getFullYear() % 100) != 0) || (getFullYear() % 400) == 0) ? 29 : 28;

      case 3:
      case 5:
      case 8:
      case 10:
        return 30;

      default:
        return 31;
    }
  }

  /**
   * Returns the first date of the month.
   * 
   * @return the first date of the month.
   */
  public DateWrapper getFirstDayOfMonth() {
    return new DateWrapper(getFullYear(), getMonth(), 1);
  }

  /**
   * Returns the full year
   * 
   * @return the full year
   */
  public int getFullYear() {
    return date.getYear() + 1900;
  }

  /**
   * Returns the hour
   * 
   * @return the hour
   */
  public int getHours() {
    return date.getHours();
  }

  /**
   * Returns the last date of the month.
   * 
   * @return the last date of the month.
   */
  public DateWrapper getLastDateOfMonth() {
    return new DateWrapper(getFullYear(), getMonth(), getDaysInMonth());
  }

  /**
   * Returns the milliseconds
   * 
   * @return the milliseconds
   */
  public long getMilliseconds() {
    return date.getTime() - clearTime().getTime();
  }

  /**
   * Returns the minutes
   * 
   * @return the minutes
   */
  public int getMinutes() {
    return date.getMinutes();
  }

  /**
   * Returns the month
   * 
   * @return the month
   */
  public int getMonth() {
    return date.getMonth();
  }

  /**
   * Returns the seconds
   * 
   * @return the seconds
   */
  public int getSeconds() {
    return date.getSeconds();
  }

  /**
   * Returns the time in milliseconds.
   * 
   * @return the time in milliseconds
   */
  public long getTime() {
    return date.getTime();
  }

  /**
   * Returns a new instance with the time portion
   * (hours/minutes/seconds/milliseconds) reseted to 12am. This keeps the date
   * the same also during daylight saving times.
   * 
   * @return a new instance with the time portion reseted to 12am
   */
  public DateWrapper resetTime() {
    Date date = asDate();
    // remove millis
    long msec = date.getTime();
    msec = (msec / 1000) * 1000;
    date.setTime(msec);

    // reset time to 12am
    date.setHours(12);
    date.setMinutes(0);
    date.setSeconds(0);
    return new DateWrapper(date);
  }

  @Override
  public String toString() {
    return asDate().toString();
  }

}
