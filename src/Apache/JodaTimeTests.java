package Apache;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.print.DocFlavor.URL;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.Hours;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.Months;
import org.joda.time.Period;
import org.joda.time.Years;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class JodaTimeTests {
	public static void main( String[] args ) {
		testIsItToday2();
	}
	
	public static void testIsItToday2(){
		LocalDate today = new LocalDate(new Date());
		LocalDate tomorrow = new LocalDate(new Date()).plusDays(1);
		System.out.println(today.isEqual(tomorrow));
		
		LocalDate today2 = tomorrow.minusDays(1);
		System.out.println(today2.isEqual(today));
	}
	
	public static void testIsItToday () {
		DateTime momentAgo = getRoundedDateTime(new DateTime(new Date()));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DateTime now = getRoundedDateTime(new DateTime(new Date()));
		
		System.out.println(now.isEqual(momentAgo));
	}
	
	private static DateTime getRoundedDateTime (DateTime dateTime) {
		return dateTime.withTime(0,0,0,0);
	}
	
	public static void testAddDay(){
		DateTime today = new DateTime(new Date());
		System.out.println(today);
		DateTime dtYesterday = today.minusDays(1);
		System.out.println(dtYesterday);
	}
	
	public static void testFromFelipe() {
		java.util.Date juDate = new Date();
		DateTime dt = new DateTime( juDate );
		int month = dt.getMonthOfYear();
		System.out.println( month );
		int year = dt.getYear();
		System.out.println( year );
		DateTime year2000 = dt.withYear( 2000 );
		System.out.println( year2000 );
		DateTime twoHoursLater = dt.plusHours( 2 );

		System.out.println( twoHoursLater );
		String monthName = dt.monthOfYear().getAsText();
		String frenchShortName = dt.monthOfYear().getAsShortText( Locale.FRENCH );
		System.out.println( frenchShortName );
		boolean isLeapYear = dt.year().isLeap();
		System.out.println( isLeapYear );
		DateTime rounded = dt.dayOfMonth().roundFloorCopy();
		System.out.println( rounded );

		// teste datetime , localdatetime, localdate e localtime
		System.out.println( "Data completa com timezone: " + dt.toString() );

		LocalDateTime ldt = new LocalDateTime( dt );
		System.out.println( "Data completa sem timezone: " + ldt.toString() );

		LocalDate ld = new LocalDate( dt );
		System.out.println( "Apenas data: " + ld.toString() );

		LocalTime lt = new LocalTime( dt );
		System.out.println( "Apenas horas, minutos, segundos e milissegundos: " + lt.toString() );

		// teste com duration
		DateTime start = new DateTime( 2015, 01, 10, 0, 0, 0, 0 );
		DateTime end = new DateTime( 2015, 01, 15, 0, 0, 0, 0 );
		Duration dur = new Duration( start, end );

		System.out.println( dur.getStandardDays() );

		// formatação
		LocalDate date = LocalDate.now();
		DateTimeFormatter fmt = DateTimeFormat.forPattern( "d MMMM, yyyy" );
		String str = date.toString( fmt );
		System.out.println( str );

		GregorianCalendar l_gc = new GregorianCalendar( 2016, 12, 16 );
		Date l_dt = l_gc.getTime();
		System.out.println( l_dt );
		System.out.println( l_gc.get( Calendar.DAY_OF_WEEK ) );

		System.out.println( " calendario" + Calendar.JANUARY );
		System.out.println( dt );
		DateTime dt2 = dt.plusDays( 1 );
		System.out.println( dt2 );

		// TESTE JODA INICIA OS MESES COM 1 E CALENDAR COM 0
		System.out.println( dt.monthOfYear().get() );

		System.out.println( Calendar.getInstance().get( Calendar.MONTH ) );

		DateTime dataFinal = new DateTime();
		DateTime dataInicio = new DateTime( 2011, 1, 1, 0, 0 );

		System.out.println( "Mês ShortString: " + dataFinal.monthOfYear().getAsShortText() );
		System.out.println( "Mês Italiano: " + dataFinal.monthOfYear().getAsShortText( Locale.ITALIAN ) );
		System.out.println( "Mês String: " + dataFinal.monthOfYear().getAsText() );
		System.out.println( "Semana do Ano: " + dataFinal.getWeekOfWeekyear() );
		System.out.println( "numero do dia da semana " + dataFinal.getDayOfWeek() );
		System.out.println( "Dia da semana String: " + dataFinal.dayOfWeek().getAsText() );
		System.out.println( "Dia da semana Francês: " + dataFinal.dayOfWeek().getAsText( Locale.FRENCH ) );
		System.out.println( "Dia da semana Italiano: " + dataFinal.dayOfWeek().getAsText( Locale.ITALIAN ) );

		System.out.println( "Ano: " + dataFinal.year().get() );
		System.out.println( "Ano no seculo atual:" + dataFinal.yearOfCentury().get() );
		
		LocalDate l1 = new LocalDate(2016,05,30);
		LocalDate l2 = new LocalDate(2016,06,30);

		
		Days d = Days.daysBetween( l1, l2 );
		System.out.println( "Diferença dias:" + d.getDays() );

		DateTime dataInicial = new DateTime( 2011, 1, 1, 0, 0 );
		Years y = Years.yearsBetween( dataInicial, dataFinal );
		System.out.println( "Diferença anos:" + y.getYears() );

		Hours h = Hours.hoursBetween( dataInicial, dataFinal );
		System.out.println( "Diferença horas:" + h.getHours() );

		Months m = Months.monthsBetween( dataInicial, dataFinal );
		System.out.println( "Diferença meses:" + m.getMonths() );

		Interval intervalo = new Interval( dataInicial, dataFinal );
		System.out.println( intervalo );

		// comparação entre duration e period
		System.out.println( "comparação entre duration e period" );
		System.out.println( dataInicial );
		System.out.println( dataFinal );
		Duration duracao = intervalo.toDuration();
		System.out.println( "Duração milisegundos:" + duracao.getMillis() );
		System.out.println( "Duração dias:" + duracao.getStandardDays() );
		System.out.println( "Duração horas:" + duracao.getStandardHours() );
		System.out.println( "Duração segundos:" + duracao.getStandardSeconds() );
		System.out.println( dataInicial );
		System.out.println( dataFinal );

		// Period compara entre cada item da data, como por exemplo: entre mes 3
		// e mes 9, há a diferença de 6 meses
		Period period = intervalo.toPeriod();
		System.out.println( "Anos do periodo:" + period.getYears() );
		System.out.println( "Meses do periodo:" + period.getMonths() );
		System.out.println( "Dias do periodo:" + period.getDays() );
		System.out.println( "Horas do periodo:" + period.getHours() );

		DateTime data = new DateTime();
		DateTime dataMaisDias = data.plusDays( 100 );
		DateTime dataMaisAno = data.plusWeeks( 10 );
		DateTime dataMaisSemanas = data.plusYears( 5 );
		DateTime dataMaisHoras = data.plusHours( 100 );
		DateTime dataMenosDias = data.minusDays( 100 );

		System.out.println( dataMaisDias );
		System.out.println( dataMaisAno );
		System.out.println( dataMaisSemanas );
		System.out.println( dataMaisHoras );
		System.out.println( dataMenosDias );

		DateTimeFormatter dtfPadrao = DateTimeFormat.forPattern( "dd/MM/yyyy" );
		System.out.println( "Data formatada Padrao: " + dataInicial.toString( dtfPadrao ) );
		System.out.println( "Data formatada Padrao: " + dataFinal.toString( dtfPadrao ) );

		DateTimeFormatter dtfExtenso = DateTimeFormat.forPattern( "dd 'de' MMMM 'de' yyyy" );
		System.out.println( "Data formatada Extenso: " + dataInicial.toString( dtfExtenso ) );
		System.out.println( "Data formatada Extenso: " + dataFinal.toString( dtfExtenso ) );

		System.out.println( "Horas que faltam ano novo: " + horasAnoNovo( new DateTime(), 2030 ) );
		System.out.println( "Dias que faltam ano novo: " + diasAnoNovo( new DateTime(), 2030 ) );
		System.out.println( "O seu aniversário cai em uma: " + diaSemanaAniversario( new DateTime( 2030, 3, 7, 0, 0 ) ) );
		System.out.println( "O intervalo tem mais que 30 dias?" + intervaloMaiorTrintaDias( dataInicial, dataFinal ) );

		// Diferença de horas entre fusos horários.

		DateTime agora = new DateTime();
		DateTime saoPaulo = agora.withZoneRetainFields( DateTimeZone.forID( "America/Sao_Paulo" ) );
		DateTime rioBranco = agora.withZoneRetainFields( DateTimeZone.forID( "America/Rio_Branco" ) );
		DateTime japao = agora.withZoneRetainFields( DateTimeZone.forID( "Asia/Tokyo" ) );
		DateTime londres = agora.withZoneRetainFields( DateTimeZone.forID( "Europe/London" ) );
		System.out.println( Hours.hoursBetween( japao, saoPaulo ).getHours() );
		System.out.println( Hours.hoursBetween( londres, saoPaulo ).getHours() );
		System.out.println( Hours.hoursBetween( rioBranco, saoPaulo ).getHours() );

		// biblioteca jollyday
		/*HolidayManager gerenciadorDeFeriados = HolidayManager.getInstance( de.jollyday.HolidayCalendar.BRAZIL );
		Set<Holiday> feriados = gerenciadorDeFeriados.getHolidays( new DateTime().getYear() );
		Set<LocalDate> dataDosFeriados = new HashSet<LocalDate>();
		for ( Holiday holiday : feriados ) {
			dataDosFeriados.add( new LocalDate( holiday.getDate(), ISOChronology.getInstance() ) );
		}*/
		
		
		SimpleDateFormat l_formatDate = new SimpleDateFormat( "MM/dd/yyyy" );
		System.out.println(l_formatDate.format( new Date() ));

	}

	public static int horasAnoNovo( DateTime data, int ano ) {

		DateTime dataFinal =
			
			
			new DateTime
			( ano, 1, 1, 0, 0 );
		return Hours.hoursBetween( data, dataFinal ).getHours();

	}

	public static int diasAnoNovo( DateTime data, int ano ) {
		DateTime dataFinal = new DateTime( ano, 1, 1, 0, 0 );
		return Days.daysBetween( data, dataFinal ).getDays();
	}

	public static String diaSemanaAniversario( DateTime data ) {
		return data.dayOfWeek().getAsText();
	}

	public static boolean intervaloMaiorTrintaDias( DateTime dataInicial, DateTime dataFinal ) {
		Days dias = Days.daysBetween( dataInicial, dataFinal );
		if ( dias.getDays() > 30 ) {
			return true;
		}
		return false;
	}
}
