import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;

public class DateTimeParserFormatter {

    public static void main(String[] args) {

	String dateStart = "01/15/2012 09:29:58";
	String dateStop = "01/15/2012 10:31:48";

	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	try {
	    Date d1 = format.parse(dateStart);
	    Date d2 = format.parse(dateStop);
	    System.out.println(StringUtils.defaultString(null, "Hello"));

	    // System.out.println(dateToString(new Date(),
	    // "yyyy-MM-dd'T'HH:mm:ssZ"));
	    // System.out.println(convertDate("2017-08-16T11:57:27+0530",
	    // "yyyy-MM-dd'T'HH:mm:ssZ", "ddMMyyyy HHmmss"));
	    System.out.println(timeDiff1(d1, d2));
	    System.out.println(timeDiff2(d1, d2));
	    timeDiffUsingCommons(d1, d2);
	    timeDiffUsingDuration();
	    dateDiffUsingPeriod();
	    datetimeDiffUsingChronoUnit();
	    System.out.println(Duration.ofNanos(System.nanoTime()).getSeconds());
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static String timeDiff1(Date d1, Date d2) {
	Date diff = new Date(d2.getTime() - d1.getTime());

	Calendar calendar = Calendar.getInstance();
	calendar.setTime(diff);
	int hours = calendar.get(Calendar.HOUR_OF_DAY);
	int minutes = calendar.get(Calendar.MINUTE);
	int seconds = calendar.get(Calendar.SECOND);
	return MessageFormat.format("Hours:{0} Minutes:{1} Seconds:{2}", hours, minutes, seconds);
    }

    public static String timeDiff2(Date d1, Date d2) {

	long diff = d2.getTime() - d1.getTime();

	long hours = TimeUnit.MILLISECONDS.toHours(diff);
	long seconds = TimeUnit.MILLISECONDS.toSeconds(diff);
	long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
	long millisec = TimeUnit.MILLISECONDS.toMillis(diff);
	return MessageFormat.format("Hours:{0} Minutes:{1} Seconds:{2} MilliSec:{3}", hours, minutes, seconds, millisec);
    }

    public static void timeDiffUsingCommons(Date d1, Date d2) {
	long diff = d2.getTime() - d1.getTime();
	String hrDateText = DurationFormatUtils.formatDuration(diff, "d 'day(s)' H 'hour(s)' m 'minute(s)' s 'second(s)' ");
	System.out.println("Duration : " + hrDateText);
    }

    public static void timeDiffUsingDuration() {
	//Java 1.8

	LocalDateTime oldDate = LocalDateTime.of(2016, Month.AUGUST, 30, 9, 20, 55);
	LocalDateTime newDate = LocalDateTime.of(2016, Month.AUGUST, 31, 10, 21, 56);

	System.out.println(oldDate);
	System.out.println(newDate);

	//count seconds between dates
	Duration duration = Duration.between(oldDate, newDate);

	System.out.println("\n" + duration.getSeconds() + " seconds");
    }

    public static void dateDiffUsingPeriod() {
	//Java 1.8
	LocalDate oldDate = LocalDate.of(1982, Month.AUGUST, 31);
	LocalDate newDate = LocalDate.of(2016, Month.NOVEMBER, 9);

	System.out.println(oldDate);
	System.out.println(newDate);

	// check period between dates
	Period period = Period.between(oldDate, newDate);

	System.out.print(period.getYears() + " years,");
	System.out.print(period.getMonths() + " months,");
	System.out.print(period.getDays() + " days");
    }

    public static void datetimeDiffUsingChronoUnit() {
	LocalDateTime oldDate = LocalDateTime.of(1982, Month.AUGUST, 31, 10, 20, 55);
	LocalDateTime newDate = LocalDateTime.of(2016, Month.NOVEMBER, 9, 10, 21, 56);

	System.out.println(oldDate);
	System.out.println(newDate);

	// count between dates
	long years = ChronoUnit.YEARS.between(oldDate, newDate);
	long months = ChronoUnit.MONTHS.between(oldDate, newDate);
	long weeks = ChronoUnit.WEEKS.between(oldDate, newDate);
	long days = ChronoUnit.DAYS.between(oldDate, newDate);
	long hours = ChronoUnit.HOURS.between(oldDate, newDate);
	long minutes = ChronoUnit.MINUTES.between(oldDate, newDate);
	long seconds = ChronoUnit.SECONDS.between(oldDate, newDate);
	long milis = ChronoUnit.MILLIS.between(oldDate, newDate);
	long nano = ChronoUnit.NANOS.between(oldDate, newDate);

	System.out.println("\n--- Total --- ");
	System.out.println(years + " years");
	System.out.println(months + " months");
	System.out.println(weeks + " weeks");
	System.out.println(days + " days");
	System.out.println(hours + " hours");
	System.out.println(minutes + " minutes");
	System.out.println(seconds + " seconds");
	System.out.println(milis + " milis");
	System.out.println(nano + " nano");
    }

    /**
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String dateToString(final Date date, String dateFormat) {
	final DateFormat dateformat = new SimpleDateFormat(dateFormat, Locale.getDefault());
	return dateformat.format(date);
    }

    public static List<String> getCompleteMonthsList() {
	final List<String> monthsList = new ArrayList<>();
	final String[] months = new DateFormatSymbols().getShortMonths();
	for (int i = months.length - 2; i >= 0; i--) {
	    monthsList.add(StringUtils.upperCase(months[i]));
	}
	return monthsList;
    }

    /**
     *
     * @param i
     * @return
     */
    public static Date getPrevDate(int i) {
	Date date = new Date();
	Calendar cal = Calendar.getInstance();
	cal.setTime(date); // convert your date to Calendar object
	int daysToDecrement = -i;
	cal.add(Calendar.DATE, daysToDecrement);
	date = cal.getTime();
	return date;
    }

    /**
     *
     * @param date
     * @param fromFormat
     * @param toFormat
     * @return
     */
    public static String convertDate(String date, String fromFormat, String toFormat) {
	String formattedDate = StringUtils.EMPTY;
	try {
	    if (StringUtils.isNotEmpty(date)) {
		SimpleDateFormat sdfFrom = new SimpleDateFormat(fromFormat);
		SimpleDateFormat sdfTo = new SimpleDateFormat(toFormat);
		formattedDate = sdfTo.format(sdfFrom.parse(date));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return formattedDate;
    }

    /**
     *
     * @param dateToParse
     * @param dateFormat
     * @return
     */
    public static Date stringToDate(String dateToParse, String dateFormat) {
	SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
	Date date = new Date();
	try {
	    if (StringUtils.isNotEmpty(dateToParse)) {
		date = formatter.parse(dateToParse);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return date;
    }

    /**
     * Takes input date as dd-MM-yyyy format and returns date in ddMMyyyy
     *
     * @param inputDate
     * @return
     */
    public static String dateTodmyFormat(String inputDate) {
	String formattedDate = "";
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	SimpleDateFormat newFormat = new SimpleDateFormat("ddMMyyyy");
	try {
	    Date date = formatter.parse(inputDate);
	    formattedDate = newFormat.format(date);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return formattedDate;
    }

    /**
     * Takes input date as ddMMyyyy format and returns date in dd-MM-yyyy
     *
     * @param inputDate
     * @return
     */
    public static String formatDate(String inputDate) {
	String formattedDate = "";
	SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
	SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
	try {
	    Date date = formatter.parse(inputDate);
	    formattedDate = newFormat.format(date);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return formattedDate;
    }

    /**
     *
     * @param accountDate
     * @param date2
     * @return
     */
    public static boolean dateCheck(String accountDate, Date date2) {
	boolean flag = false;
	try {
	    SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
	    Date date1 = sdf.parse(accountDate);
	    date2 = sdf.parse(sdf.format(date2));
	    if (date1.after(date2)) {
		flag = true;
	    }
	} catch (ParseException ex) {
	    ex.printStackTrace();
	}
	return flag;
    }

    /**
     *
     * @param fromdate
     * @param toDate
     * @return
     */
    public static boolean compareDate(String fromdate, String toDate) {
	boolean isDateBefore = false;
	try {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    Date date1 = sdf.parse(fromdate);
	    Date date2 = sdf.parse(toDate);

	    if (date1.compareTo(date2) < 0) {
		isDateBefore = true;
	    }
	} catch (ParseException ex) {
	    ex.printStackTrace();
	}
	return isDateBefore;
    }

    /**
     *
     * @param date
     * @return
     */
    public static boolean validateDateFormat(String date) {
	String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
	return date.matches(datePattern);
    }

}
